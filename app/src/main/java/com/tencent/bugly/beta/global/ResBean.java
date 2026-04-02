package com.tencent.bugly.beta.global;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class ResBean implements Parcelable, Parcelable.Creator<ResBean> {
    public static ResBean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f6011b = {"IMG_title", "VAL_style"};
    public static final Parcelable.Creator<ResBean> CREATOR = new ResBean();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, String> f6014e = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6012c = "#273238";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f6013d = "#757575";

    public ResBean() {
    }

    public String a(String str) {
        return this.f6014e.get(str);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResBean[] newArray(int i2) {
        return new ResBean[0];
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        for (String str : f6011b) {
            parcel.writeString(this.f6014e.get(str));
        }
    }

    public void a(String str, Object obj) {
        if (obj instanceof String) {
            this.f6014e.put(str, (String) obj);
        }
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResBean createFromParcel(Parcel parcel) {
        return new ResBean(parcel);
    }

    public ResBean(Parcel parcel) {
        try {
            for (String str : f6011b) {
                this.f6014e.put(str, parcel.readString());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
