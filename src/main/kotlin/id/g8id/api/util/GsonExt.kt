package id.g8id.api.util

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.time.LocalDateTime

class GsonExt {

  companion object {
    fun getGson(): Gson {
      return GsonBuilder().registerTypeAdapter(LocalDateTime::class.java, LocalDateTimeTypeAdapter()).create()
    }
  }

}