package com.foumiu.start.bangwo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.foumiu.start.bangwo.R;

/**
 * Created by dabo on 2018/6/24.
 */

public class MainMineFragment extends Fragment {

    public MainMineFragment() {
    }

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_main_mine, null);
            initViews();
        }
        return view;
    }

    private void initViews() {
    }
}
