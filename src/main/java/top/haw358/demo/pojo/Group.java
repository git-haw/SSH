package top.haw358.demo.pojo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by haw on 17-6-6.
 */
@Entity
@Table(name = "t_group")
public class Group{
    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private Integer id;

    @Column(length = 20)
    private String name;

    @Column(length = 50)
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    private Set<User> userSet = new HashSet<User>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    private Set<Role> roleSet = new HashSet<Role>();


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
