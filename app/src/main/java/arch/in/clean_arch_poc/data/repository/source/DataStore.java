package arch.in.clean_arch_poc.data.repository.source;

import java.util.List;

import arch.in.clean_arch_poc.domain.model.ArticleDetail;
import arch.in.clean_arch_poc.domain.model.GithubContributor;
import io.reactivex.Flowable;

public interface DataStore {

     Flowable<List<GithubContributor>> getArticleList();

     Flowable<ArticleDetail> getArticlDetail(String url);


}
