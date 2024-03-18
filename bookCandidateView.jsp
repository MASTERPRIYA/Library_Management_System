<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,500,0,0" />
</head>
<body>
    
   <div class="container-fluid">

        <div class="row">
            <%@ include file="header.jsp" %>
        </div>

        <form class="d-flex ">
            <input class="form-control mt-4 border-dark" type="search" onkeyup="searchBook()"  id="myInput" placeholder="Search by Book Name" aria-label="Search">
          </form>

        <table class="table table-striped-columns table-bordered table-primary border-dark mt-5" id="myTable" style="font-size:1.5rem;">
            <thead>
                <tr>
                    <th class="col">Sr.</th>
                    <th class="col">Name</th>
                    <th class="col">Author</th>
                    <th class="col">Quantity</th>
                    <th class="col" style="text-decoration: none;">Details</th>
                    <th class="col">Issue</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="edition" items="${editionBook}" varStatus="counter">
                <tr>
                    <td>${counter.count}</td>
                    <td>${edition.name}</td>
                    <td>${edition.author}</td>
                    <td>${edition.quantity}</td>
                    <td><a href="showBooksDetails.do?edition_id=${edition.editionId}" style="text-decoration: none;">Detail</a>
                     <td>
                        <button type="button" class="btn btn-warning px-4">
                            <a href="#" style="text-decoration: none; color: black;">Issue book</a>
                        </button>
                     </td>   
                </tr>
            </c:forEach>
            </tbody>
        </table>


        <%@ include file="footer.jsp" %>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <script>

        const searchBook = () => {

            let myInput = document.getElementById('myInput').value.toLowerCase(); // Search bar
            let myTable = document.getElementById('myTable'); //Table
            let tr = myTable.getElementsByTagName('tr');//tr

            for(var i=0;i<tr.length;i++){
                let td = tr[i].getElementsByTagName('td')[1]; //1 because only Books name row is 1
               
                if(td){
                    let textValue = td.textContent || td.innerHTML;

                    if(textValue.toLowerCase().indexOf(myInput)>-1){
                        tr[i].style.display="";
                    }
                    
                    else{
                        tr[i].style.display="none";
                    }
                }
            }
        }
    </script>
</body>
</html>