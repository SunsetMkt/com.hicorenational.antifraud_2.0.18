package com.tencent.bugly.crashreport.biz;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.C3154aq;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class UserInfoBean implements Parcelable {
    public static final Parcelable.Creator<UserInfoBean> CREATOR = new Parcelable.Creator<UserInfoBean>() { // from class: com.tencent.bugly.crashreport.biz.UserInfoBean.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public UserInfoBean createFromParcel(Parcel parcel) {
            return new UserInfoBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public UserInfoBean[] newArray(int i2) {
            return new UserInfoBean[i2];
        }
    };

    /* renamed from: a */
    public long f10080a;

    /* renamed from: b */
    public int f10081b;

    /* renamed from: c */
    public String f10082c;

    /* renamed from: d */
    public String f10083d;

    /* renamed from: e */
    public long f10084e;

    /* renamed from: f */
    public long f10085f;

    /* renamed from: g */
    public long f10086g;

    /* renamed from: h */
    public long f10087h;

    /* renamed from: i */
    public long f10088i;

    /* renamed from: j */
    public String f10089j;

    /* renamed from: k */
    public long f10090k;

    /* renamed from: l */
    public boolean f10091l;

    /* renamed from: m */
    public String f10092m;

    /* renamed from: n */
    public String f10093n;

    /* renamed from: o */
    public int f10094o;

    /* renamed from: p */
    public int f10095p;

    /* renamed from: q */
    public int f10096q;

    /* renamed from: r */
    public Map<String, String> f10097r;

    /* renamed from: s */
    public Map<String, String> f10098s;

    public UserInfoBean() {
        this.f10090k = 0L;
        this.f10091l = false;
        this.f10092m = "unknown";
        this.f10095p = -1;
        this.f10096q = -1;
        this.f10097r = null;
        this.f10098s = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f10081b);
        parcel.writeString(this.f10082c);
        parcel.writeString(this.f10083d);
        parcel.writeLong(this.f10084e);
        parcel.writeLong(this.f10085f);
        parcel.writeLong(this.f10086g);
        parcel.writeLong(this.f10087h);
        parcel.writeLong(this.f10088i);
        parcel.writeString(this.f10089j);
        parcel.writeLong(this.f10090k);
        parcel.writeByte(this.f10091l ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f10092m);
        parcel.writeInt(this.f10095p);
        parcel.writeInt(this.f10096q);
        C3154aq.m9984b(parcel, this.f10097r);
        C3154aq.m9984b(parcel, this.f10098s);
        parcel.writeString(this.f10093n);
        parcel.writeInt(this.f10094o);
    }

    public UserInfoBean(Parcel parcel) {
        this.f10090k = 0L;
        this.f10091l = false;
        this.f10092m = "unknown";
        this.f10095p = -1;
        this.f10096q = -1;
        this.f10097r = null;
        this.f10098s = null;
        this.f10081b = parcel.readInt();
        this.f10082c = parcel.readString();
        this.f10083d = parcel.readString();
        this.f10084e = parcel.readLong();
        this.f10085f = parcel.readLong();
        this.f10086g = parcel.readLong();
        this.f10087h = parcel.readLong();
        this.f10088i = parcel.readLong();
        this.f10089j = parcel.readString();
        this.f10090k = parcel.readLong();
        this.f10091l = parcel.readByte() == 1;
        this.f10092m = parcel.readString();
        this.f10095p = parcel.readInt();
        this.f10096q = parcel.readInt();
        this.f10097r = C3154aq.m9982b(parcel);
        this.f10098s = C3154aq.m9982b(parcel);
        this.f10093n = parcel.readString();
        this.f10094o = parcel.readInt();
    }
}
