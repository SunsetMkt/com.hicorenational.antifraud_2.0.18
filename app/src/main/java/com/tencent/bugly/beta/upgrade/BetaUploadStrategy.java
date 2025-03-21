package com.tencent.bugly.beta.upgrade;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.beta.global.C3082e;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.AbstractC3188m;
import com.tencent.bugly.proguard.C3145ah;
import com.tencent.bugly.proguard.C3175bk;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class BetaUploadStrategy implements Parcelable, Parcelable.Creator<BetaUploadStrategy> {
    public static final Parcelable.Creator<BetaUploadStrategy> CREATOR = new BetaUploadStrategy();

    /* renamed from: a */
    public C3175bk f9993a;

    /* renamed from: b */
    public long f9994b;

    public BetaUploadStrategy() {
        this.f9993a = new C3175bk();
        C3175bk c3175bk = this.f9993a;
        c3175bk.f10701b = true;
        c3175bk.f10702c = true;
        if (C3082e.f9867G.f9886S) {
            String str = StrategyBean.f10225b;
            c3175bk.f10703d = str;
            c3175bk.f10704e = str;
        } else {
            c3175bk.f10703d = "http://android.bugly.qq.com/rqd/async";
            c3175bk.f10704e = "http://android.bugly.qq.com/rqd/async";
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.f9993a.f10707h = currentTimeMillis;
        this.f9994b = currentTimeMillis;
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public BetaUploadStrategy createFromParcel(Parcel parcel) {
        return new BetaUploadStrategy(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByteArray(C3145ah.m9854a((AbstractC3188m) this.f9993a));
        parcel.writeLong(this.f9994b);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public BetaUploadStrategy[] newArray(int i2) {
        return new BetaUploadStrategy[i2];
    }

    public BetaUploadStrategy(Parcel parcel) {
        this.f9993a = (C3175bk) C3145ah.m9853a(parcel.createByteArray(), C3175bk.class);
        this.f9994b = parcel.readLong();
    }
}
