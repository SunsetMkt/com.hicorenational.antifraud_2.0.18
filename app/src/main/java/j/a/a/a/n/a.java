package j.a.a.a.n;

import j.a.a.a.g;
import j.a.a.a.h;
import j.a.a.a.i;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: BCodec.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends d implements i, h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f12536d;

    public a() {
        this("UTF-8");
    }

    @Override // j.a.a.a.n.d
    protected String a() {
        return "B";
    }

    @Override // j.a.a.a.n.d
    protected byte[] a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return j.a.a.a.k.d.e(bArr);
    }

    @Override // j.a.a.a.n.d
    protected byte[] b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return j.a.a.a.k.d.g(bArr);
    }

    @Override // j.a.a.a.h
    public String decode(String str) throws j.a.a.a.e {
        if (str == null) {
            return null;
        }
        try {
            return b(str);
        } catch (UnsupportedEncodingException e2) {
            throw new j.a.a.a.e(e2.getMessage(), e2);
        }
    }

    @Override // j.a.a.a.f
    public Object encode(Object obj) throws g {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return a((String) obj);
        }
        throw new g("Objects of type " + obj.getClass().getName() + " cannot be encoded using BCodec");
    }

    public a(String str) {
        this.f12536d = str;
    }

    @Override // j.a.a.a.i
    public String a(String str) throws g {
        if (str == null) {
            return null;
        }
        return b(str, b());
    }

    public String b(String str, String str2) throws g {
        if (str == null) {
            return null;
        }
        try {
            return a(str, str2);
        } catch (UnsupportedEncodingException e2) {
            throw new g(e2.getMessage(), e2);
        }
    }

    @Override // j.a.a.a.d
    public Object decode(Object obj) throws j.a.a.a.e {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return decode((String) obj);
        }
        throw new j.a.a.a.e("Objects of type " + obj.getClass().getName() + " cannot be decoded using BCodec");
    }

    public String b() {
        return this.f12536d;
    }
}
