<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/home.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <style>
        body{
            background-image: url('../images/home.jpg');
            background-size: cover;
            background-repeat: no-repeat;
        }
    </style>
    <title>صفحه اصلی</title>
</head>
<body>
<div>
<nav class="navbar navbar-expand-lg nav-c ">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <form method="post" action="http://localhost:8080/mohammad_sedghi_hw23_question1_maktab92_war_exploded/beforeLogin">
                        <input type="submit" class="nav-link active text-dark fw-bold" value="ورود">
                    </form>
                </li>
                <li class="nav-item">
                    <a class="nav-link active text-dark fw-bold" aria-current="page" href="signup.html">ثبت نام</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle text-dark fw-bold" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="true">
                        تماس با ما
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#">بیمه مسافرتی</a></li>
                        <li><hr class="dropdown-divider">پشتیبانی سایت</li>
                        <li><a class="dropdown-item" href="#">ثبت نظرات ، انتقادات  </a></li>
                    </ul>
                </li>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="search" type="submit">جست و جو</button>
            </form>
        </div>
    </div>
</nav>
<div>
    <div class="alert alert-success t alert-position" role="alert">
        به سامانه ثبت آنلاین خرید بلیط اتوبوس علی بابا خوش آمدید
         لطفا از منوی بالای صفحه بخش مورد نظر خود را انتخاب کنیدو
         در صورت بروز هر گونه مشکل می توانید از بخش پشتیبانی آنلاین با ما در ارتباط باشید
    </div>
</div>
</div>
</body>
</html>