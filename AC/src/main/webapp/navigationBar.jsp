<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
   content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description"
   content="Start your development with JoeBLog landing page.">
<meta name="author" content="Devcrud">
<!-- font icons -->
<link rel="stylesheet"
   href="assets/vendors/themify-icons/css/themify-icons.css">
   <link rel="icon" href="./assets/imgs/favicon.png" />
<!-- Bootstrap + JoeBLog main styles -->
<link rel="stylesheet" href="assets/css/joeblog.css">
<link rel="stylesheet" href="assets/css/search.css">
<style type="text/css">
.text-left {
   text-align: left;
}

.profile {
   border: 1px solid grey;
}

</style>

</head>
<body data-spy="scroll" data-target=".navbar" data-offset="40" id="home">



         <!-- Sidebar -->
         <div class="page-sidebar text-center">
         <h6 class="sidebar-title section-title mb-4 mt-3"><spring:message code="message.navigation.title"/></h6>
         
         <div class="profile">
               <form action="" method="post">
                       <input type="text" name="mid" placeholder="<spring:message code="message.navigation.id"/>" required /> <input
                     type="password" name="mpw" placeholder="<spring:message code="message.navigation.pw"/>" required /> 
                     <input
                     type="submit" value="<spring:message code="message.navigation.login"/>">
               </form>
            </div>

            <h6 class="sidebar-title mt-5 mb-4"><spring:message code="message.navigation.likemember"/></h6>
            <form action="">
               <div class="subscribe-wrapper">
                  <input type="email" class="form-control"
                     placeholder="<spring:message code="message.navigation.chatting"/>">
                  <button type="submit" class="btn btn-primary">
                     <i class="ti-location-arrow"></i>
                  </button>
               </div>
            </form>
         </div>
         
         


</body>
</html>