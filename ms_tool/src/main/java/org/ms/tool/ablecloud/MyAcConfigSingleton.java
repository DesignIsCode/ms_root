package org.ms.tool.ablecloud;

/**
 * @Author SuperAndy
 * @Date 2018-05-31 9:13
 */
public class MyAcConfigSingleton {
    private static class MyAcConfigSingletonHolder {
        public static MyAcConfig myAcConfig = new MyAcConfig("ac.conf");
    }

    private MyAcConfigSingleton() {
    }

    public static MyAcConfig newInstance() {
        return MyAcConfigSingletonHolder.myAcConfig;
    }
}
