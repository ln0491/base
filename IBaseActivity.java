package com.ghg.rxjavademo.base;

/**
 * Activity接口
 *
 * Created by 刘楠 on 2016/6/23 0023 9:37.
 */
public interface IBaseActivity {


    /**
     *   绑定视图布局文件
     * @return 布局文件资源id
     */
    public int bindLayout();


    /**
     * 初始化控件
     * （onCreate方法中调用）
     */
    public void initView();

    /**
     * 初始化监听器
     * （onCreate方法中调用）
     */
    public void initListener();

    /**
     * 初始化数据
     * 业务处理操作（onCreate方法中调用）
     */
    public void initData();


    /**
     * 暂停恢复刷新相关操作（onPause方法中调用）
     */
    public void pause();

    /**
     * 暂停恢复刷新相关操作（onResume方法中调用）
     */
    public void resume();

    /**
     * 暂停恢复刷新相关操作（onStop方法中调用）
     */
    public void stop();


    /**
     * 销毁，释放资源等操作在(onDestory方法中谳用)
     */
    public void destory();

}
