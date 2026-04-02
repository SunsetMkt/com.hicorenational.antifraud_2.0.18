package i.k2.l.p;

import i.k2.l.e;
import i.q2.t.i0;
import i.q2.t.v;
import i.y;

/* JADX INFO: compiled from: CoroutinesMigration.kt */
/* JADX INFO: loaded from: classes2.dex */
@y(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lkotlin/coroutines/experimental/migration/ExperimentalContextMigration;", "Lkotlin/coroutines/experimental/AbstractCoroutineContextElement;", com.umeng.analytics.pro.d.R, "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Key", "kotlin-stdlib-coroutines"}, k = 1, mv = {1, 1, 16})
final class e extends i.k2.l.a {

    /* JADX INFO: renamed from: d */
    public static final a f12150d = new a(null);

    /* JADX INFO: renamed from: c */
    @j.c.a.d
    private final i.k2.g f12151c;

    /* JADX INFO: compiled from: CoroutinesMigration.kt */
    public static final class a implements e.c<e> {
        private a() {
        }

        public /* synthetic */ a(v vVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@j.c.a.d i.k2.g gVar) {
        super(f12150d);
        i0.f(gVar, com.umeng.analytics.pro.d.R);
        this.f12151c = gVar;
    }

    @j.c.a.d
    public final i.k2.g a() {
        return this.f12151c;
    }
}
