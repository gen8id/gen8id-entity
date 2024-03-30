package ai.bitflow.api.comn.entt

import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import java.time.LocalDateTime
import java.time.ZoneOffset

class PaotHistPapl() : PanacheMongoEntity() {

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

  companion object: PanacheMongoCompanion<PaotHistPapl>

}

data class PaplPaotSenderBatchHeader(
    var emailMessage: String? = null,
    var emailSubject: String? = null,
    var recipientType: String? = null,
    var senderBatchId: String? = null,
)