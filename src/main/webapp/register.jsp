<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>rjsp</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

<style type="text/css">
.gradient-custom-3 {
/* fallback for old browsers */
background: #84fab0;

/* Chrome 10-25, Safari 5.1-6 */
background: -webkit-linear-gradient(to right, rgba(132, 250, 176, 0.5), rgba(143, 211, 244, 0.5));

/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
background: linear-gradient(to right, rgba(132, 250, 176, 0.5), rgba(143, 211, 244, 0.5))
}
.gradient-custom-4 {
/* fallback for old browsers */
background: #84fab0;

/* Chrome 10-25, Safari 5.1-6 */
background: -webkit-linear-gradient(to right, rgba(132, 250, 176, 1), rgba(143, 211, 244, 1));

/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
background: linear-gradient(to right, rgba(132, 250, 176, 1), rgba(143, 211, 244, 1))
}
</style>

</head>
<body>

<%-- <section class="vh-100 bg-image"
  style="background-image: url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp');">--%>
  <div class="bg-dark opacity-100">
  <div class="mask d-flex align-items-center h-100 gradient-custom-3">
    <div class="container h-100">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-12 col-md-9 col-lg-7 col-xl-6">
          <div class="card" style="border-radius: 15px;">
            <div class="card-body p-5">
              <h2 class="text-uppercase text-center mb-5">Create Account</h2>

              
              <form action="login" method="post">
                <div class="form-outline mb-4">
                
                  <input type="text" id="form3Example1cg" class="form-control form-control-lg" name="uname" />
                  <label class="form-label" for="form3Example1cg">username</label>
                </div>

                <div class="form-outline mb-4">
                  <input type="password" id="form3Example3cg" class="form-control form-control-lg" name="upassword" />
                  <label class="form-label" for="form3Example3cg">password</label>
                </div>

                <div class="form-outline mb-4">
                
                  <input type="text" id="form3Example4cg" class="form-control form-control-lg" name="fname" />
                  <label class="form-label" for="form3Example4cg">fullname</label>
                </div>

                <div class="form-outline mb-4">
                
                  <input type="email" id="form3Example4cdg" class="form-control form-control-lg" name="email" />
                  <label class="form-label" for="form3Example4cdg">email</label>
                </div>
                
                 <div class="form-outline mb-4">
                 
                  <input type="telephone" id="form3Example4cdg" class="form-control form-control-lg" name="mobile" />
                  <label class="form-label" for="form3Example4cdg">contact no</label>
                </div>
                
                

                <div class="d-flex justify-content-center">
                  <input type="submit" value="register" class="btn btn-outline-success"> <p class="text-center text-muted mt-5 mb-0 ">
                   
                </div>
                
                </form>
               <p class="text-center text-muted mt-5 mb-0 "><a href="login"><input type="button" value="signin" class="btn btn-outline-success"></a>

            </div>
           
          </div>
        </div>
      </div>
    </div>
  </div>
  </div>
<%--</section>--%>

</head>

<body>
<%-- <body>
<center><h1><placeholder=CreateAccount>CreateAccount</h1></center>
<center><h3>Register</h3></center>
<h4>${err}</h4>
<center><form action="register" method="post">

<input type="text" placeholder="username" name="uname"><br></br>
<input type="password" placeholder="password" name="upassword"><br></br>
<input type="text" placeholder="fullname"  name="fname"><br></br>
<input type="email" placeholder="Email" name="email"><br></br>
<input type="telephone" placeholder="Contactno"  name="mobile"><br></br>
<a href="login" ><input type="submit" value="register"> </a><br></br>
<a href="login">signin</a></center></br><br></br>
</form>
</body>
</html>--%>







