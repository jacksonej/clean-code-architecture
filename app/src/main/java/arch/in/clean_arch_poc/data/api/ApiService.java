package arch.in.clean_arch_poc.data.api;

import java.util.List;

import arch.in.clean_arch_poc.data.model.ArticleDetail;
import arch.in.clean_arch_poc.data.model.GithubContributor;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("repos/ReactiveX/RxJava/contributors")
    Flowable<List<GithubContributor>> getContributors();


    @GET("users/{user}")
    Flowable<ArticleDetail> getDetails(@Path("user") String user);

}