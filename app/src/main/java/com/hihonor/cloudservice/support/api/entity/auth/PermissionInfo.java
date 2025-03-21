package com.hihonor.cloudservice.support.api.entity.auth;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class PermissionInfo implements Parcelable {
    public static final Parcelable.Creator<PermissionInfo> CREATOR = new C2136a();

    /* renamed from: a */
    private String f6391a;

    /* renamed from: b */
    private String f6392b;

    /* renamed from: c */
    private String f6393c;

    /* renamed from: com.hihonor.cloudservice.support.api.entity.auth.PermissionInfo$a */
    class C2136a implements Parcelable.Creator {
        C2136a() {
        }

        @Override // android.os.Parcelable.Creator
        public PermissionInfo createFromParcel(Parcel parcel) {
            return new PermissionInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public PermissionInfo[] newArray(int i2) {
            return new PermissionInfo[i2];
        }
    }

    public PermissionInfo() {
    }

    /* renamed from: a */
    public String m6018a() {
        return this.f6393c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f6391a);
        parcel.writeString(this.f6392b);
        parcel.writeString(this.f6393c);
    }

    public PermissionInfo(Parcel parcel) {
        this.f6391a = parcel.readString();
        this.f6392b = parcel.readString();
        this.f6393c = parcel.readString();
    }

    /* renamed from: a */
    public PermissionInfo m6017a(String str) {
        this.f6393c = str;
        return this;
    }
}
