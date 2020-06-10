<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/WEB-INF/pages/include/coreLibrary.jsp" %>
 <script>
        window.onload=function(){  //載入視窗時就呼叫該方法
            var imgs=document.querySelectorAll(".img37");
            for(var i=0;i<imgs.length;i++){
                imgs[i].setAttribute("score",i+1);//設定分數
                imgs[i].onclick=function(){   //點選時呼叫方法


                    var srcEl=event.srcElement;//通過event來獲取原元素


                    var score=srcEl.getAttribute("score");//獲取分數
                    for(var j=0;j<score;j++){
                        imgs[j].src="img/StarCopy.gif";
                    }
                    for(var j=score;j<imgs.length;j++){
                        imgs[j].src="img/star.gif";
                    }
                    document.getElementById("lab2").value=srcEl.getAttribute("score");//通過srcEl呼叫getAttribute方法獲取分數
                }
            }
        }
    </script>
</head>
<body>

 <%@include file="/HappytailHeader.jsp" %>
 	
 	<img src='img/03.jpg' width="350" style='float: left;margin-left: 50px'>
 
 
 	<br>
	<div>
	<h1 style='margin-left: 688px'>評論</h1>
    <img class='img37' src="img/star.gif">
    <img class='img37' src="img/star.gif">
    <img class='img37' src="img/star.gif">
    <img class='img37' src="img/star.gif">
    <img class='img37' src="img/star.gif">
    </div>
	
	<div style='margin-left: 515px;float: left;'>
    <form method='post' action='saveEvaluation' onsubmit="return check()">
    <input id='lab2' type="hidden" name='score' id='score' value='' >
    <span id="str2" style='color: red'></span>
   
    <input type="hidden" name='reservationId' value='${reservation.reservationId}'>
    <textarea cols="50" rows="5" name='content' id='content' onblur="checkname()" onkeyup="checkname(this)">輸入你想要寫的內容不可大於50字</textarea><br>
	<span id="str1" style='color: red'></span>
    <input class="btn btn-success" type='submit' style='margin-left: 180px'>
    </form>
 	</div>
 	<br>
 	
 	<img src='img/01.jpg' width="350" style='margin-left: 150px'>
 	
 <%@include file="/HappytailFooter.jsp" %>
 
 <script>
 
 function checkname() {
 let i = document.getElementById("content").value.length;
 let p = document.getElementById("content").value;
 var check = false;
 if (i==0){
	 document.getElementById("str1").innerHTML = "不可空白";
	 check = false;
 } else if (i > 50){
	 document.getElementById("str1").innerHTML = "超過50字";
	 check = false;
 } else if (i <= 50){
	 document.getElementById("str1").innerHTML = "";
	 check = true;
 } return check;

 }
 
 
 function check(){
     var check = checkname() ;

     if (check != true){
         alert("輸入錯誤");
     }else {
         alert("評分成功");
         
     }

     return check;
 }
 
 
 </script>
 
    
 
</body>
</body>
</html>