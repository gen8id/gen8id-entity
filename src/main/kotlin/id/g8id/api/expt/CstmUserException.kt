package id.g8id.api.expt

import id.g8id.api.cnst.RspsCode
import id.g8id.api.rsps.ComnRsps
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.ext.ExceptionMapper
import jakarta.ws.rs.ext.Provider
import java.io.Serializable

@Provider
class CstmUserExceptionHandler : ExceptionMapper<CstmUserException> {

  override fun toResponse(e: CstmUserException): Response {

    val content = ComnRsps<Any?>()
    // println("class: ${e.javaClass.simpleName}, message: ${e.message}")

    if (e is CstmUserAlreadyExistException) {

      content.code = RspsCode.USER_EXIST
      return Response.status(Response.Status.OK).entity(content).build()

    } else if (e is CstmUserPswdNotSetException) {

      content.code = RspsCode.REG_WITH_OTHER
      return Response.status(Response.Status.OK).entity(content).build()

    } else if (e is CstmUserEmalNotVrfd) {

      content.code = RspsCode.EMAIL_NOT_VERIFIED
      return Response.status(Response.Status.OK).entity(content).build()

    } else {

      println("class: ${e.javaClass.simpleName}, message: ${e.message}")

      // if (!e.message.isNullOrEmpty()) {
      //   content.mesg = e.message!!.split("\n")[0]
      // }
      e.printStackTrace()
      return Response.status(Response.Status.GONE).build()

    }

  }

}

open class CstmUserException : RuntimeException, Serializable {
  constructor()
  constructor(message: String?) : super(message)
  constructor(message: String?, cause: Throwable?) : super(message, cause)
  constructor(cause: Throwable?) : super(cause)
  constructor(
    message: String?, cause: Throwable?,
    enableSuppression: Boolean, writableStackTrace: Boolean
  ) : super(message, cause, enableSuppression, writableStackTrace)

  companion object {
    private const val serialVersionUID = 2L
  }
}

open class CstmUserSignException : CstmUserException {
  constructor()
  constructor(message: String?) : super(message)
}

open class CstmUserRegisterException : CstmUserException {
  constructor()
  constructor(message: String?) : super(message)
}

class CstmUserPswdNotSetException : CstmUserSignException {
  constructor()
  constructor(message: String?) : super(String.format("User was registered with social networks and does not have a password. (No password) Providers:$message"))
}

class CstmUserNotFoundException() :
  CstmUserSignException("There is no user with such ID and password. (No user)") {

}

class CstmUserNotActiveException : CstmUserSignException {
  constructor()
  constructor(message: String?) : super(String.format("User status is: ${message}. (Not Active)"))
}

class CstmUserInvalidTokenException() :
  CstmUserSignException("Invalid User Token")

class CstmUserNoSocialUserException() :
  CstmUserSignException("There is no user signed up with social network. (No social)") {

}

class CstmUserEmalNotVrfd() : CstmUserSignException("User's email not verified yet. (Not verified)")

class CstmUserAlreadyExistException :
  CstmUserRegisterException("User already exist. (User exists)") {

}

class CstmUserPersistException :
  CstmUserRegisterException("Unable to persist user to DB. (Unable persist)") {

}
class HyprWletDuplicatedUserException() :
    CstmUserException("Duplicate hyper wallet client user id")

class HyprWletNotRegisteredException():
    CstmUserException("Not registered with hyperwallet")