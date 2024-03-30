package id.g8id.api.enttcomp.bo

import id.g8id.api.data.RqstImgPmpt
import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import java.text.DecimalFormat
import java.time.LocalDateTime
import java.time.ZoneOffset

class RqstImgGrup : PanacheMongoEntity {

  constructor(
  ): super() { }

  constructor (
    grupId: String,
    ctntType: String,
    ctntAgeGrad: String,
    rgstStep: String,
    aiSgstKywdList: List<String>,
    modrList: List<String>,
    qltyFcusAvrg: Double,
    adjtReslAvrg: Long,
    ttpxAvrg: Long,
    bytsAvrg: Long,
    ctntCnt: Int
  ): super() {
    this.grupId = grupId
    this.ctntType = ctntType
    this.ctntAgeGrad = ctntAgeGrad
    this.rgstStep = rgstStep
    this.aiSgstKywdList = aiSgstKywdList
    this.modrList = modrList
    this.qltyFcusAvrg = DecimalFormat("#.##").format(qltyFcusAvrg).toDouble()
    this.adjtReslAvrg = adjtReslAvrg
    this.ttpxAvrg = ttpxAvrg
    this.bytsAvrg = bytsAvrg
    this.ctntCnt = ctntCnt
  }

  lateinit var grupId: String
  var ctntType: String? = null
  var ctntAgeGrad: String? = null
  var rgstStep: String? = null
  var modrList: List<String> = mutableListOf()
  var aiSgstKywdList: List<String> = mutableListOf()
  var userRemvKywdList: List<String>? = null
  var userAdddKywdList: List<String>? = null
  var finlKywdList: List<String>? = null
  var qltyFcusAvrg: Double? = null
  var adjtReslAvrg: Long? = null
  var ttpxAvrg: Long? = null
  var bytsAvrg: Long? = null
  var ctntCnt: Int? = null

  var celbList: List<String>? = null
  var pmptImgList: MutableList<RqstImgPmpt>? = null
  var prvdCd: String? = null
  var titl: String? = null
  var pstvPmpt: String? = null
  var pmptLeng: Int? = null
  var pmptHash: String? = null
  var modlCd: String? = null
  var modlNm: String? = null

  var userDefnGradList: List<String>? = null
  var climCdList: List<String>? = null
  var crtrId: String? = null
  var crtrMesg: String? = null
  var baseGradImg: Map<String, Any>? = null
  var baseGradPmpt: Map<String, Any>? = null
  var pricIdImg: String? = null
  var pricIdPmpt: String? = null
  var ngtvPmpt: String? = null
  var bofcRgst: Boolean = true

  var upscCd: String? = null
  var upscNm: String? = null

  var rgstUserId: String? = null
  var updtUserId: String? = null
  var aprvUserId: String? = null
  var rgstDttm: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)
  var updtDttm: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)
  var aprvDttm: LocalDateTime? = null

  var aprvBySelf: Boolean? = null

  companion object: PanacheMongoCompanion<RqstImgGrup> {


  }
}