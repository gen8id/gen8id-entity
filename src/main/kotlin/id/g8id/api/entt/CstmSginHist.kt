package id.g8id.api.entt

import id.g8id.api.antn.NoArg
import id.g8id.api.rqst.CstmUserEmalSginRqst
import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import java.time.LocalDateTime
import java.time.ZoneOffset

/**
 * customer user sign in history,
 * even though password not match,
 * just id match, log here
 */
@NoArg
class CstmSginHist(param: CstmUserEmalSginRqst) : PanacheMongoEntity() {
  var userId: String
  var pvdr: String?
  var userAgnt: String? = null
  var ctnt: String? = null
  var ctry: String? = null
  var regn: String? = null
  var city: String? = null
  var plfm: String? = null
  var lang: String? = null
  var host: String? = null
  var connIp: String? = null
  var tmzn: String? = null
  var refr: String? = null
  var xRealIp: String? = null
  var userStts: String? = null
  var rgstDttm: LocalDateTime? = null

  companion object: PanacheMongoCompanion<CstmSginHist> {

  }

  init {
    this.userId   = param.userId
    this.pvdr     = param.pvdr
    this.userAgnt = param.userAgnt
    this.ctnt     = param.ctnt
    this.ctry     = param.ctry
    this.regn     = param.regn
    this.city     = param.city
    this.plfm     = param.plfm
    this.lang     = param.lang
    this.host     = param.host
    this.connIp   = param.connIp
    this.tmzn     = param.tmzn
    this.refr     = param.refr
    this.xRealIp  = param.xRealIp
    this.rgstDttm = LocalDateTime.now(ZoneOffset.UTC)
  }


}