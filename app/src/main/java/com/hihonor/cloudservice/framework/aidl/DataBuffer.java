package com.hihonor.cloudservice.framework.aidl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class DataBuffer implements Parcelable {
    public static final Parcelable.Creator<DataBuffer> CREATOR = new a();
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f4014c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Bundle f4015d;

    class a implements Parcelable.Creator<DataBuffer> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataBuffer createFromParcel(Parcel parcel) {
            return new DataBuffer(parcel, (a) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataBuffer[] newArray(int i2) {
            return new DataBuffer[i2];
        }
    }

    /* synthetic */ DataBuffer(Parcel parcel, a aVar) {
        this(parcel);
    }

    public DataBuffer a(Bundle bundle) {
        this.f4015d = bundle;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.a);
        parcel.writeString(this.f4013b);
        parcel.writeBundle(this.f4014c);
        parcel.writeBundle(this.f4015d);
    }

    private DataBuffer(Parcel parcel) {
        this.f4014c = null;
        this.f4015d = null;
        this.a = parcel.readInt();
        this.f4013b = parcel.readString();
        this.f4014c = parcel.readBundle(a((Class<?>) Bundle.class));
        this.f4015d = parcel.readBundle(a((Class<?>) Bundle.class));
    }

    private static ClassLoader a(Class<?> cls) {
        return cls == null ? ClassLoader.getSystemClassLoader() : cls.getClassLoader();
    }

    public DataBuffer(String str, int i2) {
        this.f4014c = null;
        this.f4015d = null;
        this.f4013b = str;
        this.a = i2;
    }
}
