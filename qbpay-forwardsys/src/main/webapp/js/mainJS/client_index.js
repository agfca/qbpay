//表格显示初始化
var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#mydata').bootstrapTable({
            url: 'client/getData.htm',         		//请求后台的URL（*）
            method: 'post',                      //请求方式（*）
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: false,                      //是否显示行间隔色
            cache:true,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: true,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: false,
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
            showToggle:false,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            maintainSelected:true,
            columns : [{ radio: true },
                        {
		    				align: 'center',
		                    field: 'id',
		                    title: '编号'
		                },
		                {
		    				align: 'center',
		                    field: 'clientName',
		                    title: '姓名'
		                },
		                {
		    				align: 'center',
		                    field: 'socialUnifiedCode',
		                    title: '身份证号'
		                },
		                {
            				align: 'center',
		                    field: 'clientPhone',
		                    title: '手机号码'
		                },
		                {
            				align: 'center',
		                    field: 'clientProvinceId',
		                    title: 'clientProvinceId',
		                    visible:false
		                },
		                {
            				align: 'center',
		                    field: 'clientProvinceTxt',
		                    title: '所属省份'
		                },
		                {
            				align: 'center',
		                    field: 'clientCityId',
		                    title: 'clientCityId',
		                    visible:false
		                },
		                {
            				align: 'center',
		                    field: 'clientCityTxt',
		                    title: '城市'
		                },
		                {
            				align: 'center',
		                    field: 'clientAreaId',
		                    title: 'clientAreaId',
		                    visible:false
		                },
		                {
            				align: 'center',
		                    field: 'clientAreaTxt',
		                    title: '区/县'
		                },
		                {
            				align: 'center',
		                    field: 'clientAddress',
		                    title: '常住地址'
		                },
		                {
            				align: 'center',
		                    field: 'parentid',
		                    title: '账户类型',
		                    formatter:function(value,row,index){
		                    	 if(value==0){
		                    		return '主账户';
		                    	}else{
		                    		return '子账户';
		                    	}
		                    }
		                },
		                {
            				align: 'center',
		                    field: 'roleName',
		                    title: '所属角色'
		                },
		                {
            				align: 'center',
		                    field: 'roleId',
		                    title: '所属角色ID',
		                    visible:false
		                },
		                {
            				align: 'center',
		                    field: 'userStatus',
		                    title: '账户状态',
		                    formatter:function(value,row,index){
		                    	if(value==1){
		                    		return '<span style="color:#00ff00">已通过</span>';
		                    	}else if(value==0){
		                    		return '<span style="color:#FF0000">待审核</span>';
		                    	}else{
		                    		return '<span style="color:#FF0000">未通过</span>';
		                    	}
		                    }
		                },
		                {
            				align: 'center',
		                    field: 'clientStatus',
		                    title: '运行状态',
		                    formatter:function(value,row,index){
		                    	if(value==1){
		                    		return '<span>正常</span>';
		                    	}else{
		                    		return '<span style="color:#FF0000">锁定</span>';
		                    	}
		                    }
		                },
		                {
            				align: 'center',
		                    field: 'createTime',
		                    title: '创建日期',
		                    formatter:function(value,row,index){
		                    	return CommPublic.changeDateFormat(value);
		                    }
		                },
		                {
		                	align: 'center',
		                    field: 'Desc',
		                    title: '操作',
		                    formatter : function(value,row,index){
		                    	var model = JSON.stringify(row);
		                    	var btn='';
		                    	//修改支付密码
		                    	btn+="<button class='bta' onclick='editpwd("+model+")'><span class='glyphicon glyphicon-pencil' aria-hidden='true'></span>修改登录密码</button>&nbsp&nbsp&nbsp&nbsp";
		                    	//修改支付密码
		                    	btn+="<button class='bta' onclick='editPayPwd("+model+")'><span class='glyphicon glyphicon-pencil' aria-hidden='true'></span>修改支付密码</button>&nbsp&nbsp&nbsp&nbsp";
		                    	return btn;
		                    }
		                }
                        ]
        });
    };

    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            limit: params.limit,   //页面大小
            offset: params.offset,  //页码
            departmentname: $("#txt_search_departmentname").val(),
            statu: $("#txt_search_statu").val()
        };
        return temp;
    };
    return oTableInit;
};

