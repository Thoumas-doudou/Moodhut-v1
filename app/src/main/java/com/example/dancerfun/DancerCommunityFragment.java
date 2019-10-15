package com.example.dancerfun;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Date;
import java.util.List;

public class DancerCommunityFragment extends Fragment {
    private RecyclerView mDancerRecyclerView;
    private DancerAdapter mDancerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_community,container,false);

        mDancerRecyclerView=view.findViewById(R.id.rv_dancer_community);
        //转交给LayoutManager管理
        mDancerRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }
    //创建Holder内部类，帮助RecyclerView容纳实例化列表元素
    //接口实现点击响应
    private class DancerHodler extends RecyclerView.ViewHolder implements View.OnClickListener{
        private Dancer mDancer;
        private ImageView mAvatarsImageView;
        private TextView mNicknameTextView;
        private TextView mContentDate;
        private TextView mContentTextView;
        private ImageView mContentImageView;
        private ImageView mTransmitImageView;
        private ImageView mRemarkImageView;
        private ImageView mSupportImageView;
        public DancerHodler(LayoutInflater inflater,ViewGroup container){
            super(inflater.inflate(R.layout.list_item_community,container,false));
            itemView.setOnClickListener(this);
//            mAvatarsImageView=itemView.findViewById(R.id.iv_dancer_avatars);
            mNicknameTextView=itemView.findViewById(R.id.tv_dancer_nickname);
            mContentDate=itemView.findViewById(R.id.tv_dancer_date);
//            mContentTextView=itemView.findViewById(R.id.tv_dancer_contentText);
//            mContentImageView=itemView.findViewById(R.id.iv_dancer_contentImage);
//            mTransmitImageView=itemView.findViewById(R.id.iv_dancer_transmit);
//            mRemarkImageView=itemView.findViewById(R.id.iv_dancer_remark);
//            mSupportImageView=itemView.findViewById(R.id.iv_dancer_support);
        }
        //实现超类的抽象响应点击方法
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(getActivity(),DancerCommunityItemActivity.class);
            startActivity(intent);
        }

        //每次新的dancer来都要调用刷新
        //待补
        public void bind(Dancer dancer){
            mDancer=dancer;
            mNicknameTextView.setText(mDancer.getNickname());
            mContentDate.setText(formatDate(mDancer.getDate()));
        }
        //日期格式化处理
        private String formatDate(Date date){
//            Calendar calendar=Calendar.getInstance();
//
//            calendar.setTime(date);
//            int day=calendar.get(Calendar.DAY_OF_MONTH);
//
//            Date nowDate=new Date();
//            calendar.setTime(nowDate);
//            int nowDay=calendar.get(Calendar.DAY_OF_MONTH);
            return "今天 13：06";
        }
    }
    //创建Adapter内部类，帮助RecyclerView创建并适配绑定Holder，控制模型层到视图层的转变
    private class DancerAdapter extends RecyclerView.Adapter<DancerHodler>{
        private List<Dancer> mDancers;
        public DancerAdapter(List<Dancer> dancers){
            mDancers=dancers;
        }

        @NonNull
        @Override
        public DancerHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater=LayoutInflater.from(getActivity());
            return new DancerHodler(layoutInflater,parent);
        }

        @Override
        public void onBindViewHolder(@NonNull DancerHodler holder, int position) {
            Dancer dancer=mDancers.get(position);
            holder.bind(dancer);
        }

        @Override
        public int getItemCount() {
            return mDancers.size();
        }
    }
    //创建私有更新UI的方法,将数据和适配器绑定
    private void updateUI(){
        DancerLab dancerLab=DancerLab.getDancerLab(getActivity());
        List<Dancer> dancers=dancerLab.getDancers();

        mDancerAdapter=new DancerAdapter(dancers);
        mDancerRecyclerView.setAdapter(mDancerAdapter);
    }
}
