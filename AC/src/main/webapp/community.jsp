<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티</title>
<style>
.card-title {
   margin-bottom: 0.75rem;
   padding-top: 50px;
}

.tag-btn {
   color: black;
   border: 1px solid black;
   font-size: 20px;
   border: none;
   border-readius: 20px;
}

.a-none:hover {
   text-decoration: none;
}
button{ position:absolute; top:50%; left:50%;
  width:120px; height:30px; margin-top:-15px; margin-left:-60px;
  line-height:15px; cursor:pointer;
}

.modal{ 
  position:absolute; width:100%; height:100%; background: rgba(0,0,0,0.8); top:0; left:0; display:none;
}

.modal_content{
  width:400px; height:200px;
  background:#fff; border-radius:10px;
  position:relative; top:50%; left:50%;
  margin-top:-100px; margin-left:-200px;
  text-align:center;
  box-sizing:border-box; padding:74px 0;
  line-height:23px; cursor:pointer;
}
</style>
</head>
<body>

   <%@ include file="./header.jsp"%>




<button>모달창</button>

<div class="modal">
  <div class="modal_content" 
       title="클릭하면 창이 닫힙니다.">
    여기에 모달창 내용을 적어줍니다.<br>
    이미지여도 좋고 글이어도 좋습니다.
  </div>
