package tr.bel.pendik.aquilamonitor.data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by moyavuz on 08.10.2015.
 */
@Entity
@Table(name = "relation_type")
public class RelationTypeEntity {
    private Long id;
    private String desc;
    private Boolean status;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private Collection<ApplicationRelationEntity> applicationRelationsById;

    @Id
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_RELATION_TYPE", allocationSize = 1)
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

        RelationTypeEntity that = (RelationTypeEntity) o;

        if (id != that.id) return false;
        if (desc != null ? !desc.equals(that.desc) : that.desc != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        return !(updatedDate != null ? !updatedDate.equals(that.updatedDate) : that.updatedDate != null);

    }

    @Override
    public int hashCode() {
        int result = (id != null) ? id.intValue() : 0;
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (updatedDate != null ? updatedDate.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "relationTypeByRelationTypeId")
    public Collection<ApplicationRelationEntity> getApplicationRelationsById() {
        return applicationRelationsById;
    }

    public void setApplicationRelationsById(Collection<ApplicationRelationEntity> applicationRelationsById) {
        this.applicationRelationsById = applicationRelationsById;
    }
}
