package com.huawei.hms.core.aidl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class DataBuffer implements Parcelable {
    public static final Parcelable.Creator<DataBuffer> CREATOR = new C2340a();
    public String URI;

    /* renamed from: a */
    private int f7311a;

    /* renamed from: b */
    private Bundle f7312b;
    public Bundle header;

    /* renamed from: com.huawei.hms.core.aidl.DataBuffer$a */
    class C2340a implements Parcelable.Creator<DataBuffer> {
        C2340a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DataBuffer createFromParcel(Parcel parcel) {
            return new DataBuffer(parcel, (C2340a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DataBuffer[] newArray(int i2) {
            return new DataBuffer[i2];
        }
    }

    /* synthetic */ DataBuffer(Parcel parcel, C2340a c2340a) {
        this(parcel);
    }

    /* renamed from: a */
    private static ClassLoader m6762a(Class cls) {
        return cls.getClassLoader();
    }

    public DataBuffer addBody(Bundle bundle) {
        this.f7312b = bundle;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle getBody() {
        return this.f7312b;
    }

    public int getBodySize() {
        return this.f7312b == null ? 0 : 1;
    }

    public int getProtocol() {
        return this.f7311a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        if (parcel == null) {
            return;
        }
        parcel.writeInt(this.f7311a);
        parcel.writeString(this.URI);
        parcel.writeBundle(this.header);
        parcel.writeBundle(this.f7312b);
    }

    private DataBuffer(Parcel parcel) {
        this.header = null;
        this.f7311a = 1;
        this.f7312b = null;
        m6763a(parcel);
    }

    /* renamed from: a */
    private void m6763a(Parcel parcel) {
        this.f7311a = parcel.readInt();
        this.URI = parcel.readString();
        this.header = parcel.readBundle(m6762a(Bundle.class));
        this.f7312b = parcel.readBundle(m6762a(Bundle.class));
    }

    public DataBuffer() {
        this.header = null;
        this.f7311a = 1;
        this.f7312b = null;
    }

    public DataBuffer(String str) {
        this.header = null;
        this.f7311a = 1;
        this.f7312b = null;
        this.URI = str;
    }

    public DataBuffer(String str, int i2) {
        this.header = null;
        this.f7312b = null;
        this.URI = str;
        this.f7311a = i2;
    }
}
