<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>|| Show Books Details ||</title>
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
            
            <h2 class="my-2 py-2 text-center rounded-2" style="width:50%; background-color:rgb(0, 71, 171); color: white;">${edition.name}</h2>
            <div class="col-10 bg-gradient border border-dark rounded-2" style="width:40%; margin-left:400px; background-color:rgb(0, 150, 255);">

                <form action="showBooksDetails.do" style="font-size: 30px;  padding-bottom:10%; margin-top:60px; margin-left:30px; color: white; ">

                    <strong>Name : </strong>
                    <span><c:out value= "${edition.name}"></c:out></span><hr>
                    <strong>Author :</strong>
                    <span><c:out value= "${edition.author}"></c:out></span><br>
                    <strong>Quantity :</strong>
                    <span><c:out value= "${edition.quantity}"></c:out></span><br>
                    <strong>Edition :</strong>
                    <span><c:out value= "${edition.editions}"></c:out></span><br>
                    <strong>Pages :</strong></strong>
                    <span><c:out value="${edition.pages}"></c:out></span><br>
                    <strong>Weight :</strong>
                    <span><c:out value="${edition.weights}"></c:out></span><br>
                    <strong>Category :</strong>
                    <span><c:out value="${edition.category.categoryId}"></c:out></span><br>
                    <strong>Price :</strong>
                    <span><c:out value="${edition.price}"></c:out></span><br>
                    <strong>ISBN :</strong>
                    <span><c:out value="${edition.ISBN}"></c:out></span><br>
                    <strong>About :</strong>
                    <span><c:out value="${edition.about}"></c:out></span><br>
        </form>


        <div class="col-1"></div>
       
    </div>
    <%@ include file="footer.jsp" %>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>