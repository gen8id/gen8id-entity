package id.g8id.api.entt

import com.paypal.payouts.CreatePayoutResponse
import com.paypal.payouts.PayoutBatch
import id.g8id.api.antn.NoArg
import id.g8id.api.util.GsonExt
import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import java.time.LocalDateTime
import java.time.ZoneOffset

class PaotHistPapl : PanacheMongoEntity {

  constructor() : super() {}

  constructor(
    param: CreatePayoutResponse,
    userId: String,
    batch: PayoutBatch,
  ) : super() {
    this.payoutBatchId = param.batchHeader().payoutBatchId()
    this.batchStatus = param.batchHeader().batchStatus()
    this.timeCreated = param.batchHeader().timeCreated()
    this.currency = batch.items()[0].payoutItem().amount().currency()
    this.amount = batch.items()[0].payoutItem().amount().value()
    this.receiver = batch.items()[0].payoutItem().receiver()
    this.recipientType = batch.items()[0].payoutItem().recipientType()
    this.senderBatchHeader = GsonExt.getGson().fromJson(
      GsonExt.getGson().toJson(param.batchHeader().senderBatchHeader()),
      PaplPaotSenderBatchHeader::class.java
    )

    this.rgstUserId = userId
    this.updtUserId = userId
  }

  var payoutBatchId: String? = null
  var batchStatus: String? = null
  var senderBatchHeader: PaplPaotSenderBatchHeader? = null
  var timeCreated: String? = null
  var currency: String? = null
  var amount: String? = null
  var receiver: String? = null
  var recipientType: String? = null

  var rgstUserId: String? = null
  var updtUserId: String? = null
  var rgstDttm: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)
  var updtDttm: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)

  companion object: PanacheMongoCompanion<PaotHistPapl> {
    fun findAllByUserId(userId: String): List<PaotHistPapl> {
      return find("rgstUserId", userId).list()
    }
  }

}

@NoArg
data class PaplPaotSenderBatchHeader(
  val emailMessage: String?,
  val emailSubject: String?,
  val recipientType: String?,
  val senderBatchId: String?,
)