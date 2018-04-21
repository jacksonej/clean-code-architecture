package arch.in.clean_arch_poc.data.repository;


import javax.inject.Singleton;

import dagger.Component;
import arch.in.clean_arch_poc.data.api.ApiServiceModule;
import arch.in.clean_arch_poc.data.api.MyService;
import arch.in.clean_arch_poc.data.cache.room.DatabaseModule;
import arch.in.clean_arch_poc.ui.MyPreferenceManager;

@Singleton
@Component(modules = { ApiServiceModule.class, RepositoryModule.class, DatabaseModule.class})
public interface RepositoryComponent {


    DataRepository provideRepository();

    MyPreferenceManager getPrefs();

    MyService service();

}
