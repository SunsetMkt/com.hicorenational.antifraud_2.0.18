package com.hihonor.honorid.core.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class ParamInfo implements Parcelable {
    public static final Parcelable.Creator<ParamInfo> CREATOR = new a();
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f4140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f4141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4142d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f4143e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f4144f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f4145g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f4146h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f4147i;

    class a implements Parcelable.Creator<ParamInfo> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParamInfo createFromParcel(Parcel parcel) {
            return new ParamInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParamInfo[] newArray(int i2) {
            return new ParamInfo[i2];
        }
    }

    protected ParamInfo(Parcel parcel) {
        this.a = parcel.readString();
        this.f4140b = parcel.readString();
        this.f4141c = parcel.readString();
        this.f4142d = parcel.readInt();
        this.f4143e = parcel.readString();
        this.f4144f = parcel.readByte() != 0;
        this.f4145g = parcel.readByte() != 0;
        this.f4146h = parcel.readString();
        this.f4147i = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.a);
        parcel.writeString(this.f4140b);
        parcel.writeString(this.f4141c);
        parcel.writeInt(this.f4142d);
        parcel.writeString(this.f4143e);
        parcel.writeByte(this.f4144f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f4145g ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f4146h);
        parcel.writeString(this.f4147i);
    }
}
