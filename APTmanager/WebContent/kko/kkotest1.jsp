<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width"/>
<title>API Demo - Kakao JavaScript SDK</title>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>

</head>
<body>
<p>나에게 보내기 Demo</p>
<a id="send-to-btn" href="#" onclick="sendTo();">
<img src="//k.kakaocdn.net/14/dn/btqc6xrxbuT/7VJk7YSWITkz9K9pbXEffk/o.jpg"/>
</a>
<a id="kakao-link-btn" href="javascript:sendLink()">
<img src="//dev.kakao.com/assets/img/about/logos/kakaolink/kakaolink_btn_medium.png"/>
</a>
<script type='text/javascript'>
  //<![CDATA[
    // 사용할 앱의 JavaScript 키를 설정해 주세요.
    Kakao.init('f715569bf60d491d07849ba023922d2f');
    // 카카오 로그인 버튼을 생성합니다.
    function sendTo(){
        Kakao.Auth.login({
            //// 메모챗을 발송하기 위해서는 로그인할때 추가적인 scope 을 얻어야 한다.
            scope: "PROFILE,TALK_MESSAGE",
            success: function(res) {
                Kakao.API.request({
                    url: '/v1/api/talk/memo/send',
                    data: {
                        template_id: '6171',
                        args: '{"${USER_NAME}": "developer","${AGE}": 20}'
                    },
                    success: function sendLink() {
                        Kakao.Link.sendTalkLink({
                            label: '테스트용 메세지입니다.'
                          });
                        },
                    fail: function(error) {
                        alert('error! \n' + JSON.stringify(error));
                        console.log(error);
                    }
                })
            },
            fail: function(error) {
                console.log(error);
            }
        });
    }
  //]]>
</script>

</body>
</html>