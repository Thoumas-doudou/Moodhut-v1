package com.example.dancerfun;

import android.os.Bundle;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
//复用代码，创建抽象超类
public abstract class SingleFragmentActivity extends AppCompatActivity {
    protected abstract Fragment createFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        FragmentManager fragmentManager=getSupportFragmentManager();
        //获取容器视图
        Fragment fragment=fragmentManager.findFragmentById(R.id.fl_fragment_container);
        if(fragment == null){
            fragment=createFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.fl_fragment_container,fragment)
                    .commit();
        }
    }
}
