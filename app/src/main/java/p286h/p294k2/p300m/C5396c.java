package p286h.p294k2.p300m;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.open.SocialConstants;
import p286h.C5226e1;
import p286h.C5597r0;
import p286h.C5715y1;
import p286h.InterfaceC5610t0;
import p286h.InterfaceC5713y;
import p286h.p294k2.C5363i;
import p286h.p294k2.InterfaceC5358d;
import p286h.p294k2.InterfaceC5361g;
import p286h.p294k2.p301n.p302a.AbstractC5398a;
import p286h.p294k2.p301n.p302a.AbstractC5401d;
import p286h.p294k2.p301n.p302a.AbstractC5407j;
import p286h.p294k2.p301n.p302a.C5405h;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p310s.InterfaceC5510p;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5560n1;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IntrinsicsJvm.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aF\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\u001c\b\u0004\u0010\u0005\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0083\b¢\u0006\u0002\b\b\u001aD\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a]\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0003*#\b\u0001\u0012\u0004\u0012\u0002H\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f¢\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u0002H\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007\u001aA\u0010\u0011\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0003*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001aZ\u0010\u0011\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0003*#\b\u0001\u0012\u0004\u0012\u0002H\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f¢\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u0002H\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, m23546d2 = {"createCoroutineFromSuspendFunction", "Lkotlin/coroutines/Continuation;", "", ExifInterface.GPS_DIRECTION_TRUE, "completion", "block", "Lkotlin/Function1;", "", "createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt", "createCoroutineUnintercepted", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", SocialConstants.PARAM_RECEIVER, "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "intercepted", "startCoroutineUninterceptedOrReturn", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib"}, m23547k = 5, m23548mv = {1, 1, 16}, m23550xi = 1, m23551xs = "kotlin/coroutines/intrinsics/IntrinsicsKt")
/* renamed from: h.k2.m.c */
/* loaded from: classes2.dex */
public class C5396c {

    /* compiled from: IntrinsicsJvm.kt */
    /* renamed from: h.k2.m.c$a */
    public static final class a extends AbstractC5407j {
        final /* synthetic */ InterfaceC5506l $block;
        final /* synthetic */ InterfaceC5358d $completion;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceC5506l interfaceC5506l, InterfaceC5358d interfaceC5358d, InterfaceC5358d interfaceC5358d2) {
            super(interfaceC5358d2);
            this.$block = interfaceC5506l;
            this.$completion = interfaceC5358d;
        }

        @Override // p286h.p294k2.p301n.p302a.AbstractC5398a
        @InterfaceC5817e
        protected Object invokeSuspend(@InterfaceC5816d Object obj) {
            int i2 = this.label;
            if (i2 == 0) {
                this.label = 1;
                C5597r0.m22717b(obj);
                return this.$block.invoke(this);
            }
            if (i2 != 1) {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
            this.label = 2;
            C5597r0.m22717b(obj);
            return obj;
        }
    }

    /* compiled from: IntrinsicsJvm.kt */
    /* renamed from: h.k2.m.c$b */
    public static final class b extends AbstractC5401d {
        final /* synthetic */ InterfaceC5506l $block;
        final /* synthetic */ InterfaceC5358d $completion;
        final /* synthetic */ InterfaceC5361g $context;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InterfaceC5506l interfaceC5506l, InterfaceC5358d interfaceC5358d, InterfaceC5361g interfaceC5361g, InterfaceC5358d interfaceC5358d2, InterfaceC5361g interfaceC5361g2) {
            super(interfaceC5358d2, interfaceC5361g2);
            this.$block = interfaceC5506l;
            this.$completion = interfaceC5358d;
            this.$context = interfaceC5361g;
        }

        @Override // p286h.p294k2.p301n.p302a.AbstractC5398a
        @InterfaceC5817e
        protected Object invokeSuspend(@InterfaceC5816d Object obj) {
            int i2 = this.label;
            if (i2 == 0) {
                this.label = 1;
                C5597r0.m22717b(obj);
                return this.$block.invoke(this);
            }
            if (i2 != 1) {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
            this.label = 2;
            C5597r0.m22717b(obj);
            return obj;
        }
    }

    /* compiled from: IntrinsicsJvm.kt */
    /* renamed from: h.k2.m.c$c */
    public static final class c extends AbstractC5407j {
        final /* synthetic */ InterfaceC5358d $completion;
        final /* synthetic */ InterfaceC5506l $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(InterfaceC5358d interfaceC5358d, InterfaceC5358d interfaceC5358d2, InterfaceC5506l interfaceC5506l) {
            super(interfaceC5358d2);
            this.$completion = interfaceC5358d;
            this.$this_createCoroutineUnintercepted$inlined = interfaceC5506l;
        }

