package com.google.gson.b0.t;

import com.google.gson.b0.q.d;
import com.google.gson.z;
import java.sql.Timestamp;
import java.util.Date;

/* JADX INFO: compiled from: SqlTypesSupport.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static final boolean a;

    /* JADX INFO: renamed from: b */
    public static final d.b<? extends Date> f3767b;

    /* JADX INFO: renamed from: c */
    public static final d.b<? extends Date> f3768c;

    /* JADX INFO: renamed from: d */
    public static final z f3769d;

    /* JADX INFO: renamed from: e */
    public static final z f3770e;

    /* JADX INFO: renamed from: f */
    public static final z f3771f;

    /* JADX INFO: compiled from: SqlTypesSupport.java */
    class a extends d.b<java.sql.Date> {
        a(Class cls) {
            super(cls);
        }

        @Override // com.google.gson.b0.q.d.b
        public java.sql.Date a(Date date) {
            return new java.sql.Date(date.getTime());
        }
    }

    /* JADX INFO: compiled from: SqlTypesSupport.java */
    class b extends d.b<Timestamp> {
        b(Class cls) {
            super(cls);
        }

        @Override // com.google.gson.b0.q.d.b
        public Timestamp a(Date date) {
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
        a = z;
        if (a) {
            f3767b = new a(java.sql.Date.class);
            f3768c = new b(Timestamp.class);
            f3769d = com.google.gson.b0.t.a.f3764b;
            f3770e = com.google.gson.b0.t.b.f3765b;
            f3771f = c.f3766b;
            return;
        }
        f3767b = null;
        f3768c = null;
        f3769d = null;
        f3770e = null;
        f3771f = null;
    }

    private d() {
    }
}
