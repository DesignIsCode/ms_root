package org.ms.tool.ablecloud;

import com.ablecloud.cloudservice.ACCloud;
import com.ablecloud.service.AC;

/**
 * @Author SuperAndy
 * @Date 2018-05-31 9:33
 */
public class MyAcSingleton {
    private static class MyAcSingletonHolder {
        public static AC ac = new ACCloud(MyAcConfigSingleton.newInstance());
    }

    public MyAcSingleton() {
    }

    public static AC newInstance() {
        return MyAcSingletonHolder.ac;
    }
}
