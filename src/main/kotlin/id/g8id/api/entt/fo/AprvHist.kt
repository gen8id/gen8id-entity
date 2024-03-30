package id.g8id.api.entt.fo

import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import java.time.LocalDateTime

class AprvHist : PanacheMongoEntity {

  constructor() : super()

  constructor (
    ctntType: String
    , grupId: String
    , topCtntAgeGrad: String
    , aprvStep: String
    , aprvUserId: String
  ) : super() {
    this.ctntType = ctntType
    this.grupId = grupId
    this.topCtntAgeGrad = topCtntAgeGrad
    this.aprvStep = aprvStep
    this.aprvUserId = aprvUserId
  }

  lateinit var grupId: String
  lateinit var ctntType: String
  lateinit var topCtntAgeGrad: String
  lateinit var aprvStep: String
  lateinit var aprvUserId: String

  val rgstDttm: LocalDateTime? = null
  val aprvDttm: LocalDateTime? = null
  var celbCtnt: Boolean? = false
  var modrCtnt: Boolean? = false

  companion object: PanacheMongoCompanion<AprvHist> {


  }

}
