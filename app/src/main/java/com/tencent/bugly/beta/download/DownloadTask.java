package com.tencent.bugly.beta.download;

import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public abstract class DownloadTask {
    public static final int COMPLETE = 1;
    public static final int DELETED = 4;
    public static final int DOWNLOADING = 2;
    public static final int FAILED = 5;
    public static final int INIT = 0;
    public static final int PAUSED = 3;
    public static final int TYPE_HOTFIX = 2;
    public static final int TYPE_UPGRADE = 1;
    protected String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected String f6000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected String f6001c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected long f6003e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected long f6004f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected String f6006h;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected List<DownloadListener> f6002d = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected boolean f6005g = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected int f6007i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected int f6008j = 1;

    protected DownloadTask(String str, String str2, String str3, String str4) {
        this.f6006h = "";
        this.a = str;
        this.f6000b = str2;
        this.f6001c = str3;
        this.f6006h = str4;
    }

    public void addListener(DownloadListener downloadListener) {
        if (downloadListener == null || this.f6002d.contains(downloadListener)) {
            return;
        }
        this.f6002d.add(downloadListener);
    }

    public abstract void delete(boolean z);

    public abstract void download();

    public abstract long getCostTime();

    public int getDownloadType() {
        return this.f6008j;
    }

    public String getDownloadUrl() {
        return this.a;
    }

    public String getMD5() {
        return this.f6006h;
    }

    public abstract File getSaveFile();

    public long getSavedLength() {
        return this.f6003e;
    }

    public abstract int getStatus();

    public long getTotalLength() {
        return this.f6004f;
    }

    public boolean isNeededNotify() {
        return this.f6005g;
    }

    public boolean removeListener(DownloadListener downloadListener) {
        return downloadListener != null && this.f6002d.remove(downloadListener);
    }

    public void setDownloadType(int i2) {
        this.f6008j = i2;
    }

    public void setNeededNotify(boolean z) {
        this.f6005g = z;
    }

    public void setSavedLength(long j2) {
        this.f6003e = j2;
    }

    public void setTotalLength(long j2) {
        this.f6004f = j2;
    }

    public abstract void stop();
}
