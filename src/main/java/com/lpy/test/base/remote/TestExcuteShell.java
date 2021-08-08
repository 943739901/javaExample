package com.lpy.test.base.remote;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @author lipengyu
 */
public class TestExcuteShell {

    @Test
    public void test1() {
        try {
            ExecuteShellUtil instance = ExecuteShellUtil.getInstance();
            instance.init("192.168.1.144", 22, "camera", "isc123456");
            String serialNo = "F21978461";
            String port = "554";
            String s1 = instance.execCmd("ps -ef | grep " + serialNo + " | grep ffmpeg | grep -v grep | awk '{print $2}'");
            System.out.println(s1);
            if (StringUtils.isNotBlank(s1)) {
                return;
            }
            instance.execCmd("nohup ffmpeg -f rtsp -rtsp_transport tcp -i rtsp://admin:Sc123456@192.168.20.252:" + port + "/Streaming/Channels/101 -r 23 -f hls -hls_time 4 -hls_list_size 5 -hls_wrap 10 -hls_flags delete_segments /usr/share/nginx/html/hls/" + serialNo + "/cam.m3u8 1>/dev/null 2>&1 &");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        try {
            ExecuteShellUtil instance = ExecuteShellUtil.getInstance();
            instance.init("192.168.1.144", 22, "camera", "isc123456");
            String serialNo = "F21978461";
            String s1 = instance.execCmd("ps -ef | grep " + serialNo + " | grep ffmpeg | grep -v grep | awk '{print $2}'");
            String[] split = s1.split("\n");
            if (split.length > 0) {
                for (String s : split) {
                    if (StringUtils.isNotBlank(s)) {
                        instance.execCmd("kill -9 " + s);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
