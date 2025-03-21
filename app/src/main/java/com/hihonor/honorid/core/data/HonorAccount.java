package com.hihonor.honorid.core.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* loaded from: classes.dex */
public class HonorAccount implements Parcelable {
    public static final Parcelable.Creator<HonorAccount> CREATOR = new C2156a();

    /* renamed from: A */
    private String f6526A;

    /* renamed from: b */
    private String f6528b;

    /* renamed from: c */
    private String f6529c;

    /* renamed from: d */
    private String f6530d;

    /* renamed from: e */
    private String f6531e;

    /* renamed from: g */
    private String f6533g;

    /* renamed from: h */
    private String f6534h;

    /* renamed from: i */
    private String f6535i;

    /* renamed from: j */
    private String f6536j;

    /* renamed from: k */
    private String f6537k;

    /* renamed from: m */
    private String f6539m;

    /* renamed from: n */
    private String f6540n;

    /* renamed from: o */
    private String f6541o;

    /* renamed from: p */
    private String f6542p;

    /* renamed from: q */
    private String f6543q;

    /* renamed from: r */
    private String f6544r;

    /* renamed from: s */
    private String f6545s;

    /* renamed from: t */
    private String f6546t;

    /* renamed from: u */
    private String f6547u;

    /* renamed from: v */
    private String f6548v;

    /* renamed from: w */
    private String f6549w;

    /* renamed from: y */
    private boolean f6551y;

    /* renamed from: z */
    private String f6552z;

    /* renamed from: a */
    private String f6527a = "-1";

    /* renamed from: f */
    private int f6532f = 0;

    /* renamed from: l */
    private String f6538l = "";

    /* renamed from: x */
    private int f6550x = 0;

    /* renamed from: com.hihonor.honorid.core.data.HonorAccount$a */
    class C2156a implements Parcelable.Creator<HonorAccount> {
        C2156a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HonorAccount createFromParcel(Parcel parcel) {
            HonorAccount honorAccount = new HonorAccount();
            honorAccount.f6527a = parcel.readString();
            honorAccount.f6528b = parcel.readString();
            honorAccount.f6529c = parcel.readString();
            honorAccount.f6530d = parcel.readString();
            honorAccount.f6531e = parcel.readString();
            honorAccount.f6532f = parcel.readInt();
            honorAccount.f6533g = parcel.readString();
            honorAccount.f6534h = parcel.readString();
            honorAccount.f6535i = parcel.readString();
            honorAccount.f6536j = parcel.readString();
            honorAccount.f6537k = parcel.readString();
            honorAccount.f6538l = parcel.readString();
            honorAccount.f6539m = parcel.readString();
            honorAccount.f6540n = parcel.readString();
            honorAccount.f6541o = parcel.readString();
            honorAccount.f6542p = parcel.readString();
            honorAccount.f6543q = parcel.readString();
            honorAccount.f6544r = parcel.readString();
            honorAccount.f6545s = parcel.readString();
            honorAccount.f6546t = parcel.readString();
            honorAccount.f6547u = parcel.readString();
            honorAccount.f6548v = parcel.readString();
            honorAccount.f6551y = parcel.readByte() == 1;
            honorAccount.f6552z = parcel.readString();
            honorAccount.f6526A = parcel.readString();
            return honorAccount;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HonorAccount[] newArray(int i2) {
            return new HonorAccount[i2];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "HonorAccount";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f6527a);
        parcel.writeString(this.f6528b);
        parcel.writeString(this.f6529c);
        parcel.writeString(this.f6530d);
        parcel.writeString(this.f6531e);
        parcel.writeInt(this.f6532f);
        parcel.writeString(this.f6533g);
        parcel.writeString(this.f6534h);
        parcel.writeString(this.f6535i);
        parcel.writeString(this.f6536j);
        parcel.writeString(this.f6537k);
        parcel.writeString(this.f6538l);
        parcel.writeString(this.f6539m);
        parcel.writeString(this.f6540n);
        parcel.writeString(this.f6541o);
        parcel.writeString(this.f6542p);
        parcel.writeString(this.f6543q);
        parcel.writeString(this.f6544r);
        parcel.writeString(this.f6545s);
        parcel.writeString(this.f6546t);
        parcel.writeString(this.f6547u);
        parcel.writeString(this.f6548v);
        parcel.writeByte(this.f6551y ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f6552z);
        parcel.writeString(this.f6526A);
    }

    /* renamed from: x */
    public void m6205x(String str) {
        this.f6531e = str;
    }

    /* renamed from: b */
    public void m6161b(int i2) {
        this.f6532f = i2;
    }

    /* renamed from: c */
    public String m6163c() {
        return this.f6530d;
    }

    /* renamed from: d */
    public String m6165d() {
        return this.f6537k;
    }

    /* renamed from: e */
    public String m6167e() {
        return this.f6544r;
    }

    /* renamed from: f */
    public void m6170f(String str) {
        this.f6533g = str;
    }

    /* renamed from: g */
    public void m6172g(String str) {
        this.f6534h = str;
    }

    /* renamed from: h */
    public void m6174h(String str) {
        this.f6536j = str;
    }

    /* renamed from: i */
    public String m6175i() {
        return this.f6526A;
    }

    /* renamed from: j */
    public String m6177j() {
        return this.f6539m;
    }

    /* renamed from: k */
    public String m6179k() {
        String str = this.f6545s;
        return str == null ? "0" : str;
    }

