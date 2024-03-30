package id.g8id.api.entt

import id.g8id.api.antn.NoArg
import id.g8id.api.cnst.CreatorAdvantage
import id.g8id.api.cnst.CreatorGrade
import id.g8id.api.cnst.UserAgeVerify
import id.g8id.api.cnst.UserStatus
import id.g8id.api.expt.CstmUserPswdNotSetException
import id.g8id.api.rqst.CstmUserEmalSginRqst
import id.g8id.api.rqst.CstmUserSrchRqst
import id.g8id.api.rsps.UserBascRsps
import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import io.quarkus.mongodb.panache.kotlin.PanacheQuery
import io.quarkus.panache.common.Parameters
import io.quarkus.panache.common.Sort
import org.bson.types.ObjectId
import java.time.LocalDateTime
import java.time.ZoneOffset


class CstmUser : PanacheMongoEntity {

  constructor() : super()

  constructor(userStts: String) : super() {
    this.userStts = userStts
  }

  constructor(
    userId: String,
    pswd: String?,
    emal: String,
    userAgent: String?
  ) : super() {
    this.userId = userId
    this.pswd = pswd
    this.emal = emal
    this.userAgnt = userAgent
    this.rgstUserId = userId
    this.updtUserId = userId
  }

  constructor(
    userId: String,
    pswd: String?,
    emal: String,
    dispName: String?,
    moblNo: String?,
    userAgent: String,
    selfItro: String?,
  ) : super() {
    this.userId = userId
    this.pswd = pswd
    this.emal = emal
    this.dispName = dispName
    this.moblNo = moblNo
    this.userAgnt = userAgent
    this.rgstUserId = rgstUserId
    this.updtUserId = rgstUserId
    this.selfItro = selfItro
  }

  var userId: String? = null
  var dispName: String? = null
  var phtoUrl: String? = null
  var fbseUid: String? = null  // User id in Firebase
  var pvds: String = ""
  var moblNo: String? = null
  var emal: String? = null
  var pswd: String? = null
  var lang: String? = null
  var bofcRgst: Boolean = true
  var userStts: String? = null
  var selfItro: String? = null

  var pwErrCnt: Int = 0
  var crtrGrad: String? = CreatorGrade.LEVEL_1
  var userAgnt: String? = null

  // Vendor specific data
  var padlCstmId: String? = null
  var padlAddrId: String? = null
  var padlBsnsId: String? = null
  var padlTaxIdfy: String? = null
  var rgstUserId: String? = null
  var updtUserId: String? = null
  var rgstDttm: LocalDateTime? = LocalDateTime.now(ZoneOffset.UTC)
  var updtDttm: LocalDateTime? = LocalDateTime.now(ZoneOffset.UTC)
  var lastAccsDttm: LocalDateTime? = null
  var accsIp: String? = null
  var host: String? = null

  // Address
  var ctnt: String? = null
  var natnCtry: String? = null
  var accsCtnt: String? = null
  var accsCtry: String? = null
  var regn: String? = null
  var city: String? = null
  var zipCode: String? = null
  var frstName: String? = null
  var midlName: String? = null
  var lastName: String? = null
  var addrLine1: String? = null
  var addrLine2: String? = null

  var adltVrfys: MutableSet<String> = mutableSetOf(UserAgeVerify.NOT_VERIFIED)
  var adltVrfyResn: String? = null
  var emalVrfy: Boolean? = false
  var rfshTokn: String? = null
  var setPassLatr: Boolean = true
  var crtrAvtg: String? = CreatorAdvantage.NONE
  var dormDttm: LocalDateTime? = null
  var wtwlDttm: LocalDateTime? = null
  var pushKey: String? = null

