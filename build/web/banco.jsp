<%-- 
    Document   : Transacciones Bancarias
    Author     : Danilo Castilla
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="dao.Conexion"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.CajeroDAO"%>
<%@page import="modelo.Cajero"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta charset="utf-8" />
        <title>Transacciones Bancarias</title>

        <meta name="description" content="Christian Gámez Udemy" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

        <%@include file="css.jsp" %>
    </head>

    <body class="no-skin">
        <div id="navbar" class="navbar navbar-default          ace-save-state">
            <div class="navbar-container ace-save-state" id="navbar-container">
                <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
                    <span class="sr-only">Toggle sidebar</span>

                    <span class="icon-bar"></span>

                    <span class="icon-bar"></span>

                    <span class="icon-bar"></span>
                </button>

                <div class="navbar-header pull-left">
                    <a href="index.jsp" class="navbar-brand">
                        <small>
                            <%//<i class="fa fa-book"></i>%>
                            Transacciones Bancarias
                        </small>
                    </a>
                </div>

                
            </div><!-- /.navbar-container -->
        </div>

        <div class="main-container ace-save-state" id="main-container">
            <script type="text/javascript">
                try {
                    ace.settings.loadState('main-container')
                } catch (e) {
                }
            </script>

            <div id="sidebar" class="sidebar                  responsive                    ace-save-state">
                <script type="text/javascript">
                    try {
                        ace.settings.loadState('sidebar')
                    } catch (e) {
                    }
                </script>

              

                <ul class="nav nav-list">
                    <li class="">
                        <a href="index.jsp">
                            <i class="menu-icon fa fa-tachometer"></i>
                            <span class="menu-text"> Inicio </span>
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="active open">
                        <a href="#" class="dropdown-toggle">
                            <i class="menu-icon fa fa-book"></i>
                            <span class="menu-text"> Gestion Banco </span>

                            <b class="arrow fa fa-angle-down"></b>
                        </a>

                        <b class="arrow"></b>

                        <ul class="submenu">
                            <li class="active">
                                <a href="index.jsp">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Ver Usuarios
                                </a>

                                <b class="arrow"></b>
                            </li>
                            <li class="">
                                <a href="resgistroUsuarios.jsp">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Registrar Usuarios
                                </a>

                                <b class="arrow"></b>
                            </li>
                            <li class="">
                                <a href="transacciones.jsp">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Transacciones
                                </a>

                                <b class="arrow"></b>
                            </li>
                            <li class="">
                                <a href="loginconsignaciones.jsp">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Consignaciones
                                </a>

                                <b class="arrow"></b>
                            </li>
                            <li class="">
                                <a href="loginretiros.jsp">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Retiros
                                </a>

                                <b class="arrow"></b>
                            </li>
                        </ul>
                    </li>

                </ul><!-- /.nav-list -->

                <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
                    <i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
                </div>
            </div>

            <div class="main-content">
                <div class="main-content-inner">
                    <div class="page-content">
                        <div class="page-header">
                            <h1>
                                Sistemas Transaccionales  
                            </h1>
                        </div><!-- /.page-header -->
                            
                        <div class="row">
                                    <div class="col-xs-12">
                                        <div class="table-header">
                                            Usuarios Registrados
                                        </div>
                                        <!-- div.table-responsive -->
                                        <!-- div.dataTables_borderWrap -->
                                        <%
                                           Connection con = Conexion.conectar();
                                           PreparedStatement ps;
                                           ResultSet rs;
                                           
                                           ps=con.prepareStatement("SELECT * FROM cajeros");
                                           rs=ps.executeQuery();
                                           
                                        %>
                                        <div>
                                            <table id="dynamic-table" class="table table-striped table-bordered table-hover">
                                                <thead>
                                                    <tr>
                                                        <th> Numero de la Cuenta </th>
                                                        <th> Titular </th>
                                                        <th> Clave </th>
                                                        <th> Saldo </th>
                                                    </tr>
                                                    <%
                                                        while(rs.next()){
                                                    %>
                                                    <tr>
                                                        <td><%= rs.getInt("numero_cuenta")%></td> <!--numero_cuenta-->
                                                        <td><%= rs.getString("titular")%></td><!--titular-->
                                                        <td><%= rs.getShort("clave")%></td><!--clave-->
                                                        <td><%= rs.getInt("saldo")%></td><!--saldo-->
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td> 
                                                        </td>
                                                        <td class="hidden-480"></td>
                                                        <td></td>
                                                        <td></td>
                                                    </tr>
                                                </tbody>
                                                <%}%>
                        
                        
                        <div class="row">
                            <div class="col-xs-12">
                                <!-- PAGE CONTENT BEGINS -->
                                <!-- /.row -->

                                <div class="row">
                                    <div class="col-xs-12">
                                        <!-- div.table-responsive -->

                                        <!-- div.dataTables_borderWrap -->
                                            <table id="dynamic-table" class="table table-striped table-bordered table-hover">
                                            </table>
                                        </div>
                                    </div><!-- /.modal-content -->
                                </div><!-- /.modal-dialog -->
                            </div>

                            <!-- PAGE CONTENT ENDS -->
                        </div><!-- /.col -->
                    </div><!-- /.row -->
                </div><!-- /.page-content -->
            </div>
        </div><!-- /.main-content -->

        

        <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
            <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
        </a>


        <!-- basic scripts -->

        <!--[if !IE]> -->
        <script src="assets/js/jquery-2.1.4.min.js"></script>

        <!-- <![endif]-->

        <!--[if IE]>
