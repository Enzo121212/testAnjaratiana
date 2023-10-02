
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
                      <form role="form">
                        <div class="form-group">
                          <label for="nom">Nom </label>
                          <input type="text" class="form-control" id="nom" placeholder="Nom"/>
                        </div>
                        <div class="form-group">
                          <label for="nom">Prenom </label>
                          <input type="text" class="form-control" id="Prenom" placeholder="Prenom"/>
                        </div>
                        <div class="form-group">
                          <label for="nom">Contact </label>
                          <input type="text" class="form-control" id="Contact" placeholder="Contact"/>
                        </div>
                        <div class="form-group">
                          <label for="nom">Adresse </label>
                          <input type="text" class="form-control" id="Adresse" placeholder="Adresse"/>
                        </div>
                        <div class="box-footer">
                          <button type="submit" class="btn btn-primary">Ajouter</button>
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
                        <tr>
                          <td>1.</td>
                          <td>Rakoto nandrasana</td>
                          <td>
                              03298945465
                          </td>
                          <td>Antananarivo</td>
                          <td>Edit delete</td>
                        </tr>
         
                      </table>
                    </div>
                  </div>
                </div>
              </div>
            </section>

          </div>
          
 <%@ include file="footer.jsp" %>