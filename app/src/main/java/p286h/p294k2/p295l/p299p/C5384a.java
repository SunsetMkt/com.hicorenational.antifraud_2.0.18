package p286h.p294k2.p295l.p299p;

import com.umeng.analytics.pro.C3397d;
import p286h.InterfaceC5713y;
import p286h.p294k2.AbstractC5355a;
import p286h.p294k2.InterfaceC5361g;
import p286h.p294k2.p295l.InterfaceC5370e;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5586v;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: CoroutinesMigration.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m23546d2 = {"Lkotlin/coroutines/experimental/migration/ContextMigration;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", C3397d.f11892R, "Lkotlin/coroutines/experimental/CoroutineContext;", "(Lkotlin/coroutines/experimental/CoroutineContext;)V", "getContext", "()Lkotlin/coroutines/experimental/CoroutineContext;", "Key", "kotlin-stdlib-coroutines"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.k2.l.p.a */
/* loaded from: classes2.dex */
final class C5384a extends AbstractC5355a {

    /* renamed from: c */
    public static final a f20273c = new a(null);

    /* renamed from: b */
    @InterfaceC5816d
    private final InterfaceC5370e f20274b;

    /* compiled from: CoroutinesMigration.kt */
    /* renamed from: h.k2.l.p.a$a */
    public static final class a implements InterfaceC5361g.c<C5384a> {
        private a() {
        }

        public /* synthetic */ a(C5586v c5586v) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5384a(@InterfaceC5816d InterfaceC5370e interfaceC5370e) {
        super(f20273c);
        C5544i0.m22546f(interfaceC5370e, C3397d.f11892R);
        this.f20274b = interfaceC5370e;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public final InterfaceC5370e m22085a() {
        return this.f20274b;
    }
}
