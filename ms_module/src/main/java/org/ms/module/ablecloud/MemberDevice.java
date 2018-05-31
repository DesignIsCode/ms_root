package org.ms.module.ablecloud;

import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;

/**
 * @Author SuperAndy
 * @Date 2018-05-30 15:49
 */
@Alias("memberDevice")
public class MemberDevice {
    private Long id;
    private Long gatewayDeviceId;
    private String name;
    private Long owner;
    private String physicalId;
    private Long rootId;
    private Long status;
    private Long subDomainId;
    private String subDomainName;
    private LocalDateTime createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGatewayDeviceId() {
        return gatewayDeviceId;
    }

    public void setGatewayDeviceId(Long gatewayDeviceId) {
        this.gatewayDeviceId = gatewayDeviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getOwner() {
        return owner;
    }

    public void setOwner(Long owner) {
        this.owner = owner;
    }

    public String getPhysicalId() {
        return physicalId;
    }

    public void setPhysicalId(String physicalId) {
        this.physicalId = physicalId;
    }

    public Long getRootId() {
        return rootId;
    }

    public void setRootId(Long rootId) {
        this.rootId = rootId;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getSubDomainId() {
        return subDomainId;
    }

    public void setSubDomainId(Long subDomainId) {
        this.subDomainId = subDomainId;
    }

    public String getSubDomainName() {
        return subDomainName;
    }

    public void setSubDomainName(String subDomainName) {
        this.subDomainName = subDomainName;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    @Override
    public String toString() {
        return "MemberDevice [id=" + id + ", gatewayDeviceId=" + gatewayDeviceId + ", name=" + name + ", owner=" + owner
                + ", physicalId=" + physicalId + ", rootId=" + rootId + ", status=" + status + ", subDomainId="
                + subDomainId + ", subDomainName=" + subDomainName + ", createTime=" + createTime + "]";
    }
}
