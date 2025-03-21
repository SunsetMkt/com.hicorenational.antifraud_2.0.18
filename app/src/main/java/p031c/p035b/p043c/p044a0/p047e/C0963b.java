package p031c.p035b.p043c.p044a0.p047e;

import androidx.core.view.InputDeviceCompat;

/* compiled from: Base256Encoder.java */
/* renamed from: c.b.c.a0.e.b */
/* loaded from: classes.dex */
final class C0963b implements InterfaceC0968g {
    C0963b() {
    }

    @Override // p031c.p035b.p043c.p044a0.p047e.InterfaceC0968g
    /* renamed from: a */
    public int mo1241a() {
        return 5;
    }

    @Override // p031c.p035b.p043c.p044a0.p047e.InterfaceC0968g
    /* renamed from: a */
    public void mo1242a(C0969h c0969h) {
        StringBuilder sb = new StringBuilder();
        sb.append((char) 0);
        while (true) {
            if (!c0969h.m1283i()) {
                break;
            }
            sb.append(c0969h.m1278d());
            c0969h.f1689f++;
            int m1292a = C0971j.m1292a(c0969h.m1279e(), c0969h.f1689f, mo1241a());
            if (m1292a != mo1241a()) {
                c0969h.m1275b(m1292a);
                break;
            }
        }
        int length = sb.length() - 1;
        int m1268a = c0969h.m1268a() + length + 1;
        c0969h.m1277c(m1268a);
        boolean z = c0969h.m1282h().m1313b() - m1268a > 0;
        if (c0969h.m1283i() || z) {
            if (length <= 249) {
                sb.setCharAt(0, (char) length);
            } else {
                if (length <= 249 || length > 1555) {
                    throw new IllegalStateException("Message length not in valid ranges: " + length);
                }
                sb.setCharAt(0, (char) ((length / 250) + 249));
                sb.insert(1, (char) (length % 250));
            }
        }
        int length2 = sb.length();
        for (int i2 = 0; i2 < length2; i2++) {
            c0969h.m1269a(m1243a(sb.charAt(i2), c0969h.m1268a() + 1));
        }
    }

    /* renamed from: a */
    private static char m1243a(char c2, int i2) {
        int i3 = c2 + ((i2 * 149) % 255) + 1;
        return i3 <= 255 ? (char) i3 : (char) (i3 + InputDeviceCompat.SOURCE_ANY);
    }
}
