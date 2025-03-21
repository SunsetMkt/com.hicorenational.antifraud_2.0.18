package p031c.p035b.p043c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import p031c.p035b.p043c.p044a0.C0954a;
import p031c.p035b.p043c.p048b0.C0977a;
import p031c.p035b.p043c.p053d0.C1032o;
import p031c.p035b.p043c.p057e0.C1046b;
import p031c.p035b.p043c.p062f0.C1072a;
import p031c.p035b.p043c.p066x.C1114b;

/* compiled from: MultiFormatReader.java */
/* renamed from: c.b.c.k */
/* loaded from: classes.dex */
public final class C1100k implements InterfaceC1105p {

    /* renamed from: a */
    private Map<EnumC1044e, ?> f2201a;

    /* renamed from: b */
    private InterfaceC1105p[] f2202b;

    /* renamed from: c */
    private C1107r m1903c(C0981c c0981c) throws C1102m {
        InterfaceC1105p[] interfaceC1105pArr = this.f2202b;
        if (interfaceC1105pArr != null) {
            for (InterfaceC1105p interfaceC1105p : interfaceC1105pArr) {
                try {
                    return interfaceC1105p.mo1186a(c0981c, this.f2201a);
                } catch (AbstractC1106q unused) {
                }
            }
        }
        throw C1102m.getNotFoundInstance();
    }

    @Override // p031c.p035b.p043c.InterfaceC1105p
    /* renamed from: a */
    public C1107r mo1185a(C0981c c0981c) throws C1102m {
        m1904a((Map<EnumC1044e, ?>) null);
        return m1903c(c0981c);
    }

    /* renamed from: b */
    public C1107r m1905b(C0981c c0981c) throws C1102m {
        if (this.f2202b == null) {
            m1904a((Map<EnumC1044e, ?>) null);
        }
        return m1903c(c0981c);
    }

    @Override // p031c.p035b.p043c.InterfaceC1105p
    public void reset() {
        InterfaceC1105p[] interfaceC1105pArr = this.f2202b;
        if (interfaceC1105pArr != null) {
            for (InterfaceC1105p interfaceC1105p : interfaceC1105pArr) {
                interfaceC1105p.reset();
            }
        }
    }

    @Override // p031c.p035b.p043c.InterfaceC1105p
    /* renamed from: a */
    public C1107r mo1186a(C0981c c0981c, Map<EnumC1044e, ?> map) throws C1102m {
        m1904a(map);
        return m1903c(c0981c);
    }

    /* renamed from: a */
    public void m1904a(Map<EnumC1044e, ?> map) {
        this.f2201a = map;
        boolean z = true;
        boolean z2 = map != null && map.containsKey(EnumC1044e.TRY_HARDER);
        Collection collection = map == null ? null : (Collection) map.get(EnumC1044e.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (!collection.contains(EnumC0953a.UPC_A) && !collection.contains(EnumC0953a.UPC_E) && !collection.contains(EnumC0953a.EAN_13) && !collection.contains(EnumC0953a.EAN_8) && !collection.contains(EnumC0953a.CODABAR) && !collection.contains(EnumC0953a.CODE_39) && !collection.contains(EnumC0953a.CODE_93) && !collection.contains(EnumC0953a.CODE_128) && !collection.contains(EnumC0953a.ITF) && !collection.contains(EnumC0953a.RSS_14) && !collection.contains(EnumC0953a.RSS_EXPANDED)) {
                z = false;
            }
            if (z && !z2) {
                arrayList.add(new C1032o(map));
            }
            if (collection.contains(EnumC0953a.QR_CODE)) {
                arrayList.add(new C1072a());
            }
            if (collection.contains(EnumC0953a.DATA_MATRIX)) {
                arrayList.add(new C0954a());
            }
            if (collection.contains(EnumC0953a.AZTEC)) {
                arrayList.add(new C1114b());
            }
            if (collection.contains(EnumC0953a.PDF_417)) {
                arrayList.add(new C1046b());
            }
            if (collection.contains(EnumC0953a.MAXICODE)) {
                arrayList.add(new C0977a());
            }
            if (z && z2) {
                arrayList.add(new C1032o(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (!z2) {
                arrayList.add(new C1032o(map));
            }
            arrayList.add(new C1072a());
            arrayList.add(new C0954a());
            arrayList.add(new C1114b());
            arrayList.add(new C1046b());
            arrayList.add(new C0977a());
            if (z2) {
                arrayList.add(new C1032o(map));
            }
        }
        this.f2202b = (InterfaceC1105p[]) arrayList.toArray(new InterfaceC1105p[arrayList.size()]);
    }
}
