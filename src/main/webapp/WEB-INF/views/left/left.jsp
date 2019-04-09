<div class="navbar-default sidebar" role="navigation">
	<div class="sidebar-nav navbar-collapse">
		<ul class="nav" id="side-menu">
			<li class="sidebar-search">
				<div class="input-group custom-search-form">
					<input type="text" class="form-control" placeholder="Recherche...">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button">
							<i class="fa fa-search"></i>
						</button>
					</span>
				</div> <!-- /input-group -->
			</li>
			
			<c:url value="/home/" var="salle" />
			<li><a href="${salle }"><i class="fa fa-barcode fa-fw"></i>
					<fmt:message code="common.salle" /> </a></li>
					
					
					
			<li><a href="#"><i class="fa fa-list fa-fw"></i>
					<fmt:message code="common.publication" /><span class="fa arrow"></span></a>
				<ul class="nav nav-second-level" area-expended="false">
					<c:url value="/salle/nouveau" var="salle" />
					<li><a href="${salle }"><fmt:message code="common.publier" /></a></li>
					<c:url value="/listeReservation/" var="cdeClient" />
					<li><a href="${cdeClient }"><fmt:message code="common.client.commande" /></a></li>
				</ul> <!-- /.nav-second-level -->
			</li>
					
		</ul>
	</div>
	<!-- /.sidebar-collapse -->
</div>