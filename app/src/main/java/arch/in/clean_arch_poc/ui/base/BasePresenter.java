package arch.in.clean_arch_poc.ui.base;

public interface BasePresenter {
    void onConnectionTimeOut();
    void onUnknownError(String message);
    void onNetworkError();
}
