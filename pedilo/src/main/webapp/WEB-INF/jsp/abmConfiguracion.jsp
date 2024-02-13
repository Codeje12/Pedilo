<%@include file="encabezado.jsp"%>
    <link rel="stylesheet" href="../css/abmConfiguracion.css">

    <script src="../js/demo/abmConfiguracion.js"></script>
    <body id="page-top">
            <div id="wrapper">
                <div class="side-bar">
                    <%@include file="menu.jsp" %>
                </div>
                <div class="container">

                <!-- Edit Create -->
                    <div class="container-form">

                        <div class="main-inputs">
                           <div class="col-md input-container">
                               <div class="form-floating">
                                 <input type="text" class="form-control input-form required" id="nombreEmprendimiento" name="nombreEmprendimiento" placeholder="Nombre..." >
                                 <label for="nombreEmprendimiento">nombre</label>
                               </div>
                           </div>
                           <div class="col-md input-container">
                               <div class="form-floating">
                                 <input class="form-control input-form required" name="linkUbicacion" id="linkUbicacion" >
                                 <label for="linkUbicacion">Link de su ubicaci&oacute;n</label>
                               </div>
                           </div>
                        </div>

                        <div class="main-inputs">
                            <div class="col-md input-container">
                               <div class="form-floating">
                                 <input class="form-control input-form required" name="whatsApp" id="whatsApp" >
                                 <label for="whatsApp">N&uacute;mero de WhatsApp</label>
                               </div>
                            </div>
                        </div>

                        <div class="container container-btns">
                            <button id="guardarProducto" type="button" class="btn btn-primary">Confirmar</button>
                            <button id="cancelarProducto" type="button" class="btn btn-danger">Cancelar</button>
                        </div>
                    </div>
                </div>
            </div>
     <!-- End of Page Wrapper -->

     <!-- Scroll to Top Button-->
     <a class="scroll-to-top rounded" href="#page-top">
         <i class="fas fa-angle-up"></i>
     </a>
<%@include file="piePagina.jsp"%>