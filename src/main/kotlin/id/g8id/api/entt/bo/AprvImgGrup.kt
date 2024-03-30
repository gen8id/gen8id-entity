package src.main.kotlin.id.g8id.api.entt.bo

import id.g8id.api.data.ImgSorcItem
import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import java.time.LocalDateTime
import java.time.ZoneOffset

class AprvImgGrup : PanacheMongoEntity {

  constructor(
  ): super() { }

  constructor(
    grupId: String,
    ctntType: String
  ): super() {
    this.grupId = grupId
    this.ctntType = ctntType
  }

  constructor (
    grupId: String,
    ctntType: String,
    ctntAgeGrad: String,
    rgstStep: String,
    aiSgstKywdList: List<String>,
    modrList: List<String>,
    qltyFcusAvrg: Float,
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
    this.qltyFcusAvrg = qltyFcusAvrg
    this.adjtReslAvrg = adjtReslAvrg
    this.ttpxAvrg = ttpxAvrg
    this.bytsAvrg = bytsAvrg
    this.ctntCnt = ctntCnt
  }

  var grupId: String? = null
  var ctntType: String? = null
  var rgstStep: String? = null
  var modrList: List<String>? = mutableListOf()
  var ctntAgeGrad: String? = null
  var aiSgstKywdList: List<String>? = mutableListOf()
  var userRemvKywdList: List<String>? = mutableListOf()
  var userAdddKywdList: List<String>? = mutableListOf()
  var finlKywdList: List<String>? = null
  var qltyFcusAvrg: Float? = null
  var adjtReslAvrg: Long? = null
  var ttpxAvrg: Long? = null
  var bytsAvrg: Long? = null
  var ctntCnt: Int? = null

  var celbList: List<String>? = null
  var inptImgList: MutableList<ImgSorcItem>? = null
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
  var aprvBySelf: Boolean? = false

  var aprvUserId: String? = null
  var aprvDttm: LocalDateTime? = null
  var rgstUserId: String? = null
  var updtUserId: String? = null
  var bofcRgst: Boolean = true
  var rgstDttm: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)
  var updtDttm: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)
  var upscCd: String? = null
  var upscNm: String? = null


  companion object: PanacheMongoCompanion<AprvImgGrup> {


  }
}