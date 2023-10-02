
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
                      <h3 class="box-title"> ${article.id == null ? 'Ajouter' : 'Modifier'} Article</h3>
                    </div>
                    <div class="box-body">
                      <form action="articles" method="post">
                          <input type="hidden" name="action" value="${article.id == null ? 'create' : 'update'}">
        				<input type="hidden" name="id" value="${article.id}">
                        <div class="form-group">
                          <label for="Article">Article </label>
                          <input type="text" class="form-control" id="Article" placeholder="Article"  name="articleName" value="${article.article}" required/>
                        </div>
                        <div class="box-footer">
                          <button type="submit" class="btn btn-primary" value="${article.id == null ? 'Ajouter' : 'Modifier'}">${article.id == null ? 'Ajouter' : 'Modifier'}</button>
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
                          <th style="width: 20px">#</th>
                          <th class="text-center">Articles</th>
                          <th ></th>
                        </tr>
		                <c:forEach var="article" items="${articles}" varStatus="loop">
						    <tr>
						       <td>${loop.index + 1}</td>
						        <td class="text-center">${article.article}</td>
						        <td class="text-right">
						            <a href="articles?action=edit&id=${article.id}" class="btn btn-primary btn-sm"><i class="fa fa-pencil"></i> </a>
						            <a href="articles?action=delete&id=${article.id}"class="btn btn-danger btn-sm"><i class="fa fa-trash"></i> </a>
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