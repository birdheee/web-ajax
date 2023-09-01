<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 목록</title>
<style>
tr.link{
	background-color:white;
	color:black;
	cursor:pointer;
}
tr.link:hover{
	color:blue;
}
</style>
</head>
<body>
	<button onclick="location.href='/views/user-info/insert'">등록</button>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>아이디</th>
			<th>생년월일</th>
		</tr>
		<tbody id="tBody">
		</tbody>
	</table>
	<script>
		function goPage(num){
			location.href = '/views/user-info/one?uiNum=' + num;
		}
		function getList(){
			const xhr = new XMLHttpRequest();
			xhr.open('GET','/user-info/list');
			xhr.onreadystatechange = function(){
				if(xhr.readyState===4){
					if(xhr.status===200){
						const list = JSON.parse(xhr.responseText);
						let html = '';
						for(const user of list){
							html += '<tr class="link" onclick="goPage(' + user.uiNum + ')">';
							html += '<td>' + user.uiNum + '</td>';
							html += '<td>' + user.uiName + '</td>';
							html += '<td>' + user.uiId + '</td>';
							html += '<td>' + user.uiBirth + '</td>';
							html += '</tr>';
						}
						document.querySelector('#tBody').innerHTML = html;
						console.log(html); 
					}
				}
			}
			xhr.send();
		}
		window.addEventListener('load',getList);
	</script>
</body>
</html>