package arch.in.clean_arch_poc.data.cache.list;


import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import arch.in.clean_arch_poc.data.cache.room.AppDatabase;
import arch.in.clean_arch_poc.domain.model.GithubContributor;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class ArticleListCacheImpl implements ArticleListCache {

    @Inject
     AppDatabase db;

    @Inject
    public ArticleListCacheImpl() {
    }

    @Override
    public void clearList() {

    }

    @Override
    public void saveList() {

    }

    @Override
    public Flowable<Boolean> isCached() {
        return db.userDao().getCount().flatMap(res -> {
                    if (res > 0) {
                        return Flowable.just(true);
                    } else {
                        return Flowable.just(false);
                    }
                }
        ).subscribeOn(Schedulers.io());
    }


    @Override
    public void setLastCacheTime() {

    }

    @Override
    public Flowable<Boolean> isExpired() {
        return db.userDao().getCount().flatMap(res -> {
                    if (res > 0) {
                        return Flowable.just(true);
                    } else {
                        return Flowable.just(false);
                    }
                }
        ).subscribeOn(Schedulers.io());
    }


    @Override
    public Flowable<List<GithubContributor>> get() {
        Flowable<List<GithubContributor>> all = db.userDao().getAll();
        return all;
    }

    @Override
    public void put(List<GithubContributor> contributors) {
        db.userDao().insertAll(contributors);

    }


}
