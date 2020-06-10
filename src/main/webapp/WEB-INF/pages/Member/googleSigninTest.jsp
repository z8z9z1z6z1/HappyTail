<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="google-signin-client_id" content="482598775927-m0fbnpe3dnrtf2sa5cic8tgasa7arn4q.apps.googleusercontent.com">
<script src="https://apis.google.com/js/platform.js" async defer></script>

<title>第三方登入測試</title>
</head>
<body>
<div class="g-signin2" data-onsuccess="onSignIn"></div>

<a href="#" onclick="signOut();">Sign out</a>

<script type="text/javascript">
gapi.load('auth2', function() {
	  auth2 = gapi.auth2.init({
});
	function onSignIn(googleUser) {
		location.href = "";
		
	}	
	  
	function signOut() {
    	var auth2 = gapi.auth2.getAuthInstance();
    	auth2.signOut().then(function () {
      	console.log('User signed out.');
    	});
	}
</script>
</body>
</html>