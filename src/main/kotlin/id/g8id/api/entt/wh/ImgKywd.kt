package id.g8id.api.bo.entt

import id.g8id.api.util.TimeUtil
import id.g8id.api.bo.cnst.KywdGrup
import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import org.bson.types.ObjectId
import java.time.LocalDateTime
import java.time.ZoneOffset

class ImgKywd : PanacheMongoEntity {

  constructor() : super()

  constructor(kywds: MutableMap<String, Long>) : super() {
    this.kywds = kywds
  }

  var kywds = mutableMapOf<String, Long>()
  var lastUpdtDttm: LocalDateTime? = null

  companion object: PanacheMongoCompanion<ImgKywd> {

    /**
     * Gathering search content keywords and it's frequency count
     *
     * Keywords should be updated in 'kywds' field with count+1
     * Celebrity name(If able to distinguish with general keywords) should also be updated in 'kywds' field with count+1
     * Celebrity name(If able to distinguish with general keywords) should be updated in 'celbs' field with count+1
     */
    fun addSrchKywd(kywd: String) {

      // Upsert (Merge)
      val id       = ObjectId(TimeUtil.getTodayYyyyMMdd() + KywdGrup.SEARCH)
      val item     = findById(id)
      val kywdList = kywd.split(" ")

      if (item!=null) {
        // 1. if found id, update each keyword count +1
        val kywds = item.kywds
        kywdList.forEach {
          if (kywds.containsKey(it)) {
            kywds[it] = (kywds.getValue(it) + 1)
          } else {
            kywds[it] = 1
          }
        }
        item.lastUpdtDttm = LocalDateTime.now(ZoneOffset.UTC)
        item.update()
      } else {
        // 2. if not found, insert one with count 1
        val kywds = mutableMapOf<String, Long>()
        kywdList.forEach {
          kywds[it] = 1
        }
        val newItem = ImgKywd(kywds)
        newItem.id = id
        newItem.lastUpdtDttm = LocalDateTime.now(ZoneOffset.UTC)
        newItem.persist()
      }
    }

    /**
     * Gathering uploaded content keywords and it's frequency count
     *
     * Keywords should be updated in 'kywds' field with count+1
     * Celebrity name should also be updated in 'kywds' field with count+1
     * Celebrity name should be updated in 'celbs' field with count+1
     */
    fun addUpldKywd(newKywds: Set<String>,) {
      // Upsert (Merge)
      val id    = ObjectId(TimeUtil.getTodayYyyyMMdd() + KywdGrup.UPLOAD)
      var item  = findById(id)
      val kywdUpdted: MutableMap<String, Long>?

      if (item!=null) {
        kywdUpdted = item.kywds.toMutableMap()
      } else {
        kywdUpdted = mutableMapOf()
      }

      // 1. if found id, update each keyword count +1
      newKywds.forEach {
        if (kywdUpdted.containsKey(it)) {
          kywdUpdted[it] = (kywdUpdted.getValue(it) + 1)
        } else {
          kywdUpdted[it] = 1
        }
      }

      if (item==null) {
        item = ImgKywd(kywdUpdted)
        item.id = id
      } else {
        item.kywds = kywdUpdted
      }
      item.lastUpdtDttm = LocalDateTime.now(ZoneOffset.UTC)
      item.persistOrUpdate()

    }

  }

}