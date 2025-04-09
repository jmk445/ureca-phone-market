<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<title>로그인</title>
</head>
<body>
<!-- 	validation check 
		브라우저 내장 유효성 검사 X <= <form novalidate> 
		BootStrap이 제공하는 유효성 검사 O -->
		<!--  mb : margin bottom, mt : margin top -->
		<!-- justify-content-center : 가운데 정렬 -->
	<div class="container">
		<div class="mb-3 mt-5 d-flex justify-content-center"> 
			<h1 display="4">jmk445.log</h1>
		</div>
		<div class="mb-3">
			<h2>로그인</h2>
		</div>
		
		<form novalidate>
				
			<div class="mb-3">
				<label for= "userEmail" class = "form-label">email:</label>
				<input  type ="email" class="form-control" id="userEmail" name="userEmail" placeholder="confirm password" value = "jmk445@naver.com">				
			</div>	
			<div class="mb-3">
				<label for= "userPassword" class = "form-label">password:</label>
				<input  type ="password" class="form-control" id="userPassword" name="userPassword" placeholder="password" value="1234">				
			</div>

		</form>
		
		<div>
			<button type="button" id="btnLogin" class="btn btn-success">로그인</button>
			<button type="button" class="btn btn-success" onclick="location.href='/'">홈</button>
		</div>
		
	</div>    
    
    <script>
    	window.onload = function(){
    		//btnRegister 처리
    		document.querySelector("#btnLogin").onclick = function(){
    			//validation check
    			if(document.querySelector("#userEmail").value=='' || document.querySelector("#userEmail").value == '' ){
    				alert("입력이 올바르지 않습니다.");
    				return;
    			}    			
    			login();
    		}    	    		    		
    	}
    	    	
    	//회원 가입
    	async function login(){
    		
    		let userEmail = document.querySelector("#userEmail").value;
    		let userPassword = document.querySelector("#userPassword").value;
    		
    		
    		// x-www-form-urlencoded
    		let urlParams = new URLSearchParams({    			    			
    			userEmail : userEmail,
    			userPassword : userPassword,
    		})
    		
    		//fetch Options
    		let fetchOptions ={
    			method:"POST",
    			body: urlParams
    		}
    		
	    	let response = await fetch("/auth/login",fetchOptions);    		
    		let data = await response.json();
    		if(data.result == "success"){   
    			alert("로그인 성공했습니다.")
    			window.location.href="/"    			
    		}else{
    			alert("로그인 도중 문제가 생겼습니다.");
    		}
    		
    	}
    </script>
</body>
</html>