package c.b.c.c0.d;

import c.b.c.c0.c;
import c.b.c.e;
import c.b.c.f0.c.i;
import c.b.c.m;
import c.b.c.q;
import c.b.c.r;
import c.b.c.s;
import c.b.c.t;
import c.b.c.z.g;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: QRCodeMultiReader.java */
/* loaded from: classes.dex */
public final class a extends c.b.c.f0.a implements c {

    /* renamed from: c, reason: collision with root package name */
    private static final r[] f2438c = new r[0];

    /* renamed from: d, reason: collision with root package name */
    private static final t[] f2439d = new t[0];

    /* compiled from: QRCodeMultiReader.java */
    private static final class b implements Comparator<r>, Serializable {
        private b() {
        }

        @Override // java.util.Comparator
        public int compare(r rVar, r rVar2) {
            int intValue = ((Integer) rVar.c().get(s.STRUCTURED_APPEND_SEQUENCE)).intValue();
            int intValue2 = ((Integer) rVar2.c().get(s.STRUCTURED_APPEND_SEQUENCE)).intValue();
            if (intValue < intValue2) {
                return -1;
            }
            return intValue > intValue2 ? 1 : 0;
        }
    }

    private static List<r> a(List<r> list) {
        boolean z;
        Iterator<r> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (it.next().c().containsKey(s.STRUCTURED_APPEND_SEQUENCE)) {
                z = true;
                break;
            }
        }
        if (!z) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<r> arrayList2 = new ArrayList();
        for (r rVar : list) {
            arrayList.add(rVar);
            if (rVar.c().containsKey(s.STRUCTURED_APPEND_SEQUENCE)) {
                arrayList2.add(rVar);
            }
        }
        Collections.sort(arrayList2, new b());
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        int i3 = 0;
        for (r rVar2 : arrayList2) {
            sb.append(rVar2.e());
            i2 += rVar2.b().length;
            if (rVar2.c().containsKey(s.BYTE_SEGMENTS)) {
                Iterator it2 = ((Iterable) rVar2.c().get(s.BYTE_SEGMENTS)).iterator();
                while (it2.hasNext()) {
                    i3 += ((byte[]) it2.next()).length;
                }
            }
        }
        byte[] bArr = new byte[i2];
        byte[] bArr2 = new byte[i3];
        int i4 = 0;
        int i5 = 0;
        for (r rVar3 : arrayList2) {
            System.arraycopy(rVar3.b(), 0, bArr, i4, rVar3.b().length);
            i4 += rVar3.b().length;
            if (rVar3.c().containsKey(s.BYTE_SEGMENTS)) {
                for (byte[] bArr3 : (Iterable) rVar3.c().get(s.BYTE_SEGMENTS)) {
                    System.arraycopy(bArr3, 0, bArr2, i5, bArr3.length);
                    i5 += bArr3.length;
                }
            }
        }
        r rVar4 = new r(sb.toString(), bArr, f2439d, c.b.c.a.QR_CODE);
        if (i3 > 0) {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(bArr2);
            rVar4.a(s.BYTE_SEGMENTS, arrayList3);
        }
        arrayList.add(rVar4);
        return arrayList;
    }

    @Override // c.b.c.c0.c
    public r[] b(c.b.c.c cVar) throws m {
        return b(cVar, null);
    }

    @Override // c.b.c.c0.c
    public r[] b(c.b.c.c cVar, Map<e, ?> map) throws m {
        ArrayList arrayList = new ArrayList();
        for (g gVar : new c.b.c.c0.d.b.a(cVar.a()).b(map)) {
            try {
                c.b.c.z.e a2 = a().a(gVar.a(), map);
                t[] b2 = gVar.b();
                if (a2.e() instanceof i) {
                    ((i) a2.e()).a(b2);
                }
                r rVar = new r(a2.i(), a2.f(), b2, c.b.c.a.QR_CODE);
                List<byte[]> a3 = a2.a();
                if (a3 != null) {
                    rVar.a(s.BYTE_SEGMENTS, a3);
                }
                String b3 = a2.b();
                if (b3 != null) {
                    rVar.a(s.ERROR_CORRECTION_LEVEL, b3);
                }
                if (a2.j()) {
                    rVar.a(s.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(a2.h()));
                    rVar.a(s.STRUCTURED_APPEND_PARITY, Integer.valueOf(a2.g()));
                }
                arrayList.add(rVar);
            } catch (q unused) {
            }
        }
        if (arrayList.isEmpty()) {
            return f2438c;
        }
        List<r> a4 = a(arrayList);
        return (r[]) a4.toArray(new r[a4.size()]);
    }
}
