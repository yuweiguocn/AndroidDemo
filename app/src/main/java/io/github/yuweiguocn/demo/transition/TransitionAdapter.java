package io.github.yuweiguocn.demo.transition;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import io.github.yuweiguocn.demo.R;
import io.github.yuweiguocn.demo.databinding.ItemImageBinding;


/**
 * Created by growth on 3/1/17.
 */

public class TransitionAdapter extends RecyclerView.Adapter<TransitionAdapter.ViewHolder> {

    private Context mContext;
    LayoutInflater mLayoutInflater;
    private int[] images = {
            R.drawable.example1,
            R.drawable.example2,
            R.drawable.example3,
            R.drawable.example4,
            R.drawable.example5,
            R.drawable.example6,
            R.drawable.example7,
            R.drawable.example8,
            R.drawable.example9
    };

    public TransitionAdapter(Context mContext) {
        this.mContext = mContext;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mLayoutInflater.inflate(R.layout.item_image, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.imageView.setImageResource(images[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDetail(images[position], v);
            }
        });
    }

    private void showDetail(int image,View view) {
        Intent intent = new Intent(mContext, TransitionResultActivity.class);
        View decor = ((Activity)mContext).getWindow().getDecorView();
        View statusBar = decor.findViewById(android.R.id.statusBarBackground);
//        View navBar = decor.findViewById(android.R.id.navigationBarBackground);
//        View actionBar = decor.findViewById(android.R.id.action_bar_container);
        Pair<View, String> p1 = Pair.create(decor, "decor");
        Pair<View, String> p2 = Pair.create(statusBar, "statusBar");
//        Pair<View, String> p3 = Pair.create(navBar, "navBar");
//        Pair<View, String> p4 = Pair.create(actionBar, "actionBar");
        Pair<View, String> p5 = Pair.create(view, mContext.getResources().getString(R.string.transition_name));
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation((Activity) mContext, p1, p2, p5);
//        ActivityOptions options = ActivityOptions
//                .makeSceneTransitionAnimation((Activity) mContext, view, mContext.getResources().getString(R.string.transition_name));
        intent.putExtra("img", image);
        mContext.startActivity(intent, options.toBundle());
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ItemImageBinding binding;

        public ItemImageBinding getBinding() {
            return binding;
        }

        private ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
            imageView = binding.ivItem;
        }
    }
}
