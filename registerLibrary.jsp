<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>|| Register Library ||</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">

    <script src="https://www.google.com/recaptcha/api.js"></script>

</head>
<body>
    <div class="container-fluid">

        <div class="row">
            <%@ include file="header.jsp" %>
        </div>

        <div class="row justify-content-center d-flex">
            
            <div class="col-1"></div>
            
            <h2 class="my-2 py-2 text-dark text-center rounded-2" style="width:70%; background-color:rgb(175, 164, 164);">Register Yourself</h2>

            <div class="col-10 bg-gradient border border-dark rounded-2" style="height:1500px; width:45%; margin-left:300px; background-color:rgb(175, 164, 164);">

                <form action="registerLibrary.do" class="needs-validation" method="post" style="margin-top:50px; margin-left:40px;" novalidate>

                    <label for="name" class="form-label"><h4>Name :</h4></label>
                    <input type="text" class="form-control mb-3" id="name" name="name" required="required" style="padding-right:500px;">
                    <div class="invalid-feedback">
                        Please enter your name !
                    </div>

                    <label for="email" class="form-label"><h4>Email :</h4></label>
                    <input type="email" class="form-control mb-3" id="email" name="email" pattern="^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$" required="required" style="padding-right:500px;">
                    <div class="invalid-feedback" id="email_error_feedback">Please enter your valid email !</div>

                   <!--  <input type="button" value="Send Verification Link" class="btn btn-sm btn-warning" id="send_verification_link"><br><br> -->
              

                    <label for="password" class="form-label"><h4>Password :</h4></label>
                    <input type="password" class="form-control mb-3" id="password" name="password" required="required" style="padding-right:500px;">
                    <div class="invalid-feedback">
                        Please enter your password !
                    </div>

                    
                    <label for="city" class="form-label"><h4>City :</h4></label>
                    <select class="form-select mb-4" id="city" name="city" required>
                        <option selected>Select</option>
                        <c:forEach var="city" items="${cities}">
                            <option value="${city.cityId}">${city.name}</option>
                        </c:forEach>
                    </select>
                    <div class="invalid-feedback">
                        Please select any particular city !
                    </div>

                    
                    <label for="userType" class="form-label"><h4>UserType :</h4></label>
                    <select class="form-select mb-4" id="userType" name="userType" required>
                        <option selected>Select</option>
                        <c:forEach var="userType" items="${userTypes}">
                            <option value="${userType.userTypeId}">${userType.name}</option>
                        </c:forEach>
                    </select>
                    <div class="invalid-feedback">
                        Please select the userType !
                    </div>


                    <!-- <label for="website" class="form-label"><h4>Website(if any) :</h4><label>
                    <input type="text" class="form-control mb-3" id="website" name="website" style="padding-right:500px;"> -->

                    <label for="phone" class="form-label"><h4>Phone Number :</h4></label>
                    <input type="number" class="form-control mb-3" id="phone" name="phone" required="required" style="padding-right:500px;">
                    <div class="invalid-feedback">
                        Please enter your valid phone number !
                    </div>

                    <input type="button" value="Send OTP" class="btn btn-sm btn-warning" id="send_otp"><br><br>

                    <div id="check_otp_box" class="d-none">
                        <label for="otp" class="form-label"><h4>Enter OTP that sent in your phone number  :</h4></label>
                        <input type="number" class="form-control mb-3" id="otp" name="otp" required="required" style="padding-right:500px;">
                        <div class="invalid-feedback"> Please enter correct OTP !</div>
                        <button type="button" class="btn btn-primary" id="check_otp">Check OTP</button><br><br> 
                    </div>

                    <div id="recaptcha" class="d-none">
                        <div class="g-recaptcha" data-sitekey="6LfyQDopAAAAABU9m4LYmJRyu5LT6Avh3geb5Uvu"></div>
                    </div>
                    <input type="submit" value="Save" class="btn btn-light px-5 mt-5">

                </form>
            </div>
            <div class="col-1"></div>
        </div>
        <%@ include file="footer.jsp" %>
    </div>
    
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
 
 <script>

    let send_otp = document.querySelector("#send_otp");
    let phone = document.querySelector('#phone');
    let check_otp_box = document.querySelector('#check_otp_box');
    let otp = document.querySelector('#otp');
    let send_verification_link = document.querySelector('#send_verification_link');
    let email = document.querySelector('#email');
   
//________________________________________________EMAIL________________________________________
    let email_error_feedback = document.querySelector('#email_error_feedback');
    let emailDuplicacy = false;
    let emailPattern = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/;

    let checkEmailDuplicacy = async (email) => {
        let response = await fetch('check_email_duplicacy.do?email='+email);
        let result = await response.text(); 
        return result;
    };

    email.addEventListener('focus',() => {
        let emailDuplicacy = false;
        email.classList.remove('is-invalid');
        email.classList.remove('is-valid');
        email_error_feedback.innerHTML = 'Enter valid email';

    });

    email.addEventListener('blur', (event) => {
        if(emailPattern.test(event.target.value)){
            checkEmailDuplicacy(event.target.value).then((data) => {
                if (data=='true'){
                    emailDuplicacy= true;
                    email.classList.add('is-invalid');
                    email_error_feedback.innerHTML='Email already exists.';
                }else{
                    email.classList.add('is-valid');
                }
            }).catch((error) =>{
                console.log(error);
            });
        }else{
            email.classList.add('is-invalid');
        }

    });
//_____________________________________________________________________________________________________    
//______________________________________________SendOTP________________________________________________
    
    // function disabledbtn(){
    //     document.getElementById("send_otp").disabled = true;
    // }
  
    let generateOTP = async () => {
            let response = await fetch('generate_otp.do?phone='+phone.value);
            let result = await response.text();
            return result;
        };

        send_otp.addEventListener('click', () => {
            generateOTP().then(data => {
                if(data == 'true') {
                    check_otp_box.classList.replace('d-none','d-block');
                    send_otp.classList.add('d-none');
                    phone.readOnly=true;
                }
            }).catch((err)=>{
                console.log(err);
            });
        });
//__________________________________________________Verification Link____________________________________
            /**send_verification_link.addEventListener('keyup' ,() => {
            if(email.value.length > 0){
                send_verification_link.disabled = false;
            }else{
                send_verification_link.disabled = true;
                email.readOnly = true;
            }
        });**/
//_________________________________________________CheckOTP___________________________________________________

        let checkOTP = async() =>{
            let response = await fetch('check_otp.do?otp='+otp.value);
            let result = await response.text();
            return result;
        };

        check_otp.addEventListener('click',() =>{
            checkOTP().then((data) =>{
                if(data =='true'){
                    recaptcha.classList.replace('d-none','d-block');
                }else{
                    otp.classList.add('is-invalid');
                }
            }).catch((err) =>{
                console.log(err);
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