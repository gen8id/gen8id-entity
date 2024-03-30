package id.g8id.api.rsps

import id.g8id.api.antn.NoArg

@NoArg
data class ImgListRsps<T>(
  val list: List<T>?
) {
  constructor(
    list: List<T>?
    , cnt: Int?
  ) : this(list) {
    this.cnt = cnt
  }
  var cnt: Int? = 0

}
