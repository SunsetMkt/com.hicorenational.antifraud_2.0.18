package com.tencent.bugly.beta.upgrade;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.beta.global.e;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.ah;
import com.tencent.bugly.proguard.bk;
import com.tencent.bugly.proguard.m;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class BetaUploadStrategy implements Parcelable, Parcelable.Creator<BetaUploadStrategy> {
    public static final Parcelable.Creator<BetaUploadStrategy> CREATOR = new BetaUploadStrategy();
    public bk a;

    /* JADX INFO: renamed from: b */
    public long f6074b;

    public BetaUploadStrategy() {
        this.a = new bk();
        bk bkVar = this.a;
        bkVar.f6490b = true;
        bkVar.f6491c = true;
        if (e.G.S) {
            String str = StrategyBean.f6190b;
            bkVar.f6492d = str;
            bkVar.f6493e = str;
        } else {
            bkVar.f6492d = "http://android.bugly.qq.com/rqd/async";
            bkVar.f6493e = "http://android.bugly.qq.com/rqd/async";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.a.f6496h = jCurrentTimeMillis;
        this.f6074b = jCurrentTimeMillis;
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a */
    public BetaUploadStrategy createFromParcel(Parcel parcel) {
        return new BetaUploadStrategy(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByteArray(ah.a((m) this.a));
        parcel.writeLong(this.f6074b);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a */
    public BetaUploadStrategy[] newArray(int i2) {
        return new BetaUploadStrategy[i2];
    }

    public BetaUploadStrategy(Parcel parcel) {
        this.a = (bk) ah.a(parcel.createByteArray(), bk.class);
        this.f6074b = parcel.readLong();
    }
}
