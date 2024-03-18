<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>|| Add Librarian ||</title>
    
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">

</head>
<body>

    <div class="container-fluid">

        <div class="row">
            <%@ include file="header.jsp" %>
        </div>

        <div class="row justify-content-center d-flex">
            
            <div class="col-1"></div>
            
            <h2 class="my-2 py-2 text-center rounded-2" style="width:70%; background-color:rgb(0, 71, 171); color: white;">Fill Librarian Details</h2>
            <div class="col-10 bg-gradient border border-dark rounded-2" style="width:55%; margin-left:450px; background-color:rgb(0, 150, 255);">

                <form action="addLibrarian.do" method="post" style="padding-bottom:20%; margin-top:60px; margin-left:30px;">
                    
                    <label for="name" class="form-label" style="color: white;"><h3>Name* :</h3></label>
                    <input type="text" class="form-control mb-4" id="name" name="name"  required="required">

                    <label for="userType" class="form-label" style="color: white;"><h4>UserType :</h4></label>
                    <select class="form-select mb-4" id="userType" name="userType" required="required">
                        <option selected>Select</option>
                        <c:forEach var="userType" items="${userTypes}">
                            <option value="${userType.userTypeId}">${userType.name}</option>
                        </c:forEach>
                    </select>

                    <label for="phone" class="form-label" style="color: white;"><h3>Phone* :</h3></label>
                    <input type="number" class="form-control mb-4" id="phone" name="phone" required="required">
                    
                    <label for="email" class="form-label" style="color: white;"><h3>Email* :</h3></label>
                    <input type="email" class="form-control mb-4" id="email" name="email" required="required">

                    <label for="city" class="form-label" style="color: white;"><h4>City :</h4></label>
                    <select class="form-select mb-4" id="city" name="city" required>
                        <option selected>Select</option>
                        <c:forEach var="city" items="${cities}">
                            <option value="${city.cityId}">${city.name}</option>
                        </c:forEach>
                    </select>
                    <div class="invalid-feedback">
                        Please select any particular city !
                    </div>

                    <label for="password" class="form-label" style="color: white;"><h3>Password* :</h3></label>
                    <input type="password" class="form-control mb-4" id="password" name="password" required="required">

                    <label for="adhaarcard" class="form-label" style="color: white;"><h3>AdhaarCard* :</h3></label>
                    <input type="number" class="form-control mb-4" id="adhaarcard" name="adhaarcard" required="required">

                    <label for="qualification" class="form-label" style="color: white;"><h3>Qualification* :</h3></label>
                    <input type="text" class="form-control mb-4" id="qualification"  name="qualification" required="required">

                    <label for="experience" class="form-label" style="color: white;"><h3>Experience* :</h3></label>
                    <input type="number" class="form-control mb-4" id="experience" name="experience" required="required">

                    <label for="about" class="form-label" style="color: white;"><h3>About :</h3></label>
                    <textarea class="form-control" id="about" name="about" rows="3"></textarea>

                    
                    <p class="text-start mt-5 fs-4" style="color: red;">* This indicates mandatory fields.</p>
                    <input type="submit" value="Save" class="btn btn-dark btn-lg px-5 mt-5">

                </form>
            </div>
            <div class="col-1"></div>
        </div>
        <%@ include file="footer.jsp" %>
    </div>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
   
</body>
</html>