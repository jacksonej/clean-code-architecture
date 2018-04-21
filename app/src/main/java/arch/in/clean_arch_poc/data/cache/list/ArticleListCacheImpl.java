package arch.in.clean_arch_poc.data.cache.list;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import arch.in.clean_arch_poc.data.cache.room.AppDatabase;
import arch.in.clean_arch_poc.data.model.GithubContributor;
import io.reactivex.Flowable;
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
    public boolean isCached() {
        return false;
    }

    @Override
    public void setLastCacheTime() {

    }

    @Override
    public boolean isExpired() {
        return false;
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
