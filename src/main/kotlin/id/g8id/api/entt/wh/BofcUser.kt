package id.g8id.api.entt.wh.entt


import id.g8id.api.cnst.UserStatus
import id.g8id.api.rqst.BofcSignInRqst
import id.g8id.api.rqst.BofcUserSearchRqst
import id.g8id.api.rqst.CodeRqst
import id.g8id.api.util.AuthUser
import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import org.bson.types.ObjectId
import java.time.LocalDateTime
import java.time.ZoneOffset


class BofcUser : PanacheMongoEntity, AuthUser {

  constructor() : super()

  constructor(stts: String) : super() {
    this.stts = stts
  }

  constructor(
    userId: String,
    pswd: String,
    emal: String,
    userAgent: String?,
    rgstDttm: LocalDateTime,
    updtDttm: LocalDateTime
  ) : super() {
    this.userId = userId
    this.pswd = pswd
    this.email = emal
    this.userAgent = userAgent
    this.rgstUserId = userId
    this.updtUserId = userId
    this.rgstDttm =  LocalDateTime.now(ZoneOffset.UTC)
    this.updtDttm =  LocalDateTime.now(ZoneOffset.UTC)
  }

  constructor(
    userId: String,
    pswd: String,
    emal: String,
    dispName: String?,
    moblNo: String?,
    rgstUserId: String,
    userAgent: String?,
    rgstDttm: LocalDateTime,
    updtDttm: LocalDateTime
  ) : super() {
    this.userId = userId
    this.pswd = pswd
    this.email = emal
    this.dispName = dispName
    this.moblNo = moblNo
    this.userAgent = userAgent
    this.rgstUserId = rgstUserId
    this.updtUserId = rgstUserId
    this.rgstDttm =  LocalDateTime.now(ZoneOffset.UTC)
    this.updtDttm =  LocalDateTime.now(ZoneOffset.UTC)
  }

  var userId: String? = null
  var pswd: String? = null
  var email: String? = null
  override var rfshTokn: String? = null
  var dispName: String? = null
  var moblNo: String? = null
  var rgstUserId: String? = null
  var updtUserId: String? = null
  var stts: String? = null
  var jobTitle: String? = null
  var role: String? = null
  var rgstDttm: LocalDateTime? = null
  var updtDttm: LocalDateTime? = null

  var tftrMthd: String? = null
  var prvdGgle: String? = null
  var prvdFcbk: String? = null
  var prvdTwtr: String? = null
  var prvdAppl: String? = null
  var phtoUrl: String? = null

  var cmpn: String? = null
  var dptm: String? = null

  var telNo: String? = null
  var userCi: String? = null
  var pushKey: String? = null
  var lang: String? = null
  var cont: String? = null
  var stte: String? = null
  var pwErrCnt: Int = 0
  var aprvUserId: String? = null

  var userAgent: String? = null
  var aprvDttm: LocalDateTime? = null
  var lastAccDttm: LocalDateTime? = null
  var dormDttm: LocalDateTime? = null
  var wtwlDttm: LocalDateTime? = null

  var ctnt: String? = null
  var ctry: String? = null
  var regn: String? = null
  var regnCd: String? = null
  var city: String? = null

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
          if (item.stts == UserStatus.LOCKED) {
          } else if (item.stts == UserStatus.IN_REQUEST) {
          } else if (item.stts == UserStatus.BANNED) {
          } else if (item.stts == UserStatus.DORMANCY) {
          } else if (item.stts == UserStatus.WITHDRAWAL) {
          } else if (item.stts == UserStatus.ACTIVE) {
            // 1.1.1. if user status is active
            item.pwErrCnt = 0
            item.ctnt = param.ctnt
            item.ctry = param.ctry
            item.regn = param.regn
            item.city = param.city
            item.lang = param.lang
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
          )
          hist.persist()

        }
      }
      // 2. if no user with the userid found
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