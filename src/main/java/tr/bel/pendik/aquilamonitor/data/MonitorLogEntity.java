package tr.bel.pendik.aquilamonitor.data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by moyavuz on 08.10.2015.
 */
@Entity
@Table(name = "monitor_log")
public class MonitorLogEntity {
    private Long id;
    private Long monitorId;
    private Boolean isStatusLive;
    private Integer responseTime;
    private String statusDesc;
    private String faultDesc;
    private Integer faultCount;
    private Boolean isSendEmailAfter;
    private Boolean isSendSmsAfter;
    private Timestamp createdDate;

    @Id
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_MONITOR_LOG", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "monitor_id", nullable = true, insertable = true, updatable = true)
    public Long getMonitorId() {
        return monitorId;
    }

    public void setMonitorId(Long monitorId) {
        this.monitorId = monitorId;
    }

    @Basic
    @Column(name = "is_status_live", nullable = true, insertable = true, updatable = true)
    public Boolean getIsStatusLive() {
        return isStatusLive;
    }

    public void setIsStatusLive(Boolean isStatusLive) {
        this.isStatusLive = isStatusLive;
    }

    @Basic
    @Column(name = "response_time", nullable = true, insertable = true, updatable = true)
    public Integer getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Integer responseTime) {
        this.responseTime = responseTime;
    }

    @Basic
    @Column(name = "status_desc", nullable = true, insertable = true, updatable = true, length = 255)
    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    @Basic
    @Column(name = "fault_desc", nullable = true, insertable = true, updatable = true, length = 4000)
    public String getFaultDesc() {
        return faultDesc;
    }

    public void setFaultDesc(String faultDesc) {
        this.faultDesc = faultDesc;
    }

    @Basic
    @Column(name = "fault_count", nullable = true, insertable = true, updatable = true)
    public Integer getFaultCount() {
        return faultCount;
    }

    public void setFaultCount(Integer faultCount) {
        this.faultCount = faultCount;
    }

    @Basic
    @Column(name = "is_send_email_after", nullable = true, insertable = true, updatable = true)
    public Boolean getIsSendEmailAfter() {
        return isSendEmailAfter;
    }

    public void setIsSendEmailAfter(Boolean isSendEmailAfter) {
        this.isSendEmailAfter = isSendEmailAfter;
    }

    @Basic
    @Column(name = "is_send_sms_after", nullable = true, insertable = true, updatable = true)
    public Boolean getIsSendSmsAfter() {
        return isSendSmsAfter;
    }

    public void setIsSendSmsAfter(Boolean isSendSmsAfter) {
        this.isSendSmsAfter = isSendSmsAfter;
    }

    @Basic
    @Column(name = "created_date", nullable = true, insertable = false, updatable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MonitorLogEntity that = (MonitorLogEntity) o;

        if (id != that.id) return false;
        if (monitorId != null ? !monitorId.equals(that.monitorId) : that.monitorId != null) return false;
        if (isStatusLive != null ? !isStatusLive.equals(that.isStatusLive) : that.isStatusLive != null) return false;
        if (responseTime != null ? !responseTime.equals(that.responseTime) : that.responseTime != null) return false;
        if (statusDesc != null ? !statusDesc.equals(that.statusDesc) : that.statusDesc != null) return false;
        if (faultDesc != null ? !faultDesc.equals(that.faultDesc) : that.faultDesc != null) return false;
        if (faultCount != null ? !faultCount.equals(that.faultCount) : that.faultCount != null) return false;
        if (isSendEmailAfter != null ? !isSendEmailAfter.equals(that.isSendEmailAfter) : that.isSendEmailAfter != null)
            return false;
        if (isSendSmsAfter != null ? !isSendSmsAfter.equals(that.isSendSmsAfter) : that.isSendSmsAfter != null)
            return false;
        return !(createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null);

    }

    @Override
    public int hashCode() {
        int result = (id != null) ? id.intValue() : 0;
        result = 31 * result + (monitorId != null ? monitorId.hashCode() : 0);
        result = 31 * result + (isStatusLive != null ? isStatusLive.hashCode() : 0);
        result = 31 * result + (responseTime != null ? responseTime.hashCode() : 0);
        result = 31 * result + (statusDesc != null ? statusDesc.hashCode() : 0);
        result = 31 * result + (faultDesc != null ? faultDesc.hashCode() : 0);
        result = 31 * result + (faultCount != null ? faultCount.hashCode() : 0);
        result = 31 * result + (isSendEmailAfter != null ? isSendEmailAfter.hashCode() : 0);
        result = 31 * result + (isSendSmsAfter != null ? isSendSmsAfter.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        return result;
    }
}
