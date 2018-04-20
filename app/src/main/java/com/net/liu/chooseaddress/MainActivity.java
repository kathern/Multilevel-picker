package com.net.liu.chooseaddress;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.net.liu.chooseaddress.adapter.AreaAdapter;

public class MainActivity extends AppCompatActivity implements AreaAdapter.OnItemClick {

    private TabLayout mTabLayout;
    private RecyclerView mRecyclerView;
    private AreaAdapter adapter;

    private String url = "http://192.168.105.87/exapi/api/v1.0/SmartData/GetHotWord";
    private String[] data = new String[]{"姓名", "年龄", "身高", "日期"};
    private int mCurrentTab = 0;
    private int mTabCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setData();
    }

    private void initView() {
        mTabLayout = findViewById(R.id.tabLayout);
        mRecyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mTabLayout.addTab(mTabLayout.newTab().setText("请选择"), true);
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                System.out.println("select");
                mCurrentTab = tab.getPosition();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                System.out.println("select");
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void setData() {
        data = new String[]{"姓名", "年龄", "身高", "日期"};
        setAdapter();
    }

    private void setAdapter() {
        adapter = new AreaAdapter(this, data);
        mRecyclerView.setAdapter(adapter);
        adapter.setOnItemClick(this);
    }

    @Override
    public void click(String name, int pos) {
        mTabLayout.getTabAt(mCurrentTab).setText(name);
        mTabCount = mTabLayout.getTabCount();
        if (mCurrentTab < mTabCount - 1) {
            mTabLayout.getTabAt(mCurrentTab + 1).select();
        } else {
            mTabLayout.addTab(mTabLayout.newTab().setText("请选择"), true);
            setAdapter();
        }

    }
}
