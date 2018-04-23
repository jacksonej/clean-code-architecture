package arch.in.clean_arch_poc.data.cache.detail;

import arch.in.clean_arch_poc.data.cache.Cache;
import arch.in.clean_arch_poc.data.model.ArticleDetail;
import io.reactivex.Flowable;

public interface ArticleDetailCache extends Cache{

    Flowable<ArticleDetail> get();
}
