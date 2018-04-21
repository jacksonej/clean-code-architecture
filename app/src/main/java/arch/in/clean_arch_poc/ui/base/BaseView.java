package arch.in.clean_arch_poc.ui.base;

public interface BaseView {

    void onUnknownError(String errorMessage);

    void onTimeout();

    void onNetworkError();


}
