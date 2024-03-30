package id.g8id.api.entt.wh

import id.g8id.api.data.StrpReversals
import id.g8id.api.util.GsonExt
import com.stripe.model.Transfer
import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import java.time.LocalDateTime
import java.time.ZoneOffset

class PaotHistStrp : PanacheMongoEntity {
  constructor() : super() {}

  constructor(
    param: Transfer
    , userId: String
  ) : super() {
    this.rgstUserId = userId
    this.updtUserId = userId

    this.amount = param.amount
    this.amountReversed = param.amountReversed
    this.balanceTransaction = param.balanceTransaction
    this.created = param.created
    this.currency = param.currency
    this.description = param.description
    this.destination = param.destination
    this.destinationPayment = param.destinationPayment
    this.txId = param.id
    this.livemode = param.livemode
    this.metadata = param.metadata
    this.`object` = param.`object`
    this.reversals = GsonExt.getGson().fromJson(GsonExt.getGson().toJson(param.reversals), StrpReversals::class.java)
    this.reversed = param.reversed
    this.sourceTransaction = param.sourceTransaction
    this.sourceType = param.sourceType
    this.transferGroup = param.transferGroup
  }


  var amount: Long? = null
  var amountReversed: Long? = null
  var balanceTransaction: String? = null
  var created: Long? = null
  var currency: String? = null
  var description: String? = null
  var destination: String? = null
  var destinationPayment: String? = null
  // ID of return value
  var txId: String? = null
  var livemode: Boolean? = false // If production => true, when development false
  var metadata: Map<String, String>? = null
  var `object`: String? = null
  var reversals: StrpReversals? = null
  var reversed: Boolean? = null
  var sourceTransaction: String? = null
  var sourceType: String? = null
  var transferGroup: String? = null

  var rgstUserId: String? = null
  var updtUserId: String? = null
  var rgstDttm: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)
  var updtDttm: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)

  fun putReversedData(transfer: Transfer) {
    this.amountReversed = transfer.amountReversed
    this.reversals = GsonExt.getGson().fromJson(GsonExt.getGson().toJson(transfer.reversals), StrpReversals::class.java)
    this.reversed = transfer.reversed
  }


  companion object: PanacheMongoCompanion<PaotHistStrp> {


  }

}
