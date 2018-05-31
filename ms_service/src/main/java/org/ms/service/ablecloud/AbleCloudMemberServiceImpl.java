package org.ms.service.ablecloud;

import com.ablecloud.common.ACAccount;
import com.ablecloud.common.ACThirdPlatform;
import com.ablecloud.service.AC;
import org.ms.mapper.ablecloud.AbleCloudMemberMapper;
import org.ms.module.ablecloud.AbleCloudMember;
import org.ms.tool.ablecloud.MyAcSingleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author SuperAndy
 * @Date 2018-05-30 16:34
 */
@Service
public class AbleCloudMemberServiceImpl implements AbleCloudMemberService{

    private Logger logger = LoggerFactory.getLogger("baseBack");

    private AbleCloudMemberMapper ableCloudMemberMapper;

    @Autowired
    public AbleCloudMemberServiceImpl(AbleCloudMemberMapper ableCloudMemberMapper) {
        this.ableCloudMemberMapper = ableCloudMemberMapper;
    }

    @Override
    public int dailyAbleCloudMember() {
        int result = 0;
        AC ac = MyAcSingleton.newInstance();
        List<ACAccount> listACAccount = new ArrayList<>();
        List<AbleCloudMember> listAbleCloudMember = new ArrayList<>();
        try {
            long accountCount = ac.accountMgr(ac.newContext("")).getAccountCount();
            long offset = 0;
            long limit = 100;
            while (offset <= accountCount) {
                List<ACAccount> acAccounts = ac.accountMgr(ac.newContext("")).listAllAccounts(offset, limit);
                listACAccount.addAll(acAccounts);
                offset += limit;
            }
            listACAccount.stream().forEach(acAccount -> {
                AbleCloudMember ableCloudMember = new AbleCloudMember();
                ableCloudMember.setId(acAccount.getUid());
                ableCloudMember.setPhone(acAccount.getPhone());
                ableCloudMember.setEmail(acAccount.getEmail());
                ableCloudMember.setNickName(acAccount.getNickName());
                ableCloudMember.setOpenId(acAccount.getOpenId(ACThirdPlatform.WEIXIN));
                ableCloudMember.setReserveOne(acAccount.getToken());
                ableCloudMember.setReserveTwo(acAccount.getTokenExpiration());
                ableCloudMember.setReserveThree(acAccount.getRefreshToken());
                ableCloudMember.setReserveFour(acAccount.getRefreshTokenExpiration());
                ableCloudMember.setCreateTime(LocalDateTime.now());
                listAbleCloudMember.add(ableCloudMember);
            });
            // System.out.println("账号数量:" + listAbleCloudMember.size());

            if (listAbleCloudMember.size() > 0) {
                result = ableCloudMemberMapper.insertAbleCloudMember(listAbleCloudMember);
                return result;
            } else {
                return result;
            }
        } catch (Exception e) {
            logger.error("云端账户查询或插入错误:"+e.getMessage());
            return result;
        }
    }

}
