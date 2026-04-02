package com.tencent.bugly.beta;

import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.v;
import com.tencent.bugly.proguard.y;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class UpgradeInfo {
    public String apkMd5;
    public String apkUrl;
    public long fileSize;
    public String id;
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

    public UpgradeInfo(y yVar) {
        this.id = "";
        this.title = "";
        this.newFeature = "";
        this.publishTime = 0L;
        this.publishType = 0;
        this.upgradeType = 1;
        this.popTimes = 0;
        this.popInterval = 0L;
        this.versionName = "";
        if (yVar != null) {
            this.id = yVar.f6606m;
            this.title = yVar.a;
            this.newFeature = yVar.f6595b;
            this.publishTime = yVar.f6596c;
            this.publishType = yVar.f6597d;
            this.upgradeType = yVar.f6600g;
            this.popTimes = yVar.f6601h;
            this.popInterval = yVar.f6602i;
            v vVar = yVar.f6598e;
            this.versionCode = vVar.f6574c;
            this.versionName = vVar.f6575d;
            this.apkMd5 = vVar.f6580i;
            u uVar = yVar.f6599f;
            this.apkUrl = uVar.f6568b;
            this.fileSize = uVar.f6570d;
            this.imageUrl = yVar.f6605l.get("IMG_title");
            this.updateType = yVar.p;
        }
    }
}
