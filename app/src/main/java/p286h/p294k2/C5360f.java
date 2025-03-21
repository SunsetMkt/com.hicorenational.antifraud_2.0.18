package p286h.p294k2;

import androidx.exifinterface.media.ExifInterface;
import bean.SurveyH5Bean;
import com.tencent.open.SocialConstants;
import com.umeng.analytics.pro.C3397d;
import p286h.C5190a0;
import p286h.C5475q0;
import p286h.C5597r0;
import p286h.C5715y1;
import p286h.InterfaceC5610t0;
import p286h.InterfaceC5713y;
import p286h.p294k2.p300m.C5396c;
import p286h.p294k2.p300m.C5397d;
import p286h.p294k2.p301n.p302a.C5405h;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p310s.InterfaceC5510p;
import p286h.p309q2.p311t.C5535f0;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Continuation.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0004\u001a<\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\u00012\u001a\b\u0004\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\f\u0012\u0004\u0012\u00020\r0\u000bH\u0087\bø\u0001\u0000\u001a3\u0010\u000e\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\u001a\b\u0004\u0010\u000f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0007\u0012\u0004\u0012\u00020\r0\u000bH\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001aD\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u0007\"\u0004\b\u0000\u0010\b*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a]\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u0007\"\u0004\b\u0000\u0010\u0015\"\u0004\b\u0001\u0010\b*#\b\u0001\u0012\u0004\u0012\u0002H\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0016¢\u0006\u0002\b\u00172\u0006\u0010\u0018\u001a\u0002H\u00152\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001a&\u0010\u001a\u001a\u00020\r\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u00072\u0006\u0010\u001b\u001a\u0002H\bH\u0087\b¢\u0006\u0002\u0010\u001c\u001a!\u0010\u001d\u001a\u00020\r\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u00072\u0006\u0010\u001e\u001a\u00020\u001fH\u0087\b\u001a>\u0010 \u001a\u00020\r\"\u0004\b\u0000\u0010\b*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007H\u0007ø\u0001\u0000¢\u0006\u0002\u0010!\u001aW\u0010 \u001a\u00020\r\"\u0004\b\u0000\u0010\u0015\"\u0004\b\u0001\u0010\b*#\b\u0001\u0012\u0004\u0012\u0002H\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0016¢\u0006\u0002\b\u00172\u0006\u0010\u0018\u001a\u0002H\u00152\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\"\"\u001b\u0010\u0000\u001a\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, m23546d2 = {"coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext$annotations", "()V", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Continuation", "Lkotlin/coroutines/Continuation;", ExifInterface.GPS_DIRECTION_TRUE, C3397d.f11892R, "resumeWith", "Lkotlin/Function1;", "Lkotlin/Result;", "", "suspendCoroutine", "block", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createCoroutine", "", "completion", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", SocialConstants.PARAM_RECEIVER, "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "resume", SurveyH5Bean.VALUE, "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "resumeWithException", "exception", "", "startCoroutine", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "kotlin-stdlib"}, m23547k = 2, m23548mv = {1, 1, 16})
/* renamed from: h.k2.f */
/* loaded from: classes2.dex */
public final class C5360f {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Continuation.kt */
    /* renamed from: h.k2.f$a */
    public static final class a<T> implements InterfaceC5358d<T> {

        /* renamed from: a */
        final /* synthetic */ InterfaceC5361g f20234a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC5506l f20235b;

        public a(InterfaceC5361g interfaceC5361g, InterfaceC5506l interfaceC5506l) {
            this.f20234a = interfaceC5361g;
            this.f20235b = interfaceC5506l;
        }

        @Override // p286h.p294k2.InterfaceC5358d
        @InterfaceC5816d
        public InterfaceC5361g getContext() {
            return this.f20234a;
        }

