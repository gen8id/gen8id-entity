package id.g8id.api.data

import id.g8id.api.antn.NoArg
import org.bson.types.ObjectId

@NoArg
data class RqstImgItemData(
  var id: ObjectId? = null,
  var pblcId: String? = null,
  var grupId: String? = null,
  var pblcBigUrl: String? = null,
  var pblcThumUrl: String? = null,
  var cptn: String? = null,
  var qltyFcus: Double? = null,
  var byts: Long? = null,
  var ctntAgeGrad: String? = null,
  var wdth: Int? = null,
  var hegt: Int? = null,
  var ttpx: Long? = null,
  var adjtResl: Long? = null,
  var aiSgstKywdList: Set<String>? = null,
  var modrMap: Map<String, List<String>>? = null,
  var celbs: Set<String>? = null,
) {

}
