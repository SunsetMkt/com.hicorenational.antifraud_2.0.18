package p000a.p001a.p014u;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* renamed from: a.a.u.b */
/* loaded from: classes.dex */
public class C0053b {

    /* renamed from: a */
    private static AtomicInteger f167a = new AtomicInteger(0);

    /* renamed from: a */
    public static String m203a(String str, String str2) {
        StringBuilder sb = new StringBuilder(16);
        if (str != null) {
            sb.append(str);
            sb.append('.');
        }
        if (str2 != null) {
            sb.append(str2);
            sb.append(f167a.incrementAndGet() & Integer.MAX_VALUE);
        }
        return sb.toString();
    }
}