  companion object: PanacheMongoCompanion<CstmUser> {

    fun isEqual(first: CstmUser, other: CstmUser): Boolean {
      return first.userId == other.userId && first.userStts == other.userStts
    }

    fun findByIdAndPswd(userId: String, pswd: String): PanacheQuery<CstmUser> {
      // Todo: JWT 토큰 생성
      val ret = CstmUser.find("userId = :userId and pswd = :pswd", Parameters.with("userId", userId).and("pswd", pswd))
      return ret
    }

    fun register(param: CstmUser) {
      param.persist()
    }

    fun getUsers(param: CstmUserSrchRqst): List<CstmUser> {
      val (query, params) = buildQueryAndParams(param)
      return find(query, Sort.by("rgstDttm").descending(), params).page(param.page - 1, 20).list()
    }

    fun countUsers(param: CstmUserSrchRqst): Long {
      val (query, params) = buildQueryAndParams(param)
      return count(query, params)
    }

    private fun buildQueryAndParams(param: CstmUserSrchRqst): Pair<String, MutableMap<String, Any?>> {
      val params = param.toRqstMap()
      val queryParts: MutableList<String> = ArrayList()
      if (params["dispName"] != null) queryParts.add("dispName like :dispName")
      if (params["userStts"] != null) queryParts.add("userStts = :userStts")
      if (params["userClass"] != null) queryParts.add("userClass = :userClass")
      if (params["ctry"] != null) queryParts.add("ctry = :ctry")
      if (params["lang"] != null) queryParts.add("lang = :lang")
      if (params["rgstFrom"] != null) queryParts.add("rgstDttm >= :rgstFrom")
      if (params["rgstTo"] != null) queryParts.add("rgstDttm <= :rgstTo")
      if (params["bofcRgst"] != null) queryParts.add("bofcRgst = :bofcRgst")
      val query = if (queryParts.size != 0) queryParts.joinToString(" and ") else "{}"
      return Pair(query, params)
    }

    fun update(param: CstmUser) {
      param.update()
    }

    fun findByFirebaseId(id: String): CstmUser? {
      return find("fbseUid = :fbseUid", Parameters.with("fbseUid", id)).firstResult()
    }

    fun findByUserId(userId: String): CstmUser? {
      return find("userId = :userId", Parameters.with("userId", userId)).firstResult()
    }

    fun findByUserIdBasic(userId: String): UserBascRsps? {
      return find("userId = :userId", Parameters.with("userId", userId)).project(UserBascRsps::class.java).firstResult()
    }

    fun removeAllByIds(ids: List<ObjectId>): Long {
      return CstmUser.delete("_id in ?1", ids)
    }

    @Throws(CstmUserPswdNotSetException::class)
    fun findByUserIdAndPswd(param: CstmUserEmalSginRqst): CstmUser? {

      val item = CstmUser.find("userId", param.userId).firstResult()

      if (item!=null) {
        // 1. if user with the userid found
        println("Found user at DB is " + item.userId + " " + param.encPswd + " " + item.pswd)

        if (item.pswd.isNullOrEmpty()) {
          throw CstmUserPswdNotSetException(item.pvds)
        }

        if (item.pswd != param.encPswd) {
          // 1). if password does not match
          //      - password wrong count + 1
          //      - return no user found or locked
          item.pwErrCnt = item.pwErrCnt.plus(1)

          if (item.userStts== UserStatus.ACTIVE && item.pwErrCnt > 4) {
            item.userStts = UserStatus.LOCKED
          }
          if (!param.ctnt.isNullOrBlank()) {
            item.accsCtnt = param.ctnt
          }
          if (!param.ctry.isNullOrBlank()) {
            item.accsCtry = param.ctry
          }

          if (item.pwErrCnt < 5) {
            item.userStts = UserStatus.WRONG_PW
          } else {
            item.userStts = UserStatus.LOCKED
          }

          item.lastAccsDttm = LocalDateTime.now(ZoneOffset.UTC)
          item.update()

          // return as no user with the user info found
          return item
          
        } else {

          // 2) if password matched
          if (item.userStts == UserStatus.ACTIVE && item.pwErrCnt < 5) {
            // 1.1.1. if user status is active
            item.pwErrCnt = 0
          } else if (item.userStts == UserStatus.LOCKED) {
          } else if (item.userStts == UserStatus.BANNED) {
          } else if (item.userStts == UserStatus.DORMANCY) {
          } else if (item.userStts == UserStatus.WITHDRAWAL) {
//        } else if (item.userStts == UserStatus.IN_REQUEST) {
          } else {
          }


          if (!param.ctnt.isNullOrBlank()) {
            item.accsCtnt = param.ctnt
          }
          if (!param.ctry.isNullOrBlank()) {
            item.accsCtry = param.ctry
          }

          // 1.1.2. stts - RQST, BNED, WTWL, DORM, LKED
          item.lastAccsDttm = LocalDateTime.now(ZoneOffset.UTC)
          item.update()
        }
      } else {
        println("Cstm user not found { userId: " + item?.userId + ", encPswd: " + param.encPswd + " != " + item?.pswd + "}")
      }
      // 2. if no user with the userid found
      return item
    }

  }

}

@NoArg
data class CstmUserToknData(val encToknVlue: String, val userId: String, val fingerprint: String, var prvsVlue: String? = null)
