package arch.in.clean_arch_poc.data.cache;

public interface Cache {

    void clearList();

    void saveList();


    boolean isCached();

    void setLastCacheTime();

     boolean isExpired();
}
