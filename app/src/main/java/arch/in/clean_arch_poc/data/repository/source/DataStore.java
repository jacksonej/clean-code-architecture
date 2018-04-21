package arch.in.clean_arch_poc.data.repository.source;

import java.util.List;

import arch.in.clean_arch_poc.data.model.ArticleDetail;
import arch.in.clean_arch_poc.data.model.GithubContributor;
import io.reactivex.Flowable;

public interface DataStore {

     Flowable<List<GithubContributor>> getArticleList();

     Flowable<ArticleDetail> getArticlDetail(String url);


}
