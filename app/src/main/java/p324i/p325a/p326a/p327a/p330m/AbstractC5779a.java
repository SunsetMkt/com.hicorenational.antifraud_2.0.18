package p324i.p325a.p326a.p327a.p330m;

import p324i.p325a.p326a.p327a.C5762g;
import p324i.p325a.p326a.p327a.InterfaceC5764i;

/* compiled from: AbstractCaverphone.java */
/* renamed from: i.a.a.a.m.a */
/* loaded from: classes2.dex */
public abstract class AbstractC5779a implements InterfaceC5764i {
    /* renamed from: a */
    public boolean m24257a(String str, String str2) throws C5762g {
        return mo24152a(str).equals(mo24152a(str2));
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5761f
    public Object encode(Object obj) throws C5762g {
        if (obj instanceof String) {
            return mo24152a((String) obj);
        }
        throw new C5762g("Parameter supplied to Caverphone encode is not of type java.lang.String");
    }
}
