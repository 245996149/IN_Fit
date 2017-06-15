package cn.infit.ll.dbentity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by kaxia on 2017/6/14.
 */
@Entity
@Table(name = "users", schema = "IN_Fit", catalog = "")
public class UsersEntity {
    private long id;
    private String userPhone;
    private String userPass;
    private String userEmail;
    private Timestamp createTime;
    private int userStatus;
    private Date birthday;
    private String wechatOpenid;
    private String wechatNickname;
    private String wechatCity;
    private String wechatProvince;
    private String wechatHeadimgurl;
    private String sex;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_phone")
    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Basic
    @Column(name = "user_pass")
    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    @Basic
    @Column(name = "user_email")
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "create_time")
    @CreationTimestamp
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "user_status")
    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    @Basic
    @Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "wechat_openid")
    public String getWechatOpenid() {
        return wechatOpenid;
    }

    public void setWechatOpenid(String wechatOpenid) {
        this.wechatOpenid = wechatOpenid;
    }


    @Basic
    @Column(name = "wechat_nickname")
    public String getWechatNickname() {
        return wechatNickname;
    }

    public void setWechatNickname(String wechatNickname) {
        this.wechatNickname = wechatNickname;
    }

    @Basic
    @Column(name = "wechat_city")
    public String getWechatCity() {
        return wechatCity;
    }

    public void setWechatCity(String wechatCity) {
        this.wechatCity = wechatCity;
    }

    @Basic
    @Column(name = "wechat_province")
    public String getWechatProvince() {
        return wechatProvince;
    }

    public void setWechatProvince(String wechatProvince) {
        this.wechatProvince = wechatProvince;
    }

    @Basic
    @Column(name = "wechat_headimgurl")
    public String getWechatHeadimgurl() {
        return wechatHeadimgurl;
    }

    public void setWechatHeadimgurl(String wechatHeadimgurl) {
        this.wechatHeadimgurl = wechatHeadimgurl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (id != that.id) return false;
        if (userStatus != that.userStatus) return false;
        if (userPhone != null ? !userPhone.equals(that.userPhone) : that.userPhone != null) return false;
        if (userPass != null ? !userPass.equals(that.userPass) : that.userPass != null) return false;
        if (userEmail != null ? !userEmail.equals(that.userEmail) : that.userEmail != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (wechatOpenid != null ? !wechatOpenid.equals(that.wechatOpenid) : that.wechatOpenid != null) return false;
        if (wechatNickname != null ? !wechatNickname.equals(that.wechatNickname) : that.wechatNickname != null)
            return false;
        if (wechatCity != null ? !wechatCity.equals(that.wechatCity) : that.wechatCity != null) return false;
        if (wechatProvince != null ? !wechatProvince.equals(that.wechatProvince) : that.wechatProvince != null)
            return false;
        if (wechatHeadimgurl != null ? !wechatHeadimgurl.equals(that.wechatHeadimgurl) : that.wechatHeadimgurl != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (userPhone != null ? userPhone.hashCode() : 0);
        result = 31 * result + (userPass != null ? userPass.hashCode() : 0);
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + userStatus;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (wechatOpenid != null ? wechatOpenid.hashCode() : 0);
        result = 31 * result + (wechatNickname != null ? wechatNickname.hashCode() : 0);
        result = 31 * result + (wechatCity != null ? wechatCity.hashCode() : 0);
        result = 31 * result + (wechatProvince != null ? wechatProvince.hashCode() : 0);
        result = 31 * result + (wechatHeadimgurl != null ? wechatHeadimgurl.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UsersEntity{" +
                "id=" + id +
                ", userPhone='" + userPhone + '\'' +
                ", userPass='" + userPass + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", createTime=" + createTime +
                ", userStatus=" + userStatus +
                ", birthday=" + birthday +
                ", wechatOpenid='" + wechatOpenid + '\'' +
                ", wechatNickname='" + wechatNickname + '\'' +
                ", wechatCity='" + wechatCity + '\'' +
                ", wechatProvince='" + wechatProvince + '\'' +
                ", wechatHeadimgurl='" + wechatHeadimgurl + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
