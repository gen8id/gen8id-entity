package id.g8id.api.entt.fo

import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import io.quarkus.panache.common.Parameters
import java.time.LocalDateTime

class RfshTokn : PanacheMongoEntity {

  constructor() : super()

  constructor(
    vlue: String,
    userId: String,
    exprDttm: LocalDateTime
  ) {
    this.vlue = vlue
    this.userId = userId
    this.exprDttm = exprDttm
  }

  var vlue: String? = null
  var userIP: String? = null
  var fngrPrnt: String? = null
  var userId: String? = null
  var exprDttm: LocalDateTime? = null // expiration date
  var crtdByIp: String? = null    // Ip, from which token was issued
  var crtdDttm: LocalDateTime? = null
  var prvsVlue: String? = null
  var rvkdByIp: String? = null // Ip, from which token was revoked
  var rvkdDttm: LocalDateTime? = null

  companion object : PanacheMongoCompanion<RfshTokn> {

//        init {
//            RfshTokn.mongoCollection()
//                .createIndex(Indexes.ascending("exprDttm"), IndexOptions().expireAfter(0L, TimeUnit.MILLISECONDS))
//            System.out.println("test")
//        }

    fun findByUserId(userId: String): List<RfshTokn> {
      return find("userId = :userId", Parameters.with("userId", userId)).list()
    }

    fun findByUserIdAndVlue(userId: String, vlue: String): RfshTokn? {
      return find(
        "userId = :userId and vlue = :vlue",
        Parameters.with("userId", userId).and("vlue", vlue)
      ).firstResult()
    }

    fun findByUserIdAndPrvsVlue(userId: String, vlue: String): RfshTokn? {
      return find(
        "userId = :userId and prvsVlue = :prvsVlue",
        Parameters.with("userId", userId).and("prvsVlue", vlue)
      ).firstResult()
    }

    fun removeAllByUserId(userId: String) {
      delete("userId = :userId", Parameters.with("userId", userId))
    }

    fun removeAllByUserIdAndFingerprint(userId: String, fingerprint: String) {
      delete(
        "userId = :userId and fngrPrnt = :fngrPrnt",
        Parameters.with("userId", userId).and("fngrPrnt", fingerprint)
      )
    }

    fun findByVlue(vlue: String): RfshTokn? {
      return find("vlue = :vlue", Parameters.with("vlue", vlue)).firstResult()
    }
  }
}