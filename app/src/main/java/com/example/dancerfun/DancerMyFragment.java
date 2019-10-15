package com.example.dancerfun;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DancerMyFragment extends Fragment implements View.OnClickListener{
    private ImageView mBackImageView;
    private TextView mTitleTextView;
    private TextView mFunctionTextView;
    private ImageView mMoreImageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        mFunctionTextView=view.findViewById(R.id.tv_function);
        mFunctionTextView.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_function:
                Intent intent=new Intent(getActivity(),DancerMySetActivity.class);
                startActivity(intent);
                break;
        }
    }
}
