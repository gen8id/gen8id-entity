package id.g8id.api.entt

import id.g8id.api.rsps.PaplUserAddr
import id.g8id.api.rsps.PaplUserProfRsps
import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import org.bson.types.ObjectId
import java.time.LocalDateTime
import java.time.ZoneOffset


/**
 */
class PaplWlet : PanacheMongoEntity {

  constructor() : super()

  constructor(param: PaplUserProfRsps, cstmUserId: String, isDflt: Boolean): super() {
    this.payerId = param.payerId
    this.verified = param.verified
    this.verifiedAccount = param.verifiedAccount
    this.emailVerified = param.emailVerified
    this.email = param.email
    this.name = param.name
    this.userId = param.userId
    this.sub = param.sub
    this.address = param.address
    this.cstmUserId = cstmUserId
    this.isDflt = isDflt
  }

  constructor(payerId: String, verified: Boolean, verifiedAccount: Boolean, emailVerified: Boolean
              , email: String, name: String, userId: String, sub: String, cstmUserId: String, isDflt: Boolean) : super() {
    this.payerId = payerId
    this.verified = verified
    this.verifiedAccount = verifiedAccount
    this.emailVerified = emailVerified
    this.email = email
    this.name = name
    this.userId = userId
    this.sub = sub
    this.cstmUserId = cstmUserId
    this.isDflt = isDflt
  }

  // personal
  var cstmUserId: String? = null
  var payerId: String? = null
  var verified: Boolean? = null
  var verifiedAccount: Boolean? = null
  var emailVerified: Boolean? = null
  var email: String? = null
  var name: String? = null
  var userId: String? = null
  var sub: String? = null
  var address: PaplUserAddr? = null
  var isDflt: Boolean = false // 기본 월렛 여부
  var rgstDttm: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)

  companion object: PanacheMongoCompanion<PaplWlet> {
    fun findByIdAndCstmId(id: String, cstmUserId: String): PaplWlet? {
      return PaplWlet.find("id = ?1 and cstmUserId = ?2", ObjectId(id), cstmUserId).firstResult()
    }
  }

}