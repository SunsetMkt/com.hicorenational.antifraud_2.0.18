package com.tencent.bugly.crashreport.common.info;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class PlugInBean implements Parcelable {
    public static final Parcelable.Creator<PlugInBean> CREATOR = new Parcelable.Creator<PlugInBean>() { // from class: com.tencent.bugly.crashreport.common.info.PlugInBean.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlugInBean createFromParcel(Parcel parcel) {
            return new PlugInBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlugInBean[] newArray(int i2) {
            return new PlugInBean[i2];
        }
    };
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6172c;

    public PlugInBean(String str, String str2, String str3) {
        this.a = str;
        this.f6171b = str2;
        this.f6172c = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "plid:" + this.a + " plV:" + this.f6171b + " plUUID:" + this.f6172c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.a);
        parcel.writeString(this.f6171b);
        parcel.writeString(this.f6172c);
    }

    public PlugInBean(Parcel parcel) {
        this.a = parcel.readString();
        this.f6171b = parcel.readString();
        this.f6172c = parcel.readString();
    }
}
