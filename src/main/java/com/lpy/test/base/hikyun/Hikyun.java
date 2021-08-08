package com.lpy.test.base.hikyun;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hikvision.artemis.sdk.ArtemisHttpUtil;
import com.hikvision.artemis.sdk.config.ArtemisConfig;
import com.lpy.test.base.hikyun.DTO.*;
import org.junit.Test;

import java.util.*;

/**
 * @author lipengyu
 */
public class Hikyun {

    private final Long projectId = 1513874748864912L;

    /**
     * 请根据自己的appKey和appSecret更换static静态块中的三个参数。
     */
    static {
        ArtemisConfig.host = "gcca-open.hikyun.com"; // artemis网关服务器ip端口
        ArtemisConfig.appKey = "21229755"; // 秘钥appkey
        ArtemisConfig.appSecret = "GDaix5A2tuZkUCeS4sFL";// 秘钥appSecret
    }
    /**
     * 能力开放平台的网站路径
     * 路径不用修改，就是/artemis
     */
    private static final String ARTEMIS_PATH = "/artemis";

    /**
     * 获取全局token
     */
    @Test
    public void test() {
        GlobalRequest globalRequest = new GlobalRequest();
        globalRequest.setProjectId(projectId);
        String globalDataApi = ARTEMIS_PATH +"/api/v1/common/token/global";
        Map<String,String> path = new HashMap<String,String>(2){
            {
                put("https://",globalDataApi);
            }
        };
        String body= JSON.toJSONString(globalRequest);
        String result = ArtemisHttpUtil.doPostStringArtemis(path,body,null,null,"application/json");
        System.out.println(result);
    }

    /**
     * 获取萤石token
     */
    @Test
    public void test1() {
        YsRequest ysRequest = new YsRequest();
        ysRequest.setDev("F31735438");
        String ysDataApi = ARTEMIS_PATH +"/api/v1/common/token/ys";
        Map<String,String> path = new HashMap<String,String>(2){
            {
                put("https://",ysDataApi);
            }
        };
        String body=JSON.toJSONString(ysRequest);
        Map<String, String> header = new HashMap<>();
        header.put("AccessToken", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBdXRob3JpemF0aW9uIiwicGF5bG9hZCI6IntcInByb2R1Y3RDb2RlXCI6XCJnYXJiYWdlXCIsXCJ0aW1lXCI6XCIxNjE1ODkwMTQ5MjQwXCJ9In0.4iKtnajPeqzQ_I00iQhvVdNdE_vzmKK6BoWCJ9os1s5hgJd_Odk3vLLRF_vnW2asMTnjV_7JaEsvRjO_-bWokA");
        String result =ArtemisHttpUtil.doPostStringArtemis(path,body,null,null,"application/json",header);
        System.out.println(result);
    }

    /**
     * 获取用户token
     */
    @Test
    public void test2() {
        UserRequest userRequest = new UserRequest();
        userRequest.setName("");
        userRequest.setPassword("");
        String userDataApi = ARTEMIS_PATH +"/api/v1/common/token/user";
        Map<String,String> path = new HashMap<String,String>(2){
            {
                put("https://",userDataApi);
            }
        };
        String body=JSON.toJSONString(userRequest);
        Map<String, String> header = new HashMap<>();
        header.put("AccessToken", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBdXRob3JpemF0aW9uIiwicGF5bG9hZCI6IntcInByb2R1Y3RDb2RlXCI6XCJnYXJiYWdlXCIsXCJ0aW1lXCI6XCIxNjE1ODkwMTQ5MjQwXCJ9In0.4iKtnajPeqzQ_I00iQhvVdNdE_vzmKK6BoWCJ9os1s5hgJd_Odk3vLLRF_vnW2asMTnjV_7JaEsvRjO_-bWokA");
        String result =ArtemisHttpUtil.doPostStringArtemis(path,body,null,null,"application/json",header);
        System.out.println(result);
    }

    /**
     * {"code":"200","msg":"操作成功","data":"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBdXRob3JpemF0aW9uIiwicGF5bG9hZCI6IntcInByb2R1Y3RDb2RlXCI6XCJnYXJiYWdlXCIsXCJ0aW1lXCI6XCIxNjE1ODY0NTE4Njk2XCJ9In0.bDcOG7Mmpd5x7peOttF250puGk9-LwbxBiL2jvW5z4cZNBT1ipC1y5QVcGOTLCszVn0rIBj-RwKGvd9dcAY14g"}
     */
    @Test
    public void test3() {
        GetRequest getRequest = new GetRequest();
        getRequest.setDeviceSerial("F31735438");
        getRequest.setProjectId(projectId);
        String getDataApi = ARTEMIS_PATH +"/api/v1/resource/device/get";
        Map<String,String> path = new HashMap<String,String>(2){
            {
                put("https://",getDataApi);
            }
        };
        Map<String, String> header = new HashMap<>();
        header.put("AccessToken", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBdXRob3JpemF0aW9uIiwicGF5bG9hZCI6IntcInByb2R1Y3RDb2RlXCI6XCJnYXJiYWdlXCIsXCJ0aW1lXCI6XCIxNjE1ODg2Mjc2MDA2XCJ9In0.mC1-Rz1b0n3KMRSPW5aCt7eFLl8BpUiR4A4pVxXZk9ChLcAqxXg-liuq1v8Crdo1KKSwbDWrVw1Tllr8d4Xcwg");
        String body=JSON.toJSONString(getRequest);
        String result =ArtemisHttpUtil.doPostStringArtemis(path,body,null,null,"application/json", header);

        System.out.println(result);
    }

    /**
     * {"code":"200","msg":"操作成功","data":"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBdXRob3JpemF0aW9uIiwicGF5bG9hZCI6IntcInByb2R1Y3RDb2RlXCI6XCJnYXJiYWdlXCIsXCJ0aW1lXCI6XCIxNjE1ODY0NTE4Njk2XCJ9In0.bDcOG7Mmpd5x7peOttF250puGk9-LwbxBiL2jvW5z4cZNBT1ipC1y5QVcGOTLCszVn0rIBj-RwKGvd9dcAY14g"}
     */
    @Test
    public void test4() {
        OpenRequest openRequest = new OpenRequest();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("F31735438#1");
        openRequest.setMonitorCodes(arrayList);
        openRequest.setProjectId(projectId);
        String openDataApi = ARTEMIS_PATH +"/api/v1/resource/video/live/open";
        Map<String,String> path = new HashMap<String,String>(2){
            {
                put("https://",openDataApi);
            }
        };
        String body=JSON.toJSONString(openRequest);
        Map<String, String> header = new HashMap<>();
        header.put("AccessToken", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBdXRob3JpemF0aW9uIiwicGF5bG9hZCI6IntcInByb2R1Y3RDb2RlXCI6XCJnYXJiYWdlXCIsXCJ0aW1lXCI6XCIxNjE1ODg5MDM2NTk1XCJ9In0.aCs4Rnt0ZJKzN82f6q8P5Kx19kMiP6W1b1ThvsjHtG0YCuEx0_clAX7iwehJeM12DzP3J0gjsgI01H5qRDeqYA");
        String result =ArtemisHttpUtil.doPostStringArtemis(path,body,null,null,"application/json", header);

        System.out.println(result);
    }
}
