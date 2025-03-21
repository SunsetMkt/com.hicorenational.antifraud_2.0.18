package p324i.p325a.p326a.p327a.p330m.p331k;

import p324i.p325a.p326a.p327a.C5762g;
import p324i.p325a.p326a.p327a.InterfaceC5764i;

/* compiled from: BeiderMorseEncoder.java */
/* renamed from: i.a.a.a.m.k.a */
/* loaded from: classes2.dex */
public class C5789a implements InterfaceC5764i {

    /* renamed from: a */
    private C5793e f20857a = new C5793e(EnumC5792d.GENERIC, EnumC5796h.APPROX, true);

    @Override // p324i.p325a.p326a.p327a.InterfaceC5764i
    /* renamed from: a */
    public String mo24152a(String str) throws C5762g {
        if (str == null) {
            return null;
        }
        return this.f20857a.m24373a(str);
    }

    /* renamed from: b */
    public EnumC5796h m24349b() {
        return this.f20857a.m24376c();
    }

    /* renamed from: c */
    public boolean m24350c() {
        return this.f20857a.m24377d();
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5761f
    public Object encode(Object obj) throws C5762g {
        if (obj instanceof String) {
            return mo24152a((String) obj);
        }
        throw new C5762g("BeiderMorseEncoder encode parameter is not of type String");
    }

    /* renamed from: a */
    public EnumC5792d m24345a() {
        return this.f20857a.m24375b();
    }

    /* renamed from: a */
    public void m24348a(boolean z) {
        this.f20857a = new C5793e(this.f20857a.m24375b(), this.f20857a.m24376c(), z);
    }

    /* renamed from: a */
    public void m24346a(EnumC5792d enumC5792d) {
        this.f20857a = new C5793e(enumC5792d, this.f20857a.m24376c(), this.f20857a.m24377d());
    }

    /* renamed from: a */
    public void m24347a(EnumC5796h enumC5796h) {
        this.f20857a = new C5793e(this.f20857a.m24375b(), enumC5796h, this.f20857a.m24377d());
    }
}
