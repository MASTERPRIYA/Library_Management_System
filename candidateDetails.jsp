<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>|| Candidate Details ||</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/css/Basic.css">
</head>
<body>
    <div class="container-fluid">

        <div class="row">
            <%@ include file="header.jsp" %>
        </div>

        <table class="table table-striped-columns table-bordered table-secondary border-dark mt-5" style="font-size:1.5rem;">
            <thead>
            <tr>
                <th class="col">Sr no.</th>
                <th class="col">Candidate Id</th>
                <th class="col">Candidate Name</th>
                <th class="col">Phone no.</th>
                <th class="col">Email</th>
                <th class="col">   </th> 
            </tr>
            </thead>
            <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>12345</td>
                    <td>Priya Vishwakarma</td>
                    <td>66666666</td>
                    <td>priyavish@123gmail.com</td>
                    <td><a href="#" style="text-decoration: none;">Show Profile</a></td><!--Pending-->
                </tr>
            </tbody>
            <tbody>
                <tr>
                    <th scope="row">2</th>
                    <td>456789</td>
                    <td>Doremon</td>
                    <td>55555555</td>
                    <td>doremon@gmail.com</td>
                    <td><a href="#" style="text-decoration: none;">Show Profile</a></td><!--Pending-->
                </tr>
             </tbody>



        <%@ include file="footer.jsp" %>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>