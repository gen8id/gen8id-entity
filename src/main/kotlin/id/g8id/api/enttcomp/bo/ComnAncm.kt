package id.g8id.api.enttcomp.bo

import id.g8id.api.rqst.AncmSearchRqst
import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import io.quarkus.panache.common.Sort
import org.bson.types.ObjectId
import java.time.LocalDateTime

class ComnAncm : PanacheMongoEntity {

    constructor() : super()

    constructor(revNo: String, title: String, body: String, ancmType: String): super() {
        this.revNo = revNo
        this.title = title
        this.body = body
        this.ancmType = ancmType
    }

    var revNo: String? = null
    var title: String? = null
    var body: String? = null
    var ancmType: String? = null
    var applySince: LocalDateTime? = null
    var applyUntil: LocalDateTime? = null
    var rgstDttm: LocalDateTime? = null
    var lastUpdtID: String? = null
    var lstUpdtDttm: LocalDateTime? = null
    var display: Boolean? = false

    companion object: PanacheMongoCompanion<ComnAncm> {

        fun getAnnouncements(param: AncmSearchRqst): List<ComnAncm> {
            val (query, params) = buildQueryAndParams(param)
            return ComnAncm.find(query, Sort.by("applySince").descending(), params).page(param.page - 1, 5).list()
        }

        fun countAnnouncements(param: AncmSearchRqst): Long {
            val (query, params) = buildQueryAndParams(param)
            return ComnAncm.count(query, params)
        }

        private fun buildQueryAndParams(param: AncmSearchRqst): Pair<String, MutableMap<String, Any?>> {
            val params = param.toRqstMap()
            val queryParts: MutableList<String> = ArrayList()
            if (params["title"] != null) queryParts.add("title like :title")
            if (params["ancmType"] != null) queryParts.add("ancmType = :ancmType")
            if (params["applySince"] != null) queryParts.add("applySince >= :applySince")
            if (params["applyUntil"] != null) queryParts.add("(applyUntil = null or applyUntil <= :applyUntil)")
            val query = if (queryParts.size != 0) queryParts.joinToString(" and ") else "{}"
            return Pair(query, params)
        }

        fun removeAllByIds(ids: List<ObjectId>): Long {
            return ComnAncm.delete("_id in ?1", ids)
        }

    }
}