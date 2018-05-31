package org.ms.module.ablecloud;

import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @Author SuperAndy
 * @Date 2018-05-30 15:47
 */
@Alias("bewinchDeviceInfo")
public class BewinchDeviceInfo {
    private String physicalId;
    private Long logicId;
    private String majorDomain;
    private String subDomain;
    private String subDomainName;
    private String devVersion;
    private String modVersion;
    private String ipAddress;
    private String macAddress;
    private LocalDateTime activeTime;
    private String country;
    private String province;
    private String city;
    private String street;
    private LocalDateTime lastOnlineTime;
    private Integer status;// 激活状态
    private String acType;
    private String onlineStatus;
    private Integer deviceDefineId;
    private LocalDateTime createTime;

    public String getPhysicalId() {
        return physicalId;
    }

    public void setPhysicalId(String physicalId) {
        this.physicalId = physicalId;
    }

    public Long getLogicId() {
        return logicId;
    }

    public void setLogicId(Long logicId) {
        this.logicId = logicId;
    }

    public String getMajorDomain() {
        return majorDomain;
    }

    public void setMajorDomain(String majorDomain) {
        this.majorDomain = majorDomain;
    }

    public String getSubDomain() {
        return subDomain;
    }

    public void setSubDomain(String subDomain) {
        this.subDomain = subDomain;
    }

    public String getSubDomainName() {
        return subDomainName;
    }

    public void setSubDomainName(String subDomainName) {
        this.subDomainName = subDomainName;
    }

    public String getDevVersion() {
        return devVersion;
    }

    public void setDevVersion(String devVersion) {
        this.devVersion = devVersion;
    }

    public String getModVersion() {
        return modVersion;
    }

    public void setModVersion(String modVersion) {
        this.modVersion = modVersion;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public LocalDateTime getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(LocalDateTime activeTime) {
        this.activeTime = activeTime;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public LocalDateTime getLastOnlineTime() {
        return lastOnlineTime;
    }

    public void setLastOnlineTime(LocalDateTime lastOnlineTime) {
        this.lastOnlineTime = lastOnlineTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAcType() {
        return acType;
    }

    public void setAcType(String acType) {
        this.acType = acType;
    }

    public String getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(String onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public Integer getDeviceDefineId() {
        return deviceDefineId;
    }

    public void setDeviceDefineId(Integer deviceDefineId) {
        this.deviceDefineId = deviceDefineId;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    @Override
    public String toString() {
        return "DeviceInfo [physicalId=" + physicalId + ", logicId=" + logicId + ", majorDomain=" + majorDomain
                + ", subDomain=" + subDomain + ", subDomainName=" + subDomainName + ", devVersion=" + devVersion
                + ", modVersion=" + modVersion + ", ipAddress=" + ipAddress + ", macAddress=" + macAddress
                + ", activeTime=" + activeTime + ", country=" + country + ", province=" + province + ", city=" + city
                + ", street=" + street + ", lastOnlineTime=" + lastOnlineTime + ", status=" + status + ", acType="
                + acType + ", onlineStatus=" + onlineStatus + ", deviceDefineId=" + deviceDefineId + ", createTime="
                + createTime + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this != obj) {
            return false;
        }
        if (null == obj) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        BewinchDeviceInfo bewinchDeviceInfo = (BewinchDeviceInfo) obj;

        return Objects.equals(physicalId, bewinchDeviceInfo.physicalId)
                && Objects.equals(majorDomain, bewinchDeviceInfo.majorDomain)
                && Objects.equals(subDomain, bewinchDeviceInfo.subDomain)
                && Objects.equals(devVersion, bewinchDeviceInfo.devVersion)
                && Objects.equals(modVersion, bewinchDeviceInfo.modVersion)
                && Objects.equals(ipAddress, bewinchDeviceInfo.ipAddress)
                && Objects.equals(macAddress, bewinchDeviceInfo.macAddress)
                && (activeTime != null && bewinchDeviceInfo.activeTime != null)
                ? activeTime.compareTo(bewinchDeviceInfo.activeTime) == 0
                : (activeTime == null && bewinchDeviceInfo.activeTime == null)
                && Objects.equals(country, bewinchDeviceInfo.country)
                && Objects.equals(province, bewinchDeviceInfo.province)
                && Objects.equals(city, bewinchDeviceInfo.city)
                && Objects.equals(street, bewinchDeviceInfo.street)
                && (lastOnlineTime != null && bewinchDeviceInfo.lastOnlineTime != null)
                ? lastOnlineTime.compareTo(bewinchDeviceInfo.lastOnlineTime) == 0
                : (lastOnlineTime == null && bewinchDeviceInfo.lastOnlineTime == null)
                && Objects.equals(status, bewinchDeviceInfo.status)
                && Objects.equals(acType, bewinchDeviceInfo.acType)
                && Objects.equals(logicId, bewinchDeviceInfo.logicId)
                && Objects.equals(subDomainName, bewinchDeviceInfo.subDomainName)
                && Objects.equals(deviceDefineId, bewinchDeviceInfo.deviceDefineId);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((physicalId == null) ? 0 : physicalId.hashCode());
        return result;
    }
}
