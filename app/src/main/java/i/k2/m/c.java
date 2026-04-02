package i.k2.m;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.open.SocialConstants;
import i.e1;
import i.k2.g;
import i.k2.i;
import i.k2.n.a.h;
import i.k2.n.a.j;
import i.q2.s.l;
import i.q2.s.p;
import i.q2.t.i0;
import i.q2.t.n1;
import i.r0;
import i.t0;
import i.y;
import i.y1;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: IntrinsicsJvm.kt */
/* JADX INFO: loaded from: classes2.dex */
@y(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aF\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\u001c\b\u0004\u0010\u0005\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0083\b\u00a2\u0006\u0002\b\b\u001aD\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\n\u001a]\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0003*#\b\u0001\u0012\u0004\u0012\u0002H\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u00a2\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u0002H\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000f\u001a\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007\u001aA\u0010\u0011\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0003*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012\u001aZ\u0010\u0011\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0003*#\b\u0001\u0012\u0004\u0012\u0002H\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u00a2\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u0002H\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"createCoroutineFromSuspendFunction", "Lkotlin/coroutines/Continuation;", "", ExifInterface.GPS_DIRECTION_TRUE, "completion", "block", "Lkotlin/Function1;", "", "createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt", "createCoroutineUnintercepted", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", SocialConstants.PARAM_RECEIVER, "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "intercepted", "startCoroutineUninterceptedOrReturn", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 5, mv = {1, 1, 16}, xi = 1, xs = "kotlin/coroutines/intrinsics/IntrinsicsKt")
public class c {

    /* JADX INFO: compiled from: IntrinsicsJvm.kt */
    public static final class a extends j {
        final /* synthetic */ l $block;
        final /* synthetic */ i.k2.d $completion;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(l lVar, i.k2.d dVar, i.k2.d dVar2) {
            super(dVar2);
            this.$block = lVar;
            this.$completion = dVar;
        }

        @Override // i.k2.n.a.a
        @j.c.a.e
        protected Object invokeSuspend(@j.c.a.d Object obj) {
            int i2 = this.label;
            if (i2 == 0) {
                this.label = 1;
                r0.b(obj);
                return this.$block.invoke(this);
            }
            if (i2 != 1) {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
            this.label = 2;
            r0.b(obj);
            return obj;
        }
    }

    /* JADX INFO: compiled from: IntrinsicsJvm.kt */
    public static final class b extends i.k2.n.a.d {
        final /* synthetic */ l $block;
        final /* synthetic */ i.k2.d $completion;
        final /* synthetic */ g $context;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(l lVar, i.k2.d dVar, g gVar, i.k2.d dVar2, g gVar2) {
            super(dVar2, gVar2);
            this.$block = lVar;
            this.$completion = dVar;
            this.$context = gVar;
        }

        @Override // i.k2.n.a.a
        @j.c.a.e
        protected Object invokeSuspend(@j.c.a.d Object obj) {
            int i2 = this.label;
            if (i2 == 0) {
                this.label = 1;
                r0.b(obj);
                return this.$block.invoke(this);
            }
            if (i2 != 1) {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
            this.label = 2;
            r0.b(obj);
            return obj;
        }
    }

    /* JADX INFO: renamed from: i.k2.m.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IntrinsicsJvm.kt */
    public static final class C0247c extends j {
        final /* synthetic */ i.k2.d $completion;
        final /* synthetic */ l $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0247c(i.k2.d dVar, i.k2.d dVar2, l lVar) {
            super(dVar2);
            this.$completion = dVar;
            this.$this_createCoroutineUnintercepted$inlined = lVar;
        }

        @Override // i.k2.n.a.a
        @j.c.a.e
        protected Object invokeSuspend(@j.c.a.d Object obj) {
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.label = 2;
                r0.b(obj);
                return obj;
            }
            this.label = 1;
            r0.b(obj);
            l lVar = this.$this_createCoroutineUnintercepted$inlined;
            if (lVar != null) {
                return ((l) n1.a(lVar, 1)).invoke(this);
            }
            throw new e1("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
    }

    /* JADX INFO: compiled from: IntrinsicsJvm.kt */
    public static final class d extends i.k2.n.a.d {
        final /* synthetic */ i.k2.d $completion;
        final /* synthetic */ g $context;
        final /* synthetic */ l $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(i.k2.d dVar, g gVar, i.k2.d dVar2, g gVar2, l lVar) {
            super(dVar2, gVar2);
            this.$completion = dVar;
            this.$context = gVar;
            this.$this_createCoroutineUnintercepted$inlined = lVar;
        }

        @Override // i.k2.n.a.a
        @j.c.a.e
        protected Object invokeSuspend(@j.c.a.d Object obj) {
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.label = 2;
                r0.b(obj);
                return obj;
            }
            this.label = 1;
            r0.b(obj);
            l lVar = this.$this_createCoroutineUnintercepted$inlined;
            if (lVar != null) {
                return ((l) n1.a(lVar, 1)).invoke(this);
            }
            throw new e1("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
    }

    /* JADX INFO: compiled from: IntrinsicsJvm.kt */
    public static final class e extends j {
        final /* synthetic */ i.k2.d $completion;
        final /* synthetic */ Object $receiver$inlined;
        final /* synthetic */ p $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(i.k2.d dVar, i.k2.d dVar2, p pVar, Object obj) {
            super(dVar2);
            this.$completion = dVar;
            this.$this_createCoroutineUnintercepted$inlined = pVar;
            this.$receiver$inlined = obj;
        }

