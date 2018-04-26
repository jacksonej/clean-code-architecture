package arch.in.clean_arch_poc.domain.interactor;

import java.util.List;

import javax.inject.Inject;

import arch.in.clean_arch_poc.data.repository.DataRepository;
import arch.in.clean_arch_poc.domain.model.GithubContributor;
import io.reactivex.Flowable;

public class ArticleListUsecase extends FlowableUsecase<CommonResponse<List<GithubContributor>>,String> {


    DataRepository repository;

    @Inject
    public ArticleListUsecase(DataRepository repository) {
        this.repository = repository;
    }


    @Override
    Flowable<CommonResponse<List<GithubContributor>>> buildUseCaseObservable(String params) {
        return repository.getArticleList();
    }
}
