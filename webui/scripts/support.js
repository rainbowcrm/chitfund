
class SessionUser {

 constructor(firstName,lastName,sessionId)
 {
 this.firstName =firstName;
 this.lastName = lastName;
 this.sessionId = sessionId

 }
}

sessionUser = new SessionUser('','','')
 url = "http://chitapp:20220/"
//--disable-web-security --disable-gpu --user-data-dir=~/chromeTem

function getMenus()
{
     let request = new XMLHttpRequest () ;

     request.open("GET",url+'api/application/getMenus',false);
     request.setRequestHeader("Content-type", "application/json");

      request.send() ;
       var snapsotresponse  =   JSON.parse(request.responseText)  ;
       console.log("Responss   e =" + request.responseText );
        return  snapsotresponse;
}

function login()
    {
        var name = document.getElementById("txtname").value ;
        var pwd =  document.getElementById("txtpwd").value ;
    var data = {
        "userId" : name,
        "pwd" : pwd
    };
     let request = new XMLHttpRequest () ;

    request.open("POST",url+'api/login/checkLogin',false);
     request.setRequestHeader("Content-type", "application/json");
        request.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
        // Typical action to be performed when the document is ready:
         responseObject = JSON.parse(request.responseText);
         sessionUser.firstName =responseObject.FirstName;
         sessionUser.lastName =responseObject.LastName ;
         sessionUser.sessionId = responseObject.sessionId;
         console.log(sessionUser);
         localStorage = window.localStorage;
         localStorage.setItem("userFirstName", sessionUser.firstName);
         localStorage.setItem("userLastName", sessionUser.lastName);
         localStorage.setItem("userSession", sessionUser.sessionId);

         window.location.href = './bopages/bolanding.html'
        }else
        {
         document.getElementById("erromessage").innerHTML ="Authorization failed";
        }
    };

    try {
       request.send(JSON.stringify(data),true) ;
    }catch(err)
    {
     document.getElementById("erromessage").innerHTML ="Authorization failed";
    }

    return false;
    }

