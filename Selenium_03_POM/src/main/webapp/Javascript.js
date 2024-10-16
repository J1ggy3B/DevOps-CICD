var thisImg = 1;
var imgCnt = 10;
function newSlide(direction)
{
thisImg = thisImg + parseInt(direction);
if (thisImg	== 0) {thisImg = imgCnt};
if (thisImg	== imgCnt+1) {thisImg = 1};	
document.getElementById("sshow").src = "CarouselImages/" + thisImg + ".jpg";
}
//----------------------------------------------------------------------------
function init()
{
	document.getElementById("store").onclick = storeName;
	document.getElementById("recall").onclick = recallName;
	document.getElementById("remove").onclick = removeName;
	document.getElementById("reset").onclick = reSet;
}document.addEventListener("DOMContentLoaded", init, false);

//-------------------------------------------------------------------------
function storeName()
{

		var username = document.getElementById("username").value;
		if( (username ==="") || (username === null) )
		{
		alert("Please enter your name");
		}	
	else{
		localStorage.setItem("user", username);
		document.getElementById("leg").innerHTML = "<h4>" + "item: " + username + " has been stored" + "</h4>";		
		document.getElementById("username").value = "";
		}
}
//-------------------------------------------------------------------------
function recallName()
{
		if( (localStorage.getItem("user") ==="") || (localStorage.getItem("user")=== null) )
		{
		alert("No user stored");
		}	
	else{
		document.getElementById("username").value = localStorage.getItem("user");
		document.getElementById("leg").innerHTML = "<h4>" +  "Item: " + localStorage.getItem("user") + " has been recalled" + "</h4>";
		}
}
//------------------------------------------------------------------------
function removeName()
{
		if( (localStorage.getItem("user") ==="") || (localStorage.getItem("user")=== null) )
		{
		alert("No user available");
		}	
	else{
		document.getElementById("leg").innerHTML = "<h4>" +  "Item: "+ localStorage.getItem("user") + " has been removed" + "</h4>";
		localStorage.removeItem("user");
		document.getElementById("username").value = "";
		}
}
//--------------------------------------------------------------------------------
function reSet()
{
		document.getElementById("leg").innerHTML = "<h4>" +  "Enter Name: " + "</h4>";	
		document.getElementById("username").value = "";
		if( (localStorage.getItem("user") ==="") || (localStorage.getItem("user")=== null) )
		{
		localStorage.removeItem("user");
		}			
}