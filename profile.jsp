<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>|| Profile Candidate ||</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">

    <script src="https://unpkg.com/dropzone@5/dist/min/dropzone.min.js"></script>
    <link rel="stylesheet" href="https://unpkg.com/dropzone@5/dist/min/dropzone.min.css" type="text/css" />
    
    <link rel="stylesheet" href="static/css/Basic.css">
    <link rel="stylesheet" href="static/css/Style.css">
</head>
<body>

<!-- ############################### -- Pic Upload Modal -- start ###################################-->
    <div class="modal fade" id="pic_upload_modal">
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
    </div>
<!-- ############################### -- Pic Upload Modal -- end ###################################-->

    <div class="container-fluid">

        <div class="row">
            <%@ include file="header.jsp" %>
        </div>

        <div class="row justify-content-center d-flex">
            
            <div class="col-1"></div>

                <div  class="mt-3">
                    <img src="show_pic.do" id="my_pic" data-bs-toggle="modal" data-bs-target="#pic_upload_modal" style="object-fit:cover" width="270" >
                </div>

            <div class="main">
                <h3>IDENTITY</h3>
                <div class="card">
                  <div class="card-body">
                        <form action="profile.do">
                            <input type="hidden" name="candidate_id" value="${candidate.candidateId}">
                            <label for="name" class="form-label"><h4>Name :</h4></label>
                            <span><c:out value="${candidate.name}"></c:out></span><br>

                            <label for="email" class="form-label"><h4>Email :</h4></label>
                            <span><c:out value="${candidate.email}"></c:out></span><br>

                            <label for="phone" class="form-label"><h4>Phone :</h4></label>
                            <span><c:out value="${candidate.phone}"></c:out></span><br> 

                            <label for="address" class="form-label"><h4>Address :</h4></label>
                            <span><c:out value="${candidate.address}"></c:out></span><br>

                            <label for="city" class="form-label"><h4>City :</h4></label>
                            <span><c:out value="${candidate.city}"></c:out></span><br>

                            <label for="organization" class="form-label"><h4>Organization :</h4></label>
                            <span><c:out value="${candidate.organization}"></c:out></span><br>

                            <label for="gender" class="form-label"><h4>Gender :</h4></label>
                            <span><c:out value="${candidate.gender}"></c:out></span><br>

                            <label for="adhaarcard" class="form-label"><h4>Adhaarcard :</h4></label>
                            <span><c:out value="${candidate.adhaarcard}"></c:out></span><br>


                        </form>               
                    </div>
                </div>
            </div>

        <%@ include file="footer.jsp" %>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body
</html>

