
 <%@ include file="header.jsp" %>
  
        <div class="content-wrapper">
            <section class="content-header">
              <h1>
                Livreur
              </h1>
            </section>
    
            <section class="content">
              <div class="row mt-2">
                <div class="col-md-6">
                  <div class="box box-warning">
                    <div class="box-header">
                      <h3 class="box-title">Ajout Livreur</h3>
                    </div>
                    <div class="box-body">
	                     	<form action="Livreur" method="post">
							    <input type="hidden" name="action" value="${livreur.id == null  ? 'create' : 'update'}">
							    <input type="hidden" name="id" value="${livreur.id}">
							    <div class="form-group">
							        <label for="nom">Nom</label>
							        <input type="text" class="form-control" id="nom" name="nom" placeholder="Nom" value="${livreur.nom}" required/>
							    </div>
							    <div class="form-group">
							        <label for="prenom">Prenom</label>
							        <input type="text" class="form-control" id="prenom" name="prenom" placeholder="Prenom" value="${livreur.prenom}" required/>
							    </div>
							    <div class="form-group">
							        <label for="contact">Contact</label>
							        <input type="text" class="form-control" id="contact" name="contacte" placeholder="Contact" value="${livreur.contacte}" required/>
							    </div>
							    <div class="form-group">
							        <label for="adresse">Adresse</label>
							        <input type="text" class="form-control" id="adresse" name="adresse" placeholder="Adresse" value="${livreur.adresse}" required/>
							    </div>
							    <div class="box-footer">
							        <button type="submit" class="btn btn-primary" value="${client.id == 0 ? 'Ajouter' : 'Modifier'}">${livreur.id == 0 ? 'Ajouter' : 'Modifier'}</button>
							    </div>
							</form>
                    </div>
                  </div>
                </div>

                <div class="col-md-6">
                  <div class="box">
                    <div class="box-header">
                      <h3 class="box-title">Liste des livreurs</h3>
                    </div>
                    <div class="box-body no-padding">
                      <table class="table table-striped">
                        <tr>
                          <th style="width: 10px">#</th>
                          <th>Nom et Prenom</th>
                          <th>Contact</th>
                          <th> Adresse</th>
                          <th>  Action</th>
                        </tr>
                 			<c:forEach var="index" items="${livreurs}" varStatus="loop">
						        <tr>
						            <td>${loop.index + 1}</td>
						            <td class="text-center">${index.nom}</td>
						            <td class="text-center">${index.prenom}</td>
						            <td class="text-center">${index.contacte}</td>
						            <td class="text-center">${index.adresse}</td>
						            <td class="text-right">
						                <a href="Livreur?action=edit&id=${index.id}" class="btn btn-primary btn-sm"><i class="fa fa-pencil"></i> </a>
						                <a href="Livreur?action=delete&id=${index.id}" class="btn btn-danger btn-sm"><i class="fa fa-trash"></i> </a>
						            </td>
						        </tr>
						    </c:forEach>
         
                      </table>
                    </div>
                  </div>
                </div>
              </div>
            </section>

          </div>
          
 <%@ include file="footer.jsp" %>