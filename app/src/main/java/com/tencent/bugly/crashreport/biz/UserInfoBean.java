package com.tencent.bugly.crashreport.biz;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.aq;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class UserInfoBean implements Parcelable {
    public static final Parcelable.Creator<UserInfoBean> CREATOR = new Parcelable.Creator<UserInfoBean>() { // from class: com.tencent.bugly.crashreport.biz.UserInfoBean.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public UserInfoBean createFromParcel(Parcel parcel) {
            return new UserInfoBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public UserInfoBean[] newArray(int i2) {
            return new UserInfoBean[i2];
        }
    };
    public long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f6138d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f6139e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f6140f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f6141g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f6142h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f6143i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f6144j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f6145k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f6146l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f6147m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f6148n;
    public int o;
    public int p;
    public int q;
    public Map<String, String> r;
    public Map<String, String> s;

    public UserInfoBean() {
        this.f6145k = 0L;
        this.f6146l = false;
        this.f6147m = "unknown";
        this.p = -1;
        this.q = -1;
        this.r = null;
        this.s = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f6136b);
        parcel.writeString(this.f6137c);
        parcel.writeString(this.f6138d);
        parcel.writeLong(this.f6139e);
        parcel.writeLong(this.f6140f);
        parcel.writeLong(this.f6141g);
        parcel.writeLong(this.f6142h);
        parcel.writeLong(this.f6143i);
        parcel.writeString(this.f6144j);
        parcel.writeLong(this.f6145k);
        parcel.writeByte(this.f6146l ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f6147m);
        parcel.writeInt(this.p);
        parcel.writeInt(this.q);
        aq.b(parcel, this.r);
        aq.b(parcel, this.s);
        parcel.writeString(this.f6148n);
        parcel.writeInt(this.o);
    }

    public UserInfoBean(Parcel parcel) {
        this.f6145k = 0L;
        this.f6146l = false;
        this.f6147m = "unknown";
        this.p = -1;
        this.q = -1;
        this.r = null;
        this.s = null;
        this.f6136b = parcel.readInt();
        this.f6137c = parcel.readString();
        this.f6138d = parcel.readString();
        this.f6139e = parcel.readLong();
        this.f6140f = parcel.readLong();
        this.f6141g = parcel.readLong();
        this.f6142h = parcel.readLong();
        this.f6143i = parcel.readLong();
        this.f6144j = parcel.readString();
        this.f6145k = parcel.readLong();
        this.f6146l = parcel.readByte() == 1;
        this.f6147m = parcel.readString();
        this.p = parcel.readInt();
        this.q = parcel.readInt();
        this.r = aq.b(parcel);
        this.s = aq.b(parcel);
        this.f6148n = parcel.readString();
        this.o = parcel.readInt();
    }
}
