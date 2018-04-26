package erik.soekov.astendor.security.models;

import erik.soekov.astendor.security.dtos.UserDTO;

import javax.persistence.*;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "active")
    private Integer active;
    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    @ManyToMany(cascade = {}, fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private Set<Role> roles;

    public User() {
    }

    public User(UserDTO userDTO){
        this.username = userDTO.getUsername();
        this.password = userDTO.getPassword();
        this.email = userDTO.getEmail();
        this.active = 1;
        this.roles = new TreeSet<>();
        roles.add(new Role(2, "STANDARD"));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
