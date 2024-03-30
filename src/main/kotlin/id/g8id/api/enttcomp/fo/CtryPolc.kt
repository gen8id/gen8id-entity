package id.g8id.api.enttcomp.fo

import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import java.time.LocalDateTime
import java.time.ZoneOffset

class CtryPolc : PanacheMongoEntity {

  public constructor() : super()

  lateinit var ctnt: String
  lateinit var iso2: String
  lateinit var name: String
  var iso3: String? = null
  var ctryNo: String? = null
  var islm: Boolean? = null
  var adltPlusPemt: Boolean? = null
  var panr: Boolean? = null
  var papl: String? = null
  var hpwl: String? = null
  var padl: Boolean? = null
  var strp: Boolean? = null
  var remk: String? = null
  var ctntAgeGrad: String? = null
  var updtUserId: String? = null
  var updtDttm: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)

  companion object: PanacheMongoCompanion<CtryPolc> {

  }

}