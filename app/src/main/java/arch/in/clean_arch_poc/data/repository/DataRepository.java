package arch.in.clean_arch_poc.data.repository;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import arch.in.clean_arch_poc.data.cache.list.ArticleListCache;
import arch.in.clean_arch_poc.data.repository.source.RemoteDataStore;
import arch.in.clean_arch_poc.domain.interactor.CommonResponse;
import arch.in.clean_arch_poc.domain.model.ArticleDetail;
import arch.in.clean_arch_poc.domain.model.CachedData;
import arch.in.clean_arch_poc.domain.model.GithubContributor;
import arch.in.clean_arch_poc.domain.repository.Repository;
import io.reactivex.Flowable;

@Singleton
public class DataRepository implements Repository {


    RemoteDataStore mRemoteDataStore;

    @Inject
    ArticleListCache cache;

    @Inject
    CommonResponse<List<GithubContributor>> commonListResponse;

    @Inject
    public DataRepository(RemoteDataStore remoteDataStore) {
        this.mRemoteDataStore = remoteDataStore;
    }


    @Override
    public Flowable<CommonResponse<List<GithubContributor>>> getArticleList() {

        return Flowable.zip(cache.isCached(), cache.isExpired(),
                (isCached, isExpired) -> new CachedData(isCached, isExpired))
                .flatMap(cachedData -> {
                    if (cachedData.getIsCached() && !cachedData.getExpired()) {
                        Log.d("hai", "in cache");
                        return  cache.get().flatMap(result -> {
                            commonListResponse.setResponse(result);
                            commonListResponse.setFromNetwork(false);
                            return Flowable.just(commonListResponse);
                        });
                    } else {
                            return mRemoteDataStore.getArticleList().flatMap(result -> {
                                cache.put(result);
                                Log.d("hai", "in network");
                                commonListResponse.setFromNetwork(true);
                                commonListResponse.setResponse(result);
                                return Flowable.just(commonListResponse);
                            });
                        }
                });

    }



    @Override
    public Flowable<ArticleDetail> getArticleDetails(String articleurl) {
        /*ArticleDetailCache mDetailCache = new ArticleDetailCacheImpl();
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
