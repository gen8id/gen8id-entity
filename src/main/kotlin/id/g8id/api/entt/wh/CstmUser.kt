package id.g8id.api.entt.wh.entt


import id.g8id.api.cnst.*
import id.g8id.api.rqst.CstmUserSearchRqst
import id.g8id.api.rqst.CstmUserSignInRqst
import id.g8id.api.util.AuthUser
import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import io.quarkus.mongodb.panache.kotlin.PanacheQuery
import io.quarkus.panache.common.Parameters
import io.quarkus.panache.common.Sort
import org.bson.types.ObjectId
import java.time.LocalDateTime
import java.time.ZoneOffset


class CstmUser : PanacheMongoEntity, AuthUser {

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
    this.userAgent = userAgent
    this.rgstUserId = userId
    this.updtUserId = userId
    this.crtrGrad = CreatorGrade.LEVEL_1
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
    this.userAgent = userAgent
    this.rgstUserId = rgstUserId
    this.updtUserId = rgstUserId
    this.crtrGrad = CreatorGrade.LEVEL_1
  }

  var userId: String = ""
  var firebaseUId: String? = null
  var prvdGgle: String? = null
  var prvdFcbk: String? = null
  var prvdTwtr: String? = null
  var prvdAppl: String? = null
  var moblNo: String? = null
  var emal: String = ""
  var emailVerified: Boolean = false
  var pswd: String? = null
  override var rfshTokn: String? = null
  var setPassLatr: Boolean = true
  var dispName: String? = null
  var userCi: String? = null
  var pushKey: String? = null
  var telNo: String? = null
  var lang: String? = null
  var ctry: String? = null
  var stte: String? = null
  var bofcRgst: Boolean = true
  var userStts: String? = null
  var phtoUrl: String? = null
  var pwErrCnt: Int = 0
  var selrJoinStep: String? = null
  var buyrGrde: String? = null
  var crtrGrde: String? = null
  var ageVrfyCd: String? = AgeVerified.NO
  var crtrRgstStts: String? = CreatorRgstStats.NO
  var crtrGrad: String? = null
  var crtrAvtg: String? = CreatorAdvantage.NO_ADVNTG
  var userClass: String? = null

  var hyprWletUserTokn: String? = null
  var hyprWletUserStat: String? = null
  var userAgent: String? = null
  var rgstUserId: String? = null
  var updtUserId: String? = null
  var rgstDttm: LocalDateTime? = LocalDateTime.now(ZoneOffset.UTC)
  var updtDttm: LocalDateTime? = LocalDateTime.now(ZoneOffset.UTC)
  var lastAccDttm: LocalDateTime? = null
  var dormDttm: LocalDateTime? = null
  var wtwlDttm: LocalDateTime? = null


  companion object: PanacheMongoCompanion<CstmUser> {

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

    fun removeAllByIds(ids: List<ObjectId>): Long {
      return CstmUser.delete("_id in ?1", ids)
    }

    fun findByUserIdAndPswd(param: CstmUserSignInRqst): CstmUser? {

      val item = CstmUser.find("userId", param.userId).firstResult()

      println("Found user at DB is " + item?.userId + " " + param.encPswd + " " + item?.pswd)

      if (item!=null) {
        // 1. if user with the userid found

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
          item.lastAccDttm = LocalDateTime.now(ZoneOffset.UTC)
          item.update()
        }
      }
      // 2. if no user with the userid found
      return item
    }

  }

}