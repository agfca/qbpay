var CommAjax={
	//执行Ajax提交(支持回调)，支持异步	
	SubmitAjaxCallBack:function(url,data,callback,async){
		var _async=true;//默认是true，即为异步方式,false：同步方式
		if(async==false){
			_async=false;
		}
		console.log("传递的参数："+JSON.stringify(data));
		$.ajax({
            type: "post",
            url: url,
            data: data,
            async: _async,
            dataType: "json",
            //contentType: 'application/json;charset=utf-8',
            success: function (ret) {
                callback(ret);
            },
            error: function (res) {
            	console.log(res);
            	var data={"Result":false,Msg:"操作失败,请稍后再试"};
            	callback(data);
            }
        });
	},
	SubmitAjax:function(url,data,callback,async){
		var _async=true;//默认是true，即为异步方式,false：同步方式
		if(async==false){
			_async=false;
		}
		console.log("传递的参数："+JSON.stringify(data));
		$.ajax({
	        type: "post",
	        url: url,
	        data: data,
	        async: _async,
	        dataType: "json",
	        //contentType: 'application/json;charset=utf-8',
	        success: function (ret) {
	            callback(ret);
	        },
	        error: function (res) {
	        	console.log(res);
	        	
	        }
	    });
	}
}