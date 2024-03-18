<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> || Login Librarian || </title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    
</head>
<body>

<!--**************************************Change Password-START*******************************************-->

    <div class="modal fade modal-lg" tabindex="-1"  id="change_password">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h3 class="modal-title">Create New Password  :</h3>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>
                <form  id="changePasswordForm" action="changePassword.do"  method="post">

                    <div class="modal-body">

                            <label for="email" class="form-label mr-5 mt-4"><h4>Email :</h4></label>
                            <input type="email" class="form-control" id="modal_email"  name="email"  required="required" style="padding-right: 400px;">
        
                            <label for="password" class="form-label mt-4 mr-5"><h4>New Password :</h4></label>
                            <input type="password" class="form-control"  id="modal_password"  name="password"  required="required" style="padding-right: 400px;">
                    
                    </div>
                
                    <div class="modal-footer">
                        <button type="button" class="btn btn-info  px-5 mr-5 mt-5" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-info  px-5 mr-5 mt-5" id="save_change_password_btn" data-bs-dismiss="modal">Save</button>
                    </div>
                </form>       
            </div>
        </div>
    </div>
   
<!--*********************************************Change Password-END******************************************-->

    <div class="container-fluid">

        <div class="row">
            <%@ include file="header.jsp" %>
         </div>

         <div class="row">
            <div class="col-1"></div>
    
            <div class="col-10  border border-dark bg-gradient" style="height:600px; width:45%;  margin-top:80px; margin-left:18%;background-color:rgb(0, 150, 255); ">

                <form action="loginLibrarian.do" method="post" style="margin-top:100px; margin-left:50px;">

                    <label for="email" class="form-label mr-5" style="color: rgb(255, 255, 255);"><h3>Email :</h3></label><br>  
                    <input type="email" class="form-control mb-3 px-5" id="email"  name="email" style="padding-right:700px;" required="required">
                    <div class="invalid-feedback" id="email_error_feedback">Please Enter Your Email</div>

                    
                    <label for="password" class="form-label mb-3 mr-5" style= "color: rgb(255, 255, 255);"><h3>Password :</h3></label>
                    <input type="password" class="form-control" id="password" name="password" style="padding-right: 700px;" required="required">
                    <div class="invalid-feedback">Please Enter Your Password</div>

                    <input type="submit" value="Login" id="loginbtn" class="btn btn-light btn-lg px-5 m-5">

                    <button type="button" id="changePasswordbtn" class="btn btn-light btn-lg px-5 m-5" data-bs-toggle="modal" data-bs-target="#change_password">Change Password</button>
                    
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

    <script>
        let email = document.querySelector('#email');
        let emailExist = true;
        let loginLibrarianMenu = document.querySelector('#loginLibrarianMenu');
        let loginbtn = document.querySelector('#loginbtn');
        let changePasswordbtn = document.querySelector('#changePasswordbtn');
        let modalEmail = document.querySelector('#modal_email');
        let modalPassword = document.querySelector('#modal_password');
    
//________________________________CheckEmail______________________________________________________

        let checkEmailExist = async (email) =>{
            let response = await fetch('check_email_exist.do?email='+email);
            let result = await response.text();
            return result;
        };


        email.addEventListener('blur',(event) => {
            checkEmailExist(event.target.value).then((data) => {
                if(data =='true'){
                    emailExist=false;
                    email.classList.add('is-valid');
                }else{
                    email.classList.add('is-invalid');
                    email.value="Enter email does not exist please contact with Admin";
                    loginbtn.disabled=true;
                    changePasswordbtn.disabled=true;
                }
            }).catch((error) =>{
                console.log(error);
            });
        });
//________________________________SaveChangePassword_____________________________________________________________________________________________
      
// _____________________________________Validation______________________________________________________________________________________________
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