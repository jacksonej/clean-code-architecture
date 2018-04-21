package arch.in.clean_arch_poc.domain.repository;

import java.util.List;

import arch.in.clean_arch_poc.data.model.ArticleDetail;
import arch.in.clean_arch_poc.data.model.GithubContributor;
import io.reactivex.Flowable;

public interface Repository {

    Flowable<List<GithubContributor>> getArticleList();

    Flowable<ArticleDetail> getArticleDetails(String articleurl);

    void saveList(List<GithubContributor> contributors);

}
