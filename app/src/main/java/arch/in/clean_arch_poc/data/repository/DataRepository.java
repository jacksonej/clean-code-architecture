package arch.in.clean_arch_poc.data.repository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import arch.in.clean_arch_poc.data.cache.list.ArticleListCache;
import arch.in.clean_arch_poc.data.model.ArticleDetail;
import arch.in.clean_arch_poc.data.model.GithubContributor;
import arch.in.clean_arch_poc.data.repository.source.RemoteDataStore;
import arch.in.clean_arch_poc.domain.repository.Repository;
import io.reactivex.Flowable;

@Singleton
public class DataRepository implements Repository {


    RemoteDataStore mRemoteDataStore;

    @Inject
    ArticleListCache cache;


    @Inject
    public DataRepository(RemoteDataStore remoteDataStore) {
        this.mRemoteDataStore = remoteDataStore;
    }


    @Override
    public Flowable<List<GithubContributor>> getArticleList() {
        if (cache.isCached() && !cache.isExpired()) {
            return cache.get();
        }
        return mRemoteDataStore.getArticleList().flatMap(result -> {
            cache.put(result);
            return Flowable.just(result);
        });
    }

    @Override
    public Flowable<ArticleDetail> getArticleDetails(String articleurl) {
        /*ArticleDetailtCache mDetailCache = new ArticleDetailCacheImpl();
        if (mDetailCache.isCached() && !mDetailCache.isExpired()) {
            mDetailCache.get();
        }*/
        return mRemoteDataStore.getArticlDetail(articleurl);
    }

    @Override
    public void saveList(List<GithubContributor> contributors) {
        cache.put(contributors);
    }


}
