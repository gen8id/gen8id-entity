package id.g8id.api.enttcomp.bo
import id.g8id.api.cnst.CreatorDetail
import id.g8id.api.data.AprvImgPmpt
import id.g8id.api.data.ImgGrupNoPmpt
import id.g8id.api.rsps.ImgListRsps
import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import io.quarkus.panache.common.Sort
import java.text.DecimalFormat
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
    this.qltyFcusAvrg = DecimalFormat("#.##").format(qltyFcusAvrg).toDouble()
    this.adjtReslAvrg = adjtReslAvrg
    this.ttpxAvrg = ttpxAvrg
    this.bytsAvrg = bytsAvrg
    this.ctntCnt = ctntCnt
  }

  lateinit var grupId: String
  lateinit var ctntType: String
  lateinit var ctntAgeGrad: String
  lateinit var rgstStep: String
  lateinit var modrList: List<String>
  lateinit var aiSgstKywdList: List<String>
  var userRemvKywdList: List<String>? = null
  var userAdddKywdList: List<String>? = null
  var finlKywdList: List<String>? = null
  var qltyFcusAvrg: Double? = null
  var adjtReslAvrg: Long? = null
  var ttpxAvrg: Long? = null
  var bytsAvrg: Long? = null
  var ctntCnt: Int? = null

  var celbList: List<String>? = null
  var pmptImgList: MutableList<AprvImgPmpt>? = null
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
  var aprvBySelf: Boolean? = true

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
    fun findByCrtrId(crtrId: String): ImgListRsps<ImgGrupNoPmpt> {
      val totlCnt = AprvImgGrup.find("crtrId", crtrId).count().toInt()
      val limit = if (totlCnt > CreatorDetail.COLLECTION_PER_PAGE) { CreatorDetail.COLLECTION_PER_PAGE } else { totlCnt }
      val list = AprvImgGrup.find("crtrId", Sort.descending("aprvDttm"), crtrId).project(ImgGrupNoPmpt::class.java)
        .list().subList(0, limit)
      list.forEach { it ->
        val item = AprvImgItem.find("grupId", it.grupId).firstResult()
        if (item!=null) {
          it.pblcThumUrl = item.pblcThumUrl
        }
      }
      return ImgListRsps(list, totlCnt)
    }
  }

}