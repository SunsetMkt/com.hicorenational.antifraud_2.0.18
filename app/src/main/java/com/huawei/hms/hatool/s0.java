package com.huawei.hms.hatool;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class s0 {
    private boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f4801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f4802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f4803d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f4804e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f4805f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private j0 f4806g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f4807h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Map<String, String> f4808i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f4809j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f4810k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f4811l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f4812m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f4813n;
    private boolean o;
    private String p;
    private long q;

    public s0() {
        this.f4804e = "";
        this.f4805f = "";
        this.f4806g = new j0();
        this.f4807h = "";
        this.f4809j = "";
        this.f4810k = 10;
        this.f4811l = 7;
        this.f4812m = true;
        this.f4813n = true;
        this.o = false;
        this.q = 0L;
    }

    public s0(s0 s0Var) {
        this.f4804e = "";
        this.f4805f = "";
        this.f4806g = new j0();
        this.f4807h = "";
        this.f4809j = "";
        this.f4810k = 10;
        this.f4811l = 7;
        this.f4812m = true;
        this.f4813n = true;
        this.o = false;
        this.q = 0L;
        this.f4806g = s0Var.f4806g;
        b(s0Var.a);
        a(s0Var.f4802c);
        b(s0Var.f4803d);
        e(s0Var.f4804e);
        g(s0Var.f4805f);
        d(s0Var.f4807h);
        f(s0Var.f4809j);
        c(s0Var.f4801b);
        a(s0Var.f4810k);
        b(s0Var.f4811l);
        d(s0Var.f4812m);
        a(s0Var.f4813n);
        e(s0Var.o);
        a(s0Var.f4808i);
        c(s0Var.p);
        a(s0Var.q);
    }

    public void a(int i2) {
        this.f4810k = i2;
    }

    public void a(long j2) {
        this.q = j2;
    }

    public void a(String str) {
        this.f4802c = str;
    }

    public void a(Map<String, String> map) {
        this.f4808i = map;
    }

    public void a(boolean z) {
        this.f4813n = z;
    }

    public boolean a() {
        return this.f4813n;
    }

    public int b() {
        return this.f4810k;
    }

    public void b(int i2) {
        this.f4811l = i2;
    }

    public void b(String str) {
        this.f4803d = str;
    }

    public void b(boolean z) {
        this.a = z;
    }

    public void c(String str) {
        this.p = str;
    }

    public void c(boolean z) {
        this.f4801b = z;
    }

    public boolean c() {
        return this.a;
    }

    public int d() {
        return this.f4811l;
    }

    public void d(String str) {
        this.f4807h = str;
    }

    public void d(boolean z) {
        this.f4812m = z;
    }

    public void e(String str) {
        this.f4804e = str;
    }

    public void e(boolean z) {
        this.o = z;
    }

    public boolean e() {
        return this.f4801b;
    }

    public String f() {
        return this.f4802c;
    }

    public void f(String str) {
        this.f4809j = str;
    }

    public void g(String str) {
        this.f4805f = str;
    }

    public boolean g() {
        return this.f4812m;
    }

    public String h() {
        return this.f4803d;
    }

    public boolean i() {
        return this.o;
    }

    public j0 j() {
        return this.f4806g;
    }

    public Map<String, String> k() {
        return this.f4808i;
    }

    public long l() {
        return this.q;
    }

    public String m() {
        return this.p;
    }

    public String n() {
        return this.f4807h;
    }

    public String o() {
        return this.f4804e;
    }

    public String p() {
        return this.f4809j;
    }

    public String q() {
        return this.f4805f;
    }
}
