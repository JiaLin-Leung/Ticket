package com.TrictSystem.Tools;

import android.content.Context;

import com.TrictSystem.Tools.circleprogress.CircleProgress;

/**
 * Created by smile_raccoon on 2018/1/11.
 */

public class utils {

    private CircleProgress mProgressView;
    public void showCircleProgress(Context context){
        if (mProgressView == null){
            mProgressView = new CircleProgress(context);
        }
        mProgressView.startAnim();
    }

    public void stopCircleProgress(Context context){
        if (mProgressView == null){
            return;
        }
        mProgressView.stopAnim();
    }
}
