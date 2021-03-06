package com.fhx.wateraffairs.base;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;


import com.fhx.wateraffairs.R;
import com.tencent.mmkv.MMKV;
import com.zyao89.view.zloading.ZLoadingDialog;
import com.zyao89.view.zloading.Z_TYPE;

import butterknife.ButterKnife;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;


public abstract class BaseActivity extends SwipeBackActivity {


    private SwipeBackLayout mSwipeBackLayout;
//    public ZLoadingDialog zLoadingDialog;
    public MMKV mmkv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        ButterKnife.bind(this);
        mmkv = MMKV.defaultMMKV();
        mSwipeBackLayout = getSwipeBackLayout();
        // 可以调用该方法，设置是否允许滑动退出
        setSwipeBackEnable(true);
        // 设置滑动方向，可设置EDGE_LEFT, EDGE_RIGHT, EDGE_ALL, EDGE_BOTTOM
        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
        // 滑动退出的效果只能从边界滑动才有效果，如果要扩大touch的范围，可以调用这个方法
        //mSwipeBackLayout.setEdgeSize(200);

        //初始化控件
        initView();
        //设置数据
        initData();
        //监听
        initListen();
    }

    /**
     * dialog相关
     */
//    public void dialog() {
//        zLoadingDialog = new ZLoadingDialog(this);
//        zLoadingDialog.setLoadingBuilder(Z_TYPE.CHART_RECT)
//                .setLoadingColor(Color.parseColor("#eeeeee"))
//                .setHintText("加载中...")
//                .setHintTextSize(14F)
//                .setHintTextColor(Color.parseColor("#eeeeee"))
//                .setDialogBackgroundColor(Color.parseColor("#CC111111"))
//                .setDurationTime(1.3);
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        if (zLoadingDialog != null) {
//            zLoadingDialog.dismiss();
//        }
    }

    /**
     * 设置布局文件id
     */
    protected abstract int initLayout();

    /**
     * 初始化控件
     */
    protected abstract void initView();

    /**
     * 设置数据
     */
    protected abstract void initData();

    /**
     * 设置数据监听
     */
    protected abstract void initListen();


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
    }

    public void ToastShort(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void FinishActivity(){
        finish();
        overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
    }

}
