package tr.bel.pendik.aquilamonitor.data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by moyavuz on 08.10.2015.
 */
@Entity
@Table(name = "server_program")
public class ServerProgramEntity {
    private Long id;
    private String desc;
    private Long serverId;
    private Long programId;
    private String managerUsername;
    private String managerPassord;
    private Boolean isBackupNeeded;
    private Boolean isMonitorNeeded;
    private Boolean status;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private Collection<ResponsibleEntity> responsiblesById;
    private ProgramEntity programByProgramId;
    private ServerEntity serverByServerId;

    @Id
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_SERVER_PROGRAM", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "desc", nullable = true, insertable = true, updatable = true, length = 255)
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Basic
    @Column(name = "server_id", nullable = true, insertable = false, updatable = false)
    public Long getServerId() {
        return serverId;
    }

    public void setServerId(Long serverId) {
        this.serverId = serverId;
    }

    @Basic
    @Column(name = "program_id", nullable = true, insertable = false, updatable = false)
    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
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
    public String getManagerPassord() {
        return managerPassord;
    }

    public void setManagerPassord(String managerPassord) {
        this.managerPassord = managerPassord;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServerProgramEntity that = (ServerProgramEntity) o;

        if (id != that.id) return false;
        if (desc != null ? !desc.equals(that.desc) : that.desc != null) return false;
        if (serverId != null ? !serverId.equals(that.serverId) : that.serverId != null) return false;
        if (programId != null ? !programId.equals(that.programId) : that.programId != null) return false;
        if (managerUsername != null ? !managerUsername.equals(that.managerUsername) : that.managerUsername != null)
            return false;
        if (managerPassord != null ? !managerPassord.equals(that.managerPassord) : that.managerPassord != null)
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
        result = 31 * result + (serverId != null ? serverId.hashCode() : 0);
        result = 31 * result + (programId != null ? programId.hashCode() : 0);
        result = 31 * result + (managerUsername != null ? managerUsername.hashCode() : 0);
        result = 31 * result + (managerPassord != null ? managerPassord.hashCode() : 0);
        result = 31 * result + (isBackupNeeded != null ? isBackupNeeded.hashCode() : 0);
        result = 31 * result + (isMonitorNeeded != null ? isMonitorNeeded.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (updatedDate != null ? updatedDate.hashCode() : 0);
        return result;
    }

    /*   @OneToMany(mappedBy = "serverProgramByServerProgramId")
       public Collection<ResponsibleEntity> getResponsiblesById() {
           return responsiblesById;
       }

       public void setResponsiblesById(Collection<ResponsibleEntity> responsiblesById) {
           this.responsiblesById = responsiblesById;
       }
   */
    @ManyToOne
    @JoinColumn(name = "program_id", referencedColumnName = "id")
    public ProgramEntity getProgramByProgramId() {
        return programByProgramId;
    }

    public void setProgramByProgramId(ProgramEntity programByProgramId) {
        this.programByProgramId = programByProgramId;
    }

    @ManyToOne
    @JoinColumn(name = "server_id", referencedColumnName = "id")
    public ServerEntity getServerByServerId() {
        return serverByServerId;
    }

    public void setServerByServerId(ServerEntity serverByServerId) {
        this.serverByServerId = serverByServerId;
    }
}
