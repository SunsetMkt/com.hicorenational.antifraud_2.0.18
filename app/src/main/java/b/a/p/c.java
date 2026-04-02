package b.a.p;

import anet.channel.util.ALog;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private static final CopyOnWriteArrayList<b> a = new CopyOnWriteArrayList<>();

    private c() {
    }

    public static void a(b bVar) {
        if (a.contains(bVar)) {
            return;
        }
        a.add(bVar);
        ALog.i("anet.InterceptorManager", "[addInterceptor]", null, "interceptors", a.toString());
    }

    public static boolean b(b bVar) {
        return a.contains(bVar);
    }

    public static void c(b bVar) {
        a.remove(bVar);
        ALog.i("anet.InterceptorManager", "[remoteInterceptor]", null, "interceptors", a.toString());
    }

    public static b a(int i2) {
        return a.get(i2);
    }

    public static int a() {
        return a.size();
    }
}
