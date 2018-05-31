package org.ms.service.timeTask;

import org.ms.service.ablecloud.AbleCloudMemberService;
import org.ms.service.ablecloud.BewinchDeviceInfoService;
import org.ms.service.ablecloud.BewinchPropertyService;
import org.ms.service.ablecloud.MemberDeviceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author SuperAndy
 * @Date 2018-05-31 10:03
 */
@Component
public class AbleCloudTask {
    Logger logger = LoggerFactory.getLogger("baseBack");

    @Autowired
    private BewinchDeviceInfoService bewinchDeviceInfoService;

    @Autowired
    private BewinchPropertyService bewinchPropertyService;

    @Autowired
    private AbleCloudMemberService ableCloudMemberService;

    @Autowired
    private MemberDeviceService memberDeviceService;

    @Scheduled(cron = "0 30 0 * * *")
    public void dailyActivateDevices() {

        int result = bewinchDeviceInfoService.dailyActivateDevices();
        logger.info("当天新增机器数量:" + result);
        //System.out.println("当天新增机器数量:" + result);

        long startTime = new Date().getTime();
        bewinchPropertyService.dailyBackBewinchProperty();
        logger.info("机器属性导入耗时:" + (new Date().getTime() - startTime));
        //System.out.println("机器属性导入完毕");

        startTime = new Date().getTime();
        ableCloudMemberService.dailyAbleCloudMember();
        logger.info("用户列表导入耗时:" + (new Date().getTime() - startTime));
        //System.out.println("用户列表导入完毕");

        startTime = new Date().getTime();
        memberDeviceService.dailyMemberDevice();
        logger.info("用户设备关系导入耗时:" + (new Date().getTime() - startTime));
        //System.out.println("用户设备关系表导入完毕");
    }
}
