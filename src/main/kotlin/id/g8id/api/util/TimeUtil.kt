package id.g8id.api.util

import org.bson.types.ObjectId
import java.nio.ByteBuffer
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

class TimeUtil {

  companion object {

    // val FORMAT_SD_TO_DATE = SimpleDateFormat("yyyyMMdd")
    val FORMAT_LDT_TO_SEC_TZ  = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ")
    val FORMAT_LDT_TO_SEC     = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")
    val FORMAT_LDT_TO_DATE    = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'")
    val FORMAT_DF_DATE_HYP    = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val FORMAT_DF_TO_DATE     = DateTimeFormatter.ofPattern("yyyyMMdd")
    val FORMAT_DF_TO_HOUR     = DateTimeFormatter.ofPattern("yyyyMMddHH")
    val FORMAT_DF_TO_MIN_SHORT = DateTimeFormatter.ofPattern("yyyyMMddHHmm")
    val FORMAT_DF_TO_SEC      = DateTimeFormatter.ofPattern("yyyyMMddHHmmss")
    val FORMAT_DF_TO_SEC_SMPL = DateTimeFormatter.ofPattern("yyMMddHHmmss")
    val FORMAT_DF_TO_MSEC      = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS")

    fun getTodayYyyyMMdd(): String {
      return LocalDate.now(ZoneOffset.UTC).format(FORMAT_DF_TO_DATE)
    }

    fun getTodayYyMMdd(): String {
      return LocalDate.now(ZoneOffset.UTC).format(FORMAT_DF_TO_DATE).substring(2)
    }

    fun getTodayYyyMMdd(): String {
      return LocalDate.now(ZoneOffset.UTC).format(FORMAT_DF_TO_DATE).substring(1)
    }

    /**
     * from 7days to 13days ago
     */
    fun get1Or2WeekBeforeYyyyMMdd(): List<String> {
      val ret = mutableListOf<String>()
      val now = LocalDate.now(ZoneOffset.UTC)
      for (i in 8..14) {
        // println("i $i")
        val newDate = now.minusDays(i.toLong())
        ret.add(newDate.format(FORMAT_DF_TO_DATE))
      }
      return ret
    }

    fun getWeekYyyyMMddId(kywdGrup: String): List<ObjectId> {
      val ret = mutableListOf<ObjectId>()
      val today = LocalDate.now(ZoneOffset.UTC)
      for (i: Int in 0..7) {
        ret.add(ObjectId(today.minusDays(i.toLong()).format(FORMAT_DF_TO_DATE)
            + kywdGrup))
      }
      return ret
    }

    fun getMonthYyyyMMddId(kywdGrup: String): List<ObjectId> {
      val ret = mutableListOf<ObjectId>()
      val today = LocalDate.now(ZoneOffset.UTC)
      for (i: Int in 0..30) {
        ret.add(ObjectId(today.minusDays(i.toLong()).format(FORMAT_DF_TO_DATE)
            + kywdGrup))
      }
      return ret
    }

    fun getNowYyyyMmddHH(): String {
      return LocalDateTime.now(ZoneOffset.UTC).format(FORMAT_DF_TO_HOUR)
    }
    fun getEpochTimestampSecModLongToBase62(): String {
      val ETS_20240101 = 1704067200L
      val unixTimeAfter20240101 = System.currentTimeMillis()/1000 - ETS_20240101
      val buffer: ByteBuffer = ByteBuffer.allocate(java.lang.Long.BYTES)
      buffer.putLong(unixTimeAfter20240101)
      return StngUtil.encodeToBase62String(buffer.array())
    }

    fun dateTimeStr2LocalDateTime(dateTimeStr: String): LocalDateTime {
      return LocalDateTime.parse(dateTimeStr, FORMAT_LDT_TO_SEC)
    }

  }

}