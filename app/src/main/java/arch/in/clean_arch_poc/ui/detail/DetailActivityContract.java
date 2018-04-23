package arch.in.clean_arch_poc.ui.detail;

import arch.in.clean_arch_poc.domain.model.ArticleDetail;
import arch.in.clean_arch_poc.ui.base.BasePresenter;
import arch.in.clean_arch_poc.ui.base.BaseView;

public class DetailActivityContract {

    interface Presenter extends BasePresenter{
        void getApiCall(String url);
    }


    interface View extends BaseView{
        void setView(ArticleDetail detail);
    }
}
