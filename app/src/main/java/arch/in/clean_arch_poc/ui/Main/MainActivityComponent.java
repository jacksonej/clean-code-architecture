package arch.in.clean_arch_poc.ui.Main;

import dagger.Component;
import arch.in.clean_arch_poc.data.repository.RepositoryComponent;
import arch.in.clean_arch_poc.ui.base.ActivityScope;

@ActivityScope
@Component(modules = {MainActivityModule.class} ,dependencies = RepositoryComponent.class)
public interface MainActivityComponent {

    void inject(MainActivity mainActivity);

}