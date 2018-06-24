package com.foumiu.start.bangwo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.foumiu.start.bangwo.R;
import com.foumiu.start.bangwo.StubActivity;

/**
 * Created by dabo on 2018/6/24.
 */

public class MainPublishFragment extends Fragment {
    public MainPublishFragment() {
    }

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_main_publish, null);
            initViews();
        }
        return view;
    }

    private void initViews() {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), StubActivity.class);
                Bundle bundle = new Bundle();
                intent.putExtra(StubActivity.BUNDLE, bundle);
                intent.putExtra(StubActivity.FRAGMENT_CLASS, FirstTestFragment.class);
                startActivity(intent);
            }
        });
    }
}
