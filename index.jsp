<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> || Home || </title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
<body>

<div class="container-fluid">

    <div class="row">
        <%@ include file="header.jsp" %>
    </div>

    <div class="container-fluid">
        <!-- <div class="row mt-4" style="background-image:url(static/images/girl.jpg);"> -->
            <div class="row mt-4" style="background-color: rgb(255, 255, 255);">

                <div class="row row-cols-1 row-cols-md-3 g-4">

                    <div class="col">
                      <div class="card h-100 border-dark p-2" style="width: 15rem; margin-left: 50%;">
                        <img src="static/images/Library.png" class="card-img-top" alt="Library">
                        <div class="card-body">
                          <a href="loginLibrary.do" class="btn btn-primary px-5">Library</a>
                        </div>
                      </div>
                    </div>

                    <div class="col">
                      <div class="card h-100 border-dark p-2" style="width: 15rem; margin-left: 30%;">
                        <img src="static/images/Librarian.png" class="card-img-top" alt="Librarian">
                        <div class="card-body">
                          <a href="loginLibrarian.do" class="btn btn-primary px-5">Librarian</a>
                        </div>
                      </div>
                    </div>

                    <div class="col">
                      <div class="card h-100 border-dark p-2" style="width: 15rem; margin-left: 10%;">
                        <img src="static/images/Candidate.png" class="card-img-top" alt="Candidate">
                        <div class="card-body">
                            <a href="candidate.jsp" class="btn btn-primary px-5">Candidate</a>
                        </div>
                      </div>
                    </div>

                  </div>
                
                
             </div>
    </div>

        <%@ include file="footer.jsp" %>
</div> 
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>