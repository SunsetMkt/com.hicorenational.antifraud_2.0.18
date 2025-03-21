package com.hihonor.honorid.core.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class ParamInfo implements Parcelable {
    public static final Parcelable.Creator<ParamInfo> CREATOR = new C2157a();

    /* renamed from: a */
    private String f6553a;

    /* renamed from: b */
    private String f6554b;

    /* renamed from: c */
    private String f6555c;

    /* renamed from: d */
    private int f6556d;

    /* renamed from: e */
    private String f6557e;

    /* renamed from: f */
    private boolean f6558f;

    /* renamed from: g */
    private boolean f6559g;

    /* renamed from: h */
    private String f6560h;

    /* renamed from: i */
    private String f6561i;

    /* renamed from: com.hihonor.honorid.core.data.ParamInfo$a */
    class C2157a implements Parcelable.Creator<ParamInfo> {
        C2157a() {
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
        this.f6553a = parcel.readString();
        this.f6554b = parcel.readString();
        this.f6555c = parcel.readString();
        this.f6556d = parcel.readInt();
        this.f6557e = parcel.readString();
        this.f6558f = parcel.readByte() != 0;
        this.f6559g = parcel.readByte() != 0;
        this.f6560h = parcel.readString();
        this.f6561i = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f6553a);
        parcel.writeString(this.f6554b);
        parcel.writeString(this.f6555c);
        parcel.writeInt(this.f6556d);
        parcel.writeString(this.f6557e);
        parcel.writeByte(this.f6558f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6559g ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f6560h);
        parcel.writeString(this.f6561i);
    }
}
