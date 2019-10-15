package com.example.dancerfun;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CustomTitleBar extends RelativeLayout {
    private ImageView mBackImageView;
    private TextView mTitleTextView;
    private TextView mFunctionTextView;
    private ImageView mMoreImageView;

    public CustomTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context,attrs);
    }

    //初始化视图
    private void initView(final Context context, AttributeSet attributeSet) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_titlebar, this);
        mBackImageView = inflate.findViewById(R.id.iv_back);
        mTitleTextView = inflate.findViewById(R.id.tv_title);
        mFunctionTextView = inflate.findViewById(R.id.tv_function);
        mMoreImageView=inflate.findViewById(R.id.iv_more);
        init(context,attributeSet);
    }

    //初始化资源文件
    public void init(Context context, AttributeSet attributeSet) {
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.CustomTitleBar);

        String title = typedArray.getString(R.styleable.CustomTitleBar_title);//标题
        int back = typedArray.getResourceId(R.styleable.CustomTitleBar_back, 0);//左边图片
        String function = typedArray.getString(R.styleable.CustomTitleBar_function);//左边图片
        int more = typedArray.getResourceId(R.styleable.CustomTitleBar_more, 0);//右边图片
//        boolean titleBar = typedArray.getBoolean(R.styleable.CustomTitleBar_titlebar,true);//标题栏类型,默认为10

        //赋值进去我们的标题栏
        mBackImageView.setImageResource(back);
        mTitleTextView.setText(title);
        mFunctionTextView.setText(function);
        mMoreImageView.setImageResource(more);
    }
    //点击事件
    public void setBackOnClickListener(OnClickListener l){
        mBackImageView.setOnClickListener(l);
    }

    public void setFunctionOnClickListener(OnClickListener l){
        mFunctionTextView.setOnClickListener(l);
    }

    public void setMoreOnClickListener(OnClickListener l){
        mMoreImageView.setOnClickListener(l);
    }
}