function cleardata(){
	$("#clientName").val("");
	$("#clientPhone").val("");
	$("#password").val("666666");
	$("#payPassword").val("888888");
	$("#clientAddress").val("");
	$("#socialUnifiedCode").val("");
}
	//新增数据
	function addModel(){
		//$("#myForm")[0].reset();
		cleardata();
		$("#id").val(0);
		document.getElementById("modaltitle").innerHTML="创建子账户";
		getpro();
		getcity();
		getRoleList();
		
		$("#socialCodeStartDate").datepicker('setDate',new Date())
		$("#socialCodeEndDate").datepicker('setDate',new Date()); //设置为当前日期	
		$("#myModal").modal("show");
	}
	
	//编辑数据
	function editModel(){
		cleardata();
		var select = $("#mydata").bootstrapTable('getSelections');
		if(select.length== 0){
			CommLayer.alertMsg("请选择要操作的数据");
			return false;
		}
		//获取参数
		var selectmodel = select[0];
		var myFormObj=document.forms["myForm"];	
		document.getElementById("modaltitle").innerHTML="修改账户信息";
		
		$("#id").val(selectmodel.id);//修改操作
		myFormObj.id.value=selectmodel.id;
		myFormObj.clientName.value=selectmodel.clientName;
		myFormObj.clientPhone.value=selectmodel.clientPhone;
		
		myFormObj.password.value="666666";
		myFormObj.password.disabled='disabled';
		myFormObj.payPassword.value="888888";
		myFormObj.payPassword.disabled='disabled';
		getRoleList();	//获取角色信息
		$("#roleid").val(selectmodel.roleId);
		myFormObj.socialUnifiedCode.value=selectmodel.socialUnifiedCode;
		getpro();
		$("#clientProvinceId").val(selectmodel.clientProvinceId);	
		getcity();
		$("#clientCityId").val(selectmodel.clientCityId);
		getarea();
		$("#clientAreaId").val(selectmodel.clientAreaId);
		myFormObj.clientAddress.value=selectmodel.clientAddress;

		$("#socialCodeStartDate").datepicker('setDate',selectmodel.clientCodeStartDate);
		$("#socialCodeEndDate").datepicker('setDate',selectmodel.clientCodeEndDate); //设置为当前日期	
		$("#myModal").modal("show");
	}
	//删除数据
	function delModel(){
		var select = $("#mydata").bootstrapTable('getSelections');
		if(select.length== 0){
			CommLayer.alertMsg("请选择要操作的数据");
			return false;
		}
		//获取参数
		var this_id = select[0].id;
		if(this_id==null || this_id==undefined || this_id==""){
			CommLayer.alertMsg("没有获取到提交的参数信息");
			return false;
		}
		CommLayer.comfirmOk("删除后将无法还原，您确定要执行删除吗？",function(){
			var url = "client/delClient.htm";
			var data={
					"id":this_id 
			}
			CommAjax.SubmitAjaxCallBack(url,data,function(res){
	        	if(res.Result){
	        		layer.msg(res.Msg);
		        	$("#mydata").bootstrapTable('refresh');
	            }else{
	            	layer.msg(res.Msg);
	            }
	        });
		});
	}
	
	//修改登录密码
	function editpwd(model){
		var myForm2Obj=document.forms["myForm2"];		
		myForm2Obj.clientName2.value=model.clientName;
		myForm2Obj.clientPhone2.value=model.clientPhone;
		myForm2Obj.clientName2.disabled='disabled';
		myForm2Obj.clientPhone2.disabled='disabled';
		myForm2Obj.password2.value="666666";					//默认密码
		myForm2Obj.comfirmpassword2.value="666666";		//默认密码
		myForm2Obj.id2.value=model.id;		
		$("#myModal2").modal("show");
	}
	
	//修改支付密码
	function editPayPwd(model){
		var myFormObj=document.forms["myForm3"];
		myFormObj.clientName3.value=model.clientName;
		myFormObj.clientPhone3.value=model.clientPhone;
		myFormObj.clientName3.disabled='disabled';
		myFormObj.clientPhone3.disabled='disabled';
		myFormObj.paypassword3.value="888888";					//默认支付密码
		myFormObj.comfirmpaypassword3.value="888888";		//默认支付确认密码
		myFormObj.id3.value=model.id;		
		$("#myModal3").modal("show");
	}
	
	//获取省份
	function getpro(){
		var clientProvinceIdBox=$("#clientProvinceId");
        	getAreaList(clientProvinceIdBox,0,true);	//获取省份
	}
	
	//获取城市
    function getcity(){
    	var pid=$("#clientProvinceId").val();
		var clientCityIdBox=$("#clientCityId");
		var clientAreaIdBox=$("#clientAreaId");

		getAreaList(clientCityIdBox,pid,true);	//获取城市
		
		var cid=clientCityIdBox.val();		//获取县、区
		getAreaList(clientAreaIdBox,cid,true);
	}
   
    //获取区县
    function getarea(){
    	var cid=$("#clientCityId").val();
    	var clientAreaIdBox=$("#clientAreaId");
		getAreaList(clientAreaIdBox,cid,true);
    }
   
    //获取当前账户下创建的角色
    function getRoleList(){
    	 CommAjax.SubmitAjaxCallBack("role/loadClientMenu.htm",null,function(res){
    		 console.log(JSON.stringify(res));
    	 	var roleidBox=document.getElementById("#roleid");
    	 	$("#roleid").empty();
    	 	if(res!=null){
    	 		var len=res.length;
	    	 	if(len>0){
	    	 		for(var i=0;i<len;i++){
	    	 			$("#roleid").append("<option value='"+res[i].Id+"'>"+res[i].Name+"</option>");
	    	 		}
	    	 	}
    	 	}
        },false);
    }
	
