package arch.in.clean_arch_poc.ui.Main;

import java.util.List;

import arch.in.clean_arch_poc.domain.model.GithubContributor;
import arch.in.clean_arch_poc.ui.base.BasePresenter;
import arch.in.clean_arch_poc.ui.base.BaseView;

public class MainActivityContract {

    interface Presenter extends BasePresenter{
        void getApiCall();
    }


    interface View extends BaseView{
        void setView(List<GithubContributor> mGithubContributors);
    }
}
