package ui;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import java.util.List;
import java.util.Stack;
import ui.activity.BaseActivity;
import ui.activity.MainActivity;
import util.g2;

/* JADX INFO: compiled from: ActivityManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static c f14078c;
    private Stack<Activity> a = new Stack<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f14079b;

    private c() {
    }

    public static c i() {
        if (f14078c == null) {
            synchronized (c.class) {
                if (f14078c == null) {
                    f14078c = new c();
                }
            }
        }
        return f14078c;
    }

    public static boolean j() {
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) Hicore.getApp().getSystemService("activity")).getRunningTasks(1);
        if (runningTasks != null && runningTasks.size() > 0) {
            if (Hicore.getApp().getPackageName().equals(runningTasks.get(0).topActivity.getClassName())) {
                return true;
            }
        }
        return false;
    }

    public void a(Activity activity) {
        this.a.add(activity);
    }

    public boolean b() {
        return this.f14079b <= 0;
    }

    public Activity c() {
        return this.a.lastElement();
    }

    public void d(Activity activity) {
        if (activity != null) {
            this.a.remove(activity);
        }
    }

    public void e() {
        int size = this.a.size();
        for (int i2 = 0; i2 < size - 1; i2++) {
            if (this.a.get(i2) != null) {
                c(this.a.get(i2));
            }
        }
    }

    public void f() {
        int size = this.a.size();
        for (int i2 = 0; i2 < size - 1; i2++) {
            Activity activity = this.a.get(i2);
            if (activity != null && !(activity instanceof MainActivity)) {
                c(this.a.get(i2));
            }
        }
    }

    public Stack<Activity> g() {
        return this.a;
    }

    public Activity h() {
        return this.a.lastElement();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        d(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.f14079b++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        this.f14079b--;
        if (!Build.MANUFACTURER.equalsIgnoreCase("xiaomi") || j()) {
            return;
        }
        g2.c(activity, 0);
    }

    public void a(int i2) {
        if (this.a.size() > i2) {
            b(this.a.get(i2));
        }
    }

    public void b(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        this.a.remove(activity);
        activity.finish();
    }

    public void c(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        activity.finish();
    }

    public void d() {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.a.get(i2) != null) {
                c(this.a.get(i2));
            }
        }
        this.a.clear();
    }

    public void a(Class<?> cls) {
        for (Activity activity : this.a) {
            if (activity.getClass().equals(cls)) {
                b(activity);
                return;
            }
        }
    }

    public <T extends BaseActivity> T b(Class<T> cls) {
        Stack<Activity> stack = this.a;
        if (stack == null) {
            return null;
        }
        for (Activity activity : stack) {
            if (activity.getClass().equals(cls)) {
                return (T) activity;
            }
        }
        return null;
    }

    public void a() {
        try {
            this.f14079b = 0;
            d();
            Process.killProcess(Process.myPid());
            System.exit(0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
