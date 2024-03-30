package src.main.kotlin.id.g8id.api.entt.bo


import ai.bitflow.api.comn.antn.NoArg
import ai.bitflow.api.comn.cnst.*
import ai.bitflow.api.comn.rqst.CstmUserSearchRqst
import ai.bitflow.api.comn.rqst.CstmUserSignInRqst
import id.g8id.api.cnst.CreatorAdvantage
import id.g8id.api.cnst.CreatorRegistStat
import id.g8id.api.cnst.UserAgeVerify
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
    userAgent: String
  ) : super() {
    this.userId = userId
    this.pswd = pswd
    this.emal = emal
    this.dispName = dispName
    this.moblNo = moblNo
    this.userAgnt = userAgent
    this.rgstUserId = userId
    this.updtUserId = userId
  }

  var userId: String? = null
  var dispName: String? = null
  var firebaseUId: String? = null  // User id in Firebase
  var moblNo: String? = null
  var emal: String? = null
  var pswd: String? = null
  var lang: String? = null
  var bofcRgst: Boolean = true
  var userStts: String? = null
  var pvds: String? = null

  var pwErrCnt: Int = 0
  var stts: String? = null
  var ageVrfyCd: String? = UserAgeVerify.NO
  var crtrGrad: String? = null
  var userAgnt: String? = null

  // Vendor specific data
  var padlCstmId: String? = null
  var padlAddrId: String? = null
  var padlBsnsId: String? = null
  var padlTaxIdfy: String? = null
  var hyprWletUserTokn: String? = null
  var hyprWletUserStat: String? = null
  var hyprWletCretOn: LocalDateTime? = null
  var hyprWletClntUserId: String? = null
  var hyprWletPrflType: String? = null
  var rgstUserId: String? = null
  var updtUserId: String? = null
  var rgstDttm: LocalDateTime? = LocalDateTime.now(ZoneOffset.UTC)
  var updtDttm: LocalDateTime? = LocalDateTime.now(ZoneOffset.UTC)
  var lastAccsDttm: LocalDateTime? = null

  // Address
  var ctryCd: String? = null
  var zipCode: String? = null
  var stte: String? = null  //state
  var city: String? = null
  var frstName: String? = null
  var midlName: String? = null
  var lastName: String? = null
  var addrLine1: String? = null
  var addrLine2: String? = null

  var accsCtry: String? = null
  var natnCtry: String? = null
  var emailVerified: Boolean = false
  var rfshTokn: String? = null
  var setPassLatr: Boolean = true
  var pushKey: String? = null
  var telNo: String? = null
  var phtoUrl: String? = null
  var selrJoinStep: String? = null
  var buyrGrad: String? = null
  var crtrRgstStts: String? = CreatorRegistStat.NO
  var crtrAvtg: String? = CreatorAdvantage.NONE
  var userClass: String? = null
  var dormDttm: LocalDateTime? = null
  var wtwlDttm: LocalDateTime? = null


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

    fun getUsers(param: CstmUserSearchRqst): List<CstmUser> {
      val (query, params) = buildQueryAndParams(param)
      return find(query, Sort.by("rgstDttm").descending(), params).page(param.page - 1, 20).list()
    }

    fun countUsers(param: CstmUserSearchRqst): Long {
      val (query, params) = buildQueryAndParams(param)
      return count(query, params)
    }

    private fun buildQueryAndParams(param: CstmUserSearchRqst): Pair<String, MutableMap<String, Any?>> {
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
      return find("firebaseUId = :firebaseUId", Parameters.with("firebaseUId", id)).firstResult()
    }

    fun findByUserId(userId: String): CstmUser? {
      return find("userId = :userId", Parameters.with("userId", userId)).firstResult()
    }

    fun removeAllByIds(ids: List<ObjectId>): Long {
      return CstmUser.delete("_id in ?1", ids)
    }

    fun findByUserIdAndPswd(param: CstmUserSignInRqst): CstmUser? {

      val item = CstmUser.find("userId", param.userId).firstResult()

      if (item!=null) {
        // 1. if user with the userid found
        println("Found user at DB is " + item?.userId + " " + param.encPswd + " " + item?.pswd)

        if (item.pswd != param.encPswd) {
          // 1). if password does not match
          //      - password wrong count + 1
          //      - return no user found or locked
          item.pwErrCnt = item.pwErrCnt.plus(1)
          if (item.userStts== UserStatus.ACTIVE && item.pwErrCnt > 4) {
            item.userStts = UserStatus.LOCKED
          }

          item.updtDttm = LocalDateTime.now(ZoneOffset.UTC)
          item.updtUserId = param.userId
          item.update()

          if (item.pwErrCnt < 5) {
            item.userStts = UserStatus.WRONG_PW
          }

          // return as no user with the user info found
          return if (item.pwErrCnt < 5) {
            CstmUser(UserStatus.NOT_FOUND)
          } else {
            CstmUser(UserStatus.LOCKED)
          }
        } else {

          // 2) if password matched
          if (item.userStts == UserStatus.ACTIVE) {
            if (item.pwErrCnt > 4 ) {
              item.userStts = UserStatus.LOCKED
            } else {
              // 1.1.1. if user status is active
              item.pwErrCnt = 0
            }
          } else if (item.userStts == UserStatus.IN_REQUEST) {
          } else if (item.userStts == UserStatus.BANNED) {
          } else if (item.userStts == UserStatus.DORMANCY) {
          } else if (item.userStts == UserStatus.WITHDRAWAL) {
          } else {
          }

          // 1.1.2. stts - RQST, BNED, WTWL, DORM, LKED
          item.updtDttm = LocalDateTime.now(ZoneOffset.UTC)
          item.updtUserId = param.userId
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
data class CstmUserToknData(val encToknVlue: String, val userId: String, val ip: String, var prvsVlue: String? = null)