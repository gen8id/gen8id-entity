package id.g8id.api.entt.fo

import ai.bitflow.api.comn.rqst.AddCartRqst
import ai.bitflow.api.comn.rqst.PadlItem
import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import io.quarkus.panache.common.Parameters
import io.quarkus.panache.common.Sort
import java.time.LocalDateTime
import java.time.ZoneOffset

class UserCart() : PanacheMongoEntity() {

  constructor(param: AddCartRqst) : this() {
    this.rgstUserId = param.userId
    this.grupId = param.grupId
    this.ctntType = param.ctntType
    this.titl = param.titl
    this.pblcThumUrl = param.pblcThumUrl
    this.imgIdList = param.imgIdList
    this.imgPricId = param.imgPricId
    this.pmptPricId = param.pmptPricId
    this.dscntId = param.dsctId
    this.crcy = param.crcy
    this.items = param.items
    this.plfmFeeRate = param.plfmFeeRate
    this.totlPric = param.totlPric
    this.frmtTotl = param.frmtTotl
    this.imgCnt = if (!param.imgIdList.isNullOrEmpty()) { param.imgIdList!!.size } else { 0 }
    this.pmptCnt = param.pmptCnt
  }

  constructor(userId: String, ctntType: String, grupId: String
              , title: String, pblcThumUrl: String, imgIdList: List<String>?, pmptYn: Boolean, totlPric: Double) : this() {
    this.rgstUserId = userId
    this.titl = title
    this.grupId = grupId
    this.ctntType = ctntType
    this.pblcThumUrl = pblcThumUrl
    this.imgIdList = imgIdList
    this.totlPric = totlPric
    this.imgCnt = if (!imgIdList.isNullOrEmpty()) { imgIdList.size } else { 0 }
  }

  var ctntType: String? = null
  var grupId: String? = null
  var crtrId: String? = null
  var titl: String? = null
  var customData: Map<String, String>? = null
  var pblcThumUrl: String? = null
  var ctry: String? = null
  var crcy: String? = null
  var crtrGrad: String? = null
  var plfmFeeRate: Int? = null

  var imgIdList: List<String>? = null
  var imgPricId: String? = null
  var pmptPricId: String? = null
  var dscntId: String? = null
  var items: List<PadlItem>? = null
  var imgCnt: Int = 0
  var pmptCnt: Int = 0
  var totlPric: Double? = 0.0
  var frmtTotl: String? = null
  var rgstUserId: String? = null
  var rgstDttm: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)

  companion object: PanacheMongoCompanion<UserCart> {
    fun findAllByUserId(userId: String): List<UserCart> {
      return find(
        "rgstUserId = :rgstUserId",
        Sort.descending("rgstDttm"),
        Parameters.with("rgstUserId", userId),
      ).list()
    }

  }

}
