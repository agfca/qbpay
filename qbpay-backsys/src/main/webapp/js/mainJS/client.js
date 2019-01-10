$(function () {
	$('#addForm').bootstrapValidator({
    	message: 'This value is not valid',
        feedbackIcons: {/*input状态样式图片*/
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },fields: {
            /*submitUrl: {
                message: '接口提交地址验证失败',
                validators: {
                    notEmpty: {
                        message: '接口提交地址不能为空'
                    },
                    uri: {
                    	message: '接口提交地址格式错误'
                    }
                }
            }*/
        }
    })
    .on('success.form.bv', function(e) {//点击提交之后
        e.preventDefault();
        var url = "client/editClientOverTime.htm";
        
        var data = $('#addForm').serialize();
        
        jQuery.ajax({
            type : "POST",
            dataType : "json",//返回json格式的数据
            url : url,
            data : $('#addForm').serialize(),
            timeout : 50000,
            success : function(result) {
                if(result.statu){
                	$("#clientModal").modal("hide");
                	$("#tb_client").bootstrapTable('refresh');
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
        $('#tb_client').bootstrapTable({
            url: 'client/loadClient.htm',         		//请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: false,                      //是否显示行间隔色
            cache:true,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: false,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            dataField:"res",
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
   					field: 'clientName',
   					title: '客户名称'
   				},
   				{
   					align: 'center',
   					field: 'socialUnifiedCode',
   					title: '统一代码/身份证'
   				},
				{
					align: 'center',
					field: 'clientAddress',
					title: '地址'
				},
				{
   					align: 'center',
   					field: 'clientType',
   					title: '客户类型',
   					formatter : function(value,row,index){
   						switch (value) {
   						case 1:
   							return "个人";
   						case 2:
   							return "企业";
   						}
   					}
   				},
				{
					align: 'center',
					field: 'createTime',
					title: '注册时间',
					formatter : function(value,row,index){
   						return changeDateFormat(value);
   					}
				},
				{
					align: 'center',
					field: 'overTime',
					title: '当前结算时间'
				},
				{
					align: 'center',
					field: 'Desc',
					title: '操作',
					formatter : function(value,row,index){
						var model = JSON.stringify(row);
						var btn = "";
						btn += "<button class='btn btn-circle btn-info' title='修改结算时间' onclick='editOverTime("+model+")'><span class='glyphicon glyphicon-pencil' aria-hidden='true'></span></button>&nbsp;";
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
            clientType: $("#clientTypeSearch").val(),
            userStatus: $("#userStatusSearch").val(),
            clientName: $("#clientNameSearch").val()
        };
        return temp;
    };
    return oTableInit;
};

function editOverTime(model){
	$("#clientName").val(model.clientName);
	$("#overTimeBefore").val(model.overTime);
	$("#id").val(model.id);
	
	$("#clientModal").modal("show");
}

function reload(){
	$("#tb_client").bootstrapTable('destroy');
	var oTable = new TableInit();
    oTable.Init();
}

$("#clientTypeSearch").on("change",function(){
	reload();
});

$("#userStatusSearch").on("change",function(){
	reload();
});

$("#searchClient").on("click",function(){
	reload();
});