package src.main.kotlin.id.g8id.api.entt.bo


import ai.bitflow.api.comn.cnst.UserStatus
import ai.bitflow.api.comn.rqst.BofcSignInRqst
import ai.bitflow.api.comn.rqst.BofcUserSearchRqst
import ai.bitflow.api.comn.rqst.CodeRqst
import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import org.bson.types.ObjectId
import java.time.LocalDateTime
import java.time.ZoneOffset


class BofcUser : PanacheMongoEntity {

  constructor() : super()

  constructor(stts: String) : super() {
    this.stts = stts
  }

  constructor(
    dispName: String
    , userId: String
    , emal: String
    , moblNo: String
    , role: String
    , pswd: String
    , rgstUserId: String
  ) : super() {
    this.dispName = dispName
    this.userId = userId
    this.emal = emal
    this.moblNo = moblNo
    this.role = role
    this.pswd = pswd
    this.rgstUserId = rgstUserId
    this.updtUserId = rgstUserId
    this.stts = UserStatus.ACTIVE
  }

  var userId: String? = null
  var pswd: String? = null
  var emal: String? = null
  var rfshTokn: String? = null
  var dispName: String? = null
  var moblNo: String? = null
  var stts: String? = null
  var jobTitl: String? = null
  var role: String? = null
  var phtoUrl: String? = null

  var lang: String? = null

  var pwErrCnt: Int = 0
  var lastAccDttm: LocalDateTime? = null
  var dormDttm: LocalDateTime? = null
  var wtwlDttm: LocalDateTime? = null

  var rgstUserId: String? = null
  var updtUserId: String? = null
  var rgstDttm: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)
  var updtDttm: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)

  companion object: PanacheMongoCompanion<BofcUser> {

    /**
     * e.g. find("userId = :userId and pswd = :pswd", Parameters.with("userId", userId).and("pswd", pswd))
     */
    fun findByUserIdAndPswd(param: BofcSignInRqst): BofcUser? {

      val item = find("userId", param.userId).firstResult()

      println("Found user at DB is " + item?.userId + " " + param.encPswd + " " + item?.pswd)

      if (item!=null) {
        // 1. if user with the userid found

        if (item.pswd != param.encPswd) {
          // 1). if password does not match
          //      - password wrong count + 1
          //      - return no user found or locked
          item.pwErrCnt = item.pwErrCnt.plus(1)
          if (item.stts==UserStatus.ACTIVE && item.pwErrCnt > 4) {
            item.stts = UserStatus.LOCKED
          }

          item.updtDttm = LocalDateTime.now(ZoneOffset.UTC)
          item.updtUserId = param.userId
          item.update()

          if (item.pwErrCnt < 5) {
            item.stts = UserStatus.WRONG_PW
          }

          val hist = BofcSginHist(
            param.userId
            , item.stts
            , param.userAgent!!
            , param.ip!!
            , param.host
            , param.lang
            , param.ctnt
            , param.ctry
            , param.regn
            , param.city
            , param.pfrm
            , param.pvdr
          )
          hist.persist()

          // return as no user with the user info found
          return if (item.pwErrCnt < 5) {
            BofcUser(UserStatus.NOT_FOUND)
          } else {
            BofcUser(UserStatus.LOCKED)
          }
        } else {

          // 2) if password matched
          if (item.stts == UserStatus.ACTIVE) {
            // 1.1.1. if user status is active
            item.pwErrCnt = 0
            item.lang = param.lang
          } else if (item.stts == UserStatus.LOCKED) {
          } else if (item.stts == UserStatus.IN_REQUEST) {
          } else if (item.stts == UserStatus.BANNED) {
          } else if (item.stts == UserStatus.DORMANCY) {
          } else if (item.stts == UserStatus.WITHDRAWAL) {
          } else {
          }

          // 1.1.2. stts - RQST, BNED, WTWL, DORM, LKED
          item.lastAccDttm = LocalDateTime.now(ZoneOffset.UTC)
          item.update()

          val hist = BofcSginHist(
            param.userId
            , item.stts
            , param.userAgent!!
            , param.ip!!
            , param.host
            , param.lang
            , param.ctnt
            , param.ctry
            , param.regn
            , param.city
            , param.pfrm
            , param.pvdr
          )
          hist.persist()

        }
      }
      // 2. if no user with the userid found
      return item
    }

    fun findByUserId(param: BofcSignInRqst): BofcUser? {

      val item = find("userId", param.userId).firstResult()

      if (item!=null) {
          if (item.stts == UserStatus.ACTIVE) {
            // 1.1.1. if user status is active
            item.pwErrCnt = 0
            item.lang = param.lang
          } else if (item.stts == UserStatus.LOCKED) {
          } else if (item.stts == UserStatus.IN_REQUEST) {
          } else if (item.stts == UserStatus.BANNED) {
          } else if (item.stts == UserStatus.DORMANCY) {
          } else if (item.stts == UserStatus.WITHDRAWAL) {
          } else {
          }

          // 1.1.2. stts - RQST, BNED, WTWL, DORM, LKED
          item.lastAccDttm = LocalDateTime.now(ZoneOffset.UTC)
          item.update()

          val hist = BofcSginHist(
            param.userId
            , item.stts
            , param.userAgent!!
            , param.ip!!
            , param.host
            , param.lang
            , param.ctnt
            , param.ctry
            , param.regn
            , param.city
            , param.pfrm
            , param.pvdr
          )
          hist.persist()
      }
      return item
    }

    fun update(param: CodeRqst) {
      var item = CodeMast.findById(ObjectId(param.id))
      if (item!=null) {
        CodeMast.update(item)
      }

    }

    // Paginated user request
    fun getUsers(param: BofcUserSearchRqst): List<BofcUser> {
      val (query, params) = buildQueryAndParams(param)
      return find(query, params).page(param.page - 1, 8).list()
    }

    fun countUsers(param: BofcUserSearchRqst): Long {
      val (query, params) = buildQueryAndParams(param)
      return count(query, params)
    }

    private fun buildQueryAndParams(param: BofcUserSearchRqst): Pair<String, MutableMap<String, Any?>> {
      val params = param.toRqstMap()
      val queryParts: MutableList<String> = ArrayList()
      if (params["dispName"] != null) queryParts.add("dispName like :dispName")
      if (params["sttsStr"] != null) queryParts.add("stts = :sttsStr")
      if (params["roleStr"] != null) queryParts.add("role = :roleStr")
      val query = if (queryParts.size != 0) queryParts.joinToString(" and ") else "{}"
      return Pair(query, params)
    }

  }

}