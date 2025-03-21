package com.tencent.bugly.crashreport.crash;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.proguard.C3154aq;
import java.util.Map;
import java.util.UUID;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class CrashDetailBean implements Parcelable, Comparable<CrashDetailBean> {
    public static final Parcelable.Creator<CrashDetailBean> CREATOR = new Parcelable.Creator<CrashDetailBean>() { // from class: com.tencent.bugly.crashreport.crash.CrashDetailBean.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CrashDetailBean createFromParcel(Parcel parcel) {
            return new CrashDetailBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CrashDetailBean[] newArray(int i2) {
            return new CrashDetailBean[i2];
        }
    };

    /* renamed from: A */
    public String f10266A;

    /* renamed from: B */
    public String f10267B;

    /* renamed from: C */
    public long f10268C;

    /* renamed from: D */
    public long f10269D;

    /* renamed from: E */
    public long f10270E;

    /* renamed from: F */
    public long f10271F;

    /* renamed from: G */
    public long f10272G;

    /* renamed from: H */
    public long f10273H;

    /* renamed from: I */
    public String f10274I;

    /* renamed from: J */
    public String f10275J;

    /* renamed from: K */
    public String f10276K;

    /* renamed from: L */
    public String f10277L;

    /* renamed from: M */
    public String f10278M;

    /* renamed from: N */
    public long f10279N;

    /* renamed from: O */
    public boolean f10280O;

    /* renamed from: P */
    public Map<String, String> f10281P;

    /* renamed from: Q */
    public int f10282Q;

    /* renamed from: R */
    public int f10283R;

    /* renamed from: S */
    public Map<String, String> f10284S;

    /* renamed from: T */
    public Map<String, String> f10285T;

    /* renamed from: U */
    public byte[] f10286U;

    /* renamed from: V */
    public String f10287V;

    /* renamed from: W */
    public String f10288W;

    /* renamed from: a */
    public long f10289a;

    /* renamed from: b */
    public int f10290b;

    /* renamed from: c */
    public String f10291c;

    /* renamed from: d */
    public boolean f10292d;

    /* renamed from: e */
    public String f10293e;

    /* renamed from: f */
    public String f10294f;

    /* renamed from: g */
    public String f10295g;

    /* renamed from: h */
    public Map<String, PlugInBean> f10296h;

    /* renamed from: i */
    public Map<String, PlugInBean> f10297i;

    /* renamed from: j */
    public boolean f10298j;

    /* renamed from: k */
    public boolean f10299k;

    /* renamed from: l */
    public int f10300l;

    /* renamed from: m */
    public String f10301m;

    /* renamed from: n */
    public String f10302n;

    /* renamed from: o */
    public String f10303o;

    /* renamed from: p */
    public String f10304p;

    /* renamed from: q */
    public String f10305q;

    /* renamed from: r */
    public long f10306r;

    /* renamed from: s */
    public String f10307s;

    /* renamed from: t */
    public int f10308t;

    /* renamed from: u */
    public String f10309u;

    /* renamed from: v */
    public String f10310v;

    /* renamed from: w */
    public String f10311w;

    /* renamed from: x */
    public String f10312x;

    /* renamed from: y */
    public byte[] f10313y;

    /* renamed from: z */
    public Map<String, String> f10314z;

    public CrashDetailBean() {
        this.f10289a = -1L;
        this.f10290b = 0;
        this.f10291c = UUID.randomUUID().toString();
        this.f10292d = false;
        this.f10293e = "";
        this.f10294f = "";
        this.f10295g = "";
        this.f10296h = null;
        this.f10297i = null;
        this.f10298j = false;
        this.f10299k = false;
        this.f10300l = 0;
        this.f10301m = "";
        this.f10302n = "";
        this.f10303o = "";
        this.f10304p = "";
        this.f10305q = "";
        this.f10306r = -1L;
        this.f10307s = null;
        this.f10308t = 0;
        this.f10309u = "";
        this.f10310v = "";
        this.f10311w = null;
        this.f10312x = null;
        this.f10313y = null;
        this.f10314z = null;
        this.f10266A = "";
        this.f10267B = "";
        this.f10268C = -1L;
        this.f10269D = -1L;
        this.f10270E = -1L;
        this.f10271F = -1L;
        this.f10272G = -1L;
        this.f10273H = -1L;
        this.f10274I = "";
        this.f10275J = "";
        this.f10276K = "";
        this.f10277L = "";
        this.f10278M = "";
        this.f10279N = -1L;
        this.f10280O = false;
        this.f10281P = null;
        this.f10282Q = -1;
        this.f10283R = -1;
        this.f10284S = null;
        this.f10285T = null;
        this.f10286U = null;
        this.f10287V = null;
        this.f10288W = null;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return 1;
        }
        long j2 = this.f10306r - crashDetailBean.f10306r;
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
        parcel.writeInt(this.f10290b);
        parcel.writeString(this.f10291c);
        parcel.writeByte(this.f10292d ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f10293e);
        parcel.writeString(this.f10294f);
        parcel.writeString(this.f10295g);
        parcel.writeByte(this.f10298j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f10299k ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f10300l);
        parcel.writeString(this.f10301m);
        parcel.writeString(this.f10302n);
        parcel.writeString(this.f10303o);
        parcel.writeString(this.f10304p);
        parcel.writeString(this.f10305q);
        parcel.writeLong(this.f10306r);
        parcel.writeString(this.f10307s);
        parcel.writeInt(this.f10308t);
        parcel.writeString(this.f10309u);
        parcel.writeString(this.f10310v);
        parcel.writeString(this.f10311w);
        C3154aq.m9984b(parcel, this.f10314z);
        parcel.writeString(this.f10266A);
        parcel.writeString(this.f10267B);
        parcel.writeLong(this.f10268C);
        parcel.writeLong(this.f10269D);
        parcel.writeLong(this.f10270E);
        parcel.writeLong(this.f10271F);
        parcel.writeLong(this.f10272G);
        parcel.writeLong(this.f10273H);
        parcel.writeString(this.f10274I);
        parcel.writeString(this.f10275J);
        parcel.writeString(this.f10276K);
        parcel.writeString(this.f10277L);
        parcel.writeString(this.f10278M);
        parcel.writeLong(this.f10279N);
        parcel.writeByte(this.f10280O ? (byte) 1 : (byte) 0);
        C3154aq.m9984b(parcel, this.f10281P);
        C3154aq.m9965a(parcel, this.f10296h);
        C3154aq.m9965a(parcel, this.f10297i);
        parcel.writeInt(this.f10282Q);
        parcel.writeInt(this.f10283R);
        C3154aq.m9984b(parcel, this.f10284S);
        C3154aq.m9984b(parcel, this.f10285T);
        parcel.writeByteArray(this.f10286U);
        parcel.writeByteArray(this.f10313y);
        parcel.writeString(this.f10287V);
        parcel.writeString(this.f10288W);
        parcel.writeString(this.f10312x);
    }

    public CrashDetailBean(Parcel parcel) {
        this.f10289a = -1L;
        this.f10290b = 0;
        this.f10291c = UUID.randomUUID().toString();
        this.f10292d = false;
        this.f10293e = "";
        this.f10294f = "";
        this.f10295g = "";
        this.f10296h = null;
        this.f10297i = null;
        this.f10298j = false;
        this.f10299k = false;
        this.f10300l = 0;
        this.f10301m = "";
        this.f10302n = "";
        this.f10303o = "";
        this.f10304p = "";
        this.f10305q = "";
        this.f10306r = -1L;
        this.f10307s = null;
        this.f10308t = 0;
        this.f10309u = "";
        this.f10310v = "";
        this.f10311w = null;
        this.f10312x = null;
        this.f10313y = null;
        this.f10314z = null;
        this.f10266A = "";
        this.f10267B = "";
        this.f10268C = -1L;
        this.f10269D = -1L;
        this.f10270E = -1L;
        this.f10271F = -1L;
        this.f10272G = -1L;
        this.f10273H = -1L;
        this.f10274I = "";
        this.f10275J = "";
        this.f10276K = "";
        this.f10277L = "";
        this.f10278M = "";
        this.f10279N = -1L;
        this.f10280O = false;
        this.f10281P = null;
        this.f10282Q = -1;
        this.f10283R = -1;
        this.f10284S = null;
        this.f10285T = null;
        this.f10286U = null;
        this.f10287V = null;
        this.f10288W = null;
        this.f10290b = parcel.readInt();
        this.f10291c = parcel.readString();
        this.f10292d = parcel.readByte() == 1;
        this.f10293e = parcel.readString();
        this.f10294f = parcel.readString();
        this.f10295g = parcel.readString();
        this.f10298j = parcel.readByte() == 1;
        this.f10299k = parcel.readByte() == 1;
        this.f10300l = parcel.readInt();
        this.f10301m = parcel.readString();
        this.f10302n = parcel.readString();
        this.f10303o = parcel.readString();
        this.f10304p = parcel.readString();
        this.f10305q = parcel.readString();
        this.f10306r = parcel.readLong();
        this.f10307s = parcel.readString();
        this.f10308t = parcel.readInt();
        this.f10309u = parcel.readString();
        this.f10310v = parcel.readString();
        this.f10311w = parcel.readString();
        this.f10314z = C3154aq.m9982b(parcel);
        this.f10266A = parcel.readString();
        this.f10267B = parcel.readString();
        this.f10268C = parcel.readLong();
        this.f10269D = parcel.readLong();
        this.f10270E = parcel.readLong();
        this.f10271F = parcel.readLong();
        this.f10272G = parcel.readLong();
        this.f10273H = parcel.readLong();
        this.f10274I = parcel.readString();
        this.f10275J = parcel.readString();
        this.f10276K = parcel.readString();
        this.f10277L = parcel.readString();
        this.f10278M = parcel.readString();
        this.f10279N = parcel.readLong();
        this.f10280O = parcel.readByte() == 1;
        this.f10281P = C3154aq.m9982b(parcel);
        this.f10296h = C3154aq.m9963a(parcel);
        this.f10297i = C3154aq.m9963a(parcel);
        this.f10282Q = parcel.readInt();
        this.f10283R = parcel.readInt();
        this.f10284S = C3154aq.m9982b(parcel);
        this.f10285T = C3154aq.m9982b(parcel);
        this.f10286U = parcel.createByteArray();
        this.f10313y = parcel.createByteArray();
        this.f10287V = parcel.readString();
        this.f10288W = parcel.readString();
        this.f10312x = parcel.readString();
    }
}
