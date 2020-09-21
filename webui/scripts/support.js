
class SessionUser {

 constructor(firstName,lastName,sessionId)
 {
 this.firstName =firstName;
 this.lastName = lastName;
 this.sessionId = sessionId

 }
}

sessionUser = new SessionUser('','','')
 url = "http://localhost:20220/"
//--disable-web-security --disable-gpu --user-data-dir=~/chromeTem

function populateData(pkValue,entity)
{
alert(pkValue);
alert(entity);
}


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
    console.log(pageid);
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
function saveData(entity)
{
ct = document.getElementById("frmgenericAdd").elements.length ;
let postContent= { };
for (i =0 ; i < ct ;i ++)
{
   var propValue = document.getElementById("frmgenericAdd").elements[i].value;
   var propTag = document.getElementById("frmgenericAdd").elements[i].getAttribute("data-json");
   if (propTag != '' && propTag != null )
        postContent[propTag] = propValue;
}
console.log(postContent);
console.log(entity);

fullurl = url + 'api/generic/create?entity=' + entity ;
let request = new XMLHttpRequest () ;
request.open("POST",fullurl,false);

                var allcookies = document.cookie;
               cookiearray = allcookies.split(';');

               for(var i=0; i<cookiearray.length; i++) {
                  name = cookiearray[i].split('=')[0];
                  value = cookiearray[i].split('=')[1];
                 console.log ("Key is : " + name + " and Value is : " + value);
                  if(name.trim() =='XSRF-TOKEN') {
                      request.setRequestHeader("X-XSRF-TOKEN", value);
                      console.log('added x-xsrf-token');
                      }
               }

request.setRequestHeader("Content-type", "application/json");
request.setRequestHeader("Access-Control-Allow-Origin", url);
     request.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
         alert('success');
        }else
        {
         alert('error');
        }

    };

    try {
       request.send(JSON.stringify(postContent),true) ;
    }catch(err)
    {
     document.getElementById("erromessage").innerHTML ="Authorization failed";
    }
return false;
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
       // alert(document.cookie);
    return false;
    }

