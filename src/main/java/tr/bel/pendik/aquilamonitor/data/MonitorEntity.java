package tr.bel.pendik.aquilamonitor.data;


import javax.persistence.*;
import java.sql.Blob;
import java.sql.Timestamp;

/**
 * Created by moyavuz on 08.10.2015.
 */
@Entity
@javax.persistence.Table(name = "monitor")
public class MonitorEntity {
    private Long id;
    private String desc;
    private Long applicationId;
    private Long serverId;
    private Long serverProgramId;
    private String statusDesc;
    private Boolean isStatusLive;
    private Integer interval;
    private Integer timeout;
    private Integer faultRetryCount;
    private Blob request;
    private Blob response;
    private String testUrl;
    private String testUsername;
    private String testPassword;
    private Boolean isSendFaultEmail;
    private Boolean isSendFaultSms;
    private Boolean isSendSuccessEmailAfterFault;
    private Boolean isSendSuccessSmsAfterFault;
    private Boolean faultCount;
    private Boolean totalFaultCount;
    private Timestamp lastFaultDate;
    private Timestamp lastSuccessDate;
    private Boolean status;
    private Timestamp createdDate;
    private Timestamp updatedDate;

    @Id
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_MONITOR_ENTITY", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @javax.persistence.Column(name = "desc", nullable = true, insertable = true, updatable = true, length = 255)
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Basic
    @javax.persistence.Column(name = "application_id", nullable = true, insertable = true, updatable = true)
    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    @Basic
    @javax.persistence.Column(name = "server_id", nullable = true, insertable = true, updatable = true)
    public Long getServerId() {
        return serverId;
    }

    public void setServerId(Long serverId) {
        this.serverId = serverId;
    }

    @Basic
    @javax.persistence.Column(name = "server_program_id", nullable = true, insertable = true, updatable = true)
    public Long getServerProgramId() {
        return serverProgramId;
    }

    public void setServerProgramId(Long serverProgramId) {
        this.serverProgramId = serverProgramId;
    }

    @Basic
    @javax.persistence.Column(name = "status_desc", nullable = true, insertable = true, updatable = true, length = 255)
    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    @Basic
    @javax.persistence.Column(name = "is_status_live", nullable = true, insertable = true, updatable = true)
    public Boolean getIsStatusLive() {
        return isStatusLive;
    }

    public void setIsStatusLive(Boolean isStatusLive) {
        this.isStatusLive = isStatusLive;
    }

    @Basic
    @javax.persistence.Column(name = "interval", nullable = true, insertable = true, updatable = true)
    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    @Basic
    @javax.persistence.Column(name = "timeout", nullable = true, insertable = true, updatable = true)
    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    @Basic
    @javax.persistence.Column(name = "fault_retry_count", nullable = true, insertable = true, updatable = true)
    public Integer getFaultRetryCount() {
        return faultRetryCount;
    }

    public void setFaultRetryCount(Integer faultRetryCount) {
        this.faultRetryCount = faultRetryCount;
    }

    @Basic
    @javax.persistence.Column(name = "request", nullable = true, insertable = true, updatable = true)
    public Blob getRequest() {
        return request;
    }

    public void setRequest(Blob request) {
        this.request = request;
    }

    @Basic
    @javax.persistence.Column(name = "response", nullable = true, insertable = true, updatable = true)
    public Blob getResponse() {
        return response;
    }

    public void setResponse(Blob response) {
        this.response = response;
    }

    @Basic
    @javax.persistence.Column(name = "test_url", nullable = true, insertable = true, updatable = true, length = 255)
    public String getTestUrl() {
        return testUrl;
    }

    public void setTestUrl(String testUrl) {
        this.testUrl = testUrl;
    }

    @Basic
    @javax.persistence.Column(name = "test_username", nullable = true, insertable = true, updatable = true, length = 50)
    public String getTestUsername() {
        return testUsername;
    }

    public void setTestUsername(String testUsername) {
        this.testUsername = testUsername;
    }