</div>


   <div class="container">

      <div class="page-container">
         <div class="page-content">
            <div class="card">
               <div class="card-header text-center">
                  <h5 class="card-title">커뮤니티</h5>
               </div>
               <div class="card-body">
                  <!-- <div class="blog-media">
                     <button type="button" class="tag-btn" data-filter="sile">#실생활</button>
                  </div> -->

                  <!-- 테스트 -->
                  <div>
                     <div class="flex-w flex-sb-m p-b-52">
                        <div class="flex-w flex-l-m filter-tope-group m-tb-10">
                           <button data-filter="*">글 전체 목록</button>

                           <button data-filter=".women">#오운완</button>

                           <button data-filter=".men">#데일리</button>

                           <button data-filter=".bag">#ㅎ</button>

                           <button data-filter=".shoes">#ㅇㅇ..</button>

                           <button data-filter=".watches">#???</button>
                        </div>

                        <hr>

                        <table>
                           <colgroup>
                              <col style="width: 7%">
                              <col style="width: 400px">
                              <col style="width: 400px">
                              <col style="width: 18%">
                              <col style="width: 6%">
                              <col style="width: 6%">

                           </colgroup>
                           <thead>
                              <tr>
                                 <th scope="col" style="padding-left: 5px;">번호</th>
                                 <th scope="col">말머리</th>
                                 <th scope="col">제목</th>
                                 <th scope="col">글쓴이</th>
                                 <th scope="col">작성일</th>
                                 <th scope="col" style="padding-left: 2.5%;">추천</th>
                              </tr>
                           </thead>
                           <tr>
                              <td>
                                 <div class="row isotope-grid">
                                    <div
                                       class="col-sm-6 col-md-4 col-lg-3 p-b-35 isotope-item women">
                                       <!-- Block2 -->
                                       <div class="block2">
                                          <div class="block2-pic hov-img0"></div>

                                          <div class="block2-txt flex-w flex-t p-t-14">
                                             <div class="block2-txt-child1 flex-col-l "></div>
                                             <p>1</p>
                                             <div class="block2-txt-child2 flex-r p-t-3"></div>
                                          </div>
                                       </div>
                                    </div>
                                 </div>

                              </td>
                           </tr>
                        </table>

                        <div class="row isotope-grid">
                           <div
                              class="col-sm-6 col-md-4 col-lg-3 p-b-35 isotope-item women">
                              <!-- Block2 -->
                              <div class="block2">
                                 <div class="block2-pic hov-img0"></div>

                                 <div class="block2-txt flex-w flex-t p-t-14">
                                    <div class="block2-txt-child1 flex-col-l "></div>

                                    <div class="block2-txt-child2 flex-r p-t-3"></div>
                                 </div>
                              </div>
                           </div>

                           <div
                              class="col-sm-6 col-md-4 col-lg-3 p-b-35 isotope-item women">
                              <!-- Block2 -->
                              <div class="block2">
                                 <div class="block2-pic hov-img0">
                                    <img src="images/product-02.jpg" alt="IMG-PRODUCT"> <a
                                       href="#"
                                       class="block2-btn flex-c-m stext-103 cl2 size-102 bg0 bor2 hov-btn1 p-lr-15 trans-04 js-show-modal1">
                                       Quick View </a>
                                 </div>

                                 <div class="block2-txt flex-w flex-t p-t-14">
                                    <div class="block2-txt-child1 flex-col-l ">
                                       <a href="product-detail.html"
                                          class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6">
                                          Herschel supply </a> <span class="stext-105 cl3">
                                          $35.31 </span>
                                    </div>

                                    <div class="block2-txt-child2 flex-r p-t-3">
                                       <a href="#"
                                          class="btn-addwish-b2 dis-block pos-relative js-addwish-b2">
                                          <img class="icon-heart1 dis-block trans-04"
                                          src="images/icons/icon-heart-01.png" alt="ICON"> <img
                                          class="icon-heart2 dis-block trans-04 ab-t-l"
                                          src="images/icons/icon-heart-02.png" alt="ICON">
                                       </a>
                                    </div>
                                 </div>
                              </div>
                           </div>

                           <div class="col-sm-6 col-md-4 col-lg-3 p-b-35 isotope-item men">
                              <!-- Block2 -->
                              <div class="block2">
                                 <div class="block2-pic hov-img0">
                                    <img src="images/product-03.jpg" alt="IMG-PRODUCT"> <a
                                       href="#"
                                       class="block2-btn flex-c-m stext-103 cl2 size-102 bg0 bor2 hov-btn1 p-lr-15 trans-04 js-show-modal1">
                                       Quick View </a>
                                 </div>

                                 <div class="block2-txt flex-w flex-t p-t-14">
                                    <div class="block2-txt-child1 flex-col-l ">
                                       <a href="product-detail.html"
                                          class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6">
                                          Only Check Trouser </a> <span class="stext-105 cl3">
                                          $25.50 </span>
                                    </div>

                                    <div class="block2-txt-child2 flex-r p-t-3">
                                       <a href="#"
                                          class="btn-addwish-b2 dis-block pos-relative js-addwish-b2">
                                          <img class="icon-heart1 dis-block trans-04"
                                          src="images/icons/icon-heart-01.png" alt="ICON"> <img
                                          class="icon-heart2 dis-block trans-04 ab-t-l"
                                          src="images/icons/icon-heart-02.png" alt="ICON">
                                       </a>
                                    </div>
                                 </div>
                              </div>
                           </div>

                           <div
                              class="col-sm-6 col-md-4 col-lg-3 p-b-35 isotope-item women">
                              <!-- Block2 -->
                              <div class="block2">
                                 <div class="block2-pic hov-img0">
                                    <img src="images/product-04.jpg" alt="IMG-PRODUCT"> <a
                                       href="#"
                                       class="block2-btn flex-c-m stext-103 cl2 size-102 bg0 bor2 hov-btn1 p-lr-15 trans-04 js-show-modal1">
                                       Quick View </a>
                                 </div>

                                 <div class="block2-txt flex-w flex-t p-t-14">
                                    <div class="block2-txt-child1 flex-col-l ">
                                       <a href="product-detail.html"
                                          class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6">
                                          Classic Trench Coat </a> <span class="stext-105 cl3">
                                          $75.00 </span>
                                    </div>

                                    <div class="block2-txt-child2 flex-r p-t-3">
                                       <a href="#"
                                          class="btn-addwish-b2 dis-block pos-relative js-addwish-b2">
                                          <img class="icon-heart1 dis-block trans-04"
                                          src="images/icons/icon-heart-01.png" alt="ICON"> <img
                                          class="icon-heart2 dis-block trans-04 ab-t-l"
                                          src="images/icons/icon-heart-02.png" alt="ICON">
                                       </a>
                                    </div>
                                 </div>
                              </div>
                           </div>

                           <div
                              class="col-sm-6 col-md-4 col-lg-3 p-b-35 isotope-item women">
                              <!-- Block2 -->
                              <div class="block2">
                                 <div class="block2-pic hov-img0">
                                    <img src="images/product-05.jpg" alt="IMG-PRODUCT"> <a
                                       href="#"
                                       class="block2-btn flex-c-m stext-103 cl2 size-102 bg0 bor2 hov-btn1 p-lr-15 trans-04 js-show-modal1">
                                       Quick View </a>
                                 </div>

                                 <div class="block2-txt flex-w flex-t p-t-14">
                                    <div class="block2-txt-child1 flex-col-l ">
                                       <a href="product-detail.html"
                                          class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6">
                                          Front Pocket Jumper </a> <span class="stext-105 cl3">
                                          $34.75 </span>
                                    </div>

                                    <div class="block2-txt-child2 flex-r p-t-3">
                                       <a href="#"
                                          class="btn-addwish-b2 dis-block pos-relative js-addwish-b2">
                                          <img class="icon-heart1 dis-block trans-04"
                                          src="images/icons/icon-heart-01.png" alt="ICON"> <img
                                          class="icon-heart2 dis-block trans-04 ab-t-l"
                                          src="images/icons/icon-heart-02.png" alt="ICON">
                                       </a>
                                    </div>
                                 </div>
                              </div>
                           </div>

                           <div
                              class="col-sm-6 col-md-4 col-lg-3 p-b-35 isotope-item watches">
                              <!-- Block2 -->
                              <div class="block2">
                                 <div class="block2-pic hov-img0">
                                    <img src="images/product-06.jpg" alt="IMG-PRODUCT"> <a
                                       href="#"
                                       class="block2-btn flex-c-m stext-103 cl2 size-102 bg0 bor2 hov-btn1 p-lr-15 trans-04 js-show-modal1">
                                       Quick View </a>
                                 </div>

                                 <div class="block2-txt flex-w flex-t p-t-14">
                                    <div class="block2-txt-child1 flex-col-l ">
                                       <a href="product-detail.html"
                                          class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6">
                                          Vintage Inspired Classic </a> <span class="stext-105 cl3">
                                          $93.20 </span>
                                    </div>

                                    <div class="block2-txt-child2 flex-r p-t-3">
                                       <a href="#"
                                          class="btn-addwish-b2 dis-block pos-relative js-addwish-b2">
                                          <img class="icon-heart1 dis-block trans-04"
                                          src="images/icons/icon-heart-01.png" alt="ICON"> <img
                                          class="icon-heart2 dis-block trans-04 ab-t-l"
                                          src="images/icons/icon-heart-02.png" alt="ICON">
                                       </a>
                                    </div>
                                 </div>
                              </div>
                           </div>

                           <div
                              class="col-sm-6 col-md-4 col-lg-3 p-b-35 isotope-item women">
                              <!-- Block2 -->
                              <div class="block2">
                                 <div class="block2-pic hov-img0">
                                    <img src="images/product-07.jpg" alt="IMG-PRODUCT"> <a
                                       href="#"
                                       class="block2-btn flex-c-m stext-103 cl2 size-102 bg0 bor2 hov-btn1 p-lr-15 trans-04 js-show-modal1">
                                       Quick View </a>
                                 </div>

                                 <div class="block2-txt flex-w flex-t p-t-14">
                                    <div class="block2-txt-child1 flex-col-l ">
                                       <a href="product-detail.html"
                                          class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6">
                                          Shirt in Stretch Cotton </a> <span class="stext-105 cl3">
                                          $52.66 </span>
                                    </div>

                                    <div class="block2-txt-child2 flex-r p-t-3">
                                       <a href="#"
                                          class="btn-addwish-b2 dis-block pos-relative js-addwish-b2">
                                          <img class="icon-heart1 dis-block trans-04"
                                          src="images/icons/icon-heart-01.png" alt="ICON"> <img
                                          class="icon-heart2 dis-block trans-04 ab-t-l"
                                          src="images/icons/icon-heart-02.png" alt="ICON">
                                       </a>
                                    </div>
                                 </div>
                              </div>
                           </div>

                           <div
                              class="col-sm-6 col-md-4 col-lg-3 p-b-35 isotope-item women">
                              <!-- Block2 -->
                              <div class="block2">
                                 <div class="block2-pic hov-img0">
                                    <img src="images/product-08.jpg" alt="IMG-PRODUCT"> <a
                                       href="#"
                                       class="block2-btn flex-c-m stext-103 cl2 size-102 bg0 bor2 hov-btn1 p-lr-15 trans-04 js-show-modal1">
                                       Quick View </a>
                                 </div>

                                 <div class="block2-txt flex-w flex-t p-t-14">
                                    <div class="block2-txt-child1 flex-col-l ">
                                       <a href="product-detail.html"
                                          class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6">
                                          Pieces Metallic Printed </a> <span class="stext-105 cl3">
                                          $18.96 </span>
                                    </div>

                                    <div class="block2-txt-child2 flex-r p-t-3">
                                       <a href="#"
                                          class="btn-addwish-b2 dis-block pos-relative js-addwish-b2">
                                          <img class="icon-heart1 dis-block trans-04"
                                          src="images/icons/icon-heart-01.png" alt="ICON"> <img
                                          class="icon-heart2 dis-block trans-04 ab-t-l"
                                          src="images/icons/icon-heart-02.png" alt="ICON">
                                       </a>
                                    </div>
                                 </div>
                              </div>
                           </div>

                           <div
                              class="col-sm-6 col-md-4 col-lg-3 p-b-35 isotope-item shoes">
                              <!-- Block2 -->
                              <div class="block2">
                                 <div class="block2-pic hov-img0">
                                    <img src="images/product-09.jpg" alt="IMG-PRODUCT"> <a
                                       href="#"
                                       class="block2-btn flex-c-m stext-103 cl2 size-102 bg0 bor2 hov-btn1 p-lr-15 trans-04 js-show-modal1">
                                       Quick View </a>
                                 </div>

                                 <div class="block2-txt flex-w flex-t p-t-14">
                                    <div class="block2-txt-child1 flex-col-l ">
                                       <a href="product-detail.html"
                                          class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6">
                                          Converse All Star Hi Plimsolls </a> <span
                                          class="stext-105 cl3"> $75.00 </span>
                                    </div>

                                    <div class="block2-txt-child2 flex-r p-t-3">
                                       <a href="#"
                                          class="btn-addwish-b2 dis-block pos-relative js-addwish-b2">
                                          <img class="icon-heart1 dis-block trans-04"
                                          src="images/icons/icon-heart-01.png" alt="ICON"> <img
                                          class="icon-heart2 dis-block trans-04 ab-t-l"
                                          src="images/icons/icon-heart-02.png" alt="ICON">
                                       </a>
                                    </div>
                                 </div>
                              </div>
                           </div>

                           <div
                              class="col-sm-6 col-md-4 col-lg-3 p-b-35 isotope-item women">
                              <!-- Block2 -->
                              <div class="block2">
                                 <div class="block2-pic hov-img0">
                                    <img src="images/product-10.jpg" alt="IMG-PRODUCT"> <a
                                       href="#"
                                       class="block2-btn flex-c-m stext-103 cl2 size-102 bg0 bor2 hov-btn1 p-lr-15 trans-04 js-show-modal1">
                                       Quick View </a>
                                 </div>

                                 <div class="block2-txt flex-w flex-t p-t-14">
                                    <div class="block2-txt-child1 flex-col-l ">
                                       <a href="product-detail.html"
                                          class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6">
                                          Femme T-Shirt In Stripe </a> <span class="stext-105 cl3">
                                          $25.85 </span>
                                    </div>

                                    <div class="block2-txt-child2 flex-r p-t-3">
                                       <a href="#"
                                          class="btn-addwish-b2 dis-block pos-relative js-addwish-b2">
                                          <img class="icon-heart1 dis-block trans-04"
                                          src="images/icons/icon-heart-01.png" alt="ICON"> <img
                                          class="icon-heart2 dis-block trans-04 ab-t-l"
                                          src="images/icons/icon-heart-02.png" alt="ICON">
                                       </a>
                                    </div>
                                 </div>
                              </div>
                           </div>

                           <div class="col-sm-6 col-md-4 col-lg-3 p-b-35 isotope-item men">
                              <!-- Block2 -->
                              <div class="block2">
                                 <div class="block2-pic hov-img0">
                                    <img src="images/product-11.jpg" alt="IMG-PRODUCT"> <a
                                       href="#"
                                       class="block2-btn flex-c-m stext-103 cl2 size-102 bg0 bor2 hov-btn1 p-lr-15 trans-04 js-show-modal1">
                                       Quick View </a>
                                 </div>

                                 <div class="block2-txt flex-w flex-t p-t-14">
                                    <div class="block2-txt-child1 flex-col-l ">
                                       <a href="product-detail.html"
                                          class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6">
                                          Herschel supply </a> <span class="stext-105 cl3">
                                          $63.16 </span>
                                    </div>

                                    <div class="block2-txt-child2 flex-r p-t-3">
                                       <a href="#"
                                          class="btn-addwish-b2 dis-block pos-relative js-addwish-b2">
                                          <img class="icon-heart1 dis-block trans-04"
                                          src="images/icons/icon-heart-01.png" alt="ICON"> <img
                                          class="icon-heart2 dis-block trans-04 ab-t-l"
                                          src="images/icons/icon-heart-02.png" alt="ICON">
                                       </a>
                                    </div>
                                 </div>
                              </div>
                           </div>

                           <div class="col-sm-6 col-md-4 col-lg-3 p-b-35 isotope-item men">
                              <!-- Block2 -->
                              <div class="block2">
                                 <div class="block2-pic hov-img0">
                                    <img src="images/product-12.jpg" alt="IMG-PRODUCT"> <a
                                       href="#"
                                       class="block2-btn flex-c-m stext-103 cl2 size-102 bg0 bor2 hov-btn1 p-lr-15 trans-04 js-show-modal1">
                                       Quick View </a>
                                 </div>

                                 <div class="block2-txt flex-w flex-t p-t-14">
                                    <div class="block2-txt-child1 flex-col-l ">
                                       <a href="product-detail.html"
                                          class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6">
                                          Herschel supply </a> <span class="stext-105 cl3">
                                          $63.15 </span>
                                    </div>

                                    <div class="block2-txt-child2 flex-r p-t-3">
                                       <a href="#"
                                          class="btn-addwish-b2 dis-block pos-relative js-addwish-b2">
                                          <img class="icon-heart1 dis-block trans-04"
                                          src="images/icons/icon-heart-01.png" alt="ICON"> <img
                                          class="icon-heart2 dis-block trans-04 ab-t-l"
                                          src="images/icons/icon-heart-02.png" alt="ICON">
                                       </a>
                                    </div>
                                 </div>
                              </div>
                           </div>

                           <div
                              class="col-sm-6 col-md-4 col-lg-3 p-b-35 isotope-item women">
                              <!-- Block2 -->
                              <div class="block2">
                                 <div class="block2-pic hov-img0">
                                    <img src="images/product-13.jpg" alt="IMG-PRODUCT"> <a
                                       href="#"
                                       class="block2-btn flex-c-m stext-103 cl2 size-102 bg0 bor2 hov-btn1 p-lr-15 trans-04 js-show-modal1">
                                       Quick View </a>
                                 </div>

                                 <div class="block2-txt flex-w flex-t p-t-14">
                                    <div class="block2-txt-child1 flex-col-l ">
                                       <a href="product-detail.html"
                                          class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6">
                                          T-Shirt with Sleeve </a> <span class="stext-105 cl3">
                                          $18.49 </span>
                                    </div>

                                    <div class="block2-txt-child2 flex-r p-t-3">
                                       <a href="#"
                                          class="btn-addwish-b2 dis-block pos-relative js-addwish-b2">
                                          <img class="icon-heart1 dis-block trans-04"
                                          src="images/icons/icon-heart-01.png" alt="ICON"> <img
                                          class="icon-heart2 dis-block trans-04 ab-t-l"
                                          src="images/icons/icon-heart-02.png" alt="ICON">
                                       </a>
                                    </div>
                                 </div>
                              </div>
                           </div>

                           <div
                              class="col-sm-6 col-md-4 col-lg-3 p-b-35 isotope-item women">
                              <!-- Block2 -->
                              <div class="block2">
                                 <div class="block2-pic hov-img0">
                                    <img src="images/product-14.jpg" alt="IMG-PRODUCT"> <a
                                       href="#"
                                       class="block2-btn flex-c-m stext-103 cl2 size-102 bg0 bor2 hov-btn1 p-lr-15 trans-04 js-show-modal1">
                                       Quick View </a>
                                 </div>

                                 <div class="block2-txt flex-w flex-t p-t-14">
                                    <div class="block2-txt-child1 flex-col-l ">
                                       <a href="product-detail.html"
                                          class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6">
                                          Pretty Little Thing </a> <span class="stext-105 cl3">
                                          $54.79 </span>
                                    </div>

                                    <div class="block2-txt-child2 flex-r p-t-3">
                                       <a href="#"
                                          class="btn-addwish-b2 dis-block pos-relative js-addwish-b2">
                                          <img class="icon-heart1 dis-block trans-04"
                                          src="images/icons/icon-heart-01.png" alt="ICON"> <img
                                          class="icon-heart2 dis-block trans-04 ab-t-l"
                                          src="images/icons/icon-heart-02.png" alt="ICON">
                                       </a>
                                    </div>
                                 </div>
                              </div>
                           </div>

                           <div
                              class="col-sm-6 col-md-4 col-lg-3 p-b-35 isotope-item watches">
                              <!-- Block2 -->
                              <div class="block2">
                                 <div class="block2-pic hov-img0">
                                    <img src="images/product-15.jpg" alt="IMG-PRODUCT"> <a
                                       href="#"
                                       class="block2-btn flex-c-m stext-103 cl2 size-102 bg0 bor2 hov-btn1 p-lr-15 trans-04 js-show-modal1">
                                       Quick View </a>
                                 </div>

                                 <div class="block2-txt flex-w flex-t p-t-14">
                                    <div class="block2-txt-child1 flex-col-l ">
                                       <a href="product-detail.html"
                                          class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6">
                                          Mini Silver Mesh Watch </a> <span class="stext-105 cl3">
                                          $86.85 </span>
                                    </div>

                                    <div class="block2-txt-child2 flex-r p-t-3">
                                       <a href="#"
                                          class="btn-addwish-b2 dis-block pos-relative js-addwish-b2">
                                          <img class="icon-heart1 dis-block trans-04"
                                          src="images/icons/icon-heart-01.png" alt="ICON"> <img
                                          class="icon-heart2 dis-block trans-04 ab-t-l"
                                          src="images/icons/icon-heart-02.png" alt="ICON">
                                       </a>
                                    </div>
                                 </div>
                              </div>
                           </div>

                           <div
                              class="col-sm-6 col-md-4 col-lg-3 p-b-35 isotope-item women">
                              <!-- Block2 -->
                              <div class="block2">
                                 <div class="block2-pic hov-img0">
                                    <img src="images/product-16.jpg" alt="IMG-PRODUCT"> <a
                                       href="#"
                                       class="block2-btn flex-c-m stext-103 cl2 size-102 bg0 bor2 hov-btn1 p-lr-15 trans-04 js-show-modal1">
                                       Quick View </a>
                                 </div>

                                 <div class="block2-txt flex-w flex-t p-t-14">
                                    <div class="block2-txt-child1 flex-col-l ">
                                       <a href="product-detail.html"
                                          class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6">
                                          Square Neck Back </a> <span class="stext-105 cl3">
                                          $29.64 </span>
                                    </div>

                                    <div class="block2-txt-child2 flex-r p-t-3">
                                       <a href="#"
                                          class="btn-addwish-b2 dis-block pos-relative js-addwish-b2">
                                          <img class="icon-heart1 dis-block trans-04"
                                          src="images/icons/icon-heart-01.png" alt="ICON"> <img
                                          class="icon-heart2 dis-block trans-04 ab-t-l"
                                          src="images/icons/icon-heart-02.png" alt="ICON">
                                       </a>
                                    </div>
                                 </div>
                              </div>
                           </div>
                        </div>
                        <!-- 테스트 끝 -->
                        ㄴ
                        <!-- core  -->
                        <script src="assets/vendors/jquery/jquery-3.4.1.js"></script>
                        <script src="assets/vendors/bootstrap/bootstrap.bundle.js"></script>

                        <!-- JoeBLog js -->
                        <script src="assets/js/joeblog.js"></script>
                        <!--===============================================================================================-->
                        <!--===============================================================================================-->
                        <script src="vendor/animsition/js/animsition.min.js"></script>
                        <!--===============================================================================================-->
                        <script src="vendor/bootstrap/js/popper.js"></script>
                        <!--===============================================================================================-->
                        <script src="vendor/select2/select2.min.js"></script>
                        <!--===============================================================================================-->
                        <script src="vendor/daterangepicker/moment.min.js"></script>
                        <script src="vendor/daterangepicker/daterangepicker.js"></script>
                        <!--===============================================================================================-->
                        <script src="vendor/slick/slick.min.js"></script>
                        <script src="js/slick-custom.js"></script>
                        <!--===============================================================================================-->
                        <script src="vendor/parallax100/parallax100.js"></script>
                        <script>
                           $('.parallax100').parallax100();
                        </script>
                        <!--===============================================================================================-->
                        <script src="vendor/MagnificPopup/jquery.magnific-popup.min.js"></script>
                        <!--===============================================================================================-->
                        <script src="vendor/isotope/isotope.pkgd.min.js"></script>
                        <!--===============================================================================================-->
                        <script src="vendor/sweetalert/sweetalert.min.js"></script>
                        <!—===============================================================================================—>
                        <!—===============================================================================================—>
                        <script src="js/main.js"></script>
                        

                        <%@ include file="./footer.jsp"%>
</body>
</html>