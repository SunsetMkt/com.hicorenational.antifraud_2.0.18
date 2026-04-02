package com.tencent.bugly.crashreport.crash;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.proguard.aq;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class CrashDetailBean implements Parcelable, Comparable<CrashDetailBean> {
    public static final Parcelable.Creator<CrashDetailBean> CREATOR = new Parcelable.Creator<CrashDetailBean>() { // from class: com.tencent.bugly.crashreport.crash.CrashDetailBean.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CrashDetailBean createFromParcel(Parcel parcel) {
            return new CrashDetailBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CrashDetailBean[] newArray(int i2) {
            return new CrashDetailBean[i2];
        }
    };
    public String A;
    public String B;
    public long C;
    public long D;
    public long E;
    public long F;
    public long G;
    public long H;
    public String I;
    public String J;
    public String K;
    public String L;
    public String M;
    public long N;
    public boolean O;
    public Map<String, String> P;
    public int Q;
    public int R;
    public Map<String, String> S;
    public Map<String, String> T;
    public byte[] U;
    public String V;
    public String W;
    public long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6217c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f6218d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f6219e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f6220f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f6221g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map<String, PlugInBean> f6222h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map<String, PlugInBean> f6223i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f6224j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f6225k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f6226l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f6227m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f6228n;
    public String o;
    public String p;
    public String q;
    public long r;
    public String s;
    public int t;
    public String u;
    public String v;
    public String w;
    public String x;
    public byte[] y;
    public Map<String, String> z;

    public CrashDetailBean() {
        this.a = -1L;
        this.f6216b = 0;
        this.f6217c = UUID.randomUUID().toString();
        this.f6218d = false;
        this.f6219e = "";
        this.f6220f = "";
        this.f6221g = "";
        this.f6222h = null;
        this.f6223i = null;
        this.f6224j = false;
        this.f6225k = false;
        this.f6226l = 0;
        this.f6227m = "";
        this.f6228n = "";
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = -1L;
        this.s = null;
        this.t = 0;
        this.u = "";
        this.v = "";
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = "";
        this.B = "";
        this.C = -1L;
        this.D = -1L;
        this.E = -1L;
        this.F = -1L;
        this.G = -1L;
        this.H = -1L;
        this.I = "";
        this.J = "";
        this.K = "";
        this.L = "";
        this.M = "";
        this.N = -1L;
        this.O = false;
        this.P = null;
        this.Q = -1;
        this.R = -1;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = null;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return 1;
        }
        long j2 = this.r - crashDetailBean.r;
        if (j2 > 0) {
            return 1;
        }
        return j2 < 0 ? -1 : 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f6216b);
        parcel.writeString(this.f6217c);
        parcel.writeByte(this.f6218d ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f6219e);
        parcel.writeString(this.f6220f);
        parcel.writeString(this.f6221g);
        parcel.writeByte(this.f6224j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6225k ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f6226l);
        parcel.writeString(this.f6227m);
        parcel.writeString(this.f6228n);
        parcel.writeString(this.o);
        parcel.writeString(this.p);
        parcel.writeString(this.q);
        parcel.writeLong(this.r);
        parcel.writeString(this.s);
        parcel.writeInt(this.t);
        parcel.writeString(this.u);
        parcel.writeString(this.v);
        parcel.writeString(this.w);
        aq.b(parcel, this.z);
        parcel.writeString(this.A);
        parcel.writeString(this.B);
        parcel.writeLong(this.C);
        parcel.writeLong(this.D);
        parcel.writeLong(this.E);
        parcel.writeLong(this.F);
        parcel.writeLong(this.G);
        parcel.writeLong(this.H);
        parcel.writeString(this.I);
        parcel.writeString(this.J);
        parcel.writeString(this.K);
        parcel.writeString(this.L);
        parcel.writeString(this.M);
        parcel.writeLong(this.N);
        parcel.writeByte(this.O ? (byte) 1 : (byte) 0);
        aq.b(parcel, this.P);
        aq.a(parcel, this.f6222h);
        aq.a(parcel, this.f6223i);
        parcel.writeInt(this.Q);
        parcel.writeInt(this.R);
        aq.b(parcel, this.S);
        aq.b(parcel, this.T);
        parcel.writeByteArray(this.U);
        parcel.writeByteArray(this.y);
        parcel.writeString(this.V);
        parcel.writeString(this.W);
        parcel.writeString(this.x);
    }

    public CrashDetailBean(Parcel parcel) {
        this.a = -1L;
        this.f6216b = 0;
        this.f6217c = UUID.randomUUID().toString();
        this.f6218d = false;
        this.f6219e = "";
        this.f6220f = "";
        this.f6221g = "";
        this.f6222h = null;
        this.f6223i = null;
        this.f6224j = false;
        this.f6225k = false;
        this.f6226l = 0;
        this.f6227m = "";
        this.f6228n = "";
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = -1L;
        this.s = null;
        this.t = 0;
        this.u = "";
        this.v = "";
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = "";
        this.B = "";
        this.C = -1L;
        this.D = -1L;
        this.E = -1L;
        this.F = -1L;
        this.G = -1L;
        this.H = -1L;
        this.I = "";
        this.J = "";
        this.K = "";
        this.L = "";
        this.M = "";
        this.N = -1L;
        this.O = false;
        this.P = null;
        this.Q = -1;
        this.R = -1;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = null;
        this.f6216b = parcel.readInt();
        this.f6217c = parcel.readString();
        this.f6218d = parcel.readByte() == 1;
        this.f6219e = parcel.readString();
        this.f6220f = parcel.readString();
        this.f6221g = parcel.readString();
        this.f6224j = parcel.readByte() == 1;
        this.f6225k = parcel.readByte() == 1;
        this.f6226l = parcel.readInt();
        this.f6227m = parcel.readString();
        this.f6228n = parcel.readString();
        this.o = parcel.readString();
        this.p = parcel.readString();
        this.q = parcel.readString();
        this.r = parcel.readLong();
        this.s = parcel.readString();
        this.t = parcel.readInt();
        this.u = parcel.readString();
        this.v = parcel.readString();
        this.w = parcel.readString();
        this.z = aq.b(parcel);
        this.A = parcel.readString();
        this.B = parcel.readString();
        this.C = parcel.readLong();
        this.D = parcel.readLong();
        this.E = parcel.readLong();
        this.F = parcel.readLong();
        this.G = parcel.readLong();
        this.H = parcel.readLong();
        this.I = parcel.readString();
        this.J = parcel.readString();
        this.K = parcel.readString();
        this.L = parcel.readString();
        this.M = parcel.readString();
        this.N = parcel.readLong();
        this.O = parcel.readByte() == 1;
        this.P = aq.b(parcel);
        this.f6222h = aq.a(parcel);
        this.f6223i = aq.a(parcel);
        this.Q = parcel.readInt();
        this.R = parcel.readInt();
        this.S = aq.b(parcel);
        this.T = aq.b(parcel);
        this.U = parcel.createByteArray();
        this.y = parcel.createByteArray();
        this.V = parcel.readString();
        this.W = parcel.readString();
        this.x = parcel.readString();
    }
}
