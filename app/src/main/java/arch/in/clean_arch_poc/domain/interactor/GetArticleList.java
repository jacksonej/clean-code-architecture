package arch.in.clean_arch_poc.domain.interactor;

import java.util.List;

import javax.inject.Inject;

import arch.in.clean_arch_poc.data.model.GithubContributor;
import arch.in.clean_arch_poc.data.repository.DataRepository;
import io.reactivex.Flowable;

public class GetArticleList extends FlowableUsecase<List<GithubContributor>,String> {


    DataRepository repository;

    @Inject
    public GetArticleList(DataRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flowable<List<GithubContributor>> buildUseCaseObservable(String param) {
        return repository.getArticleList();
    }


}
