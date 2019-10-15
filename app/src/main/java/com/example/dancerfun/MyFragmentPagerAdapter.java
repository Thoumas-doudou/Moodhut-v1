package com.example.dancerfun;

import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private final int PAGER_COUNT = 3;

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public int getCount() {
        return PAGER_COUNT;
    }

    @Override
    public Object instantiateItem(ViewGroup vg, int position) {
        return super.instantiateItem(vg, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case DancerActivity.PAGE_ONE:
                fragment = new DancerCommunityFragment();
                break;
            case DancerActivity.PAGE_TWO:
                fragment = new DancerHomeFragment();
                break;
            case DancerActivity.PAGE_THREE:
                fragment = new DancerMyFragment();
                break;
        }
        return fragment;
    }
}
