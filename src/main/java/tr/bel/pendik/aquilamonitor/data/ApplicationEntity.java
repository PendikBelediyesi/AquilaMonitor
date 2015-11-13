package tr.bel.pendik.aquilamonitor.data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by moyavuz on 08.10.2015.
 */
@Entity
@javax.persistence.Table(name = "application")
public class ApplicationEntity {
    private Long id;
    private String desc;
    private Long parentId;
    private Long applicationTypeId;
    private Long serverProgramId;
    private String version;
    private String serviceName;
    private Integer port;
    private String path;
    private String url;
    private String managerUsername;
    private String managerPassword;
    private Boolean isBackupNeeded;
    private Boolean isMonitorNeeded;
    private Boolean status;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private ApplicationTypeEntity applicationTypeByApplicationTypeId;
    private ApplicationEntity applicationByParentId;
    private ServerProgramEntity serverProgramByServerProgramId;

    @ManyToOne
    @JoinColumn(name = "application_type_id", referencedColumnName = "id")
    public ApplicationTypeEntity getApplicationTypeByApplicationTypeId() {
        return applicationTypeByApplicationTypeId;
    }

    public void setApplicationTypeByApplicationTypeId(ApplicationTypeEntity applicationTypeByApplicationTypeId) {
        this.applicationTypeByApplicationTypeId = applicationTypeByApplicationTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "server_program_id", referencedColumnName = "id")
    public ServerProgramEntity getServerProgramByServerProgramId() {
        return serverProgramByServerProgramId;
    }

    public void setServerProgramByServerProgramId(ServerProgramEntity serverProgramByServerProgramId) {
        this.serverProgramByServerProgramId = serverProgramByServerProgramId;
    }

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    public ApplicationEntity getApplicationByParentId() {
        return applicationByParentId;
    }

    public void setApplicationByParentId(ApplicationEntity applicationByParentId) {
        this.applicationByParentId = applicationByParentId;
    }

    @Id
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_APPLICATION", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @javax.persistence.Column(name = "desc", nullable = false, insertable = true, updatable = true, length = 255)
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Basic
    @javax.persistence.Column(name = "parent_id", nullable = true, insertable = false, updatable = false)
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Basic
    @javax.persistence.Column(name = "application_type_id", nullable = true, insertable = false, updatable = false)
    public Long getApplicationTypeId() {
        return applicationTypeId;
    }

    public void setApplicationTypeId(Long applicationTypeId) {
        this.applicationTypeId = applicationTypeId;
    }

    @Basic
    @javax.persistence.Column(name = "server_program_id", nullable = true, insertable = false, updatable = false)
    public Long getServerProgramId() {
        return serverProgramId;
    }

    public void setServerProgramId(Long serverProgramId) {
        this.serverProgramId = serverProgramId;
    }

    @Basic
    @javax.persistence.Column(name = "version", nullable = true, insertable = true, updatable = true, length = 255)
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Basic
    @javax.persistence.Column(name = "service_name", nullable = true, insertable = true, updatable = true, length = 255)
    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Basic
    @javax.persistence.Column(name = "port", nullable = true, insertable = true, updatable = true)
    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    @Basic
    @javax.persistence.Column(name = "path", nullable = true, insertable = true, updatable = true, length = 255)
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Basic
    @javax.persistence.Column(name = "url", nullable = true, insertable = true, updatable = true, length = 255)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @javax.persistence.Column(name = "manager_username", nullable = true, insertable = true, updatable = true, length = 50)
    public String getManagerUsername() {
        return managerUsername;
    }

    public void setManagerUsername(String managerUsername) {
        this.managerUsername = managerUsername;
    }

    @Basic
    @javax.persistence.Column(name = "manager_password", nullable = true, insertable = true, updatable = true, length = 50)
    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }

    @Basic
    @javax.persistence.Column(name = "is_backup_needed", nullable = true, insertable = true, updatable = true)
    public Boolean getIsBackupNeeded() {
        return isBackupNeeded;
    }

    public void setIsBackupNeeded(Boolean isBackupNeeded) {
        this.isBackupNeeded = isBackupNeeded;
    }

    @Basic
    @javax.persistence.Column(name = "is_monitor_needed", nullable = true, insertable = true, updatable = true)
    public Boolean getIsMonitorNeeded() {
        return isMonitorNeeded;
    }

    public void setIsMonitorNeeded(Boolean isMonitorNeeded) {
        this.isMonitorNeeded = isMonitorNeeded;
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

        ApplicationEntity that = (ApplicationEntity) o;

        if (id != that.id) return false;
        if (desc != null ? !desc.equals(that.desc) : that.desc != null) return false;
        if (parentId != null ? !parentId.equals(that.parentId) : that.parentId != null) return false;
        if (applicationTypeId != null ? !applicationTypeId.equals(that.applicationTypeId) : that.applicationTypeId != null)
            return false;
        if (serverProgramId != null ? !serverProgramId.equals(that.serverProgramId) : that.serverProgramId != null)
            return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;
        if (serviceName != null ? !serviceName.equals(that.serviceName) : that.serviceName != null) return false;
        if (port != null ? !port.equals(that.port) : that.port != null) return false;
        if (path != null ? !path.equals(that.path) : that.path != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (managerUsername != null ? !managerUsername.equals(that.managerUsername) : that.managerUsername != null)
            return false;
        if (managerPassword != null ? !managerPassword.equals(that.managerPassword) : that.managerPassword != null)
            return false;
        if (isBackupNeeded != null ? !isBackupNeeded.equals(that.isBackupNeeded) : that.isBackupNeeded != null)
            return false;
        if (isMonitorNeeded != null ? !isMonitorNeeded.equals(that.isMonitorNeeded) : that.isMonitorNeeded != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        return !(updatedDate != null ? !updatedDate.equals(that.updatedDate) : that.updatedDate != null);

    }

    @Override
    public int hashCode() {
        int result = (id != null) ? id.intValue() : 0;
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (applicationTypeId != null ? applicationTypeId.hashCode() : 0);
        result = 31 * result + (serverProgramId != null ? serverProgramId.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (serviceName != null ? serviceName.hashCode() : 0);
        result = 31 * result + (port != null ? port.hashCode() : 0);
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (managerUsername != null ? managerUsername.hashCode() : 0);
        result = 31 * result + (managerPassword != null ? managerPassword.hashCode() : 0);
        result = 31 * result + (isBackupNeeded != null ? isBackupNeeded.hashCode() : 0);
        result = 31 * result + (isMonitorNeeded != null ? isMonitorNeeded.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (updatedDate != null ? updatedDate.hashCode() : 0);
        return result;
    }
}
