package arch.in.clean_arch_poc.ui.Main;

import dagger.Module;
import dagger.Provides;
import arch.in.clean_arch_poc.ui.base.ActivityScope;

/**
 * Created by tony on 19/12/17.
 */
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
