/**
 * 加载更多搜索下拉框以及激活日期控件
 */
$(function () {
    $("button[data-toggle='popover']").popover({
        html: true
    }).on('shown.bs.popover', function () {
        $('.input-group-date').datetimepicker({
            format: 'YYYY-MM-DD'
        });
    });
    //点击popover区域外隐藏popover
    $(document).on('click', function (e) {
        $('[data-toggle="popover"],[data-original-title]').each(function () {
            //the 'is' for buttons that trigger popups
            //the 'has' for icons within a button that triggers a popup
            if (!$(this).is(e.target) && $(this).has(e.target).length === 0 && $('.popover').has(e.target).length === 0) {
                (($(this).popover('hide').data('bs.popover')||{}).inState||{}).click = false  // fix for BS 3.3.6
            }

        });
    });
})

/**
 * 时间戳格式化为：yyyy-MM-dd hh:mm:ss
 */
function dateFormatter(cellval) {
    var dateVal = cellval + "";
    if (cellval != null) {
        var date = new Date(parseInt(dateVal.replace("/Date(", "").replace(")/", ""), 10));
        var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
        var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();

        var hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
        var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
        var seconds = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();

        return date.getFullYear() + "-" + month + "-" + currentDate + " " + hours + ":" + minutes + ":" + seconds;
    }
}

/**
 * 将list数据组装为有层次的数组数据
 * 节点id：pkId;  父节点id: parentId;  childs: 组装时存放子节点数据用
 * @param sNodes
 * @returns {Array}
 */
function assemblyTreeObj(sNodes) {
    var re = [];
    var tempMap = [];
    var key = "id";
    var parentkey = "parentId";
    var childskey = "nodes";
    for(var i=0; i<sNodes.length; i++){
        tempMap[sNodes[i][key]] = sNodes[i];
    }
    for(var i=0; i<sNodes.length; i++){
        if(tempMap[sNodes[i][parentkey]]){
            if(!tempMap[sNodes[i][parentkey]][childskey]){
                tempMap[sNodes[i][parentkey]][childskey] = [];
            }
            tempMap[sNodes[i][parentkey]][childskey].push(sNodes[i]);
        }else {
            re.push(sNodes[i]);
        }
    }
    return re;
}

/**
 * 获取treeview所有子节点
 * @param node
 * @returns {Array}
 */
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

/**
 * 所有子节点选中时设置父节点选中
 * @param node
 */
function setParentNodeCheck(node,$tree) {
    var selectNodes = getChildNodeIdArr(node); //获取所有子节点
    if (selectNodes) { //子节点不为空，则选中所有子节点
        $tree.treeview('checkNode', [selectNodes, { silent: true }]);
    }
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

/**
 * 子节点取消选中时父节点也取消选中
 * @param node
 */
function setParentNodeUncheck(node,$tree) {
    if(node.parentId != null && node.parentId != undefined){
        var parentNode = $tree.treeview("getNode", node.parentId);
        $tree.treeview("uncheckNode",[parentNode, { silent: true }]);
        if(parentNode.parentId != null && parentNode.parentId != undefined){
            setParentNodeUncheck(parentNode);
        }
    }
}