package com.code.help.others;

import com.alibaba.fastjson.JSON;
import com.code.help.spider.util.IOUtils;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Test {
    @org.junit.Test
    public void test() throws IOException {
        String s = "JDBID=72559C25-D4E6-40B4-A853-8941E39F7FC5&RNVersion=2&accessToken=ACCESS_TOKEN8674463648107274271543241868710&appKey=fb371c48e9a9b2a1174ed729ae888513&channel=appstore&clientVersion=3.0.2.0&containerTag=3&deviceID=84B05269-B93F-41D2-8D00-0173CA1E9D47&deviceType=iPhone%206S&fp=RsTkeLZ2uVk0XbIUmmAdxzvpK7xVfXOx6O7YR7Sf9ZpjKvxNmyiKdnQVLh4WLCI24kKiqt_Yeto236VqVjB2lfHvYMXVGLRf5Ii7kLh9Vad-CtX8gp1JXT_ZUP4p0dJdHs2KqpFzyjyj6J0PQZBolcqLFypDfFbA&friendID=586106121159555226&fullRouter=jdbclient%3A//user/guest/index?memberID%3D586106121159555226%26hideNavigation%3D1%26thumbnailUrl%3D%26searchType%3D0%26isShownFullPhoneNumber%3Dtrue%26avatarUrl%3D%26fromSearchToken%3D55aa130d538bf9f898aa8d1a56adbf9ec2d3d1c42a572a5c1753fecb64d4de01e505dd27433452658e4a27401318aa2beae875fdae9f36e749d174436032f82abefa30d96858de3cd65e800ad832c3744fdac7393f6fec50%26fromScene%3D3%26userType%3D0%26name%3D%2A%E4%BF%8A%26sourceType%3D3&h=1334&isForeground=1&isRelease=1&jailbreak=0&loadType=1&memberID=867446364810727427&network=5&packageName=6CFC76EBF375F494E5A83AF889BFE72F&phoneVen=3&platform=iOS&proxyType=https&referer=jdbclient%3A//tab/contactInstance/index&requestTimeout=0&sessionMode=1&showName=0&showPhone=1&sysLaunchTimeInterval=82241&systemVersion=12.1&traceID=8E7B7E1FE6224357BDCCA3F26536BE6C&udid=449de86377ab5be21acd0f04fa77a04ae03fce6d&w=750";

        s = "JDBID=000000006786d1f8ffffffffe32195ad&accessToken=ACCESS_TOKEN9394890268621824061544673238901&apkSign=6F01335F52FCA82276CC99E2F9E65865&appKey=fb371c48e9a9b2a1174ed729ae888513&blackBox2=55058735A264EC3372C637C648E4C612&channel=unknown&clientVersion=3.0.6.0&deviceID=866899022633679&deviceType=MI4LTE&enterTime=1544673384834&env=prod&fp=j48nheygX0VbvASrjKJxAdBVAtcqRY82fk1CdyulGaDBraW6UG419wmcwf9nVzOnlybSrR3jMS97nq_Pcz1IctXdD7EKdwPZq_z3-8rYWZh2_0K8TeLs-9BFG36T82ScspaNpdewFQ4xW7P_oOmFFZgRn84whKpt&fullRouter=jdbclient%3A%2F%2Fuser%2FcertificateAuthority&h=1920&isForeground=1&isHasCheatSoft=0&isRelease=1&jdbId=939489026862182406&manufacturer=Xiaomi&memberID=939489026862182406&network=5&phoneVen=2&platform=android&proxyType=http&sessionMode=1&sysLaunchTimeInterval=72163&systemVersion=6.0.1&title=%E8%AE%A4%E8%AF%81%E4%B8%AD%E5%BF%83&traceID=3b3ac18e56fd4e0dbbbf7bb98871bcce&udid=000000006786d1f8ffffffffe32195ad&version=3.0.6.0&w=1080";
        //s  ="traceID=c91fd039b86945a98157693e8afeba6f&JDBID=000000006786d1f8ffffffffe32195ad&proxyType=https&appKey=fb371c48e9a9b2a1174ed729ae888513&keyword=18100178365&udid=000000006786d1f8ffffffffe32195ad&accessToken=ACCESS_TOKEN9384855754830848011544498772192&deviceID=866899022633679&memberID=938485575483084801";
        s = "memberID=939591081664655369&logVersion=1.1.0&categories=&isForeground=1&sessionMode=1&accessToken=ACCESS_TOKEN9395910816646553691544697570707&JDBID=00000000672c7c7fffffffff9307c44d&deviceID=357246052322045&network=5&deviceType=LG-D802&memberID=939591081664655369&clientVersion=2.9.9.1&apkSign=6F01335F52FCA82276CC99E2F9E65865&blackBox2=3150BE5C795D524F9612FCA1E8102036&fp=bqvGNneQGpKKW-oE3oNYfYs5vnrHcy1qk_AA6elhJ1P2z4nzFFXj3yTUNdGp5QD6B-aOtjIeXHptbp9Tmwcc3w1O74ilyr81fRcb9hDJCeC9XtkrKiF0IrezEaI9GdqbT3M5vLThPF8W2wJ2mSjGI3xyo-hzBxJB&platform=android&isHasCheatSoft=0&udid=00000000672c7c7fffffffff9307c44d&h=1776&w=1080&traceID=83b6c0554f2b49758bff470594d1d4bb&sysLaunchTimeInterval=984&isRelease=1&systemVersion=4.2.2&manufacturer=LGE&proxyType=http&phoneVen=1&channel=3007a&appKey=fb371c48e9a9b2a1174ed729ae888513";
        s ="traceID=c91fd039b86945a98157693e8afeba6f&JDBID=000000006786d1f8ffffffffe32195ad&proxyType=https&appKey=fb371c48e9a9b2a1174ed729ae888513&keyword=18100178365&udid=000000006786d1f8ffffffffe32195ad&accessToken=ACCESS_TOKEN9394890268621824061544673238901&deviceID=866899022633679&memberID=939489026862182406";
        s = "appKey=fb371c48e9a9b2a1174ed729ae888513&isRelease=1&isForeground=1&rachel=2c0f2bd457f48f7d86b1b36118c781bb&phoneVen=2&JDBID=ffffffff8b381ef6d36e90c014709159&traceID=e0c72c4e53e14bb5a833eb648602f27f&clientVersion=3.0.6.0&fp=awYyhMxowrWHIPw5Ox0OkOWUGFokk5eOc4peQ_0yoYIxkEhtamLm6ImwlMMo5QUvlh6RVmVOx21ukpE5UK0Bc2JouRYimASwxMUFZiwkssoNXBDdKK8vEOgCbExwzWUPfH8F_1DPO5roy4DEWLDKZGj3fhCSc9m-&udid=ffffffff8b381ef6d36e90c014709159&manufacturer=Xiaomi&proxyType=none&channel=unknown&isHasCheatSoft=0&blackBox2=6C9CF2C1418498A0A19E35BCF85F4DB3&deviceType=MI4LTE&accessToken=ACCESS_TOKEN9384855754830848011544709423472&memberID=938485575483084801&h=1920&w=1080&monica=1544709736&platform=android&network=5&systemVersion=6.0.1&deviceID=99000643324363&apkSign=6F01335F52FCA82276CC99E2F9E65865&sysLaunchTimeInterval=958476&sessionMode=1";
        s = "raceID=1a61e6e6e00048ac9bdc74fadb1a5487&bizType=3&channel=appstore&fp=&clientVersion=3.0.2.0&systemVersion=12.0.1&platform=iOS&network=4&manufacturer=Xiaomi&isRelease=1&JDBID=219f4bd67db74384af3539e0e56bab6a&appKey=fb371c48e9a9b2a1174ed729ae888513&udid=219f4bd67db74384af3539e0e56bab6a&deviceType=iPhone%206S&sysLaunchTimeInterval=686196&phoneVen=3&jdbId=933776117054009344&h=1334&proxyType=none&deviceID=D397CC2D-4D6C-4D68-B355-8F4D02741CFB&w=750&sessionMode=1&isForeground=1&memberID=933776117054009344&keyword=18958078635";


        for (String ss : s.split("&")) {
            if (ss.contains("=")) {
                String[] sss = ss.split("=");
                if (sss.length == 1) {
                    System.out.println(sss[0] + "=" + "");
                } else {
                    System.out.println(sss[0] + "=" + sss[1]);
                }
            } else {
                System.out.println(ss);
            }
        }
    }
    @org.junit.Test
    public void test2() throws IOException {
        String filepath = "/Users/chancelee/Desktop/DEFAULT/aa.txt";
        Map<String, String> maps = new HashMap<>();
        BufferedReader stream = new BufferedReader(new InputStreamReader(new FileInputStream(filepath)));
        StringBuffer result = new StringBuffer();

        String l= null;
        while ((l = stream.readLine())!=null) {
            if("".equals(l)){
                continue;
            }
            String[] ars = l.split("=");
            if(ars.length==1){
                maps.put(ars[0], "");
            }else{
                maps.put(ars[0], ars[1]);
            }
        }
        stream.close();

        for(Map.Entry<String, String> en:maps.entrySet()){
            result.append(en.getKey()+"="+en.getValue()+"&");
        }
        result.deleteCharAt(result.length()-1);
        System.out.println(result.toString());
    }

        public void testt(){

//       String ss  = IOUtils.toJsonByFile("/Users/chancelee/Desktop/以前的文件/借条/debit_json/ypz.json", "UTF-8");
        String ss  ="{\n" +
                "\t    \"appType\":\"jdb\",\n" +
                "\t    \"data\":{\n" +
                "\t        \"authList\":[\n" +
                "\t            {\n" +
                "\t                \"authName\":\"实名认证\",\n" +
                "\t                \"authStatus\":0,\n" +
                "\t                \"authType\":1\n" +
                "\t            },\n" +
                "\t            {\n" +
                "\t                \"authName\":\"肖像认证\",\n" +
                "\t                \"authStatus\":0,\n" +
                "\t                \"authType\":2\n" +
                "\t            },\n" +
                "\t            {\n" +
                "\t                \"authName\":\"银行卡认证\",\n" +
                "\t                \"authStatus\":0,\n" +
                "\t                \"authType\":3\n" +
                "\t            },\n" +
                "\t            {\n" +
                "\t                \"authName\":\"信用认证\",\n" +
                "\t                \"authStatus\":1,\n" +
                "\t                \"authType\":35\n" +
                "\t            },\n" +
                "\t            {\n" +
                "\t                \"authName\":\"上传通讯录\",\n" +
                "\t                \"authStatus\":0,\n" +
                "\t                \"authType\":9\n" +
                "\t            },\n" +
                "\t            {\n" +
                "\t                \"authName\":\"获取位置\",\n" +
                "\t                \"authStatus\":1,\n" +
                "\t                \"authType\":10\n" +
                "\t            },\n" +
                "\t            {\n" +
                "\t                \"authName\":\"绑定备用号\",\n" +
                "\t                \"authStatus\":1,\n" +
                "\t                \"authType\":11\n" +
                "\t            },\n" +
                "\t            {\n" +
                "\t                \"authName\":\"亲密联系人\",\n" +
                "\t                \"authStatus\":1,\n" +
                "\t                \"authType\":12\n" +
                "\t            },\n" +
                "\t            {\n" +
                "\t                \"authName\":\"上传身份证\",\n" +
                "\t                \"authStatus\":1,\n" +
                "\t                \"authType\":13\n" +
                "\t            },\n" +
                "\t            {\n" +
                "\t                \"authName\":\"运营商报告\",\n" +
                "\t                \"authStatus\":1,\n" +
                "\t                \"authType\":18\n" +
                "\t            },\n" +
                "\t            {\n" +
                "\t                \"authName\":\"京东认证\",\n" +
                "\t                \"authStatus\":1,\n" +
                "\t                \"authType\":19\n" +
                "\t            },\n" +
                "\t            {\n" +
                "\t                \"authName\":\"在读认证\",\n" +
                "\t                \"authStatus\":1,\n" +
                "\t                \"authType\":54\n" +
                "\t            },\n" +
                "\t            {\n" +
                "\t                \"authName\":\"公积金认证\",\n" +
                "\t                \"authStatus\":1,\n" +
                "\t                \"authType\":27\n" +
                "\t            },\n" +
                "\t            {\n" +
                "\t                \"authName\":\"银联交易认证\",\n" +
                "\t                \"authStatus\":1,\n" +
                "\t                \"authType\":59\n" +
                "\t            }\n" +
                "\t        ],\n" +
                "\t        \"baseInfo\":{\n" +
                "\t            \"bindStatus\":1,\n" +
                "\t            \"faceStatus\":1,\n" +
                "\t            \"gender\":1,\n" +
                "\t            \"headImg\":\"https://www.gxb.io/images/GXS-logo.png\",\n" +
                "\t            \"identNum\":5,\n" +
                "\t            \"level\":\"见习生\",\n" +
                "\t            \"name\":\"公信宝\",\n" +
                "\t            \"overdueTips\":\"最近两年内，该用户无逾期超过7天的应还款\",\n" +
                "\t            \"phone\":\"12312344321\",\n" +
                "\t            \"realNameStatus\":1,\n" +
                "\t            \"registerTime\":\"2018-05-28 00:00:00\"\n" +
                "\t        },\n" +
                "\t        \"contactList\":[\n" +
                "\t            {\n" +
                "\t                \"contactType\":3,\n" +
                "\t                \"jdbId\":\"123321199001111234\",\n" +
                "\t                \"name\":\"张三\",\n" +
                "\t                \"phone\":\"15512344321\",\n" +
                "\t                \"remarkName\":\"\",\n" +
                "\t                \"sourceType\":4\n" +
                "\t            },\n" +
                "\t            {\n" +
                "\t                \"contactType\":3,\n" +
                "\t                \"jdbId\":\"321123199007011234\",\n" +
                "\t                \"name\":\"李四\",\n" +
                "\t                \"phone\":\"16812344321\",\n" +
                "\t                \"remarkName\":\"\",\n" +
                "\t                \"sourceType\":2\n" +
                "\t            }\n" +
                "\t        ],\n" +
                "\t        \"iouList\":[\n" +
                "\t            {\n" +
                "\t                \"appType\":\"jdb\",\n" +
                "\t                \"baseAmt\":100,\n" +
                "\t                \"borrowerName\":\"张三\",\n" +
                "\t                \"borrowerTime\":\"2018-11-30 00:00:00\",\n" +
                "\t                \"interestAmt\":0.09,\n" +
                "\t                \"interestRate\":12,\n" +
                "\t                \"iouStatus\":0,\n" +
                "\t                \"iouType\":1,\n" +
                "\t                \"iouWayType\":1,\n" +
                "\t                \"landerName\":\"公信宝\",\n" +
                "\t                \"purpose\":\"买卖\",\n" +
                "\t                \"repayTime\":\"2018-12-03 23:59:59\",\n" +
                "\t                \"repayType\":0\n" +
                "\t            },\n" +
                "\t            {\n" +
                "\t                \"appType\":\"jdb\",\n" +
                "\t                \"baseAmt\":100,\n" +
                "\t                \"borrowerName\":\"李四\",\n" +
                "\t                \"borrowerTime\":\"2018-11-27 00:00:00\",\n" +
                "\t                \"interestAmt\":0.19,\n" +
                "\t                \"interestRate\":24,\n" +
                "\t                \"iouStatus\":3,\n" +
                "\t                \"iouType\":1,\n" +
                "\t                \"iouWayType\":1,\n" +
                "\t                \"landerName\":\"公信宝\",\n" +
                "\t                \"purpose\":\"赊账\",\n" +
                "\t                \"repayTime\":\"2018-12-28 23:59:59\",\n" +
                "\t                \"repayType\":0\n" +
                "\t            }\n" +
                "\t        ],\n" +
                "\t        \"jdbCreditInfo\":{\n" +
                "\t            \"alreadyDoneBorrowAmount\":0,\n" +
                "\t            \"alreadyDoneLendAmount\":100,\n" +
                "\t            \"alreadyDoneSuretyAmount\":0,\n" +
                "\t            \"alreadyDoneZhuanlichaAmount\":0,\n" +
                "\t            \"currentBorrowAmount\":0,\n" +
                "\t            \"currentBorrowTop5Percent\":0,\n" +
                "\t            \"currentLendAmount\":200,\n" +
                "\t            \"currentLendTop5Percent\":0,\n" +
                "\t            \"currentSuretyAmount\":0,\n" +
                "\t            \"currentSuretyTop5Percent\":0,\n" +
                "\t            \"currentZhuanlichaAmount\":0,\n" +
                "\t            \"currentZhuanlichaTop5Percent\":0,\n" +
                "\t            \"historicalBorrowAmount\":0,\n" +
                "\t            \"historicalBorrowCount\":0,\n" +
                "\t            \"historicalBorrowFriendCount\":0,\n" +
                "\t            \"historicalLendAmount\":300,\n" +
                "\t            \"historicalLendCount\":3,\n" +
                "\t            \"historicalLendFriendCount\":1,\n" +
                "\t            \"historicalSuretyAmount\":0,\n" +
                "\t            \"historicalSuretyCount\":0,\n" +
                "\t            \"historicalSuretyFriendCount\":0,\n" +
                "\t            \"historicalZhuanlichaAmount\":0,\n" +
                "\t            \"historicalZhuanlichaCount\":0,\n" +
                "\t            \"historicalZhuanlichaFriendCount\":0\n" +
                "\t        }\n" +
                "\t    }\n" +
                "\t}";

        Object o = JSON.parse(ss);

        System.out.println(JSON.toJSONString(o));


    }
    public void tet(){
        String s = "{\"data\":{\"baseInfo\":{\"faceStatus\":1,\"gender\":1,\"headImg\":\"https://www.gxb.io/images/GXS-logo.png\",\"level\":\"见习生\",\"phone\":\"12312344321\",\"registerTime\":\"2018-05-28 00:00:00\",\"name\":\"公信宝\",\"realNameStatus\":1,\"bindStatus\":1,\"identNum\":5,\"overdueTips\":\"最近两年内，该用户无逾期超过7天的应还款\"},\"iouList\":[{\"interestRate\":12,\"interestAmt\":0.09,\"repayTime\":\"2018-12-03 23:59:59\",\"purpose\":\"买卖\",\"borrowerTime\":\"2018-11-30 00:00:00\",\"borrowerName\":\"张三\",\"repayType\":0,\"iouWayType\":1,\"appType\":\"jdb\",\"iouType\":1,\"baseAmt\":100,\"landerName\":\"公信宝\",\"iouStatus\":0},{\"interestRate\":24,\"interestAmt\":0.19,\"repayTime\":\"2018-12-28 23:59:59\",\"purpose\":\"赊账\",\"borrowerTime\":\"2018-11-27 00:00:00\",\"borrowerName\":\"李四\",\"repayType\":0,\"iouWayType\":1,\"appType\":\"jdb\",\"iouType\":1,\"baseAmt\":100,\"landerName\":\"公信宝\",\"iouStatus\":3}],\"contactList\":[{\"phone\":\"15512344321\",\"sourceType\":4,\"jdbId\":\"123321199001111234\",\"name\":\"张三\",\"contactType\":3,\"remarkName\":\"\"},{\"phone\":\"16812344321\",\"sourceType\":2,\"jdbId\":\"321123199007011234\",\"name\":\"李四\",\"contactType\":3,\"remarkName\":\"\"}],\"jdbCreditInfo\":{\"currentLendTop5Percent\":0,\"alreadyDoneSuretyAmount\":0,\"currentZhuanlichaTop5Percent\":0,\"currentBorrowTop5Percent\":0,\"historicalBorrowFriendCount\":0,\"historicalBorrowCount\":0,\"currentSuretyTop5Percent\":0,\"alreadyDoneZhuanlichaAmount\":0,\"alreadyDoneBorrowAmount\":0,\"historicalBorrowAmount\":0,\"historicalLendAmount\":300,\"historicalLendFriendCount\":1,\"historicalSuretyCount\":0,\"historicalZhuanlichaAmount\":0,\"historicalSuretyAmount\":0,\"currentBorrowAmount\":0,\"historicalSuretyFriendCount\":0,\"historicalZhuanlichaCount\":0,\"currentLendAmount\":200,\"currentSuretyAmount\":0,\"currentZhuanlichaAmount\":0,\"historicalLendCount\":3,\"historicalZhuanlichaFriendCount\":0,\"alreadyDoneLendAmount\":100},\"authList\":[{\"authStatus\":0,\"authName\":\"实名认证\",\"authType\":1},{\"authStatus\":0,\"authName\":\"肖像认证\",\"authType\":2},{\"authStatus\":0,\"authName\":\"银行卡认证\",\"authType\":3},{\"authStatus\":1,\"authName\":\"信用认证\",\"authType\":35},{\"authStatus\":0,\"authName\":\"上传通讯录\",\"authType\":9},{\"authStatus\":1,\"authName\":\"获取位置\",\"authType\":10},{\"authStatus\":1,\"authName\":\"绑定备用号\",\"authType\":11},{\"authStatus\":1,\"authName\":\"亲密联系人\",\"authType\":12},{\"authStatus\":1,\"authName\":\"上传身份证\",\"authType\":13},{\"authStatus\":1,\"authName\":\"运营商报告\",\"authType\":18},{\"authStatus\":1,\"authName\":\"京东认证\",\"authType\":19},{\"authStatus\":1,\"authName\":\"在读认证\",\"authType\":54},{\"authStatus\":1,\"authName\":\"公积金认证\",\"authType\":27},{\"authStatus\":1,\"authName\":\"银联交易认证\",\"authType\":59}]},\"appType\":\"jdb\"}";
    }
}
