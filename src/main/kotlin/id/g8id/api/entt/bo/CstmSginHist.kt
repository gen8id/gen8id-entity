package id.g8id.api.entt.bo

import id.g8id.api.rqst.CstmUserSrchRqst
import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import io.quarkus.panache.common.Sort
import java.time.LocalDateTime
import java.time.ZoneOffset


/**
 * customer user sign in history,
 * even though password not match,
 * just id match, log here
 */
class CstmSginHist : PanacheMongoEntity {

  constructor() : super()

  constructor(
    userId: String
    , stts: String?
    , userAgnt: String
    , connIp: String?
    , lang: String?
    , ctnt: String?
    , ctry: String?
    , regn: String?
    , city: String?
    , prfm: String?
    , pvdr: String?
  ) : super() {
    this.userId = userId
    this.stts = stts
    this.userAgnt = userAgnt
    this.connIp = connIp
    this.lang = lang
    this.ctnt = ctnt
    this.ctry = ctry
    this.regn = regn
    this.city = city
    this.prfm = prfm
    this.pvdr = pvdr
  }

  lateinit var userId: String
  var stts: String? = null
  lateinit var userAgnt: String
  var connIp: String? = null
  var rgstDttm: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)
  var lang: String? = null
  var ctry: String? = null
  var ctnt: String? = null
  var regn: String? = null
  var city: String? = null
  var prfm: String? = null
  var pvdr: String? = null

  companion object: PanacheMongoCompanion<CstmSginHist> {
    fun getSginHist(param: CstmUserSrchRqst): List<CstmSginHist> {
      val (query, params) = buildQueryAndParams(param)
      return find(query, Sort.by("rgstDttm").descending(), params).page(param.page - 1, 20).list()
    }

    fun countSginHist(param: CstmUserSrchRqst): Long {
      val (query, params) = buildQueryAndParams(param)
      return count(query, params)
    }

    private fun buildQueryAndParams(param: CstmUserSrchRqst): Pair<String, MutableMap<String, Any?>> {
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