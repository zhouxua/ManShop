package com.zhouxuan.manshop.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhouxuan.manshop.R;
import com.zhouxuan.manshop.home.adapter.HomeAdapter;
import com.zhouxuan.manshop.home.bean.HomeBean;
import com.zhouxuan.manshop.home.parsenter.Iparsenter;
import com.zhouxuan.manshop.home.view.Iview;
import com.zhouxuan.manshop.utils.Api;

import java.util.List;

/**
 * 周旋
 * 2017/11/8  18:53
 */

public class Fragmenter1 extends Fragment implements Iview{
    Iparsenter iparsenter;
    private RecyclerView mRecyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View  view= View.inflate(getActivity(),R.layout.fragmenter_home,null);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.id_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        iparsenter = new Iparsenter(this);
        iparsenter.setNews(Api.BASE_PATH);

        return view;
    }

    @Override
    public void getData(HomeBean homeData) {
        HomeAdapter adapter = new HomeAdapter(getActivity(), homeData);
        mRecyclerView.setAdapter(adapter);
    }
}
