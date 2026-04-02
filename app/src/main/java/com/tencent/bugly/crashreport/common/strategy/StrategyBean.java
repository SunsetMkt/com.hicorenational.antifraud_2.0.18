package com.tencent.bugly.crashreport.common.strategy;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.aq;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class StrategyBean implements Parcelable {
    public static final Parcelable.Creator<StrategyBean> CREATOR = new Parcelable.Creator<StrategyBean>() { // from class: com.tencent.bugly.crashreport.common.strategy.StrategyBean.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public StrategyBean createFromParcel(Parcel parcel) {
            return new StrategyBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public StrategyBean[] newArray(int i2) {
            return new StrategyBean[i2];
        }
    };
    public static String a = "http://rqd.uu.qq.com/rqd/sync";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f6190b = "http://android.bugly.qq.com/rqd/async";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f6191c = "http://android.bugly.qq.com/rqd/async";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f6192d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f6193e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f6194f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f6195g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f6196h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f6197i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f6198j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f6199k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f6200l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f6201m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f6202n;
    public boolean o;
    public long p;
    public long q;
    public String r;
    public String s;
    public String t;
    public String u;
    public Map<String, String> v;
    public int w;
    public long x;
    public long y;

    public StrategyBean() {
        this.f6193e = -1L;
        this.f6194f = -1L;
        this.f6195g = true;
        this.f6196h = true;
        this.f6197i = true;
        this.f6198j = true;
        this.f6199k = false;
        this.f6200l = true;
        this.f6201m = true;
        this.f6202n = true;
        this.o = true;
        this.q = 30000L;
        this.r = f6190b;
        this.s = f6191c;
        this.t = a;
        this.w = 10;
        this.x = 300000L;
        this.y = -1L;
        this.f6194f = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("S(");
        sb.append("@L@L");
        sb.append("@)");
        f6192d = sb.toString();
        sb.setLength(0);
        sb.append("*^");
        sb.append("@K#K");
        sb.append("@!");
        this.u = sb.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f6194f);
        parcel.writeByte(this.f6195g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6196h ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6197i ? (byte) 1 : (byte) 0);
        parcel.writeString(this.r);
        parcel.writeString(this.s);
        parcel.writeString(this.u);
        aq.b(parcel, this.v);
        parcel.writeByte(this.f6198j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6199k ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6202n ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.o ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.q);
        parcel.writeByte(this.f6200l ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6201m ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.p);
        parcel.writeInt(this.w);
        parcel.writeLong(this.x);
        parcel.writeLong(this.y);
    }

    public StrategyBean(Parcel parcel) {
        this.f6193e = -1L;
        this.f6194f = -1L;
        boolean z = true;
        this.f6195g = true;
        this.f6196h = true;
        this.f6197i = true;
        this.f6198j = true;
        this.f6199k = false;
        this.f6200l = true;
        this.f6201m = true;
        this.f6202n = true;
        this.o = true;
        this.q = 30000L;
        this.r = f6190b;
        this.s = f6191c;
        this.t = a;
        this.w = 10;
        this.x = 300000L;
        this.y = -1L;
        try {
            f6192d = "S(@L@L@)";
            this.f6194f = parcel.readLong();
            this.f6195g = parcel.readByte() == 1;
            this.f6196h = parcel.readByte() == 1;
            this.f6197i = parcel.readByte() == 1;
            this.r = parcel.readString();
            this.s = parcel.readString();
            this.u = parcel.readString();
            this.v = aq.b(parcel);
            this.f6198j = parcel.readByte() == 1;
            this.f6199k = parcel.readByte() == 1;
            this.f6202n = parcel.readByte() == 1;
            this.o = parcel.readByte() == 1;
            this.q = parcel.readLong();
            this.f6200l = parcel.readByte() == 1;
            if (parcel.readByte() != 1) {
                z = false;
            }
            this.f6201m = z;
            this.p = parcel.readLong();
            this.w = parcel.readInt();
            this.x = parcel.readLong();
            this.y = parcel.readLong();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
