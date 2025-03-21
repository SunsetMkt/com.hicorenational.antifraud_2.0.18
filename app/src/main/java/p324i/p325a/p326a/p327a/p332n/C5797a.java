package p324i.p325a.p326a.p327a.p332n;

import java.io.UnsupportedEncodingException;
import p324i.p325a.p326a.p327a.C5760e;
import p324i.p325a.p326a.p327a.C5762g;
import p324i.p325a.p326a.p327a.InterfaceC5763h;
import p324i.p325a.p326a.p327a.InterfaceC5764i;
import p324i.p325a.p326a.p327a.p328k.C5769d;

/* compiled from: BCodec.java */
/* renamed from: i.a.a.a.n.a */
/* loaded from: classes2.dex */
public class C5797a extends AbstractC5800d implements InterfaceC5764i, InterfaceC5763h {

    /* renamed from: d */
    private final String f20919d;

    public C5797a() {
        this("UTF-8");
    }

    @Override // p324i.p325a.p326a.p327a.p332n.AbstractC5800d
    /* renamed from: a */
    protected String mo24416a() {
        return "B";
    }

    @Override // p324i.p325a.p326a.p327a.p332n.AbstractC5800d
    /* renamed from: a */
    protected byte[] mo24417a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return C5769d.m24164e(bArr);
    }

    @Override // p324i.p325a.p326a.p327a.p332n.AbstractC5800d
    /* renamed from: b */
    protected byte[] mo24420b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return C5769d.m24166g(bArr);
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5763h
    public String decode(String str) throws C5760e {
        if (str == null) {
            return null;
        }
        try {
            return m24432b(str);
        } catch (UnsupportedEncodingException e2) {
            throw new C5760e(e2.getMessage(), e2);
        }
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5761f
    public Object encode(Object obj) throws C5762g {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return mo24152a((String) obj);
        }
        throw new C5762g("Objects of type " + obj.getClass().getName() + " cannot be encoded using BCodec");
    }

    public C5797a(String str) {
        this.f20919d = str;
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5764i
    /* renamed from: a */
    public String mo24152a(String str) throws C5762g {
        if (str == null) {
            return null;
        }
        return m24419b(str, m24418b());
    }

    /* renamed from: b */
    public String m24419b(String str, String str2) throws C5762g {
        if (str == null) {
            return null;
        }
        try {
            return m24431a(str, str2);
        } catch (UnsupportedEncodingException e2) {
            throw new C5762g(e2.getMessage(), e2);
        }
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5759d
    public Object decode(Object obj) throws C5760e {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return decode((String) obj);
        }
        throw new C5760e("Objects of type " + obj.getClass().getName() + " cannot be decoded using BCodec");
    }

    /* renamed from: b */
    public String m24418b() {
        return this.f20919d;
    }
}
