package com.hencoder.praticedraw6;

import android.os.Bundle;
import android.view.Menu;

import androidx.annotation.LayoutRes;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.hencoder.hencoderpratice.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager pager;
    List<PageModel> pageModels = new ArrayList<>();

    {
        pageModels.add(new PageModel(R.layout.sample6_translation, R.string.title_translation, R.layout.practice6_translation));
        pageModels.add(new PageModel(R.layout.sample6_rotation, R.string.title_rotation, R.layout.practice6_rotation));
        pageModels.add(new PageModel(R.layout.sample6_scale, R.string.title_scale, R.layout.practice6_scale));
        pageModels.add(new PageModel(R.layout.sample6_alpha, R.string.title_alpha, R.layout.practice6_alpha));
        pageModels.add(new PageModel(R.layout.sample6_multi_properties, R.string.title_multi_properties, R.layout.practice6_multi_properties));
        pageModels.add(new PageModel(R.layout.sample6_duration, R.string.title_duration, R.layout.practice6_duration));
        pageModels.add(new PageModel(R.layout.sample6_interpolator, R.string.title_interpolator, R.layout.practice6_interpolator));
        pageModels.add(new PageModel(R.layout.sample6_object_anomator, R.string.title_object_animator, R.layout.practice6_object_animator));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                PageModel pageModel = pageModels.get(position);
                return PageFragment.newInstance(pageModel.sampleLayoutRes, pageModel.practiceLayoutRes);
            }

            @Override
            public int getCount() {
                return pageModels.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return getString(pageModels.get(position).titleRes);
            }
        });

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(pager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    private class PageModel {
        @LayoutRes
        int sampleLayoutRes;
        @StringRes
        int titleRes;
        @LayoutRes int practiceLayoutRes;

        PageModel(@LayoutRes int sampleLayoutRes, @StringRes int titleRes, @LayoutRes int practiceLayoutRes) {
            this.sampleLayoutRes = sampleLayoutRes;
            this.titleRes = titleRes;
            this.practiceLayoutRes = practiceLayoutRes;
        }
    }
}
