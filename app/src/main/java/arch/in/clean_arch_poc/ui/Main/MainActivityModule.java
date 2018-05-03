package arch.in.clean_arch_poc.ui.Main;

import arch.in.clean_arch_poc.ui.base.ActivityScope;
import dagger.Module;
import dagger.Provides;


@ActivityScope
@Module
public class MainActivityModule {

    private MainActivityContract.View mView;


    public MainActivityModule(MainActivityContract.View view) {
        mView = view;

    }





    @Provides
    public MainActivityContract.View getProvideView() {
        return mView;
    }
}
