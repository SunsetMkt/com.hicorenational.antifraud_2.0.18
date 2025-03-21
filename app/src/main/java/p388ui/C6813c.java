package p388ui;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import p388ui.activity.BaseActivity;
import p388ui.activity.MainActivity;
import util.C7337y1;

/* compiled from: ActivityManager.java */
/* renamed from: ui.c */
/* loaded from: classes2.dex */
public class C6813c implements Application.ActivityLifecycleCallbacks {

    /* renamed from: c */
    private static C6813c f23664c;

    /* renamed from: a */
    private Stack<Activity> f23665a = new Stack<>();

    /* renamed from: b */
    private int f23666b;

    private C6813c() {
    }

    /* renamed from: i */
    public static C6813c m25437i() {
        if (f23664c == null) {
            synchronized (C6813c.class) {
                if (f23664c == null) {
                    f23664c = new C6813c();
                }
            }
        }
        return f23664c;
    }

    /* renamed from: j */
    public static boolean m25438j() {
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) Hicore.getApp().getSystemService("activity")).getRunningTasks(1);
        if (runningTasks != null && runningTasks.size() > 0) {
            if (Hicore.getApp().getPackageName().equals(runningTasks.get(0).topActivity.getClassName())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void m25441a(Activity activity) {
        this.f23665a.add(activity);
    }

    /* renamed from: b */
    public boolean m25445b() {
        return this.f23666b <= 0;
    }

    /* renamed from: c */
    public Activity m25446c() {
        return this.f23665a.lastElement();
    }

    /* renamed from: d */
    public void m25449d(Activity activity) {
        if (activity != null) {
            this.f23665a.remove(activity);
        }
    }

    /* renamed from: e */
    public void m25450e() {
        int size = this.f23665a.size();
        for (int i2 = 0; i2 < size - 1; i2++) {
            if (this.f23665a.get(i2) != null) {
                m25447c(this.f23665a.get(i2));
            }
        }
    }

    /* renamed from: f */
    public void m25451f() {
        int size = this.f23665a.size();
        for (int i2 = 0; i2 < size - 1; i2++) {
            Activity activity = this.f23665a.get(i2);
            if (activity != null && !(activity instanceof MainActivity)) {
                m25447c(this.f23665a.get(i2));
            }
        }
    }

    /* renamed from: g */
    public Stack<Activity> m25452g() {
        return this.f23665a;
    }

    /* renamed from: h */
    public Activity m25453h() {
        return this.f23665a.lastElement();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        m25441a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        m25449d(activity);
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
        this.f23666b++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        this.f23666b--;
        if (!Build.MANUFACTURER.equalsIgnoreCase("xiaomi") || m25438j()) {
            return;
        }
        C7337y1.m26771c(activity, 0);
    }

    /* renamed from: a */
    public void m25440a(int i2) {
        if (this.f23665a.size() > i2) {
            m25444b(this.f23665a.get(i2));
        }
    }

    /* renamed from: b */
    public void m25444b(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        this.f23665a.remove(activity);
        activity.finish();
    }

    /* renamed from: c */
    public void m25447c(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        activity.finish();
    }

    /* renamed from: d */
    public void m25448d() {
        int size = this.f23665a.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f23665a.get(i2) != null) {
                m25447c(this.f23665a.get(i2));
            }
        }
        this.f23665a.clear();
    }

    /* renamed from: a */
    public void m25442a(Class<?> cls) {
        Iterator<Activity> it = this.f23665a.iterator();
        while (it.hasNext()) {
            Activity next = it.next();
            if (next.getClass().equals(cls)) {
                m25444b(next);
                return;
            }
        }
    }

    /* renamed from: b */
    public <T extends BaseActivity> T m25443b(Class<T> cls) {
        Stack<Activity> stack = this.f23665a;
        if (stack == null) {
            return null;
        }
        Iterator<Activity> it = stack.iterator();
        while (it.hasNext()) {
            Activity next = it.next();
            if (next.getClass().equals(cls)) {
                return (T) next;
            }
        }
        return null;
    }

    /* renamed from: a */
    public void m25439a() {
        try {
            this.f23666b = 0;
            m25448d();
            Process.killProcess(Process.myPid());
            System.exit(0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
