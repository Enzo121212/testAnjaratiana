
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
                      <form role="form">
                        
                        <div class="form-group">
                          <label for="client">Select</label>
                          <select class="form-control" id="client">
                            <option>client 1</option>
                            <option>client 2</option>
                          </select>
                        </div>

                        <div class="form-group">
                          <label for="article"> Sélectionnez un ou plusieurs articles</label>
                          <select multiple class="form-control" id="article">
                            <option>article 1</option>
                            <option>article 2</option>
                            <option>article 3</option>
                            <option>article 4</option>
                            <option>article 5</option>
                          </select>
                        </div>

                        
                        <div class="form-group">
                          <label for="date">Date de livraison </label>
                          <input type="date" class="form-control" id="date" placeholder="Date de livraison"/>
                        </div>

                        <div class="form-group">
                          <label for="Heure">Heure de livraison </label>
                          <input type="time" class="form-control" id="Heure" placeholder="Date de livraison"/>
                        </div>

                        <div class="form-group">
                          <label for="livreur">Livreur</label>
                          <select  class="form-control" id="livreur">
                            <option>livreur 1</option>
                            <option>livreur 2</option>
                            <option>livreur 3</option>
                            <option>livreur 4</option>
                            <option>livreur 5</option>
                          </select>
                        </div>

                        
                        <div class="form-group">
                          <label for="Transport">Transport</label>
                          <select  class="form-control" id="Transport">
                            <option value="1" >Voiture</option>
                            <option value="2">Moto</option>
                            <option value="3">Velo</option>
                            <option value="4">Bus</option>
                          </select>
                        </div>

                        <div class="form-group">
                          <label for="Prix">Prix de livraison </label>
                          <input type="text" class="form-control" id="Prix" placeholder="Prix"/>
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
                          <th>Prix </th>
                          <th>Transport</th>
                        </tr>
                        <tr>
                          <td>1.</td>
                          <td>Rakoto nandrasana</td>
                          <td>
                              03298945465
                          </td>
                          <td>Antananarivo</td>
                          <td>Edit delete</td>
                          <td>Efea</td>
                        </tr>
         
                      </table>
                    </div>
                  </div>
                </div>
              </div>
            </section>

          </div>
          
 <%@ include file="footer.jsp" %>