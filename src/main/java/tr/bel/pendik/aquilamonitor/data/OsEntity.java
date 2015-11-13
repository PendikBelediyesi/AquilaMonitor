package tr.bel.pendik.aquilamonitor.data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by moyavuz on 08.10.2015.
 */
@Entity
@Table(name = "os")
public class OsEntity {
    private Long id;
    private String desc;
    private Boolean status;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    //   private Collection<ServerEntity> serversById;

    @Id
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_OS", allocationSize = 1)
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

        OsEntity osEntity = (OsEntity) o;

        if (id != osEntity.id) return false;
        if (desc != null ? !desc.equals(osEntity.desc) : osEntity.desc != null) return false;
        if (status != null ? !status.equals(osEntity.status) : osEntity.status != null) return false;
        if (createdDate != null ? !createdDate.equals(osEntity.createdDate) : osEntity.createdDate != null)
            return false;
        return !(updatedDate != null ? !updatedDate.equals(osEntity.updatedDate) : osEntity.updatedDate != null);

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

   /* @OneToMany(mappedBy = "osByOsId")
    public Collection<ServerEntity> getServersById() {
        return serversById;
    }

    public void setServersById(Collection<ServerEntity> serversById) {
        this.serversById = serversById;
    }*/
}
