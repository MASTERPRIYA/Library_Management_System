<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>|| Register Candidate ||</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">

    <script src="https://unpkg.com/dropzone@5/dist/min/dropzone.min.js"></script>
    <link rel="stylesheet" href="https://unpkg.com/dropzone@5/dist/min/dropzone.min.css" type="text/css" />
    
    <script src="https://www.google.com/recaptcha/api.js"></script>

</head>
<body>
 <!-- ############################### -- Pic Upload Modal -- start ###################################-->
        <!-- <div class="modal fade" id="pic_upload_modal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h3>Upload Your Pic</h3>
                    </div>
                    <div class="modal-body">
                        <form action="upload_pic.do" class="dropzone" id="pic-upload-form"></form>
                    </div>
                    <div class="modal-footer"></div>
                </div>
            </div>
        </div> -->
<!-- ############################### -- Pic Upload Modal -- end ###################################-->
    
<!--****************************************<MEMBER>-START****************************************************-->

    <div class="modal fade modal-lg" tabindex="-1"  id="member">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h3 class="modal-title">Fill these blanks:</h3>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>
                <div class="modal-body">
                    <form action="#" method="post">

                        <label for="email" class="form-label mr-5 mt-4"><h4>Email :</h4></label>
                        <input type="email" class="form-control" id="email" name="email" required="required" style="padding-right: 400px;">
    
                        <label for="date_of_joining" class="form-label mt-4 mr-5"><h4>Date of joining :</h4></label>
                        <input type="number" class="form-control" id="date_of_joining" name="date_of_joining" required="required" style="padding-right: 400px;">

                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary  px-5 mr-5 mt-5" data-bs-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-dark px-5 mr-5 mt-5">
                        <a style="text-decoration: none; color: white;" href="#"  data-bs-toggle="modal" data-bs-target="#save_member">Save</a>
                    </button>
                </div>
            </div>
        </div>
    </div>
<!--*********************************************<MEMBER>-END***************************************************-->

<!--*********************************************<QR-CODE>-START************************************************-->
    <div class="modal fade modal-lg" tabindex="-1"  id="save_member">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h3 class="modal-title">Scan QR and pay 500 to become the member of library</h3>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>
                <div class="modal-body">
                    <form action="#" method="post">
                        <img src="static/images/QR-CODE.jpeg" style="width:190px;height:190px" alt="QR-code">
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary  px-5 mr-5 mt-5" data-bs-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-dark px-5 mr-5 mt-5">
                        <a style="text-decoration: none; color: white;">Proceed Payment </a>
                    </button>
                </div>
            </div>
        </div>
    </div>  
<!--*********************************************<QR-CODE>-END********************************************-->        

    <div class="container-fluid">

        <div class="row">
            <%@ include file="header.jsp" %>
        </div>

        <div class="row justify-content-center d-flex">
            
            <div class="col-1"></div>
            
            <h2 class="my-2 py-2 text-center rounded-2" style="width:70%; background-color:rgb(0, 150, 255); color: rgb(255, 255, 255);">Provide appropriate details</h2>

            <div class="col-10 bg-gradient border border-dark rounded-2" style="height:1800px; width:50%; margin-left:350px; background-color:rgb(0, 150, 255); color: white">
            <!-- <div  class="mb-5">
                    <img src="show_pic.do" id="my_pic" data-bs-toggle="modal" data-bs-target="#pic_upload_modal" class="rounded-circle" style="object-fit:cover" width="270">
                </div> -->

                <form action="registerCandidate.do" class="needs-validation" method="post" style="margin-top:50px; margin-left:40px;" novalidate>

                    <label for="name" class="form-label"><h4>Name :</h4></label>
                    <input type="text" class="form-control mb-3" id="name" name="name" required="required" style="padding-right:500px;">
                    <div class="invalid-feedback">
                        Please enter your name !
                    </div>

                
                    <label for="email" class="form-label"><h4>Email :</h4></label>
                    <input type="email" class="form-control mb-3" id="email" name="email" required="required" style="padding-right:500px;">
                    <div class="invalid-feedback">
                        Please enter your valid email !
                    </div>


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

                    <label for="gender" class="form-label"><h4>Gender :</h4></label>
                    <select  class="form-select mb-4" id="gender" name="gender" required>
                        <option selected>Select</option>
                            <option>F</option>
                            <option>M</option>
                    </select>
                    <div class="invalid-feedback">
                        Please select the gender !
                    </div>

                    <label for="organization" class="form-label"><h4>Organization :</h4></label>
                   <select  class="form-select mb-4" id="organization" name="organization" required>
                    <option selected>Select</option>
                    <option>School</option>
                    <option>College</option>
                    <option>Employee</option>
                    <option>Others</option>
                   </select>
                   

                    <label for="adhaarcard" class="form-label"><h4>Adhaarcard no. :</h4></label>
                    <input type="number" class="form-control mb-3" id="adhaarcard" name="adhaarcard" required="required" style="padding-right:500px;">
                    <div class="invalid-feedback">
                        Please enter your adhaarcard number !
                    </div>

                    <label for="dob" class="form-label"><h4>Date of birth :</h4></label>
                    <input type="date" class="form-control mb-4" id="dob" name="dob" require="required" style="padding-right:500px;">
                    <div class="invalid-feedback">Please enter your date of birth !</div>

                    <label for="address" class="form-label"><h4>Address :</h4><label>
                    <input type="text" class="form-control mb-3" id="address" name="address" style="padding-right:500px;">

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
                    <a href="#" class="btn btn-success p-3 mt-5" style="text-decoration:none;color:rgb(255, 255, 255);border-radius:15px;margin-left:50%" data-bs-toggle="modal" data-bs-target="#member">Membership</a>
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