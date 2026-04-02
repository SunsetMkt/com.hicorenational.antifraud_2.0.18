package com.hihonor.honorid.core.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class HonorAccount implements Parcelable {
    public static final Parcelable.Creator<HonorAccount> CREATOR = new a();
    private String A;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f4127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f4128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f4129d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f4130e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f4132g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f4133h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f4134i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f4135j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f4136k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f4138m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f4139n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private boolean y;
    private String z;
    private String a = "-1";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f4131f = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f4137l = "";
    private int x = 0;

    class a implements Parcelable.Creator<HonorAccount> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HonorAccount createFromParcel(Parcel parcel) {
            HonorAccount honorAccount = new HonorAccount();
            honorAccount.a = parcel.readString();
            honorAccount.f4127b = parcel.readString();
            honorAccount.f4128c = parcel.readString();
            honorAccount.f4129d = parcel.readString();
            honorAccount.f4130e = parcel.readString();
            honorAccount.f4131f = parcel.readInt();
            honorAccount.f4132g = parcel.readString();
            honorAccount.f4133h = parcel.readString();
            honorAccount.f4134i = parcel.readString();
            honorAccount.f4135j = parcel.readString();
            honorAccount.f4136k = parcel.readString();
            honorAccount.f4137l = parcel.readString();
            honorAccount.f4138m = parcel.readString();
            honorAccount.f4139n = parcel.readString();
            honorAccount.o = parcel.readString();
            honorAccount.p = parcel.readString();
            honorAccount.q = parcel.readString();
            honorAccount.r = parcel.readString();
            honorAccount.s = parcel.readString();
            honorAccount.t = parcel.readString();
            honorAccount.u = parcel.readString();
            honorAccount.v = parcel.readString();
            honorAccount.y = parcel.readByte() == 1;
            honorAccount.z = parcel.readString();
            honorAccount.A = parcel.readString();
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
        parcel.writeString(this.a);
        parcel.writeString(this.f4127b);
        parcel.writeString(this.f4128c);
        parcel.writeString(this.f4129d);
        parcel.writeString(this.f4130e);
        parcel.writeInt(this.f4131f);
        parcel.writeString(this.f4132g);
        parcel.writeString(this.f4133h);
        parcel.writeString(this.f4134i);
        parcel.writeString(this.f4135j);
        parcel.writeString(this.f4136k);
        parcel.writeString(this.f4137l);
        parcel.writeString(this.f4138m);
        parcel.writeString(this.f4139n);
        parcel.writeString(this.o);
        parcel.writeString(this.p);
        parcel.writeString(this.q);
        parcel.writeString(this.r);
        parcel.writeString(this.s);
        parcel.writeString(this.t);
        parcel.writeString(this.u);
        parcel.writeString(this.v);
        parcel.writeByte(this.y ? (byte) 1 : (byte) 0);
        parcel.writeString(this.z);
        parcel.writeString(this.A);
    }

    public void x(String str) {
        this.f4130e = str;
    }

    public void b(int i2) {
        this.f4131f = i2;
    }

    public String c() {
        return this.f4129d;
    }

    public String d() {
        return this.f4136k;
    }

    public String e() {
        return this.r;
    }

    public void f(String str) {
        this.f4132g = str;
    }

    public void g(String str) {
        this.f4133h = str;
    }

    public void h(String str) {
        this.f4135j = str;
    }

    public String i() {
        return this.A;
    }

    public String j() {
        return this.f4138m;
    }

    public String k() {
        String str = this.s;
        return str == null ? "0" : str;
    }

    public String l() {
        return this.f4137l;
    }

    public String m() {
        return this.v;
    }

    public void n(String str) {
        this.f4139n = str;
    }

    public void o(String str) {
        this.a = str;
    }

    public String p() {
        return this.w;
    }

    public int q() {
        return this.f4131f;
    }

    public String r() {
        return this.f4134i;
    }

    public String s() {
        return this.f4128c;
    }

    public String t() {
        return this.f4127b;
    }

    public void u(String str) {
        this.f4127b = str;
    }

    public String v() {
        return this.z;
    }

    public void w(String str) {
        this.z = str;
    }

    public void b(String str) {
        this.t = str;
    }

    public void c(String str) {
        this.f4129d = str;
    }

    public void d(String str) {
        this.f4136k = str;
    }

    public void e(String str) {
        this.r = str;
    }

    public String f() {
        return this.f4133h;
    }

    public String g() {
        return this.f4135j;
    }

    public int h() {
        return this.x;
    }

    public void i(String str) {
        this.A = str;
    }

    public void j(String str) {
        this.f4138m = str;
    }

    public void k(String str) {
        this.s = str;
    }

    public void l(String str) {
        this.f4137l = str;
    }

    public void m(String str) {
        this.v = str;
    }

    public String n() {
        return this.u;
    }

    public String o() {
        return TextUtils.isEmpty(this.o) ? "" : this.o;
    }

    public void p(String str) {
        this.u = str;
    }

    public void q(String str) {
        this.o = str;
    }

    public void r(String str) {
        this.w = str;
    }

    public void s(String str) {
        this.f4134i = str;
    }

    public void t(String str) {
        this.f4128c = str;
    }

    public String u() {
        return this.p;
    }

    public void v(String str) {
        this.p = str;
    }

    public String w() {
        return this.f4130e;
    }

    public String a() {
        return this.q;
    }

    public String b() {
        return this.t;
    }

    public void a(String str) {
        this.q = str;
    }

    public void a(int i2) {
        this.x = i2;
    }

    public void a(boolean z) {
        this.y = z;
    }

    public HonorAccount a(Bundle bundle) {
        o(bundle.getString("sL"));
        u(bundle.getString("requestTokenType"));
        t(bundle.getString(d.c.a.b.a.a.N));
        c(bundle.getString(d.c.a.b.a.a.H));
        x(bundle.getString("userId"));
        b(bundle.getInt(d.c.a.b.a.a.q));
        f(bundle.getString("Cookie"));
        g(bundle.getString("deviceId"));
        s(bundle.getString(d.c.a.b.a.a.t));
        h(bundle.getString("deviceType"));
        d(bundle.getString("accountType"));
        l(bundle.getString("loginUserName"));
        j(bundle.getString(d.c.a.b.a.a.D));
        n(bundle.getString(d.c.a.b.a.a.E));
        q(bundle.getString(d.c.a.b.a.a.F));
        v(bundle.getString("uuid"));
        a(bundle.getString(d.c.a.b.a.a.f10078k));
        e(bundle.getString(d.c.a.b.a.a.f10079l));
        r(bundle.getString(d.c.a.b.a.a.f10080m));
        a(bundle.getInt(d.c.a.b.a.a.o, 0));
        k(bundle.getString(d.c.a.b.a.a.p));
        b(bundle.getString("access_token"));
        p(bundle.getString("code"));
        m(bundle.getString("open_id"));
        a(bundle.getBoolean(d.c.a.b.a.a.N1));
        w(bundle.getString(d.c.a.b.a.a.O1));
        i(bundle.getString(d.c.a.b.a.a.P1));
        return this;
    }
}
