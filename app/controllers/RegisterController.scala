package controllers

import models.PersonSignup
import play.api.data._
import play.api.data.Forms._
import play.api.mvc.Controller

class RegisterController extends Controller {

  val signupData: Form[PersonSignup] = Form(
    mapping(
      "firstName" -> nonEmptyText,
      "lastName" -> nonEmptyText,
      "email" -> nonEmptyText,
      "password" -> nonEmptyText,
      "rePassword" -> nonEmptyText,
      "phone" -> text
    )(PersonSignup.apply)(PersonSignup.unapply)
  )
}
