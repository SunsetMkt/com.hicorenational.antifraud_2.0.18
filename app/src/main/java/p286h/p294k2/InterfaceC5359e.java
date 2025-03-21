package p286h.p294k2;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.C3397d;
import p286h.C5226e1;
import p286h.InterfaceC5610t0;
import p286h.InterfaceC5713y;
import p286h.p294k2.InterfaceC5361g;
import p286h.p309q2.p310s.InterfaceC5510p;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: ContinuationInterceptor.kt */
@InterfaceC5610t0(version = "1.3")
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ(\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0005H\u0096\u0002¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\bH&J\u0014\u0010\u000b\u001a\u00020\f2\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016J\u0014\u0010\r\u001a\u00020\u000e2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¨\u0006\u0010"}, m23546d2 = {"Lkotlin/coroutines/ContinuationInterceptor;", "Lkotlin/coroutines/CoroutineContext$Element;", "get", ExifInterface.LONGITUDE_EAST, "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "interceptContinuation", "Lkotlin/coroutines/Continuation;", ExifInterface.GPS_DIRECTION_TRUE, "continuation", "minusKey", "Lkotlin/coroutines/CoroutineContext;", "releaseInterceptedContinuation", "", "Key", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.k2.e */
/* loaded from: classes2.dex */
public interface InterfaceC5359e extends InterfaceC5361g.b {

    /* renamed from: V */
    public static final b f20232V = b.f20233a;

    /* compiled from: ContinuationInterceptor.kt */
    /* renamed from: h.k2.e$a */
    public static final class a {
        @InterfaceC5817e
        /* renamed from: a */
        public static <E extends InterfaceC5361g.b> E m22002a(InterfaceC5359e interfaceC5359e, @InterfaceC5816d InterfaceC5361g.c<E> cVar) {
            C5544i0.m22546f(cVar, "key");
            if (!(cVar instanceof AbstractC5356b)) {
                if (InterfaceC5359e.f20232V != cVar) {
                    return null;
                }
                if (interfaceC5359e != null) {
                    return interfaceC5359e;
                }
                throw new C5226e1("null cannot be cast to non-null type E");
            }
            AbstractC5356b abstractC5356b = (AbstractC5356b) cVar;
            if (!abstractC5356b.m21996a(interfaceC5359e.getKey())) {
                return null;
            }
            E e2 = (E) abstractC5356b.m21995a(interfaceC5359e);
            if (e2 instanceof InterfaceC5361g.b) {
                return e2;
            }
            return null;
        }

        @InterfaceC5816d
        /* renamed from: a */
        public static InterfaceC5361g m22003a(InterfaceC5359e interfaceC5359e, @InterfaceC5816d InterfaceC5361g interfaceC5361g) {
            C5544i0.m22546f(interfaceC5361g, C3397d.f11892R);
            return InterfaceC5361g.b.a.m22019a(interfaceC5359e, interfaceC5361g);
        }

        /* renamed from: a */
        public static <R> R m22004a(InterfaceC5359e interfaceC5359e, R r, @InterfaceC5816d InterfaceC5510p<? super R, ? super InterfaceC5361g.b, ? extends R> interfaceC5510p) {
            C5544i0.m22546f(interfaceC5510p, "operation");
            return (R) InterfaceC5361g.b.a.m22020a(interfaceC5359e, r, interfaceC5510p);
        }

        /* renamed from: a */
        public static void m22005a(InterfaceC5359e interfaceC5359e, @InterfaceC5816d InterfaceC5358d<?> interfaceC5358d) {
            C5544i0.m22546f(interfaceC5358d, "continuation");
        }

        @InterfaceC5816d
        /* renamed from: b */
        public static InterfaceC5361g m22006b(InterfaceC5359e interfaceC5359e, @InterfaceC5816d InterfaceC5361g.c<?> cVar) {
            C5544i0.m22546f(cVar, "key");
            if (!(cVar instanceof AbstractC5356b)) {
                return InterfaceC5359e.f20232V == cVar ? C5363i.INSTANCE : interfaceC5359e;
            }
            AbstractC5356b abstractC5356b = (AbstractC5356b) cVar;
            return (!abstractC5356b.m21996a(interfaceC5359e.getKey()) || abstractC5356b.m21995a(interfaceC5359e) == null) ? interfaceC5359e : C5363i.INSTANCE;
        }
    }

    /* compiled from: ContinuationInterceptor.kt */
    /* renamed from: h.k2.e$b */
    public static final class b implements InterfaceC5361g.c<InterfaceC5359e> {

        /* renamed from: a */
        static final /* synthetic */ b f20233a = new b();

        private b() {
        }
    }

    /* renamed from: a */
    void mo22000a(@InterfaceC5816d InterfaceC5358d<?> interfaceC5358d);

    @InterfaceC5816d
    /* renamed from: b */
    <T> InterfaceC5358d<T> mo22001b(@InterfaceC5816d InterfaceC5358d<? super T> interfaceC5358d);

    @Override // p286h.p294k2.InterfaceC5361g.b, p286h.p294k2.InterfaceC5361g
    @InterfaceC5817e
    <E extends InterfaceC5361g.b> E get(@InterfaceC5816d InterfaceC5361g.c<E> cVar);

    @Override // p286h.p294k2.InterfaceC5361g.b, p286h.p294k2.InterfaceC5361g
    @InterfaceC5816d
    InterfaceC5361g minusKey(@InterfaceC5816d InterfaceC5361g.c<?> cVar);
}
