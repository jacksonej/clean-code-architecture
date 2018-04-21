package arch.in.clean_arch_poc.ui.splash;

import dagger.Module;
import dagger.Provides;
import arch.in.clean_arch_poc.ui.base.ActivityScope;

/**
 * Created by tony on 19/12/17.
 */
@ActivityScope
@Module
public class DetailActivityModule {

    private DetailActivityContract.View mView;


    public DetailActivityModule(DetailActivityContract.View view) {
        mView = view;

    }

    @Provides
    public DetailActivityContract.View getProvideView() {
        return mView;
    }
}
