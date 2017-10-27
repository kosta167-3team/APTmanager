<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width" />
<title> All About Apart - 출입증 발급</title>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>

</head>
<body>
	<a id="kakao-login-btn"></a>
	<a href="http://developers.kakao.com/login"></a>
	<script type='text/javascript'>
	
	var message = ${reservation.v_contents};
		Kakao.init('ae9f974b5119a84092f103b5834f90ea'); // 개발자의 Javascript Key		
	
		Kakao.Auth.createLoginButton({ // create login button
			container : '#kakao-login-btn',
			
			success : function(authObj) {
				Kakao.Auth.login({ // 카카오톡 로그인
					scope : "PROFILE,TALK_MESSAGE",
					success : function(res) {
					 	 Kakao.API.request({	 // 카카오톡 						
							url : '/v1/api/talk/memo/send',
							data : {
								template_id : '6174',
								args: '{"\${msg}" : "'+message+'"}'
							},
					
							success : function(res) { // 보내기 성공
								Kakao.Auth.logout();
						        location.href="mainForm.jsp";
							},
							fail : function(error) { // 보내기 실패
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
			fail : function(err) { // 버튼 생성 실패 시
				alert("create button fail");
			}
		});
	</script>

</body>
</html>