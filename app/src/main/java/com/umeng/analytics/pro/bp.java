package com.umeng.analytics.pro;

/* JADX INFO: compiled from: TApplicationException.java */
/* JADX INFO: loaded from: classes2.dex */
public class bp extends bw {
    public static final int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f7112b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f7113c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f7114d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f7115e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f7116f = 5;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f7117g = 6;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f7118h = 7;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final cu f7119j = new cu("TApplicationException");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final ck f7120k = new ck("message", (byte) 11, 1);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final ck f7121l = new ck("type", (byte) 8, 2);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final long f7122m = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected int f7123i;

    public bp() {
        this.f7123i = 0;
    }

    public int a() {
        return this.f7123i;
    }

    public void b(cp cpVar) throws bw {
        cpVar.a(f7119j);
        if (getMessage() != null) {
            cpVar.a(f7120k);
            cpVar.a(getMessage());
            cpVar.c();
        }
        cpVar.a(f7121l);
        cpVar.a(this.f7123i);
        cpVar.c();
        cpVar.d();
        cpVar.b();
    }

    public static bp a(cp cpVar) throws bw {
        cpVar.j();
        String strZ = null;
        int iW = 0;
        while (true) {
            ck ckVarL = cpVar.l();
            byte b2 = ckVarL.f7175b;
            if (b2 == 0) {
                cpVar.k();
                return new bp(iW, strZ);
            }
            short s = ckVarL.f7176c;
            if (s != 1) {
                if (s != 2) {
                    cs.a(cpVar, b2);
                } else if (b2 == 8) {
                    iW = cpVar.w();
                } else {
                    cs.a(cpVar, b2);
                }
            } else if (b2 == 11) {
                strZ = cpVar.z();
            } else {
                cs.a(cpVar, b2);
            }
            cpVar.m();
        }
    }

    public bp(int i2) {
        this.f7123i = 0;
        this.f7123i = i2;
    }

    public bp(int i2, String str) {
        super(str);
        this.f7123i = 0;
        this.f7123i = i2;
    }

    public bp(String str) {
        super(str);
        this.f7123i = 0;
    }
}
