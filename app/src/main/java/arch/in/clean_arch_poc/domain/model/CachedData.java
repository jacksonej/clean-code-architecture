package arch.in.clean_arch_poc.domain.model;

public class CachedData {
    Boolean isCached;
    Boolean isExpired;

    public CachedData(Boolean isCached, Boolean isExpired) {
        this.isCached = isCached;
        this.isExpired = isExpired;
    }

    public Boolean getIsCached() {
        return isCached;
    }

    public void setIsCached(Boolean isCached) {
        this.isCached = isCached;
    }

    public Boolean getCached() {
        return isCached;
    }

    public void setCached(Boolean cached) {
        isCached = cached;
    }

    public Boolean getExpired() {
        return isExpired;
    }

    public void setExpired(Boolean expired) {
        isExpired = expired;
    }
}
