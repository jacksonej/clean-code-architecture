package arch.in.clean_arch_poc.data.repository.source;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import arch.in.clean_arch_poc.data.api.ApiService;
import arch.in.clean_arch_poc.data.model.ArticleDetail;
import arch.in.clean_arch_poc.data.model.GithubContributor;
import io.reactivex.Flowable;
@Singleton
public class RemoteDataStore implements DataStore {

    ApiService service;


    @Inject
    public RemoteDataStore(ApiService service) {
        this.service = service;
    }


    @Override
    public Flowable<List<GithubContributor>> getArticleList() {
        return service.getContributors();
    }

    @Override
    public Flowable<ArticleDetail> getArticlDetail(String url) {
        return service.getDetails(url);
    }
}
