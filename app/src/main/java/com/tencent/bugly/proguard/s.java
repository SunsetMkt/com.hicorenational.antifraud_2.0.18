package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.text.TextUtils;
import com.tencent.bugly.beta.download.DownloadTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class s implements com.tencent.bugly.beta.download.b {
    public static s a = new s();

    /* JADX INFO: renamed from: b */
    public ConcurrentHashMap<String, DownloadTask> f6562b = new ConcurrentHashMap<>(3);

    /* JADX INFO: renamed from: c */
    private ScheduledExecutorService f6563c;

    /* JADX INFO: renamed from: com.tencent.bugly.proguard.s$1 */
    /* JADX INFO: compiled from: BUGLY */
    class AnonymousClass1 implements ThreadFactory {
        AnonymousClass1() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("BETA_SDK_DOWNLOAD");
            return thread;
        }
    }

    public s() {
        this.f6563c = null;
        try {
            this.f6563c = Executors.newScheduledThreadPool(3, new ThreadFactory() { // from class: com.tencent.bugly.proguard.s.1
                AnonymousClass1() {
                }

                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable);
                    thread.setName("BETA_SDK_DOWNLOAD");
                    return thread;
                }
            });
            if (this.f6563c.isShutdown()) {
                throw new IllegalArgumentException("ScheduledExecutorService is not available!");
            }
        } catch (Exception e2) {
            an.a(e2);
        }
    }

    @Override // com.tencent.bugly.beta.download.b
    public DownloadTask a(String str, String str2, String str3, String str4) {
        t tVar = null;
        if (TextUtils.isEmpty(str)) {
            an.e("downloadUrl is null!", new Object[0]);
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            an.e("saveDir is null!", new Object[0]);
            return null;
        }
        if (this.f6562b.get(str) != null) {
            return this.f6562b.get(str);
        }
        ContentValues contentValuesA = p.a.a(str);
        if (contentValuesA != null && contentValuesA.get("_dUrl") != null && contentValuesA.getAsString("_sFile") != null && contentValuesA.getAsLong("_sLen") != null && contentValuesA.getAsLong("_tLen") != null && contentValuesA.getAsString("_MD5") != null) {
            tVar = new t((String) contentValuesA.get("_dUrl"), contentValuesA.getAsString("_sFile"), contentValuesA.getAsLong("_sLen").longValue(), contentValuesA.getAsLong("_tLen").longValue(), contentValuesA.getAsString("_MD5"));
            if (contentValuesA.getAsLong("_DLTIME") != null) {
                tVar.f6564k = contentValuesA.getAsLong("_DLTIME").longValue();
            }
        }
        return tVar == null ? new t(str, str2, str3, str4) : tVar;
    }

    public synchronized boolean a(Runnable runnable) {
        if (this.f6563c != null && !this.f6563c.isShutdown()) {
            if (runnable == null) {
                an.d("async task = null", new Object[0]);
                return false;
            }
            an.d("task start %s", runnable.getClass().getName());
            this.f6563c.execute(runnable);
            return true;
        }
        an.d("async handler was closed , should not post task!", new Object[0]);
        return false;
    }
}
