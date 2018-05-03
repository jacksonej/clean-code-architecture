package arch.in.clean_arch_poc.ui.detail;

import javax.inject.Inject;

import arch.in.clean_arch_poc.domain.interactor.CallbackWrapper;
import arch.in.clean_arch_poc.domain.interactor.DetailUsecase;
import arch.in.clean_arch_poc.domain.model.ArticleDetail;
import arch.in.clean_arch_poc.ui.MyPreferenceManager;
import arch.in.clean_arch_poc.ui.base.BasePresenterImpl;

public class DetailPresenter extends BasePresenterImpl implements DetailActivityContract.Presenter {



    DetailActivityContract.View view;
    MyPreferenceManager prefs;

    @Inject
    DetailUsecase detailUsecase;

    @Inject
    public DetailPresenter(DetailActivityContract.View view, MyPreferenceManager myPreferenceManager) {
        super(view);
        this.view = view;
        this.prefs=myPreferenceManager;
    }


    @Override
    public void getApiCall(String url) {


        detailUsecase.execute(new CallbackWrapper<ArticleDetail>(this) {
            @Override
            protected void onSuccess(ArticleDetail articleDetail) {
                view.setView(articleDetail);
            }
        },url);
        prefs.getPackage();


    }

    @Override
    public void onDestroy() {
        detailUsecase.dispose();
    }
}
