<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>|| Table Library ||</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/css/Basic.css">
</head>
<body>
    <div class="container-fluid">

        <div class="row">
            <%@ include file="header.jsp" %>
         </div>

         <div class="row">
            <div class="col-1"></div>
            
            <div class="col-10  border border-dark bg-gradient" style="height:600px; width:45%;  margin-top:80px; margin-left:18%;background-color:rgb(0, 150, 255); ">

                <form action="loginPublisher.do" method="post" style="margin-top:100px; margin-left:50px;">

                    <label for="email" class="form-label mr-5" style="color: rgb(255, 255, 255);"><h3>Email :</h3></label><br>  
                    <input type="email" class="form-control mb-3 px-5" id="email"  name="email" style="padding-right:700px;" required="required">
                    <div class="invalid-feedback" id="email_error_feedback">Please Enter Your Email</div>

                    
                    <label for="password" class="form-label mb-3 mr-5" style= "color: rgb(255, 255, 255);"><h3>Password :</h3></label>
                    <input type="password" class="form-control" id="password" name="password" style="padding-right: 700px;" required="required">
                    <div class="invalid-feedback">Please Enter Your Password</div>

                    <input type="submit" value="Login" id="loginbtn" class="btn btn-light btn-lg px-5 m-5">
                    
                    <button type="button" class="btn btn-light btn-lg px-5 mr-5">
                        <a style="text-decoration: none; color: rgb(0, 0, 0);" href="index.jsp">Exit</a>
                    </button>
                </form>

            </div>

            <div class="col-1"></div>
         </div>

         <%@ include file="footer.jsp" %>
        
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>