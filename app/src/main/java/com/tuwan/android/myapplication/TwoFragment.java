package com.tuwan.android.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tuwan.android.myapplication.nextviewpager.FirstFragment1;
import com.tuwan.android.myapplication.nextviewpager.FragAdapter1;
import com.tuwan.android.myapplication.nextviewpager.ThreeFragment1;
import com.tuwan.android.myapplication.nextviewpager.TwoFragment1;
import com.tuwan.android.myapplication.viewpager.MyViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gumenghao on 2018/5/14.
 */

@SuppressLint("ValidFragment")
public class TwoFragment extends Fragment {

    private MyViewPager vp_viewpager;
    private List<Fragment> listFragment = new ArrayList<>();
    private FragmentManager fm;

    public TwoFragment(FragmentManager fm) {
        this.fm = fm;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_layout2, null);

        initList();

        vp_viewpager = (MyViewPager) view.findViewById(R.id.vp_viewpager);
        vp_viewpager.setOffscreenPageLimit(3);
        vp_viewpager.setAdapter(new FragAdapter1(getChildFragmentManager(), listFragment, getActivity()));

        return view;

    }

    private void initList() {
        listFragment.clear();
        listFragment.add(new FirstFragment1());
        listFragment.add(new TwoFragment1());
        listFragment.add(new ThreeFragment1());
    }

}
