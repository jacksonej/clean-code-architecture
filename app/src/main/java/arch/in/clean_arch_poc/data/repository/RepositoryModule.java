package arch.in.clean_arch_poc.data.repository;

import javax.inject.Singleton;

import arch.in.clean_arch_poc.data.cache.list.ArticleListCache;
import arch.in.clean_arch_poc.data.cache.list.ArticleListCacheImpl;
import arch.in.clean_arch_poc.ui.base.ContextModule;
import dagger.Module;
import dagger.Provides;

@Module (includes = ContextModule.class)
public class RepositoryModule {




    @Provides
    @Singleton
    public ArticleListCache providesArticleListCache(ArticleListCacheImpl listCache) {
        return listCache;
    }


}