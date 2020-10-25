
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
        setToken(request);
      request.send() ;
       var snapsotresponse  =   JSON.parse(request.responseText)  ;
       console.log("Responss   e =" + request.responseText );
        return  snapsotresponse;
}
function getGenericList(pageid,currentPage,recordsPerPage)
{
    let request = new XMLHttpRequest () ;

    console.log(pageid);
    var from = currentPage * recordsPerPage;
    var to= from  + recordsPerPage;

    request.open("GET",url+'api/commonui/getPage?pageid='+ pageid + "&from=" + from + "&to=" + to,false);
    request.setRequestHeader("Content-type", "application/json");
     setToken(request);
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
     setToken(request);
    request.send() ;
    var snapsotresponse  =   JSON.parse(request.responseText)  ;
    console.log("Response =" + request.responseText );
     return  snapsotresponse;

}

function populateData(pkValue,entity)
{

    let request = new XMLHttpRequest () ;

    fullurl = url + 'api/commonui/getDataFromPK?entity=' + entity + "&pk=" + pkValue;
    request.open("GET",fullurl,false);
    request.setRequestHeader("Content-type", "application/json");
    request.send() ;
    var snapsotresponse  =   JSON.parse(request.responseText)  ;
    console.log("Response =" + request.responseText );

    ct = document.getElementById("frmgenericEdit").elements.length ;
    let postContent= { };
    for (i =0 ; i < ct ;i ++)
    {
       var edCtrl = document.getElementById("frmgenericEdit").elements[i];
       var jsonTag = document.getElementById("frmgenericEdit").elements[i].getAttribute("data-json");
       if (jsonTag != '' && jsonTag != null )
       {
            if (edCtrl.type == 'checkbox')
            {
                if (snapsotresponse[jsonTag] == true )
                    edCtrl.checked = true;
                else
                    edCtrl.checked = false;

            }else
            {
                edCtrl.value= snapsotresponse[jsonTag];
            }
       }


    }
//    alert('done');

}
function setToken (request)
{


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
}

function applyFilter( pageid,recordsPerPage,tableId,pkField)
{
    ct = document.getElementById("frmFilter").elements.length ;
    let postContent= { };

    for (i =0 ; i < ct ;i ++)
    {
           var ctrl = document.getElementById("frmFilter").elements[i];
           var propValue = ctrl.value;
           var propTag = ctrl.getAttribute("data-json");
            if (propValue != '' && propValue != null )
            {
              if(ctrl.type == 'checkbox')
               {
                  if (ctrl.checked == true )
                     postContent[propTag] = 'true';
                  else
                    postContent[propTag] = 'false';
               }else
               {
               postContent[propTag] = propValue;
               }
            }
    }
    document.getElementById("hdnAppliedFilter").value = JSON.stringify(postContent);
    console.log(postContent);

    reloadListWithContent(pageid,0,recordsPerPage,tableId,pkField);
}


