package org.ms.service.ablecloud;

import com.ablecloud.common.ACUserDevice;
import com.ablecloud.service.AC;
import org.ms.mapper.ablecloud.AbleCloudMemberMapper;
import org.ms.mapper.ablecloud.MemberDeviceMapper;
import org.ms.module.ablecloud.AbleCloudMember;
import org.ms.module.ablecloud.MemberDevice;
import org.ms.tool.ablecloud.MyAcSingleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author SuperAndy
 * @Date 2018-05-31 10:01
 */
@Service
public class MemberDeviceServiceImpl implements MemberDeviceService{

    private Logger logger = LoggerFactory.getLogger("baseBack");
    private MemberDeviceMapper memberDeviceMapper;
    private AbleCloudMemberMapper ableCloudMemberMapper;

    @Autowired
    public MemberDeviceServiceImpl(MemberDeviceMapper memberDeviceMapper, AbleCloudMemberMapper ableCloudMemberMapper) {
        this.memberDeviceMapper = memberDeviceMapper;
        this.ableCloudMemberMapper = ableCloudMemberMapper;
    }

    @Override
    public void dailyMemberDevice() {
        long offset = 0;
        long limit = 100;
        AC ac = MyAcSingleton.newInstance();
        List<AbleCloudMember> listAbleCloudMember = ableCloudMemberMapper.getAllAbleCloudMember();
        for (AbleCloudMember ableCloudMember : listAbleCloudMember) {
            handleMemberDevice(ac, ableCloudMember, offset, limit);
        }

    }

    private void handleMemberDevice(AC ac, AbleCloudMember ableCloudMember, long offset, long limit) {
        try {
            List<ACUserDevice> listACUserDevice = ac.bindMgr(ac.newContext("")).getDevicesOfUser("",
                    ableCloudMember.getId(), offset, limit);
            List<MemberDevice> listMemberDevice = new ArrayList<>();
            for (ACUserDevice acUserDevice : listACUserDevice) {
                MemberDevice memberDevice = new MemberDevice();
                memberDevice.setId(acUserDevice.getId());
                memberDevice.setName(acUserDevice.getName());
                memberDevice.setGatewayDeviceId(acUserDevice.getGatewayDeviceId());
                memberDevice.setOwner(acUserDevice.getOwner());
                memberDevice.setPhysicalId(acUserDevice.getPhysicalId());
                memberDevice.setRootId(acUserDevice.getRootId());
                memberDevice.setStatus(acUserDevice.getStatus());
                memberDevice.setSubDomainId(acUserDevice.getSubDomainId());
                memberDevice.setSubDomainName(acUserDevice.getSubDomainName());
                listMemberDevice.add(memberDevice);
            }
            if (listMemberDevice.size() > 0 && listMemberDevice.size() < limit) {
                int result = memberDeviceMapper.insertMemberDevice(listMemberDevice);
                //System.out.println("成功插入了" + result + "条用户机器列表关系");
            } else if (listMemberDevice.size() == limit) {
                int result = memberDeviceMapper.insertMemberDevice(listMemberDevice);
                // System.out.println("成功插入了" + result + "条用户机器列表关系,进行递归");
                long middle = offset + limit;
                handleMemberDevice(ac, ableCloudMember, middle, limit);
            }

        } catch (Exception e) {
            logger.error("云端抓取每日用户设备关系列表错误:" + e.getMessage());
        }

    }

}
