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
@Table(name = "t_role")
public class Role{
    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private Integer id;

    @Column(length = 20)
    private String role;

    @Column(length = 50)
    private String description;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;


    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private Set<Menu> menuSet = new HashSet<Menu>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Set<Menu> getMenuSet() {
        return menuSet;
    }

    public void setMenuSet(Set<Menu> menuSet) {
        this.menuSet = menuSet;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
