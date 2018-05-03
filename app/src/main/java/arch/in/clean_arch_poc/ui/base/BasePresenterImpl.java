package arch.in.clean_arch_poc.ui.base;

public class BasePresenterImpl implements BasePresenter{

    BaseView view;

    public BasePresenterImpl(BaseView view) {
        this.view = view;
    }

    @Override
    public void onConnectionTimeOut() {
        view.onTimeout();
    }

    @Override
    public void onUnknownError(String message) {
        view.onUnknownError(message);
    }

    @Override
    public void onNetworkError() {
        view.onNetworkError();
    }

    @Override
    public void onDestroy() {

    }
}
