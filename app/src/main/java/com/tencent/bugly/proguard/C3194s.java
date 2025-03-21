package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.text.TextUtils;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.download.InterfaceC3076b;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.s */
/* loaded from: classes2.dex */
public class C3194s implements InterfaceC3076b {

    /* renamed from: a */
    public static C3194s f10788a = new C3194s();

    /* renamed from: b */
    public ConcurrentHashMap<String, DownloadTask> f10789b = new ConcurrentHashMap<>(3);

    /* renamed from: c */
    private ScheduledExecutorService f10790c;

    public C3194s() {
        this.f10790c = null;
        try {
            this.f10790c = Executors.newScheduledThreadPool(3, new ThreadFactory() { // from class: com.tencent.bugly.proguard.s.1
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable);
                    thread.setName("BETA_SDK_DOWNLOAD");
                    return thread;
                }
            });
            if (this.f10790c.isShutdown()) {
                throw new IllegalArgumentException("ScheduledExecutorService is not available!");
            }
        } catch (Exception e2) {
            C3151an.m9916a(e2);
        }
    }

    @Override // com.tencent.bugly.beta.download.InterfaceC3076b
    /* renamed from: a */
    public DownloadTask mo9315a(String str, String str2, String str3, String str4) {
        RunnableC3195t runnableC3195t = null;
        if (TextUtils.isEmpty(str)) {
            C3151an.m9923e("downloadUrl is null!", new Object[0]);
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            C3151an.m9923e("saveDir is null!", new Object[0]);
            return null;
        }
        if (this.f10789b.get(str) != null) {
            return this.f10789b.get(str);
        }
        ContentValues m10127a = C3191p.f10775a.m10127a(str);
        if (m10127a != null && m10127a.get("_dUrl") != null && m10127a.getAsString("_sFile") != null && m10127a.getAsLong("_sLen") != null && m10127a.getAsLong("_tLen") != null && m10127a.getAsString("_MD5") != null) {
            runnableC3195t = new RunnableC3195t((String) m10127a.get("_dUrl"), m10127a.getAsString("_sFile"), m10127a.getAsLong("_sLen").longValue(), m10127a.getAsLong("_tLen").longValue(), m10127a.getAsString("_MD5"));
            if (m10127a.getAsLong("_DLTIME") != null) {
                runnableC3195t.f10792k = m10127a.getAsLong("_DLTIME").longValue();
            }
        }
        return runnableC3195t == null ? new RunnableC3195t(str, str2, str3, str4) : runnableC3195t;
    }

    /* renamed from: a */
    public synchronized boolean m10143a(Runnable runnable) {
        if (this.f10790c != null && !this.f10790c.isShutdown()) {
            if (runnable == null) {
                C3151an.m9922d("async task = null", new Object[0]);
                return false;
            }
            C3151an.m9922d("task start %s", runnable.getClass().getName());
            this.f10790c.execute(runnable);
            return true;
        }
        C3151an.m9922d("async handler was closed , should not post task!", new Object[0]);
        return false;
    }
}