        @Override // p286h.p294k2.p301n.p302a.AbstractC5398a
        @InterfaceC5817e
        protected Object invokeSuspend(@InterfaceC5816d Object obj) {
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.label = 2;
                C5597r0.m22717b(obj);
                return obj;
            }
            this.label = 1;
            C5597r0.m22717b(obj);
            InterfaceC5506l interfaceC5506l = this.$this_createCoroutineUnintercepted$inlined;
            if (interfaceC5506l != null) {
                return ((InterfaceC5506l) C5560n1.m22586a(interfaceC5506l, 1)).invoke(this);
            }
            throw new C5226e1("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
    }

    /* compiled from: IntrinsicsJvm.kt */
    /* renamed from: h.k2.m.c$d */
    public static final class d extends AbstractC5401d {
        final /* synthetic */ InterfaceC5358d $completion;
        final /* synthetic */ InterfaceC5361g $context;
        final /* synthetic */ InterfaceC5506l $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(InterfaceC5358d interfaceC5358d, InterfaceC5361g interfaceC5361g, InterfaceC5358d interfaceC5358d2, InterfaceC5361g interfaceC5361g2, InterfaceC5506l interfaceC5506l) {
            super(interfaceC5358d2, interfaceC5361g2);
            this.$completion = interfaceC5358d;
            this.$context = interfaceC5361g;
            this.$this_createCoroutineUnintercepted$inlined = interfaceC5506l;
        }

        @Override // p286h.p294k2.p301n.p302a.AbstractC5398a
        @InterfaceC5817e
        protected Object invokeSuspend(@InterfaceC5816d Object obj) {
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.label = 2;
                C5597r0.m22717b(obj);
                return obj;
            }
            this.label = 1;
            C5597r0.m22717b(obj);
            InterfaceC5506l interfaceC5506l = this.$this_createCoroutineUnintercepted$inlined;
            if (interfaceC5506l != null) {
                return ((InterfaceC5506l) C5560n1.m22586a(interfaceC5506l, 1)).invoke(this);
            }
            throw new C5226e1("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
    }

    /* compiled from: IntrinsicsJvm.kt */
    /* renamed from: h.k2.m.c$e */
    public static final class e extends AbstractC5407j {
        final /* synthetic */ InterfaceC5358d $completion;
        final /* synthetic */ Object $receiver$inlined;
        final /* synthetic */ InterfaceC5510p $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(InterfaceC5358d interfaceC5358d, InterfaceC5358d interfaceC5358d2, InterfaceC5510p interfaceC5510p, Object obj) {
            super(interfaceC5358d2);
            this.$completion = interfaceC5358d;
            this.$this_createCoroutineUnintercepted$inlined = interfaceC5510p;
            this.$receiver$inlined = obj;
        }

        @Override // p286h.p294k2.p301n.p302a.AbstractC5398a
        @InterfaceC5817e
        protected Object invokeSuspend(@InterfaceC5816d Object obj) {
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.label = 2;
                C5597r0.m22717b(obj);
                return obj;
            }
            this.label = 1;
            C5597r0.m22717b(obj);
            InterfaceC5510p interfaceC5510p = this.$this_createCoroutineUnintercepted$inlined;
            if (interfaceC5510p != null) {
                return ((InterfaceC5510p) C5560n1.m22586a(interfaceC5510p, 2)).invoke(this.$receiver$inlined, this);
            }
            throw new C5226e1("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
    }

    /* compiled from: IntrinsicsJvm.kt */
    /* renamed from: h.k2.m.c$f */
    public static final class f extends AbstractC5401d {
        final /* synthetic */ InterfaceC5358d $completion;
        final /* synthetic */ InterfaceC5361g $context;
        final /* synthetic */ Object $receiver$inlined;
        final /* synthetic */ InterfaceC5510p $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(InterfaceC5358d interfaceC5358d, InterfaceC5361g interfaceC5361g, InterfaceC5358d interfaceC5358d2, InterfaceC5361g interfaceC5361g2, InterfaceC5510p interfaceC5510p, Object obj) {
            super(interfaceC5358d2, interfaceC5361g2);
            this.$completion = interfaceC5358d;
            this.$context = interfaceC5361g;
            this.$this_createCoroutineUnintercepted$inlined = interfaceC5510p;
            this.$receiver$inlined = obj;
        }

