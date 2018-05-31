package org.ms.module.ablecloud;

import org.apache.ibatis.type.Alias;
import org.ms.module.common.Member;

import java.time.LocalDateTime;

/**
 * @Author SuperAndy
 * @Date 2018-05-30 15:03
 */
@Alias("ableCloudMember")
public class AbleCloudMember extends Member {
    private String nickName;
    private String openId;
    private String reserveOne;
    private String reserveTwo;
    private String reserveThree;
    private String reserveFour;
    private String reserveFive;
    private LocalDateTime createTime;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getReserveOne() {
        return reserveOne;
    }

    public void setReserveOne(String reserveOne) {
        this.reserveOne = reserveOne;
    }

    public String getReserveTwo() {
        return reserveTwo;
    }

    public void setReserveTwo(String reserveTwo) {
        this.reserveTwo = reserveTwo;
    }

    public String getReserveThree() {
        return reserveThree;
    }

    public void setReserveThree(String reserveThree) {
        this.reserveThree = reserveThree;
    }

    public String getReserveFour() {
        return reserveFour;
    }

    public void setReserveFour(String reserveFour) {
        this.reserveFour = reserveFour;
    }

    public String getReserveFive() {
        return reserveFive;
    }

    public void setReserveFive(String reserveFive) {
        this.reserveFive = reserveFive;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    @Override
    public String toString() {
        return "AbleCloudMember ["+super.toString()+"nickName=" + nickName + ", openId=" + openId + ", reserveOne=" + reserveOne
                + ", reserveTwo=" + reserveTwo + ", reserveThree=" + reserveThree + ", reserveFour=" + reserveFour
                + ", reserveFive=" + reserveFive + ", createTime=" + createTime + "]";
    }
}
