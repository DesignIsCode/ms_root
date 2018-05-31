package org.ms.module.common;

/**
 * @Author SuperAndy
 * @Date 2018-05-30 15:01
 * 会员基本信息
 */
public class Member {
    private Long id;
    private String phone;
    private String name;
    private String country;
    private String province;
    private String addr;
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Member [id=" + id + ", phone=" + phone + ", name=" + name + ", country=" + country + ", province="
                + province + ", addr=" + addr + ", email=" + email + "]";
    }
}
