<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width" />
<title>API Demo - Kakao JavaScript SDK</title>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>

</head>
<body>
	<a id="kakao-login-btn"></a>
	<a href="http://developers.kakao.com/login"></a>
	<script type='text/javascript'>
		//<![CDATA[
		// 사용할 앱의 JavaScript 키를 설정해 주세요.
		Kakao.init('ae9f974b5119a84092f103b5834f90ea');
		// 카카오 로그인 버튼을 생성합니다.
		Kakao.Auth.createLoginButton({
			container : '#kakao-login-btn',
			success : function(authObj) {
				Kakao.Auth.login({
					scope : "PROFILE,TALK_MESSAGE",
					success : function(res) {
						Kakao.API.request({
							url : '/v1/api/talk/memo/send',
							data : {
								template_id : '6174',
							},
							success : function(res) {
								alert("succsess");
								console.log(res);
							},
							fail : function(error) {
								alert('error!');
								console.log(error);
							}
						})
					},
					fail : function(error) {
						console.log(error);
					}
				});
			},
			fail : function(err) {
				System.out.println("ff");
				alert("fail");
			}
		});

		
		//]]>
	</script>

</body>
</html>