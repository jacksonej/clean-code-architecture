package arch.in.clean_arch_poc.domain.interactor;

import javax.inject.Inject;

import arch.in.clean_arch_poc.domain.model.ArticleDetail;
import arch.in.clean_arch_poc.data.repository.DataRepository;
import io.reactivex.Flowable;

public class GetDetail extends FlowableUsecase<ArticleDetail,String> {


    DataRepository repository;

    @Inject
    public GetDetail(DataRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flowable<ArticleDetail> buildUseCaseObservable(String param) {
        return repository.getArticleDetails(param);
       /* return repository.getArticleList()
                .doOnNext(result -> repository.saveList(result))
                .flatMap(result -> {
                    String id = result.get(0).getLogin();
                    return repository.getArticleDetails(id);
                }
        );*/
    }



}