<script src="assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
        <script type="text/javascript">
                    if ('ontouchstart' in document.documentElement)
                        document.write("<script src='assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
        </script>
        <script src="assets/js/bootstrap.min.js"></script>

        <!-- page specific plugin scripts -->
        <script src="assets/js/jquery.dataTables.min.js"></script>
        <script src="assets/js/jquery.dataTables.bootstrap.min.js"></script>
        <script src="assets/js/dataTables.buttons.min.js"></script>
        <script src="assets/js/buttons.flash.min.js"></script>
        <script src="assets/js/buttons.html5.min.js"></script>
        <script src="assets/js/buttons.print.min.js"></script>
        <script src="assets/js/buttons.colVis.min.js"></script>
        <script src="assets/js/dataTables.select.min.js"></script>

        <!-- ace scripts -->
        <script src="assets/js/ace-elements.min.js"></script>
        <script src="assets/js/ace.min.js"></script>

        <!-- inline scripts related to this page -->
        <script type="text/javascript">
                    jQuery(function ($) {
                        //initiate dataTables plugin
                        var myTable =
                                $('#dynamic-table')
                                //.wrap("<div class='dataTables_borderWrap' />")   //if you are applying horizontal scrolling (sScrollX)
                                .DataTable({
                                    bAutoWidth: false,
                                    "aoColumns": [
                                        {"bSortable": false},
                                        null, null, null, null, null,
                                        {"bSortable": false}
                                    ],
                                    "aaSorting": [],

                                    //"bProcessing": true,
                                    //"bServerSide": true,
                                    //"sAjaxSource": "http://127.0.0.1/table.php"	,

                                    //,
                                    //"sScrollY": "200px",
                                    //"bPaginate": false,

                                    //"sScrollX": "100%",
                                    //"sScrollXInner": "120%",
                                    //"bScrollCollapse": true,
                                    //Note: if you are applying horizontal scrolling (sScrollX) on a ".table-bordered"
                                    //you may want to wrap the table inside a "div.dataTables_borderWrap" element

                                    //"iDisplayLength": 50


                                    select: {
                                        style: 'multi'
                                    }
                                });



                        $.fn.dataTable.Buttons.defaults.dom.container.className = 'dt-buttons btn-overlap btn-group btn-overlap';

                        new $.fn.dataTable.Buttons(myTable, {
                            buttons: [
                                {
                                    "extend": "colvis",
                                    "text": "<i class='fa fa-search bigger-110 blue'></i> <span class='hidden'>Show/hide columns</span>",
                                    "className": "btn btn-white btn-primary btn-bold",
                                    columns: ':not(:first):not(:last)'
                                },
                                {
                                    "extend": "copy",
                                    "text": "<i class='fa fa-copy bigger-110 pink'></i> <span class='hidden'>Copy to clipboard</span>",
                                    "className": "btn btn-white btn-primary btn-bold"
                                },
                                {
                                    "extend": "csv",
                                    "text": "<i class='fa fa-database bigger-110 orange'></i> <span class='hidden'>Export to CSV</span>",
                                    "className": "btn btn-white btn-primary btn-bold"
                                },
                                {
                                    "extend": "excel",
                                    "text": "<i class='fa fa-file-excel-o bigger-110 green'></i> <span class='hidden'>Export to Excel</span>",
                                    "className": "btn btn-white btn-primary btn-bold"
                                },
                                {
                                    "extend": "pdf",
                                    "text": "<i class='fa fa-file-pdf-o bigger-110 red'></i> <span class='hidden'>Export to PDF</span>",
                                    "className": "btn btn-white btn-primary btn-bold"
                                },
                                {
                                    "extend": "print",
                                    "text": "<i class='fa fa-print bigger-110 grey'></i> <span class='hidden'>Print</span>",
                                    "className": "btn btn-white btn-primary btn-bold",
                                    autoPrint: false,
                                    message: 'This print was produced using the Print button for DataTables'
                                }
                            ]
                        });
                        myTable.buttons().container().appendTo($('.tableTools-container'));

                        //style the message box
                        var defaultCopyAction = myTable.button(1).action();
                        myTable.button(1).action(function (e, dt, button, config) {
                            defaultCopyAction(e, dt, button, config);
                            $('.dt-button-info').addClass('gritter-item-wrapper gritter-info gritter-center white');
                        });


                        var defaultColvisAction = myTable.button(0).action();
                        myTable.button(0).action(function (e, dt, button, config) {

                            defaultColvisAction(e, dt, button, config);


                            if ($('.dt-button-collection > .dropdown-menu').length == 0) {
                                $('.dt-button-collection')
                                        .wrapInner('<ul class="dropdown-menu dropdown-light dropdown-caret dropdown-caret" />')
                                        .find('a').attr('href', '#').wrap("<li />")
                            }
                            $('.dt-button-collection').appendTo('.tableTools-container .dt-buttons')
                        });

                        ////

                        setTimeout(function () {
                            $($('.tableTools-container')).find('a.dt-button').each(function () {
                                var div = $(this).find(' > div').first();
                                if (div.length == 1)
                                    div.tooltip({container: 'body', title: div.parent().text()});
                                else
                                    $(this).tooltip({container: 'body', title: $(this).text()});
                            });
                        }, 500);





                        myTable.on('select', function (e, dt, type, index) {
                            if (type === 'row') {
                                $(myTable.row(index).node()).find('input:checkbox').prop('checked', true);
                            }
                        });
                        myTable.on('deselect', function (e, dt, type, index) {
                            if (type === 'row') {
                                $(myTable.row(index).node()).find('input:checkbox').prop('checked', false);
                            }
                        });




                        /////////////////////////////////
                        //table checkboxes
                        $('th input[type=checkbox], td input[type=checkbox]').prop('checked', false);

                        //select/deselect all rows according to table header checkbox
                        $('#dynamic-table > thead > tr > th input[type=checkbox], #dynamic-table_wrapper input[type=checkbox]').eq(0).on('click', function () {
                            var th_checked = this.checked;//checkbox inside "TH" table header

                            $('#dynamic-table').find('tbody > tr').each(function () {
                                var row = this;
                                if (th_checked)
                                    myTable.row(row).select();
                                else
                                    myTable.row(row).deselect();
                            });
                        });

                        //select/deselect a row when the checkbox is checked/unchecked
                        $('#dynamic-table').on('click', 'td input[type=checkbox]', function () {
                            var row = $(this).closest('tr').get(0);
                            if (this.checked)
                                myTable.row(row).deselect();
                            else
                                myTable.row(row).select();
                        });



                        $(document).on('click', '#dynamic-table .dropdown-toggle', function (e) {
                            e.stopImmediatePropagation();
                            e.stopPropagation();
                            e.preventDefault();
                        });



                        //And for the first simple table, which doesn't have TableTools or dataTables
                        //select/deselect all rows according to table header checkbox
                        var active_class = 'active';
                        $('#simple-table > thead > tr > th input[type=checkbox]').eq(0).on('click', function () {
                            var th_checked = this.checked;//checkbox inside "TH" table header

                            $(this).closest('table').find('tbody > tr').each(function () {
                                var row = this;
                                if (th_checked)
                                    $(row).addClass(active_class).find('input[type=checkbox]').eq(0).prop('checked', true);
                                else
                                    $(row).removeClass(active_class).find('input[type=checkbox]').eq(0).prop('checked', false);
                            });
                        });

                        //select/deselect a row when the checkbox is checked/unchecked
                        $('#simple-table').on('click', 'td input[type=checkbox]', function () {
                            var $row = $(this).closest('tr');
                            if ($row.is('.detail-row '))
                                return;
                            if (this.checked)
                                $row.addClass(active_class);
                            else
                                $row.removeClass(active_class);
                        });



                        /********************************/
                        //add tooltip for small view action buttons in dropdown menu
                        $('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});

                        //tooltip placement on right or left
                        function tooltip_placement(context, source) {
                            var $source = $(source);
                            var $parent = $source.closest('table')
                            var off1 = $parent.offset();
                            var w1 = $parent.width();

                            var off2 = $source.offset();
                            //var w2 = $source.width();

                            if (parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2))
                                return 'right';
                            return 'left';
                        }




                        /***************/
                        $('.show-details-btn').on('click', function (e) {
                            e.preventDefault();
                            $(this).closest('tr').next().toggleClass('open');
                            $(this).find(ace.vars['.icon']).toggleClass('fa-angle-double-down').toggleClass('fa-angle-double-up');
                        });
                        /***************/





                        /**
                         //add horizontal scrollbars to a simple table
                         $('#simple-table').css({'width':'2000px', 'max-width': 'none'}).wrap('<div style="width: 1000px;" />').parent().ace_scroll(
                         {
                         horizontal: true,
                         styleClass: 'scroll-top scroll-dark scroll-visible',//show the scrollbars on top(default is bottom)
                         size: 2000,
                         mouseWheelLock: true
                         }
                         ).css('padding-top', '12px');
                         */


                    })
        </script>
    </body>
</html>

