/*if (window.console) {
  console.log("Welcome to your Play application's JavaScript!");
}*/

$(document).ready(function(){
//Login Button
$('#login').on("click",function(){
jsRoutes.controllers.HomeController.loginSubmit($('#email').val()).ajax({
success: function(data){
$('#mainbody').html(data);
},
error: function(){
alert("No Data Found")
}

})
})

//Register Button
$('#register').on("click",function(){
jsRoutes.controllers.HomeController.signUp().ajax({
success: function(data){
$('#mainbody').html(data);

},
error: function(){
alert("No Data Found")
}
})
})

//signup form
$('#signup').on("click",function(){
jsRoutes.controllers.HomeController.submit($('#firstName').val(),$('#lastName').val(),$('#email').val(),
                                             $('#password').val(),$('#rePassword').val(),$('#phone').val()).ajax({
success: function(data){
$('#mainbody').html(data);
},
error: function(){
alert("No Data Found")
}

})
})

$('#logout').on("click",function(){
jsRoutes.controllers.HomeController.logout().ajax({
success: function(data){
$('#mainbody').html(data);
},
error: function(){
alert("No Data Found")
}
})
})

});