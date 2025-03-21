package p251g.p252a.p268y0.p273e.p276c;

import java.util.concurrent.Callable;
import p251g.p252a.AbstractC4533s;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.p264u0.C4553d;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: MaybeErrorCallable.java */
/* renamed from: g.a.y0.e.c.w */
/* loaded from: classes2.dex */
public final class C4899w<T> extends AbstractC4533s<T> {

    /* renamed from: a */
    final Callable<? extends Throwable> f18718a;

    public C4899w(Callable<? extends Throwable> callable) {
        this.f18718a = callable;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super T> interfaceC4559v) {
        interfaceC4559v.onSubscribe(C4553d.m18183a());
        try {
            th = (Throwable) C4601b.m18284a(this.f18718a.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            C4561b.m18199b(th);
        }
        interfaceC4559v.onError(th);
    }
}
