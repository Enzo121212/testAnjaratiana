
 <%@ include file="header.jsp" %>
    <div class="content-wrapper">
            <section class="content-header">
              <h1>
                Clients
              </h1>
            </section>
    
            <section class="content">
              <div class="row mt-2">
                <div class="col-md-6">
                  <div class="box box-warning">
                    <div class="box-header">
                      <h3 class="box-title">Ajout Client</h3>
                    </div>
                    <div class="box-body">
               			<form action="Client" method="post">
						    <input type="hidden" name="action" value="${client.id == null  ? 'create' : 'update'}">
						    <input type="hidden" name="id" value="${client.id}">
						    <div class="form-group">
						        <label for="nom">Nom</label>
						        <input type="text" class="form-control" id="nom" name="nom" placeholder="Nom" value="${client.nom}" required/>
						    </div>
						    <div class="form-group">
						        <label for="prenom">Prenom</label>
						        <input type="text" class="form-control" id="prenom" name="prenom" placeholder="Prenom" value="${client.prenom}" required/>
						    </div>
						    <div class="form-group">
						        <label for="contact">Contact</label>
						        <input type="text" class="form-control" id="contact" name="contacte" placeholder="Contact" value="${client.contacte}" required/>
						    </div>
						    <div class="form-group">
						        <label for="adresse">Adresse</label>
						        <input type="text" class="form-control" id="adresse" name="adresse" placeholder="Adresse" value="${client.adresse}" required/>
						    </div>
						    <div class="box-footer">
						        <button type="submit" class="btn btn-primary" value="${client.id == 0 ? 'Ajouter' : 'Modifier'}">${client.id == 0 ? 'Ajouter' : 'Modifier'}</button>
						    </div>
						</form>
               
                    </div>
                  </div>
                </div>

                <div class="col-md-6">
                  <div class="box">
                    <div class="box-header">
                      <h3 class="box-title">Liste des Clients</h3>
                    </div>
                    <div class="box-body no-padding">
                     	<table class="table table-striped">
						    <tr>
						        <th style="width: 20px">#</th>
						        <th class="text-center">Nom</th>
						        <th class="text-center">Prénom</th>
						        <th class="text-center">Contact</th>
						        <th class="text-center">Adresse</th>
						        <th></th>
						    </tr>
						    <c:forEach var="client" items="${clients}" varStatus="loop">
						        <tr>
						            <td>${loop.index + 1}</td>
						            <td class="text-center">${client.nom}</td>
						            <td class="text-center">${client.prenom}</td>
						            <td class="text-center">${client.contacte}</td>
						            <td class="text-center">${client.adresse}</td>
						            <td class="text-right">
						                <a href="Client?action=edit&id=${client.id}" class="btn btn-primary btn-sm"><i class="fa fa-pencil"></i> </a>
						                <a href="Client?action=delete&id=${client.id}" class="btn btn-danger btn-sm"><i class="fa fa-trash"></i> </a>
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