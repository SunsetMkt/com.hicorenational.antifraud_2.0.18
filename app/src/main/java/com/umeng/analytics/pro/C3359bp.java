package com.umeng.analytics.pro;

/* compiled from: TApplicationException.java */
/* renamed from: com.umeng.analytics.pro.bp */
/* loaded from: classes2.dex */
public class C3359bp extends C3366bw {

    /* renamed from: a */
    public static final int f11744a = 0;

    /* renamed from: b */
    public static final int f11745b = 1;

    /* renamed from: c */
    public static final int f11746c = 2;

    /* renamed from: d */
    public static final int f11747d = 3;

    /* renamed from: e */
    public static final int f11748e = 4;

    /* renamed from: f */
    public static final int f11749f = 5;

    /* renamed from: g */
    public static final int f11750g = 6;

    /* renamed from: h */
    public static final int f11751h = 7;

    /* renamed from: j */
    private static final C3391cu f11752j = new C3391cu("TApplicationException");

    /* renamed from: k */
    private static final C3381ck f11753k = new C3381ck("message", (byte) 11, 1);

    /* renamed from: l */
    private static final C3381ck f11754l = new C3381ck("type", (byte) 8, 2);

    /* renamed from: m */
    private static final long f11755m = 1;

    /* renamed from: i */
    protected int f11756i;

    public C3359bp() {
        this.f11756i = 0;
    }

    /* renamed from: a */
    public int m11031a() {
        return this.f11756i;
    }

    /* renamed from: b */
    public void m11032b(AbstractC3386cp abstractC3386cp) throws C3366bw {
        abstractC3386cp.mo11121a(f11752j);
        if (getMessage() != null) {
            abstractC3386cp.mo11116a(f11753k);
            abstractC3386cp.mo11122a(getMessage());
            abstractC3386cp.mo11128c();
        }
        abstractC3386cp.mo11116a(f11754l);
        abstractC3386cp.mo11114a(this.f11756i);
        abstractC3386cp.mo11128c();
        abstractC3386cp.mo11130d();
        abstractC3386cp.mo11127b();
    }

    /* renamed from: a */
    public static C3359bp m11030a(AbstractC3386cp abstractC3386cp) throws C3366bw {
        abstractC3386cp.mo11137j();
        String str = null;
        int i2 = 0;
        while (true) {
            C3381ck mo11139l = abstractC3386cp.mo11139l();
            byte b2 = mo11139l.f11834b;
            if (b2 == 0) {
                abstractC3386cp.mo11138k();
                return new C3359bp(i2, str);
            }
            short s = mo11139l.f11835c;
            if (s != 1) {
                if (s != 2) {
                    C3389cs.m11183a(abstractC3386cp, b2);
                } else if (b2 == 8) {
                    i2 = abstractC3386cp.mo11150w();
                } else {
                    C3389cs.m11183a(abstractC3386cp, b2);
                }
            } else if (b2 == 11) {
                str = abstractC3386cp.mo11153z();
            } else {
                C3389cs.m11183a(abstractC3386cp, b2);
            }
            abstractC3386cp.mo11140m();
        }
    }

    public C3359bp(int i2) {
        this.f11756i = 0;
        this.f11756i = i2;
    }

    public C3359bp(int i2, String str) {
        super(str);
        this.f11756i = 0;
        this.f11756i = i2;
    }

    public C3359bp(String str) {
        super(str);
        this.f11756i = 0;
    }
}
