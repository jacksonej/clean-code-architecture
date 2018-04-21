package arch.in.clean_arch_poc.data.cache.list;

import java.util.List;

import arch.in.clean_arch_poc.data.cache.Cache;
import arch.in.clean_arch_poc.data.model.GithubContributor;
import io.reactivex.Flowable;

public interface ArticleListCache extends Cache {

    Flowable<List<GithubContributor>> get();


    void put(List<GithubContributor> contributors);
}
