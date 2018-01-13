function login() {
    var form = $('form');
    var account = form.find('[name=username]').val().trim();
    var pwd = form.find('[name=password]').val().trim();
    if(account == null  || account == '' || account == undefined
        || pwd == null  || pwd == '' || pwd == undefined){
        doAlert("请输入用户名密码",'danger')
        return false;
    }
    // var params = $('form').serializeArray();
    var params ={'account':account, 'pwd':pwd};
    $.ajax({
        type: 'post',
        url: '/login',
        data: params,
        success: function(data){
            if(data.status == 'ERROR'){
                doAlert(data.message, 'danger');
            }else{
                window.location.href="/index";
            }

        },
        error: function (data) {
            doAlert(data.message, 'danger');
        }
    })
}