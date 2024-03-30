package id.g8id.api.enttcomp.bo

import id.g8id.api.rqst.BofcUserSearchRqst
import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import io.quarkus.panache.common.Sort
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
    , pvdr: String?
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
    this.pvdr = pvdr
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
  var pvdr: String? = null

  companion object: PanacheMongoCompanion<BofcSginHist> {
    fun getSginHist(param: BofcUserSearchRqst): List<BofcSginHist> {
      val (query, params) = buildQueryAndParams(param)
      return find(query, Sort.by("rgstDttm").descending(), params).page(param.page - 1, 20).list()
    }

    fun countSginHist(param: BofcUserSearchRqst): Long {
      val (query, params) = buildQueryAndParams(param)
      return count(query, params)
    }

    private fun buildQueryAndParams(param: BofcUserSearchRqst): Pair<String, MutableMap<String, Any?>> {
      val params = param.toRqstMap()
      var queryParts: MutableList<String> = ArrayList()
      if(params["dispName"] != null) queryParts.add("dispName like :dispName")
      if(params["stts"] !=null) queryParts.add("stts = :stts")
      if(params["role"] !=null) queryParts.add("role = :role")
      if(params["page"] !=null) queryParts.add("page = :page")
      val query = if (queryParts.size != 0) queryParts.joinToString(" and ") else "{}"
      return Pair(query, params)
    }
  }

}