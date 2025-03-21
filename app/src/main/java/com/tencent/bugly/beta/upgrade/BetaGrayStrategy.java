package com.tencent.bugly.beta.upgrade;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.AbstractC3188m;
import com.tencent.bugly.proguard.C3145ah;
import com.tencent.bugly.proguard.C3200y;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class BetaGrayStrategy implements Parcelable, Parcelable.Creator<BetaGrayStrategy> {
    public static final Parcelable.Creator<BetaGrayStrategy> CREATOR = new BetaGrayStrategy();

    /* renamed from: a */
    public C3200y f9988a;

    /* renamed from: b */
    public int f9989b;

    /* renamed from: c */
    public long f9990c;

    /* renamed from: d */
    public boolean f9991d;

    /* renamed from: e */
    public long f9992e;

    public BetaGrayStrategy(Parcel parcel) {
        this.f9989b = 0;
        this.f9990c = -1L;
        this.f9991d = false;
        this.f9992e = -1L;
        this.f9988a = (C3200y) C3145ah.m9853a(parcel.createByteArray(), C3200y.class);
        this.f9989b = parcel.readInt();
        this.f9990c = parcel.readLong();
        this.f9991d = 1 == parcel.readByte();
        this.f9992e = parcel.readLong();
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public BetaGrayStrategy createFromParcel(Parcel parcel) {
        return new BetaGrayStrategy(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByteArray(C3145ah.m9854a((AbstractC3188m) this.f9988a));
        parcel.writeInt(this.f9989b);
        parcel.writeLong(this.f9990c);
        parcel.writeByte(this.f9991d ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f9992e);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public BetaGrayStrategy[] newArray(int i2) {
        return new BetaGrayStrategy[i2];
    }

    public BetaGrayStrategy() {
        this.f9989b = 0;
        this.f9990c = -1L;
        this.f9991d = false;
        this.f9992e = -1L;
    }
}
