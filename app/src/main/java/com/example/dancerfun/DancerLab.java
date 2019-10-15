package com.example.dancerfun;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//创建舞者动态数据集中池单例
public class DancerLab {
    private static DancerLab sDancerLab;
    private List<Dancer> mDancers;
    public static DancerLab getDancerLab(Context context){
        if(sDancerLab == null){
            sDancerLab=new DancerLab(context);
        }
        return sDancerLab;
    }
    //私有构造方法
    private DancerLab(Context context){
        mDancers=new ArrayList<>();
        for (int i=0;i<100;i++){
            Dancer dancer=new Dancer();
            dancer.setNickname("昵称 #"+i);
            mDancers.add(dancer);
        }
    }

    public List<Dancer> getDancers() {
        return mDancers;
    }

    public Dancer getDancer(UUID id){
        for (Dancer dancer:mDancers){
            if(dancer.getId().equals(id)){
                return dancer;
            }
        }
        return null;
    }
}
