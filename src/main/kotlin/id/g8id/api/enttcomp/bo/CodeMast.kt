package id.g8id.api.enttcomp.bo

import id.g8id.api.data.CodeData
import io.quarkus.cache.CacheInvalidate
import io.quarkus.cache.CacheKey
import io.quarkus.cache.CacheResult
import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import io.quarkus.panache.common.Sort
import java.time.LocalDateTime
import java.time.ZoneOffset


class CodeMast : PanacheMongoEntity {

  public constructor() : super()

  constructor(
    grupCode: String,
    code: String,
    name: String,
    valu: String?,
    ordr: Int?,
    remk: String?,
    userId: String
  ) : super() {
    this.grupCode = grupCode
    this.code = code
    this.name = name
    this.valu = valu
    this.ordr = ordr
    this.remk = remk
    this.rgstUserId = userId
    this.updtUserId = userId
  }

  lateinit var grupCode: String
  lateinit var code: String
  var name: String? = null
  var valu: String? = null
  var ordr: Int? = 0
  var remk: String? = null
  var disp: Boolean? = true
  var rgstUserId: String? = null
  var rgstDttm: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)
  var updtUserId: String? = null
  var updtDttm: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)

  companion object: PanacheMongoCompanion<CodeMast> {

    val PAGE_LIMIT = 15

    // Paginated code request
    fun getCodes(grupCode: String, page: Int): List<CodeMast> {
        return find("grupCode = ?1", Sort.by("grupCode").and("ordr"), grupCode).page(page - 1, PAGE_LIMIT).list()
    }

    fun getCodesWithoutPaging(grupCode: String): List<CodeMast> {
      return list("grupCode = ?1", Sort.by("grupCode").and("ordr"), grupCode)
    }

    // Total count of codes
    fun countCodes(grupCode: String): Long {
      return count("grupCode = ?1", grupCode)
    }

    @CacheInvalidate(cacheName = "yyyymmddhh")
    @CacheResult(cacheName = "yyyymmddhh")
    fun getFreqUsedCodes(grupCodes : Array<String>, @CacheKey yyyymmddhh: String): Map<String, MutableList<CodeData>> {
      val dispFilter = listOf(null, true)
      val res: List<CodeMast> = find("grupCode in ?1 and disp in ?2", Sort.by("grupCode").and("ordr"), grupCodes, dispFilter).list()
      val ret = mutableMapOf<String, MutableList<CodeData>>()
      res.forEach {
        val item = CodeData(it.grupCode, it.code!!, it.name!!, it.valu, it.ordr)
        val codeList: MutableList<CodeData>?
        if (ret.containsKey(it.grupCode)) {
          codeList = ret.get(it.grupCode)
        } else {
          codeList = mutableListOf()
          ret.put(it.grupCode, codeList)
        }
        codeList!!.add(item)
      }
      return ret
    }
  }

}