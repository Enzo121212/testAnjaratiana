
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ include file="header.jsp" %>
   <div class="content-wrapper">
            <section class="content-header">
              <h1>
                Livraison
              </h1>
            </section>
    
            <section class="content">
              <div class="row mt-2">
                <div class="col-md-4">
                  <div class="box box-warning">
                    <div class="box-header">
                      <h3 class="box-title">Ajout Livraison</h3>
                    </div>
                    <div class="box-body">
                      <form action="Livraison" method="post">
                        
                        <div class="form-group">
                          <label for="client">Select</label>
                          <select class="form-control" id="client" name="idClient">
                             <c:forEach var="index" items="${clients}" >
                             	<option value="${index.id}">${index.nom}  ${index.prenom}</option>
						    </c:forEach>
                          </select>
                        </div>

                        <div class="form-group">
                          <label for="article"> Selectionnez un ou plusieurs articles</label>
                          <select multiple class="form-control" id="article" name="idCommande" required>
                            <c:forEach var="index" items="${articles}" >
                             	<option value="${index.id}">${index.article}</option>
						    </c:forEach>
						    
                          </select>
                        </div>

                        
                        <div class="form-group">
                          <label for="date">Date de livraison </label>
                          <input type="date" class="form-control" id="date" placeholder="Date de livraison"  name="dateLivraison" required />
                        </div>

                        <div class="form-group">
                          <label for="Heure">Heure de livraison </label>
                          <input type="time" class="form-control" id="Heure" placeholder="Date de livraison" name="heureLivraison"  required/>
                        </div>

                        <div class="form-group">
                          <label for="livreur">Livreur</label>
                          <select  class="form-control" id="livreur" name="idLivreur" required >
                      		<c:forEach var="index" items="${livreurs}" >
                             	<option value="${index.id}">${index.nom}  ${index.prenom}</option>
						    </c:forEach>
                          </select>
                        </div>

                        
                        <div class="form-group">
                          <label for="Transport">Transport</label>
                          <select  class="form-control" id="Transport" name="idTransport" required>
                            <option value="1" >Voiture</option>
                            <option value="2">Moto</option>
                            <option value="3">Velo</option>
                            <option value="4">Bus</option>
                          </select>
                        </div>

                        <div class="form-group">
                          <label for="Prix">Prix de livraison </label>
                          <input type="number" class="form-control"  name="prix" id="Prix" placeholder="Prix" required/>
                        </div>

                        <div class="box-footer">
                          <button type="submit" class="btn btn-primary">Ajouter</button>
                        </div>
                      </form>
                    </div>
                  </div>
                </div>

                <div class="col-md-8">
                  <div class="box">
                    <div class="box-header">
                      <h3 class="box-title">Liste des livreurs</h3>
                    </div>
                    <div class="box-body no-padding">
                      <table class="table table-striped">
                        <tr>
                          <th style="width: 10px">#</th>
                          <th>Date Livraison</th>
                          <th>Clients</th>
                          <th>Heures</th>
                          <th>Livreur</th>
                          <th>Transport</th>
                          <th>Prix </th>
                        </tr>
						<c:forEach var="livraison" items="${livraisons}" varStatus="loop">
				            <tr>
				                <td>${loop.index + 1}</td>
				                 <td> <fmt:formatDate value="${livraison.dateLivraison}" pattern="dd/MM/yyyy" /> </td>
				                <td>${livraison.client.nom} ${livraison.client.prenom}</td>
				                <td>${livraison.heureLivraison}</td>
				                <td>${livraison.livreur.nom} ${livraison.livreur.prenom}</td>
				                <td>${livraison.transport.transport}</td>
				                <td>${livraison.prix}</td>
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