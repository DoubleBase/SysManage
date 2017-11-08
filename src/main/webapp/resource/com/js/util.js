getNotNullValue = function(value){
	if(value==null||value==undefined)
		return "";
	return value;
}

base_valid_is_empty = function(id){
	if($('#'+id).val()=='' || $('#'+id).val().length<=0){
		return true;
	}
	return false;
}