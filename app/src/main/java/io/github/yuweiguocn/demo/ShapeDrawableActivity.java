package io.github.yuweiguocn.demo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import io.github.yuweiguocn.demo.base.BaseActivity;
import io.github.yuweiguocn.demo.databinding.ActivityShapeDrawableBinding;

public class ShapeDrawableActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityShapeDrawableBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_shape_drawable);
        setSupportActionBar(binding.includeToolbar.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
