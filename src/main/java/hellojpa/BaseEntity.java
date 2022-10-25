package hellojpa;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity {

    private String createdBy;
    private LocalDateTime createdByDate;
    private String lastModifiedBy;
    private String getLastModifiedDate;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedByDate() {
        return createdByDate;
    }

    public void setCreatedByDate(LocalDateTime createdByDate) {
        this.createdByDate = createdByDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getGetLastModifiedDate() {
        return getLastModifiedDate;
    }

    public void setGetLastModifiedDate(String getLastModifiedDate) {
        this.getLastModifiedDate = getLastModifiedDate;
    }
}
