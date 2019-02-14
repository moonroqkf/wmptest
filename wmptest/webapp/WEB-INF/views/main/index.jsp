<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script type="text/javascript" language="javascript">
    function printResult() {
    	
    	if(isEmpty($("#url").val())) {
    		alert("URL 값을 입력하셔야 합니다.");
    		$("#url").focus();
    		return;
    	}else if(isEmpty($("#printGroupSize").val())) {
    		alert("출력묶음 단위를 지정하셔야 합니다.");
    		$("#printGroupSize").focus();
    		return;
    	}else if($("#printGroupSize").val() <= 0 || $("#printGroupSize").val() > 100) {
    		alert("출력묶음 단위 1~100 정수만 가능합니다.");
    		$("#printGroupSize").focus();
    		return;
    	}
    	
    	$.ajax({
            type : "POST",
            url : "/wmptest/printOut",
            data : {
            	url : $("#url").val(),
            	type : $("#type").val(),
            	printGroupSize : $("#printGroupSize").val()
            },
            dataType : "json",
            error : function(){
                alert('통신실패!!');
            },
            success : function(data){
                $("#result").text(data.result);
                $("#remain").text(data.remainStr);
            }
            
        });
    }
    
    function isEmpty(str){
	    if(typeof str == "undefined" || str == null || str == "")
	        return true;
	    else
	        return false;
	}
</script>
</head>
<body>
       <table border="1" width="500">
               <tr>
                      <td>URL</td>
                      <td><input type="text" id="url" name="url" value="http://www.wemakeprice.com/"></td>
               </tr>
               <tr>
                      <td>TYPE</td>
                      <td>
                      	<select id="type" name="type">
                      		<option value="H">HTML제외</option>
                      		<option value="T">Text</option>
                      	</select>
                      </td>
               </tr>
               <tr>
               		<td>출력묶음단위</td>
               		<td><input type="text" id="printGroupSize" name="printGroupSize" value="10"></td>
               </tr>
               <tr>
                      <td colspan="2" align="right"><input type="button" VALUE=" 출력 " onclick="javascript:printResult();" ></td>
               </tr>
       </table>

	몫 : <div id="result"></div><br>
	나머지 : <div id="remain"></div>
</body>
</html>