        @Override // p286h.p294k2.InterfaceC5358d
        public void resumeWith(@InterfaceC5816d Object obj) {
            this.f20235b.invoke(C5475q0.m26854boximpl(obj));
        }
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    /* renamed from: a */
    public static /* synthetic */ void m22010a() {
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    /* renamed from: a */
    private static final <T> void m22011a(@InterfaceC5816d InterfaceC5358d<? super T> interfaceC5358d, T t) {
        C5475q0.a aVar = C5475q0.Companion;
        interfaceC5358d.resumeWith(C5475q0.m26855constructorimpl(t));
    }

    @InterfaceC5610t0(version = "1.3")
    /* renamed from: b */
    public static final <T> void m22014b(@InterfaceC5816d InterfaceC5506l<? super InterfaceC5358d<? super T>, ? extends Object> interfaceC5506l, @InterfaceC5816d InterfaceC5358d<? super T> interfaceC5358d) {
        InterfaceC5358d<C5715y1> m22112a;
        InterfaceC5358d m22110a;
        C5544i0.m22546f(interfaceC5506l, "$this$startCoroutine");
        C5544i0.m22546f(interfaceC5358d, "completion");
        m22112a = C5396c.m22112a(interfaceC5506l, interfaceC5358d);
        m22110a = C5396c.m22110a(m22112a);
        C5715y1 c5715y1 = C5715y1.f20665a;
        C5475q0.a aVar = C5475q0.Companion;
        m22110a.resumeWith(C5475q0.m26855constructorimpl(c5715y1));
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    /* renamed from: c */
    private static final <T> Object m22016c(InterfaceC5506l<? super InterfaceC5358d<? super T>, C5715y1> interfaceC5506l, InterfaceC5358d<? super T> interfaceC5358d) {
        InterfaceC5358d m22110a;
        Object m22117b;
        C5535f0.m22475c(0);
        m22110a = C5396c.m22110a(interfaceC5358d);
        C5365k c5365k = new C5365k(m22110a);
        interfaceC5506l.invoke(c5365k);
        Object m22024a = c5365k.m22024a();
        m22117b = C5397d.m22117b();
        if (m22024a == m22117b) {
            C5405h.m22142c(interfaceC5358d);
        }
        C5535f0.m22475c(1);
        return m22024a;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    /* renamed from: a */
    private static final <T> void m22012a(@InterfaceC5816d InterfaceC5358d<? super T> interfaceC5358d, Throwable th) {
        C5475q0.a aVar = C5475q0.Companion;
        interfaceC5358d.resumeWith(C5475q0.m26855constructorimpl(C5597r0.m22715a(th)));
    }

    @InterfaceC5610t0(version = "1.3")
    /* renamed from: b */
    public static final <R, T> void m22015b(@InterfaceC5816d InterfaceC5510p<? super R, ? super InterfaceC5358d<? super T>, ? extends Object> interfaceC5510p, R r, @InterfaceC5816d InterfaceC5358d<? super T> interfaceC5358d) {
        InterfaceC5358d<C5715y1> m22113a;
        InterfaceC5358d m22110a;
        C5544i0.m22546f(interfaceC5510p, "$this$startCoroutine");
        C5544i0.m22546f(interfaceC5358d, "completion");
        m22113a = C5396c.m22113a(interfaceC5510p, r, interfaceC5358d);
        m22110a = C5396c.m22110a(m22113a);
        C5715y1 c5715y1 = C5715y1.f20665a;
        C5475q0.a aVar = C5475q0.Companion;
        m22110a.resumeWith(C5475q0.m26855constructorimpl(c5715y1));
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    /* renamed from: a */
    private static final <T> InterfaceC5358d<T> m22007a(InterfaceC5361g interfaceC5361g, InterfaceC5506l<? super C5475q0<? extends T>, C5715y1> interfaceC5506l) {
        return new a(interfaceC5361g, interfaceC5506l);
    }

    /* renamed from: b */
    private static final InterfaceC5361g m22013b() {
        throw new C5190a0("Implemented as intrinsic");
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5816d
    /* renamed from: a */
    public static final <T> InterfaceC5358d<C5715y1> m22008a(@InterfaceC5816d InterfaceC5506l<? super InterfaceC5358d<? super T>, ? extends Object> interfaceC5506l, @InterfaceC5816d InterfaceC5358d<? super T> interfaceC5358d) {
        InterfaceC5358d<C5715y1> m22112a;
        InterfaceC5358d m22110a;
        Object m22117b;
        C5544i0.m22546f(interfaceC5506l, "$this$createCoroutine");
        C5544i0.m22546f(interfaceC5358d, "completion");
        m22112a = C5396c.m22112a(interfaceC5506l, interfaceC5358d);
        m22110a = C5396c.m22110a(m22112a);
        m22117b = C5397d.m22117b();
        return new C5365k(m22110a, m22117b);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5816d
    /* renamed from: a */
    public static final <R, T> InterfaceC5358d<C5715y1> m22009a(@InterfaceC5816d InterfaceC5510p<? super R, ? super InterfaceC5358d<? super T>, ? extends Object> interfaceC5510p, R r, @InterfaceC5816d InterfaceC5358d<? super T> interfaceC5358d) {
        InterfaceC5358d<C5715y1> m22113a;
        InterfaceC5358d m22110a;
        Object m22117b;
        C5544i0.m22546f(interfaceC5510p, "$this$createCoroutine");
        C5544i0.m22546f(interfaceC5358d, "completion");
        m22113a = C5396c.m22113a(interfaceC5510p, r, interfaceC5358d);
        m22110a = C5396c.m22110a(m22113a);
        m22117b = C5397d.m22117b();
        return new C5365k(m22110a, m22117b);
    }
}
