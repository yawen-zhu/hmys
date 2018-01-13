/**
 * 进入首页时动态加载菜单
 */
$(function () {
    $.ajax({
        type: 'get',
        url: '/menu',
        success: function(resp){
            var menuList = resp.data;
            var menuTree = assemblyTreeObj(menuList);
            var html = "";
            $(menuTree).each(function (i,menu) {
                html += "<li><a><i class='fa fa-gear'></i>"+menu.text+"<span class='fa fa-chevron-down'></span></a> <ul class='nav child_menu'>";
                $(menu.nodes).each(function (j,submenu) {
                    html += "<li><a href='"+submenu.murl+"?id="+submenu.id+"' target='menuFrame'>"+submenu.text+"</a></li>";
                })
                html += '</ul></li>';
            })
            $("#menuTree").append($.parseHTML(html));
            //菜单绑定展开以及点击事件
            init_sidebar();
            //展开第一个菜单
            var $li = $('#sidebar-menu').find('li:first');
            $li.addClass('active');
            $('ul:first', $li).slideDown();
        },
        error: function (data) {
            alert("加载菜单失败");
        }
    })

})

