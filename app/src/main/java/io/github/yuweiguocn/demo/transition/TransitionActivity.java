package io.github.yuweiguocn.demo.transition;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;

import io.github.yuweiguocn.demo.R;
import io.github.yuweiguocn.demo.base.BaseActivity;
import io.github.yuweiguocn.demo.databinding.ActivityTransitionBinding;


public class TransitionActivity extends BaseActivity{
    ActivityTransitionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_transition);
        setSupportActionBar(binding.includeToolbar.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.rvData.setHasFixedSize(true);
        binding.rvData.setLayoutManager(new GridLayoutManager(this, 2));
        binding.rvData.setAdapter(new TransitionAdapter(this));

    }
}
