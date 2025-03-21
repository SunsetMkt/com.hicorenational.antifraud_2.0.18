package com.umeng.analytics.pro;

import com.umeng.analytics.pro.C3380cj;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* compiled from: TSerializer.java */
/* renamed from: com.umeng.analytics.pro.bz */
/* loaded from: classes2.dex */
public class C3369bz {

    /* renamed from: a */
    private final ByteArrayOutputStream f11764a;

    /* renamed from: b */
    private final C3399db f11765b;

    /* renamed from: c */
    private AbstractC3386cp f11766c;

    public C3369bz() {
        this(new C3380cj.a());
    }

    /* renamed from: a */
    public byte[] m11073a(InterfaceC3360bq interfaceC3360bq) throws C3366bw {
        this.f11764a.reset();
        interfaceC3360bq.write(this.f11766c);
        return this.f11764a.toByteArray();
    }

    /* renamed from: b */
    public String m11074b(InterfaceC3360bq interfaceC3360bq) throws C3366bw {
        return new String(m11073a(interfaceC3360bq));
    }

    public C3369bz(InterfaceC3388cr interfaceC3388cr) {
        this.f11764a = new ByteArrayOutputStream();
        this.f11765b = new C3399db(this.f11764a);
        this.f11766c = interfaceC3388cr.mo11154a(this.f11765b);
    }

    /* renamed from: a */
    public String m11072a(InterfaceC3360bq interfaceC3360bq, String str) throws C3366bw {
        try {
            return new String(m11073a(interfaceC3360bq), str);
        } catch (UnsupportedEncodingException unused) {
            throw new C3366bw("JVM DOES NOT SUPPORT ENCODING: " + str);
        }
    }
}
