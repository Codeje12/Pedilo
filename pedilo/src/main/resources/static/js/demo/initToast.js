$(document).ready(function () {
    function toastMessage(message, type){
        const toast = $(".toast");
        const toastBootstrap = bootstrap.Toast.getOrCreateInstance(toast);
        
        $(".toast-body").html(message);
        toastBootstrap.show();
    }   
});