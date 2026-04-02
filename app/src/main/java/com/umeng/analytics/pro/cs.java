package com.umeng.analytics.pro;

import com.umeng.analytics.pro.cj;

/* JADX INFO: compiled from: TProtocolUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public class cs {
    private static int a = Integer.MAX_VALUE;

    public static void a(int i2) {
        a = i2;
    }

    public static void a(cp cpVar, byte b2) throws bw {
        a(cpVar, b2, a);
    }

    public static void a(cp cpVar, byte b2, int i2) throws bw {
        if (i2 > 0) {
            int i3 = 0;
            switch (b2) {
                case 2:
                    cpVar.t();
                    return;
                case 3:
                    cpVar.u();
                    return;
                case 4:
                    cpVar.y();
                    return;
                case 5:
                case 7:
                case 9:
                default:
                    return;
                case 6:
                    cpVar.v();
                    return;
                case 8:
                    cpVar.w();
                    return;
                case 10:
                    cpVar.x();
                    return;
                case 11:
                    cpVar.A();
                    return;
                case 12:
                    cpVar.j();
                    while (true) {
                        byte b3 = cpVar.l().f7175b;
                        if (b3 == 0) {
                            cpVar.k();
                            return;
                        } else {
                            a(cpVar, b3, i2 - 1);
                            cpVar.m();
                        }
                    }
                    break;
                case 13:
                    cm cmVarN = cpVar.n();
                    while (i3 < cmVarN.f7179c) {
                        int i4 = i2 - 1;
                        a(cpVar, cmVarN.a, i4);
                        a(cpVar, cmVarN.f7178b, i4);
                        i3++;
                    }
                    cpVar.o();
                    return;
                case 14:
                    ct ctVarR = cpVar.r();
                    while (i3 < ctVarR.f7193b) {
                        a(cpVar, ctVarR.a, i2 - 1);
                        i3++;
                    }
                    cpVar.s();
                    return;
                case 15:
                    cl clVarP = cpVar.p();
                    while (i3 < clVarP.f7177b) {
                        a(cpVar, clVarP.a, i2 - 1);
                        i3++;
                    }
                    cpVar.q();
                    return;
            }
        } else {
            throw new bw("Maximum skip depth exceeded");
        }
    }

    public static cr a(byte[] bArr, cr crVar) {
        if (bArr[0] > 16) {
            return new cj.a();
        }
        return (bArr.length <= 1 || (bArr[1] & i.q2.t.n.a) == 0) ? crVar : new cj.a();
    }
}