function updateData(entity)
{
ct = document.getElementById("frmgenericEdit").elements.length ;
let postContent= { };

for (i =0 ; i < ct ;i ++)
{
   var ctrl = document.getElementById("frmgenericEdit").elements[i];
   var propValue = ctrl.value;
   var propTag = ctrl.getAttribute("data-json");

    if (propTag != '' && propTag != null )
    {
       if(ctrl.type == 'checkbox')
       {
          if (ctrl.checked == true )
             postContent[propTag] = 'true';
          else
            postContent[propTag] = 'false';
       }else
       {
       postContent[propTag] = propValue;
       }
   }


}
console.log(postContent);
console.log(entity);

fullurl = url + 'api/generic/update?entity=' + entity ;
let request = new XMLHttpRequest () ;
request.open("POST",fullurl,false);
setToken(request);

request.setRequestHeader("Content-type", "application/json");
request.setRequestHeader("Access-Control-Allow-Origin", url);
     request.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
        // alert('success');
        }else
        {
        // alert('error');
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


function saveData(entity)
{
ct = document.getElementById("frmgenericAdd").elements.length ;
let postContent= { };
for (i =0 ; i < ct ;i ++)
{
   var ctrl = document.getElementById("frmgenericAdd").elements[i];
      var propValue = ctrl.value;
      var propTag = ctrl.getAttribute("data-json");

       if (propTag != '' && propTag != null )
       {
          if(ctrl.type == 'checkbox')
          {
             if (ctrl.checked == true )
                postContent[propTag] = 'true';
             else
               postContent[propTag] = 'false';
          }else
          {
          postContent[propTag] = propValue;
          }
      }

}
console.log(postContent);
console.log(entity);

fullurl = url + 'api/generic/create?entity=' + entity ;
let request = new XMLHttpRequest () ;
request.open("POST",fullurl,false);
setToken(request);

request.setRequestHeader("Content-type", "application/json");
request.setRequestHeader("Access-Control-Allow-Origin", url);
     request.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
        // alert('success');
        }else
        {
         // alert('error');
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
    request.open("GET",url+'api/login/sayhello',true);
    request.setRequestHeader("Authorization", auth);
    setToken(request);
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
var lastClicked = 0;
function forceNav(pageid,recordsPerPage,tableId,pkField)
{

    var pgEntered = document.getElementById("txtNavCtrl").value;
    lastClicked =  pgEntered-1 ;
    reloadListWithContent(pageid,lastClicked,recordsPerPage,tableId,pkField);
}
function forceNextPageNav(pageid,recordsPerPage,tableId,pkField)
{
    lastClicked ++ ;
    reloadListWithContent(pageid,lastClicked,recordsPerPage,tableId,pkField);
}

function forcePrevPageNav(pageid,recordsPerPage,tableId,pkField)
{

    if (lastClicked >0 )
            lastClicked -- ;
    reloadListWithContent(pageid,lastClicked,recordsPerPage,tableId,pkField);
}
function reloadListWithContent(pageid,currentPage,recordsPerPage,tableId,pkField)
{
    let request = new XMLHttpRequest () ;
    lastClicked = currentPage;
    console.log(pageid);
    var from = currentPage * recordsPerPage;
    var to= from  + recordsPerPage;
    let hdnContent= document.getElementById("hdnAppliedFilter").value;
    postContent = {} ;
    if( hdnContent != '' )
        postContent = JSON.parse(hdnContent);

    alert(postContent);
    //postContent = {"code" :"CD102"};
    request.open("POST",url+'api/commonui/getListContent?pageid='+ pageid + "&from=" + from + "&to=" + to,false);
    request.setRequestHeader("Content-type", "application/json");
     setToken(request);
    request.send(JSON.stringify(postContent),true) ;
    var snapsotresponse  =   JSON.parse(request.responseText)  ;
    console.log("Response from reloadListWithContent =" + request.responseText );
    reRenderTable(tableId,pageid,snapsotresponse.data,pkField);

    var listElems = document.getElementsByName("navListItem") ;
    for (i = 0; i < listElems.length ; i ++ )
    {
            if( i == currentPage)
                listElems[i].className = "page-item  active";
            else
                listElems[i].className = "page-item";

    }
}


function reRenderTable(tableId,entity, data,pkField)
{
        var dataTable = document.getElementById(tableId);
         console.log(dataTable.rows);
        while (dataTable.rows.length > 1) {
                console.log(dataTable.rows.length);
                dataTable.deleteRow(dataTable.rows.length -1 );
        }

        for ( var i in data) {
               singleRow=  data[i];
               //innerContent = "<tr>";
               innerContent = " ";
               innerContent =  innerContent + '<td><input type="checkbox" id="checkbox2" name="options[]" value="' + singleRow[pkField] + '"></td>';
               for ( var i in fields) {
                  var field = fields[i];
                  if (field.ListPageBV != 'IGNORE')
                  {
                    if (field.DisplayControl == 'CheckBox'){
                        if ( singleRow[field.FieldName] == true)
                             innerContent = innerContent + '<td> &#10004 </td>';
                        else
                              innerContent = innerContent + '<td></td>' ;
                    }else {
                        innerContent = innerContent + '<td>' + singleRow[field.FieldName] + '</td>';
                      }
                  }
               }
                innerContent = innerContent + '<td>';
                innerContent = innerContent + '<a href="#editDataModel" class="edit" onClick = "populateData(\''+singleRow[pkField]+'\',\'' + entity + '\');" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>';
                innerContent = innerContent + '&nbsp';
                innerContent = innerContent + '<a href="#deleteDataModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>';
                innerContent = innerContent + '</td>';
             //   innerContent = innerContent + "</tr>";

                var newrow = dataTable.insertRow();
                newrow.innerHTML =  innerContent;
            }
}