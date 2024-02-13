var actionHelper =null;
var _id=null;
var _imgHelper;

$(document).ready(function () {
    
    $("."+action).css("display","block");

    cargarTipoUnidad();
    initBtns();
    listarProductos();
});

function save(){
    let valid = true;
    $(".required").each(function(){
        if($(this).val() == null || $(this).val() == ""){
            $(this).focus();
            toastMessage($(this).attr("name") +" es obligatorio","error");
            valid=false;
        }
    });

    if(valid){
        $.ajax({
            url : "/tipoUnidad/"+parseInt($("#tipoUnidad").val()),
            type : 'GET',
            success: function(responseEntity){
                let tipoUnidad = responseEntity;
                let extension;
                let hayImgCargada = document.getElementById('img').files[0];
                if(hayImgCargada){
                    extension = getFileExtension(document.getElementById('img').files[0]?.name);
                    _imgHelper = "producto_"+_id+"."+extension;
                }

                let producto={
                    id:_id,
                    tipoUnidad:tipoUnidad,
                    activo:$('#activo').is(":checked"),
                    nombre:$("#nombre").val(),
                    precio:$("#precio").val(),
                    imagen:_imgHelper,
                    descripcion:$("#descripcion").val()
                }

                //GUARDO LA IMG si no esta vacia
                if(hayImgCargada){
                    saveFileUpload();
                }

                $.ajax({
                    url : "/producto/create",
                    type : 'POST',
                    data : JSON.stringify(producto),
                    contentType:"application/json",
                    dataType:"json",
                    success: function(response){
                        if(response.status="ok"){
                            window.location.href="/producto/index";
                        }
                    },
                });
            },
        });
    }
}

function getFileExtension(filename) {
    return filename.split('.').pop();
  }

function listarProductos(){
    $.ajax({
        url : "/producto/list",
        type : 'GET',
        success: function(response){
            response.forEach(producto => {
                let activoAccionNombre = producto.activo?"desactivar":"activar";
                let style= !producto.activo ?"class=table-danger":"";
                $(".body-table").append(`
                                        <tr ${style}>
                                            <td>${producto.id}</td>
                                            <td>${producto.nombre}</td>
                                            <td>$ ${producto.precio}</td>
                                            <td>${producto.activo ?"Si":"No"}</td>
                                            <td>${producto.tipoUnidad.nombre}</td>
                                            <td>${producto.imagen!=null?producto.imagen:""}</td>                                            
                                            <td>
                                                <div class="d-grid gap-2 d-md-block">
                                                    <button class="btn btn-success btn-edit" data-id="${producto.id}" type="button">Editar</button>
                                                    <button class="btn btn-${producto.activo?"danger":"info"} btn-activo" data-id="${producto.id}" type="button">${capitalizerFirstLetter(activoAccionNombre)}</button>
                                                </div>
                                            </td>
                                        </tr>
                `);
            });

            $(".btn-edit").unbind('click');
            $(".btn-edit").click(function(e){
                _id=$(this).attr("data-id");
                editar(_id);
            });

            $(".btn-activo").unbind('click');
            $(".btn-activo").click(function(e){
                activoEvaluate($(this).attr("data-id"));
            });
        },
    });
}

function editar(id){
    $.ajax({
        url : "/producto/"+id,
        type : 'GET',
        success: function(response){
            let producto = response;
            actionHelper = "edit";

            $("."+action).css("display","none");
            $("."+actionHelper).css("display","block");

            _imgHelper =  producto.imagen;

            $(".input-form").each(function(){
                if($(this).attr("id") === "activo")
                    $("#"+$(this).attr("id")).prop('checked', producto.activo);
                else if($(this).attr("id") === "tipoUnidad")
                    $("#"+$(this).attr("id")+" option[value="+ producto[$(this).attr("id")].id +"]").attr("selected",true);
                else
                    $(this).val(producto[$(this).attr("id")]);
            });
        },
    });
}

function toastMessage(message, type){
    const toast = $(".toast");
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
    initBtnNuevo();
    initBtnCancelar();  
    initBtnGuardar();
    //initBtnFileUpload();    
}

function initBtnGuardar(){
    $("#guardarProducto").unbind('click');
    $("#guardarProducto").click(function(){
        save();
    });
}

function initBtnNuevo(){
    $(".btn-add").click(function(){
        window.location.href="/producto/nuevo"
    });
}

function saveFileUpload(){
    $("#uploadForm").on('submit', function(e){        
        e.preventDefault();
        let file = e.target[0].files[0];
        let dataForm = new FormData();
        dataForm.append("file",file);
        dataForm.append("id",_id);

        $.ajax({
            url : "/producto/fileUpload",
            type : 'POST',
            data: dataForm,
            contentType: false,
            cache: false,
            processData:false,        
            success: function(response){
                if(response.status =="ok"){
                 //NADA   
                }
            },
        });
    });
    $("#submitHelper").click();    
}

function cargarTipoUnidad(){
    $.ajax({
        url : "/tipoUnidad/list",
        type : 'GET',
        success: function(responseEntity){
            let tipoUnidades = responseEntity;
            tipoUnidades.forEach(tipoUnidad => {
                $("#tipoUnidad").append(`
                       <option value="${tipoUnidad.id}">${tipoUnidad.nombre}</option>
                `);
            });
        },
    });
}

function activoEvaluate(idProducto){
    $.ajax({
        url : "/producto/activo",
        type : 'POST',
        data : {"id":idProducto},
        success: function(response){
            if(response.status="ok"){
                window.location.href="/producto/index";
            }
        },
    });
}

function capitalizerFirstLetter(str) {
    return str.charAt(0).toUpperCase() + str.slice(1);
  }