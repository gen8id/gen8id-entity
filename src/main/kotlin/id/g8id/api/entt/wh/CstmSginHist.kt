package id.g8id.api.entt.wh

import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import io.quarkus.panache.common.Parameters
import java.time.LocalDateTime
import java.time.ZoneOffset

/**
 * customer user sign in history,
 * even though password not match,
 * just id match, log here
 */
class CstmSginHist(
  var userId: String,
  var stts: String?,
  var userAgnt: String?,
  var userIp: String?,
  var host: String?,
  var lang: String?,
  var ctnt: String?,
  var ctry: String?,
  var regn: String?,
  var city: String?,
  var pfrm: String?
) : PanacheMongoEntity() {

  var rgstDttm: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)

  companion object : PanacheMongoCompanion<CstmSginHist> {
    fun countBeforeThreeMonths(): Int {
      val threeMonthsAgo = LocalDateTime.now(ZoneOffset.UTC).minusMonths(3)
      return count("rgstDttm < :rgstDttm", Parameters.with("rgstDttm", threeMonthsAgo)).toInt()
    }

    fun deleteBeforeThreeMonths(): Int {
      val threeMonthsAgo = LocalDateTime.now(ZoneOffset.UTC).minusMonths(3)
      return delete("rgstDttm < :rgstDttm", Parameters.with("rgstDttm", threeMonthsAgo)).toInt()
    }
  }

}