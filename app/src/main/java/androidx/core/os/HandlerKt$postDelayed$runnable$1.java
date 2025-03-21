package androidx.core.os;

import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5495a;

/* compiled from: Handler.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m23546d2 = {"<anonymous>", "", "run"}, m23547k = 3, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class HandlerKt$postDelayed$runnable$1 implements Runnable {
    final /* synthetic */ InterfaceC5495a $action;

    public HandlerKt$postDelayed$runnable$1(InterfaceC5495a interfaceC5495a) {
        this.$action = interfaceC5495a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$action.invoke();
    }
}
