package arch.in.clean_arch_poc.domain.repository;

import java.util.List;

import arch.in.clean_arch_poc.domain.model.ArticleDetail;
import arch.in.clean_arch_poc.domain.model.GithubContributor;
import io.reactivex.Flowable;

public interface Repository {

    Flowable<List<GithubContributor>> getArticleList();

    Flowable<ArticleDetail> getArticleDetails(String articleurl);

    void saveList(List<GithubContributor> contributors);

}
