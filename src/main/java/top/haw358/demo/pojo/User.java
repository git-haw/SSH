package top.haw358.demo.pojo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_user")
public class User{
    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private Integer id;

    @Column(nullable = false, length = 20, unique = true)
    private String name;

    @Column(nullable = false, length = 11, unique = true)
    private String phone;

    @Column(nullable = false, length = 30, unique = true)
    private String email;

    @Column(nullable = false, length = 20)
    private String password;

    private Boolean enabled;

    @Temporal(TemporalType.TIMESTAMP)
    @JoinColumn(name = "create_time", nullable = false)
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    @JoinColumn(name = "modify_time")
    private Date modifyTime;

    @Temporal(TemporalType.TIMESTAMP)
    @JoinColumn(name = "last_login")
    private Date lastLogin;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    private Group group;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}