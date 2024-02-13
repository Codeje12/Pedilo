<%@include file="encabezado.jsp" %>

<script>
var _ruta = '${model.ruta}';
</script>
    <script src="../js/index.js"></script>
    <!-- Page Wrapper -->
    <div id="wrapper">

        <!--div class="side-bar">
            <%@include file="menu.jsp" %>
        </div-->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <h1 class="h3 mb-2 text-gray-800"> Pedilo </h1>
                <p class="mb-4">Eleg&iacute; los productos y hace el pedido</p>

                <div class="productos-render-main col-xs-12 col-md-10">
                </div>

            </div>
            <!-- /.container-fluid -->
            </div>
            <!-- End of Main Content -->
        </div>
        <!-- End of Content Wrapper -->

    </div>
<%@include file="piePagina.jsp" %>