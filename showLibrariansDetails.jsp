<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>|| Show Librarian Details ||</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/css/Basic.css">
</head>
<body>
   
    <div class="container-fluid">

        <div class="row">
            <%@ include file="header.jsp" %>
        </div>

        <div class="row justify-content-center d-flex">
            
            <div class="col-1"></div>
            
            <h2 class="my-2 py-2 text-center rounded-2" style="width:70%; background-color:rgb(0, 71, 171); color: white;">${librarian.name}</h2>
            <div class="col-10 bg-gradient border border-dark rounded-2" style="width:50%; margin-left:400px; background-color:rgb(0, 150, 255);">

        <form action="showLibrariansDetails.do" style="padding-bottom:10%; margin-top:60px; margin-left:30px; ">

                    <b><h4>Name :</h4></b>
                    <span><c:out value= "${librarian.name}"></c:out></span><br>
                    <b><h3>Phone :</h3></b>
                    <span><c:out value= "${librarian.phone}"></c:out></span><br>
                    <b><h3>Password :</h3></b>
                    <span><c:out value= "${librarian.password}"></c:out></span><br>
                    <b><h3>AdhaarCard :</h3></b>
                    <span><c:out value= "${librarian.adhaarcard}"></c:out></span><br>
                    <b><h3>Qualification :</h3></b>
                    <span><c:out value="${librarian.qualification}"></c:out></span><br>
                    <b><h3>Experience :</h3></b>
                    <span><c:out value="${librarian.experience}"></c:out></span><br>
                    <b><h3>City :</h3></b>
                    <span><c:out value="${librarian.city.cityId}"></c:out></span><br>
                    <b><h3>About :</h3></b>
                    <span><c:out value="${librarian.about}"></c:out></span><br>
        </form>


        <div class="col-1"></div>
       
    </div>
    <%@ include file="footer.jsp" %>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>