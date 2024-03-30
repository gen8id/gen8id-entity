package id.g8id.api.entt.wh

import id.g8id.api.cnst.BotUser
import id.g8id.api.data.PadlRfndWbhkData
import id.g8id.api.data.RfndItem
import id.g8id.api.data.Totals
import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import java.time.LocalDateTime
import java.time.ZoneOffset

class RfndHist : PanacheMongoEntity {
  constructor()

  constructor(param: PadlRfndWbhkData) {
    this.eventId = param.eventId
    this.eventType = param.eventType
    this.occurredAt = param.occurredAt
    this.notificationId = param.notificationId

    this.adjId = param.data.id
    this.items = param.data.items
    this.action = param.data.action
    this.reason = param.data.reason
    this.status = param.data.status
    this.totals = param.data.totals
    this.customerId = param.data.customerId
    this.currencyCode = param.data.currencyCode
    this.payoutTotals = param.data.payoutTotals
    this.transactionId = param.data.transactionId
    this.subscriptionId = param.data.subscriptionId
    this.creditAppliedToBalance = param.data.creditAppliedToBalance

    this.rgstUserId = BotUser.PDDL_WBHK_USER
    this.updtUserId = BotUser.PDDL_WBHK_USER
  }

  var eventId: String? = null
  var eventType: String? = null
  var occurredAt: String? = null
  var notificationId: String? = null

  var adjId: String? = null
  var items: List<RfndItem>? = null
  var action: String? = null
  var reason: String? = null
  var status: String? = null
  var totals: Totals? = null
  var customerId: String? = null
  var currencyCode: String? = null
  var payoutTotals: Totals? = null
  var transactionId: String? = null
  var subscriptionId: String? = null
  var creditAppliedToBalance: String? = null

  var rgstUserId: String? = BotUser.PDDL_WBHK_USER
  var rgstDttm: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)
  var updtUserId: String? = BotUser.PDDL_WBHK_USER
  var updtDttm: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)

  companion object: PanacheMongoCompanion<RfndHist> {

  }

}
