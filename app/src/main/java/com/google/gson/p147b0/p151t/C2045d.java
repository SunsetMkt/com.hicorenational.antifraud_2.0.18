package com.google.gson.p147b0.p151t;

import com.google.gson.InterfaceC2078z;
import com.google.gson.p147b0.p148q.C2027d;
import java.sql.Timestamp;
import java.util.Date;

/* compiled from: SqlTypesSupport.java */
/* renamed from: com.google.gson.b0.t.d */
/* loaded from: classes.dex */
public final class C2045d {

    /* renamed from: a */
    public static final boolean f5891a;

    /* renamed from: b */
    public static final C2027d.b<? extends Date> f5892b;

    /* renamed from: c */
    public static final C2027d.b<? extends Date> f5893c;

    /* renamed from: d */
    public static final InterfaceC2078z f5894d;

    /* renamed from: e */
    public static final InterfaceC2078z f5895e;

    /* renamed from: f */
    public static final InterfaceC2078z f5896f;

    /* compiled from: SqlTypesSupport.java */
    /* renamed from: com.google.gson.b0.t.d$a */
    class a extends C2027d.b<java.sql.Date> {
        a(Class cls) {
            super(cls);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.p147b0.p148q.C2027d.b
        /* renamed from: a */
        public java.sql.Date mo5408a(Date date) {
            return new java.sql.Date(date.getTime());
        }
    }

    /* compiled from: SqlTypesSupport.java */
    /* renamed from: com.google.gson.b0.t.d$b */
    class b extends C2027d.b<Timestamp> {
        b(Class cls) {
            super(cls);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.p147b0.p148q.C2027d.b
        /* renamed from: a */
        public Timestamp mo5408a(Date date) {
            return new Timestamp(date.getTime());
        }
    }

    static {
        boolean z;
        try {
            Class.forName("java.sql.Date");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        f5891a = z;
        if (f5891a) {
            f5892b = new a(java.sql.Date.class);
            f5893c = new b(Timestamp.class);
            f5894d = C2042a.f5885b;
            f5895e = C2043b.f5887b;
            f5896f = C2044c.f5889b;
            return;
        }
        f5892b = null;
        f5893c = null;
        f5894d = null;
        f5895e = null;
        f5896f = null;
    }

    private C2045d() {
    }
}
