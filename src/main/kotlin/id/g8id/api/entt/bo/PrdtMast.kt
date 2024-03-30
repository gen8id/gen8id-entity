package id.g8id.api.entt.bo

import com.fasterxml.jackson.annotation.JsonProperty
import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import org.bson.codecs.pojo.annotations.BsonProperty
import java.time.LocalDateTime

data class PrdtMast(

  @BsonProperty("productId")
  @JsonProperty("id")
  var productId: String? = null,
  var name: String? = null,
  @JsonProperty("tax_category")
  var taxCategory: String? = null, // digital-goods
  var description: String? = null,
  @JsonProperty("image_url")
  var imageUrl: String? = null,
  @JsonProperty("custom_data")
  var customData: Map<String, Any>? = null,
  var status: String? = null,
  @JsonProperty("created_at")
  var createdAt: LocalDateTime? = null

) : PanacheMongoEntity() {

  companion object: PanacheMongoCompanion<PrdtMast> {

  }

}
