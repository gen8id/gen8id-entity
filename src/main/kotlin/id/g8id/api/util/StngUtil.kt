package id.g8id.api.util

import io.seruco.encoding.base62.Base62
import java.nio.ByteBuffer

class StngUtil {

  companion object {

    fun encodeToBase62String(rawString: String): String {
      return Base62.createInstance().encode(rawString.toByteArray(Charsets.UTF_8)).toString(Charsets.UTF_8)
    }

    fun encodeToBase62String(byteArray: ByteArray): String {
      return Base62.createInstance().encode(byteArray).toString(Charsets.UTF_8)
    }

    /**
     * almost 18bytes
     */
    fun getUniqueStringWithTimeAndUserId(userId: String): String {
      val unixTimeAfter20240101 = System.currentTimeMillis()/1000 - 1704067200L
      val buffer: ByteBuffer = ByteBuffer.allocate(java.lang.Long.BYTES)
      buffer.putLong(unixTimeAfter20240101)
      return (encodeToBase62String(buffer.array()) + encodeToBase62String(userId.toByteArray(Charsets.UTF_8))).trimStart('0')
    }

    fun isMobile(platform: String?): Boolean {
      if (platform==null) { return false }
      val mobile = arrayOf("android", "iphone", "ipad")
      return mobile.contains(platform.lowercase())
    }

    fun getPlatformNameFromUserAgent(userAgent: String): String? {

      val userAgntLow = userAgent.lowercase()
      var ret: String? = null
      if (userAgntLow.contains("android")) {
        ret = "Android"
      } else if (userAgntLow.contains("windows")) {
        ret = "Windows"
      } else if (userAgntLow.contains("os x")) {
        if (userAgntLow.contains("mobile")) {
          if (userAgntLow.contains("iphone")) {
            ret = "Iphone"
          } else if (userAgntLow.contains("ipad")) {
            ret = "Ipad"
          } else if (userAgntLow.contains("macintosh")) {
            ret = "Ipad"
          }
        } else if (userAgntLow.contains("macintosh")) {
          ret = "Macintosh"
        }
      } else if (userAgntLow.contains("linux")) {
        ret = "Linux"
      }
      return ret

    }
    
  }


}