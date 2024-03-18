<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>|| Publisher View ||</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,500,0,0" />
</head>
<body>
    
   <div class="container-fluid">

        <div class="row">
            <%@ include file="header.jsp" %>
        </div>

        <button type="button" class="btn btn-lg btn-primary mt-4 px-5" style="margin-left: 85%;"> 
            <a style="text-decoration: none; color: rgb(255, 255, 255);" href="addBooks.do">
                <h3>Add Books</h3>
            </a>
        </button>

        <table class="table table-striped-columns table-bordered table-primary border-dark mt-5" style="font-size:1.5rem;">
            <thead>
                <tr>
                    <th class="col">Sr.</th>
                    <th class="col">Name</th>
                    <th class="col">Author</th>
                    <th class="col">Quantity</th>
                    <th class="col" style="text-decoration: none;">Details</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="edition" items="${editionBook}" varStatus="counter">
                <tr>
                    <td>${counter.count}</td>
                    <td>${edition.name}</td>
                    <td>${edition.author}</td>
                    <td>${edition.quantity}</td>
                    <td><a href="showBooksDetails.do?edition_id=${edition.editionId}" style="text-decoration: none;">Detail</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>


        <%@ include file="footer.jsp" %>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>