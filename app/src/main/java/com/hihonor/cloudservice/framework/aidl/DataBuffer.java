package com.hihonor.cloudservice.framework.aidl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class DataBuffer implements Parcelable {
    public static final Parcelable.Creator<DataBuffer> CREATOR = new C2127a();

    /* renamed from: a */
    public final int f6368a;

    /* renamed from: b */
    public final String f6369b;

    /* renamed from: c */
    public Bundle f6370c;

    /* renamed from: d */
    public Bundle f6371d;

    /* renamed from: com.hihonor.cloudservice.framework.aidl.DataBuffer$a */
    class C2127a implements Parcelable.Creator<DataBuffer> {
        C2127a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataBuffer createFromParcel(Parcel parcel) {
            return new DataBuffer(parcel, (C2127a) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataBuffer[] newArray(int i2) {
            return new DataBuffer[i2];
        }
    }

    /* synthetic */ DataBuffer(Parcel parcel, C2127a c2127a) {
        this(parcel);
    }

    /* renamed from: a */
    public DataBuffer m5977a(Bundle bundle) {
        this.f6371d = bundle;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f6368a);
        parcel.writeString(this.f6369b);
        parcel.writeBundle(this.f6370c);
        parcel.writeBundle(this.f6371d);
    }

    private DataBuffer(Parcel parcel) {
        this.f6370c = null;
        this.f6371d = null;
        this.f6368a = parcel.readInt();
        this.f6369b = parcel.readString();
        this.f6370c = parcel.readBundle(m5976a((Class<?>) Bundle.class));
        this.f6371d = parcel.readBundle(m5976a((Class<?>) Bundle.class));
    }

    /* renamed from: a */
    private static ClassLoader m5976a(Class<?> cls) {
        return cls == null ? ClassLoader.getSystemClassLoader() : cls.getClassLoader();
    }

    public DataBuffer(String str, int i2) {
        this.f6370c = null;
        this.f6371d = null;
        this.f6369b = str;
        this.f6368a = i2;
    }
}
