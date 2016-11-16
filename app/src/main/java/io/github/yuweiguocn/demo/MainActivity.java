package io.github.yuweiguocn.demo;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.github.yuweiguocn.demo.about.AboutActivity;
import io.github.yuweiguocn.demo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(binding.includeToolbar.toolbar);

        MainFragment fragment = new MainFragment(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_content, fragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        startActivity(new Intent(this, AboutActivity.class));
        return true;
    }


    public static class MainFragment extends ListFragment{

        private Context mContext;

        public MainFragment(Context mContext) {
            this.mContext = mContext;
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setListAdapter(new SimpleAdapter(mContext, getData(),
                    android.R.layout.simple_list_item_1, new String[] { "title" },
                    new int[] { android.R.id.text1 }));
        }

        protected List<Map<String, Object>> getData() {
            List<Map<String, Object>> myData = new ArrayList<Map<String, Object>>();

            Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
            mainIntent.addCategory("android.intent.category.DEMO");

            PackageManager pm = mContext.getPackageManager();
            List<ResolveInfo> list = pm.queryIntentActivities(mainIntent, 0);

            if (null == list)
                return myData;

            int len = list.size();
            for (int i = 0; i < len; i++) {
                ResolveInfo info = list.get(i);
                CharSequence labelSeq = info.loadLabel(pm);
                String label = labelSeq != null
                        ? labelSeq.toString()
                        : info.activityInfo.name;
                addItem(myData, label, activityIntent(
                        info.activityInfo.applicationInfo.packageName,
                        info.activityInfo.name));
            }

            Collections.sort(myData, sDisplayNameComparator);

            return myData;
        }

        private final static Comparator<Map<String, Object>> sDisplayNameComparator =
                new Comparator<Map<String, Object>>() {
                    private final Collator   collator = Collator.getInstance();

                    public int compare(Map<String, Object> map1, Map<String, Object> map2) {
                        return collator.compare(map1.get("title"), map2.get("title"));
                    }
                };

        protected Intent activityIntent(String pkg, String componentName) {
            Intent result = new Intent();
            result.setClassName(pkg, componentName);
            return result;
        }


        protected void addItem(List<Map<String, Object>> data, String name, Intent intent) {
            Map<String, Object> temp = new HashMap<String, Object>();
            temp.put("title", name);
            temp.put("intent", intent);
            data.add(temp);
        }

        @Override
        @SuppressWarnings("unchecked")
        public void onListItemClick(ListView l, View v, int position, long id) {
            Map<String, Object> map = (Map<String, Object>)l.getItemAtPosition(position);

            Intent intent = new Intent((Intent) map.get("intent"));
            intent.addCategory(Intent.CATEGORY_SAMPLE_CODE);
            startActivity(intent);
        }
    }

}
