package id.g8id.api.entt

import id.g8id.api.rqst.SaveFltrRqst
import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import org.bson.types.ObjectId
import java.time.LocalDateTime
import java.time.ZoneOffset

class SavdFltr : PanacheMongoEntity() {

  lateinit var userId: String
  lateinit var fltrNm: String
  var prvdCd: List<String>? = null
  var asptRtio: List<String>? = null
  var ctntAgeGrad: List<String>? = null
  var stle: List<String>? = null
  var ctgr: List<String>? = null
  var kywd: List<String>? = null
  var ordrBy: String? = null
  var rgstDttm: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)

  companion object: PanacheMongoCompanion<SavdFltr> {
    fun updateFilter(param: SaveFltrRqst): Boolean {
      var item = find("userId = ?1 and _id = ?2", param.userId, ObjectId(param.id)).firstResult()
      if (item==null) {
        item = SavdFltr()
      }
      item.userId = param.userId!!
      item.fltrNm = param.fltrNm
      item.prvdCd = param.prvdCd
      item.asptRtio = param.asptRtio
      item.ctntAgeGrad = param.ctntAgeGrad
      item.stle = param.stle
      item.ctgr = param.ctgr
      item.kywd = param.kywd
      item.ordrBy = param.ordrBy
      item.rgstDttm = LocalDateTime.now(ZoneOffset.UTC)
      item.persistOrUpdate()
      return true
    }
  }

}