    @Basic
    @javax.persistence.Column(name = "test_password", nullable = true, insertable = true, updatable = true, length = 50)
    public String getTestPassword() {
        return testPassword;
    }

    public void setTestPassword(String testPassword) {
        this.testPassword = testPassword;
    }

    @Basic
    @javax.persistence.Column(name = "is_send_fault_email", nullable = true, insertable = true, updatable = true)
    public Boolean getIsSendFaultEmail() {
        return isSendFaultEmail;
    }

    public void setIsSendFaultEmail(Boolean isSendFaultEmail) {
        this.isSendFaultEmail = isSendFaultEmail;
    }

    @Basic
    @javax.persistence.Column(name = "is_send_fault_sms", nullable = true, insertable = true, updatable = true)
    public Boolean getIsSendFaultSms() {
        return isSendFaultSms;
    }

    public void setIsSendFaultSms(Boolean isSendFaultSms) {
        this.isSendFaultSms = isSendFaultSms;
    }

    @Basic
    @javax.persistence.Column(name = "is_send_success_email_after_fault", nullable = true, insertable = true, updatable = true)
    public Boolean getIsSendSuccessEmailAfterFault() {
        return isSendSuccessEmailAfterFault;
    }

    public void setIsSendSuccessEmailAfterFault(Boolean isSendSuccessEmailAfterFault) {
        this.isSendSuccessEmailAfterFault = isSendSuccessEmailAfterFault;
    }

    @Basic
    @javax.persistence.Column(name = "is_send_success_sms_after_fault", nullable = true, insertable = true, updatable = true)
    public Boolean getIsSendSuccessSmsAfterFault() {
        return isSendSuccessSmsAfterFault;
    }

    public void setIsSendSuccessSmsAfterFault(Boolean isSendSuccessSmsAfterFault) {
        this.isSendSuccessSmsAfterFault = isSendSuccessSmsAfterFault;
    }

    @Basic
    @javax.persistence.Column(name = "fault_count", nullable = true, insertable = true, updatable = true)
    public Boolean getFaultCount() {
        return faultCount;
    }

    public void setFaultCount(Boolean faultCount) {
        this.faultCount = faultCount;
    }

    @Basic
    @javax.persistence.Column(name = "total_fault_count", nullable = true, insertable = true, updatable = true)
    public Boolean getTotalFaultCount() {
        return totalFaultCount;
    }

    public void setTotalFaultCount(Boolean totalFaultCount) {
        this.totalFaultCount = totalFaultCount;
    }

    @Basic
    @javax.persistence.Column(name = "last_fault_date", nullable = true, insertable = true, updatable = true)
    public Timestamp getLastFaultDate() {
        return lastFaultDate;
    }

    public void setLastFaultDate(Timestamp lastFaultDate) {
        this.lastFaultDate = lastFaultDate;
    }

    @Basic
    @javax.persistence.Column(name = "last_success_date", nullable = true, insertable = true, updatable = true)
    public Timestamp getLastSuccessDate() {
        return lastSuccessDate;
    }

