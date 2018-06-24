package com.foumiu.start.bangwo.fragment;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.foumiu.start.bangwo.R;
import com.foumiu.start.bangwo.Utils.Logger;

import java.util.List;

/**
 * Created by dabo on 2018/6/24.
 */

public class SecondTestFragment extends Fragment {

    private View view;
    private Bundle mBundle;

    public SecondTestFragment() {
    }

    @SuppressLint("ValidFragment")
    public SecondTestFragment(Bundle bundle) {
        mBundle = bundle;
    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            ActivityManager am = (ActivityManager) getActivity().getSystemService(Context.ACTIVITY_SERVICE);
            List<ActivityManager.RunningTaskInfo> runningTaskInfoList = am.getRunningTasks(2);
            for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTaskInfoList) {
                Logger.d("id: " + runningTaskInfo.id);
                Logger.d("description: " + runningTaskInfo.description);
                Logger.d("topActivity: " + runningTaskInfo.topActivity);
                Logger.d("baseActivity: " + runningTaskInfo.baseActivity.toString());
                Logger.d("number of activities: " + runningTaskInfo.numActivities);

            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_first_test, null);
            initViews();
        }

        return view;
    }

    private void initViews() {
        TextView tv = view.findViewById(R.id.text);
        tv.setText("這是第二個測試頁");
    }

    @Override
    public void onResume() {
        super.onResume();
       // mHandler.sendEmptyMessageDelayed(0, 1000);
    }
}
