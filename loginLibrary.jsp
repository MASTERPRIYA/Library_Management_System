
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> || LoginLibrary || </title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container-fluid-sm">

        <div class="row">
            <%@ include file="header.jsp" %>
         </div>

         <div class="row">
            <div class="col-1"></div>
            

            <div class="col-10 mt-5 bg-gradient border border-dark" style="height:500px; width:45%; background-color:rgb(0, 150, 255); margin-left:20%;">

                <form action="loginLibrary.do" method="post" class="needs-validation" style="margin-top:80px; margin-left:50px;" novalidate>

                    <label for="email" class="form-label mr-4" style="color: white;"><h3>Email :</h3></label>
                    <input type="text" class="form-control mb-3" id="email" name="email" required="required">
                    <div class="invalid-feedback" id="email_error_feedback"> Please enter your email</div>

                    <label for="password" class="form-label mb-3 mr-5" style="color: white;"><h3>Password :</h3></label>
                    <input type="password" class="form-control" id="password" name="password" required="required">
                    <div class="invalid-feedback">Please enter your password</div>

                    <input type="submit" value="Login" id="lgnbtn" class="btn btn-light btn-lg px-5 m-5">

                    <button type="button" class="btn btn-light btn-lg px-5 m-5">
                        <a style="text-decoration:none; color:rgb(0, 0, 0);" href="registerLibrary.do">Register</a>
                    </button>
    
                   <button type="button" class="btn btn-light btn-lg px-5 m-5 ">
                        <a style="text-decoration:none; color:rgb(0, 0, 0);" href="index.jsp">Exit</a>
                    </button>
    

                </form>
            </div>

            <div class="col-1"></div>

        </div>

        <%@ include file="footer.jsp" %>
        
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <script>

//_______________________________________CHECK ACCOUNT_______________________________________________
        let email = document.querySelector('#email');
        let emailExist = true;

        let checkEmailExist = async (email) =>{
            let response = await fetch('check_email_exist.do?email='+email);
            let result = await response.text();
            return result;
        };


        email.addEventListener('blur',(event) => {
            checkEmailExist(event.target.value).then((data) => {
                if(data=='true'){
                    emailExist=false;
                    email.classList.add('is-valid');
                }else{
                    email.classList.add('is-invalid');
                    email.value="Enter email does not exist please create your account"
                }
            }).catch((error) =>{
                console.log(error);
            });
        });

// _____________________________________Validation___________________________________________________ 
    (() => {
        'use strict'

        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        const forms = document.querySelectorAll('.needs-validation')

        // Loop over them and prevent submission
        Array.from(forms).forEach(form => {
            form.addEventListener('submit', event => {
            if (!form.checkValidity()) {
                event.preventDefault()
                event.stopPropagation()
            }

            form.classList.add('was-validated')
            }, false)
        })
        })()
    </script>
    
</body>
</html>