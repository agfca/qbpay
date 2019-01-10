var CommPublic={
		changeDateFormat:function(cellval) {
		    if (cellval != null) {
		        var date = new Date(parseInt(cellval));
		        var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
		        var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
		        return date.getFullYear() + "-" + month + "-" + currentDate;
		    }
		},  
	isPhone:function(txt_phone){
		if(/^(13[0-9]|14[0-9]|15[0-9]|17[0-9]|18[0-9])\d{8}$/.test(txt_phone)==true){
			return true
		}else{
			return false;
		}
		
	},
	isIdCard:function(idCard){
		if (idCard != "" && !/^(\d{14}|\d{17})(\d|[xX])$/.test(idCard)) {
			return false;
			}
		else{
			return true;
		}	
	},
	compareDate:function(start,end){
		 return ((new Date(end.replace(/-/g,"\/")))>(new Date(start.replace(/-/g,"\/"))));
	}
}

var CommLayer={
		alertMsg:function(msg){
			layer.msg(msg);
		},
		comfirmOk:function(msg,callback){
			if(msg==null||msg==undefined||msg==""){
				msg="您确定要执行吗？";
			}
			layer.confirm(msg, {icon: 3, title:'系统提示'}, function(index){
				  callback();
				  layer.close(index);
				});
		}
}
Date.prototype.Format = function(fmt)   
{ 
  var o = {   
    "M+" : this.getMonth()+1,                 //月份   
    "d+" : this.getDate(),                    //日   
    "h+" : this.getHours(),                   //小时   
    "m+" : this.getMinutes(),                 //分   
    "s+" : this.getSeconds(),                 //秒   
    "q+" : Math.floor((this.getMonth()+3)/3), //季度   
    "S"  : this.getMilliseconds()             //毫秒   
  };   
  if(/(y+)/.test(fmt))   
    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
  for(var k in o)   
    if(new RegExp("("+ k +")").test(fmt))   
  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
  return fmt;   
}  
  