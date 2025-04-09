<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자</title>
</head>
<body>
    <h1>휴대폰 구매</h1>
    
    <table>
        <thead>
            <tr><th>phoneName</th><th>phonePrice</th><th>phoneMaker</th><th>phoneRemain</th></tr>
        </thead>
        <tbody id="phoneTbody">              
        </tbody>
    </table>
    <hr>    
    	   
	<h1>장바구니</h1>
	<table>
	    <thead>
	        <tr>
	            <th>휴대폰 이름</th>	            
	            <th>수량</th>
	            <th>총가격</th>
	        </tr>
	    </thead>
	    <tbody id="cartTbody">
	    </tbody>
	</table>
	
	<button id="buyButton">구매하기</button>
	<hr>
	<button onclick="location.href='/'">홈</button>
   

    
    <script>
        window.onload = function(){
            listPhone();
            loadCart();                                    
            document.querySelector("#buyButton").onclick = processPurchase;
        }   
       
        async function listPhone(){
            let url = '/phones/list';
            try{
                let response = await fetch(url);
                let data = await response.json();
                makeListHtml(data);
            }catch(error){
                console.log(error);
                alert('휴대폰 목록 처리 중 오류 발생!');
            }           
        }
        
        async function makeListHtml(list){
            let listHTML = ``;
            list.forEach(el => {
                listHTML +=
                    `<tr style="cursor:pointer" data-phoneId="\${el.phoneId}">
                        <td>\${el.phoneId}</td>
                        <td>\${el.phoneName}</td>
                        <td>\${el.phonePrice}</td>
                        <td>\${el.phoneMaker}</td>
                        <td>\${el.phoneRemain}</td>
                        <td><button type="button" onclick="addCart('\${el.phoneId}')">장바구니 담기</button></td>
                    </tr>`;
            });

            document.querySelector("#phoneTbody").innerHTML = listHTML;
        }   
        async function addCart(phoneId){
            let url = '/shopping/addCart/' + phoneId;
            try{
                let response = await fetch(url);
                let data = await response.json();       
                alert('장바구니 추가!');
                loadCart();
            }catch(error){
                console.error(error);
                alert('장바구니 추가 중 오류 발생!');
            }           
        }   
        
        async function loadCart() {
        	let url = '/shopping/getCart';
            try {
                let response = await fetch(url);
                let data = await response.json();
                makeCartHtml(data);
            } catch (error) {
                console.error(error);
                alert("장바구니 정보를 불러오는 중 오류가 발생했습니다.");
            }
        }

        function makeCartHtml(list) {
            let tbody = ``;
            list.forEach(phone => {
                tbody += `<tr data-phoneid="${phone.phoneId}">
                            <td>\${phone.phoneName}</td>                                                        
                            <td>\${phone.buyCnt}</td>
                            <td>\${phone.totalPrice}</td>
                          </tr>`;
            });
            document.querySelector("#cartTbody").innerHTML = tbody;
        }

        async function processPurchase() {
        	let url = '/shopping/purchase'
            try{
                let response = await fetch(url);
                let data = await response.json();       
                alert('구매완료, 3일 내로 배송 갑니다.');
                loadCart();
                listPhone();
            }catch(error){
                console.error(error);
                alert('장바구니 추가 중 오류 발생!');
            }       
        }

        

        
        
             
    </script>
</body>
</html>
