package com.gangzi.testdemo;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.IdRes;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.gangzi.testdemo.view.MyPopWindow;

public class MainActivity extends Activity implements View.OnClickListener{

    private RadioGroup rg_main;
    private ImageView iv_show;
    private MyPopWindow mPopWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initView() {
        rg_main= (RadioGroup) findViewById(R.id.rg_main);
        iv_show= (ImageView) findViewById(R.id.iv_home_bg);
        iv_show.setOnClickListener(this);
    }

    private void initListener() {
        rg_main.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int i) {
                switch (i){
                    case R.id.rb_community:

                        break;
                }
            }
        });
    }

    //为弹出窗口实现监听类
    private View.OnClickListener itemsOnClick = new View.OnClickListener(){

        public void onClick(View v) {
            mPopWindow.dismiss();
            switch (v.getId()) {
                case R.id.test1:
                    break;
                case R.id.test2:
                    break;
                case R.id.iv_cancels:
                    mPopWindow.dismiss();
                    WindowManager.LayoutParams lp=getWindow().getAttributes();
                    lp.alpha=1f;
                    getWindow().setAttributes(lp);
                    break;
                default:
                    break;
            }


        }

    };

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_home_bg:
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 0.4f;
                getWindow().setAttributes(lp);
                mPopWindow=new MyPopWindow(this,itemsOnClick);
                Toast.makeText(this,"我点了！",Toast.LENGTH_SHORT).show();
                mPopWindow.showAtLocation(MainActivity.this.findViewById(R.id.main), Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL,0,0);
                break;
        }
    }
}
