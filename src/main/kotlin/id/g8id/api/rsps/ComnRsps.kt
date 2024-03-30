package id.g8id.api.rsps

import id.g8id.api.antn.NoArg
import id.g8id.api.cnst.RspsCode
import java.io.Serializable

// code is for JSON inner status, not http status code
// eror is detailed err msg
@NoArg
open class ComnRsps<T> (var rslt: T?) {

    constructor (): this(null)

    var code: Int? = RspsCode.SUCCESS
    var mesg: String? = null

    fun setMsgNotFound(msg: String): ComnRsps<T> {
        if(rslt == null) {
            this.mesg = "Not Found Any $msg"
        }
        return this
    }
}

data class PaginatedRslt<out A, out B>(
    val items: A,
    val count: B
) : Serializable