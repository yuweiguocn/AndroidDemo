package io.github.yuweiguocn.demo.transition;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import io.github.yuweiguocn.demo.R;
import io.github.yuweiguocn.demo.base.BaseActivity;
import io.github.yuweiguocn.demo.databinding.ActivityTransitionResultBinding;

public class TransitionResultActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decor = ((Activity)mContext).getWindow().getDecorView();
        View statusBar = decor.findViewById(android.R.id.statusBarBackground);
//        View navBar = decor.findViewById(android.R.id.navigationBarBackground);
//        View actionBar = decor.findViewById(mContext.getResources().getIdentifier(
//                "action_bar_container", "id", "android"));
        decor.setTransitionName("decor");
//        statusBar.setTransitionName("statusBar");
//        navBar.setTransitionName("navBar");
//        actionBar.setTransitionName("actionBar");
        ActivityTransitionResultBinding binding= DataBindingUtil.setContentView(this, R.layout.activity_transition_result);
//        setSupportActionBar(binding.includeToolbar.toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        int img = getIntent().getIntExtra("img", -1);
        binding.ivContent.setImageResource(img);
        binding.llContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionResultActivity.this.finishAfterTransition();
            }
        });
    }
}
