var _idsPedido=[];
$(document).ready(function() {
  //$('#dataTable').DataTable();

  $('.side-bar').append(``);

    $(".add-product").click(function(){
      let button = $(this);
      let idProducto = $(this).attr("attr").split("-")[0];

      if(!_idsPedido.includes(idProducto)){
        _idsPedido.push(idProducto);
      }

      button.hide();
      $(".add-sub").removeClass("hide");
    });

});
