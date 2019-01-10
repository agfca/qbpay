$(function () {
	$('#addForm').bootstrapValidator({
    	message: 'This value is not valid',
        feedbackIcons: {/*input状态样式图片*/
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },fields: {
        	productName: {
                message: '产品名称验证失败',
                validators: {
                    notEmpty: {
                        message: '产品名称不能为空'
                    }
                }
            },
            proportion: {
                message: '默认费率验证失败',
                validators: {
                    notEmpty: {
                        message: '默认费率不能为空'
                    }
                }
            },
            notifyUrl: {
                message: '异步反馈地址验证失败',
                validators: {
                    notEmpty: {
                        message: '异步反馈地址不能为空'
                    },
                    uri: {
                    	message: '异步反馈地址格式错误'
                    }
                }
            },
            returnUrl: {
                message: '同步反馈地址验证失败',
                validators: {
                    notEmpty: {
                        message: '同步反馈地址不能为空'
                    },
                    uri: {
                    	message: '同步反馈地址格式错误'
                    }
                }
            },
            submitUrl: {
                message: '接口提交地址验证失败',
                validators: {
                    notEmpty: {
                        message: '接口提交地址不能为空'
                    },
                    uri: {
                    	message: '接口提交地址格式错误'
                    }
                }
            }
        }
    })
    .on('success.form.bv', function(e) {//点击提交之后
        e.preventDefault();
        var url = "defaultRate/addOrEditDefaultRate.htm";
        
        var data = $('#addForm').serialize();
        
        jQuery.ajax({
            type : "POST",
            dataType : "json",//返回json格式的数据
            url : url,
            data : $('#addForm').serialize(),
            timeout : 50000,
            success : function(result) {
                if(result.statu){
                	$("#defaultRateModal").modal("hide");
                	$("#tb_defaultRate").bootstrapTable('refresh');
                }
                layer.msg(result.msg);
                $('#addForm').bootstrapValidator('disableSubmitButtons', false);
            },
            error : function(XMLHttpRequest) {
                layer.msg("系统错误请稍后再试!");
            }
        });
    });
	
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
});

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#tb_defaultRate').bootstrapTable({
            url: 'defaultRate/loadDefaultRate.htm',         		//请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: false,                      //是否显示行间隔色
            cache:true,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: false,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
            dataField:"result",
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            search: true,                      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,					//是否全文搜索
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
            showToggle:false,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            maintainSelected:true,
            columns : [
				{
					align:'center',
					title: "序号",
					halign: 'center',
					formatter:index
				},
				{
   					align: 'center',
   					field: 'tTypeId',
   					title: '产品类别',
   					formatter : getPayType
   				},
   				{
   					align: 'center',
   					field: 'productId',
   					title: '产品小类',
   					formatter : getProdect
   				},
				{
					align: 'center',
					field: 'proportion',
					title: '产品费率'
				},
				{
   					align: 'center',
   					field: 'status',
   					title: '产品状态',
   					formatter : function(value,row,index){
   						switch (value) {
   						case 0:
   							return "启用";
   						case 1:
   							return "禁用";
   						default:
   							return "无";
   						}
   					}
   				},
				{
					align: 'center',
					field: 'notifyUrl',
					title: '异步地址',
				},
				{
					align: 'center',
					field: 'returnUrl',
					title: '同步地址'
				},
				{
					align: 'center',
					field: 'submitUrl',
					title: '提交地址'
				},
				{
					align: 'center',
					field: 'Desc',
					title: '操作',
					formatter : function(value,row,index){
						var model = JSON.stringify(row);
						var btn = "";
						btn += "<button class='btn btn-circle btn-info' title='修改产品' onclick='edit("+model+")'><span class='glyphicon glyphicon-edit' aria-hidden='true'></span></button>&nbsp;";
						btn += "<button class='btn btn-circle btn-danger' title='删除产品' onclick='del("+model+")'><span class='glyphicon glyphicon-trash' aria-hidden='true'></span></button>&nbsp;";
						return btn;
					}
				}
			],
        });
    };
    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = {
            limit: params.limit,   	//页面大小
            offset: params.offset,  //页码
            tTypeId: $("#tTypeIdSearch").val(),
            productId: $("#productIdSearch").val()
        };
        return temp;
    };
    return oTableInit;
};

$("#new").on("click",function(){
	$("#addForm")[0].reset();
	
	$("#defaultRateModal").modal("show");
});

function edit(model){
	$("#id").val(model.id);
	$("#productId").val(model.productId);
	$("#proportion").val(model.proportion);
	$("#tTypeId").val(model.tTypeId);
	$("#notifyUrl").val(model.notifyUrl);
	$("#returnUrl").val(model.returnUrl);
	$("#submitUrl").val(model.submitUrl);
	
	$("#defaultRateModal").modal("show");
}

function del(model){
	layer.confirm('确定删除产品：'+model.productName+'吗?',{btn: ['确定', '取消'],title:"提示"}, function(){
		jQuery.ajax({
	        type : "POST",
	        dataType : "json",//返回json格式的数据
	        url : "defaultRate/delDefaultRate.htm",
	        data : {id:model.id},
	        timeout : 50000,
	        success : function(result) {
	        	if(result.statu){
	        		$("#tb_defaultRate").bootstrapTable('refresh');
	        	}
	        	layer.msg(result.msg);
	        },
	        error : function(XMLHttpRequest) {
	            layer.msg("系统错误请稍后再试!");
	        }
	    });
	})
}

$("#tTypeIdSearch").on("change",function(){
	$("#tb_defaultRate").bootstrapTable('refresh');
});

$("#productIdSearch").on("change",function(){
	$("#tb_defaultRate").bootstrapTable('refresh');
});