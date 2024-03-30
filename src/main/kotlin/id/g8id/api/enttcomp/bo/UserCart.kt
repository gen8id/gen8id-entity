package id.g8id.api.enttcomp.bo

import id.g8id.api.rqst.AddCartRqst
import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import java.time.LocalDateTime
import java.time.ZoneOffset

class UserCart() : PanacheMongoEntity() {

  constructor(param: AddCartRqst) : this() {
    this.rgstUserId = param.userId
    this.grupId = param.grupId
    this.ctntType = param.ctntType
    this.titl = param.titl
    this.pblcThumUrl = param.pblcThumUrl
    this.imgList = param.imgIdList
    this.totlPric = param.totlPric
    this.imgCnt = if (!param.imgIdList.isNullOrEmpty()) { param.imgIdList!!.size } else { 0 }
  }

  constructor(userId: String, ctntType: String, grupId: String
              , title: String, pblcThumUrl: String, imgIdStrList: List<String>?, pmptYn: Boolean, totlPric: Double) : this() {
    this.rgstUserId = userId
    this.titl = title
    this.grupId = grupId
    this.ctntType = ctntType
    this.pblcThumUrl = pblcThumUrl
    this.imgList = imgIdStrList
    this.totlPric = totlPric
    this.imgCnt = if (!imgIdStrList.isNullOrEmpty()) { imgIdStrList.size } else { 0 }
  }

  var rgstUserId: String? = null
  var ctntType: String? = null
  var grupId: String? = null
  var titl: String? = null
  var pblcThumUrl: String? = null
  var imgList: List<String>? = null
  var dsctInfo: String? = null
  var totlPric: Double? = 0.0
  var imgCnt: Int = 0
  var rgstDttm: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)

  companion object: PanacheMongoCompanion<UserCart> {

  }

}
