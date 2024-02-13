var _id=null;

$(document).ready(function () {
    initBtns();
    getConfiguration();
});

function save(){
    let valid = true;
    $(".required").each(function(){
        if($(this).val() == null || $(this).val() == ""){
            $(this).focus();
            toastMessage($(this).attr("name") +" es obligatorio",true);
            valid=false;
        }
    });

    if(valid){
        let configuracion={
            id:_id,
            nombreEmprendimiento:$("#nombreEmprendimiento").val(),
            linkUbicacion:$("#linkUbicacion").val(),
            whatsApp:$("#whatsApp").val(),
        }

        $.ajax({
            url : "/configuracion/create",
            type : 'POST',
            data : JSON.stringify(configuracion),
            contentType:"application/json",
            dataType:"json",
            success: function(response){
                if(response.status="ok"){
                    toastMessage("Cambios guardados",false);
                }
            },
        });
    }
}

function getConfiguration(){
    $.ajax({
        url : "/configuracion/get",
        type : 'GET',
        success: function(response){
            if(response!= null){
                let configuracion = response;
                _id=configuracion.id;

                $(".input-form").each(function(){
                    $(this).val(configuracion[$(this).attr("id")]);
                });                
            }
        },
    });
}

function toastMessage(message, isError){
    const toast = $(".toast");
    if(!isError){
        toast.removeClass("text-bg-danger");
        toast.addClass("text-bg-primary");    
    }else{
        toast.removeClass("text-bg-primary");
        toast.addClass("text-bg-danger");
    }

    const toastBootstrap = bootstrap.Toast.getOrCreateInstance(toast);

    $(".toast-body").html(message);
    toastBootstrap.show();
}

function initBtnCancelar(){
    $("#cancelarProducto").unbind('click');
    $("#cancelarProducto").click(function(){
        if(actionHelper){
            $("."+actionHelper).css("display","none");
            $("."+action).css("display","block");
        }else
            history.back();
    });
}

function initBtns(){
    initBtnCancelar();
    initBtnGuardar();
}

function initBtnGuardar(){
    $("#guardarProducto").unbind('click');
    $("#guardarProducto").click(function(){
        save();
    });
}

function capitalizerFirstLetter(str) {
    return str.charAt(0).toUpperCase() + str.slice(1);
}