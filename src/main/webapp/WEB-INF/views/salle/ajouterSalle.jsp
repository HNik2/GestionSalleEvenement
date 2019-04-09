<%@ include file="/WEB-INF/views/includes/includes.jsp" %>
<!DOCTYPE html>
<html lang="fr" xmlns:th="http://www.thymeleaf.org">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Gestion de stock mvc</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=request.getContextPath() %>/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="<%=request.getContextPath() %>/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%=request.getContextPath() %>/resources/dist/css/sb-admin-2.css" rel="stylesheet">

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
                        <h1 class="page-header"> <fmt:message code="salle.nouveau" /></h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                
                <div class="row">
	                <div class="col-lg-12">
	                    <div class="panel panel-primary">
	                        <div class="panel-heading">
	                            <fmt:message code="salle.nouveau" />
	                        </div>
	                        <!-- /.panel-heading -->
	                        <div class="panel-body">
	                        	<c:url value="/salle/enregistrer" var ="urlEnregistrer" />
								<f:form modelAttribute="salle" action="${urlEnregistrer }" enctype="multipart/form-data" role = "form">
									<f:hidden path="idSalle"/>
									
<%-- 									<f:hidden path="publie.clientPublie.idClient" items="${clients }" itemValue="idClient"/>
 --%>									<f:hidden path="photo"/>
									
									<div class="form-group">
                                        <label><fmt:message code="common.nom" /></label>
                                        <f:input path="nom" class="form-control" placeholder="Nom" required="required"/>
                                    </div>
                                    <div class="form-group">
                                    <label><fmt:message code="common.code" /></label>
                                        <f:input path="codeSalle" class="form-control" placeholder="Code salle" />
                                    </div>
                                    
									<div class="form-group">
                                        <label><fmt:message code="common.prix" /></label>
                                        <f:input id="prix" path="prix" class="form-control" placeholder="Prix" required="required"/>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label>Nombre de place</label>
                                        <f:input id="nbrePlace" path="nbrePlace" class="form-control" placeholder="Place" required="required"/>
                                    </div>
									
									<div class="form-group">
                                        <label><fmt:message code="common.parametrage.categorie" /></label>
                                        <f:select class="form-control" path="catgori.idCategorie" items="${categories }" itemLabel="libelle" itemValue="idCategorie" />
                                    </div>
                                    
                                    <%-- <div class="form-group">
                                        <label><fmt:message code="common.parametrage.ville" /></label>
                                        <f:select class="form-control" path="villeSal.idVille" items="${villeSal.idVille }" itemLabel="nomVille" itemValue="idVille" />
                                    </div> --%>
                                    
                                    <div class="form-group">
                                    <!--  >c:forEach items="${villes }" var = "ville"-->
                                    <label><fmt:message code="common.parametrage.ville" /></label>
                                     <f:select class="form-control" path="villeSal.idVille" items="${villes }" itemLabel="nomVille" itemValue="idVille" required="required"/>
                                    <!-- >/c:forEach-->
                                     </div>
                                    
				                    <%-- <div class="form-group">
				                     <select class="selectpicker" name="vDep" tabindex="-98">
				                        <option th:each="ville: ${villes}" th:value="${ville.idVille}"  th:text="${ville.nomVille}"></option>
				                        
				                        <option th:each="ville: ${villes}" th:value="${ville.idVille}"  
				                            th:if="${salle.idvoyage &gt; 0} AND ${ville.id} == ${voyage.vDep.id}" selected="selected"  th:text="${ville.libelle}">
				                        </option>                    
				                    </select> 
				               	 	</div> --%>
                                    
                                    
                                    <div class="form-group">
                                        <label><fmt:message code="common.photo" /></label>
                                        <input type="file" name="file">
                                    </div>
                                    <div class="panel-footer">
                                    	<button type="submit" class="btn btn-primary"><i class="fa fa-save">&nbsp;<fmt:message code="common.enregister" /></i></button>
                                    	<a href="<c:url value="/salle/" />" class="btn btn-danger"> <i class="fa fa-arrow-left">&nbsp;<fmt:message code="common.annuler" /></i></a>
                                    </div>
								</f:form>	                        
	                        </div>
	                        <!-- /.panel-body -->
	                    </div>
	                    <!-- /.panel -->
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

    <!-- Custom Theme JavaScript -->
    <script src="<%=request.getContextPath() %>/resources/dist/js/sb-admin-2.js"></script>
    
    <!-- My Custom JavaScript files -->
    <script src="<%=request.getContextPath() %>/resources/javascript/article.js"></script>

</body>

</html>