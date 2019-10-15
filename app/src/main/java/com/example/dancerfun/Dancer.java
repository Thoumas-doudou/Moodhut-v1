package com.example.dancerfun;

import android.widget.ImageView;

import java.util.Date;
import java.util.UUID;

public class Dancer {
    private UUID mId;
    private ImageView mAvatars;
    private String mNickname;
    private Date mDate;
    private String mContentText;
    private ImageView mContentImage;


    public String getNickname() {
        return mNickname;
    }

    public void setNickname(String nickname) {
        mNickname = nickname;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
    }
}
