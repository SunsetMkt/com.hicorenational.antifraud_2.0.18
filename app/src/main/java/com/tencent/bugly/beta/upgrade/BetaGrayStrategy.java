package com.tencent.bugly.beta.upgrade;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.ah;
import com.tencent.bugly.proguard.m;
import com.tencent.bugly.proguard.y;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class BetaGrayStrategy implements Parcelable, Parcelable.Creator<BetaGrayStrategy> {
    public static final Parcelable.Creator<BetaGrayStrategy> CREATOR = new BetaGrayStrategy();
    public y a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f6071c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f6072d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f6073e;

    public BetaGrayStrategy(Parcel parcel) {
        this.f6070b = 0;
        this.f6071c = -1L;
        this.f6072d = false;
        this.f6073e = -1L;
        this.a = (y) ah.a(parcel.createByteArray(), y.class);
        this.f6070b = parcel.readInt();
        this.f6071c = parcel.readLong();
        this.f6072d = 1 == parcel.readByte();
        this.f6073e = parcel.readLong();
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public BetaGrayStrategy createFromParcel(Parcel parcel) {
        return new BetaGrayStrategy(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByteArray(ah.a((m) this.a));
        parcel.writeInt(this.f6070b);
        parcel.writeLong(this.f6071c);
        parcel.writeByte(this.f6072d ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f6073e);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public BetaGrayStrategy[] newArray(int i2) {
        return new BetaGrayStrategy[i2];
    }

    public BetaGrayStrategy() {
        this.f6070b = 0;
        this.f6071c = -1L;
        this.f6072d = false;
        this.f6073e = -1L;
    }
}
