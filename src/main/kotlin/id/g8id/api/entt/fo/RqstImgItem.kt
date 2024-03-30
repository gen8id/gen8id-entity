package id.g8id.api.entt

import id.g8id.api.cnst.ContentAgeGrade
import id.g8id.api.data.RqstImgItemData
import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import java.text.DecimalFormat
import java.time.LocalDateTime
import java.time.ZoneOffset


class RqstImgItem : PanacheMongoEntity {

  constructor() : super()

  constructor (
    grupId: String
    , pblcId: String
    , ctntType: String
    , pblcBigUrl: String
    , pblcThumUrl: String?
    , wdth: Int
    , hegt: Int
    , fileExt: String
    , fileHashOrg: String
    , byts: Long?
    , cptn: String?
    , rgstId: String
    , cretDttm: LocalDateTime?
    , colrRgbList: List<Map<String, Double>>?
    , goglColrList: List<Map<String, Double>>?
    , cdnrColrList: List<Map<String, Double>>?
    , aiSgstKywdList: List<String>?
    , rgstStep: String
    , qltyFcus: Double?
  ) : super() {
    this.grupId = grupId
    this.pblcId = pblcId
    this.ctntType = ctntType
    this.pblcBigUrl = pblcBigUrl
    this.pblcThumUrl = pblcThumUrl
    this.wdth = wdth
    this.hegt = hegt
    this.asptRtio = DecimalFormat("#.##").format(wdth.toDouble() / hegt.toDouble()).toDouble()
    this.ttpx = wdth.toLong() * hegt.toLong()
    this.fileExt = fileExt
    this.fileHashOrg = fileHashOrg
    this.byts = byts
    this.aiSgstKywds = aiSgstKywdList
    this.cptn = cptn
    this.adjtResl = (wdth.toDouble() * hegt.toDouble() * (qltyFcus ?: 1.0)).toLong()
    this.qltyFcus = DecimalFormat("#.##").format(qltyFcus).toDouble()
    this.rgstUserId = rgstId
    this.updtUserId = rgstId
    this.cretDttm = cretDttm
    this.rgstStep = rgstStep
    this.rgstDttm = LocalDateTime.now(ZoneOffset.UTC)
    this.updtDttm = LocalDateTime.now(ZoneOffset.UTC)
    this.rgbColrList = colrRgbList
    this.goglColrList = goglColrList
    this.cdnrColrList = cdnrColrList
  }

  lateinit var grupId: String
  lateinit var pblcId: String
  lateinit var ctntType: String
  lateinit var pblcBigUrl: String
  var pblcThumUrl: String? = null
  var wdth: Int? = null
  var hegt: Int? = null
  var asptRtio: Double? = null
  var ttpx: Long? = null
  var fileExt: String? = null
  var fileHashOrg: String? = null
  var byts: Long? = null
  var cptn: String? = null
  var adjtResl: Long? = null
  var qltyFcus: Double? = null
  var rgstUserId: String? = null
  var updtUserId: String? = null
  var cretDttm: LocalDateTime? = null
  var rgstStep: String? = null
  var rgstDttm: LocalDateTime? = null
  var updtDttm: LocalDateTime? = null
  var bofcRgst: Boolean = false
  var aprvUserId: String? = null
  var aprvDttm: LocalDateTime? = null

  var ctntAgeGrad: String = ContentAgeGrade.EVERYONE
  var topCtntAgeGrad: String = ContentAgeGrade.EVERYONE
  var aiSgstKywds: List<String>? = null
  var finlKywds: List<String>? = null
  var rgbColrList: List<Map<String, Double>>? = null
  var cdnrColrList: List<Map<String, Double>>? = null
  var goglColrList: List<Map<String, Double>>? = null

  var prvdCd: String? = null
  var titl: String? = null
  var pstvPmpt: String? = null
  var pmptHash: String? = null
  var crtrId: String? = null
  var aprvBySelf: Boolean = false

  var celbCtnt: Boolean = false
  var prsnCnt: Int = 0
  var celbs: List<String>? = null
  var modrMap: Map<String, List<String>>? = null // content moderation result

  companion object: PanacheMongoCompanion<RqstImgItem> {
    fun findByGrupIdConvertToData(grupId: String): List<RqstImgItemData> {
      return find("grupId", grupId).list().map { it.toData() }
    }
  }

}

fun RqstImgItem.toData(): RqstImgItemData {
  return RqstImgItemData(
    id = this.id,
    pblcId = this.pblcId,
    grupId = this.grupId,
    pblcBigUrl = this.pblcBigUrl,
    pblcThumUrl = this.pblcThumUrl,
    cptn = this.cptn,
    qltyFcus = this.qltyFcus,
    byts = this.byts,
    ctntAgeGrad = this.ctntAgeGrad,
    wdth = this.wdth,
    hegt = this.hegt,
    ttpx = this.ttpx,
    adjtResl = this.adjtResl,
    aiSgstKywdList = this.aiSgstKywds?.toSet(),
    modrMap = this.modrMap,
    celbs = this.celbs?.toSet(),
  )
}