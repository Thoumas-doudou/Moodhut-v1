package com.example.dancerfun;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DancerCommunityItemFragment extends Fragment {
    private RecyclerView mDancerRemarkRecyclerView;
    private DancerRemarkAdapter mRemarkAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_dancer_details,container,false);
        mDancerRemarkRecyclerView=view.findViewById(R.id.rv_dancer_remarks);
        mDancerRemarkRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }
    //实例化dancer_remark布局
    private class DancerRemarkHolder extends RecyclerView.ViewHolder{
        public DancerRemarkHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.list_item_dancer_remark,parent,false));
        }
    }
    private class DancerRemarkAdapter extends RecyclerView.Adapter<DancerRemarkHolder>{
        private List<Dancer> mDancers;
        public DancerRemarkAdapter(List<Dancer> dancers){
            mDancers=dancers;
        }

        @NonNull
        @Override
        public DancerRemarkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater=LayoutInflater.from(getActivity());
            return new DancerRemarkHolder(layoutInflater,parent);
        }

        @Override
        public void onBindViewHolder(@NonNull DancerRemarkHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return mDancers.size();
        }
    }
    private void updateUI(){
        DancerLab dancerLab=DancerLab.getDancerLab(getActivity());
        List<Dancer> dancers=dancerLab.getDancers();

        mRemarkAdapter=new DancerRemarkAdapter(dancers);
        mDancerRemarkRecyclerView.setAdapter(mRemarkAdapter);
    }
}
