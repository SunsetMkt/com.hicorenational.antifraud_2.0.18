package com.tencent.bugly.beta.global;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.bugly.beta.download.C3075a;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.download.InterfaceC3076b;
import com.tencent.bugly.proguard.C3151an;
import com.tencent.bugly.proguard.C3191p;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.global.f */
/* loaded from: classes2.dex */
public class C3083f {

    /* renamed from: a */
    public static C3083f f9925a = new C3083f();

    /* renamed from: d */
    private List<Runnable> f9928d = new ArrayList();

    /* renamed from: b */
    final Map<String, DownloadTask> f9926b = Collections.synchronizedMap(new HashMap());

    /* renamed from: c */
    Handler f9927c = new Handler(Looper.getMainLooper());

    /* renamed from: a */
    public synchronized void m9343a(Runnable runnable, int i2) {
        if (this.f9926b.size() == 0) {
            runnable.run();
        } else {
            RunnableC3081d runnableC3081d = new RunnableC3081d(6, false, runnable);
            this.f9927c.postDelayed(runnableC3081d, i2);
            m9342a(runnableC3081d);
        }
    }

    /* renamed from: b */
    public void m9344b() {
        synchronized (this) {
            Iterator<Runnable> it = this.f9928d.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
            Iterator<DownloadTask> it2 = this.f9926b.values().iterator();
            while (it2.hasNext()) {
                it2.next().delete(false);
            }
            this.f9928d.clear();
            this.f9926b.clear();
        }
    }

    /* renamed from: a */
    public synchronized void m9342a(Runnable runnable) {
        if (this.f9926b.size() == 0) {
            runnable.run();
        } else {
            this.f9928d.add(runnable);
        }
    }

    /* renamed from: a */
    public void m9341a(InterfaceC3076b interfaceC3076b, Map<String, String> map) {
        DownloadTask downloadTask;
        if (interfaceC3076b == null) {
            return;
        }
        if (map != null && !map.isEmpty()) {
            Iterator<DownloadTask> it = this.f9926b.values().iterator();
            while (it.hasNext()) {
                it.next().delete(true);
            }
            this.f9926b.clear();
            C3075a c3075a = new C3075a(1, this, this.f9926b);
            for (String str : ResBean.f9857b) {
                if (!map.containsKey(str)) {
                    this.f9926b.clear();
                    ResBean.f9856a = new ResBean();
                    C3078a.m9335a("rb.bch", ResBean.f9856a);
                    return;
                }
                String str2 = map.get(str);
                if (str.startsWith("IMG_") && !TextUtils.isEmpty(str2)) {
                    ResBean.f9856a.m9319a(str, "");
                    Iterator<DownloadTask> it2 = this.f9926b.values().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            downloadTask = it2.next();
                            if (downloadTask.getDownloadUrl().equals(str2)) {
                                break;
                            }
                        } else {
                            downloadTask = null;
                            break;
                        }
                    }
                    if (downloadTask == null) {
                        downloadTask = interfaceC3076b.mo9315a(str2, C3082e.f9867G.f9918t.getAbsolutePath(), null, null);
                    }
                    if (downloadTask != null) {
                        downloadTask.addListener(c3075a);
                        downloadTask.setNeededNotify(false);
                        this.f9926b.put(str, downloadTask);
                    }
                } else {
                    ResBean.f9856a.m9319a(str, str2);
                }
            }
            C3078a.m9335a("rb.bch", ResBean.f9856a);
            if (this.f9926b.isEmpty()) {
                return;
            }
            Iterator<DownloadTask> it3 = this.f9926b.values().iterator();
            while (it3.hasNext()) {
                it3.next().download();
            }
            return;
        }
        this.f9926b.clear();
        ResBean.f9856a = new ResBean();
        C3078a.m9335a("rb.bch", ResBean.f9856a);
    }

    /* renamed from: a */
    public void m9340a() {
        ArrayList arrayList = new ArrayList();
        for (String str : ResBean.f9857b) {
            String m9318a = ResBean.f9856a.m9318a(str);
            if (str.startsWith("IMG_") && !TextUtils.isEmpty(m9318a)) {
                arrayList.add(m9318a);
            }
        }
        File[] listFiles = C3082e.f9867G.f9918t.listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            return;
        }
        for (File file : listFiles) {
            Iterator it = arrayList.iterator();
            boolean z = true;
            while (it.hasNext()) {
                if (file.getAbsolutePath().equals((String) it.next())) {
                    z = false;
                }
            }
            if (z) {
                C3191p.f10775a.m10134b(file.getAbsolutePath());
                if (!file.delete()) {
                    C3151an.m9923e("cannot deleteCache file:%s", file.getAbsolutePath());
                }
            }
        }
    }
}
