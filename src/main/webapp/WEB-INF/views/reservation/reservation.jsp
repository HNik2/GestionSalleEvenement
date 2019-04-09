<%@ include file="/WEB-INF/views/includes/includes.jsp" %>
<!DOCTYPE html>
<html lang="fr">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Gestion de salle Evenement</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=request.getContextPath() %>/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="<%=request.getContextPath() %>/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%=request.getContextPath() %>/resources/dist/css/sb-admin-2.css" rel="stylesheet">
    
    <!-- DataTables CSS -->
    <link href="<%=request.getContextPath() %>/resources/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="<%=request.getContextPath() %>/resources/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<%=request.getContextPath() %>/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            
            <%@ include file="/WEB-INF/views/menu_top/topMenu.jsp" %>
			
            <%@ include file="/WEB-INF/views/menu_left/leftMenu.jsp" %>
            <!-- /.navbar-static-side -->
        </nav>

        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header"><fmt:message code="common.salle" /></h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                
                <div class="row">
					<div class="col-lg-12">
						<ol class="breadcrumb">
						  <li><a href="<c:url value="/salle/nouveau" />" ><i class="fa fa-plus">&nbsp;<fmt:message code="common.ajouter" /></i></a></li>
						  <c:url value="/salle/export/" var = "export"/>
						  <li><a href="${export}"><i class="fa fa-download">&nbsp;<fmt:message code="common.exporter" /></i></a></li>
						  <li><a href="#"><i class="fa fa-upload">&nbsp;<fmt:message code="common.importer" /></i></a></li>
						</ol>					
					</div>                
                </div>
                
                <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <fmt:message code="salle.liste" />
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                    	<th><fmt:message code="common.photo" /></th>
                                        <th><fmt:message code="common.nom" /></th>
                                        <th><fmt:message code="common.prix" /></th>
                                		<th><fmt:message code="common.code" /></th>
                                		<th><fmt:message code="common.place" /></th>
                                		<th><fmt:message code="common.parametrage.ville" /></th>
                                        <th><fmt:message code="common.parametrage.categorie" /></th>
                                        <th><fmt:message code="common.date" /></th>
                                      
                                   
                                    </tr>
                                </thead>
                                <tbody>
                                	
	                                    <tr class="odd gradeX">
	                                 		<td class="center"><img src="${reservation.getSalle().getPhoto() }" width="200px" height="100px"/></td>
	                                        <td>${reservation.getSalle().getNom() }</td>
	                                        <td >${reservation.getSalle().getPrix() }</td>
	                                        <td >${reservation.getSalle().getCodeSalle() }</td>
	                                        <td >${reservation.getSalle().getNbrePlace() }</td>
	                                        <td >${reservation.getSalle().getVilleSal().getNomVille() }</td>
	                                        <td>${reservation.getSalle().getCatgori().getLibelle()}</td>
	                                        
	                                    </tr>
                                	
                                </tbody>
                            </table>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                
                <div class="col-lg-12">
                 	<h4 class="page-header">Informations réservation</h4>
                 	<c:url value="/reservation/enregistrerReservation" var ="urlReserveEng" />
                 	<f:form role = "form" modelAttribute="reservation" action="${urlReserveEng }" enctype="multipart/form-data">
                    
                    
                    <div class="col-sm-4">
	                    <div class="panel-body">
		                    
		     					<div class="form-group">
                                        <label>Date de l'événement</label>
                                        <f:input id="date" path="dateEvenement" class="form-control" placeholder="Date" type="date" required="required" />
                                   </div>
											
							
		                        
		                     	
	                      </div>
	                      <div class="panel-body">
		                    
		     					<div class="form-group">
                                        <label>Heure de l'événement</label>
                                        <f:input id="heure" path="heureEvenement" class="form-control" placeholder="Heure" type="time" required="required" />
                                   </div>
											
							
		                        
		                     	
	                      </div>
                    </div>
                   
                    <div class="col-sm-4">
                    <div class="panel-footer">
                                    	<button type="submit" class="btn btn-primary"><i class="fa fa-save">&nbsp;<fmt:message code="common.enregister" /></i></button>
                                    	<a href="<c:url value="/reservation/" />" class="btn btn-danger"> <i class="fa fa-arrow-left">&nbsp;<fmt:message code="common.annuler" /></i></a>
                                    </div>
		             </div>
                    </f:form>	
                 </div>
                <!-- /.col-lg-12 -->
            </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="<%=request.getContextPath() %>/resources/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath() %>/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="<%=request.getContextPath() %>/resources/vendor/metisMenu/metisMenu.min.js"></script>

    
    <!-- DataTables JavaScript -->
    <script src="<%=request.getContextPath() %>/resources/vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/vendor/datatables-responsive/dataTables.responsive.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="<%=request.getContextPath() %>/resources/dist/js/sb-admin-2.js"></script>
    
    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
    </script>
</body>

</html>