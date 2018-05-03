package arch.in.clean_arch_poc.ui.base;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import arch.in.clean_arch_poc.data.repository.DaggerRepositoryComponent;
import arch.in.clean_arch_poc.data.repository.RepositoryComponent;


public class AndroidAppication extends Application {

    RepositoryComponent repositoryComponent;

    public static AndroidAppication appication;
    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);

        initializeRepositoryComponent();
        appication=this;
    }


    private RepositoryComponent initializeRepositoryComponent() {
        repositoryComponent = DaggerRepositoryComponent.builder()
                .contextModule(new ContextModule(getApplicationContext()))
                .build();
        return repositoryComponent;

    }

    public RepositoryComponent getRepositoryComponent() {
        return repositoryComponent;
    }


    public static AndroidAppication getAppication() {
        return appication;
    }


}
