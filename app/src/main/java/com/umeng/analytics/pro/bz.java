package com.umeng.analytics.pro;

import com.umeng.analytics.pro.cj;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: TSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class bz {
    private final ByteArrayOutputStream a;

    /* JADX INFO: renamed from: b */
    private final db f7127b;

    /* JADX INFO: renamed from: c */
    private cp f7128c;

    public bz() {
        this(new cj.a());
    }

    public byte[] a(bq bqVar) throws bw {
        this.a.reset();
        bqVar.write(this.f7128c);
        return this.a.toByteArray();
    }

    public String b(bq bqVar) throws bw {
        return new String(a(bqVar));
    }

    public bz(cr crVar) {
        this.a = new ByteArrayOutputStream();
        this.f7127b = new db(this.a);
        this.f7128c = crVar.a(this.f7127b);
    }

    public String a(bq bqVar, String str) throws bw {
        try {
            return new String(a(bqVar), str);
        } catch (UnsupportedEncodingException unused) {
            throw new bw("JVM DOES NOT SUPPORT ENCODING: " + str);
        }
    }
}
