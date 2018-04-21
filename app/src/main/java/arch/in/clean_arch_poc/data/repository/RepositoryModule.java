package arch.in.clean_arch_poc.data.repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import arch.in.clean_arch_poc.data.cache.list.ArticleListCache;
import arch.in.clean_arch_poc.data.cache.list.ArticleListCacheImpl;
import arch.in.clean_arch_poc.domain.repository.Repository;
import arch.in.clean_arch_poc.ui.base.ContextModule;

@Module (includes = ContextModule.class)
public class RepositoryModule {



    @Provides
    @Singleton
    public Repository provideRemoteDataSource(DataRepository dataRepository) {
        return dataRepository;
    }


    @Provides
    @Singleton
    public ArticleListCache providesArticleListCache(ArticleListCacheImpl listCache) {
        return listCache;
    }


}