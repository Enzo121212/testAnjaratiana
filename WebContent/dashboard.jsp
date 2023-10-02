       
 <%@ include file="header.jsp" %>
   <div class="content-wrapper">
            <section class="content-header">
              <h1>
                Tableau de bord
              </h1>
            </section>
    
            <section class="content">
              <div class="row">
                <div class="col-lg-3 col-xs-6">
                  <div class="small-box bg-aqua">
                    <div class="inner">
                      <h3>150</h3>
                      <p>Livraison du jour</p>
                    </div>
                    <div class="icon">
                      <i class="fa fa-truck"></i>
                    </div>
                    <a href="#" class="small-box-footer">Voir Plus <i class="fa fa-arrow-circle-right"></i></a>
                  </div>
                </div>
                <div class="col-lg-3 col-xs-6">
                  <div class="small-box bg-green">
                    <div class="inner">
                      <h3>53
                        </h3>
                      <p>Livraison effectué</p>
                    </div>
                    <div class="icon">
                      <i class="fa fa-shopping-cart"></i>
                      
                    </div>
                    <a href="#" class="small-box-footer">Voir plus <i class="fa fa-arrow-circle-right"></i></a>
                  </div>
                </div>
                <div class="col-lg-3 col-xs-6">
                  <div class="small-box bg-yellow">
                    <div class="inner">
                      <h3>44</h3>
                      <p>Livreur Disponible</p>
                    </div>
                    <div class="icon">
                      <i class="	fa fa-user"></i>
                    </div>
                    <a href="#" class="small-box-footer">Voir plus <i class="fa fa-arrow-circle-right"></i></a>
                  </div>
                </div>
                <div class="col-lg-3 col-xs-6">
                  <div class="small-box bg-red">
                    <div class="inner">
                      <h3>65</h3>
                      <p>Chiffre d'Affaire</p>
                    </div>
                    <div class="icon">
                      <i class="	fa fa-euro"></i>
                    </div>
                    <a href="#" class="small-box-footer">Voir plus <i class="fa fa-arrow-circle-right"></i></a>
                  </div>
                </div>
              </div>

              <div class="row">
                <div class="col-md-12">
                  <div class="box">
                    <div class="box-header with-border">
                      <h3 class="box-title">CHIFRRE D'AFFAIRE</h3>
                    </div>
                    <div class="box-body">
                      <div class="chart-responsive">
                        <canvas id="turnoverChart" height="180"></canvas>
                      </div>
                    </div>
                  </div>
                </div>
              </div>

              <div class="row">
                <div class="col-md-12">
                  <div class="box">
                    <div class="box-header with-border">
                      <h3 class="box-title">LIVRAISON</h3>
                    </div>
                    <div class="box-body">
                      <div class="chart-responsive">
                        <canvas id="deliveryChart" height="180"></canvas>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
          
            </section><!-- /.content -->

<%@ include file="footerDashboard.jsp" %>