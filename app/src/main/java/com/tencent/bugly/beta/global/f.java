package com.tencent.bugly.beta.global;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.p;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class f {
    public static f a = new f();

    /* JADX INFO: renamed from: d */
    private List<Runnable> f6033d = new ArrayList();

    /* JADX INFO: renamed from: b */
    final Map<String, DownloadTask> f6031b = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: c */
    Handler f6032c = new Handler(Looper.getMainLooper());

    public synchronized void a(Runnable runnable, int i2) {
        if (this.f6031b.size() == 0) {
            runnable.run();
        } else {
            d dVar = new d(6, false, runnable);
            this.f6032c.postDelayed(dVar, i2);
            a(dVar);
        }
    }

    public void b() {
        synchronized (this) {
            Iterator<Runnable> it = this.f6033d.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
            Iterator<DownloadTask> it2 = this.f6031b.values().iterator();
            while (it2.hasNext()) {
                it2.next().delete(false);
            }
            this.f6033d.clear();
            this.f6031b.clear();
        }
    }

    public synchronized void a(Runnable runnable) {
        if (this.f6031b.size() == 0) {
            runnable.run();
        } else {
            this.f6033d.add(runnable);
        }
    }

    public void a(com.tencent.bugly.beta.download.b bVar, Map<String, String> map) {
        DownloadTask downloadTaskA;
        if (bVar == null) {
            return;
        }
        if (map != null && !map.isEmpty()) {
            Iterator<DownloadTask> it = this.f6031b.values().iterator();
            while (it.hasNext()) {
                it.next().delete(true);
            }
            this.f6031b.clear();
            com.tencent.bugly.beta.download.a aVar = new com.tencent.bugly.beta.download.a(1, this, this.f6031b);
            for (String str : ResBean.f6011b) {
                if (!map.containsKey(str)) {
                    this.f6031b.clear();
                    ResBean.a = new ResBean();
                    a.a("rb.bch", ResBean.a);
                    return;
                }
                String str2 = map.get(str);
                if (str.startsWith("IMG_") && !TextUtils.isEmpty(str2)) {
                    ResBean.a.a(str, "");
                    Iterator<DownloadTask> it2 = this.f6031b.values().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            downloadTaskA = it2.next();
                            if (downloadTaskA.getDownloadUrl().equals(str2)) {
                                break;
                            }
                        } else {
                            downloadTaskA = null;
                            break;
                        }
                    }
                    if (downloadTaskA == null) {
                        downloadTaskA = bVar.a(str2, e.G.t.getAbsolutePath(), null, null);
                    }
                    if (downloadTaskA != null) {
                        downloadTaskA.addListener(aVar);
                        downloadTaskA.setNeededNotify(false);
                        this.f6031b.put(str, downloadTaskA);
                    }
                } else {
                    ResBean.a.a(str, str2);
                }
            }
            a.a("rb.bch", ResBean.a);
            if (this.f6031b.isEmpty()) {
                return;
            }
            Iterator<DownloadTask> it3 = this.f6031b.values().iterator();
            while (it3.hasNext()) {
                it3.next().download();
            }
            return;
        }
        this.f6031b.clear();
        ResBean.a = new ResBean();
        a.a("rb.bch", ResBean.a);
    }

    public void a() {
        ArrayList arrayList = new ArrayList();
        for (String str : ResBean.f6011b) {
            String strA = ResBean.a.a(str);
            if (str.startsWith("IMG_") && !TextUtils.isEmpty(strA)) {
                arrayList.add(strA);
            }
        }
        File[] fileArrListFiles = e.G.t.listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
            return;
        }
        for (File file : fileArrListFiles) {
            Iterator it = arrayList.iterator();
            boolean z = true;
            while (it.hasNext()) {
                if (file.getAbsolutePath().equals((String) it.next())) {
                    z = false;
                }
            }
            if (z) {
                p.a.b(file.getAbsolutePath());
                if (!file.delete()) {
                    an.e("cannot deleteCache file:%s", file.getAbsolutePath());
                }
            }
        }
    }
}
