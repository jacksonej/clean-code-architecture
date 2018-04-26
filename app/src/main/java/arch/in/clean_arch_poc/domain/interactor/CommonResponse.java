package arch.in.clean_arch_poc.domain.interactor;

import javax.inject.Inject;

public class CommonResponse<T> {

    Boolean isFromNetwork;

    public Boolean isFromNetwork() {
        return isFromNetwork;
    }

    public void setFromNetwork(Boolean fromNetwork) {
        isFromNetwork = fromNetwork;
    }

    @Inject
    public CommonResponse() {
    }

    T response;

    Long time;
    public void setResponse(T response) {
        this.response = response;
    }

    public T getResponse(){
        return response;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
