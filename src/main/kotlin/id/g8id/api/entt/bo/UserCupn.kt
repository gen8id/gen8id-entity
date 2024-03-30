package src.main.kotlin.id.g8id.api.entt.bo

import ai.bitflow.api.comn.rqst.UserCupnRgstRqst
import ai.bitflow.api.comn.rqst.UserCupnSrchRqst
import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import io.quarkus.panache.common.Sort
import org.bson.types.ObjectId
import java.math.BigInteger
import java.security.MessageDigest
import java.time.LocalDateTime
import java.time.ZoneOffset

class UserCupn() : PanacheMongoEntity() {

  constructor(param: UserCupnRgstRqst) : this() {
    this.cupnType = param.cupnType
    this.actvPerd = param.actvPerd
  }

  var cupnCode: String = ""
  var cupnType: String = ""
  var issuDttm: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)
  var asgnUserId: String = ""
  var issuUserId: String = ""
  var actvPerd: Int = 0
  var abutCupn: String? = null
  var asgnDttm: LocalDateTime? = null
  var actv: Boolean = true
  var updtDttm: LocalDateTime? = null
  var updtUserId: String? = null

  companion object: PanacheMongoCompanion<UserCupn> {
    private const val ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_-"
    private const val DATE_LENGTH = 30

    private val deTree: HashMap<String?, Char?> = object : HashMap<String?, Char?>() {
      init {
        ALPHABET.forEachIndexed { index, c ->
          put(index.toString(2).padStart(6, '0'), c)
        }
      }
    }

    private val enTree: HashMap<Char?, String?> = object : HashMap<Char?, String?>() {
      init {
        ALPHABET.forEachIndexed { index, c ->
          put(c, index.toString(2).padStart(6, '0'))
        }
      }
    }

    fun getCode(cpon: UserCupn): String {
      val issueDate = cpon.issuDttm.toString().substring(2, 10).replace("-", "")
      val until = cpon.actvPerd.toString().padStart(3, '0')

      val date = (issueDate + until).toInt().toString(2).padStart(30, '0')
      val binStr = date + mapToBinString(cpon.asgnUserId.padEnd(10, '-'))
      val negStr = negotiate(binStr)
      val encoded = mapToCharString(negStr)

      return encoded + getHashChar(encoded)
    }

    fun getClaims(text: String): Map<String, String> {
      val binStr = mapToBinString(text.substring(0, 15))
      val negStr = negotiate(binStr!!)
      val date = negStr.substring(0, 30)
      val issueDate = date.toInt(2) / 1000
      val until = date.toInt(2) % 1000
      val username = mapToCharString(negStr.substring(30, 90)).replace("-", "")
      return hashMapOf("issueDate" to issueDate.toString(), "until" to until.toString(), "username" to username)
    }

    /**
     * Validate coupon by checking hashsumm
     */
    fun validate(text: String): Boolean {
      return getHashChar(text.substring(0, -1)).toString() == text.takeLast(1)

    }

    @OptIn(ExperimentalStdlibApi::class)
    private fun getHashChar(text: String): Char? {
      val hash = MessageDigest.getInstance("SHA-256").digest(text.toByteArray(Charsets.UTF_8))
      return deTree[(hash.toHexString().toBigInteger(16) % BigInteger.valueOf(64)).toString(2).padStart(6, '0')]
    }

    private fun mapToBinString(username: String): String? {
      return username.map { enTree[it] }.reduce { acc, s -> acc + s }
    }

    private fun negotiate(binStr: String): String {
      val negotiator = "1".repeat(binStr.length).toBigInteger(2)
      return binStr.toBigInteger(2).xor(negotiator).toString(2).padStart(90, '0')
    }

    private fun mapToCharString(text: String): String {
      val sb = StringBuilder()
      for (i in 0..<text.length / 6) {
        sb.append(deTree[text.substring(i * 6, i * 6 + 6)])
      }
      return sb.toString();
    }

    fun removeAllByIds(ids: List<ObjectId>): Long {
      return delete("_id in ?1", ids)
    }

    fun getAnnouncements(param: UserCupnSrchRqst): List<UserCupn> {
      val (query, params) = buildQueryAndParams(param)
      return find(query, Sort.by("issuDttm").descending(), params).page(param.page - 1, param.btchSize).list()
    }

    fun countAnnouncements(param: UserCupnSrchRqst): Long {
      val (query, params) = buildQueryAndParams(param)
      return count(query, params)
    }

    private fun buildQueryAndParams(param: UserCupnSrchRqst): Pair<String, MutableMap<String, Any?>> {
      val params = param.toRqstMap()
      val queryParts: MutableList<String> = ArrayList()
      if (params["abutCupn"] != null) queryParts.add("abutCupn like :abutCupn")
      if (params["actv"] != null) queryParts.add("actv = :actv")
      if (params["cupnCode"] != null) queryParts.add("cupnCode like :cupnCode")
      if (params["asgnUserId"] != null) queryParts.add("asgnUserId like :asgnUserId")
      val query = if (queryParts.size != 0) queryParts.joinToString(" and ") else "{}"
      return Pair(query, params)
    }
  }

}