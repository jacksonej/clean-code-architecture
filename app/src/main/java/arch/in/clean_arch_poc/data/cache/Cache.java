package arch.in.clean_arch_poc.data.cache;

import io.reactivex.Flowable;

public interface Cache {

    void clearList();

    void saveList();


    Flowable<Boolean> isCached();

    void setLastCacheTime();

    Flowable<Boolean> isExpired();
}
