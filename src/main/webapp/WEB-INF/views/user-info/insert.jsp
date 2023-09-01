<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 등록</title>
</head>
<body>
	<div class="container">
		이름 : <input type="text" id="uiName"><br>
		아이디 : <input type="text" id="uiId"><br>
		비밀번호 : <input type="password" id="uiPwd"><br>
		생년월일 : <input type="date" id="uiBirth"><br>
		자기소개 : <textarea id="uiDesc"></textarea><br>
		<button onclick="addUser()">등록</button>
	</div>
	<script>
		function addUser(){
			const param = {
					uiName : document.querySelector('#uiName').value,
					uiId : document.querySelector('#uiId').value,
					uiPwd : document.querySelector('#uiPwd').value,
					uiBirth : document.querySelector('#uiBirth').value,
					uiDesc : document.querySelector('#uiDesc').value
			}
			const json = JSON.stringify(param);
			const xhr = new XMLHttpRequest();
			xhr.open('POST', '/user-info/insert');
			xhr.onreadystatechange = function(){
				if(xhr.readyState===4){
					console.log(xhr.responseText);
					if(xhr.status===200){
						if(xhr.responseText==='1'){
							alert('등록 완료');
						}else{
							alert('등록 실패');
						}
						location.href='/views/user-info/list';
					}else{
						alert('등록시 오류가 발생했습니다.');
					}
				}
			}
			xhr.send(json);
		}
	</script>
</body>
</html>