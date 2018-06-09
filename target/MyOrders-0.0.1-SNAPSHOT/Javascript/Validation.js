/**
 * 
 */
function OrderSubmit(){
	//alert("please enter quantity");
	console.log("inside OrderSubmit");
	var Quantity = document.getElementById("quantity").value;
	var availbility = document.getElementById("availableCnt").value;
	console.log(Quantity + "|" + availbility);
	if (Quantity < 1) {
		alert("Order should be greater than 0");    
		return false;
	} else {
		if (parseInt(Quantity) > parseInt(availbility)) {
			console.log("Quantity greater than availablity :" + Quantity + "|" + availbility);
			alert("Quantity should be less than available Count");
			return false;
		} else {
			return true;
		}
	}
}