function doAlert(msg, cls){
    var tp = BootstrapDialog.TYPE_PRIMARY;
    switch (cls){
        case 'info':
            tp = BootstrapDialog.TYPE_INFO; break;
        case 'success':
            tp = BootstrapDialog.TYPE_SUCCESS; break;
        case 'danger':
            tp = BootstrapDialog.TYPE_DANGER; break;
        case 'error':
            tp = BootstrapDialog.TYPE_DANGER; break;
        case 'warning':
            tp = BootstrapDialog.TYPE_WARNING; break;
        default :
            tp = BootstrapDialog.TYPE_PRIMARY;
    }
    BootstrapDialog.show({
        type : tp,
        title : msg,
        size : BootstrapDialog.SIZE_SMALL,//SIZE_SMALL, SIZE_NORMAL, SIZE_WIDE, SIZE_LARGE
        cssClass: 'dialogtip'
    });
}
