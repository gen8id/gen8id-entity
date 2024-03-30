package id.g8id.api.enttcomp.fo

import id.g8id.api.data.*
import id.g8id.api.rqst.*
import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import java.time.LocalDateTime
import java.time.ZoneOffset

class PaidHistAciv : PanacheMongoEntity() {

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

  companion object: PanacheMongoCompanion<PaidHistAciv> {

  }

}
