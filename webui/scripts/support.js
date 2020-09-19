
class SessionUser {

 constructor(firstName,lastName,sessionId)
 {
 this.firstName =firstName;
 this.lastName = lastName;
 this.sessionId = sessionId

 }
}

sessionUser = new SessionUser('','','')
 url = "https://localhost:20220/"
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
function getGenericList(pageid)
{
    let request = new XMLHttpRequest () ;
    request.open("GET",url+'api/commonui/getPage?pageid='+ pageid,false);
    request.setRequestHeader("Content-type", "application/json");
    request.send() ;
    var snapsotresponse  =   JSON.parse(request.responseText)  ;
    console.log("Responss   e =" + request.responseText );
     return  snapsotresponse;

}

function getPageCreate(pageid)
{
    let request = new XMLHttpRequest () ;
    request.open("GET",url+'api/commonui/getPage?pageid='+ pageid,false);
    request.setRequestHeader("Content-type", "application/json");
    request.send() ;
    var snapsotresponse  =   JSON.parse(request.responseText)  ;
    console.log("Responss   e =" + request.responseText );
     return  snapsotresponse;

}

function showPage(pageName)
{
 document.getElementById("ifrmContent").src=pageName;
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
    auth = "Basic " + btoa(name + ":" + pwd);
    request.open("GET",url+'api/login/sayhello',false);
    request.setRequestHeader("Authorization", auth);
     request.setRequestHeader("Content-type", "application/json");
        request.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
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

