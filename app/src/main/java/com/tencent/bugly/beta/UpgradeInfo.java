package com.tencent.bugly.beta;

import com.tencent.bugly.proguard.C3196u;
import com.tencent.bugly.proguard.C3197v;
import com.tencent.bugly.proguard.C3200y;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class UpgradeInfo {
    public String apkMd5;
    public String apkUrl;
    public long fileSize;

    /* renamed from: id */
    public String f9838id;
    public String imageUrl;
    public String newFeature;
    public long popInterval;
    public int popTimes;
    public long publishTime;
    public int publishType;
    public String title;
    public int updateType;
    public int upgradeType;
    public int versionCode;
    public String versionName;

    public UpgradeInfo(C3200y c3200y) {
        this.f9838id = "";
        this.title = "";
        this.newFeature = "";
        this.publishTime = 0L;
        this.publishType = 0;
        this.upgradeType = 1;
        this.popTimes = 0;
        this.popInterval = 0L;
        this.versionName = "";
        if (c3200y != null) {
            this.f9838id = c3200y.f10844m;
            this.title = c3200y.f10832a;
            this.newFeature = c3200y.f10833b;
            this.publishTime = c3200y.f10834c;
            this.publishType = c3200y.f10835d;
            this.upgradeType = c3200y.f10838g;
            this.popTimes = c3200y.f10839h;
            this.popInterval = c3200y.f10840i;
            C3197v c3197v = c3200y.f10836e;
            this.versionCode = c3197v.f10804c;
            this.versionName = c3197v.f10805d;
            this.apkMd5 = c3197v.f10810i;
            C3196u c3196u = c3200y.f10837f;
            this.apkUrl = c3196u.f10797b;
            this.fileSize = c3196u.f10799d;
            this.imageUrl = c3200y.f10843l.get("IMG_title");
            this.updateType = c3200y.f10847p;
        }
    }
}
