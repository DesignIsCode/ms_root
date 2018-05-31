package org.ms.tool.ablecloud;

import com.ablecloud.common.ACConfig;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;

/**
 * @Author SuperAndy
 * @Date 2018-05-30 17:06
 */
public class MyAcConfig extends ACConfig {

    private Configuration configuration;

    public MyAcConfig(String configFile) {
        try {
            configuration = new Configurations().properties(new File(configFile));
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }

    /**
     * 取开发者在AbleCloud平台上的帐号的ID（可登录AbleCloud管理控制台查看）。
     *
     * @return 返回开发者帐号的ID。
     */
    @Override
    public long getDeveloperId() {
        return configuration.getInt("developer_id", 0);
    }

    /**
     * 取开发者在AbleCloud平台上对应的主域的名字（可登录AbleCloud管理控制台查看）。
     *
     * @return 开发者的主域的名字。
     */
    @Override
    public String getMajorDomain() {
        return configuration.getString("major_domain", "");
    }

    /**
     * 取运行模式：ACConfig.TEST_MODE 或 ACConfig.PRODUCTION_MODE。
     *
     * @return 返回运行模式：ACConfig.TEST_MODE 或 ACConfig.PRODUCTION_MODE。
     */
    @Override
    public String getMode() {
        return PRODUCTION_MODE;
    }

    @Override
    public String getAuthAccessKey() {
        return configuration.getString("access_key", "");
    }

    @Override
    public String getAuthSecretKey() {
        return configuration.getString("secret_key", "");
    }

    @Override
    public String getRouterAddr() {
        String addr = super.getRouterAddr();
        if (null == addr || addr.isEmpty()) {
            String routerAddrs = configuration.getString("router_addr", "");
            setRouterAddr(routerAddrs);
            addr = super.getRouterAddr();
        }
        return addr;
    }

}
