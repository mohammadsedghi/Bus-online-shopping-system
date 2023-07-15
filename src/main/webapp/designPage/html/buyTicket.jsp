<%@ page import="ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Ticket" %><%--
  Created by IntelliJ IDEA.
  User: mohammad
  Date: 7/13/2023
  Time: 10:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/buyTicket.css">
    <style>
        body{
            background-image: url('../images/home.jpg');
            background-size: cover;
            background-repeat: no-repeat;
        }
    </style>
    <title>تایید اطلاعات </title>
</head>
<body>
<div>
    <div>
        <nav class="navbar navbar-expand-lg nav-c ">
                     <div class="container-fluid">
                            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                                 <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                                          <li class="nav-item">
                                                 <a class="nav-link active text-dark fw-bold" aria-current="page" href="logIn.html">ورود</a>
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
    </div>
    <div><form method="post" action = "http://localhost:8080/mohammad_sedghi_hw23_question1_maktab92_war_exploded/confirm">
    <div class="row mb-3">
        <label for="inputEmail3" class="col-sm-2 col-form-label">نام و نام خانوادگی</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="inputEmail3" name="nameLastname">
        </div>
    </div>
    <fieldset class="row mb-3">
        <legend class="col-form-label col-sm-2 pt-0">جنسیت</legend>
        <div class="col-sm-10">
            <div class="form-check">
                <input class="form-check-input" type="radio" name="inlineRadioOptions" id="gridRadios1" value="male">
                <label class="form-check-label" for="gridRadios1">
                    مرد
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="inlineRadioOptions" id="gridRadios2" value="female">
                <label class="form-check-label" for="gridRadios2">
                    زن
                </label>
            </div>
        </div>
    </fieldset>
    <button type="submit" class="btn btn-primary" name="confirm">تایید</button>
</form>
</div>
</div>
</body>
</html>
