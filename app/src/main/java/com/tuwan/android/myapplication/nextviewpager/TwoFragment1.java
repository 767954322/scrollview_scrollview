package com.tuwan.android.myapplication.nextviewpager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tuwan.android.myapplication.FirstFragment;
import com.tuwan.android.myapplication.FragAdapter;
import com.tuwan.android.myapplication.R;
import com.tuwan.android.myapplication.ThreeFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gumenghao on 2018/5/14.
 */

@SuppressLint("ValidFragment")
public class TwoFragment1 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_layout_2, null);


        return view;

    }


}
