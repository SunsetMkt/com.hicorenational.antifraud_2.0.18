package com.xiaomi.push;

/* loaded from: classes2.dex */
public class id {

    /* renamed from: a, reason: collision with root package name */
    private static int f13236a = Integer.MAX_VALUE;

    public static void a(ia iaVar, byte b2) {
        a(iaVar, b2, f13236a);
    }

    public static void a(ia iaVar, byte b2, int i2) {
        if (i2 <= 0) {
            throw new hu("Maximum skip depth exceeded");
        }
        int i3 = 0;
        switch (b2) {
            case 2:
                iaVar.mo613a();
                return;
            case 3:
                iaVar.a();
                return;
            case 4:
                iaVar.mo600a();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                iaVar.mo610a();
                return;
            case 8:
                iaVar.mo601a();
                return;
            case 10:
                iaVar.mo602a();
                return;
            case 11:
                iaVar.mo609a();
                return;
            case 12:
                iaVar.mo607a();
                while (true) {
                    byte b3 = iaVar.mo603a().f13224a;
                    if (b3 == 0) {
                        iaVar.f();
                        return;
                    } else {
                        a(iaVar, b3, i2 - 1);
                        iaVar.g();
                    }
                }
            case 13:
                hz mo605a = iaVar.mo605a();
                while (i3 < mo605a.f900a) {
                    int i4 = i2 - 1;
                    a(iaVar, mo605a.f13226a, i4);
                    a(iaVar, mo605a.f13227b, i4);
                    i3++;
                }
                iaVar.h();
                return;
            case 14:
                ie mo606a = iaVar.mo606a();
                while (i3 < mo606a.f904a) {
                    a(iaVar, mo606a.f13237a, i2 - 1);
                    i3++;
                }
                iaVar.j();
                return;
            case 15:
                hy mo604a = iaVar.mo604a();
                while (i3 < mo604a.f899a) {
                    a(iaVar, mo604a.f13225a, i2 - 1);
                    i3++;
                }
                iaVar.i();
                return;
        }
    }
}
