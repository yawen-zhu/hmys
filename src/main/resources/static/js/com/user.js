/**
 * 系统用户js
 */
/**
 * 用户列表
 */
function queryList() {
    // doAlert("请输入用户名密码",'danger')
    $('#grid').bootstrapTable({
        url: '/user/getPageList',
        contentType : 'application/x-www-form-urlencoded',
        sidePagination: 'server',      //client or server
        striped: true,                 //隔行变色
        clickToSelect: true,           //单击选中
        pagination: true,              //是否显示分页（*）
        pageNumber:1,                  //初始化加载第一页，默认第一页
        pageSize: 10,                  //每页的记录行数（*）
        pageList: [10, 20, 50],        //可供选择的每页的行数（*）
        paginationPreText: '上一页',
        paginationNextText: '下一页',
        columns: [{checkbox: true},
            {field: 'name',   title: '用户名', width: '20%'},
            {field: 'account',title: '账号',   width: '20%'},
            {field: 'roleId', title: '角色',   width: '20%'},
            {field: 'createTime', title: '创建时间', width: '20%',
                formatter: function (value,row,index) {
                   return dateFormatter(value);
                }
            },
            {field: 'desc',   title: '描述',   width: '20%'}
        ]
    });
}

