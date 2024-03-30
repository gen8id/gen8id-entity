package id.g8id.api.enttcomp.bo

import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import io.quarkus.panache.common.Sort

class AtwkGrad : PanacheMongoEntity {

  constructor() : super()

  constructor(wrds: Int, grad: Int, ttpx: Long, gradCd: String) : super() {
    this.gradCd = gradCd
    this.wrds = wrds
    this.grad = grad
    this.ttpx = ttpx
  }

  lateinit var gradCd: String
  var wrds: Int = 0
  var grad: Int = 0
  var ttpx: Long? = null

  companion object: PanacheMongoCompanion<AtwkGrad> {
    fun findOptimizedImagePrice(adjtReslAvrg: Long): AtwkGrad {
      return list("{ ttpx : { \$lte: ?1 } }", adjtReslAvrg, Sort.descending("grad")).first()
    }

    fun findOptimizedPromptPrice(pmptLeng: Int): AtwkGrad {
      return list("{ wrds : { \$lte: ?1 } }", pmptLeng, Sort.descending("grad")).first()
    }

  }

}