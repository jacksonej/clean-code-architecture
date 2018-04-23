package arch.in.clean_arch_poc.ui.detail;

import dagger.Component;
import arch.in.clean_arch_poc.data.repository.RepositoryComponent;
import arch.in.clean_arch_poc.ui.base.ActivityScope;

@ActivityScope
@Component(modules = {DetailActivityModule.class} ,dependencies = RepositoryComponent.class)
public interface DetailActivityComponent {

    void inject(DetailActivity detailActivity);


}