    <%@ include file="/WEB-INF/views/includes/includes.jsp" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
      <meta charset="UTF-8">
      <title>Accueil</title>
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css">
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

    </head>
    <body>

      <div class="ui pointing menu">
        <a class="active item">
          Accueil
        </a>
          <a class="item">
          A propos
          </a>
           <div class="ui simple dropdown item">
                Services
            <i class="dropdown icon"></i>
            <div class="menu">
              <a class="item"><i class="cart plus icon"></i> Réserver Salle</a>
              <a class="item"><i class="edit icon"></i> Publier Salle</a>
              
            </div>
          </div>
          <div class="right menu">
            <div class="item">
              <div class="ui transparent icon input">
                
              </div>
            </div>
          </div>
          <div class="ui large buttons">
            
          <a href="/web/">
          
             <button class="ui green button" id="connexion" > Login </button> </a>
              <div class="or"></div>
            <button class="ui blue button">Sign up</button>

            

        </div>

        

      </div>
      <tbody>
        <c:forEach items="${salles }" var = "salle">
                                      <tr class="odd gradeX">
                                      <td class="center"><img src="${salle.getPhoto() }" width="200px" height="100px"/></td>
                                          <td>${salle.getNom() }</td>
                                          <td >${salle.getPrix() }</td>
                                          <td >${salle.getCodeSalle() }</td>
                                          <td >${salle.getVilleSal().getNomVille() }</td>
                                          <td>${salle.getCatgori().getLibelle()}</td>
                                         </tr>
                                  </c:forEach>
      
            </tbody>

      <script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.js"></script>
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