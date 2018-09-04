

var ajaxRequest;

function ajaxFunction(){
 try{
   // Opera 8.0+, Firefox, Safari 
   ajaxRequest = new XMLHttpRequest(); 
 }catch (e){
   // Internet Explorer Browsers 
   try{ 
      ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP"); 
   }catch (e) { 
      try{ 
         ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP"); 
      }catch (e){ 
         // Something went wrong 
         alert("Your browser broke!"); 
         return false; 
      }
   }
 } 
}

function validateUserId() {
  
   ajaxFunction(); 
   // Here processRequest() is the callback function. 
   ajaxRequest.onreadystatechange = function() {

	alert(ajaxRequest.readyState);
	alert(ajaxRequest.status);
	if (ajaxRequest.readyState == 4) {
		
         var message = "true";
	  setMessageUsingDOM(message);
	 }
   }
   
   var userId = document.getElementById("userid").value; 
   
   var url = "http://kim-kim-project.a3c1.starter-us-west-1.openshiftapps.com/hello";
  
   ajaxRequest.open("GET", url, true); 
   ajaxRequest.send(null); 
}

