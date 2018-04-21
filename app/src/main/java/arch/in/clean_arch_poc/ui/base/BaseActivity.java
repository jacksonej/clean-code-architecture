package arch.in.clean_arch_poc.ui.base;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import arch.in.clean_arch_poc.data.repository.RepositoryComponent;

public class BaseActivity extends AppCompatActivity implements BaseView {


    @Override
    public void onUnknownError(String errorMessage) {
        Toast.makeText(this,errorMessage,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTimeout() {
        Toast.makeText(this,"Timeout",Toast.LENGTH_SHORT).show();

    }


   protected RepositoryComponent getRepositoryComponent() {
        return ((AndroidAppication)getApplication()).getRepositoryComponent();
    }

    @Override
    public void onNetworkError() {
        Toast.makeText(this,"Network Error",Toast.LENGTH_SHORT).show();
    }
}
