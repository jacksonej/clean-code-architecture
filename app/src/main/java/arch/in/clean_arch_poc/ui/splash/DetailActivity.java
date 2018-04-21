package arch.in.clean_arch_poc.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import arch.in.clean_arch_poc.R;
import arch.in.clean_arch_poc.data.model.ArticleDetail;
import arch.in.clean_arch_poc.ui.base.BaseActivity;

public class DetailActivity extends BaseActivity implements DetailActivityContract.View{

    @Inject
    DetailPresenter presenter;

    @BindView(R.id.textName)
    TextView txtName;

    @BindView(R.id.texturl)
    TextView txtUrl;
    @BindView(R.id.textCompany)
    TextView txtCompany;
    @BindView(R.id.textLocation)
    TextView txtLocation;

    @BindView(R.id.imageView)
    CircleImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ButterKnife.bind(this);

        Intent i=getIntent();
        String login=i.getStringExtra("login");

        initializePresenter();
        presenter.getApiCall(login);

    }


    private void initializePresenter() {
        DetailActivityComponent build = DaggerDetailActivityComponent.builder()
                .detailActivityModule(new DetailActivityModule(this))
                .repositoryComponent(getRepositoryComponent())
                .build();
        build.inject(this);

    }

    @Override
    public void setView(ArticleDetail detail) {
        txtName.setText(detail.getName());
        txtCompany.setText(detail.getCompany());
        txtLocation.setText(detail.getLocation());
        txtUrl.setText(detail.getHtmlUrl());
        RequestOptions options = new RequestOptions();
        Glide.with(this)
                .load(detail.getAvatarUrl())
                .apply(options.fitCenter())
                .into(image);
    }
}
