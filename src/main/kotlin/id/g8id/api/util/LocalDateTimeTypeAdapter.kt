package id.g8id.api.util

import com.google.gson.*
import java.lang.reflect.Type
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * ref. https://howtodoinjava.com/gson/gson-typeadapter-for-inaccessibleobjectexception/
 */
class LocalDateTimeTypeAdapter : JsonSerializer<LocalDateTime?>, JsonDeserializer<LocalDateTime?> {

  override fun serialize(
    localDateTime: LocalDateTime?, srcType: Type?,
    context: JsonSerializationContext?
  ): JsonElement {
    return JsonPrimitive(formatter.format(localDateTime))
  }

  @Throws(JsonParseException::class)
  override fun deserialize(
    json: JsonElement, typeOfT: Type?,
    context: JsonDeserializationContext?
  ): LocalDateTime {
    return LocalDateTime.parse(json.asString, formatter)
  }

  companion object {
    private val formatter = DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss")
  }

}