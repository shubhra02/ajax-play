package controllers

import javax.inject._

import models.PersonSignup
import play.api._
import play.api.mvc._
import services.{AddPerson, PersonData}


@Singleton
class HomeController @Inject()(personService: PersonData) extends Controller {

  def welcome=Action {
    Ok(views.html.main(views.html.signin()))
  }

  def signUp=Action {
    Ok(views.html.signup())
  }


  def logout = Action {
    Ok(views.html.signin()).withNewSession
  }

  def loginSubmit(email: String) = Action { implicit request =>

    val userLogin=personService.getPerson(email)
    if (personService.checkPerson(userLogin.email, userLogin.password)) {

      Ok(views.html.profile(userLogin)).withSession("connected" -> userLogin.email)
    }
    else {
      Ok(views.html.signin()).withNewSession
    }
  }


  def submit(firstName:String, lastName:String, email: String, password:String, rePassword:String, phone:String)=Action { implicit request =>

    val person = PersonSignup(firstName, lastName, email,password,rePassword,phone)
    if(personService.personExist(person.email)) {
      AddPerson.listPerson.append(person)
      Ok(views.html.profile(person)).withSession("connected" -> person.email)
    }else {
      Ok("UserName Already Exists")
    }
  }




}
