package com.example.dancerfun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class DancerActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {
    private Button mBackButton;
    private TextView mTitleTextView;
    private Button mFunctionButton;
    private RadioGroup mTabbarRadioGroup;
    private RadioButton mCommunityRadioButton;
    private RadioButton mHomeRadioButton;
    private RadioButton mMyRadioButton;
    private ViewPager mViewPager;
    private MyFragmentPagerAdapter mPagerAdapter;
    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        mPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        bindViews();
        setBottomTabbar();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_community:
                mViewPager.setCurrentItem(PAGE_ONE);
                break;
            case R.id.rb_home:
                mViewPager.setCurrentItem(PAGE_TWO);
                break;
            case R.id.rb_my:
                mViewPager.setCurrentItem(PAGE_THREE);
                break;
        }
    }
    //重写ViewPager页面切换的处理方法
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        switch (position){
            case PAGE_ONE:
                break;
            case PAGE_TWO:
                break;
            case PAGE_THREE:
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        //state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
        if (state == 2) {
            switch (mViewPager.getCurrentItem()) {
                case PAGE_ONE:
                    mCommunityRadioButton.setChecked(true);
                    break;
                case PAGE_TWO:
                    mHomeRadioButton.setChecked(true);
                    break;
                case PAGE_THREE:
                    mMyRadioButton.setChecked(true);
                    break;
            }
        }
    }
    //设置底部导航栏
    private void setBottomTabbar() {
        mCommunityRadioButton=findViewById(R.id.rb_community);
        mHomeRadioButton=findViewById(R.id.rb_home);
        mMyRadioButton=findViewById(R.id.rb_my);

        Drawable communityDrawable=getResources().getDrawable(R.drawable.tab_menu_community);
        Drawable homeDrawable=getResources().getDrawable(R.drawable.tab_menu_home);
        Drawable myDrawable=getResources().getDrawable(R.drawable.tab_menu_my);

        communityDrawable.setBounds(0,0,70,70);
        homeDrawable.setBounds(0,0,70,70);
        myDrawable.setBounds(0,0,70,70);

        mCommunityRadioButton.setCompoundDrawables(null, communityDrawable, null, null);
        mHomeRadioButton.setCompoundDrawables(null, homeDrawable, null, null);
        mMyRadioButton.setCompoundDrawables(null, myDrawable, null, null);
    }
    //绑定适配器
    private void bindViews() {
        mTabbarRadioGroup=findViewById(R.id.rg_tab_bar);
        mCommunityRadioButton=findViewById(R.id.rb_community);
        mHomeRadioButton=findViewById(R.id.rb_home);
        mMyRadioButton=findViewById(R.id.rb_my);
        mTabbarRadioGroup.setOnCheckedChangeListener(this);

        mViewPager = findViewById(R.id.vpager);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setCurrentItem(0);
        mViewPager.addOnPageChangeListener(this);
    }
}
