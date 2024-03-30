package id.g8id.api.data

import ai.bitflow.api.comn.entt.CodeMast
import id.g8id.api.antn.NoArg
import io.quarkus.mongodb.panache.common.ProjectionFor

@NoArg
@ProjectionFor(CodeMast::class)
class CodeData{

  constructor()

  constructor(grupCode: String, code: String, name: String, valu: String?, ordr: Int?) : this() {
    this.grupCode = grupCode
    this.code = code
    this.name = name
    this.valu = valu
    this.ordr = ordr
  }

  lateinit var grupCode: String
  lateinit var code: String
  var name: String? = null
  var valu: String? = null
  var ordr: Int? = null

}