    /* renamed from: l */
    public String m6181l() {
        return this.f6538l;
    }

    /* renamed from: m */
    public String m6183m() {
        return this.f6548v;
    }

    /* renamed from: n */
    public void m6186n(String str) {
        this.f6540n = str;
    }

    /* renamed from: o */
    public void m6188o(String str) {
        this.f6527a = str;
    }

    /* renamed from: p */
    public String m6189p() {
        return this.f6549w;
    }

    /* renamed from: q */
    public int m6191q() {
        return this.f6532f;
    }

    /* renamed from: r */
    public String m6193r() {
        return this.f6535i;
    }

    /* renamed from: s */
    public String m6195s() {
        return this.f6529c;
    }

    /* renamed from: t */
    public String m6197t() {
        return this.f6528b;
    }

    /* renamed from: u */
    public void m6200u(String str) {
        this.f6528b = str;
    }

    /* renamed from: v */
    public String m6201v() {
        return this.f6552z;
    }

    /* renamed from: w */
    public void m6204w(String str) {
        this.f6552z = str;
    }

    /* renamed from: b */
    public void m6162b(String str) {
        this.f6546t = str;
    }

    /* renamed from: c */
    public void m6164c(String str) {
        this.f6530d = str;
    }

    /* renamed from: d */
    public void m6166d(String str) {
        this.f6537k = str;
    }

    /* renamed from: e */
    public void m6168e(String str) {
        this.f6544r = str;
    }

    /* renamed from: f */
    public String m6169f() {
        return this.f6534h;
    }

    /* renamed from: g */
    public String m6171g() {
        return this.f6536j;
    }

    /* renamed from: h */
    public int m6173h() {
        return this.f6550x;
    }

    /* renamed from: i */
    public void m6176i(String str) {
        this.f6526A = str;
    }

    /* renamed from: j */
    public void m6178j(String str) {
        this.f6539m = str;
    }

    /* renamed from: k */
    public void m6180k(String str) {
        this.f6545s = str;
    }

    /* renamed from: l */
    public void m6182l(String str) {
        this.f6538l = str;
    }

    /* renamed from: m */
    public void m6184m(String str) {
        this.f6548v = str;
    }

    /* renamed from: n */
    public String m6185n() {
        return this.f6547u;
    }

    /* renamed from: o */
    public String m6187o() {
        return TextUtils.isEmpty(this.f6541o) ? "" : this.f6541o;
    }

    /* renamed from: p */
    public void m6190p(String str) {
        this.f6547u = str;
    }

    /* renamed from: q */
    public void m6192q(String str) {
        this.f6541o = str;
    }

    /* renamed from: r */
    public void m6194r(String str) {
        this.f6549w = str;
    }

    /* renamed from: s */
    public void m6196s(String str) {
        this.f6535i = str;
    }

    /* renamed from: t */
    public void m6198t(String str) {
        this.f6529c = str;
    }

    /* renamed from: u */
    public String m6199u() {
        return this.f6542p;
    }

    /* renamed from: v */
    public void m6202v(String str) {
        this.f6542p = str;
    }

    /* renamed from: w */
    public String m6203w() {
        return this.f6531e;
    }

    /* renamed from: a */
    public String m6156a() {
        return this.f6543q;
    }

    /* renamed from: b */
    public String m6160b() {
        return this.f6546t;
    }

    /* renamed from: a */
    public void m6158a(String str) {
        this.f6543q = str;
    }

    /* renamed from: a */
    public void m6157a(int i2) {
        this.f6550x = i2;
    }

    /* renamed from: a */
    public void m6159a(boolean z) {
        this.f6551y = z;
    }

    /* renamed from: a */
    public HonorAccount m6155a(Bundle bundle) {
        m6188o(bundle.getString("sL"));
        m6200u(bundle.getString("requestTokenType"));
        m6198t(bundle.getString(AbstractC1191a.f2521N));
        m6164c(bundle.getString(AbstractC1191a.f2503H));
        m6205x(bundle.getString("userId"));
        m6161b(bundle.getInt(AbstractC1191a.f2598q));
        m6170f(bundle.getString("Cookie"));
        m6172g(bundle.getString("deviceId"));
        m6196s(bundle.getString(AbstractC1191a.f2607t));
        m6174h(bundle.getString("deviceType"));
        m6166d(bundle.getString("accountType"));
        m6182l(bundle.getString("loginUserName"));
        m6178j(bundle.getString(AbstractC1191a.f2491D));
        m6186n(bundle.getString(AbstractC1191a.f2494E));
        m6192q(bundle.getString(AbstractC1191a.f2497F));
        m6202v(bundle.getString("uuid"));
        m6158a(bundle.getString(AbstractC1191a.f2580k));
        m6168e(bundle.getString(AbstractC1191a.f2583l));
        m6194r(bundle.getString(AbstractC1191a.f2586m));
        m6157a(bundle.getInt(AbstractC1191a.f2592o, 0));
        m6180k(bundle.getString(AbstractC1191a.f2595p));
        m6162b(bundle.getString("access_token"));
        m6190p(bundle.getString("code"));
        m6184m(bundle.getString("open_id"));
        m6159a(bundle.getBoolean(AbstractC1191a.f2523N1));
        m6204w(bundle.getString(AbstractC1191a.f2526O1));
        m6176i(bundle.getString(AbstractC1191a.f2529P1));
        return this;
    }
}
