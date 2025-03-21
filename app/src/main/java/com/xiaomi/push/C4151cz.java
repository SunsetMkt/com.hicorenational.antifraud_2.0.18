package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import java.io.File;

/* renamed from: com.xiaomi.push.cz */
/* loaded from: classes2.dex */
public class C4151cz {

    /* renamed from: a */
    private static InterfaceC4150cy f14838a;

    /* renamed from: a */
    public static File m14245a(Context context) {
        if (context == null) {
            AbstractC4022b.m13361d("ERROR: Context cannot be null.");
            return null;
        }
        InterfaceC4150cy interfaceC4150cy = f14838a;
        if (interfaceC4150cy != null) {
            return interfaceC4150cy.m14244a(context);
        }
        AbstractC4022b.m13361d("ERROR: XMSF not configure the instance of LogAgent.");
        return null;
    }
}
