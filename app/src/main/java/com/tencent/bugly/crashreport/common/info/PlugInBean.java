package com.tencent.bugly.crashreport.common.info;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class PlugInBean implements Parcelable {
    public static final Parcelable.Creator<PlugInBean> CREATOR = new Parcelable.Creator<PlugInBean>() { // from class: com.tencent.bugly.crashreport.common.info.PlugInBean.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlugInBean createFromParcel(Parcel parcel) {
            return new PlugInBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlugInBean[] newArray(int i2) {
            return new PlugInBean[i2];
        }
    };

    /* renamed from: a */
    public final String f10130a;

    /* renamed from: b */
    public final String f10131b;

    /* renamed from: c */
    public final String f10132c;

    public PlugInBean(String str, String str2, String str3) {
        this.f10130a = str;
        this.f10131b = str2;
        this.f10132c = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "plid:" + this.f10130a + " plV:" + this.f10131b + " plUUID:" + this.f10132c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f10130a);
        parcel.writeString(this.f10131b);
        parcel.writeString(this.f10132c);
    }

    public PlugInBean(Parcel parcel) {
        this.f10130a = parcel.readString();
        this.f10131b = parcel.readString();
        this.f10132c = parcel.readString();
    }
}
