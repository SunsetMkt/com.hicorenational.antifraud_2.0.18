package com.tencent.bugly.beta.download;

import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public abstract class DownloadTask {
    public static final int COMPLETE = 1;
    public static final int DELETED = 4;
    public static final int DOWNLOADING = 2;
    public static final int FAILED = 5;
    public static final int INIT = 0;
    public static final int PAUSED = 3;
    public static final int TYPE_HOTFIX = 2;
    public static final int TYPE_UPGRADE = 1;

    /* renamed from: a */
    protected String f9842a;

    /* renamed from: b */
    protected String f9843b;

    /* renamed from: c */
    protected String f9844c;

    /* renamed from: e */
    protected long f9846e;

    /* renamed from: f */
    protected long f9847f;

    /* renamed from: h */
    protected String f9849h;

    /* renamed from: d */
    protected List<DownloadListener> f9845d = new CopyOnWriteArrayList();

    /* renamed from: g */
    protected boolean f9848g = true;

    /* renamed from: i */
    protected int f9850i = 0;

    /* renamed from: j */
    protected int f9851j = 1;

    protected DownloadTask(String str, String str2, String str3, String str4) {
        this.f9849h = "";
        this.f9842a = str;
        this.f9843b = str2;
        this.f9844c = str3;
        this.f9849h = str4;
    }

    public void addListener(DownloadListener downloadListener) {
        if (downloadListener == null || this.f9845d.contains(downloadListener)) {
            return;
        }
        this.f9845d.add(downloadListener);
    }

    public abstract void delete(boolean z);

    public abstract void download();

    public abstract long getCostTime();

    public int getDownloadType() {
        return this.f9851j;
    }

    public String getDownloadUrl() {
        return this.f9842a;
    }

    public String getMD5() {
        return this.f9849h;
    }

    public abstract File getSaveFile();

    public long getSavedLength() {
        return this.f9846e;
    }

    public abstract int getStatus();

    public long getTotalLength() {
        return this.f9847f;
    }

    public boolean isNeededNotify() {
        return this.f9848g;
    }

    public boolean removeListener(DownloadListener downloadListener) {
        return downloadListener != null && this.f9845d.remove(downloadListener);
    }

    public void setDownloadType(int i2) {
        this.f9851j = i2;
    }

    public void setNeededNotify(boolean z) {
        this.f9848g = z;
    }

    public void setSavedLength(long j2) {
        this.f9846e = j2;
    }

    public void setTotalLength(long j2) {
        this.f9847f = j2;
    }

    public abstract void stop();
}
