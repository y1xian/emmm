package com.yyxnb.amazing.fragments.vp;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.yyxnb.amazing.R;
import com.yyxnb.amazing.widget.BaseFragmentPagerAdapter;
import com.yyxnb.arch.base.BaseFragment;
import com.yyxnb.common.DpUtils;
import com.yyxnb.common.log.LogUtils;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class VpMainFragment extends BaseFragment {

    private MagicIndicator mIndicator;
    private ViewPager mViewPager;
    private String[] titles = {"1111", "2222", "3333"};
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    public int initLayoutResId() {
        return R.layout.fragment_vp_main;
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_vp_main, container, false);
//    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mIndicator = findViewById(R.id.mIndicator);
        mViewPager = findViewById(R.id.page);
//        tabLayout = getView().findViewById(R.id.tab_layout);
//        viewPager = getView().findViewById(R.id.page);

//        fragments.add(Vp1Fragment.newInstance());
//        fragments.add(Vp2Fragment.newInstance());
//        fragments.add(Vp3Fragment.newInstance());

//        fragments.add(new Vp3Fragment());
//        fragments.add(new Vp3Fragment());
//        fragments.add(new Vp3Fragment());

        fragments.add(new Vp1Fragment());
        fragments.add(new Vp1Fragment());
        fragments.add(new Vp1Fragment());

        CommonNavigator commonNavigator = new CommonNavigator(getContext());
        //ture 即标题平分屏幕宽度的模式
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {

            @Override
            public int getCount() {
                return titles.length;
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
                colorTransitionPagerTitleView.setNormalColor(Color.GRAY);
                colorTransitionPagerTitleView.setSelectedColor(Color.BLACK);
                colorTransitionPagerTitleView.setText(titles[index]);
                colorTransitionPagerTitleView.setOnClickListener(view -> mViewPager.setCurrentItem(index));
                return colorTransitionPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                //设置宽度
//                indicator.setLineWidth(DpUtils.dp2px(mContext,30));
                //设置高度
                indicator.setLineHeight(DpUtils.dp2px(getContext(), 5));
                //设置颜色
                indicator.setColors(Color.parseColor("#FF9241"));
                //设置圆角
                indicator.setRoundRadius(5);
                //设置模式
                indicator.setMode(LinePagerIndicator.MODE_WRAP_CONTENT);
                return indicator;
            }
        });
        mIndicator.setNavigator(commonNavigator);

        mViewPager.setOffscreenPageLimit(titles.length - 1);
        mViewPager.setAdapter(new BaseFragmentPagerAdapter(getChildFragmentManager(), fragments, Arrays.asList(titles)));
        //与ViewPagger联动
        ViewPagerHelper.bind(mIndicator, mViewPager);

    }

    @Override
    public void initViewData() {
        LogUtils.w("initViewData m: " + hashCode());
    }

    @Override
    public void onVisible() {
        LogUtils.w("onVisible m: " + hashCode());
    }

    @Override
    public void onInVisible() {
        LogUtils.w("onInVisible m: " + hashCode());
    }
}