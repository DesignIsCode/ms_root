package org.ms.api.ablecloud;

import org.ms.module.ablecloud.BewinchDeviceInfo;
import org.ms.service.ablecloud.AbleCloudMemberService;
import org.ms.service.ablecloud.BewinchDeviceInfoService;
import org.ms.service.ablecloud.BewinchPropertyService;
import org.ms.service.ablecloud.MemberDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @Author SuperAndy
 * @Date 2018-05-31 19:07
 */
@RestController
@RequestMapping("/main")
public class MainController {

    private BewinchDeviceInfoService bewinchDeviceInfoService;
    private BewinchPropertyService bewinchPropertyService;
    private AbleCloudMemberService ableCloudMemberService;
    private MemberDeviceService memberDeviceService;

    @Autowired
    public MainController(BewinchDeviceInfoService bewinchDeviceInfoService,BewinchPropertyService bewinchPropertyService,
                          AbleCloudMemberService ableCloudMemberService,MemberDeviceService memberDeviceService) {
        this.bewinchDeviceInfoService = bewinchDeviceInfoService;
        this.bewinchPropertyService = bewinchPropertyService;
        this.ableCloudMemberService = ableCloudMemberService;
        this.memberDeviceService = memberDeviceService;
    }

    @RequestMapping("/index")
    public String test() {
        return "Hello";
    }

    @RequestMapping("/testOne")
    public void testOne() {
        List<BewinchDeviceInfo> bewinchDeviceInfos = bewinchDeviceInfoService.getBewinchDeviceInfos();
        System.out.println("查询到:" + bewinchDeviceInfos.size());
    }

    @RequestMapping("/initBewinchDevices")
    public void initBewinchDevices() {
        long startTime = new Date().getTime();
        int result = bewinchDeviceInfoService.initAllDevices();
        System.out.println("机器列表初始化耗时:"+(new Date().getTime() - startTime));
        System.out.println("初始化数量:"+result);
    }

    @RequestMapping("/dailyActivateDevices")
    public void dailyActivateDevices() {
        int result = bewinchDeviceInfoService.dailyActivateDevices();
        System.out.println("当天新增数量:"+result);
    }

    @RequestMapping("/dailyDeviceProperties")
    public void dailyDeviceProperties() {
        long startTime = new Date().getTime();
        bewinchPropertyService.dailyBackBewinchProperty();
        System.out.println("机器属性导入耗时:"+(new Date().getTime() - startTime));
        System.out.println("机器属性导入完毕");
    }

    @RequestMapping("/dailyAbleCloudAccount")
    public void dailyAbleCloudAccount() {
        long startTime = new Date().getTime();
        ableCloudMemberService.dailyAbleCloudMember();
        System.out.println("用户列表导入耗时:"+(new Date().getTime() - startTime));
        System.out.println("用户列表导入完毕");
    }

    @RequestMapping("/dailyUserDevice")
    public void dailyUserDevice() {
        long startTime = new Date().getTime();
        memberDeviceService.dailyMemberDevice();
        System.out.println("用户设备关系导入耗时:"+(new Date().getTime() - startTime));
        System.out.println("用户设备关系表导入完毕");
    }
}