    public void setLastSuccessDate(Timestamp lastSuccessDate) {
        this.lastSuccessDate = lastSuccessDate;
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

        MonitorEntity that = (MonitorEntity) o;

        if (id != that.id) return false;
        if (desc != null ? !desc.equals(that.desc) : that.desc != null) return false;
        if (applicationId != null ? !applicationId.equals(that.applicationId) : that.applicationId != null)
            return false;
        if (serverId != null ? !serverId.equals(that.serverId) : that.serverId != null) return false;
        if (serverProgramId != null ? !serverProgramId.equals(that.serverProgramId) : that.serverProgramId != null)
            return false;
        if (statusDesc != null ? !statusDesc.equals(that.statusDesc) : that.statusDesc != null) return false;
        if (isStatusLive != null ? !isStatusLive.equals(that.isStatusLive) : that.isStatusLive != null) return false;
        if (interval != null ? !interval.equals(that.interval) : that.interval != null) return false;
        if (timeout != null ? !timeout.equals(that.timeout) : that.timeout != null) return false;
        if (faultRetryCount != null ? !faultRetryCount.equals(that.faultRetryCount) : that.faultRetryCount != null)
            return false;
        if (request != null ? !request.equals(that.request) : that.request != null) return false;
        if (response != null ? !response.equals(that.response) : that.response != null) return false;

        if (testUrl != null ? !testUrl.equals(that.testUrl) : that.testUrl != null) return false;
        if (testUsername != null ? !testUsername.equals(that.testUsername) : that.testUsername != null) return false;
        if (testPassword != null ? !testPassword.equals(that.testPassword) : that.testPassword != null) return false;
        if (isSendFaultEmail != null ? !isSendFaultEmail.equals(that.isSendFaultEmail) : that.isSendFaultEmail != null)
            return false;
        if (isSendFaultSms != null ? !isSendFaultSms.equals(that.isSendFaultSms) : that.isSendFaultSms != null)
            return false;
        if (isSendSuccessEmailAfterFault != null ? !isSendSuccessEmailAfterFault.equals(that.isSendSuccessEmailAfterFault) : that.isSendSuccessEmailAfterFault != null)
            return false;
        if (isSendSuccessSmsAfterFault != null ? !isSendSuccessSmsAfterFault.equals(that.isSendSuccessSmsAfterFault) : that.isSendSuccessSmsAfterFault != null)
            return false;
        if (faultCount != null ? !faultCount.equals(that.faultCount) : that.faultCount != null) return false;
        if (totalFaultCount != null ? !totalFaultCount.equals(that.totalFaultCount) : that.totalFaultCount != null)
            return false;
        if (lastFaultDate != null ? !lastFaultDate.equals(that.lastFaultDate) : that.lastFaultDate != null)
            return false;
        if (lastSuccessDate != null ? !lastSuccessDate.equals(that.lastSuccessDate) : that.lastSuccessDate != null)
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
        result = 31 * result + (serverId != null ? serverId.hashCode() : 0);
        result = 31 * result + (serverProgramId != null ? serverProgramId.hashCode() : 0);
        result = 31 * result + (statusDesc != null ? statusDesc.hashCode() : 0);
        result = 31 * result + (isStatusLive != null ? isStatusLive.hashCode() : 0);
        result = 31 * result + (interval != null ? interval.hashCode() : 0);
        result = 31 * result + (timeout != null ? timeout.hashCode() : 0);
        result = 31 * result + (faultRetryCount != null ? faultRetryCount.hashCode() : 0);
        result = 31 * result + (request != null ? request.hashCode() : 0);
        result = 31 * result + (response != null ? response.hashCode() : 0);
        result = 31 * result + (testUrl != null ? testUrl.hashCode() : 0);
        result = 31 * result + (testUsername != null ? testUsername.hashCode() : 0);
        result = 31 * result + (testPassword != null ? testPassword.hashCode() : 0);
        result = 31 * result + (isSendFaultEmail != null ? isSendFaultEmail.hashCode() : 0);
        result = 31 * result + (isSendFaultSms != null ? isSendFaultSms.hashCode() : 0);
        result = 31 * result + (isSendSuccessEmailAfterFault != null ? isSendSuccessEmailAfterFault.hashCode() : 0);
        result = 31 * result + (isSendSuccessSmsAfterFault != null ? isSendSuccessSmsAfterFault.hashCode() : 0);
        result = 31 * result + (faultCount != null ? faultCount.hashCode() : 0);
        result = 31 * result + (totalFaultCount != null ? totalFaultCount.hashCode() : 0);
        result = 31 * result + (lastFaultDate != null ? lastFaultDate.hashCode() : 0);
        result = 31 * result + (lastSuccessDate != null ? lastSuccessDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (updatedDate != null ? updatedDate.hashCode() : 0);
        return result;
    }
}
