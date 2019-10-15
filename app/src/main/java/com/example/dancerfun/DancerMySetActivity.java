package com.example.dancerfun;

import androidx.fragment.app.Fragment;

public class DancerMySetActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new DancerMySetFragment();
    }
}
