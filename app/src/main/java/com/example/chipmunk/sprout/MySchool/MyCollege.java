package com.example.chipmunk.sprout.MySchool;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.chipmunk.sprout.R;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyCollege extends Fragment {

    private RollPagerView rollPagerView;
    private View view;

    public MyCollege() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.homepage, container, false);
        initView();//获取对应控件
        rollPagerViewSet();
        return view;
    }

    private void rollPagerViewSet() {
        rollPagerView.setPlayDelay(3000);//*播放间隔
        rollPagerView.setAnimationDurtion(500);//透明度
        rollPagerView.setAdapter(new rollViewpagerAdapter());//配置适配器
        rollPagerView.setHintView(new ColorPointHintView(getContext(), Color.argb(255, 139, 212, 193), Color.WHITE));
    }

    private void initView() {
        rollPagerView = (RollPagerView) view.findViewById(R.id.rollViewpager);
    }


    private class rollViewpagerAdapter extends StaticPagerAdapter {

        private int[] res = {R.drawable.banner_1
                , R.drawable.banner_2,
                R.drawable.banner_3,
                R.drawable.banner_4};

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView imageView = new ImageView(container.getContext());
            imageView.setImageResource(res[position]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            return imageView;
        }

        @Override
        public int getCount() {
            return res.length;
        }
    }

}
