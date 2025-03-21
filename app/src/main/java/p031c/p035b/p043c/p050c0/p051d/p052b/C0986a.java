package p031c.p035b.p043c.p050c0.p051d.p052b;

import java.util.ArrayList;
import java.util.Map;
import p031c.p035b.p043c.AbstractC1106q;
import p031c.p035b.p043c.C1102m;
import p031c.p035b.p043c.EnumC1044e;
import p031c.p035b.p043c.InterfaceC1110u;
import p031c.p035b.p043c.p062f0.p064d.C1086c;
import p031c.p035b.p043c.p062f0.p064d.C1089f;
import p031c.p035b.p043c.p072z.C1163b;
import p031c.p035b.p043c.p072z.C1168g;

/* compiled from: MultiDetector.java */
/* renamed from: c.b.c.c0.d.b.a */
/* loaded from: classes.dex */
public final class C0986a extends C1086c {

    /* renamed from: c */
    private static final C1168g[] f1767c = new C1168g[0];

    public C0986a(C1163b c1163b) {
        super(c1163b);
    }

    /* renamed from: b */
    public C1168g[] m1357b(Map<EnumC1044e, ?> map) throws C1102m {
        C1089f[] m1359b = new C0987b(m1802b(), map == null ? null : (InterfaceC1110u) map.get(EnumC1044e.NEED_RESULT_POINT_CALLBACK)).m1359b(map);
        if (m1359b.length == 0) {
            throw C1102m.getNotFoundInstance();
        }
        ArrayList arrayList = new ArrayList();
        for (C1089f c1089f : m1359b) {
            try {
                arrayList.add(m1800a(c1089f));
            } catch (AbstractC1106q unused) {
            }
        }
        return arrayList.isEmpty() ? f1767c : (C1168g[]) arrayList.toArray(new C1168g[arrayList.size()]);
    }
}
