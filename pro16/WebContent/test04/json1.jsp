<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON TEST</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(function() {
		$("#checkJson").click(function() {
			var jsonStr = '{"name": ["홍길동","이순신","임꺽정"]}'; // 이름을 저장 하는 JSON 배열을 name으로 선언
			var jsonInfo = JSON.parse(jsonStr);   // 제이쿼리의 JSON 기능인 parse() 메서드를 이용행 JSON 자료형을 가져옵니다.
			var output = "회원 이름<br>";
			output += "======<br>";
			for ( var i in jsonInfo.name) {  	// 배열이름 name으로 배열 요소에 반복 변수를 이용해 차례로 접근하여 값을 가져옵니다
				output += jsonInfo.name[i] + "<br>";
			}
			$("#output").html(output);  // 회원 이름을 출력합니다.
		});
	});
</script>
</head>
<body>
	<a id="checkJson" style="cursor:pointer">출력</a><br><br>
	<div id="output"></div>
</body>
</html>