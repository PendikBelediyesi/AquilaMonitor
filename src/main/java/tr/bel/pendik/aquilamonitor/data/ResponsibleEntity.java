package tr.bel.pendik.aquilamonitor.data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by moyavuz on 08.10.2015.
 */
@Entity
@Table(name = "responsible")
public class ResponsibleEntity {
    private Long id;
    private Long userId;
    private Long serverId;
    private Long programId;
    private Long serverProgramId;
    private Long applicationId;
    private Boolean status;
    private Timestamp createdDate;
    private Timestamp updatedDate;

    private UserEntity userByUserId;
    private ProgramEntity programByProgramId;
    private ServerEntity serverByServerId;
    private ServerProgramEntity serverProgramByServerProgramId;
    private ApplicationEntity applicationByApplicationId;

    @Id
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_RESPONSIBLE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id", nullable = true, insertable = false, updatable = false)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
    @Column(name = "server_program_id", nullable = true, insertable = false, updatable = false)
    public Long getServerProgramId() {
        return serverProgramId;
    }

    public void setServerProgramId(Long serverProgramId) {
        this.serverProgramId = serverProgramId;
    }

    @Basic
    @Column(name = "application_id", nullable = true, insertable = false, updatable = false)
    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
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

        ResponsibleEntity that = (ResponsibleEntity) o;

        if (id != that.id) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (serverId != null ? !serverId.equals(that.serverId) : that.serverId != null) return false;
        if (programId != null ? !programId.equals(that.programId) : that.programId != null) return false;
        if (serverProgramId != null ? !serverProgramId.equals(that.serverProgramId) : that.serverProgramId != null)
            return false;
        if (applicationId != null ? !applicationId.equals(that.applicationId) : that.applicationId != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        return !(updatedDate != null ? !updatedDate.equals(that.updatedDate) : that.updatedDate != null);

    }

    @Override
    public int hashCode() {
        int result = (id != null) ? id.intValue() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (serverId != null ? serverId.hashCode() : 0);
        result = 31 * result + (programId != null ? programId.hashCode() : 0);
        result = 31 * result + (serverProgramId != null ? serverProgramId.hashCode() : 0);
        result = 31 * result + (applicationId != null ? applicationId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (updatedDate != null ? updatedDate.hashCode() : 0);
        return result;
    }

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

    @ManyToOne
    @JoinColumn(name = "server_program_id", referencedColumnName = "id")
    public ServerProgramEntity getServerProgramByServerProgramId() {
        return serverProgramByServerProgramId;
    }

    public void setServerProgramByServerProgramId(ServerProgramEntity serverProgramByServerProgramId) {
        this.serverProgramByServerProgramId = serverProgramByServerProgramId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "application_id", referencedColumnName = "id")
    public ApplicationEntity getApplicationByApplicationId() {
        return applicationByApplicationId;
    }

    public void setApplicationByApplicationId(ApplicationEntity applicationByApplicationId) {
        this.applicationByApplicationId = applicationByApplicationId;
    }

}
