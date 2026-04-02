package com.xiaomi.push;

/* JADX INFO: loaded from: classes2.dex */
public class id {
    private static int a = Integer.MAX_VALUE;

    public static void a(ia iaVar, byte b2) {
        a(iaVar, b2, a);
    }

    public static void a(ia iaVar, byte b2, int i2) throws hu {
        if (i2 <= 0) {
            throw new hu("Maximum skip depth exceeded");
        }
        int i3 = 0;
        switch (b2) {
            case 2:
                iaVar.mo611a();
                return;
            case 3:
                iaVar.a();
                return;
            case 4:
                iaVar.mo598a();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                iaVar.mo608a();
                return;
            case 8:
                iaVar.mo599a();
                return;
            case 10:
                iaVar.mo600a();
                return;
            case 11:
                iaVar.mo607a();
                return;
            case 12:
                iaVar.mo605a();
                while (true) {
                    byte b3 = iaVar.mo601a().a;
                    if (b3 == 0) {
                        iaVar.f();
                        return;
                    } else {
                        a(iaVar, b3, i2 - 1);
                        iaVar.g();
                    }
                }
                break;
            case 13:
                hz hzVarMo603a = iaVar.mo603a();
                while (i3 < hzVarMo603a.f900a) {
                    int i4 = i2 - 1;
                    a(iaVar, hzVarMo603a.a, i4);
                    a(iaVar, hzVarMo603a.f9316b, i4);
                    i3++;
                }
                iaVar.h();
                return;
            case 14:
                ie ieVarMo604a = iaVar.mo604a();
                while (i3 < ieVarMo604a.f904a) {
                    a(iaVar, ieVarMo604a.a, i2 - 1);
                    i3++;
                }
                iaVar.j();
                return;
            case 15:
                hy hyVarMo602a = iaVar.mo602a();
                while (i3 < hyVarMo602a.f899a) {
                    a(iaVar, hyVarMo602a.a, i2 - 1);
                    i3++;
                }
                iaVar.i();
                return;
        }
    }
}
