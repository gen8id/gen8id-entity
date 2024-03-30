package id.g8id.api.bo.entt

import ai.bitflow.api.comn.util.TimeUtil
import id.g8id.api.bo.cnst.CONTENT_TYPE_SHORT_ARR
import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import org.bson.types.ObjectId
import java.time.LocalDateTime
import java.time.ZoneOffset

class AtwkView : PanacheMongoEntity {

  constructor() : super()

  constructor(grupIds: MutableMap<String, Long>) : super() {
    this.grupIdAndCnts = grupIds
  }

  var grupIdAndCnts = mutableMapOf<String, Long>()
  var lastUpdtDttm: LocalDateTime? = null

  companion object: PanacheMongoCompanion<AtwkView> {

    /**
     * Should be applied to Customer user only
     */
    fun addViewHist(type: String, grupId: String): Boolean {

      if (type.length!=4 || !CONTENT_TYPE_SHORT_ARR.contains(type)) {
        return false
      }

      // Upsert
      val id    = ObjectId(TimeUtil.getTodayYyyyMMdd() + type + "000000000000")
      var item  = findById(id)
      val viewCntUpdt: MutableMap<String, Long>?

      if (item!=null) {
        viewCntUpdt = item.grupIdAndCnts.toMutableMap()
      } else {
        viewCntUpdt = mutableMapOf()
      }

      // 1. if found id, update each keyword count +1
      if (viewCntUpdt.keys.contains(grupId)) {
        viewCntUpdt[grupId] = (viewCntUpdt.getValue(grupId) + 1)
      } else {
        viewCntUpdt[grupId] = 1
      }

      if (item==null) {
        item = AtwkView(viewCntUpdt)
        item.id = id
      } else {
        item.grupIdAndCnts = viewCntUpdt
      }
      item.lastUpdtDttm = LocalDateTime.now(ZoneOffset.UTC)
      item.persistOrUpdate()

      return true

    }

  }

}