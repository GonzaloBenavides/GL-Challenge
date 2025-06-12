package cl.benavidesgonzalo.globallogic.desafiobci.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Integer> phones;
    @Column(updatable = false)
    private Date createdAt;
    @Column(updatable = false)
    private Date lastLogin;
    @Column
    private Boolean isActive;
    
    @Column
    private String token;

    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
    public List<Integer> getPhones() {
        return phones;
    }
    public void setPhones(List<Integer> phones) {
        this.phones = phones;
    }
    
    
}
