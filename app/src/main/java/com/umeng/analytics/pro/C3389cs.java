package com.umeng.analytics.pro;

import com.umeng.analytics.pro.C3380cj;
import p286h.p309q2.p311t.C5558n;

/* compiled from: TProtocolUtil.java */
/* renamed from: com.umeng.analytics.pro.cs */
/* loaded from: classes2.dex */
public class C3389cs {

    /* renamed from: a */
    private static int f11857a = Integer.MAX_VALUE;

    /* renamed from: a */
    public static void m11182a(int i2) {
        f11857a = i2;
    }

    /* renamed from: a */
    public static void m11183a(AbstractC3386cp abstractC3386cp, byte b2) throws C3366bw {
        m11184a(abstractC3386cp, b2, f11857a);
    }

    /* renamed from: a */
    public static void m11184a(AbstractC3386cp abstractC3386cp, byte b2, int i2) throws C3366bw {
        if (i2 > 0) {
            int i3 = 0;
            switch (b2) {
                case 2:
                    abstractC3386cp.mo11147t();
                    return;
                case 3:
                    abstractC3386cp.mo11148u();
                    return;
                case 4:
                    abstractC3386cp.mo11152y();
                    return;
                case 5:
                case 7:
                case 9:
                default:
                    return;
                case 6:
                    abstractC3386cp.mo11149v();
                    return;
                case 8:
                    abstractC3386cp.mo11150w();
                    return;
                case 10:
                    abstractC3386cp.mo11151x();
                    return;
                case 11:
                    abstractC3386cp.mo11110A();
                    return;
                case 12:
                    abstractC3386cp.mo11137j();
                    while (true) {
                        byte b3 = abstractC3386cp.mo11139l().f11834b;
                        if (b3 == 0) {
                            abstractC3386cp.mo11138k();
                            return;
                        } else {
                            m11184a(abstractC3386cp, b3, i2 - 1);
                            abstractC3386cp.mo11140m();
                        }
                    }
                case 13:
                    C3383cm mo11141n = abstractC3386cp.mo11141n();
                    while (i3 < mo11141n.f11840c) {
                        int i4 = i2 - 1;
                        m11184a(abstractC3386cp, mo11141n.f11838a, i4);
                        m11184a(abstractC3386cp, mo11141n.f11839b, i4);
                        i3++;
                    }
                    abstractC3386cp.mo11142o();
                    return;
                case 14:
                    C3390ct mo11145r = abstractC3386cp.mo11145r();
                    while (i3 < mo11145r.f11859b) {
                        m11184a(abstractC3386cp, mo11145r.f11858a, i2 - 1);
                        i3++;
                    }
                    abstractC3386cp.mo11146s();
                    return;
                case 15:
                    C3382cl mo11143p = abstractC3386cp.mo11143p();
                    while (i3 < mo11143p.f11837b) {
                        m11184a(abstractC3386cp, mo11143p.f11836a, i2 - 1);
                        i3++;
                    }
                    abstractC3386cp.mo11144q();
                    return;
            }
        } else {
            throw new C3366bw("Maximum skip depth exceeded");
        }
    }

    /* renamed from: a */
    public static InterfaceC3388cr m11181a(byte[] bArr, InterfaceC3388cr interfaceC3388cr) {
        if (bArr[0] > 16) {
            return new C3380cj.a();
        }
        return (bArr.length <= 1 || (bArr[1] & C5558n.f20401a) == 0) ? interfaceC3388cr : new C3380cj.a();
    }
}
