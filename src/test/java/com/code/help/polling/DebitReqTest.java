package com.code.help.polling;

import org.junit.Test;

public class DebitReqTest {

    final String appId = "gxba57f409ca1fe2dfa";
    final String appSecurity = "2d1844d9dd8540149e936b0125c4f8de";
    final String authItem = "debitDirect";

    final String tokenUrl = "https://prod.gxb.io/crawler/auth/v2/get_auth_token";
    final String initConfigUrl = "https://prod.gxb.io/crawler/auth/minterm/v3/init_config/debit/debitDirect/";
    final String submitUrl = "https://prod.gxb.io/crawler/auth/minterm/v3/login_submit/";
    final String statusUrl = "https://prod.gxb.io/crawler/auth/minterm/v3/get_status/";
    final String crawlerUrl = "https://prod.gxb.io/crawler/data/rawdata/";
//    @Autowired
//    ResultDao resultDao;

    @Test
    public void execute() throws Exception {
        /*List<Result> results = resultDao.queryList();
//
        int successNum = 0;
        int failNUm = 0;
        int n=0;
        while(results.size()>0) {
            LinkedBlockingQueue callables = new LinkedBlockingQueue<>();
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(40, 40, 2, TimeUnit.MINUTES, callables);

            List<Future<Result>> futureResults = new LinkedList<>();
            List<Result> errorResults = new LinkedList<>();
            for (Result result : results) {
                Future<Result> futureTask = threadPoolExecutor.submit(crawler(result, resultDao));
                futureResults.add(futureTask);
            }
            TimeUnit.SECONDS.sleep(results.size()/5);
            threadPoolExecutor.shutdown();
            while (true) {
                if (threadPoolExecutor.isTerminated()) {
                    System.out.print("retry request:");
                    for (Future<Result> futureTask : futureResults) {
                        Result r = futureTask.get();
                        if (r != null) {
                            if(n==0 && "1".equals(r.getResult())){
                                failNUm++;
                            }
                            System.out.print(r.getId()+", ");
                            errorResults.add(r);
                        }else if(n==0){
                            successNum++;
                        }
                    }
                    n++;
                    System.out.println();
                    break;
                }
                TimeUnit.SECONDS.sleep(2);
            }
            threadPoolExecutor.shutdownNow();
            results = errorResults;
        }

        System.out.println("successNum:"+successNum);
        System.out.println("failNUm:"+failNUm);
//        resultDao.updateAll();


    }

    public Callable<Result> crawler(Result result, ResultDao resultDao){
        Callable<Result> execCall = ()->{
            String originalName =Thread.currentThread().getName();
            Thread.currentThread().setName(originalName+" id="+result.getId()+" ");
            String crawlerContent = null;
            String tokenContent = getResponse(tokenUrl, ProtocolInput.Action.POST_STRING, getTokenParams(result), null);
            String token = JSONObject.parseObject(tokenContent).getJSONObject("data").getString("token");

            String initContent = getResponse(initConfigUrl+token, null, null, null);
            JSONObject loginForm = JSONObject.parseObject(initContent).getJSONObject("data").getJSONArray("loginForms").getJSONObject(0);
            if(loginForm.get("status").equals("NORMAL")){
                JSONObject params = new JSONObject();
                params.put("username", result.getPhone());
                params.put("password", result.getIdcard());

                getResponse(submitUrl+token+"\""+params.toJSONString(), null, null, null);

                Callable<String> statusCall = new Callable() {
                    @Override
                    public Object call() throws Exception {
                        String statusContent = getResponse(statusUrl + token, null, null, null);
                        List<String> phaseStatus = Arrays.asList("LOGIN_FAILED", "LOGIN_SUCCESS", "FAILED", "SUCCESS");
                        JSONObject statusObj = JSONObject.parseObject(statusContent).getJSONObject("data");
                        if(phaseStatus.contains(statusObj.getString("phaseStatus")) || "LOGINED".equals(statusObj.getString("stage"))) {
                            return statusContent;
                        }else{
                            return null;
                        }
                    }
                };
                String statusContent = process(statusCall, TimeUnit.MINUTES.toMillis(1));
                if(statusContent==null){
                    Thread.currentThread().setName(originalName);
                    System.out.println(Thread.currentThread().getName()+" id="+result.getId()+" statusContent is null token:"+token);
                    return result;
                }

                if("timeout".equals(statusContent)){
                    Thread.currentThread().setName(originalName);
                    System.out.println(Thread.currentThread().getName()+" id="+result.getId()+" time out");
                    return result;
                }

                JSONObject statusObj = JSONObject.parseObject(statusContent).getJSONObject("data");
                Thread.currentThread().setName(originalName);
                if(!StringUtils.isEmpty(statusContent) && ("LOGIN_SUCCESS".equals(statusObj.getString("phaseStatus")) || "SUCCESS".equals(statusObj.getString("phaseStatus")))) {
                    Callable<String> crawlerCall = new Callable<String>() {
                        @Override
                        public String call() throws Exception {
                            String crawlerContent = getResponse(crawlerUrl + token, null, null, null);
                            String authResult = JSONObject.parseObject(crawlerContent).getJSONObject("data").getString("authResult");
                            if(StringUtils.isEmpty(authResult)){
                                return null;
                            }
                            return crawlerContent;
                        }
                    };
                    System.out.println(Thread.currentThread().getName()+" id="+result.getId()+" success");
                    crawlerContent = process(crawlerCall, TimeUnit.MINUTES.toMillis(1));
                    try{
                        crawlerContent = JSONObject.parseObject(crawlerContent).getJSONObject("data").getJSONObject("authResult").getString("data");
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                        System.out.println(Thread.currentThread().getName()+" id="+result.getId()+" content:"+crawlerContent);
                        return result;
                    }
                    if(JSONObject.parseObject(crawlerContent).get("directWyjtData")==null || JSONObject.parseObject(crawlerContent).get("directMfData")==null){
                        System.out.println(Thread.currentThread().getName()+" id="+result.getId()+" mf or yxb is null token:"+token);
                        Thread.currentThread().setName(originalName);
                        return result;
                    }

                    result.setResult(crawlerContent);
                    resultDao.update(result);
                }else if(!StringUtils.isEmpty(statusContent) && ("LOGIN_FAILED".equals(statusObj.getString("phaseStatus")) || "FAILED".equals(statusObj.getString("phaseStatus")))){
                    System.out.println(Thread.currentThread().getName()+" id="+result.getId()+" login fail or failed!token:"+token);
                    result.setResult("1");
                    return result;
                }else{
                    System.out.println(Thread.currentThread().getName()+" id="+result.getId()+" other fail");
                    Thread.currentThread().setName(originalName);
                    return result;
                }

            }
            Thread.currentThread().setName(originalName);
            return null;
        };

        return execCall;
    }
    public String process(Callable<String> call, long timeout){
        long startTime = System.currentTimeMillis();
        String content = null;
        while(true) {
            try {
                content = call.call();
                if (!StringUtils.isEmpty(content)) {
                    return content;
                }
                Thread.sleep(300);
                long endTime = System.currentTimeMillis();
                if (timeout < (endTime - startTime)) {
                    return "timeout";
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String getResponse(String url, ProtocolInput.Action method, String jsonBody, Map<String, String> headers){
        ProtocolInput input = new ProtocolInput();
        input.setUrl(url);
        input.addHeader("Content-type", "application/json; charset=utf-8");
        if(method != null){
            input.setAction(method);
        }
        if(!StringUtils.isEmpty(jsonBody)) {
            input.setPostBody(jsonBody);
        }
        if(headers!=null) {
            input.addHeaders(headers);
        }
        Protocol protocol = WebClientUtil.getWebClient();
        Content content = protocol.getProtocolOutput(input).getContent();
        String pageContent = null;
        if(content!=null){
            pageContent = content.getContentAsString();
        }else{
            System.out.println(Thread.currentThread().getName()+" url="+url+"  result="+(content==null?null:""));
        }
        return pageContent;
    }
    public String getTokenParams(Result result){
        Map<String, Object> params = new HashMap<>();
        String sequenceNo  = UUID.randomUUID().toString().replace("-", "");
        Long timestamp = new Date().getTime();

        params.put("appId", appId);
        params.put("sequenceNo", sequenceNo);
        params.put("authItem", authItem);
        params.put("timestamp", timestamp);

        params.put("name", result.getName());
        params.put("idcard", result.getIdcard());
        params.put("phone", result.getPhone());
        params.put("sign", DigestUtils.md5Hex(String.format("%s%s%s%s%s", appId, appSecurity, authItem, timestamp ,sequenceNo)));
        return JSON.toJSONString(params);
    }*/
    }

}
