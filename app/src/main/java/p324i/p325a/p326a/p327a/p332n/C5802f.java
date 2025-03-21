package p324i.p325a.p326a.p327a.p332n;

import p324i.p325a.p326a.p327a.C5760e;

/* compiled from: Utils.java */
/* renamed from: i.a.a.a.n.f */
/* loaded from: classes2.dex */
class C5802f {
    C5802f() {
    }

    /* renamed from: a */
    static int m24439a(byte b2) throws C5760e {
        int digit = Character.digit((char) b2, 16);
        if (digit != -1) {
            return digit;
        }
        throw new C5760e("Invalid URL encoding: not a valid digit (radix 16): " + ((int) b2));
    }
}
