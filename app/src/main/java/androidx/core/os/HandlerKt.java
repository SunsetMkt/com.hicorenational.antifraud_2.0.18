package androidx.core.os;

import android.os.Handler;
import p286h.C5715y1;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5495a;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: Handler.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a1\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086\b\u001a1\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086\b¨\u0006\f"}, m23546d2 = {"postAtTime", "Ljava/lang/Runnable;", "Landroid/os/Handler;", "uptimeMillis", "", "token", "", "action", "Lkotlin/Function0;", "", "postDelayed", "delayInMillis", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class HandlerKt {
    @InterfaceC5816d
    public static final Runnable postAtTime(@InterfaceC5816d Handler handler, long j2, @InterfaceC5817e Object obj, @InterfaceC5816d InterfaceC5495a<C5715y1> interfaceC5495a) {
        C5544i0.m22546f(handler, "$receiver");
        C5544i0.m22546f(interfaceC5495a, "action");
        HandlerKt$postAtTime$runnable$1 handlerKt$postAtTime$runnable$1 = new HandlerKt$postAtTime$runnable$1(interfaceC5495a);
        handler.postAtTime(handlerKt$postAtTime$runnable$1, obj, j2);
        return handlerKt$postAtTime$runnable$1;
    }

    @InterfaceC5816d
    public static /* bridge */ /* synthetic */ Runnable postAtTime$default(Handler handler, long j2, Object obj, InterfaceC5495a interfaceC5495a, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            obj = null;
        }
        C5544i0.m22546f(handler, "$receiver");
        C5544i0.m22546f(interfaceC5495a, "action");
        HandlerKt$postAtTime$runnable$1 handlerKt$postAtTime$runnable$1 = new HandlerKt$postAtTime$runnable$1(interfaceC5495a);
        handler.postAtTime(handlerKt$postAtTime$runnable$1, obj, j2);
        return handlerKt$postAtTime$runnable$1;
    }

    @InterfaceC5816d
    public static final Runnable postDelayed(@InterfaceC5816d Handler handler, long j2, @InterfaceC5817e Object obj, @InterfaceC5816d InterfaceC5495a<C5715y1> interfaceC5495a) {
        C5544i0.m22546f(handler, "$receiver");
        C5544i0.m22546f(interfaceC5495a, "action");
        HandlerKt$postDelayed$runnable$1 handlerKt$postDelayed$runnable$1 = new HandlerKt$postDelayed$runnable$1(interfaceC5495a);
        if (obj == null) {
            handler.postDelayed(handlerKt$postDelayed$runnable$1, j2);
        } else {
            HandlerCompat.postDelayed(handler, handlerKt$postDelayed$runnable$1, obj, j2);
        }
        return handlerKt$postDelayed$runnable$1;
    }

    @InterfaceC5816d
    public static /* bridge */ /* synthetic */ Runnable postDelayed$default(Handler handler, long j2, Object obj, InterfaceC5495a interfaceC5495a, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            obj = null;
        }
        C5544i0.m22546f(handler, "$receiver");
        C5544i0.m22546f(interfaceC5495a, "action");
        HandlerKt$postDelayed$runnable$1 handlerKt$postDelayed$runnable$1 = new HandlerKt$postDelayed$runnable$1(interfaceC5495a);
        if (obj == null) {
            handler.postDelayed(handlerKt$postDelayed$runnable$1, j2);
        } else {
            HandlerCompat.postDelayed(handler, handlerKt$postDelayed$runnable$1, obj, j2);
        }
        return handlerKt$postDelayed$runnable$1;
    }
}
