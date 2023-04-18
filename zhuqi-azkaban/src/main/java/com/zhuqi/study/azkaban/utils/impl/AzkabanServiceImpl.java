package com.zhuqi.study.azkaban.utils.impl;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.zhuqi.study.azkaban.utils.IAzkabanService;
import com.zhuqi.study.azkaban.utils.SSLUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class AzkabanServiceImpl implements IAzkabanService {

    private static final Logger logger = LoggerFactory.getLogger(AzkabanServiceImpl.class);

    private static final String CONTENT_TYPE = "application/x-www-form-urlencoded; charset=utf-8";

    private static final String X_REQUESTED_WITH = "XMLHttpRequest";

    @Override
    public String login() throws Exception
    {
        SSLUtil.turnOffSslChecking();


        Map<String,Object> form = new HashMap<>();
        form.put("action", "login");
        form.put("username", "azkaban");
        form.put("password", "azkaban");
        String result = getBaseHttpClient("")
                .form(form)
                .execute().body();

        logger.info("--------Azkaban返回登录信息：" + result);
        String str = JSONUtil.parseObj(result).getStr("session.id");

        return str;
    }

    /**
     * create a project
     * @param projectName project名称
     * @param description project描述
     * @throws Exception
     */
    @Override
    public void createProject(String projectName, String description) throws Exception
    {
        SSLUtil.turnOffSslChecking();
        Map<String, Object> maps = new HashMap<>();
        maps.put("session.id", login());
        maps.put("action", "create");
        maps.put("name", projectName);
        maps.put("description", description);

        String result = getBaseHttpClient("/manager").form(maps).execute().body();

        logger.info("--------Azkaban返回创建Project信息：" + result);

        // 创建成功和已存在，都表示创建成功
        if (!"success".equals(JSONUtil.parseObj(result).getStr("status")))
        {
            if (!"Project already exists.".equals(JSONUtil.parseObj(result).getStr("message")))
            {
                throw new Exception("创建Azkaban Project失败");
            }
        }
    }

    @Override
    public void deleteProject(String projectName) throws Exception
    {
        SSLUtil.turnOffSslChecking();


        Map<String, Object> map = new HashMap<>();

        map.put("id", login());
        map.put("project", projectName);

        HttpResponse accept = getBaseHttpClient("/manager?session.id={id}&delete=true&project={project}")
                .header("Accept", "text/plain;charset=utf-8")
                .form(map)
                .execute();

        logger.info("--------Azkaban返回删除Azkaban Project信息：" + accept.body());

        if (200 != accept.getStatus())
        {
            throw new Exception("删除Azkaban Project失败");
        }
    }

    @Override
    public String uploadZip(String projectName, File file) throws Exception
    {
        SSLUtil.turnOffSslChecking();
        FileSystemResource resource = new FileSystemResource(file);
        Map<String, Object> requstMap = new HashMap<>();
        requstMap.put("session.id", login());
        requstMap.put("ajax", "upload");
        requstMap.put("project", projectName);
        requstMap.put("file", resource);

        HttpRequest baseHttpClient = getBaseHttpClient("/manager");
        String result = baseHttpClient.form(requstMap).execute().body();


        logger.info("--------Azkaban返回上传文件信息：" + result);

//        if (StringUtils.isEmpty(new Gson().fromJson(result, JsonObject.class).get("projectId").getAsString()))
        if (StringUtils.isEmpty(JSONUtil.parseObj(result).getStr("project")))
        {
            throw new Exception("上传文件至Azkaban失败");
        }

        return JSONUtil.parseObj(result).getStr("project");
    }

    @Override
    public String scheduleEXEaFlow(String projectId, String projectName, String flow, String flowName, String recurring, String period, Date date) throws Exception
    {
        SSLUtil.turnOffSslChecking();

        Map<String, Object> maps = new ConcurrentHashMap<>();
        maps.put("session.id", login());
        maps.put("ajax", "scheduleFlow");
        maps.put("projectName", projectName);
        maps.put("projectId", projectId);
        maps.put("flow", flow);
        maps.put("flowName", flowName);
        maps.put("is_recurring", recurring);
        maps.put("period", period);
        scheduleTimeInit(maps, date);

        String result = getBaseHttpClient("/schedule").form(maps).execute().body();


        logger.info("--------Azkaban返回根据时间创建定时任务信息：" + result);

        if (!"200".equals(JSONUtil.parseObj(result).getStr("status")) || JSONUtil.parseObj(result).getInt("scheduleId") < 0)
        {
            throw new Exception("根据时间创建定时任务失败");
        }

        return JSONUtil.parseObj(result).getStr("scheduleId");
    }

    private void scheduleTimeInit(Map<String, Object> maps, Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Integer year = calendar.get(Calendar.YEAR);
        Integer month = calendar.get(Calendar.MONTH) + 1;
        Integer day = calendar.get(Calendar.DATE);
        Integer hour = calendar.get(Calendar.HOUR_OF_DAY);
        Integer minute = calendar.get(Calendar.MINUTE);

        maps.put("scheduleTime", hour + "," + minute + (hour > 11 ? ",pm,PDT" : ",am,EDT"));
        maps.put("scheduleDate", month + "/" + day + "/" + year);
    }

    @Override
    public String scheduleByCronEXEaFlow(String projectName, String cron, String flow, String flowName) throws Exception
    {
        throw new NotImplementedException();
//        SSLUtil.turnOffSslChecking();
//        HttpHeaders hs = new HttpHeaders();
//        hs.add("Content-Type", CONTENT_TYPE);
//        hs.add("X-Requested-With", X_REQUESTED_WITH);
//        LinkedMultiValueMap<String, String> linkedMultiValueMap = new LinkedMultiValueMap<String, String>();
//        linkedMultiValueMap.add("session.id", login());
//        linkedMultiValueMap.add("ajax", "scheduleCronFlow");
//        linkedMultiValueMap.add("projectName", projectName);
//        linkedMultiValueMap.add("cronExpression", cron);
//        linkedMultiValueMap.add("flow", flow);
//        linkedMultiValueMap.add("flowName", flowName);
//
//        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(linkedMultiValueMap, hs);
//        String result = restTemplate.postForObject(getAzkUrl() + "/schedule", httpEntity, String.class);
//
//        logger.info("--------Azkaban返回根据cron表达式创建定时任务信息：" + result);
//
//        if (!Constant.AZK_SUCCESS.equals(new Gson().fromJson(result, JsonObject.class).get("status").getAsString()))
//        {
//            throw new Exception("根据cron表达式创建定时任务失败");
//        }
//
//        return new Gson().fromJson(result, JsonObject.class).get("scheduleId").getAsString();
    }

    @Override
    public void unscheduleFlow(String scheduleId) throws Exception
    {
        throw new NotImplementedException();

//        SSLUtil.turnOffSslChecking();
//        HttpHeaders hs = new HttpHeaders();
//        hs.add("Content-Type", CONTENT_TYPE);
//        hs.add("X-Requested-With", X_REQUESTED_WITH);
//        LinkedMultiValueMap<String, String> linkedMultiValueMap = new LinkedMultiValueMap<String, String>();
//        linkedMultiValueMap.add("session.id", login());
//        linkedMultiValueMap.add("action", "removeSched");
//        linkedMultiValueMap.add("scheduleId", scheduleId);
//
//        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(linkedMultiValueMap, hs);
//        String result = restTemplate.postForObject(getAzkUrl() + "/schedule", httpEntity, String.class);
//
//        logger.info("--------Azkaban返回取消流调度信息：" + result);
//
//        if (!Constant.AZK_SUCCESS.equals(new Gson().fromJson(result, JsonObject.class).get("status").getAsString()))
//        {
//            throw new Exception("根据cron表达式创建定时任务失败");
//        }
    }

    @Override
    public void downLoadZip(String projectName, String zipPath)
    {
        throw new NotImplementedException();

//
//        OutputStream output = null;
//        BufferedOutputStream bufferedOutput = null;
//
//        try
//        {
//            URL url = new URL(getAzkUrl() + "/manager?session.id=" + login() + "&download=true&project=" + projectName);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setConnectTimeout(3 * 1000);
//            InputStream inputStream = conn.getInputStream();
//            File file = new File(zipPath);
//            output = new FileOutputStream(file);
//            bufferedOutput = new BufferedOutputStream(output);
//            bufferedOutput.write(IOUtils.toByteArray(inputStream));
//        }
//        catch (Exception e)
//        {
//            logger.info("--------下载Azkaban压缩文件异常：" + e.getMessage(), e);
//        }
//        finally
//        {
//            if (bufferedOutput != null)
//            {
//                try
//                {
//                    bufferedOutput.flush();
//                    bufferedOutput.close();
//                }
//                catch (IOException e)
//                {
//                    logger.info("关闭流异常：" + e.getMessage(), e);
//                }
//            }
//
//            if (output != null)
//            {
//                try
//                {
//                    output.close();
//                }
//                catch (IOException e)
//                {
//                    logger.info("关闭流异常：" + e.getMessage(), e);
//                }
//            }
//        }

    }

    private static HttpRequest getBaseHttpClient(String url){
        String baseUrl = "localhost:8081";
        HttpRequest result = HttpRequest.post(baseUrl + url)
                .header("Content-Tpe", CONTENT_TYPE)
                .header("X-Requested-With", X_REQUESTED_WITH);
        return result;
    }

    private String getAzkUrl(){
        return "localhost:8001";
    }
}
