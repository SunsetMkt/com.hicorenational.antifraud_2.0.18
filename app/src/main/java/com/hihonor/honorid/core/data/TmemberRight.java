package com.hihonor.honorid.core.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class TmemberRight implements Parcelable {
    public static final Parcelable.Creator<TmemberRight> CREATOR = new C2159a();

    /* renamed from: i */
    public static final String f6562i = "userId";

    /* renamed from: j */
    public static final String f6563j = "deviceType";

    /* renamed from: k */
    public static final String f6564k = "deviceId";

    /* renamed from: l */
    public static final String f6565l = "deviceID2";

    /* renamed from: m */
    public static final String f6566m = "terminalType";

    /* renamed from: n */
    public static final String f6567n = "rightsId";

    /* renamed from: o */
    public static final String f6568o = "memberBindTime";

    /* renamed from: p */
    public static final String f6569p = "expiredDate";

    /* renamed from: a */
    private long f6570a;

    /* renamed from: b */
    private int f6571b;

    /* renamed from: c */
    private String f6572c;

    /* renamed from: d */
    private String f6573d;

    /* renamed from: e */
    private String f6574e;

    /* renamed from: f */
    private int f6575f;

    /* renamed from: g */
    private String f6576g;

    /* renamed from: h */
    private String f6577h;

    /* renamed from: com.hihonor.honorid.core.data.TmemberRight$a */
    class C2159a implements Parcelable.Creator<TmemberRight> {
        C2159a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TmemberRight createFromParcel(Parcel parcel) {
            TmemberRight tmemberRight = new TmemberRight();
            tmemberRight.f6570a = parcel.readLong();
            tmemberRight.f6571b = parcel.readInt();
            tmemberRight.f6572c = parcel.readString();
            tmemberRight.f6573d = parcel.readString();
            tmemberRight.f6574e = parcel.readString();
            tmemberRight.f6575f = parcel.readInt();
            tmemberRight.f6576g = parcel.readString();
            tmemberRight.f6577h = parcel.readString();
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
        parcel.writeLong(this.f6570a);
        parcel.writeInt(this.f6571b);
        parcel.writeString(this.f6572c);
        parcel.writeString(this.f6573d);
        parcel.writeString(this.f6574e);
        parcel.writeInt(this.f6575f);
        parcel.writeString(this.f6576g);
        parcel.writeString(this.f6577h);
    }
}
