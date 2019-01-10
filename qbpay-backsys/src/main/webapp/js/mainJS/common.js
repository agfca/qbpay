
function getMsg(code){
	switch (code) {
	case "success":
		return "操作成功";
		break;
	default:
		return "失败";
		break;
	}
}

function getStatu(value,row,index){
	switch (value) {
	case "0":
		return "启用";
		break;
	case "1":
		return "禁用";
		break;
	default:
		return "无";
		break;
	}
}

function getPayType(value,row,index){
	switch (value) {
	case 1:
		return "微信";
		break;
	case 2:
		return "支付宝";
		break;
	case 3:
		return "银联";
		break;
	default:
		return "无";
		break;
	}
}

function getProdect(value,row,index){
	switch (value) {
	case "11":
		return "当面付";
		break;
	case "12":
		return "条形扫码";
		break;
	case "13":
		return "商店扫码";
		break;
	case "14":
		return "商店扫码";
		break;
	default:
		return "无";
		break;
	}
}

function formatterNull(value,row,index){
	switch (value) {
	case undefined:
		return "无";
		break;
	case null:
		return "无";
		break;
	default:
		return value;
		break;
	}
}

function index(value,row,index){
	return index+1;
}

//转换时间戳为年月日时分秒
function changeDateTimeFormat(cellval) {
    if (cellval != null) {
        var date = new Date(parseInt(cellval));
        var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
        var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
        
        var H = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
        var M = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
        var S = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
        return date.getFullYear() + "-" + month + "-" + currentDate + " " + H + ":" + M + ":" + S;
    }
}

//转换时间戳为年月日
function changeDateFormat(cellval) {
    if (cellval != null) {
        var date = new Date(parseInt(cellval));
        var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
        var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
        return date.getFullYear() + "-" + month + "-" + currentDate;
    }
}
//当前时间年月日
function nowDate(){
	   var date = new Date();
	   var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
       var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
       return date.getFullYear() + "-" + month + "-" + currentDate;
}
//当前时间年月日
function nowDateTime(){
	   var date = new Date();
	   var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
       var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
       
       var H = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
       var M = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
       var S = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
       return date.getFullYear() + "-" + month + "-" + currentDate + " " + H + ":" + M + ":" + S;
}

function discountText(discount,faciend){
	return discount * 1000 * faciend / 1000;
}

function intToDoubleFormart2(number){
	return number.toFixed(2)
}