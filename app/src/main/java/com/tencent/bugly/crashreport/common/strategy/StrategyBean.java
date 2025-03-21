package com.tencent.bugly.crashreport.common.strategy;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.C3154aq;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class StrategyBean implements Parcelable {
    public static final Parcelable.Creator<StrategyBean> CREATOR = new Parcelable.Creator<StrategyBean>() { // from class: com.tencent.bugly.crashreport.common.strategy.StrategyBean.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public StrategyBean createFromParcel(Parcel parcel) {
            return new StrategyBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public StrategyBean[] newArray(int i2) {
            return new StrategyBean[i2];
        }
    };

    /* renamed from: a */
    public static String f10224a = "http://rqd.uu.qq.com/rqd/sync";

    /* renamed from: b */
    public static String f10225b = "http://android.bugly.qq.com/rqd/async";

    /* renamed from: c */
    public static String f10226c = "http://android.bugly.qq.com/rqd/async";

    /* renamed from: d */
    public static String f10227d;

    /* renamed from: e */
    public long f10228e;

    /* renamed from: f */
    public long f10229f;

    /* renamed from: g */
    public boolean f10230g;

    /* renamed from: h */
    public boolean f10231h;

    /* renamed from: i */
    public boolean f10232i;

    /* renamed from: j */
    public boolean f10233j;

    /* renamed from: k */
    public boolean f10234k;

    /* renamed from: l */
    public boolean f10235l;

    /* renamed from: m */
    public boolean f10236m;

    /* renamed from: n */
    public boolean f10237n;

    /* renamed from: o */
    public boolean f10238o;

    /* renamed from: p */
    public long f10239p;

    /* renamed from: q */
    public long f10240q;

    /* renamed from: r */
    public String f10241r;

    /* renamed from: s */
    public String f10242s;

    /* renamed from: t */
    public String f10243t;

    /* renamed from: u */
    public String f10244u;

    /* renamed from: v */
    public Map<String, String> f10245v;

    /* renamed from: w */
    public int f10246w;

    /* renamed from: x */
    public long f10247x;

    /* renamed from: y */
    public long f10248y;

    public StrategyBean() {
        this.f10228e = -1L;
        this.f10229f = -1L;
        this.f10230g = true;
        this.f10231h = true;
        this.f10232i = true;
        this.f10233j = true;
        this.f10234k = false;
        this.f10235l = true;
        this.f10236m = true;
        this.f10237n = true;
        this.f10238o = true;
        this.f10240q = 30000L;
        this.f10241r = f10225b;
        this.f10242s = f10226c;
        this.f10243t = f10224a;
        this.f10246w = 10;
        this.f10247x = 300000L;
        this.f10248y = -1L;
        this.f10229f = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("S(");
        sb.append("@L@L");
        sb.append("@)");
        f10227d = sb.toString();
        sb.setLength(0);
        sb.append("*^");
        sb.append("@K#K");
        sb.append("@!");
        this.f10244u = sb.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f10229f);
        parcel.writeByte(this.f10230g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f10231h ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f10232i ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f10241r);
        parcel.writeString(this.f10242s);
        parcel.writeString(this.f10244u);
        C3154aq.m9984b(parcel, this.f10245v);
        parcel.writeByte(this.f10233j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f10234k ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f10237n ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f10238o ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f10240q);
        parcel.writeByte(this.f10235l ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f10236m ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f10239p);
        parcel.writeInt(this.f10246w);
        parcel.writeLong(this.f10247x);
        parcel.writeLong(this.f10248y);
    }

    public StrategyBean(Parcel parcel) {
        this.f10228e = -1L;
        this.f10229f = -1L;
        boolean z = true;
        this.f10230g = true;
        this.f10231h = true;
        this.f10232i = true;
        this.f10233j = true;
        this.f10234k = false;
        this.f10235l = true;
        this.f10236m = true;
        this.f10237n = true;
        this.f10238o = true;
        this.f10240q = 30000L;
        this.f10241r = f10225b;
        this.f10242s = f10226c;
        this.f10243t = f10224a;
        this.f10246w = 10;
        this.f10247x = 300000L;
        this.f10248y = -1L;
        try {
            f10227d = "S(@L@L@)";
            this.f10229f = parcel.readLong();
            this.f10230g = parcel.readByte() == 1;
            this.f10231h = parcel.readByte() == 1;
            this.f10232i = parcel.readByte() == 1;
            this.f10241r = parcel.readString();
            this.f10242s = parcel.readString();
            this.f10244u = parcel.readString();
            this.f10245v = C3154aq.m9982b(parcel);
            this.f10233j = parcel.readByte() == 1;
            this.f10234k = parcel.readByte() == 1;
            this.f10237n = parcel.readByte() == 1;
            this.f10238o = parcel.readByte() == 1;
            this.f10240q = parcel.readLong();
            this.f10235l = parcel.readByte() == 1;
            if (parcel.readByte() != 1) {
                z = false;
            }
            this.f10236m = z;
            this.f10239p = parcel.readLong();
            this.f10246w = parcel.readInt();
            this.f10247x = parcel.readLong();
            this.f10248y = parcel.readLong();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
