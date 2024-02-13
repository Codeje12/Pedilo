let numeroWhatsapp = "https://wa.me/5493764897567";
$(document).ready(function () {
    
    listarProductos();
});


function listarProductos(){
    $.ajax({
        url : "/producto/list",
        type : 'GET',
        success: function(response){
            let i = 1;
            let divImgContainer="";
            let divImg ='';
            let classMobile ="";
            var detector = new MobileDetect(window.navigator.userAgent)
            let sizeImg ="width='450' height='450'";

            if( (detector.mobile() || detector.phone() || detector.tablet() || detector.os()) ){
                        classMobile ="card shadow";
                        sizeImg = "width='300' height='400'";
            }

            response.forEach(producto => {
                let img = producto.imagen?producto.imagen:"sin-imagen.png";
                let pathImg = "img/producto/"+img;

                divImg +=`<div class="container container-fluid"> 
                                <div class="producto-id_${producto.id}">
                                    <h4>${producto.nombre}</h4>
                                    <img src="${pathImg}" ${sizeImg}/>
                                    <a class="btn btn-primary" href="${numeroWhatsapp+"?text=Hola+Jose.+ Quiero+pedir+lo+siguiente:"+producto.nombre}" target="_blank"> Pedir</a>                                    
                                </div>
                            </div>`;


                if(i==4){
                    divImgContainer += `<div class="productos-render ${classMobile}" style="display:flex;">
                                            ${divImg}
                                        </div>`;

                    divImg="";
                    i=1;
                }else
                    i++;                                    
            });

            $(".productos-render-main").append(divImgContainer);
        },
    });
}