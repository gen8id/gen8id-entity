package id.g8id.api.entt

import id.g8id.api.cnst.ContentType.AUDIO
import id.g8id.api.cnst.ContentType.IMAGE
import id.g8id.api.cnst.ContentType.TEXT
import id.g8id.api.cnst.ContentType.VIDEO
import id.g8id.api.rqst.AtwkLikeViewRqst
import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import java.time.LocalDateTime
import java.time.ZoneOffset

class AtwkLike() : PanacheMongoEntity() {

  constructor(userId: String) : this() {
    this.userId = userId
  }

  lateinit var userId: String
  var imag = mutableListOf<String>()
  var vido = mutableListOf<String>()
  var audo = mutableListOf<String>()
  var text = mutableListOf<String>()
  var lastUpdtDttm: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)

  companion object: PanacheMongoCompanion<AtwkLike> {

    /**
     * Should be applied to Customer user only
     */
    fun addLike(param: AtwkLikeViewRqst): Boolean {

      // Upsert
      var item = find("userId", param.userId).firstResult()

      if (item==null) {
        item = AtwkLike(param.userId!!)
      }

      var ret = false

      // 1. if found id, update each keyword count +1
      if (param.ctntType == IMAGE) {
        if (!item.imag.contains(param.grupId)) {
          item.imag.add(param.grupId)
          ret = true
        } else {
          item.imag.remove(param.grupId)
        }
      } else if (param.ctntType == VIDEO) {
        if (!item.vido.contains(param.grupId)) {
          item.vido.add(param.grupId)
          ret = true
        } else {
          item.vido.remove(param.grupId)
        }
      } else if (param.ctntType == AUDIO) {
        if (!item.audo.contains(param.grupId)) {
          item.audo.add(param.grupId)
          ret = true
        } else {
          item.audo.remove(param.grupId)
        }
      } else if (param.ctntType == TEXT) {
        if (!item.text.contains(param.grupId)) {
          item.text.add(param.grupId)
          ret = true
        } else {
          item.text.remove(param.grupId)
        }
      }

      item.lastUpdtDttm = LocalDateTime.now(ZoneOffset.UTC)
      item.persistOrUpdate()

      return ret

    }

    fun findByUserId(userId: String): AtwkLike? {
      return find("userId", userId).firstResult()
    }

  }

}