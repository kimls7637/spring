<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>글 작성 페이지</title>
<meta charset="utf-8" />
<meta name="viewport"
   content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
</head>
<body class="is-preload">

   <!-- Wrapper -->
   <div id="wrapper">

      <!-- Main -->
      <div id="main">
         <div class="inner">

            <!-- Header -->
            <header id="header">
               <c:if test="${member.mid != null}">
                  <a href="logout.do" class="logo"><strong>로그아웃</strong></a>
               </c:if>
               <c:if test="${member.mid == null}">
                  <a href="login.do" class="logo"><strong>로그인/회원가입</strong></a>
               </c:if>
               <ul class="icons">
                  <li><a href="main.do" class="icon brands fa-medium-m"><span
                        class="label"></span></a></li>
                  <c:if test="${member.mid != null}">
                     <li><a href="insert.do" class="icon solid fa-envelope"><span
                           class="label"></span></a></li>
                  </c:if>
               </ul>
            </header>

            <!-- Content -->
            <section>
               <header class="main">
                  <h1>글 작성 페이지</h1>
               </header>

               <span class="image main"><img src="images/pic.png"
                  alt="귀여운 티모 이미지" /></span>



               <form method="post" action="insert.do">
                  <div class="row gtr-uniform">
                     <div class="col-6 col-12-xsmall">
                        <input type="text" name="title" placeholder="제목" />
                     </div>
                     <div class="col-6 col-12-xsmall">
                        <input type="text" name="writer" value="${member.mid}" readonly />
                     </div>
                     <!-- Break -->
                     <div class="col-12">
                        <textarea name="content" placeholder="내용" rows="6"></textarea>
                     </div>


                        <div class="tr_hashTag_area">
                           <p>
                              <strong>해시태그 구현</strong>
                           </p>
                           <div class="form-group">
                              <input type="hidden" value="" name="tag" id="rdTag" />
                           </div>

                           <ul id="hashtagList"></ul>

                           <div class="form-group">
                              <input type="text" id="tag" size="7"
                                 placeholder="엔터로 해시태그를 등록해주세요." style="width: 300px;" />
                           </div>
                        </div>


                        <!-- Break -->
                        <div class="col-12">
                           <ul class="actions">
                              <li><input type="submit" value="글 등록하기" class="primary" /></li>
                           </ul>
                        </div>
                     </div>
               </form>

               <hr class="major" />

               <h2>Interdum sed dapibus</h2>
               <p>Donec eget ex magna. Interdum et malesuada fames ac ante
                  ipsum primis in faucibus. Pellentesque venenatis dolor imperdiet
                  dolor mattis sagittis. Praesent rutrum sem diam, vitae egestas
                  enim auctor sit amet. Pellentesque leo mauris, consectetur id
                  ipsum sit amet, fergiat. Pellentesque in mi eu massa lacinia
                  malesuada et a elit. Donec urna ex, lacinia in purus ac, pretium
                  pulvinar mauris. Curabitur sapien risus, commodo eget turpis at,
                  elementum convallis elit. Pellentesque enim turpis, hendrerit.</p>
               <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                  Duis dapibus rutrum facilisis. Class aptent taciti sociosqu ad
                  litora torquent per conubia nostra, per inceptos himenaeos. Etiam
                  tristique libero eu nibh porttitor fermentum. Nullam venenatis
                  erat id vehicula viverra. Nunc ultrices eros ut ultricies
                  condimentum. Mauris risus lacus, blandit sit amet venenatis non,
                  bibendum vitae dolor. Nunc lorem mauris, fringilla in aliquam at,
                  euismod in lectus. Pellentesque habitant morbi tristique senectus
                  et netus et malesuada fames ac turpis egestas. In non lorem sit
                  amet elit placerat maximus. Pellentesque aliquam maximus risus,
                  vel sed vehicula. Interdum et malesuada fames ac ante ipsum primis
                  in faucibus. Pellentesque venenatis dolor imperdiet dolor mattis
                  sagittis. Praesent rutrum sem diam, vitae egestas enim auctor sit
                  amet. Pellentesque leo mauris, consectetur id ipsum sit amet,
                  fersapien risus, commodo eget turpis at, elementum convallis elit.
                  Pellentesque enim turpis, hendrerit tristique lorem ipsum dolor.</p>

               <hr class="major" />

               <h2>Magna etiam veroeros</h2>
               <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                  Duis dapibus rutrum facilisis. Class aptent taciti sociosqu ad
                  litora torquent per conubia nostra, per inceptos himenaeos. Etiam
                  tristique libero eu nibh porttitor fermentum. Nullam venenatis
                  erat id vehicula viverra. Nunc ultrices eros ut ultricies
                  condimentum. Mauris risus lacus, blandit sit amet venenatis non,
                  bibendum vitae dolor. Nunc lorem mauris, fringilla in aliquam at,
                  euismod in lectus. Pellentesque habitant morbi tristique senectus
                  et netus et malesuada fames ac turpis egestas. In non lorem sit
                  amet elit placerat maximus. Pellentesque aliquam maximus risus,
                  vel sed vehicula.</p>
               <p>Interdum et malesuada fames ac ante ipsum primis in
                  faucibus. Pellentesque venenatis dolor imperdiet dolor mattis
                  sagittis. Praesent rutrum sem diam, vitae egestas enim auctor sit
                  amet. Pellentesque leo mauris, consectetur id ipsum sit amet,
                  fersapien risus, commodo eget turpis at, elementum convallis elit.
                  Pellentesque enim turpis, hendrerit tristique lorem ipsum dolor.</p>

               <hr class="major" />

               <h2>Lorem aliquam bibendum</h2>
               <p>Donec eget ex magna. Interdum et malesuada fames ac ante
                  ipsum primis in faucibus. Pellentesque venenatis dolor imperdiet
                  dolor mattis sagittis. Praesent rutrum sem diam, vitae egestas
                  enim auctor sit amet. Pellentesque leo mauris, consectetur id
                  ipsum sit amet, fergiat. Pellentesque in mi eu massa lacinia
                  malesuada et a elit. Donec urna ex, lacinia in purus ac, pretium
                  pulvinar mauris. Curabitur sapien risus, commodo eget turpis at,
                  elementum convallis elit. Pellentesque enim turpis, hendrerit.</p>
               <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                  Duis dapibus rutrum facilisis. Class aptent taciti sociosqu ad
                  litora torquent per conubia nostra, per inceptos himenaeos. Etiam
                  tristique libero eu nibh porttitor fermentum. Nullam venenatis
                  erat id vehicula viverra. Nunc ultrices eros ut ultricies
                  condimentum. Mauris risus lacus, blandit sit amet venenatis non,
                  bibendum vitae dolor. Nunc lorem mauris, fringilla in aliquam at,
                  euismod in lectus. Pellentesque habitant morbi tristique senectus
                  et netus et malesuada fames ac turpis egestas. In non lorem sit
                  amet elit placerat maximus. Pellentesque aliquam maximus risus,
                  vel sed vehicula.</p>

            </section>

         </div>
      </div>

      <!-- Sidebar -->
      <div id="sidebar">
         <div class="inner">

            <!-- Search -->
            <section id="search" class="alt">
               <form method="post" action="#">
                  <input type="text" name="query" id="query" placeholder="Search" />
               </form>
            </section>

            <!-- Menu -->
            <nav id="menu">
               <header class="major">
                  <h2>Menu</h2>
               </header>
               <ul>
                  <li><a href="index.html">Homepage</a></li>
                  <li><a href="generic.html">Generic</a></li>
                  <li><a href="elements.html">Elements</a></li>
                  <li><span class="opener">Submenu</span>
                     <ul>
                        <li><a href="#">Lorem Dolor</a></li>
                        <li><a href="#">Ipsum Adipiscing</a></li>
                        <li><a href="#">Tempus Magna</a></li>
                        <li><a href="#">Feugiat Veroeros</a></li>
                     </ul></li>
                  <li><a href="#">Etiam Dolore</a></li>
                  <li><a href="#">Adipiscing</a></li>
                  <li><span class="opener">Another Submenu</span>
                     <ul>
                        <li><a href="#">Lorem Dolor</a></li>
                        <li><a href="#">Ipsum Adipiscing</a></li>
                        <li><a href="#">Tempus Magna</a></li>
                        <li><a href="#">Feugiat Veroeros</a></li>
                     </ul></li>
                  <li><a href="#">Maximus Erat</a></li>
                  <li><a href="#">Sapien Mauris</a></li>
                  <li><a href="#">Amet Lacinia</a></li>
               </ul>
            </nav>

            <!-- Section -->
            <section>
               <header class="major">
                  <h2>Ante interdum</h2>
               </header>
               <div class="mini-posts">
                  <article>
                     <a href="#" class="image"><img src="images/pic07.jpg" alt="" /></a>
                     <p>Aenean ornare velit lacus, ac varius enim lorem
                        ullamcorper dolore aliquam.</p>
                  </article>
                  <article>
                     <a href="#" class="image"><img src="images/pic08.jpg" alt="" /></a>
                     <p>Aenean ornare velit lacus, ac varius enim lorem
                        ullamcorper dolore aliquam.</p>
                  </article>
                  <article>
                     <a href="#" class="image"><img src="images/pic09.jpg" alt="" /></a>
                     <p>Aenean ornare velit lacus, ac varius enim lorem
                        ullamcorper dolore aliquam.</p>
                  </article>
               </div>
               <ul class="actions">
                  <li><a href="#" class="button">More</a></li>
               </ul>
            </section>

            <!-- Section -->
            <section>
               <header class="major">
                  <h2>Get in touch</h2>
               </header>
               <p>Sed varius enim lorem ullamcorper dolore aliquam aenean
                  ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin
                  sed aliquam facilisis ante interdum. Sed nulla amet lorem feugiat
                  tempus aliquam.</p>
               <ul class="contact">
                  <li class="icon solid fa-envelope"><a href="#">information@untitled.tld</a></li>
                  <li class="icon solid fa-phone">(000) 000-0000</li>
                  <li class="icon solid fa-home">1234 Somewhere Road #8254<br />
                     Nashville, TN 00000-0000
                  </li>
               </ul>
            </section>

            <!-- Footer -->
            <footer id="footer">
               <p class="copyright">
                  &copy; Untitled. All rights reserved. Demo Images: <a
                     href="https://unsplash.com">Unsplash</a>. Design: <a
                     href="https://html5up.net">HTML5 UP</a>.
               </p>
            </footer>

         </div>
      </div>

   </div>

   <!-- Scripts -->
   <script src="assets/js/jquery.min.js"></script>
   <script src="assets/js/browser.min.js"></script>
   <script src="assets/js/breakpoints.min.js"></script>
   <script src="assets/js/util.js"></script>
   <script src="assets/js/main.js"></script>


   <script>
      $(document)
            .ready(
                  function() {
                     var tag = {};
                     var counter = 0;

                     // 입력한 값을 태그로 생성한다.
                     function addTag(value) {
                        tag[counter] = value;
                        counter++; // del-btn 의 고유 id 가 된다.
                     }

                     // tag 안에 있는 값을 array type 으로 만들어서 넘긴다.
                     function marginTag() {
                        return Object.values(tag).filter(
                              function(word) {
                                 return word !== "";
                              });
                     }

                     // 서버에 제공
                     $("#tag-form").on("submit", function(e) {
                        var value = marginTag(); // return array
                        $("#rdTag").val(value);

                        $(this).submit();
                     });

                     $("#tag")
                           .on(
                                 "keypress",
                                 function(e) {
                                    var self = $(this);

                                    //엔터나 스페이스바 눌렀을때 실행
                                    if (e.key === "Enter"
                                          || e.keyCode == 32) {

                                       var tagValue = self.val(); // 값 가져오기

                                       // 해시태그 값 없으면 실행X
                                       if (tagValue !== "") {

                                          // 같은 태그가 있는지 검사한다. 있다면 해당값이 array 로 return 된다.
                                          var result = Object
                                                .values(tag)
                                                .filter(
                                                      function(
                                                            word) {
                                                         return word === tagValue;
                                                      })

                                          // 해시태그가 중복되었는지 확인
                                          if (result.length == 0) {
                                             $("#hashtagList")
                                                   .append(
                                                         "<li class='tag-item'>"
                                                               + tagValue
                                                               + "<span class='del-btn' idx='"+counter+"'>x</span></li>");
                                             addTag(tagValue);
                                             self.val("");
                                          } else {
                                             alert("태그값이 중복됩니다.");
                                          }
                                       }
                                       e.preventDefault(); // SpaceBar 시 빈공간이 생기지 않도록 방지
                                    }
                                 });

                     // 삭제 버튼 
                     // 인덱스 검사 후 삭제
                     $(document).on("click", ".del-btn", function(e) {
                        var index = $(this).attr("idx");
                        tag[index] = "";
                        $(this).parent().remove();
                     });
                  })
   </script>


</body>
</html>