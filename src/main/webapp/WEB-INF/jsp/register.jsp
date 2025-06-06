<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<title>회원 가입</title>
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
			<h2>회원 가입</h2>
		</div>
		
		<form novalidate>
			<div class="mb-3">
				<label for= "userName" class = "form-label">user name:</label>
				<input  type ="text" class="form-control" id="userName" name="userName" placeholder="Enter User Name">
				<div class="valid-feedback">valid</div>
				<div class="invalid-feedback">user name은 2글자 이상입니다.</div>
			</div>
			<div class="mb-3">
				<label for= "userPassword" class = "form-label">password:</label>
				<input  type ="password" class="form-control" id="userPassword" name="userPassword" placeholder="password">
				<div class="valid-feedback">valid</div>
				<div class="invalid-feedback">다시하세요</div>
			</div>
			<div class="mb-3">
				<label for= "userPassword2" class = "form-label">password confirm:</label>
				<input  type ="password" class="form-control" id="userPassword2" name="userPassword2" placeholder="confirm password">
				<div class="valid-feedback">valid</div>
				<div class="invalid-feedback">다시하세요</div>

			</div>
			<div class="mb-3">
				<label for= "userEmail" class = "form-label">email:</label>
				<input  type ="email" class="form-control" id="userEmail" name="userEmail" placeholder="confirm password">
				<div class="valid-feedback">valid</div>
				<div class="invalid-feedback">다시하세요</div>

			</div>
		</form>
		
		<div>
			<button type="button" id="btnRegister" class="btn btn-primary">회원 가입</button>
		</div>
	</div>    
    <button onclick="location.href='/'">홈</button>
    <script>
    	window.onload = function(){
    		//btnRegister 처리
    		document.querySelector("#btnRegister").onclick = function(){
    			//validation check
    			if(document.querySelectorAll("form .is-invalid").length > 0){
    				alert("입력이 올바르지 않습니다.");
    				return;
    			}
    			
    			register();
    		}
    		document.querySelector("#userName").onblur = function(){    			
    			if(validateUserName(this.value)){
    				this.classList.remove("is-invalid");
    				this.classList.add("is-valid");
    			}else{
    				this.classList.remove("is-valid");
    				this.classList.add("is-invalid");
    			}
    		}
    		document.querySelector("#userPassword").onblur = function(){    			
    			if(validateUserPassword(this.value)){
    				this.classList.remove("is-invalid");
    				this.classList.add("is-valid");
    			}else{
    				this.classList.remove("is-valid");
    				this.classList.add("is-invalid");
    			}
    		}
    		document.querySelector("#userPassword2").onblur = function(){    			
    			if(validateUserPassword2(this.value)){
    				this.classList.remove("is-invalid");
    				this.classList.add("is-valid");
    			}else{
    				this.classList.remove("is-valid");
    				this.classList.add("is-invalid");
    			}
    		}
    		document.querySelector("#userEmail").onblur = function(){    			
    			if(validateUserEmail(this.value)){
    				this.classList.remove("is-invalid");
    				this.classList.add("is-valid");
    			}else{
    				this.classList.remove("is-valid");
    				this.classList.add("is-invalid");
    			}
    		}
    		
    		
    	}
    	
    	function validateUserName(userName){
    		//2글자 이상
    		if(userName.length >=2) return true;
    		return false;
    		    		
    	}
    	
    	function validateUserPassword(userPassword){
    		// 알파벳 적어도 1개 이상
    		// 특수문자 적어도 1개 이상
    		// 숫자 적어도 1개 이상
   		 	let patternEngAtListOne = new RegExp(/[a-zA-Z]+/);// + for at least one
		    let patternSpeAtListOne = new RegExp(/[~!@#$%^&*()_+|<>?:{}]+/);// + for at least one
		    let patternNumAtListOne = new RegExp(/[0-9]+/);// + for at least one
    		
		    if(	patternEngAtListOne.test(userPassword) && 
		    	patternSpeAtListOne.test(userPassword) &&
		    	patternNumAtListOne.test(userPassword) //프로젝트 develope 중에는 굳이 하지 말기
	    	) return true;
		    return false;		    
    	}
    	
    	function validateUserPassword2(userPassword2){
    		//userPassword와 일치
    		if(userPassword2 == document.querySelector("#userPassword").value) return true;
    		return false;
    	}
    	function validateUserEmail(userEmail){
    		// @ .
    		let regexp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    		if(regexp.test(userEmail)) return true;
    		return false;
    	}
    	
    	//회원 가입
    	async function register(){
    		
    		let userName = document.querySelector("#userName").value;
    		let userPassword = document.querySelector("#userPassword").value;
    		let userEmail = document.querySelector("#userEmail").value;
    		
    		// x-www-form-urlencoded
    		let urlParams = new URLSearchParams({
    			userName : userName,
    			userPassword : userPassword,
    			userEmail : userEmail,
    		})
    		
    		//fetch Options
    		let fetchOptions ={
    			method:"POST",
    			body: urlParams
    		}
    		
	    	let response = await fetch("/user/register",fetchOptions);    		
    		let data = await response.json();
    		if(data.result == "success"){
    			alert("회원가입 성공");
    			window.location.href="/pages/login"
    			console.log(result);    			
    		}else{
    			alert("회원가입 도중 문제가 생겼습니다.");
    		}
    		
    	}
    </script>
</body>
</html>