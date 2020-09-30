<%--
  Created by IntelliJ IDEA.
  User: phama
  Date: 9/26/2020
  Time: 11:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
        integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
  <title>Home Page</title>

  <link rel="stylesheet" href="../Style/HomeStyle.css">
</head>
<body>

<div class="container">
  <div class="row" id="header">
    <nav class="navbar navbar-expand-lg " id="nav-bar">
      <a class="navbar-brand" href="/index">PASTRIES</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
              aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="/index">Home <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/user?action=order">Order</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Contact</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#about">About us</a>
          </li>

        </ul>
      </div>
    </nav>
  </div>
  <div class="col" id="banner">
    <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
      <ol class="carousel-indicators">
        <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
        <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
        <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner" >
        <div class="carousel-item active">
          <img src="https://image.freepik.com/free-photo/thread-candied-fruits-near-basket-with-bread_23-2147851939.jpg" class="d-block w-100" alt="...">
          <div class="carousel-caption d-none d-md-block">
            <h5><a class="order-link" href="/user?action=order">Order now</a></h5>
          </div>
        </div>
        <div class="carousel-item">
          <img src="https://image.freepik.com/free-photo/rye-sliced-bread-table_1112-1265.jpg" class="d-block w-100" alt="...">
          <div class="carousel-caption d-none d-md-block">
            <h5><a class="order-link" href="/user?action=order">Order now</a></h5>
          </div>
        </div>
        <div class="carousel-item">
          <img src="https://image.freepik.com/free-photo/top-view-delicious-little-cakes-with-purple-flowers_140725-28112.jpg" class="d-block w-100" alt="...">
          <div class="carousel-caption d-none d-md-block">
            <h5><a class="order-link" href="/user?action=order">Order now</a></h5>
          </div>
        </div>
      </div>
      <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div>
  </div>
  <div class="row" id="productTitle">
    <h4 id="bestseller">Best Sellers</h4>
  </div>
  <div class="row" id="product">


    <div class="card" style="width: 18rem;">
      <img src="https://image.freepik.com/free-photo/top-view-pastries-croissants-brown-desk-dark-background_140725-13605.jpg" class="card-img-top" alt="...">
      <div class="card-body">
        <h5 class="card-title">Card title</h5>
        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the
          card's content.</p>
        <a href="#" class="btn btn-primary">Go somewhere</a>
      </div>
    </div>

    <div class="card" style="width: 18rem;">
      <img src="https://image.freepik.com/free-photo/front-view-donuts-with-chocolate-colorful-candies-brown-desk-grey_140725-13134.jpg" class="card-img-top" alt="...">
      <div class="card-body">
        <h5 class="card-title">Card title</h5>
        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the
          card's content.</p>
        <a href="#" class="btn btn-primary">Go somewhere</a>
      </div>
    </div>

    <div class="card" style="width: 18rem;">
      <img src="https://image.freepik.com/free-photo/top-view-baked-round-cake-with-sugar-powder-wooden-desk_140725-26660.jpg" class="card-img-top" alt="...">
      <div  class="card-body">
        <h5 class="card-title">Card title</h5>
        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the
          card's content.</p>
        <a href="#" class="btn btn-primary">Go somewhere</a>
      </div>
    </div>
  </div>
  <div class="row" id="showMore">
    <h4 id="show2"><a href="/user?action=order" id="show">Show more</a></h4>
  </div>
  <div class="row" id="about">
    <div class="col-7 about-part">
      <img src="https://image.freepik.com/free-photo/woman-cooking_144627-41671.jpg" class="img-fluid" id="girl" alt="girl"/>
    </div>
    <div class="col-5 about-part">
      <div class="col-10" id="text">
        <h4 id="aboutUs">About us</h4>
        <p>We believe in high performance and personal accountability. We take pride in our work and have passion for
          everything we do. Open and honest communication is the cornerstone of everything Pastries. And we aren’t afraid
          to innovate in the traditional baking industry.</p>
      </div>

    </div>
  </div>
  <div class="row" id="introduction">
    <div class="col-5" id="ingredient-text">
      <div class="col-10" id="ingredient">
        <h4 style="text-align: center; padding: 20px">Ingredients</h4>
        <p>Fresh, handcrafted bread and treats. Quality, carefully sourced ingredients. Friends and family.
          Passion and curiosity. We’re up at the crack of dawn so our bakeries smell like Mom’s kitchen.
          After each day of sharing our love for all things fluffy and flaky, we pay it forward by donating
          leftover baked goods to local charities.</p>
      </div>

    </div>
    <div class="col-3 ingredient-pic">
      <img src="https://image.freepik.com/free-photo/flour-wheat-flat-lay-wooden_176474-7337.jpg" class="img-fluid" alt="ingredient">
    </div>
    <div class="col-3 ingredient-pic">
      <img src="https://image.freepik.com/free-photo/different-baking-ingredients-table_144627-29073.jpg" class="img-fluid" alt="eggs">
    </div>
  </div>
  <div id="contact">
    <h3>Contact us</h3>
    <p>Shop:</p>
    <br>
    <p>144 Xa Dan, Dong Da</p>
    <br>
    <p>Ha Noi, Viet Nam</p>
    <br>
    <p>Phone: +84 123 456 789</p>
    <br>
    <p>Email: feedback@patries.com</p>

  </div>
  <footer>
    <p>©CopyRight by Pastries.All right reserved</p>
  </footer>
</div>

</body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
        integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
        crossorigin="anonymous"></script>
</html>
