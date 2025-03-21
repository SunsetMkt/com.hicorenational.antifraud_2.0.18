package com.xiaomi.push;

import android.content.Context;

/* renamed from: com.xiaomi.push.am */
/* loaded from: classes2.dex */
class C4084am {

    /* renamed from: a */
    static int f14539a;

    /* renamed from: a */
    public static InterfaceC4080ai m13754a(Context context) {
        if (C4300j.m15680a()) {
            f14539a = 1;
            return new C4083al(context);
        }
        if (C4079ah.m13733a(context)) {
            f14539a = 2;
            return new C4079ah(context);
        }
        if (C4086ao.m13771a(context)) {
            f14539a = 4;
            return new C4086ao(context);
        }
        if (C4088aq.m13776a(context)) {
            f14539a = 5;
            return new C4088aq(context);
        }
        if (C4082ak.m13751a(context)) {
            f14539a = 3;
            return new C4081aj(context);
        }
        f14539a = 0;
        return new C4087ap();
    }
}
