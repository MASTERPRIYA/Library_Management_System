<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>|| Candidate Welcome Page ||</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/css/Basic.css">
</head>
<style>
    h3{
        color: black; 
        font-family: "copperplate";
        font-size: 3em;
        margin: 10px 0 0 10px;
        white-space: nowrap;
        overflow: hidden;
        width: 100%;
        animation: animtext 4s steps(80, end); 
        transition: all cubic-bezier(0.1, 0.7, 1.0, 0.1);
   }
   @keyframes animtext { 
        from {
            width: 0;
            transition: all 2s ease-in-out;
        } 
    }
</style>

<body>
    <div class="container-fluid">

        <div class="row">
            <%@ include file="header.jsp" %>
        </div>
        <div class="row mt-3">
            <h3><b>Welcome to Book Mining Library !</b></h3>
        </div>
        <div class="container-fluid">
       

            <div class="row mt-5" style="background-image:url(static/images/background.jpg);">
                <div class="col-4"></div>
    
                <div class="col-4 d-grid gap-2">
                    
                    <button type="button" class="btn btn-success" style="margin-top: 90px;">
                        <a style="text-decoration: none; color: rgb(255, 255, 255);" href="loginCandidate.do">
                            <h2>Login</h2>
                        </a>
                    </button>

                    <button type="button" class="btn  btn-success mb-4" style="margin-top: 100px;">
                        <a style="text-decoration: none; color: rgb(255, 255, 255);margin-top: 100px; " href="bookCandidateView.do">
                            <h2>Show Books</h2>
                        </a>
                    </button>
                    
                    <button type="button" class="btn btn-success mb-5" style="margin-top: 90px;">
                        <a style="text-decoration: none; color: rgb(255, 255, 255);" href="registerCandidate.do">
                            <h2>Create new account</h2>
                        </a>
                    </button>

                
                </div>
                <div class="col-4"></div>
               
            </div>
       

        <%@ include file="footer.jsp" %>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>