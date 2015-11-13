package tr.bel.pendik.aquilamonitor.data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by moyavuz on 08.10.2015.
 */
@Entity
@Table(name = "server")
public class ServerEntity {
    private Long id;
    private String desc;
    private Long serverTypeId;
    private Long cpuTypeId;
    private Long ipAddressId;
    private Long parentId;
    private Long osId;
    private String hostname;
    private String location;
    private Integer ramsize;
    private Integer harddisksize;
    private Boolean isBackupNeeded;
    private Boolean isMonitorNeeded;
    private Boolean status;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private String managerUsername;
    private String managerPassword;
    private IpAddressEntity ipAddressByIpAddressId;
    private OsEntity osByOsId;
    private ServerEntity serverByParentId;
    private ServerTypeEntity serverTypeByServerTypeId;
    private CpuTypeEntity cpuTypeByCpuTypeId;
    //   private Collection<ServerEntity> serversById;
//   private Collection<ResponsibleEntity> responsiblesById;
    //   private Collection<ServerProgramEntity> serverProgramsById;

    @Id
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_SERVER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "desc", nullable = false, insertable = true, updatable = true, length = 255)
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Basic
    @Column(name = "server_type_id", nullable = true, insertable = false, updatable = false)
    public Long getServerTypeId() {
        return serverTypeId;
    }

    public void setServerTypeId(Long serverTypeId) {
        this.serverTypeId = serverTypeId;
    }

    @Basic
    @Column(name = "cpu_type_id", nullable = true, insertable = false, updatable = false)
    public Long getCpuTypeId() {
        return cpuTypeId;
    }

    public void setCpuTypeId(Long cpuTypeId) {
        this.cpuTypeId = cpuTypeId;
    }


    @Basic
    @Column(name = "ip_address_id", nullable = true, insertable = false, updatable = false)
    public Long getIpAddressId() {
        return ipAddressId;
    }

    public void setIpAddressId(Long ipAddressId) {
        this.ipAddressId = ipAddressId;
    }


    @Basic
    @Column(name = "parent_id", nullable = true, insertable = false, updatable = false)
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "os_id", nullable = true, insertable = false, updatable = false)
    public Long getOsId() {
        return osId;
    }

    public void setOsId(Long osId) {
        this.osId = osId;
    }

    @Basic
    @Column(name = "hostname", nullable = true, insertable = true, updatable = true, length = 255)
    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    @Basic
    @Column(name = "location", nullable = true, insertable = true, updatable = true, length = 255)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "ramsize", nullable = true, insertable = true, updatable = true)
    public Integer getRamsize() {
        return ramsize;
    }

    public void setRamsize(Integer ramsize) {
        this.ramsize = ramsize;
    }

    @Basic
    @Column(name = "harddisksize", nullable = true, insertable = true, updatable = true)
    public Integer getHarddisksize() {
        return harddisksize;
    }

    public void setHarddisksize(Integer harddisksize) {
        this.harddisksize = harddisksize;
    }

    @Basic
    @Column(name = "is_backup_needed", nullable = true, insertable = true, updatable = true)
    public Boolean getIsBackupNeeded() {
        return isBackupNeeded;
    }

    public void setIsBackupNeeded(Boolean isBackupNeeded) {
        this.isBackupNeeded = isBackupNeeded;
    }

    @Basic
    @Column(name = "is_monitor_needed", nullable = true, insertable = true, updatable = true)
    public Boolean getIsMonitorNeeded() {
        return isMonitorNeeded;
    }

    public void setIsMonitorNeeded(Boolean isMonitorNeeded) {
        this.isMonitorNeeded = isMonitorNeeded;
    }

    @Basic
    @Column(name = "status", nullable = true, insertable = true, updatable = true)
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Basic
    @Column(name = "created_date", nullable = true, insertable = false, updatable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Basic
    @Column(name = "updated_date", nullable = true, insertable = false, updatable = false)
    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Basic
    @Column(name = "manager_username", nullable = true, insertable = true, updatable = true, length = 50)
    public String getManagerUsername() {
        return managerUsername;
    }

    public void setManagerUsername(String managerUsername) {
        this.managerUsername = managerUsername;
    }

    @Basic
    @Column(name = "manager_password", nullable = true, insertable = true, updatable = true, length = 50)
    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServerEntity that = (ServerEntity) o;

        if (id != that.id) return false;
        if (serverTypeId != that.serverTypeId) return false;
        if (cpuTypeId != that.cpuTypeId) return false;
        if (ipAddressId != that.ipAddressId) return false;
        if (desc != null ? !desc.equals(that.desc) : that.desc != null) return false;
        if (parentId != null ? !parentId.equals(that.parentId) : that.parentId != null) return false;
        if (osId != null ? !osId.equals(that.osId) : that.osId != null) return false;
        if (hostname != null ? !hostname.equals(that.hostname) : that.hostname != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (ramsize != null ? !ramsize.equals(that.ramsize) : that.ramsize != null) return false;
        if (harddisksize != null ? !harddisksize.equals(that.harddisksize) : that.harddisksize != null) return false;
        if (isBackupNeeded != null ? !isBackupNeeded.equals(that.isBackupNeeded) : that.isBackupNeeded != null)
            return false;
        if (isMonitorNeeded != null ? !isMonitorNeeded.equals(that.isMonitorNeeded) : that.isMonitorNeeded != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (updatedDate != null ? !updatedDate.equals(that.updatedDate) : that.updatedDate != null) return false;
        if (managerUsername != null ? !managerUsername.equals(that.managerUsername) : that.managerUsername != null)
            return false;
        return !(managerPassword != null ? !managerPassword.equals(that.managerPassword) : that.managerPassword != null);
    }

    @Override
    public int hashCode() {
        int result = (id != null) ? id.intValue() : 0;
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (serverTypeId != null ? serverTypeId.hashCode() : 0);
        ;
        result = 31 * result + (ipAddressId != null ? ipAddressId.hashCode() : 0);
        ;
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (osId != null ? osId.hashCode() : 0);
        result = 31 * result + (hostname != null ? hostname.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (ramsize != null ? ramsize.hashCode() : 0);
        result = 31 * result + (harddisksize != null ? harddisksize.hashCode() : 0);
        result = 31 * result + (cpuTypeId != null ? cpuTypeId.hashCode() : 0);
        result = 31 * result + (isBackupNeeded != null ? isBackupNeeded.hashCode() : 0);
        result = 31 * result + (isMonitorNeeded != null ? isMonitorNeeded.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (updatedDate != null ? updatedDate.hashCode() : 0);
        result = 31 * result + (managerUsername != null ? managerUsername.hashCode() : 0);
        result = 31 * result + (managerPassword != null ? managerPassword.hashCode() : 0);
        return result;
    }

    /*   @OneToMany(mappedBy = "serverByServerId")
       public Collection<ResponsibleEntity> getResponsiblesById() {
           return responsiblesById;
       }

       public void setResponsiblesById(Collection<ResponsibleEntity> responsiblesById) {
           this.responsiblesById = responsiblesById;
       }
   */
    @ManyToOne
    @JoinColumn(name = "ip_address_id", referencedColumnName = "id")
    public IpAddressEntity getIpAddressByIpAddressId() {
        return ipAddressByIpAddressId;
    }

    public void setIpAddressByIpAddressId(IpAddressEntity ipAddressByIpAddressId) {
        this.ipAddressByIpAddressId = ipAddressByIpAddressId;
    }

    @ManyToOne
    @JoinColumn(name = "os_id", referencedColumnName = "id")
    public OsEntity getOsByOsId() {
        return osByOsId;
    }

    public void setOsByOsId(OsEntity osByOsId) {
        this.osByOsId = osByOsId;
    }

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    public ServerEntity getServerByParentId() {
        return serverByParentId;
    }

    public void setServerByParentId(ServerEntity serverByParentId) {
        this.serverByParentId = serverByParentId;
    }

 /*   @OneToMany(mappedBy = "serverByParentId")
    public Collection<ServerEntity> getServersById() {
        return serversById;
    }

    public void setServersById(Collection<ServerEntity> serversById) {
        this.serversById = serversById;
    }*/

    @ManyToOne
    @JoinColumn(name = "server_type_id", referencedColumnName = "id")
    public ServerTypeEntity getServerTypeByServerTypeId() {
        return serverTypeByServerTypeId;
    }

    public void setServerTypeByServerTypeId(ServerTypeEntity serverTypeByServerTypeId) {
        this.serverTypeByServerTypeId = serverTypeByServerTypeId;
    }


    @ManyToOne
    @JoinColumn(name = "cpu_type_id", referencedColumnName = "id")
    public CpuTypeEntity getCpuTypeByCpuTypeId() {
        return cpuTypeByCpuTypeId;
    }

    public void setCpuTypeByCpuTypeId(CpuTypeEntity cpuTypeByCpuTypeId) {
        this.cpuTypeByCpuTypeId = cpuTypeByCpuTypeId;
    }


  /*  @OneToMany(mappedBy = "serverByServerId")
    public Collection<ServerProgramEntity> getServerProgramsById() {
        return serverProgramsById;
    }

    public void setServerProgramsById(Collection<ServerProgramEntity> serverProgramsById) {
        this.serverProgramsById = serverProgramsById;
    }*/
}
