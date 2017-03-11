package models


case class PersonSignup (
                          firstName : String,
                          lastName : String,
                          email: String,
                          password: String,
                          rePassword:String,
                          phone: String

                        )


case class PersonSignin (
                        email:String,
                        password: String
                        )