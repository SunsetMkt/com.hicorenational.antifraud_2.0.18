package anet.channel.util;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class i {
    private static AtomicInteger a = new AtomicInteger();

    public static String a(String str) {
        if (a.get() == Integer.MAX_VALUE) {
            a.set(0);
        }
        return !TextUtils.isEmpty(str) ? StringUtils.concatString(str, ".AWCN", String.valueOf(a.incrementAndGet())) : StringUtils.concatString("AWCN", String.valueOf(a.incrementAndGet()));
    }
}
