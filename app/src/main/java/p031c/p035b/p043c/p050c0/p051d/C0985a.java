package p031c.p035b.p043c.p050c0.p051d;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p031c.p035b.p043c.AbstractC1106q;
import p031c.p035b.p043c.C0981c;
import p031c.p035b.p043c.C1102m;
import p031c.p035b.p043c.C1107r;
import p031c.p035b.p043c.C1109t;
import p031c.p035b.p043c.EnumC0953a;
import p031c.p035b.p043c.EnumC1044e;
import p031c.p035b.p043c.EnumC1108s;
import p031c.p035b.p043c.p050c0.InterfaceC0984c;
import p031c.p035b.p043c.p050c0.p051d.p052b.C0986a;
import p031c.p035b.p043c.p062f0.C1072a;
import p031c.p035b.p043c.p062f0.p063c.C1082i;
import p031c.p035b.p043c.p072z.C1166e;
import p031c.p035b.p043c.p072z.C1168g;

/* compiled from: QRCodeMultiReader.java */
/* renamed from: c.b.c.c0.d.a */
/* loaded from: classes.dex */
public final class C0985a extends C1072a implements InterfaceC0984c {

    /* renamed from: c */
    private static final C1107r[] f1765c = new C1107r[0];

    /* renamed from: d */
    private static final C1109t[] f1766d = new C1109t[0];

    /* compiled from: QRCodeMultiReader.java */
    /* renamed from: c.b.c.c0.d.a$b */
    private static final class b implements Comparator<C1107r>, Serializable {
        private b() {
        }

        @Override // java.util.Comparator
        public int compare(C1107r c1107r, C1107r c1107r2) {
            int intValue = ((Integer) c1107r.m1915c().get(EnumC1108s.STRUCTURED_APPEND_SEQUENCE)).intValue();
            int intValue2 = ((Integer) c1107r2.m1915c().get(EnumC1108s.STRUCTURED_APPEND_SEQUENCE)).intValue();
            if (intValue < intValue2) {
                return -1;
            }
            return intValue > intValue2 ? 1 : 0;
        }
    }

    /* renamed from: a */
    private static List<C1107r> m1356a(List<C1107r> list) {
        boolean z;
        Iterator<C1107r> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (it.next().m1915c().containsKey(EnumC1108s.STRUCTURED_APPEND_SEQUENCE)) {
                z = true;
                break;
            }
        }
        if (!z) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<C1107r> arrayList2 = new ArrayList();
        for (C1107r c1107r : list) {
            arrayList.add(c1107r);
            if (c1107r.m1915c().containsKey(EnumC1108s.STRUCTURED_APPEND_SEQUENCE)) {
                arrayList2.add(c1107r);
            }
        }
        Collections.sort(arrayList2, new b());
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        int i3 = 0;
        for (C1107r c1107r2 : arrayList2) {
            sb.append(c1107r2.m1917e());
            i2 += c1107r2.m1914b().length;
            if (c1107r2.m1915c().containsKey(EnumC1108s.BYTE_SEGMENTS)) {
                Iterator it2 = ((Iterable) c1107r2.m1915c().get(EnumC1108s.BYTE_SEGMENTS)).iterator();
                while (it2.hasNext()) {
                    i3 += ((byte[]) it2.next()).length;
                }
            }
        }
        byte[] bArr = new byte[i2];
        byte[] bArr2 = new byte[i3];
        int i4 = 0;
        int i5 = 0;
        for (C1107r c1107r3 : arrayList2) {
            System.arraycopy(c1107r3.m1914b(), 0, bArr, i4, c1107r3.m1914b().length);
            i4 += c1107r3.m1914b().length;
            if (c1107r3.m1915c().containsKey(EnumC1108s.BYTE_SEGMENTS)) {
                for (byte[] bArr3 : (Iterable) c1107r3.m1915c().get(EnumC1108s.BYTE_SEGMENTS)) {
                    System.arraycopy(bArr3, 0, bArr2, i5, bArr3.length);
                    i5 += bArr3.length;
                }
            }
        }
        C1107r c1107r4 = new C1107r(sb.toString(), bArr, f1766d, EnumC0953a.QR_CODE);
        if (i3 > 0) {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(bArr2);
            c1107r4.m1911a(EnumC1108s.BYTE_SEGMENTS, arrayList3);
        }
        arrayList.add(c1107r4);
        return arrayList;
    }

    @Override // p031c.p035b.p043c.p050c0.InterfaceC0984c
    /* renamed from: b */
    public C1107r[] mo1354b(C0981c c0981c) throws C1102m {
        return mo1355b(c0981c, null);
    }

    @Override // p031c.p035b.p043c.p050c0.InterfaceC0984c
    /* renamed from: b */
    public C1107r[] mo1355b(C0981c c0981c, Map<EnumC1044e, ?> map) throws C1102m {
        ArrayList arrayList = new ArrayList();
        for (C1168g c1168g : new C0986a(c0981c.m1344a()).m1357b(map)) {
            try {
                C1166e m1758a = m1732a().m1758a(c1168g.m2202a(), map);
                C1109t[] m2203b = c1168g.m2203b();
                if (m1758a.m2194e() instanceof C1082i) {
                    ((C1082i) m1758a.m2194e()).m1766a(m2203b);
                }
                C1107r c1107r = new C1107r(m1758a.m2198i(), m1758a.m2195f(), m2203b, EnumC0953a.QR_CODE);
                List<byte[]> m2187a = m1758a.m2187a();
                if (m2187a != null) {
                    c1107r.m1911a(EnumC1108s.BYTE_SEGMENTS, m2187a);
                }
                String m2190b = m1758a.m2190b();
                if (m2190b != null) {
                    c1107r.m1911a(EnumC1108s.ERROR_CORRECTION_LEVEL, m2190b);
                }
                if (m1758a.m2199j()) {
                    c1107r.m1911a(EnumC1108s.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(m1758a.m2197h()));
                    c1107r.m1911a(EnumC1108s.STRUCTURED_APPEND_PARITY, Integer.valueOf(m1758a.m2196g()));
                }
                arrayList.add(c1107r);
            } catch (AbstractC1106q unused) {
            }
        }
        if (arrayList.isEmpty()) {
            return f1765c;
        }
        List<C1107r> m1356a = m1356a(arrayList);
        return (C1107r[]) m1356a.toArray(new C1107r[m1356a.size()]);
    }
}
