package id.g8id.api.entt.bo

import id.g8id.api.cnst.ContentAgeGrade
import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import java.text.DecimalFormat
import java.time.LocalDateTime
import java.time.ZoneOffset

class AcivImgItem : PanacheMongoEntity {

  constructor() : super()

  constructor (
    grupId: String
    , pblcId: String
    , ctntType: String
    , wdth: Int
    , hegt: Int
    , fileExt: String
    , pashOrg: String
    , fileHashOrg: String
    , byts: Long
    , url: String
    , thumUrl: String
    , urlOrg: String
    , thumUrlOrg: String
    , fileNmOrg: String
    , cptn: String?
    , qltyFcus: Double?
    , rgstId: String
    , cretDttm: LocalDateTime?
    , colrRgbList: Map<String, Double>
    , colrNms: Map<String, Double>
    , kywdList: MutableList<String>?
    , rgstStep: String
  ) : super() {
    this.grupId = grupId
    this.pblcId = pblcId
    this.ctntType = ctntType
    this.wdth = wdth
    this.hegt = hegt
    this.asptRtio = DecimalFormat("#.##").format(wdth.toDouble() / hegt.toDouble()).toDouble()
    this.ttpx = wdth.toLong() * hegt.toLong()
    this.fileExt = fileExt
    this.pashOrg = pashOrg
    this.fileHashOrg = fileHashOrg
    this.byts = byts
    this.pblcBigUrl = url
    this.pblcThumUrl = thumUrl
    this.bsdeBigUrl = urlOrg
    this.bsdeThumUrl = thumUrlOrg
    this.fileNmOrg = fileNmOrg
    this.finlKywdList = kywdList
    this.cptn = cptn
    if (qltyFcus != null) {
      this.adjtResl = (wdth.toDouble() * hegt.toDouble() * qltyFcus.toDouble()).toLong()
    } else {
      this.adjtResl = (wdth.toDouble() * hegt.toDouble()).toLong()
    }
    this.qltyFcus = qltyFcus
    this.rgstUserId = rgstId
    this.updtUserId = rgstId
    this.cretDttm = cretDttm
    this.colrRgbList = colrRgbList
    this.colrNms = colrNms
    this.rgstStep = rgstStep
    this.rgstDttm = LocalDateTime.now(ZoneOffset.UTC)
    this.updtDttm = LocalDateTime.now(ZoneOffset.UTC)
  }

  lateinit var grupId: String
  lateinit var pblcId: String
  lateinit var ctntType: String
  lateinit var pblcBigUrl: String
  lateinit var pblcThumUrl: String
  lateinit var bsdeBigUrl: String
  lateinit var bsdeThumUrl: String
  var wdth: Int? = null
  var hegt: Int? = null
  var asptRtio: Double? = null
  var ttpx: Long? = null
  var fileExt: String? = null
  var pashOrg: String? = null
  var fileHashOrg: String? = null
  var byts: Long? = null
  var fileNmOrg: String? = null
  var cptn: String? = null
  var adjtResl: Long? = null
  var qltyFcus: Double? = null
  var rgstUserId: String? = null
  var updtUserId: String? = null
  var cretDttm: LocalDateTime? = null
  var rgstStep: String? = null
  var rgstDttm: LocalDateTime? = null
  var updtDttm: LocalDateTime? = null
  var bofcRgst: Boolean = true

  var ctntAgeGrad: String = ContentAgeGrade.EVERYONE
  var finlKywdList: MutableList<String>? = null
  var celbList: MutableList<String>? = null
  var modrList: MutableList<String>? = null // content moderation result
  var colrRgbList: Map<String, Double>? = null
  var colrNms: Map<String, Double>? = null

  var prvdCd: String? = null
  var titl: String? = null
  var crtrId: String? = null

  /**
   * Creating text index
   * ref. https://www.mongodb.com/docs/drivers/java/sync/current/fundamentals/builders/indexes/
   *
   * e.g. Bson textIndex = text("theaters");
   *      collection.createIndex(textIndex);
   *
   * we're. db.TempImgs.createIndex({ cptn: "text", pstvPmpt: "text", kywdList: "text"
   *    , celbList: "text", colorNms: "text", modrList: "text" }, {
   *    weights: { pstvPmpt: 10, cptn: 8, crtrMesg: 7, kywdList: 6, celbList: 5, colorNms: 4
   *    , modrList: 3 }, name: "idx-temp-imgs" });
   */
  companion object: PanacheMongoCompanion<AcivImgItem> {


  }

}
