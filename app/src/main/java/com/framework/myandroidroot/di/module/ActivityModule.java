package com.framework.myandroidroot.di.module;

import android.app.Activity;
import android.content.Context;

import com.framework.myandroidroot.di.scope.ContextLife;
import com.framework.myandroidroot.di.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * @author Leehor
 * 版本：
 * 创建日期：2019/3/18
 * 描述：实例化对象已向外界展示@Provides修饰的方法
 * @Module 其实Module 其实是一个简单工厂模式，Module 里面的方法都是创建相应类实例的方法
 * @Provides 标注该 Module 可以向外界提供的类的实例对象的方法
 */
@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @PerActivity
    @Provides
    @ContextLife("Activity")
    public Context provideActivityContext() {
        return mActivity;
    }

    @Provides
    @PerActivity
    public Activity provideActivity() {
        return mActivity;
    }
}
