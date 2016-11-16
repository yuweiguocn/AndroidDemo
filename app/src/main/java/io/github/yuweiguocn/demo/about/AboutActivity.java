package io.github.yuweiguocn.demo.about;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import io.github.yuweiguocn.demo.R;
import io.github.yuweiguocn.demo.base.BaseActivity;
import io.github.yuweiguocn.demo.bean.About;
import io.github.yuweiguocn.demo.databinding.ActivityAboutBinding;


public class AboutActivity extends BaseActivity implements AboutContract.View {

    private ActivityAboutBinding binding;

    AboutPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_about);
        setSupportActionBar(binding.includeToolbar.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.setHandlers(new AboutClickHandlers());
        presenter = new AboutPresenter(this);
        presenter.loadData();
    }

    @Override
    public void onSucess(About about) {
        binding.setAbout(about);
    }

    @Override
    public void setPresenter(AboutContract.Presenter presenter) {

    }
}
