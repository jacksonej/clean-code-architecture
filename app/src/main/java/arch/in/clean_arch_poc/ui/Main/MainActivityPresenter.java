package arch.in.clean_arch_poc.ui.Main;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import arch.in.clean_arch_poc.domain.interactor.ArticleListUsecase;
import arch.in.clean_arch_poc.domain.interactor.CallbackWrapper;
import arch.in.clean_arch_poc.domain.interactor.CommonResponse;
import arch.in.clean_arch_poc.domain.model.GithubContributor;
import arch.in.clean_arch_poc.ui.MyPreferenceManager;
import arch.in.clean_arch_poc.ui.base.BasePresenterImpl;

public class MainActivityPresenter extends BasePresenterImpl implements MainActivityContract.Presenter {


    MainActivityContract.View view;
    MyPreferenceManager prefs;

    @Inject
    ArticleListUsecase articleList;


    @Inject
    public MainActivityPresenter( MainActivityContract.View view,MyPreferenceManager myPreferenceManager) {
        super(view);
        this.view = view;
        this.prefs=myPreferenceManager;
    }


    @Override
    public void getApiCall() {

        Long startTime=System.currentTimeMillis();

        articleList.execute(new CallbackWrapper<CommonResponse<List<GithubContributor>>>(this) {
            @Override
            protected void onSuccess(CommonResponse<List<GithubContributor>> listCoomonResponse) {
                    List<GithubContributor> githubContributorsResponse = listCoomonResponse.getResponse();
                   // Log.d("hai",listCoomonResponse.getTime()+"");
                    if(listCoomonResponse.isFromNetwork())
                    {
                        Log.d("hai",(listCoomonResponse.getTime()-startTime)+" from Network ");
                    }else{
                        Log.d("hai",(listCoomonResponse.getTime()-startTime)+" from DataBase ");
                    }
                    view.setView(githubContributorsResponse);
            }


        },null);

        prefs.getPackage();


    }

    public void check(){
        Log.e("check","check");
    }

    @Override
    public void onDestroy() {
        articleList.dispose();
    }
}
