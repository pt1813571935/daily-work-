package com.umeng.shixunkaoshi;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.umeng.shixunkaoshi.adapter.VpAdapter;
import com.umeng.shixunkaoshi.fragment.ClassifyFragment;
import com.umeng.shixunkaoshi.fragment.FirstPageFragment;
import com.umeng.shixunkaoshi.fragment.MyFragment;
import com.umeng.shixunkaoshi.fragment.ShopFragment;
import com.umeng.shixunkaoshi.fragment.TopicFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager mVp;
    private TabLayout mTab;
    private ArrayList<Fragment> fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragment();

    }

    private void initFragment() {
        fm = new ArrayList<>();
        fm.add(new FirstPageFragment());
        fm.add(new TopicFragment());
        fm.add(new ClassifyFragment());
        fm.add(new ShopFragment());
        fm.add(new MyFragment());
        VpAdapter adapter = new VpAdapter(getSupportFragmentManager(), fm);
        mVp.setAdapter(adapter);
        mTab.setupWithViewPager(mVp);
        mTab.getTabAt(0).setText("首页").setIcon(R.drawable.page);
        mTab.getTabAt(1).setText("专题").setIcon(R.drawable.topic);
        mTab.getTabAt(2).setText("分类").setIcon(R.drawable.classify);
        mTab.getTabAt(3).setText("购物").setIcon(R.drawable.shop);
        mTab.getTabAt(4).setText("我的").setIcon(R.drawable.my);
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        mTab = (TabLayout) findViewById(R.id.tab);
    }
}
