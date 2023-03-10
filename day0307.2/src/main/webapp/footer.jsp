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
<title>JoeBLog | Free Bootstrap 4.3.x template</title>
<!-- font icons -->
<link rel="stylesheet"
   href="assets/vendors/themify-icons/css/themify-icons.css">
<!-- Bootstrap + JoeBLog main styles -->
<link rel="stylesheet" href="assets/css/joeblog.css">
<style type="text/css">
      .bg-primary {
        background-color: white !important;
        border-bottom: 1px solid #9e9e9e;
      }

      .ml-auto {
        list-style: none;
        margin-left: 0px !important;
      }

      img {
        vertical-align: middle;
        border-style: none;
     
      }

      .container {
        /* width: 80%; */
        padding-right: 15px;
        padding-left: 15px;
        margin-right: auto;
        margin-left: auto;
      }
     
      .navbar-expand-md .navbar-collapse {
    display: -webkit-box !important;
    display: -webkit-flex !important;
    display: -ms-flexbox !important;
    display: flex !important;
    -webkit-flex-basis: auto;
        -ms-flex-preferred-size: auto;
            flex-basis: auto;
            justify-content: flex-end;
  }
   .acense{
     padding-bottom:0px;
   
   }
   .navbar .navbar-brand img {
    width: 90px; 
   }
     img{
        width:80px;
     }
     .btn-primary {
    color: white;
    background-color: #a0ba83;
   
}
   
    </style>
</head>
<body data-spy="scroll" data-target=".navbar" data-offset="40" id="home">


   <!-- Page Footer -->
   <footer class="page-footer">
      <div class="container">
   <hr>
         <div class="row align-items-center justify-content-between">
            <div class="col-md-3 text-center text-md-left mb-3 mb-md-0">
            
            </div>
            <div class="col-md-9 text-center text-md-right">
               <div class=" mb-0 small" data-v-59015b26=""
                  data-v-555a2171="">
                  
                     <!-- ?????? ?????? -->
            <a class="navbar-brand" href="main.do"> <img 
                        src="assets/imgs/ace.png" alt="??????" />
                     </a>
                  <div class="footer-info-copyright" data-v-59015b26=""
                     data-v-555a2171="">
                     <div class="c-application c-typography c-caption1"
                        style="color: #ADB3B8;" data-v-45a3e27e="" data-v-555a2171=""
                        data-v-59015b26="">
                        <!-- ?????? : ????????? ??? 06236 ????????? ????????? ????????? ???????????? 146(?????????) 13??? J????????? ??? Tel :
                        1108-0331 ??? ????????? ???????????? : 123-45-67890 --> 
                        <spring:message code="message.footer.first"/><br data-v-45a3e27e=""
                           data-v-555a2171=""> <!-- ??????????????? ???????????? : ??? 2021-????????????-2580??? ???
                        ???????????? ???????????? : ????????? ???2018-19??? --><spring:message code="message.footer.second"/> <br
                           data-v-45a3e27e="" data-v-555a2171=""><!-- ???????????? ???????????? : ???
                         2022-3010165-14-5-00021??? -->
                        <div data-v-45a3e27e="" data-v-555a2171="" class="">
                           Copyright by (???)SixSense. All right reserved.</div>
                     </div>
                     
                  </div>
               </div>
               <div class="socials"></div>
            </div>
         </div>
         <p class="border-top mb-0 mt-4 pt-3 small">
            &copy;
            <script>
               document.write(new Date().getFullYear())
            </script>
            , Acense Community Created By SixSense
         </p>
      </div>
   </footer>
   <!-- End of Page Footer -->

   <!-- core  -->
   <script src="assets/vendors/jquery/jquery-3.4.1.js"></script>
   <script src="assets/vendors/bootstrap/bootstrap.bundle.js"></script>

   <!-- JoeBLog js -->
   <script src="assets/js/joeblog.js"></script>

</body>
</html>