$(function () {
	$('#myForm').bootstrapValidator({
    	message: 'This value is not valid',
        feedbackIcons: {/*input状态样式图片*/
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },fields: {
        	clientName: {
                message: '用户姓名不能为空',
                validators: {
                    notEmpty: {
                        message: '用户姓名不能为空'
                    }
                }
            },
        	clientPhone: {
                message: '用户电话号码不能为空',
                validators: {
                    notEmpty: {
                        message: '用户电话号码不能为空'
                    },
                    remote: {//ajax验证
	                     url: 'userRegister/CheckPhoneIsExit.htm',
	                     message: '手机号码已经注册',//提示消息
	                     type: 'POST',//请求方式
	                     data: function(validator){
	                         return {
	                             'clientPhone': $("#clientPhone").val(),
	                             'id':$("#id").val()
	                         };
	                     }
	                }
                }
            },
            password: {
                message: '登录密码不能为空',
                validators: {
                    notEmpty: {
                        message: '登录密码不能为空'
                    }
                }
            },
            payPassword: {
                message: '支付密码不能为空',
                validators: {
                    notEmpty: {
                        message: '支付密码不能为空'
                    }
                }
            },
            socialUnifiedCode: {
                message: '身份证号码不能为空',
                validators: {
                    notEmpty: {
                        message: '身份证号码不能为空'
                    },regexp: {
                        regexp:/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/,
                        message: '身份证号码格式不正确，为15位和18位身份证号码！'
                    },
                 	remote: {//ajax验证
	                     url: 'userRegister/CheckUnifiedCodeIsExit.htm',
	                     message: '身份证号码已经存在',//提示消息
	                     type: 'POST',//请求方式
	                     data: function(validator){
	                         return {
	                             'unifiedCode': $("#socialUnifiedCode").val(),
	                             'id':$("#id").val()
	                         };
	                     }
	                }
                }
            },
            roleid: {
                message: '用户角色不能为空',
                validators: {
                    notEmpty: {
                        message: '用户角色不能为空'
                    }
                }
            },
            clientCodeStartDate: {
                message: '身份证开始日期不能为空',
                validators: {
                    notEmpty: {
                        message: '身份证开始日期不能为空'
                    }
                }
            },
            clientCodeEndDate: {
                message: '身份证截止日期不能为空',
                validators: {
                    notEmpty: {
                        message: '身份证截止日期不能为空'
                    }
                }
            },
            clientProvinceId: {
                message: '所属省份不能为空',
                validators: {
                    notEmpty: {
                        message: '所属省份不能为空'
                    }
                }
            },
            clientCityId: {
                message: '所属城市不能为空',
                validators: {
                    notEmpty: {
                        message: '所属城市不能为空'
                    }
                }
            },
            clientAreaId: {
                message: '所属区县不能为空',
                validators: {
                    notEmpty: {
                        message: '所属区县不能为空'
                    }
                }
            },
            clientAddress: {
                message: '常住地址不能为空',
                validators: {
                    notEmpty: {
                        message: '常住地址不能为空'
                    }
                }
            }
        }
    })
    .on('success.form.bv', function(e) {//点击提交之后
        e.preventDefault();
        var url = "client/addOrEditByClient.htm";
		var data={
			"id":$("#id").val(),
			"clientName":$("#clientName").val(),
			"clientPhone":$("#clientPhone").val(),
			"password":md5($("#password").val()),
			"payPassword":md5($("#payPassword").val()),
			"roleId":$("#roleid").val(),
			"socialUnifiedCode":$("#socialUnifiedCode").val(),
			"clientCodeStartDate":$("#clientCodeStartDate").val(),
			"clientCodeEndDate":$("#clientCodeEndDate").val(),
			"clientProvinceId":$("#clientProvinceId").val(),
			"clientProvinceTxt":$("#clientProvinceId option:selected").text(),
			"clientCityId":$("#clientCityId").val(),
			"clientCityTxt":$("#clientCityId option:selected").text(),
			"clientAreaId":$("#clientAreaId").val(),
			"clientAreaTxt":$("#clientAreaId option:selected").text(),
			"clientAddress":$("#clientAddress").val()
	 	 };
		
		
        CommAjax.SubmitAjaxCallBack(url,data,function(res){
        	if(res.Result){
        		layer.msg(res.Msg);
	        	$("#myModal").modal("hide");
	        	$("#mydata").bootstrapTable('refresh');
            }else{
            	layer.msg(res.Msg);
            }
            $('#myForm').bootstrapValidator('disableSubmitButtons', false);
        });
    });
	
	//修改登录密码表单验证
	$('#myForm2').bootstrapValidator({
    	message: 'This value is not valid',
        feedbackIcons: {/*input状态样式图片*/
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },fields: {
        	clientName2: {
                message: '用户姓名不能为空',
                validators: {
                    notEmpty: {
                        message: '用户姓名不能为空'
                    }
                }
            },
            clientPhone2: {
                message: '用户电话号码不能为空',
                validators: {
                    notEmpty: {
                        message: '用户电话号码不能为空'
                    }
                 }
            },
            password2: {
                message: '登录密码不能为空',
                validators: {
                    notEmpty: {
                        message: '登录密码不能为空'
                    },
                    identical: {
                        field: 'comfirmpassword2',
                        message: '两次输入的密码不相符'
                    }
                }
            },
            comfirmpassword2: {
                message: '登录确认密码不能为空',
                validators: {
                    notEmpty: {
                        message: '登录确认密码不能为空'
                    },
                    identical: {
                        field: 'password2',
                        message: '两次输入的密码不相符'
                    }
                }
            }
          }
    })
    .on('success.form.bv', function(e) {//点击提交之后
        e.preventDefault();
        var url = "client/editPwd.htm";
        var myForm2Obj=document.forms["myForm2"];
		var data={
			"id":myForm2Obj.id2.value,
			"password":md5(myForm2Obj.password2.value)
	 	 };
        CommAjax.SubmitAjaxCallBack(url,data,function(res){
        	if(res.Result){
        		layer.msg(res.Msg);
	        	$("#myModal2").modal("hide");
            }else{
            	layer.msg(res.Msg);
            }
            $('#myForm2').bootstrapValidator('disableSubmitButtons', false);
        });
    });
	
	//修改支付密码表单验证
	$('#myForm3').bootstrapValidator({
    	message: 'This value is not valid',
        feedbackIcons: {/*input状态样式图片*/
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },fields: {
        	clientName3: {
                message: '用户姓名不能为空',
                validators: {
                    notEmpty: {
                        message: '用户姓名不能为空'
                    }
                }
            },
            clientPhone3: {
                message: '用户电话号码不能为空',
                validators: {
                    notEmpty: {
                        message: '用户电话号码不能为空'
                    }
                 }
            },
            paypassword3: {
                message: '支付密码不能为空',
                validators: {
                    notEmpty: {
                        message: '支付密码不能为空'
                    },
                    identical: {
                        field: 'comfirmpaypassword3',
                        message: '两次输入的支付密码不一致'
                    }
                }
            },
            comfirmpaypassword3: {
                message: '支付确认密码不能为空',
                validators: {
                    notEmpty: {
                        message: '支付确认密码不能为空'
                    },
                    identical: {
                        field: 'paypassword3',
                        message: '两次输入的支付密码不一致'
                    }
                }
            }
          }
    })
    .on('success.form.bv', function(e) {//点击提交之后
        e.preventDefault();
        var url = "client/editPayPwd.htm";
        var myFormObj=document.forms["myForm3"];
		var data={
			"id":myFormObj.id3.value,
			"payPassword":md5(myFormObj.paypassword3.value)
	 	 };
        CommAjax.SubmitAjaxCallBack(url,data,function(res){
        	if(res.Result){
        		layer.msg(res.Msg);
	        	$("#myModal3").modal("hide");
            }else{
            	layer.msg(res.Msg);
            }
            $('#myForm3').bootstrapValidator('disableSubmitButtons', false);
        });
    });
	//初始化对象
	var ButtonInit = function () {
        var oInit = new Object();
        var postdata = {};

        oInit.Init = function () {
            //初始化页面上面的按钮事件
        };

        return oInit;
    };
    
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();

    //2.初始化Button的点击事件
    var oButtonInit = new ButtonInit();
    oButtonInit.Init();
    
    //初始化日期控件
    $(".datepicker").datepicker({
		 language:  'zh-CN',
       format: 'yyyy-mm',
       weekStart: 1,
       todayBtn:  1,
       autoclose: 1,
       todayHighlight: 1,
       startView: 3, //这里就设置了默认视图为年视图
       minView: 3, //设置最小视图为年视图
       forceParse: 0,
      format: "yyyy-mm-dd"//日期格式
   });
	$("#clientCodeStartDate").datepicker('setDate',new Date());
	$("#clientCodeEndDate").datepicker('setDate',new Date()); //设置为当前日期	
	
	
    //绑定创建子账户事件
	$("#btnadd").on("click",function(){
    	addModel();
    });
	//绑定修改事件
	$("#btnupdate").on("click",function(){
		editModel();
	});
	
	//绑定删除事件
	$("#btndel").on("click",function(){
		delModel();
	});
    
    //省份联动
    $("#clientProvinceId").on("change",function(){
		getcity();
	})
    //城市联动
	$("#clientCityId").on("change",function(){
		getarea();
	})
			
});
