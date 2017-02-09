package com.bwie.myshops;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.myshops.fragment.FavorableFragment;
import com.bwie.myshops.fragment.MoonshineFragment;
import com.bwie.myshops.fragment.MyFragment;
import com.bwie.myshops.fragment.ShopcartFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView main_tv_home;
    private LinearLayout mian_ll_home, main_ll_home2, mian_ll_home3, mian_ll_home4;
    private TextView mian_tv2_home;
    private TextView main_tv3_home;
    private TextView mian_tv4_home;
    private ImageView main_iv_home;
    private ImageView mian_iv2_home;
    private ImageView main_iv3_home;
    private ImageView mian_iv4_home;
    private FrameLayout frame;
    private Fragment moonshineFragment;
    private Fragment myFragment;
    private Fragment favorableFragment;
    private Fragment shopcartFragment;
    private static  LinearLayout mian_ll_home1;
    private static LinearLayout mian_max_home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiView();
    }
    //获取id
    private void intiView(){
        mian_max_home = (LinearLayout) findViewById(R.id.mian_max_home);
        frame = (FrameLayout) findViewById(R.id.main_frame);
        mian_ll_home = (LinearLayout) findViewById(R.id.mian_ll_home);
        main_ll_home2 = (LinearLayout) findViewById(R.id.main_ll_home2);
        mian_ll_home3 = (LinearLayout) findViewById(R.id.mian_ll_home3);
        mian_ll_home4 = (LinearLayout) findViewById(R.id.mian_ll_home4);
        main_tv_home = (TextView) findViewById(R.id.main_tv_home);
        mian_tv2_home = (TextView) findViewById(R.id.mian_tv2_home);
        main_tv3_home = (TextView) findViewById(R.id.main_tv3_home);
        mian_tv4_home = (TextView) findViewById(R.id.mian_tv4_home);
        main_iv_home = (ImageView) findViewById(R.id.main_iv_home);
        mian_iv2_home = (ImageView) findViewById(R.id.mian_iv2_home);
        main_iv3_home = (ImageView) findViewById(R.id.main_iv3_home);
        mian_iv4_home = (ImageView) findViewById(R.id.mian_iv4_home);

        mian_ll_home.setOnClickListener(this);
        main_ll_home2.setOnClickListener(this);
        mian_ll_home3.setOnClickListener(this);
        mian_ll_home4.setOnClickListener(this);
        initFragment(0);
    }

    @Override
    public void onClick(View view) {
        //重置
        restartBotton();
        switch (view.getId()) {
            case R.id.mian_ll_home:
                main_iv_home.setImageResource(R.drawable.tab_home_s);
                main_tv_home.setTextColor(Color.parseColor("#E63F00"));
                initFragment(0);
                break;
            case R.id.main_ll_home2:
                mian_iv2_home.setImageResource(R.drawable.tab_topic_s);
                mian_tv2_home.setTextColor(Color.parseColor("#E63F00"));
                initFragment(1);
                break;
            case R.id.mian_ll_home3:
                main_iv3_home.setImageResource(R.drawable.main_index_cart_pressed);
                main_tv3_home.setTextColor(Color.parseColor("#E63F00"));
                initFragment(2);
                break;
            case R.id.mian_ll_home4:
                mian_iv4_home.setImageResource(R.drawable.main_index_my_pressed);
                mian_tv4_home.setTextColor(Color.parseColor("#E63F00"));
                initFragment(3);
                break;
        }
    }

    private void initFragment(int index) {
        // 由于是引用了V4包下的Fragment，所以这里的管理器要用getSupportFragmentManager获取
        FragmentManager fragmentManager = getSupportFragmentManager();
        // 开启事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 隐藏所有Fragment
        hideFragment(transaction);
        switch (index) {
            case 0:
                if (moonshineFragment == null) {
                    moonshineFragment = new MoonshineFragment();
                    transaction.add(R.id.main_frame, moonshineFragment);
                    main_iv_home.setImageResource(R.drawable.tab_home_s);
                    main_tv_home.setTextColor(Color.parseColor("#E63F00"));
                } else {
                    transaction.show(moonshineFragment);
                }
                break;
            case 1:
                if (favorableFragment == null) {
                    favorableFragment = new FavorableFragment();
                    transaction.add(R.id.main_frame, favorableFragment);
                } else {
                    transaction.show(favorableFragment);
                }
                break;
            case 2:
                if (shopcartFragment == null) {
                    shopcartFragment = new ShopcartFragment();
                    transaction.add(R.id.main_frame, shopcartFragment);
                } else {
                    transaction.show(shopcartFragment);
                }
                break;
            case 3:
                if (myFragment == null) {
                    myFragment = new MyFragment();
                    transaction.add(R.id.main_frame, myFragment);
                } else {
                    transaction.show(myFragment);
                }
                break;
        }
        // 提交事务
        transaction.commit();
    }
    //隐藏Fragment
    private void hideFragment(FragmentTransaction transaction) {
        if (moonshineFragment != null) {
            transaction.hide(moonshineFragment);
        }
        if (favorableFragment != null) {
            transaction.hide(favorableFragment);
        }
        if (shopcartFragment != null) {
            transaction.hide(shopcartFragment);
        }
        if (myFragment != null) {
            transaction.hide(myFragment);
        }
    }
    private void restartBotton() {
        main_iv_home.setImageResource(R.drawable.tab_home);
        mian_iv2_home.setImageResource(R.drawable.tab_topic);
        main_iv3_home.setImageResource(R.drawable.main_index_cart_normal);
        mian_iv4_home.setImageResource(R.drawable.main_index_my_normal);
        main_tv_home.setTextColor(Color.BLACK);
        mian_tv2_home.setTextColor(Color.BLACK);
        main_tv3_home.setTextColor(Color.BLACK);
        mian_tv4_home.setTextColor(Color.BLACK);
    }
}
