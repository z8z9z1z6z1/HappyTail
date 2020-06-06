<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <script>
        window.onload=function(){  //載入視窗時就呼叫該方法
            var imgs=document.getElementsByTagName("img");
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
                    document.getElementById("lab").innerHTML=srcEl.getAttribute("score");
                    document.getElementById("lab2").value=srcEl.getAttribute("score");//通過srcEl呼叫getAttribute方法獲取分數
                }
            }
        }
    </script>
</head>
<body>
<body>
    <img src="img/star.gif">
    <img src="img/star.gif">
    <img src="img/star.gif">
    <img src="img/star.gif">
    <img src="img/star.gif">
    

    <form method='post' action='saveEvaluation' onSubmit="return CheckForm();">
    <input id='lab2' type="hidden" name='score' value=''>
    <label id="lab">0</label>分 <br>
   
    <input type="hidden" name='reservationId' value='${reservation.reservationId}'>
    <h1>評論</h1>
    <textarea cols="50" rows="5" name='content'>輸入你想要寫的內容...</textarea><br>
	
    <input type='submit'>
    </form>
 
<script >   
function CheckForm(){
	
  if(confirm("評分成功跳轉至首頁")==true)   
    return true;
  else  
    return false;
}   
</script>     
 
</body>
</body>
</html>