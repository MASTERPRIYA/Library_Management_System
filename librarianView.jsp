<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>|| Librarian View ||</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
   
</head>
<body>
    <div class="container-fluid">

        <div class="row">
            <%@ include file="header.jsp" %>
        </div>
        <div>
            <div class="d-grid gap-2 col-6 mx-auto mt-5">

                <button type="button" class="btn btn-primary mt-5 mb-5 py-3" >
                    <a style="text-decoration: none; color: white;" href="bookLibrarianView.do">
                        <h4>Books</h4>
                    </a>
                </button>
                
                <button type="button" class="btn btn-primary mt-4 py-3">
                    <a style="text-decoration: none; color: white;" href="candidateDetails.jsp">
                        <h4>Candidates</h4>
                    </a>
                </button>
            </div>
        </div>

        <%@ include file="footer.jsp" %>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>