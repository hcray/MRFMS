//鼠标移入样式的修改
function buttonFocus(id){
	if(document.getElementById(id) == null) {
		return;
	}
	
	if(document.getElementById(id).className.indexOf('disabled') != -1){
		return;
	}

	document.getElementById(id).hideFocus = "true";
	$("#" + id).addClass('a_hover');
	id = id + 'span';
	$("#" + id).addClass('s_hover');
	//YAHOO.util.Dom.addClass(document.getElementById(id), 's_hover')
}

//鼠标移出 样式的还原
function buttonBlur(id){
	//YAHOO.util.Dom.removeClass(document.getElementById(id), 'a_hover');
	$("#" + id).removeClass('a_hover');
	id = id + 'span';
	//YAHOO.util.Dom.removeClass(document.getElementById(id), 's_hover');
	$("#" + id).removeClass('s_hover');
}

//取得元素的靠左的绝对位置
function getElementLeft(element){
	var actualLeft = element.offsetLeft;
	var current = element.offsetParent;
	while (current !== null){
		actualLeft += current.offsetLeft;
		current = current.offsetParent;
	}
	return actualLeft;
}

//取得元素的靠上的绝对位置
function getElementTop(element){
	var actualTop = element.offsetTop;
	var current = element.offsetParent;
	while (current !== null){
		actualTop += current.offsetTop;
		current = current.offsetParent;
	}
	return actualTop;
}

function noaction(){
    return;
}
