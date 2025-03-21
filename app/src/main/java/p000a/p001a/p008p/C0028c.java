package p000a.p001a.p008p;

import anet.channel.util.ALog;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
/* renamed from: a.a.p.c */
/* loaded from: classes.dex */
public class C0028c {

    /* renamed from: a */
    private static final CopyOnWriteArrayList<InterfaceC0027b> f76a = new CopyOnWriteArrayList<>();

    private C0028c() {
    }

    /* renamed from: a */
    public static void m156a(InterfaceC0027b interfaceC0027b) {
        if (f76a.contains(interfaceC0027b)) {
            return;
        }
        f76a.add(interfaceC0027b);
        ALog.m716i("anet.InterceptorManager", "[addInterceptor]", null, "interceptors", f76a.toString());
    }

    /* renamed from: b */
    public static boolean m157b(InterfaceC0027b interfaceC0027b) {
        return f76a.contains(interfaceC0027b);
    }

    /* renamed from: c */
    public static void m158c(InterfaceC0027b interfaceC0027b) {
        f76a.remove(interfaceC0027b);
        ALog.m716i("anet.InterceptorManager", "[remoteInterceptor]", null, "interceptors", f76a.toString());
    }

    /* renamed from: a */
    public static InterfaceC0027b m155a(int i2) {
        return f76a.get(i2);
    }

    /* renamed from: a */
    public static int m154a() {
        return f76a.size();
    }
}
