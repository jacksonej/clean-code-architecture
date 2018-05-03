package arch.in.clean_arch_poc.domain.interactor;

import org.json.JSONObject;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.SocketTimeoutException;

import arch.in.clean_arch_poc.ui.base.BasePresenter;
import io.reactivex.subscribers.DisposableSubscriber;
import okhttp3.ResponseBody;
import retrofit2.HttpException;

public abstract class CallbackWrapper<T> extends DisposableSubscriber<T> {
    //BaseView is just a reference of a View in MVP
    private WeakReference<BasePresenter> weakReference;

    public CallbackWrapper(BasePresenter presenter) {
        this.weakReference = new WeakReference<>(presenter);
    }

    protected abstract void onSuccess(T t);

    @Override
    public void onNext(T t) {
        //You can return StatusCodes of different cases from your API and handle it here. I usually include these cases on BaseResponse and iherit it from every response
     //  Log.d("hai","in onnext");
        CommonResponse<T> comonResponse= null;
        try {
            comonResponse = (CommonResponse<T>) t;
            comonResponse.setTime(System.currentTimeMillis());
            onSuccess((T) comonResponse);
        } catch (Exception e) {
            onSuccess(t);
        }


    }

    @Override
    public void onError(Throwable e) {
        BasePresenter presenter = weakReference.get();
        if (e instanceof HttpException) {
            ResponseBody responseBody = ((HttpException) e).response().errorBody();
            presenter.onUnknownError(getErrorMessage(responseBody));
        } else if (e instanceof SocketTimeoutException) {
            presenter.onConnectionTimeOut();
        } else if (e instanceof IOException) {
            presenter.onNetworkError();
        } else {
            presenter.onUnknownError(e.getMessage());
        }

    }

    @Override
    public void onComplete() {

    }

    private String getErrorMessage(ResponseBody responseBody) {
        try {
            JSONObject jsonObject = new JSONObject(responseBody.string());
            return jsonObject.getString("message");
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}