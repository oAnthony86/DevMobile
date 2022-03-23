<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <script src="/service-worker.js"></script>
		<link rel="manifest" href="/manifest.json" crossorigin="use-credentials">

    <title>NASA</title>

    <!-- Custom styles for this template -->
    <link href="album.css" rel="stylesheet">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</head>
  <body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">NASA</a>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div
          class="collapse navbar-collapse"
          id="navbarSupportedContent"
        >
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <a class="nav-link" href="missoes.php">MISSÕES</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="naves.php">NAVES</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="index.php">HOME</a>
            </li>
            
          </ul>
        </div>
      </div>
    </nav>
      
    <main role="main">

        <div class="album py-5 bg-light">
          <div class="container">
  
            <div class="row">
              <div class="col-md-4">
                <div class="card mb-4 shadow-sm">
                  <img class="card-img-top" src="https://uploads.jovemnerd.com.br/wp-content/uploads/2022/03/nasa-artemis-missao-lua.jpg" alt="Card image cap">
                  <div class="card-body">
                    <p class="card-text">2020. Inicio nossa nova base no Peru para pegar boas visões de satelite.</p>
                    <div class="d-flex justify-content-between align-items-center">
                      <div class="btn-group">
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-md-4">
                <div class="card mb-4 shadow-sm">
                  <img class="card-img-top" src="https://uploads.jovemnerd.com.br/wp-content/uploads/2022/03/nasa-artemis-missao-lua.jpg" alt="Card image cap">
                  <div class="card-body">
                    <p class="card-text">1980. Vencer a URSS na tecnologia.</p>
                    <div class="d-flex justify-content-between align-items-center">
                      <div class="btn-group">
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-md-4">
                <div class="card mb-4 shadow-sm">
                  <img class="card-img-top" src="https://uploads.jovemnerd.com.br/wp-content/uploads/2022/03/nasa-artemis-missao-lua.jpg" alt="Card image cap">
                  <div class="card-body">
                    <p class="card-text">1940. Desenvolver tecnologia.</p>
                    <div class="d-flex justify-content-between align-items-center">
                      <div class="btn-group">
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
  
      </main>
    
  
  
  <script>
    if ('serviceWorker' in navigator) {
			navigator.serviceWorker.register('/service-worker.js')
			.then(function(registration) {
				console.log('Registration successful, scope is:', registration.scope);
			})
			.catch(function(error) {
				console.log('Service worker registration failed, error:', error);
			});
		}
  </script>
  </body>
</html>