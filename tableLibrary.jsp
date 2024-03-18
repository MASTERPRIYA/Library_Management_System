<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

        <div class="col-1"></div>

        <div class="d-flex justify-content-center">
            <h2 class="my-2 py-3 text-center border rounded-2" style="width:90%; background-color:rgb(0, 71, 171); color:white;">Librarian Details</h2>
        </div>

        <button type="button" class="btn mt-4 px-5" style="background-color:rgb(0, 71, 171); ">
            <a style="text-decoration: none ; color:rgb(255, 255, 255);" href="addLibrarian.do">Add Librarian</a>
        </button>

        <div class="btn-group dropend">
            <button class="btn dropdown-toggle px-4 mt-4" type="button" data-bs-toggle="dropdown" style="color:rgb(255, 255, 255);margin-left:100%; background-color:rgb(0, 71, 171); ">Menu</button>
            <ul class="dropdown-menu p-2">
                <li><a style="text-decoration: none ; font-size: 20px;"class="dropdown-item" href="#">Edit</a></li>
                <li><a style="text-decoration: none ; font-size: 20px;" class="dropdown-item" href="#">Delete</a></li>
            </ul>
        </div>

        <div class="col-10" style="margin-top:100px; margin-left:190px;">
            
            
            <table class="table table-striped-columns table-bordered table-primary border-dark" style="font-size:1.5rem;">
                <thead>
                    <tr>
                        <th scope="col">Sr.</th>
                        <th scope="col">Name</th>
                        <th scope="col">Email</th>
                        <th scope="col">Phone</th>
                        <th>Details</th>
                    </tr>
                </thead>
                 <tbody>
                    <c:forEach var="lib" items="${librarians}" varStatus="counter">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${lib.name}</td>
                            <td>${lib.email}</td>
                            <td>${lib.phone}</td>
                            <td><a href="showLibrariansDetails.do?librarian_id=${lib.librarianId}">Details</a></td>
                        </tr>
                    </c:forEach> 
                </tbody>
            </table>
        </div>

        <div class="col-1"></div>
        <%@ include file="footer.jsp" %>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>