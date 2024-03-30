package id.g8id.api.entt.bo

import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import java.time.LocalDateTime
import java.time.ZoneOffset

class AprvHist : PanacheMongoEntity {

  constructor() : super()

  constructor (
    ctntType: String?
    , grupId: String?
    , ctntAgeGrad: String?
    , aprvStep: String
    , aprvUserId: String
  ) : super() {
    this.ctntType = ctntType
    this.grupId = grupId
    this.ctntAgeGrad = ctntAgeGrad
    this.aprvStep = aprvStep
    this.aprvUserId = aprvUserId
  }

  var ctntType: String? = null
  var grupId: String? = null
  var ctntAgeGrad: String? = null
  var aprvStep: String? = null
  var aprvUserId: String? = null

  val aprvDttm: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)
  var celbCtnt: Boolean? = false
  var modrCtnt: Boolean? = false

  companion object: PanacheMongoCompanion<AprvHist> {


  }

}