        @Override // p286h.p294k2.p301n.p302a.AbstractC5398a
        @InterfaceC5817e
        protected Object invokeSuspend(@InterfaceC5816d Object obj) {
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.label = 2;
                C5597r0.m22717b(obj);
                return obj;
            }
            this.label = 1;
            C5597r0.m22717b(obj);
            InterfaceC5510p interfaceC5510p = this.$this_createCoroutineUnintercepted$inlined;
            if (interfaceC5510p != null) {
                return ((InterfaceC5510p) C5560n1.m22586a(interfaceC5510p, 2)).invoke(this.$receiver$inlined, this);
            }
            throw new C5226e1("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5816d
    /* renamed from: a */
    public static <T> InterfaceC5358d<C5715y1> m22112a(@InterfaceC5816d InterfaceC5506l<? super InterfaceC5358d<? super T>, ? extends Object> interfaceC5506l, @InterfaceC5816d InterfaceC5358d<? super T> interfaceC5358d) {
        C5544i0.m22546f(interfaceC5506l, "$this$createCoroutineUnintercepted");
        C5544i0.m22546f(interfaceC5358d, "completion");
        InterfaceC5358d<?> m22140a = C5405h.m22140a(interfaceC5358d);
        if (interfaceC5506l instanceof AbstractC5398a) {
            return ((AbstractC5398a) interfaceC5506l).create(m22140a);
        }
        InterfaceC5361g context = m22140a.getContext();
        if (context == C5363i.INSTANCE) {
            if (m22140a != null) {
                return new c(m22140a, m22140a, interfaceC5506l);
            }
            throw new C5226e1("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }
        if (m22140a != null) {
            return new d(m22140a, context, m22140a, context, interfaceC5506l);
        }
        throw new C5226e1("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    /* renamed from: b */
    private static final <T> Object m22114b(@InterfaceC5816d InterfaceC5506l<? super InterfaceC5358d<? super T>, ? extends Object> interfaceC5506l, InterfaceC5358d<? super T> interfaceC5358d) {
        if (interfaceC5506l != null) {
            return ((InterfaceC5506l) C5560n1.m22586a(interfaceC5506l, 1)).invoke(interfaceC5358d);
        }
        throw new C5226e1("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    /* renamed from: b */
    private static final <R, T> Object m22115b(@InterfaceC5816d InterfaceC5510p<? super R, ? super InterfaceC5358d<? super T>, ? extends Object> interfaceC5510p, R r, InterfaceC5358d<? super T> interfaceC5358d) {
        if (interfaceC5510p != null) {
            return ((InterfaceC5510p) C5560n1.m22586a(interfaceC5510p, 2)).invoke(r, interfaceC5358d);
        }
        throw new C5226e1("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5816d
    /* renamed from: a */
    public static <R, T> InterfaceC5358d<C5715y1> m22113a(@InterfaceC5816d InterfaceC5510p<? super R, ? super InterfaceC5358d<? super T>, ? extends Object> interfaceC5510p, R r, @InterfaceC5816d InterfaceC5358d<? super T> interfaceC5358d) {
        C5544i0.m22546f(interfaceC5510p, "$this$createCoroutineUnintercepted");
        C5544i0.m22546f(interfaceC5358d, "completion");
        InterfaceC5358d<?> m22140a = C5405h.m22140a(interfaceC5358d);
        if (interfaceC5510p instanceof AbstractC5398a) {
            return ((AbstractC5398a) interfaceC5510p).create(r, m22140a);
        }
        InterfaceC5361g context = m22140a.getContext();
        if (context == C5363i.INSTANCE) {
            if (m22140a != null) {
                return new e(m22140a, m22140a, interfaceC5510p, r);
            }
            throw new C5226e1("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }
        if (m22140a != null) {
            return new f(m22140a, context, m22140a, context, interfaceC5510p, r);
        }
        throw new C5226e1("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5816d
    /* renamed from: a */
    public static <T> InterfaceC5358d<T> m22110a(@InterfaceC5816d InterfaceC5358d<? super T> interfaceC5358d) {
        InterfaceC5358d<T> interfaceC5358d2;
        C5544i0.m22546f(interfaceC5358d, "$this$intercepted");
        AbstractC5401d abstractC5401d = !(interfaceC5358d instanceof AbstractC5401d) ? null : interfaceC5358d;
        return (abstractC5401d == null || (interfaceC5358d2 = (InterfaceC5358d<T>) abstractC5401d.intercepted()) == null) ? interfaceC5358d : interfaceC5358d2;
    }

    @InterfaceC5610t0(version = "1.3")
    /* renamed from: a */
    private static final <T> InterfaceC5358d<C5715y1> m22111a(InterfaceC5358d<? super T> interfaceC5358d, InterfaceC5506l<? super InterfaceC5358d<? super T>, ? extends Object> interfaceC5506l) {
        InterfaceC5361g context = interfaceC5358d.getContext();
        if (context == C5363i.INSTANCE) {
            if (interfaceC5358d != null) {
                return new a(interfaceC5506l, interfaceC5358d, interfaceC5358d);
            }
            throw new C5226e1("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }
        if (interfaceC5358d != null) {
            return new b(interfaceC5506l, interfaceC5358d, context, interfaceC5358d, context);
        }
        throw new C5226e1("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
    }
}
