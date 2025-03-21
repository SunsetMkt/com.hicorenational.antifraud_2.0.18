package p324i.p325a.p326a.p327a.p330m;

import p324i.p325a.p326a.p327a.C5762g;
import p324i.p325a.p326a.p327a.InterfaceC5764i;

/* compiled from: Caverphone.java */
/* renamed from: i.a.a.a.m.d */
/* loaded from: classes2.dex */
public class C5782d implements InterfaceC5764i {

    /* renamed from: a */
    private final C5781c f20827a = new C5781c();

    @Override // p324i.p325a.p326a.p327a.InterfaceC5764i
    /* renamed from: a */
    public String mo24152a(String str) {
        return m24259b(str);
    }

    /* renamed from: b */
    public String m24259b(String str) {
        return this.f20827a.mo24152a(str);
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5761f
    public Object encode(Object obj) throws C5762g {
        if (obj instanceof String) {
            return m24259b((String) obj);
        }
        throw new C5762g("Parameter supplied to Caverphone encode is not of type java.lang.String");
    }

    /* renamed from: a */
    public boolean m24258a(String str, String str2) {
        return m24259b(str).equals(m24259b(str2));
    }
}