        @Override // i.k2.n.a.a
        @j.c.a.e
        protected Object invokeSuspend(@j.c.a.d Object obj) {
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.label = 2;
                r0.b(obj);
                return obj;
            }
            this.label = 1;
            r0.b(obj);
            p pVar = this.$this_createCoroutineUnintercepted$inlined;
            if (pVar != null) {
                return ((p) n1.a(pVar, 2)).invoke(this.$receiver$inlined, this);
            }
            throw new e1("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
    }

    /* JADX INFO: compiled from: IntrinsicsJvm.kt */
    public static final class f extends i.k2.n.a.d {
        final /* synthetic */ i.k2.d $completion;
        final /* synthetic */ g $context;
        final /* synthetic */ Object $receiver$inlined;
        final /* synthetic */ p $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(i.k2.d dVar, g gVar, i.k2.d dVar2, g gVar2, p pVar, Object obj) {
            super(dVar2, gVar2);
            this.$completion = dVar;
            this.$context = gVar;
            this.$this_createCoroutineUnintercepted$inlined = pVar;
            this.$receiver$inlined = obj;
        }

        @Override // i.k2.n.a.a
        @j.c.a.e
        protected Object invokeSuspend(@j.c.a.d Object obj) {
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.label = 2;
                r0.b(obj);
                return obj;
            }
            this.label = 1;
            r0.b(obj);
            p pVar = this.$this_createCoroutineUnintercepted$inlined;
            if (pVar != null) {
                return ((p) n1.a(pVar, 2)).invoke(this.$receiver$inlined, this);
            }
            throw new e1("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @t0(version = "1.3")
    @j.c.a.d
    public static <T> i.k2.d<y1> a(@j.c.a.d l<? super i.k2.d<? super T>, ? extends Object> lVar, @j.c.a.d i.k2.d<? super T> dVar) {
        i0.f(lVar, "$this$createCoroutineUnintercepted");
        i0.f(dVar, "completion");
        i.k2.d<?> dVarA = h.a(dVar);
        if (lVar instanceof i.k2.n.a.a) {
            return ((i.k2.n.a.a) lVar).create(dVarA);
        }
        g context = dVarA.getContext();
        if (context == i.INSTANCE) {
            if (dVarA != null) {
                return new C0247c(dVarA, dVarA, lVar);
            }
            throw new e1("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }
        if (dVarA != null) {
            return new d(dVarA, context, dVarA, context, lVar);
        }
        throw new e1("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
    }

    @t0(version = "1.3")
    @i.m2.f
    private static final <T> Object b(@j.c.a.d l<? super i.k2.d<? super T>, ? extends Object> lVar, i.k2.d<? super T> dVar) {
        if (lVar != null) {
            return ((l) n1.a(lVar, 1)).invoke(dVar);
        }
        throw new e1("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }

    @t0(version = "1.3")
    @i.m2.f
    private static final <R, T> Object b(@j.c.a.d p<? super R, ? super i.k2.d<? super T>, ? extends Object> pVar, R r, i.k2.d<? super T> dVar) {
        if (pVar != null) {
            return ((p) n1.a(pVar, 2)).invoke(r, dVar);
        }
        throw new e1("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @t0(version = "1.3")
    @j.c.a.d
    public static <R, T> i.k2.d<y1> a(@j.c.a.d p<? super R, ? super i.k2.d<? super T>, ? extends Object> pVar, R r, @j.c.a.d i.k2.d<? super T> dVar) {
        i0.f(pVar, "$this$createCoroutineUnintercepted");
        i0.f(dVar, "completion");
        i.k2.d<?> dVarA = h.a(dVar);
        if (pVar instanceof i.k2.n.a.a) {
            return ((i.k2.n.a.a) pVar).create(r, dVarA);
        }
        g context = dVarA.getContext();
        if (context == i.INSTANCE) {
            if (dVarA != null) {
                return new e(dVarA, dVarA, pVar, r);
            }
            throw new e1("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }
        if (dVarA != null) {
            return new f(dVarA, context, dVarA, context, pVar, r);
        }
        throw new e1("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @t0(version = "1.3")
    @j.c.a.d
    public static <T> i.k2.d<T> a(@j.c.a.d i.k2.d<? super T> dVar) {
        i.k2.d<T> dVar2;
        i0.f(dVar, "$this$intercepted");
        i.k2.n.a.d dVar3 = (i.k2.n.a.d) (!(dVar instanceof i.k2.n.a.d) ? null : dVar);
        return (dVar3 == null || (dVar2 = (i.k2.d<T>) dVar3.intercepted()) == null) ? dVar : dVar2;
    }

    @t0(version = "1.3")
    private static final <T> i.k2.d<y1> a(i.k2.d<? super T> dVar, l<? super i.k2.d<? super T>, ? extends Object> lVar) {
        g context = dVar.getContext();
        if (context == i.INSTANCE) {
            if (dVar != null) {
                return new a(lVar, dVar, dVar);
            }
            throw new e1("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }
        if (dVar != null) {
            return new b(lVar, dVar, context, dVar, context);
        }
        throw new e1("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
    }
}
