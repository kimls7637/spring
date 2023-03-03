<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="sidebar">
   <div class="page-sidebar text-center"
      style="display: flex; justify-content: flex-end;">
      <div style="width: 75%;">
         <div class="profile">
            <c:if test="${member == null}">
               <div class="pn">
                  <spring:message code="message.sideInfo.login" />
               </div>
               <form action="login.do" method="POST">
                  <div class="input-box">
                     <input id="username" type="text" name="id"
                        placeholder="<spring:message code="message.sideInfo.id"/>">
                  </div>
                  <div class="input-box">
                     <input id="password" type="password" name="pw"
                        placeholder="<spring:message code="message.sideInfo.pw"/>">
                  </div>
                  <div id="forgot">
                     <a href="searchId.jsp" style="color: black;"> <spring:message
                           code="message.sideInfo.id" />
                     </a>/<a href="searchPw.jsp" style="color: black;"> <spring:message
                           code="message.sideInfo.pw" />
                     </a>
                     <spring:message code="message.sideInfo.find" />
                  </div>
                  <div class="login">
                     <input type="submit"
                        value="<spring:message code="message.sideInfo.loginBtn"/>">
                  </div>
                  <div id="forgot">
                     <spring:message code="message.sideInfo.joinment" />
                     <br> <a href="join.jsp"
                        style="color: black; font-weight: bold"> <spring:message
                           code="message.sideInfo.join" />
                     </a>
                  </div>
               </form>
            </c:if>
            <!-- 로그인 후 분기처리할것 -->

            <c:if test="${member != null}">
               <div class="pn">${member.mNickname}</div>
               <div class="nick" style="display: flex; align-items: center;">
                  <!-- level1 씨앗 : heartCnt 0~15개 -->
                  <!-- level2 새싹 : heartCnt 16~30개 -->
                  <!-- level3 가지 : heartCnt 31~50개 -->
                  <!-- level4 열매 : heartCnt 51~70개 -->
                  <!-- level5 관리자 : -->
                  <div style="width: 25%; margin: 0 20px 0 30px;">
                     <c:if test="${member.mNickname == 'admin'}">
                        <img src="./assets/imgs/level5.png">
                     </c:if>
                     <c:if test="${member.mNickname != 'admin'}">
                        <img src="./assets/imgs/${grade}.png">
                     </c:if>
                  </div>
               </div>
               <c:if test="${member.mNickname != 'admin'}">
                  <div id="forgot">
                     <a href="forgot.jsp" style="color: black;"> 마이페이지 </a>
                  </div>
                  <form action="chat.do" method="post">
                     <input type="hidden" name="mNickname" value="${member.mNickname}">
                     <input type="submit" value="채팅" onclick="openChat()" />
                  </form>

               </c:if>
               <c:if test="${member.mNickname == 'admin'}">
                  <div id="forgot">
                     <a href="forgot.jsp" style="color: black;"> 관리자페이지 </a>
                  </div>
               </c:if>
               <div class="login">
                  <a href=" "><button>로그아웃하기</button></a>
               </div>
            </c:if>

         </div>

         <div class="profile">
            <div class="like">
               <spring:message code="message.sideInfo.memRanking" />
            </div>
            <hr>
            <div class="sidelike">
               <ul style="margin-bottom: 0px;">
                  <c:forEach var="v" items="${datas}">
                     <li>${v.mNickname}|${v.heartCnt}</li>
                  </c:forEach>
               </ul>
            </div>
         </div>
         <%--          <a href="chat.do?mNickname=${member.mNickname}">채팅</a>
 --%>
         <script>
         function openChat() {
                  var mNickname = document.getElementsByName('mNickname')[0].value;
                  var url = "chat.jsp?mNickname=" + mNickname;
                  window.open(url, "chat", "width=700, height=800, top=200, left=900");
              }
         </script>




      </div>
   </div>
</div>