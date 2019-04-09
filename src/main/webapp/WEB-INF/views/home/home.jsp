<%@ include file="/WEB-INF/views/includes/includes.jsp" %>
<!DOCTYPE html>
<html lang="fr">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Gestion Salle</title>

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
			
            <%@ include file="/WEB-INF/views/left/left.jsp" %>
           
            <!-- /.navbar-static-side -->
        </nav> 

        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h2 class="page-header">Réservation de salle</h2>
                        
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
                 <div class="row">
                 <div class="col-lg-12">
                 	<h4 class="page-header">Rechercher salle</h4>
                 	<c:url value="/home/rechercher" var ="urlRecherche" />
                 	<f:form role = "form" modelAttribute="aRechercher" action="${urlRecherche }" enctype="multipart/form-data">
                    <div class="col-sm-4">
	                    <div class="panel-body">
		                    
		                    
		       					<div class="form-group">
		                             
		                            
		                              <label><fmt:message code="common.ville" /></label>
                                            <select class="form-control" name="nomVille" required="required">
                                                <option>Hanoi</option>
                                                <option>Ho Chi Minh</option>
                                                <option>Da Nang</option>
                                                <option>Hue</option>
                                                <option>Nha Trang</option>
                                                <option>Can Tho</option>
                                                <option>Tester</option>
                                    </select>
		                        </div>
											
								<div class="form-group">
		                             <label><fmt:message code="common.prix" /></label>
		                             <input class="form-control" placeholder="Prix" name="prix" required="required"/>
		                        </div>
		                     	
	                      </div>
                    </div>
                    
                    <div class="col-sm-4">
	                    <div class="panel-body">
		                    
		                    
		       					<div class="form-group">
		                             <label><fmt:message code="common.parametrage.categorie" /></label>
		                             <select class="form-control" name="categorie" required="required">
                                                <option>Mariage</option>
                                                <option>Anniversaire</option>
                                                <option>Conférence</option>
                                                <option>Concert</option>
                                                <option>Terrain</option>
                                                <option>Test</option>
                                                
                                    </select>
		                        </div>
											
								
		                        
		                     	
	                      </div>
                    </div>
                    <div class="col-sm-4">
                    <div class="panel-body">
                    <div class="form-group">
			                      <label><fmt:message code="common.place" /></label>
			                      <input class="form-control" placeholder="Nombre de Place" name="nombre" required="required"/>
			                </div>
		             </div>
                    </div>
                    <div class="col-sm-4">
                    <div class="panel-body">
                    	<div class="row">
		                      <button type="submit" class="btn btn-default" >Rechercher</button>
		                  </div>
		                </div>
		             </div>
                    </f:form>	
                 </div>
                    <!-- /.col-lg-12 -->
                </div>
                <div class="row">
					<div class="col-lg-12">
						<ol class="breadcrumb">
						  
						  
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
                                        <th><fmt:message code="common.actions" /></th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:forEach items="${salles }" var = "salle">
	                                    <tr class="odd gradeX">
	                                 		<td class="center"><img src="${salle.getPhoto() }" width="200px" height="100px"/></td>
	                                        <td>${salle.getNom() }</td>
	                                        <td >${salle.getPrix() }</td>
	                                        <td >${salle.getCodeSalle() }</td>
	                                        <td >${salle.getNbrePlace() }</td>
	                                        <td >${salle.getVilleSal().getNomVille() }</td>
	                                        <td>${salle.getCatgori().getLibelle()}</td>
	                                        <td>
	                                        	&nbsp;| Réserver&nbsp;
	                                        	<c:url value="/commandeclient/reserver/${salle.getIdSalle() }" var="urlReserver" />
	                                        	<a href="${urlReserver }"><i class="fa fa-shopping-cart fa-fw"></i></a>
	                                        	&nbsp;|&nbsp;
<%-- 	                                        	<a href="javascript:void(0);" data-toggle="modal" data-target="#modalarticle${salle.getIdSalle() }"><i class="fa fa-trash-o"></i></a>
 --%>	                                        	<%-- <div class="modal fade" id="modalarticle${salle.getIdSalle() }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
													<div class="modal-dialog">
														<div class="modal-content">
															<div class="modal-header">
																<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
																<h4 class="modal-title" id="myModalLabel"><fmt:message code="common.confirm.suppression" /></h4>
															</div>
															<div class="modal-body">
																<fmt:message code="salle.confirm.suppression.msg" />
															</div>
															<div class="modal-footer">
																<button type="button" class="btn btn-default" data-dismiss="modal"><fmt:message code="common.annuler" /></button>
																<c:url value="/salle/supprimer/${salle.getIdSalle() }" var="urlSuppression" />
																<a href="${urlSuppression }" class="btn btn-danger"><i class="fa fa-trash-o"></i>&nbsp;<fmt:message code="common.confirmer" /></a>
															</div>
														</div>
														<!-- /.modal-content -->
													</div>
													<!-- /.modal-dialog -->
												</div> --%>
	                                        </td>
	                                    </tr>
                                	</c:forEach>
                                </tbody>
                            </table>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
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