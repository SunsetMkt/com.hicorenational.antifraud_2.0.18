package com.tencent.bugly.beta.global;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class ResBean implements Parcelable, Parcelable.Creator<ResBean> {

    /* renamed from: a */
    public static ResBean f9856a;

    /* renamed from: b */
    public static final String[] f9857b = {"IMG_title", "VAL_style"};
    public static final Parcelable.Creator<ResBean> CREATOR = new ResBean();

    /* renamed from: e */
    private Map<String, String> f9860e = new ConcurrentHashMap();

    /* renamed from: c */
    public final String f9858c = "#273238";

    /* renamed from: d */
    public final String f9859d = "#757575";

    public ResBean() {
    }

    /* renamed from: a */
    public String m9318a(String str) {
        return this.f9860e.get(str);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResBean[] newArray(int i2) {
        return new ResBean[0];
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        for (String str : f9857b) {
            parcel.writeString(this.f9860e.get(str));
        }
    }

    /* renamed from: a */
    public void m9319a(String str, Object obj) {
        if (obj instanceof String) {
            this.f9860e.put(str, (String) obj);
        }
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResBean createFromParcel(Parcel parcel) {
        return new ResBean(parcel);
    }

    public ResBean(Parcel parcel) {
        try {
            for (String str : f9857b) {
                this.f9860e.put(str, parcel.readString());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
