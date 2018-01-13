/**
* 角色管理js
*/
/**
 * 角色列表
 */
function queryList() {
    $('#grid').bootstrapTable({
        url: '/role/getPageList',
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
            {field: 'name',   title: '角色名称', width: '30%'},
            {field: 'createTime', title: '创建时间', width: '40%',
                formatter: function (value,row,index) {
                   return dateFormatter(value);
                }
            },
            {field: 'updateTime', title: '修改时间', width: '40%',
                formatter: function (value,row,index) {
                    return dateFormatter(value);
                }
            },
        ]
    });
}

function doFunction(action){
    switch (action){
        case 'authorise':
            authorise();
        default:
    }
}

/**
 * 授权
 */
function authorise() {
    BootstrapDialog.show({
        type : BootstrapDialog.TYPE_PRIMARY,
        title : '角色授权',
        size : BootstrapDialog.SIZE_NORMAL,//SIZE_SMALL, SIZE_NORMAL, SIZE_WIDE, SIZE_LARGE
        message: $('<div></div>').load('/role/authorise')
    })
}

/**
 * 加载权限树
 */
function loadMenuActionTree(){
    $.ajax({
        type: 'get',
        url: '/getMenuActionTree',
        success: function(data){
            var treeData = assemblyTreeObj(data);
            $.each(treeData,function(key,val) {
                console.log(val.text+":"+val.state.checked);
                if(val.nodes){
                    setParentIsChecked(val.nodes)
                }
            })
            function setParentIsChecked(treeData) {
                $.each(treeData,function(key,val) {
                    console.log(val.text+":"+val.state.checked);
                    if(val.nodes){
                        setParentIsChecked(val.nodes)
                    }
                })
            }
            var $tree = $('#menuActionTree').treeview({
                data: treeData,
                showCheckbox: true,
                expandIcon: 'fa fa-folder',
                collapseIcon: 'fa fa-folder-open',
                onNodeChecked:function(event, node) {          //选中节点
                    var selectNodes = getChildNodeIdArr(node); //获取所有子节点
                    if (selectNodes) {                         //子节点不为空，则选中所有子节点
                        $tree.treeview('checkNode', [selectNodes, { silent: true }]);
                    }
                    setParentNodeCheck(node);                  //所有同级节点选中时，选中父节点
                },
                onNodeUnchecked: function(event, node) {       //取消选中节点
                    var selectNodes = getChildNodeIdArr(node); //获取所有子节点
                    if (selectNodes) {                         //子节点不为空，则取消选中所有子节点
                        $tree.treeview('uncheckNode', [selectNodes, { silent: true }]);
                    }
                    setParentNodeUncheck(node)                 //取消选中其父节点
                },

            });
            //获取所有子节点
            function getChildNodeIdArr(node) {
                var ts = [];
                if (node.nodes) {
                    for (x in node.nodes) {
                        ts.push(node.nodes[x].nodeId);
                        if (node.nodes[x].nodes) {
                            var getNodeDieDai = getChildNodeIdArr(node.nodes[x]);
                            for (j in getNodeDieDai) {
                                ts.push(getNodeDieDai[j]);
                            }
                        }
                    }
                } else {
                    ts.push(node.nodeId);
                }
                return ts;
            }
            //当所有同级节点选中时，选中父节点
            function setParentNodeCheck(node) {
                var parentNode = $tree.treeview("getNode", node.parentId);
                if (parentNode.nodes) {
                    var checkedCount = 0;
                    for (x in parentNode.nodes) {
                        if (parentNode.nodes[x].state.checked) {
                            checkedCount ++;
                        } else {
                            break;
                        }
                    }
                    if (checkedCount === parentNode.nodes.length) {
                        $tree.treeview("checkNode", parentNode.nodeId);
                        setParentNodeCheck(parentNode);
                    }
                }
            }
            //节点取消选中时，同时取消选中其父节点
            function setParentNodeUncheck(node) {
                if(node.parentId != null && node.parentId != undefined){
                    var parentNode = $tree.treeview("getNode", node.parentId);
                    $tree.treeview("uncheckNode",[parentNode, { silent: true }]);
                    if(parentNode.parentId != null && parentNode.parentId != undefined){
                        setParentNodeUncheck(parentNode);
                    }
                }
            }
            // $tree.treeview('expandAll');
            // var findExpandibleNodess = function() {
            //     return $tree.treeview('search', [ $('#input-expand-node').val(), { ignoreCase: false, exactMatch: false } ]);
            // };
            // var expandibleNodes = findExpandibleNodess();
            // $tree.treeview('expandNode', [ expandibleNodes, { silent: $('#chk-expand-silent').is(':checked') }]);
            // 展开|收起 按钮点击事件
            $('#btn-expand-all').on('click', function () {
                $tree.treeview('expandAll');
            });
            $('#btn-collapse-all').on('click', function () {
                $tree.treeview('collapseAll');
            });
            // 全选|反选 按钮点击事件
            $('#btn-check-all').on('click', function () {
                $tree.treeview('checkAll');
            });
            $('#btn-uncheck-all').on('click', function () {
                $tree.treeview('uncheckAll');
            });

        },
        error: function (data) {
            doAlert("加载菜单失败","error");
        }
    })

}