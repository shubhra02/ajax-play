package services

import models.PersonSignup
import play.api.cache

import scala.collection.mutable.ListBuffer

/**
  * Created by knoldus on 11/3/17.
  */
class PersonData {

  def personExist(email: String): Boolean = {
    val users = AddPerson.listPerson
    val result = users.filter(data => data.email == email)

    if (result.length == 1)
      false
    else true
  }


  def getPerson(email: String) = {
    val users = AddPerson.listPerson
    val result = users.filter(data => data.email == email)

  if (result.length == 1) {

    result.filter(data => (data.email == email))(0)
  } else
    PersonSignup("","","","","","")
}

    def checkPerson(email: String, password: String): Boolean = {
      val users = AddPerson.listPerson
      val result = users.filter(data => (data.email == email && data.password == password))
      if(result.length == 1)
        true
      else false

    }

}
