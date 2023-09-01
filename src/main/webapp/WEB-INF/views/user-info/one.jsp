<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 상세보기</title>
</head>
<body>
번호 : <span id="uiNum">${param.uiNum}</span><br>
이름 : <span id="uiName"></span><br>
아이디 : <span id="uiId"></span><br>
비밀번호 : <span id="uiPwd"></span><br>
생년월일 : <span id="uiBirth"></span><br>
소개 : <span id="uiDesc"></span><br>
가입일 : <span id="credat"></span><br>
<button onclick="goPage('/views/user-info/update?uiNum=${param.uiNum}')">수정</button>
<button onclick="deleteUser()">삭제</button>
<script>
	window.addEventListener('load',function(){
		const xhr = new XMLHttpRequest();
		xhr.open('GET','/user-info/one?uiNum=' + ${param.uiNum});
		xhr.onreadystatechange = function(){
			if(xhr.readyState===4){
				if(xhr.status===200){
					const obj = JSON.parse(xhr.responseText);
					for(const key in obj){
						if(document.querySelector('#' + key)){
							document.querySelector('#' + key).innerText = obj[key];
						}
					}
				}
			}
		}
		xhr.send();
	})
	function deleteUser(){
		const param = {
				uiNum : ${param.uiNum}
		}
		const json = JSON.stringify(param);
		const xhr = new XMLHttpRequest();
		xhr.open('POST','/user-info/delete');
		xhr.onreadystatechange = function(){
			if(xhr.readyState===4){
				if(xhr.status===200){
					if(xhr.responseText==='1'){
						alert('삭제 완료');
					}else{
						alert('이미 삭제된 내용입니다.');
					}
					location.href='/views/user-info/list';
				}else{
					alert('삭제시 오류가 발생했습니다.');
				}
			}
		}
		xhr.send(json);
	}
	function goPage(url){
		location.href = url;
	}
	
</script>
</body>
</html>