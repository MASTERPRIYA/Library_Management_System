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
            
            <h2 class="my-2 py-2 text-center rounded-2" style="width:50%; background-color:rgb(0, 71, 171); color: white;">Add Book</h2>
            <div class="col-10 bg-gradient border border-dark rounded-2" style="width:45%; margin-left:400px; background-color:rgb(0, 150, 255);">

                <form action="addBooks.do" method="post" style="padding-bottom:10%; margin-top:60px; margin-left:30px;">
                    
                    <label for="name" class="form-label" style="color: white;"><h3>Book Name :</h3></label>
                    <input type="text" class="form-control mb-4" id="name" name="name"  required="required">

                    <label for="author" class="form-label" style="color: white;"><h3>Author :</h3></label>
                    <input type="text" class="form-control mb-4" id="author" name="author" required="required">
                    
                    <label for="category" class="form-label" style="color: white;"><h4>Category :</h4></label>
                    <select class="form-select mb-4" id="category" name="category" required>
                        <option selected>Select</option>
                        <c:forEach var="category" items="${categories}">
                            <option value="${category.categoryId}">${category.type}</option>
                        </c:forEach>
                    </select>

                    <label for="editions" class="form-label" style="color: white;"><h3>Edition :</h3></label>
                    <input type="text" class="form-control mb-4" id="editions" name="editions" required="required">

                    <label for="quantity" class="form-label" style="color: white;"><h3>Quantity :</h3></label>
                    <input type="number" class="form-control mb-4" id="quantity" name="quantity" required="required">

                    <label for="price" class="form-label" style="color: white;"><h3>Price :</h3></label>
                    <input type="number" class="form-control mb-4" id="price" name="price" required="required">

                    <label for="ISBN" class="form-label" style="color: white;"><h3>ISBN :</h3></label>
                    <input type="text" class="form-control mb-4" id="ISBN" name="ISBN" required="required">

                    <label for="date" class="form-label" style="color: white;"><h3>Date :</h3></label>
                    <input type="date" class="form-control mb-4" id="date" name="date" required="required">

                    <label for="weights" class="form-label" style="color: white;"><h3>Weight :</h3></label>
                    <input type="number" class="form-control mb-4" id="weights" name="weights" required="required">

                    <label for="pages" class="form-label" style="color: white;"><h3>Page :</h3></label>
                    <input type="number" class="form-control mb-4" id="pages" name="pages" required="required">

                    <label for="about" class="form-label" style="color: white;"><h3>About :</h3></label>
                    <textarea class="form-control" id="about" name="about" rows="3"></textarea>

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