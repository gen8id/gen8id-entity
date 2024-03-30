package id.g8id.api.entt.wh

import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import io.quarkus.panache.common.Parameters
import java.time.LocalDateTime
import java.time.ZoneOffset

/**
 * backoffice user sign in history,
 * even though password not match,
 * just id match, log here
 */
class BofcSginHist : PanacheMongoEntity {

  constructor() : super()

  constructor(
    userId: String
    , stts: String?
    , userAgent: String
    , ip: String
    , host: String?
    , lang: String?
    , ctnt: String?
    , ctry: String?
    , regn: String?
    , city: String?
    , pfrm: String?
  ) : super() {
    this.userId = userId
    this.stts = stts
    this.userAgnt = userAgent
    this.ip = ip
    this.lang = lang
    this.ctnt = ctnt
    this.ctry = ctry
    this.regn = regn
    this.city = city
    this.pfrm = pfrm
    this.host = host
  }

  lateinit var userId: String
  var rgstDttm: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)

  var userAgnt: String? = null
  var ip: String? = null
  var stts: String? = null
  var lang: String? = null
  var ctnt: String? = null
  var regn: String? = null
  var ctry: String? = null
  var city: String? = null
  var pfrm: String? = null
  var host: String? = null


  companion object : PanacheMongoCompanion<BofcSginHist> {
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