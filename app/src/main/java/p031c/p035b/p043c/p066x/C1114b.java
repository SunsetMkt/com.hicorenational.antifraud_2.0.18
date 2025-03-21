package p031c.p035b.p043c.p066x;

import p031c.p035b.p043c.C0981c;
import p031c.p035b.p043c.C1097h;
import p031c.p035b.p043c.C1102m;
import p031c.p035b.p043c.C1107r;
import p031c.p035b.p043c.InterfaceC1105p;

/* compiled from: AztecReader.java */
/* renamed from: c.b.c.x.b */
/* loaded from: classes.dex */
public final class C1114b implements InterfaceC1105p {
    @Override // p031c.p035b.p043c.InterfaceC1105p
    /* renamed from: a */
    public C1107r mo1185a(C0981c c0981c) throws C1102m, C1097h {
        return mo1186a(c0981c, null);
    }

    @Override // p031c.p035b.p043c.InterfaceC1105p
    public void reset() {
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005d A[LOOP:0: B:24:0x005b->B:25:0x005d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0031  */
    @Override // p031c.p035b.p043c.InterfaceC1105p
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public p031c.p035b.p043c.C1107r mo1186a(p031c.p035b.p043c.C0981c r6, java.util.Map<p031c.p035b.p043c.EnumC1044e, ?> r7) throws p031c.p035b.p043c.C1102m, p031c.p035b.p043c.C1097h {
        /*
            r5 = this;
            c.b.c.x.e.a r0 = new c.b.c.x.e.a
            c.b.c.z.b r6 = r6.m1344a()
            r0.<init>(r6)
            r6 = 0
            r1 = 0
            c.b.c.x.a r2 = r0.m1957a(r6)     // Catch: p031c.p035b.p043c.C1097h -> L25 p031c.p035b.p043c.C1102m -> L2b
            c.b.c.t[] r3 = r2.m2203b()     // Catch: p031c.p035b.p043c.C1097h -> L25 p031c.p035b.p043c.C1102m -> L2b
            c.b.c.x.d.a r4 = new c.b.c.x.d.a     // Catch: p031c.p035b.p043c.C1097h -> L21 p031c.p035b.p043c.C1102m -> L23
            r4.<init>()     // Catch: p031c.p035b.p043c.C1097h -> L21 p031c.p035b.p043c.C1102m -> L23
            c.b.c.z.e r2 = r4.m1937a(r2)     // Catch: p031c.p035b.p043c.C1097h -> L21 p031c.p035b.p043c.C1102m -> L23
            r4 = r3
            r3 = r1
            r1 = r2
            r2 = r3
            goto L2f
        L21:
            r2 = move-exception
            goto L27
        L23:
            r2 = move-exception
            goto L2d
        L25:
            r2 = move-exception
            r3 = r1
        L27:
            r4 = r3
            r3 = r2
            r2 = r1
            goto L2f
        L2b:
            r2 = move-exception
            r3 = r1
        L2d:
            r4 = r3
            r3 = r1
        L2f:
            if (r1 != 0) goto L4e
            r1 = 1
            c.b.c.x.a r0 = r0.m1957a(r1)     // Catch: p031c.p035b.p043c.C1097h -> L44 p031c.p035b.p043c.C1102m -> L46
            c.b.c.t[] r4 = r0.m2203b()     // Catch: p031c.p035b.p043c.C1097h -> L44 p031c.p035b.p043c.C1102m -> L46
            c.b.c.x.d.a r1 = new c.b.c.x.d.a     // Catch: p031c.p035b.p043c.C1097h -> L44 p031c.p035b.p043c.C1102m -> L46
            r1.<init>()     // Catch: p031c.p035b.p043c.C1097h -> L44 p031c.p035b.p043c.C1102m -> L46
            c.b.c.z.e r1 = r1.m1937a(r0)     // Catch: p031c.p035b.p043c.C1097h -> L44 p031c.p035b.p043c.C1102m -> L46
            goto L4e
        L44:
            r6 = move-exception
            goto L47
        L46:
            r6 = move-exception
        L47:
            if (r2 != 0) goto L4d
            if (r3 == 0) goto L4c
            throw r3
        L4c:
            throw r6
        L4d:
            throw r2
        L4e:
            if (r7 == 0) goto L65
            c.b.c.e r0 = p031c.p035b.p043c.EnumC1044e.NEED_RESULT_POINT_CALLBACK
            java.lang.Object r7 = r7.get(r0)
            c.b.c.u r7 = (p031c.p035b.p043c.InterfaceC1110u) r7
            if (r7 == 0) goto L65
            int r0 = r4.length
        L5b:
            if (r6 >= r0) goto L65
            r2 = r4[r6]
            r7.mo1924a(r2)
            int r6 = r6 + 1
            goto L5b
        L65:
            c.b.c.r r6 = new c.b.c.r
            java.lang.String r7 = r1.m2198i()
            byte[] r0 = r1.m2195f()
            c.b.c.a r2 = p031c.p035b.p043c.EnumC0953a.AZTEC
            r6.<init>(r7, r0, r4, r2)
            java.util.List r7 = r1.m2187a()
            if (r7 == 0) goto L7f
            c.b.c.s r0 = p031c.p035b.p043c.EnumC1108s.BYTE_SEGMENTS
            r6.m1911a(r0, r7)
        L7f:
            java.lang.String r7 = r1.m2190b()
            if (r7 == 0) goto L8a
            c.b.c.s r0 = p031c.p035b.p043c.EnumC1108s.ERROR_CORRECTION_LEVEL
            r6.m1911a(r0, r7)
        L8a:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p031c.p035b.p043c.p066x.C1114b.mo1186a(c.b.c.c, java.util.Map):c.b.c.r");
    }
}
