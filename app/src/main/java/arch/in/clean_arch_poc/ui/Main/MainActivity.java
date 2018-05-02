package arch.in.clean_arch_poc.ui.Main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import arch.in.clean_arch_poc.R;
import arch.in.clean_arch_poc.data.api.MyService;
import arch.in.clean_arch_poc.domain.model.GithubContributor;
import arch.in.clean_arch_poc.ui.base.BaseActivity;
import arch.in.clean_arch_poc.ui.view.adapter.CustomAdapter;

public class MainActivity extends BaseActivity implements MainActivityContract.View {

    ArrayList<GithubContributor> mGithubContributors = new ArrayList<>();
    CustomAdapter customAdapter;

    @Inject
    MainActivityPresenter presenter;



    @Inject
    MyService service;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializePresenter();
        presenter.getApiCall();
        presenter.check();
        setupRecyclerView();
      // Log.d("hai",service.getString());

    }

    private void initializePresenter() {
        MainActivityComponent build = DaggerMainActivityComponent.builder()
                .mainActivityModule(new MainActivityModule(this))
                .repositoryComponent(getRepositoryComponent())
                .build();
        build.inject(this);

    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        customAdapter = new CustomAdapter(this, mGithubContributors);
        recyclerView.setAdapter(customAdapter);
    }


    @Override
    public void setView(List<GithubContributor> githubContributors) {
        mGithubContributors.addAll(githubContributors);
        customAdapter.notifyDataSetChanged();
    }


    @Override
    public void onNetworkError() {
        super.onNetworkError();
    }
}

