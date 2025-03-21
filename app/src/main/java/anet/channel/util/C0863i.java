package anet.channel.util;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* renamed from: anet.channel.util.i */
/* loaded from: classes.dex */
public class C0863i {

    /* renamed from: a */
    private static AtomicInteger f1188a = new AtomicInteger();

    /* renamed from: a */
    public static String m740a(String str) {
        if (f1188a.get() == Integer.MAX_VALUE) {
            f1188a.set(0);
        }
        return !TextUtils.isEmpty(str) ? StringUtils.concatString(str, ".AWCN", String.valueOf(f1188a.incrementAndGet())) : StringUtils.concatString("AWCN", String.valueOf(f1188a.incrementAndGet()));
    }
}
