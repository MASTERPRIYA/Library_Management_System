<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>|| Publisher View ||</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,500,0,0" />
    <link rel="stylesheet" href="static/css/Basic.css">
</head>
<body>

<!--======================================ADD BOOKS : START +++++++++++++++++++++++++++++++++++++++++++++++++ -->
        <div class="modal fade modal-lg" tabindex="-1" id="add_book">
            <div class="modal-dialog modal-xl">
                <div class="modal-content">
                    <div class="model-header">
                        <h3 class="modal-title mt-3 px-3">If you want to add books you have to create the account or login your account</h3> 
                    </div>
                    <div class="modal-body">
                        <form action="#" method="post">

                            <button type="button" class="btn btn-primary px-5 mt-5 mb-4">
                                <a style="text-decoration: none; color: white;" href="loginPublisher.do">Login</a>
                            </button>

                            <button type="button" class="btn btn-primary px-5 mt-5 mb-4" style="margin-left:40%;">
                                <a style="text-decoration: none; color: white;" href="#">Create Your Account</a>
                            </button>
                            
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary  px-5 mt-4" data-bs-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
<!--======================================ADD BOOKS : END +++++++++++++++++++++++++++++++++++++++++++++++++ -->

    <div class="container-fluid">

        <div class="row">
            <%@ include file="header.jsp" %>
        </div>

        <button type="button" class="btn btn-lg btn-primary mt-4 px-5" style="margin-left: 85%;" data-bs-toggle="modal" data-bs-target="#add_book">Add More Books</button>

        <table class="table table-striped-columns table-bordered table-primary border-dark mt-5" style="font-size:1.5rem;">
            <thead>
                <tr>
                    <th class="col">Book_Id</th>
                    <th class="col">Name</th>
                    <th class="col">Author</th>
                    <th class="col">Category</th>
                    <th class="col">Publisher</th>
                    <th class="col">Edition</th>
                    <th class="col">Quantity</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>Ramayan</td>
                    <td>TulsiDaash</td>
                    <td>Religious</td>
                    <td>A</td>
                    <td>A</td>
                    <td>49</td>
                </tr>
            </tbody>
            <tbody>
                <tr>
                    <th scope="row">2</th>
                    <td>Ramayan</td>
                    <td>TulsiDaash</td>
                    <td>Religious</td>
                    <td>A</td>
                    <td>A</td>
                    <td>49</td>
                </tr>
            </tbody>
        </table>


        <%@ include file="footer.jsp" %>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>