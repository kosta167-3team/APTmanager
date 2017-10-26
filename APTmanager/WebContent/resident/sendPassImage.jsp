<!DOCTYPE html>
<%@page import="resident.model.Reservation"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width" />
<title> All About Apart - ì¶ìì¦ ë°ê¸</title>
<%
	request.setCharacterEncoding("utf-8");
	Reservation reservation = (Reservation)session.getAttribute("reservation");
	request.setAttribute("reservation", reservation);
	System.out.println(reservation.getV_contents());
%>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>

</head>
<body>
	<a id="kakao-login-btn"></a>
	<a href="http://developers.kakao.com/login"></a>
	<script type='text/javascript' charset="utf-8">
	 var address = "${address}";
		Kakao.init('ae9f974b5119a84092f103b5834f90ea'); // ê°ë°ìì Javascript Key		
	
		Kakao.Auth.createLoginButton({ // create login button
			container : '#kakao-login-btn',
			
			success : function(authObj) {
				Kakao.Auth.login({ // ì¹´ì¹´ì¤í¡ ë¡ê·¸ì¸
					scope : "PROFILE,TALK_MESSAGE",
					success : function(res) {
					 	 Kakao.API.request({	 // ì¹´ì¹´ì¤í¡ 						
							url : '/v1/api/talk/memo/send',
							data : {
								template_id : '6174',
								args: '{"\${address}" : "'+ address+'"}',
							},
					
							success : function(res) { // ë³´ë´ê¸° ì±ê³µ
								Kakao.Auth.logout();
						        location.href="mainForm.jsp";
							},
							fail : function(error) { // ë³´ë´ê¸° ì¤í¨
								Kakao.Auth.logout();
								alert(JSON.stringify(error));
							}
						})						
					},
					fail : function(error) {
						alert('login error');
						
					}
				});
			},
			fail : function(err) { // ë²í¼ ìì± ì¤í¨ ì
				alert("create button fail");
			}
		});
	</script>

</body>
</html>