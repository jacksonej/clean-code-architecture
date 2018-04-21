package arch.in.clean_arch_poc.ui.Main;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import arch.in.clean_arch_poc.data.model.GithubContributor;
import arch.in.clean_arch_poc.data.repository.DataRepository;
import arch.in.clean_arch_poc.domain.interactor.CallbackWrapper;
import arch.in.clean_arch_poc.domain.interactor.GetArticleList;
import arch.in.clean_arch_poc.ui.MyPreferenceManager;
import arch.in.clean_arch_poc.ui.base.BasePresenterImpl;

public class MainActivityPresenter extends BasePresenterImpl implements MainActivityContract.Presenter {


    DataRepository repository;
    MainActivityContract.View view;
    MyPreferenceManager prefs;

    @Inject
    GetArticleList articleList;


    @Inject
    public MainActivityPresenter(DataRepository repository, MainActivityContract.View view,MyPreferenceManager myPreferenceManager) {
        super(view);
        this.view = view;
        this.repository = repository;
        this.prefs=myPreferenceManager;
    }


    @Override
    public void getApiCall() {


        articleList.execute(new CallbackWrapper<List<GithubContributor>>(this) {
            @Override
            protected void onSuccess(List<GithubContributor> githubContributors) {
                view.setView(githubContributors);
            }

        },null);

        prefs.getPackage();


    }

    public void check(){
        Log.e("check","check");
    }
}
