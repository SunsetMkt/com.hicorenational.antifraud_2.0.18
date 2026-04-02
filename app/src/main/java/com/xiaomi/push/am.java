package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
class am {
    static int a;

    public static ai a(Context context) {
        if (j.m624a()) {
            a = 1;
            return new al(context);
        }
        if (ah.a(context)) {
            a = 2;
            return new ah(context);
        }
        if (ao.a(context)) {
            a = 4;
            return new ao(context);
        }
        if (aq.a(context)) {
            a = 5;
            return new aq(context);
        }
        if (ak.a(context)) {
            a = 3;
            return new aj(context);
        }
        a = 0;
        return new ap();
    }
}
