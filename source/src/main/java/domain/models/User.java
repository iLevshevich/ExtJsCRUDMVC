package domain.models;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * Created by levshevich_i on 21.10.15.
 */
@Entity
@Table(name = "Users")
/*
TABLE [dbo].[Users](
	[id] [uniqueidentifier] NOT NULL,
	[firstname] [nchar](30) NOT NULL,
	[lastname] [nchar](30) NOT NULL,
	[telephone] [nchar](15) NOT NULL,
	[email] [nchar](30) NOT NULL,
	[password] [nchar](100) NOT NULL,
	[created] [datetime] NOT NULL,
	[modified] [datetime] NOT NULL
 */
public class User implements Serializable {
    @Id
    @Column(name = "id", columnDefinition="uniqueidentifier", nullable=false)
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    private String id;

    @Column(name = "firstname", nullable=false)
    private String firstname;

    @Column(name = "lastname", nullable=false)
    private String lastname;

    @Column(name = "email", nullable=false)
    private String email;

    @Column(name = "telephone", nullable=false)
    private String telephone;

    @Column(name = "password", nullable=false)
    private String password;

    @Column(name = "created", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    @Generated(value = GenerationTime.INSERT)
    private Date created;

    @Column(name = "modified", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    @Generated(value = GenerationTime.ALWAYS)
    private Date modified;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id.trim();
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname.trim();
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname.trim();
    }

    public String getEmail() {
        return email.trim();
    }

    public void setEmail(String email) {
        this.email = email.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public static User getUser(Map<String,? extends Object> data)
    {
        User result = new User();
        {
            result.id = (String) data.get("id");
            result.firstname = (String) data.get("firstname");
            result.lastname = (String) data.get("lastname");
            result.email = (String) data.get("email");
            result.telephone = (String) data.get("telephone");
            result.password = (String) data.get("password");

            if(data.get("created") != null){
                result.created = new Date(Long.parseLong((String)data.get("created")));
            }

            if(data.get("modified") != null){
                result.setModified(new Date(Long.parseLong((String)data.get("modified"))));
            }
        }
        return result;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
}
