package p031c.p035b.p043c.p053d0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import p031c.p035b.p043c.AbstractC1106q;
import p031c.p035b.p043c.C1102m;
import p031c.p035b.p043c.C1107r;
import p031c.p035b.p043c.EnumC0953a;
import p031c.p035b.p043c.EnumC1044e;
import p031c.p035b.p043c.p053d0.p054a0.C0994e;
import p031c.p035b.p043c.p053d0.p054a0.p055g.C0999d;
import p031c.p035b.p043c.p072z.C1162a;

/* compiled from: MultiFormatOneDReader.java */
/* renamed from: c.b.c.d0.o */
/* loaded from: classes.dex */
public final class C1032o extends AbstractC1034q {

    /* renamed from: a */
    private final AbstractC1034q[] f1938a;

    public C1032o(Map<EnumC1044e, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(EnumC1044e.POSSIBLE_FORMATS);
        boolean z = (map == null || map.get(EnumC1044e.ASSUME_CODE_39_CHECK_DIGIT) == null) ? false : true;
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(EnumC0953a.EAN_13) || collection.contains(EnumC0953a.UPC_A) || collection.contains(EnumC0953a.EAN_8) || collection.contains(EnumC0953a.UPC_E)) {
                arrayList.add(new C1033p(map));
            }
            if (collection.contains(EnumC0953a.CODE_39)) {
                arrayList.add(new C1022e(z));
            }
            if (collection.contains(EnumC0953a.CODE_93)) {
                arrayList.add(new C1024g());
            }
            if (collection.contains(EnumC0953a.CODE_128)) {
                arrayList.add(new C1020c());
            }
            if (collection.contains(EnumC0953a.ITF)) {
                arrayList.add(new C1030m());
            }
            if (collection.contains(EnumC0953a.CODABAR)) {
                arrayList.add(new C0989a());
            }
            if (collection.contains(EnumC0953a.RSS_14)) {
                arrayList.add(new C0994e());
            }
            if (collection.contains(EnumC0953a.RSS_EXPANDED)) {
                arrayList.add(new C0999d());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new C1033p(map));
            arrayList.add(new C1022e());
            arrayList.add(new C0989a());
            arrayList.add(new C1024g());
            arrayList.add(new C1020c());
            arrayList.add(new C1030m());
            arrayList.add(new C0994e());
            arrayList.add(new C0999d());
        }
        this.f1938a = (AbstractC1034q[]) arrayList.toArray(new AbstractC1034q[arrayList.size()]);
    }

    @Override // p031c.p035b.p043c.p053d0.AbstractC1034q
    /* renamed from: a */
    public C1107r mo1365a(int i2, C1162a c1162a, Map<EnumC1044e, ?> map) throws C1102m {
        for (AbstractC1034q abstractC1034q : this.f1938a) {
            try {
                return abstractC1034q.mo1365a(i2, c1162a, map);
            } catch (AbstractC1106q unused) {
            }
        }
        throw C1102m.getNotFoundInstance();
    }

    @Override // p031c.p035b.p043c.p053d0.AbstractC1034q, p031c.p035b.p043c.InterfaceC1105p
    public void reset() {
        for (AbstractC1034q abstractC1034q : this.f1938a) {
            abstractC1034q.reset();
        }
    }
}
