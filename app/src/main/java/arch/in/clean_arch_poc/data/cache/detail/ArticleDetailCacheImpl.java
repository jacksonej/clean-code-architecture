package arch.in.clean_arch_poc.data.cache.detail;

import arch.in.clean_arch_poc.data.cache.Cache;
import arch.in.clean_arch_poc.domain.model.ArticleDetail;
import io.reactivex.Flowable;

public class ArticleDetailCacheImpl implements ArticleDetailCache {


   // private ArticleDetailCacheImpl(){}

    private static ArticleDetailCacheImpl mArticleListCache;


    public static Cache getInstance()
    {
        if(mArticleListCache==null)
        {
            return new ArticleDetailCacheImpl();
        }
        return mArticleListCache;
    }



    @Override
    public void clearList() {

    }

    @Override
    public void saveList() {

    }

    @Override
    public Flowable<ArticleDetail> get() {
        return null;
    }


    @Override
    public boolean isCached() {
        return true;
    }

    @Override
    public void setLastCacheTime() {

    }

    @Override
    public boolean isExpired() {

        return true;
    }
}
