package id.g8id.api.data

import id.g8id.api.enttcomp.fo.RqstImgGrup
import io.quarkus.mongodb.panache.common.ProjectionFor
import java.time.LocalDateTime

@ProjectionFor(RqstImgGrup::class)
class ImgGrupNoPmpt {

  constructor() : super()

  constructor(grupId: String): super() {
    this.grupId = grupId
  }

  constructor (
    grupId: String,
    ctntType: String,
    ctntAgeGrad: String,
    celbList: List<String>?,
    modrList: List<String>?,
    ttpxAvrg: Long?,
    bytsAvrg: Long?,
    qltyFcusAvrg: Float?,
    adjtReslAvrg: Long?,
    ctntCnt: Int?,
    aiSgstKywdList: List<String>?
  ): super() {
    this.grupId = grupId
    this.ctntType = ctntType
    this.ctntAgeGrad = ctntAgeGrad
    this.ttpxAvrg = ttpxAvrg
    this.bytsAvrg = bytsAvrg
    this.celbList = celbList
    this.modrList = modrList
    this.ttpxAvrg = ttpxAvrg
    this.bytsAvrg = bytsAvrg
    this.qltyFcusAvrg = qltyFcusAvrg
    this.adjtReslAvrg = adjtReslAvrg
    this.ctntCnt = ctntCnt
    this.aiSgstKywdList = aiSgstKywdList
  }
  var grupId: String? = null
  var itemId: String? = null
  var ctntType: String? = null
  var ctntCnt: Int? = null
  var natnCtry: String? = null
  var phtoUrl: String? = null
  var modlCd: String? = null
  var modlNm: String? = null
  var finlKywdList: List<String>? = null

  var pblcThumUrl: String? = null

  var ctntAgeGrad: String? = null
  var ttpxAvrg: Long? = null
  var bytsAvrg: Long? = null
  var celbList: List<String>? = null
  var modrList: List<String>? = null
  var pmptImgListSize: Int = 0
  var qltyFcusAvrg: Float? = null
  var adjtReslAvrg: Long? = null

  var titl: String? = null
  var prvdCd: String? = null
  var rgstStep: String? = null
  var bofcRgst: Boolean? = null
  var crtrId: String? = null
  var crtrNm: String? = null
  var crtrMesg: String? = null
  var crtrGrad: String? = null
  var pmptLeng: Int? = 0
  var pricIdImg: String? = null
  var pricIdPmpt: String? = null
  var imgPric: Int? = null
  var imgPckgPric: Int? = null
  var pmptPric: Int? = null
  var dsctRate: Int? = null
  var aiSgstKywdList: List<String>? = null
  var updtDttm: LocalDateTime? = null
  var sc: Double? = null
  var liked: Boolean? = false
  var purchased: Boolean? = false

}

