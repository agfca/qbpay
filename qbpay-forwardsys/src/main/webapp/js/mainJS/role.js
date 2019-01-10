$(function () {
	$('#addForm').bootstrapValidator({
    	message: 'This value is not valid',
        feedbackIcons: {/*input状态样式图片*/
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },fields: {
        	roleName: {
                message: '角色名称验证失败',
                validators: {
                    notEmpty: {
                        message: '角色名称不能为空'
                    }
                }
            }
        }
    })
    .on('success.form.bv', function(e) {//点击提交之后
        e.preventDefault();
        var url = "role/addOrEditRole.htm";
        jQuery.ajax({
            type : "POST",
            dataType : "json",//返回json格式的数据
            url : url,
            data : $('#addForm').serialize(),
            timeout : 50000,
            success : function(result) {
                if(result.statu){
                	$("#roleModal").modal("hide");
                	$("#tb_role").bootstrapTable('refresh');
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
        $('#tb_role').bootstrapTable({
            url: 'role/loadRole.htm',         		//请求后台的URL（*）
            method: 'post',                      //请求方式（*）
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
            search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,				//是否全文搜索
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
                    field: 'roleName',
                    title: '角色名称'
                },
				{
   					align: 'center',
   					field: 'roleStatu',
   					title: '角色状态',
   					formatter : function(value,row,index){
   						if(value == 0){
   							return "启用";
   						}else if(value == 1){
   							return "禁用";
   						}
   					}
   				},
				{
					align: 'center',
					field: 'roleRemark',
					title: '备注',
				},
				{
					align: 'center',
					field: 'Desc',
					title: '操作',
					formatter : function(value,row,index){
						var model = JSON.stringify(row);
						var btn = "";
						btn += "<button class='btn btn-circle btn-info' title='修改角色' onclick='edit("+model+")'><span class='glyphicon glyphicon-edit' aria-hidden='true'></span></button>&nbsp;";
						btn += "<button class='btn btn-circle btn-info' title='设置权限' onclick='roleMenu("+model+")'><span class='glyphicon glyphicon-th-list' aria-hidden='true'></span></button>&nbsp;";
						btn += "<button class='btn btn-circle btn-danger' title='删除角色' onclick='del("+model+")'><span class='glyphicon glyphicon-trash' aria-hidden='true'></span></button>&nbsp;";
						
						return btn;
					}
				}
			]
        });
    };
    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = {
            limit: params.limit,   	//页面大小
            offset: params.offset,  //页码
        };
        return temp;
    };
    return oTableInit;
};

$("#new").on("click",function(){
	$("#addForm")[0].reset();
	
	$("#roleModal").modal("show");
});

function loadParentMenu(parentId){
	jQuery.ajax({
        type : "POST",
        dataType : "json",//返回json格式的数据
        url : "menu/loadParentMenu.htm",
        data : $('#addForm').serialize(),
        timeout : 50000,
        success : function(result) {
            var htm = "<option value='0' selected>--无--</option>";
            
            for (var i = 0; i < result.length; i++) {
            	var model = result[i];
				if(parentId != null && model.menuId == parentId){
					htm += "<option value='"+model.menuId+"' selected='selected'>" + model.menuName + "</option>";
				}else{
					htm += "<option value='"+model.menuId+"'>" + model.menuName + "</option>";
				}
			}
            $("#menuParentId").html(htm);
        },
        error : function(XMLHttpRequest) {
            layer.msg("系统错误请稍后再试!");
        }
    });
}

function edit(model){
	
	loadParentMenu(model.menuParentId);
	
	$("#roleName").val(model.roleName);
	$("#roleId").val(model.roleId);
	$("#roleRemark").val(model.roleRemark);
	
	$("#roleModal").modal("show");
}

function del(model){
	layer.confirm('确定删除角色：'+model.roleName+'吗?',{btn: ['确定', '取消'],title:"提示"}, function(){
		jQuery.ajax({
	        type : "POST",
	        dataType : "json",//返回json格式的数据
	        url : "role/delRole.htm",
	        data : {roleId:model.roleId},
	        timeout : 50000,
	        success : function(result) {
	        	if(result.statu){
	        		$("#tb_role").bootstrapTable('refresh');
	        	}
	        	layer.msg(result.msg);
	        },
	        error : function(XMLHttpRequest) {
	            layer.msg("系统错误请稍后再试!");
	        }
	    });
	})
}

function roleMenu(model){
	$("#role").val(model.roleId);
	$.ajax({
		type:"post",
		dataType : "json",//返回json格式的数据
		url:"role/loadRoleMenu.htm",
		data:{roleId:model.roleId},
		success : function(result){
			var zNodes = result;
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			$("#role").val(model.roleId);
			$(".line").attr("class", "level0");
			$("#menuModal").modal("show");
		},
		error : function(XMLHttpRequest) {
            layer.msg("系统错误请稍后再试!");
        }
	});
}

var setting = {
        view: {
            addHoverDom: false,
            removeHoverDom: false,
            selectedMulti: false
        },
        check: {
            enable: true
        },
        data: {
            simpleData: {
                enable: true
            }
        },
        edit: {
            enable: true
        }
    };

//获取所有选中节点的值
$("#menuAdd").on("click",function(){
	var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
    var nodes = treeObj.getCheckedNodes(true);
    var msg = "";
    for (var i = 0; i < nodes.length; i++) {
        msg += nodes[i].id+",";
    }
    
    msg = msg.substring(0, msg.length-1);
    
    var roleId = $("#role").val();
    var index = layer.load(2, {shade: [0.5,'#fff']}); //0代表加载的风格，支持0-2
    jQuery.ajax({
		type : "POST",
		dataType : "json",//返回json格式的数据
		url : "role/roleMenuChange.htm",
		data : {roleId:roleId,menuId:msg},
		timeout : 50000,
		success : function(result) {
			layer.close(index);
			if(result.statu){
				$("#menuModal").modal("hide");
			}
			layer.msg(result.msg);
		},
		error : function(XMLHttpRequest) {
			layer.close(index);
			layer.msg("系统错误请稍后再试!");
		}
	});
});