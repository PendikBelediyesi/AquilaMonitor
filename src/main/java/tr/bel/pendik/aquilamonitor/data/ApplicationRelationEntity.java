package tr.bel.pendik.aquilamonitor.data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by moyavuz on 08.10.2015.
 */
@Entity
@Table(name = "application_relation")
public class ApplicationRelationEntity {
    private Long id;
    private String desc;
    private Long applicationId;
    private Long relationApplicationId;
    private Long relationTypeId;
    private Boolean status;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private RelationTypeEntity relationTypeByRelationTypeId;

    @Id
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_APPLICATION_RELATION", allocationSize = 1)
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
    @Column(name = "application_id", nullable = false, insertable = true, updatable = true)
    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    @Basic
    @Column(name = "relation_application_id", nullable = false, insertable = true, updatable = true)
    public Long getRelationApplicationId() {
        return relationApplicationId;
    }

    public void setRelationApplicationId(Long relationApplicationId) {
        this.relationApplicationId = relationApplicationId;
    }

    @Basic
    @Column(name = "relation_type_id", nullable = true, insertable = false, updatable = false)
    public Long getRelationTypeId() {
        return relationTypeId;
    }

    public void setRelationTypeId(Long relationTypeId) {
        this.relationTypeId = relationTypeId;
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

        ApplicationRelationEntity that = (ApplicationRelationEntity) o;

        if (id != that.id) return false;
        if (applicationId != that.applicationId) return false;
        if (relationApplicationId != that.relationApplicationId) return false;
        if (desc != null ? !desc.equals(that.desc) : that.desc != null) return false;
        if (relationTypeId != null ? !relationTypeId.equals(that.relationTypeId) : that.relationTypeId != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        return !(updatedDate != null ? !updatedDate.equals(that.updatedDate) : that.updatedDate != null);

    }

    @Override
    public int hashCode() {
        int result = (id != null) ? id.intValue() : 0;
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (applicationId != null ? applicationId.hashCode() : 0);
        ;
        result = 31 * result + (relationApplicationId != null ? relationApplicationId.hashCode() : 0);
        ;
        result = 31 * result + (relationTypeId != null ? relationTypeId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (updatedDate != null ? updatedDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "relation_type_id", referencedColumnName = "id", insertable = false, updatable = false)
    public RelationTypeEntity getRelationTypeByRelationTypeId() {
        return relationTypeByRelationTypeId;
    }

    public void setRelationTypeByRelationTypeId(RelationTypeEntity relationTypeByRelationTypeId) {
        this.relationTypeByRelationTypeId = relationTypeByRelationTypeId;
    }
}
