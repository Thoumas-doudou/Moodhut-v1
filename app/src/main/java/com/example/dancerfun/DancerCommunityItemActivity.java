package com.example.dancerfun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class DancerCommunityItemActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new DancerCommunityItemFragment();
    }
}
