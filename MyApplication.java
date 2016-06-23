package com.ghg.rxjavademo.application;

import android.app.Activity;
import android.app.Application;

import java.lang.ref.WeakReference;
import java.util.Stack;

/**
 * 单例
 * Created by 刘楠 on 2016/6/23 0023 9:49.
 */
public class MyApplication extends Application {

    private static final Stack<WeakReference<Activity>> ACTIVITYS = new Stack<WeakReference<Activity>>();


    private static MyApplication instance=null;

    @Override
    public void onCreate() {
        super.onCreate();

        instance=this;

    }


    public static MyApplication getInstance(){
        return instance;
    }


    /**
     * 添加一个Activity
     * @param task
     */
    public void pushTask(WeakReference<Activity> task) {
        ACTIVITYS.push(task);
    }

    /**
     * 移除指定的Activity
     * @param task
     */
    public void removeTask(WeakReference<Activity> task){

        ACTIVITYS.remove(task);
    }

    /**
     * 移除指定位置的Activity
     * @param taskIndex
     */
    public void removeTask(int taskIndex){
        if(ACTIVITYS.size()>taskIndex){

            ACTIVITYS.remove(taskIndex);
        }
    }

    /**
     * 移除所有
     */
    public void removeAllTask(){

        for(WeakReference<Activity> task:ACTIVITYS){

           if(!task.get().isFinishing()){

               task.get().finish();
           }
        }

    }

    /**
     * 从顶部开始移除
     */
    public void removeTop(){


        int end = ACTIVITYS.size();

        int start =1;

        for(int i= end-1; i>=start;i--){

            if(!ACTIVITYS.get(i).get().isFinishing()){

                ACTIVITYS.get(i).get().finish();
            }
        }


    }

}
