package com.ghg.rxjavademo.base;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;

import com.ghg.rxjavademo.R;
import com.ghg.rxjavademo.application.MyApplication;

import java.lang.ref.WeakReference;

public  abstract class BaseActivity extends AppCompatActivity implements IBaseActivity, View.OnClickListener{


    private static final String TAG = "BaseActivity";
    private WeakReference<Activity> mTask;

    private MyApplication mMyApplication;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(bindLayout());

        initView();

        initListener();
        initData();

        mMyApplication = MyApplication.getInstance();

        Log.d(TAG, "onCreate: "+mMyApplication.hashCode());
        mTask = new WeakReference<Activity>(this);


       Log.d(TAG, "onCreate: "+mTask.hashCode());


        mMyApplication.pushTask(mTask);

    }





    @Override
    public void pause() {
        super.onPause();

        pause();

    }

    @Override
    public void resume() {

        super.onResume();
        resume();

    }

    @Override
    public void stop() {

        super.onStop();
        stop();

    }

    @Override
    public void destory() {

        super.onDestroy();

        //mMyApplication.removeTask(mTask);
        destory();
    }


    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);

        overridePendingTransition(R.anim.push_right_in,R.anim.push_left_out);
    }


    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        overridePendingTransition(R.anim.push_right_in,R.anim.push_left_out);


    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.push_left_in,R.anim.push_right_out);
    }
}
