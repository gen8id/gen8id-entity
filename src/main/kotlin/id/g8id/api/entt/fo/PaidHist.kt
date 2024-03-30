package id.g8id.api.entt.fo

import id.g8id.api.cnst.BotUser
import id.g8id.api.cnst.PadlWbhkEvnt
import id.g8id.api.cnst.Purchase
import id.g8id.api.data.PadlChckOut
import id.g8id.api.data.PadlPamts
import id.g8id.api.data.PadlTrnxDetl
import id.g8id.api.cnst.ContentType
import id.g8id.api.data.PadlTrnxWbhkData
import id.g8id.api.rqst.*
import id.g8id.api.rqst.PadlCstm
import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.temporal.ChronoUnit

class PaidHist : PanacheMongoEntity {

  constructor() : super() {}

  constructor(
    param: PcseCpltRqst
    , payerId: String
    , sessionId: String
  ) : super() {
    this.transactionId = param.transactionId
    this.status = param.status
    this.checkOutid = param.checkOutId
    this.customData = param.customData
    this.crtrId = param.customData?.crtrId
    this.grupId = param.customData?.grupId
    this.currencyCode = param.currencyCode
    this.customer = param.customer
    this.customerId = param.customer.id
    this.businessId = param.customer.business?.id
    this.addressId = param.customer.address?.id
    this.items = param.items
    this.totals = param.totals
    this.discount = param.discount
    this.recurringTotals = param.recurringTotals

    this.userId = payerId
    this.rgstUserId = sessionId
    this.updtUserId = sessionId
  }

  constructor(
    param: PadlTrnxWbhkData
  ) : super() {
    this.transactionId = param.data.id
    this.status = param.data.status
    this.customData = param.data.customData
    this.origin = param.data.origin
    this.invoiceId = param.data.invoiceId
    this.invoiceNumber = param.data.invoiceNumber
    this.subscriptionId = param.data.subscriptionId
    this.details = param.data.details
    this.payments = param.data.payments
    this.checkout = param.data.checkout


    this.customerId = param.data.customerId
    this.businessId = param.data.businessId
    this.addressId = param.data.addressId
    this.currencyCode = param.data.currencyCode

    val payoutTotals = param.data.details?.payoutTotals
    if (payoutTotals!=null) {
      this.totals = PadlTotlItem(
        payoutTotals.subtotal!!
        , payoutTotals.tax!!
        , payoutTotals.total!!
        , payoutTotals.discount!!
        , payoutTotals.balance!!
        , payoutTotals.credit!!)
    }

    this.eventId = param.eventId
    this.eventType = param.eventType
    this.occurredAt = param.occurredAt
    this.notificationId = param.notificationId

    this.discountId = param.data.discountId

    this.rgstUserId = BotUser.PDDL_WBHK_USER
    this.updtUserId = BotUser.PDDL_WBHK_USER
  }

  fun putWebhookData(
    param: PadlTrnxWbhkData
  ) {
    this.transactionId = param.data.id
    this.status = param.data.status
    this.origin = param.data.origin
    this.customData = param.data.customData
    this.invoiceId = param.data.invoiceId
    this.invoiceNumber = param.data.invoiceNumber
    this.subscriptionId = param.data.subscriptionId
    this.details = param.data.details
    this.payments = param.data.payments
    this.checkout = param.data.checkout

    this.eventId = param.eventId
    this.eventType = param.eventType
    this.occurredAt = param.occurredAt
    this.notificationId = param.notificationId

    this.discountId = param.data.discountId

    this.updtUserId = BotUser.PDDL_WBHK_USER
    this.updtDttm = LocalDateTime.now(ZoneOffset.UTC)
  }

  // 1) Checkout data
  var transactionId: String? = null
  var status: String? = null
  var userId: String? = null
  var customerId: String? = null
  var businessId: String? = null
  var addressId: String? = null
  var rgstUserId: String? = null
  var rgstDttm: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)
  var updtUserId: String? = null
  var updtDttm: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)
  var checkOutid: String? = null
  var customData: PaidCstmData? = null
  var currencyCode: String? = null
  var customer: PadlCstm? = null
  var items: List<PadlPricItem>? = null
  var totals: PadlTotlItem? = null
  var discount: PadlDsct? = null
  var recurringTotals: PadlRcurTotl? = null
  var crtrId: String? = null
  var grupId: String? = null
  var dnldDttm: LocalDateTime? = null

  // 2) Webhook data
  var origin: String? = null
  var invoiceId: String? = null
  var invoiceNumber: String? = null
  var subscriptionId: String? = null
  var payments: List<PadlPamts>? = null

  var eventId: String? = null
  var eventType: String? = null
  var occurredAt: String? = null
  var notificationId: String? = null

  var details: PadlTrnxDetl? = null
  var checkout: PadlChckOut? = null
  var discountId: String? = null

  var ctntType: String = ContentType.IMAGE
  var crtrGrad: String? = null
  var feeRate: Int = 33

  fun getConfirmationStatus(): String {
    if (this.eventType == PadlWbhkEvnt.ADJUSTMENT_CREATED || this.eventType == PadlWbhkEvnt.ADJUSTMENT_UPDATED) {
      return "Refunded"
    }
    val now = LocalDateTime.now(ZoneOffset.UTC)
    val daysSincePurchase = ChronoUnit.DAYS.between(this.rgstDttm, now)
    if (daysSincePurchase > 7) {
      return Purchase.CONFIRMED
    }
    return Purchase.NOT_CONFIRMED
  }

  fun download() {
    if (this.dnldDttm == null) {
      this.dnldDttm = LocalDateTime.now(ZoneOffset.UTC)
      this.update()
    }
  }

  fun hasPmpt(): Boolean {
    return this.details?.lineItems?.find {
      it.product?.customData?.get("type") == "pmpt"
    } != null
  }

  companion object: PanacheMongoCompanion<PaidHist> {

    fun findAllByUserId(userId: String): List<PaidHist> {
      return find("userId", userId).list()
    }

    fun findConfirmedItem(crtrId: String): List<PaidHist> {
      val sevenDaysAgo = LocalDateTime.now().minusDays(7)
      return find("crtrId = ?1 and eventType = ?2 and rgstDttm < ?3",
        crtrId, PadlWbhkEvnt.TRANSACTION_COMPLETED, sevenDaysAgo).list()
    }

  }

}
