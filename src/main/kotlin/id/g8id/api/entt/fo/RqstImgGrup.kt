package id.g8id.api.entt

import id.g8id.api.cnst.CreatorDetail
import id.g8id.api.data.ImgGrupNoPmpt
import id.g8id.api.data.RqstImgPmpt
import id.g8id.api.rsps.ImgListRsps
import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import io.quarkus.panache.common.Sort
import java.time.LocalDateTime
import java.time.ZoneOffset

class RqstImgGrup : PanacheMongoEntity {

  constructor(
  ): super() { }

  constructor (
    grupId: String,
    ctntType: String,
    topCtntAgeGrad: String,
    rgstStep: String,
    aiSgstKywdList: Set<String>,
    modrMap: Map<String, List<String>>,
    qltyFcusAvrg: Double,
    adjtReslAvrg: Long,
    ttpxAvrg: Long,
    bytsAvrg: Long,
    ctntCnt: Int
  ): super() {
    this.grupId = grupId
    this.ctntType = ctntType
    this.topCtntAgeGrad = topCtntAgeGrad
    this.rgstStep = rgstStep
    this.aiSgstKywds = aiSgstKywdList
    this.modrMap = modrMap
    this.qltyFcusAvrg = qltyFcusAvrg
    this.adjtReslAvrg = adjtReslAvrg
    this.ttpxAvrg = ttpxAvrg
    this.bytsAvrg = bytsAvrg
    this.ctntCnt = ctntCnt
  }

  lateinit var grupId: String
  lateinit var ctntType: String
  lateinit var topCtntAgeGrad: String
  lateinit var rgstStep: String
  lateinit var modrMap: Map<String, List<String>>
  lateinit var aiSgstKywds: Set<String>
  var userRemvKywds: Set<String>? = null
  var userAdedKywds: Set<String>? = null
  var finlKywds: Set<String>? = null
  var qltyFcusAvrg: Double? = null
  var adjtReslAvrg: Long? = null
  var ttpxAvrg: Long? = null
  var bytsAvrg: Long? = null
  var ctntCnt: Int? = null

  var prvdCd: String? = null
  var titl: String? = null
  var pstvPmpt: String? = null
  var pmptLeng: Int? = null
  var pmptHash: String? = null
  var modlCd: String? = null
  var modlNm: String? = null

  var crtrId: String? = null
  var crtrMesg: String? = null
  var initUpldFldr: String? = null
  var baseGradImg: Map<String, Any>? = null   // Todo: removable
  var baseGradPmpt: Map<String, Any>? = null  // Todo: removable
  var userDefnGradList: List<String>? = null  // Todo:
  var climCdList: List<String>? = null        // Todo:
  var celbList: List<String>? = null
  var pmptImgList: MutableList<RqstImgPmpt>? = null

  var pricIdImg: String? = null
  var pricIdPmpt: String? = null
  var ngtvPmpt: String? = null
  var bofcRgst: Boolean = false

  var upscCd: String? = null
  var upscNm: String? = null

  var rgstUserId: String? = null
  var updtUserId: String? = null
  var aprvUserId: String? = null
  var rgstDttm: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)
  var updtDttm: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)
  var aprvDttm: LocalDateTime? = null
  var aprvBySelf: Boolean? = false

  companion object: PanacheMongoCompanion<RqstImgGrup> {

    fun findByCrtrIdAndRgstStep(crtrId: String, rgstStep: String): ImgListRsps<ImgGrupNoPmpt> {
      val totlCnt = RqstImgGrup.find("crtrId = ?1 and rgstStep = ?2", crtrId, rgstStep).count().toInt()
      val limit = if (totlCnt > CreatorDetail.COLLECTION_PER_PAGE) { CreatorDetail.COLLECTION_PER_PAGE } else { totlCnt }
      val list = RqstImgGrup.find("crtrId = ?1 and rgstStep = ?2", Sort.descending("updtDttm"), crtrId, rgstStep)
        .project(ImgGrupNoPmpt::class.java).list().subList(0, limit)

      list.forEach { it ->
        val item = RqstImgItem.find("grupId", it.grupId).firstResult()
        if (item!=null) {
          it.pblcThumUrl = item.pblcThumUrl
        }
      }

      return ImgListRsps(list, totlCnt)
    }

  }
}