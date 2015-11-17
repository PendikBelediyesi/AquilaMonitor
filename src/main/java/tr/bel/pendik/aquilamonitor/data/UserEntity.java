package tr.bel.pendik.aquilamonitor.data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;

/**
 * Created by moyavuz on 08.10.2015.
 */
@Entity
@javax.persistence.Table(name = "user")
public class UserEntity {
    private Long id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private Long callnumber;
    private String email;
    private String position;
    private Long roleId;
    private byte[] image;
    private Boolean isServerResponsible;
    private Boolean isProgramResponsible;
    private Boolean isServerProgramResponsible;
    private Boolean isApplicationResponsible;
    private Boolean isLogin;
    private Boolean isSendInfoEmail;
    private Boolean isSendInfoSms;
    private String lastLoginIp;
    private Timestamp lastLoginDate;
    private Boolean status;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private RoleEntity roleByRoleId;

    @Id
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_USER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    public RoleEntity getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(RoleEntity roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }

    @Basic
    @javax.persistence.Column(name = "name", nullable = false, insertable = true, updatable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @javax.persistence.Column(name = "surname", nullable = true, insertable = true, updatable = true, length = 255)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @javax.persistence.Column(name = "username", nullable = true, insertable = true, updatable = true, length = 50)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @javax.persistence.Column(name = "password", nullable = true, insertable = true, updatable = true, length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @javax.persistence.Column(name = "callnumber", nullable = true, insertable = true, updatable = true)
    public Long getCallnumber() {
        return callnumber;
    }

    public void setCallnumber(Long callnumber) {
        this.callnumber = callnumber;
    }

    @Basic
    @javax.persistence.Column(name = "email", nullable = false, insertable = true, updatable = true, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @javax.persistence.Column(name = "position", nullable = true, insertable = true, updatable = true, length = 50)
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Basic
    @Column(name = "role_id", nullable = true, insertable = false, updatable = false)
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Basic
    @javax.persistence.Column(name = "image", nullable = true, insertable = true, updatable = true)
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Basic
    @javax.persistence.Column(name = "is_server_responsible", nullable = true, insertable = true, updatable = true)
    public Boolean getIsServerResponsible() {
        return isServerResponsible;
    }

    public void setIsServerResponsible(Boolean isServerResponsible) {
        this.isServerResponsible = isServerResponsible;
    }

    @Basic
    @javax.persistence.Column(name = "is_program_responsible", nullable = true, insertable = true, updatable = true)
    public Boolean getIsProgramResponsible() {
        return isProgramResponsible;
    }

    public void setIsProgramResponsible(Boolean isProgramResponsible) {
        this.isProgramResponsible = isProgramResponsible;
    }

    @Basic
    @javax.persistence.Column(name = "is_server_program_responsible", nullable = true, insertable = true, updatable = true)
    public Boolean getIsServerProgramResponsible() {
        return isServerProgramResponsible;
    }

    public void setIsServerProgramResponsible(Boolean isServerProgramResponsible) {
        this.isServerProgramResponsible = isServerProgramResponsible;
    }

    @Basic
    @javax.persistence.Column(name = "is_application_responsible", nullable = true, insertable = true, updatable = true)
    public Boolean getIsApplicationResponsible() {
        return isApplicationResponsible;
    }

    public void setIsApplicationResponsible(Boolean isApplicationResponsible) {
        this.isApplicationResponsible = isApplicationResponsible;
    }

    @Basic
    @javax.persistence.Column(name = "is_login", nullable = true, insertable = true, updatable = true)
    public Boolean getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(Boolean isLogin) {
        this.isLogin = isLogin;
    }

    @Basic
    @javax.persistence.Column(name = "is_send_info_email", nullable = true, insertable = true, updatable = true)
    public Boolean getIsSendInfoEmail() {
        return isSendInfoEmail;
    }

    public void setIsSendInfoEmail(Boolean isSendInfoEmail) {
        this.isSendInfoEmail = isSendInfoEmail;
    }

    @Basic
    @javax.persistence.Column(name = "is_send_info_sms", nullable = true, insertable = true, updatable = true)
    public Boolean getIsSendInfoSms() {
        return isSendInfoSms;
    }

    public void setIsSendInfoSms(Boolean isSendInfoSms) {
        this.isSendInfoSms = isSendInfoSms;
    }

    @Basic
    @javax.persistence.Column(name = "last_login_ip", nullable = true, insertable = true, updatable = true, length = 20)
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    @Basic
    @javax.persistence.Column(name = "last_login_date", nullable = true, insertable = true, updatable = true)
    public Timestamp getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Timestamp lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    @Basic
    @javax.persistence.Column(name = "status", nullable = true, insertable = true, updatable = true)
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Basic
    @javax.persistence.Column(name = "created_date", nullable = true, insertable = false, updatable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Basic
    @javax.persistence.Column(name = "updated_date", nullable = true, insertable = false, updatable = false)
    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (callnumber != null ? !callnumber.equals(that.callnumber) : that.callnumber != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (position != null ? !position.equals(that.position) : that.position != null) return false;
        if (!Arrays.equals(image, that.image)) return false;
        if (isServerResponsible != null ? !isServerResponsible.equals(that.isServerResponsible) : that.isServerResponsible != null)
            return false;
        if (isProgramResponsible != null ? !isProgramResponsible.equals(that.isProgramResponsible) : that.isProgramResponsible != null)
            return false;
        if (isServerProgramResponsible != null ? !isServerProgramResponsible.equals(that.isServerProgramResponsible) : that.isServerProgramResponsible != null)
            return false;
        if (isApplicationResponsible != null ? !isApplicationResponsible.equals(that.isApplicationResponsible) : that.isApplicationResponsible != null)
            return false;
        if (isLogin != null ? !isLogin.equals(that.isLogin) : that.isLogin != null) return false;
        if (isSendInfoEmail != null ? !isSendInfoEmail.equals(that.isSendInfoEmail) : that.isSendInfoEmail != null)
            return false;
        if (isSendInfoSms != null ? !isSendInfoSms.equals(that.isSendInfoSms) : that.isSendInfoSms != null)
            return false;
        if (lastLoginIp != null ? !lastLoginIp.equals(that.lastLoginIp) : that.lastLoginIp != null) return false;
        if (lastLoginDate != null ? !lastLoginDate.equals(that.lastLoginDate) : that.lastLoginDate != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        return !(updatedDate != null ? !updatedDate.equals(that.updatedDate) : that.updatedDate != null);

    }

    @Override
    public int hashCode() {
        int result = (id != null) ? id.intValue() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (callnumber != null ? callnumber.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (image != null ? Arrays.hashCode(image) : 0);
        result = 31 * result + (isServerResponsible != null ? isServerResponsible.hashCode() : 0);
        result = 31 * result + (isProgramResponsible != null ? isProgramResponsible.hashCode() : 0);
        result = 31 * result + (isServerProgramResponsible != null ? isServerProgramResponsible.hashCode() : 0);
        result = 31 * result + (isApplicationResponsible != null ? isApplicationResponsible.hashCode() : 0);
        result = 31 * result + (isLogin != null ? isLogin.hashCode() : 0);
        result = 31 * result + (isSendInfoEmail != null ? isSendInfoEmail.hashCode() : 0);
        result = 31 * result + (isSendInfoSms != null ? isSendInfoSms.hashCode() : 0);
        result = 31 * result + (lastLoginIp != null ? lastLoginIp.hashCode() : 0);
        result = 31 * result + (lastLoginDate != null ? lastLoginDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (updatedDate != null ? updatedDate.hashCode() : 0);
        return result;
    }
}
