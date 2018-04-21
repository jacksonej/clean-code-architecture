package arch.in.clean_arch_poc.data.api;

import android.support.annotation.NonNull;

public class APIServiceHolder {
    private ApiService apiService;

        @NonNull
        public ApiService apiService() {
            return apiService;
        }

        public void setAPIService(ApiService apiService) {
            this.apiService = apiService;
        }
}