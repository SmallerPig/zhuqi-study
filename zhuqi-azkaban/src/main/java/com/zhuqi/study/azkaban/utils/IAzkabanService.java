package com.zhuqi.study.azkaban.utils;

import java.io.File;
import java.util.Date;

public interface IAzkabanService {

    /**
     * Azkaban登录接口，返回sessionId
     *
     * @return
     * @throws Exception
     * @author wuzy
     * @date 2017年12月21日
     */
    public String login() throws Exception;

    /**
     * Azkaban创建project
     *
     * @param projectName project名称
     * @param description project描述
     * @throws Exception
     * @author wuzy
     * @date 2017年12月21日
     */
    public void createProject(String projectName, String description) throws Exception;

    /**
     * Azkaban删除project
     *
     * @param projectName project名称
     * @throws Exception
     * @author wuzy
     * @date 2017年12月21日
     */
    public void deleteProject(String projectName) throws Exception;

    /**
     * Azkaban上传zip文件
     *
     * @param projectName
     * @param file
     * @return projectId
     * @throws Exception
     * @author wuzy
     * @date 2017年12月21日
     */
    public String uploadZip(String projectName, File file) throws Exception;

    /**
     * 根据时间 创建调度任务
     *
     * @param projectId
     * @param projectName
     * @param flow
     * @param flowName
     * @param recurring   是否循环，on循环
     * @param period      循环频率： M Months，w Weeks，d Days，h Hours，m Minutes，s Seconds；如60s，支持分钟的倍数
     * @param date        开始时间
     * @return 返回scheduleId
     * @throws Exception
     * @author wuzy
     * @date 2017年12月21日
     */
    public String scheduleEXEaFlow(String projectId, String projectName, String flow, String flowName, String recurring, String period, Date date) throws Exception;

    /**
     * 根据cron表达式 创建调度任务
     *
     * @param projectName
     * @param cron
     * @param flow
     * @param flowName
     * @return 返回scheduleId
     * @throws Exception
     * @author wuzy
     * @date 2017年12月21日
     */
    public String scheduleByCronEXEaFlow(String projectName, String cron, String flow, String flowName) throws Exception;

    /**
     * 根据scheduleId取消一个流的调度
     *
     * @param scheduleId
     * @throws Exception
     * @author wuzy
     * @date 2017年12月21日
     */
    public void unscheduleFlow(String scheduleId) throws Exception;

    /**
     * 下载Azkaban压缩文件
     *
     * @param projectName
     * @param zipPath
     * @throws Exception
     * @author wuzy
     * @date 2017年12月22日
     */
    public void downLoadZip(String projectName, String zipPath) throws Exception;
}
