
 <%@ include file="header.jsp" %>
    <div class="content-wrapper">
            <section class="content-header">
              <h1>
                Articles
              </h1>
            </section>
    
            <section class="content">
              <div class="row mt-2">
                <div class="col-md-6">
                  <div class="box box-warning">
                    <div class="box-header">
                      <h3 class="box-title">Ajout Article</h3>
                    </div>
                    <div class="box-body">
                      <form role="form">
                        <div class="form-group">
                          <label for="Article">Article </label>
                          <input type="text" class="form-control" id="Article" placeholder="Article"/>
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
                      <h3 class="box-title">Liste des articles</h3>
                    </div>
                    <div class="box-body no-padding">
                      <table class="table table-striped">
                        <tr>
                          <th style="width: 10px">#</th>
                          <th>Articles</th>
                          <th>  Action</th>
                        </tr>
                        <tr>
                          <td>1.</td>
                          <td>Article 1</td>
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