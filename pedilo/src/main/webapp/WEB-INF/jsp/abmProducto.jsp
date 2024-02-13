<%@include file="encabezado.jsp"%>
    <link rel="stylesheet" href="../css/abmProducto.css">

    <script>
        var action = "${model.action}";
    </script>

    <script src="../js/demo/abmProducto.js"></script>
    <body id="page-top">
            <div id="wrapper">
                <div class="side-bar">
                    <%@include file="menu.jsp" %>
                </div>
                <div class="container">

                <!-- DataTale -->
                    <div class="list card shadow mb-4 hiden">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Productos</h6>
                            <a class="btn btn-primary btn-add" href="#" role="button">+</a>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table caption-top" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Id</th>
                                            <th>Nombre</th>
                                            <th>Precio</th>
                                            <th>Activo</th>
                                            <th>Tipo de Unidad</th>
                                            <th>Imagen</th>
                                            <th>Acciones</th>
                                        </tr>
                                    </thead>
                                    <tbody class="body-table">
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                <!-- Edit Create -->
                    <div class="container-form create edit hiden">

                        <div class="main-inputs">
                           <div class="col-md input-container">
                               <div class="form-floating">
                                 <input type="text" class="form-control input-form required" id="nombre" name="nombre" placeholder="Nombre..." >
                                 <label for="nombre">nombre</label>
                               </div>
                           </div>
                           <div class="col-md input-container">
                               <div class="form-floating">
                                 <input type="number" class="form-control input-form required" name="precio" id="precio" >
                                 <label for="precio">Precio</label>
                               </div>
                           </div>
                        </div>

                        <div class="main-inputs">
                           <div class="col-md input-container form-check">
                             <input class="form-check-input input-form" type="checkbox" id="activo" checked>
                             <label class="form-check-label" for="activo">
                               Activo?
                             </label>
                           </div>
                           <div class="col-md input-container">
                               <div class="form-floating">
                                 <select class="form-select required input-form" name="tipoUnidad" id="tipoUnidad">
                                   <option selected></option>
                                 </select>
                                 <label for="tipoUnidad">Tipo de unidad</label>
                               </div>
                           </div>
                        </div>

                        <div class="main-inputs">
                           <div class="col-md input-container">
                               <div class="form-floating">
                                 <textarea class="form-control input-form" placeholder="Descripcion breve..." id="descripcion" style="height: 100px"></textarea>
                                 <label for="descripcion">Descripcion breve</label>
                               </div>
                           </div>
                           <div class="col-md input-container">
                               <div class="mb-3">
                                 <label for="formFile" class="form-label">Seleccione una imagen</label>
                                   <form method="POST" enctype="multipart/form-data" id="uploadForm">
                                     <input class="form-control" accept=".jpeg,.jpg,.png" type="file" id="img">
                                     <input id="submitHelper" type="submit" value="Subir" class="hiden"/>
                                   </form>
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