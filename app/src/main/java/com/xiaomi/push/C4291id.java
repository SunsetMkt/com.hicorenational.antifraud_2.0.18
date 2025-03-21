package com.xiaomi.push;

/* renamed from: com.xiaomi.push.id */
/* loaded from: classes2.dex */
public class C4291id {

    /* renamed from: a */
    private static int f16350a = Integer.MAX_VALUE;

    /* renamed from: a */
    public static void m15660a(AbstractC4288ia abstractC4288ia, byte b2) {
        m15661a(abstractC4288ia, b2, f16350a);
    }

    /* renamed from: a */
    public static void m15661a(AbstractC4288ia abstractC4288ia, byte b2, int i2) {
        if (i2 <= 0) {
            throw new C4281hu("Maximum skip depth exceeded");
        }
        int i3 = 0;
        switch (b2) {
            case 2:
                abstractC4288ia.mo15615a();
                return;
            case 3:
                abstractC4288ia.mo15590a();
                return;
            case 4:
                abstractC4288ia.mo15591a();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                abstractC4288ia.mo15602a();
                return;
            case 8:
                abstractC4288ia.mo15592a();
                return;
            case 10:
                abstractC4288ia.mo15593a();
                return;
            case 11:
                abstractC4288ia.mo15601a();
                return;
            case 12:
                abstractC4288ia.mo15598a();
                while (true) {
                    byte b3 = abstractC4288ia.mo15594a().f16331a;
                    if (b3 == 0) {
                        abstractC4288ia.mo15622f();
                        return;
                    } else {
                        m15661a(abstractC4288ia, b3, i2 - 1);
                        abstractC4288ia.mo15623g();
                    }
                }
            case 13:
                C4286hz mo15596a = abstractC4288ia.mo15596a();
                while (i3 < mo15596a.f16337a) {
                    int i4 = i2 - 1;
                    m15661a(abstractC4288ia, mo15596a.f16336a, i4);
                    m15661a(abstractC4288ia, mo15596a.f16338b, i4);
                    i3++;
                }
                abstractC4288ia.mo15624h();
                return;
            case 14:
                C4292ie mo15597a = abstractC4288ia.mo15597a();
                while (i3 < mo15597a.f16352a) {
                    m15661a(abstractC4288ia, mo15597a.f16351a, i2 - 1);
                    i3++;
                }
                abstractC4288ia.mo15626j();
                return;
            case 15:
                C4285hy mo15595a = abstractC4288ia.mo15595a();
                while (i3 < mo15595a.f16335a) {
                    m15661a(abstractC4288ia, mo15595a.f16334a, i2 - 1);
                    i3++;
                }
                abstractC4288ia.mo15625i();
                return;
        }
    }
}
