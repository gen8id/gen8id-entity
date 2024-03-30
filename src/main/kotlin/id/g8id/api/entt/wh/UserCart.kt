package id.g8id.api.bo.entt

import id.g8id.api.bo.data.CartImgItem
import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import java.time.LocalDateTime
import java.time.ZoneOffset

class UserCart(var userId: String, var ctntType: String, var grupId: String) : PanacheMongoEntity() {

  var rgstUserId: String = userId

  var artTitle: String? = null
  var totlPric: Long? = 0
  var thumbUrl: String? = null
  var imgList: List<CartImgItem>? = null
  var pmptInfo: CartImgItem? = null
  var dsctInfo: CartImgItem? = null

  var rgstDttm: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)

  companion object: PanacheMongoCompanion<UserCart> {

  }

}
