package com.hihonor.honorid.core.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class TmemberRight implements Parcelable {
    public static final Parcelable.Creator<TmemberRight> CREATOR = new a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f4148i = "userId";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f4149j = "deviceType";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f4150k = "deviceId";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f4151l = "deviceID2";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f4152m = "terminalType";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f4153n = "rightsId";
    public static final String o = "memberBindTime";
    public static final String p = "expiredDate";
    private long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f4155c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f4156d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f4157e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f4158f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f4159g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f4160h;

    class a implements Parcelable.Creator<TmemberRight> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TmemberRight createFromParcel(Parcel parcel) {
            TmemberRight tmemberRight = new TmemberRight();
            tmemberRight.a = parcel.readLong();
            tmemberRight.f4154b = parcel.readInt();
            tmemberRight.f4155c = parcel.readString();
            tmemberRight.f4156d = parcel.readString();
            tmemberRight.f4157e = parcel.readString();
            tmemberRight.f4158f = parcel.readInt();
            tmemberRight.f4159g = parcel.readString();
            tmemberRight.f4160h = parcel.readString();
            return tmemberRight;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TmemberRight[] newArray(int i2) {
            return new TmemberRight[i2];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.a);
        parcel.writeInt(this.f4154b);
        parcel.writeString(this.f4155c);
        parcel.writeString(this.f4156d);
        parcel.writeString(this.f4157e);
        parcel.writeInt(this.f4158f);
        parcel.writeString(this.f4159g);
        parcel.writeString(this.f4160h);
    }
}
