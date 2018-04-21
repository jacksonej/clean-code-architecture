package arch.in.clean_arch_poc.data.api;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
@Module
public class ApiServiceModule {



    private static final String BASE_URL = "base_url";

    @Provides
    @Named(BASE_URL)
    String provideBaseUrl() {
        return "https://api.github.com/";
    }

    @Provides
    @Singleton
    APIServiceHolder provideApiServiceHolder() {
        return new APIServiceHolder();
    }

    @Provides
    @Singleton
    Dispatcher provideDispatcher(){
        return new Dispatcher();
    }

    @Provides
    @Singleton
    OkHttpClient provideHttpClient( Dispatcher dispatcher) {
        dispatcher.setMaxRequests(1);
        return new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30,TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .cache(null)
                .dispatcher(dispatcher)
                .build();
    }




    @Provides
    @Singleton
    Retrofit provideRetrofit(@Named(BASE_URL) String baseUrl,  OkHttpClient client) {
        return new Retrofit.Builder().baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    /* Specific services */
    @Provides
    @Singleton
    ApiService provideApiService(Retrofit retrofit, APIServiceHolder apiServiceHolder) {
        ApiService apiService = retrofit.create(ApiService.class);
        apiServiceHolder.setAPIService(apiService);
        return apiServiceHolder.apiService();
    }



}