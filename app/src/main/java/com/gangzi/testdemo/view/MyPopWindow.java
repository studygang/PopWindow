package com.gangzi.testdemo.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.gangzi.testdemo.R;

/**
 * Created by Administrator on 2017/5/8.
 */

public class MyPopWindow extends PopupWindow {

    private View popView;
    private ImageView test1,test2,test3;
    private ImageView iv_cancel;

    public MyPopWindow(Context context, View.OnClickListener itemsOnClick) {
        super(context);
        initView(context,itemsOnClick);
    }

    private void initView(Context context, View.OnClickListener itemsOnClick) {
        popView= LayoutInflater.from(context).inflate(R.layout.pop_window_item,null);
        test1= (ImageView) popView.findViewById(R.id.test1);
        test2= (ImageView) popView.findViewById(R.id.test2);
        test3= (ImageView) popView.findViewById(R.id.test3);
        iv_cancel= (ImageView) popView.findViewById(R.id.iv_cancels);
        iv_cancel.setOnClickListener(itemsOnClick);
        test1.setOnClickListener(itemsOnClick);
        test2.setOnClickListener(itemsOnClick);
        test3.setOnClickListener(itemsOnClick);
        setContentView(popView);
        //设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        //设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(400);
       /* ColorDrawable dw = new ColorDrawable(0xb0000000);
        //设置SelectPicPopupWindow弹出窗体的背景
        setBackgroundDrawable(dw);*/
        WindowManager.LayoutParams lp = ((Activity)context).getWindow().getAttributes();
        lp.alpha = 0.5f;
        ((Activity)context).getWindow().setAttributes(lp);
    }
    /**
     * 设置添加屏幕的背景透明度
     *
     * @param bgAlpha
     */
    public void backgroundAlpha(Activity context, float bgAlpha) {
        WindowManager.LayoutParams lp = context.getWindow().getAttributes();
        lp.alpha = bgAlpha;
        context.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        context.getWindow().setAttributes(lp);
    }
}
