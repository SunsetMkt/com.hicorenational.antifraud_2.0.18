package com.hihonor.cloudservice.support.api.entity.auth;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class PermissionInfo implements Parcelable {
    public static final Parcelable.Creator<PermissionInfo> CREATOR = new a();
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f4032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f4033c;

    class a implements Parcelable.Creator {
        a() {
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

    public String a() {
        return this.f4033c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.a);
        parcel.writeString(this.f4032b);
        parcel.writeString(this.f4033c);
    }

    public PermissionInfo(Parcel parcel) {
        this.a = parcel.readString();
        this.f4032b = parcel.readString();
        this.f4033c = parcel.readString();
    }

    public PermissionInfo a(String str) {
        this.f4033c = str;
        return this;
    }
}
