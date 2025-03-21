package p286h.p292i2;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.accs.AccsClientConfig;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import p286h.C5715y1;
import p286h.InterfaceC5713y;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.InterfaceC5481e;
import p286h.p309q2.p310s.InterfaceC5495a;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: Thread.kt */
@InterfaceC5481e(name = "ThreadsKt")
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aJ\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u001a0\u0010\u000e\u001a\u0002H\u000f\"\b\b\u0000\u0010\u000f*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u000f0\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000f0\fH\u0087\b¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, m23546d2 = {"thread", "Ljava/lang/Thread;", "start", "", "isDaemon", "contextClassLoader", "Ljava/lang/ClassLoader;", CommonNetImpl.NAME, "", RemoteMessageConst.Notification.PRIORITY, "", "block", "Lkotlin/Function0;", "", "getOrSet", ExifInterface.GPS_DIRECTION_TRUE, "", "Ljava/lang/ThreadLocal;", AccsClientConfig.DEFAULT_CONFIGTAG, "(Ljava/lang/ThreadLocal;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlin-stdlib"}, m23547k = 2, m23548mv = {1, 1, 16})
/* renamed from: h.i2.b */
/* loaded from: classes2.dex */
public final class C5337b {

    /* compiled from: Thread.kt */
    /* renamed from: h.i2.b$a */
    public static final class a extends Thread {

        /* renamed from: a */
        final /* synthetic */ InterfaceC5495a f20217a;

        a(InterfaceC5495a interfaceC5495a) {
            this.f20217a = interfaceC5495a;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.f20217a.invoke();
        }
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final Thread m21899a(boolean z, boolean z2, @InterfaceC5817e ClassLoader classLoader, @InterfaceC5817e String str, int i2, @InterfaceC5816d InterfaceC5495a<C5715y1> interfaceC5495a) {
        C5544i0.m22546f(interfaceC5495a, "block");
        a aVar = new a(interfaceC5495a);
        if (z2) {
            aVar.setDaemon(true);
        }
        if (i2 > 0) {
            aVar.setPriority(i2);
        }
        if (str != null) {
            aVar.setName(str);
        }
        if (classLoader != null) {
            aVar.setContextClassLoader(classLoader);
        }
        if (z) {
            aVar.start();
        }
        return aVar;
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final <T> T m21898a(@InterfaceC5816d ThreadLocal<T> threadLocal, InterfaceC5495a<? extends T> interfaceC5495a) {
        T t = threadLocal.get();
        if (t != null) {
            return t;
        }
        T invoke = interfaceC5495a.invoke();
        threadLocal.set(invoke);
        return invoke;
    }
}
