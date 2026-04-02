package i.k2.l.n;

import androidx.exifinterface.media.ExifInterface;
import bean.SurveyH5Bean;
import com.tencent.open.SocialConstants;
import i.e1;
import i.k2.l.e;
import i.m2.f;
import i.q2.s.l;
import i.q2.s.p;
import i.q2.t.i0;
import i.q2.t.n1;
import i.t0;
import i.y;
import i.y1;
import j.c.a.d;

/* JADX INFO: compiled from: IntrinsicsJvm.kt */
/* JADX INFO: loaded from: classes2.dex */
@y(bv = {1, 0, 3}, d1 = {"\u00002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a:\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u00072\u0010\b\u0004\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fH\u0082\b\u00a2\u0006\u0002\b\r\u001aD\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\"\u0004\b\u0000\u0010\t*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u0007H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010\u001a]\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\"\u0004\b\u0000\u0010\u0011\"\u0004\b\u0001\u0010\t*#\b\u0001\u0012\u0004\u0012\u0002H\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012\u00a2\u0006\u0002\b\u00132\u0006\u0010\u0014\u001a\u0002H\u00112\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u0007H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015\u001aA\u0010\u0016\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\t*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u0007H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017\u001aZ\u0010\u0016\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0011\"\u0004\b\u0001\u0010\t*#\b\u0001\u0012\u0004\u0012\u0002H\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012\u00a2\u0006\u0002\b\u00132\u0006\u0010\u0014\u001a\u0002H\u00112\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u0007H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018\"\u001a\u0010\u0000\u001a\u00020\u00018FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\t\u00a8\u0006\u0019"}, d2 = {"COROUTINE_SUSPENDED", "", "COROUTINE_SUSPENDED$annotations", "()V", "getCOROUTINE_SUSPENDED", "()Ljava/lang/Object;", "buildContinuationByInvokeCall", "Lkotlin/coroutines/experimental/Continuation;", "", ExifInterface.GPS_DIRECTION_TRUE, "completion", "block", "Lkotlin/Function0;", "buildContinuationByInvokeCall$IntrinsicsKt__IntrinsicsJvmKt", "createCoroutineUnchecked", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/experimental/Continuation;)Lkotlin/coroutines/experimental/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", SocialConstants.PARAM_RECEIVER, "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)Lkotlin/coroutines/experimental/Continuation;", "startCoroutineUninterceptedOrReturn", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "kotlin-stdlib-coroutines"}, k = 5, mv = {1, 1, 16}, xi = 1, xs = "kotlin/coroutines/experimental/intrinsics/IntrinsicsKt")
public class b {

    /* JADX INFO: compiled from: IntrinsicsJvm.kt */
    public static final class a implements i.k2.l.c<y1> {
        final /* synthetic */ i.k2.l.c a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ i.q2.s.a f12141b;

        public a(i.k2.l.c cVar, i.q2.s.a aVar) {
            this.a = cVar;
            this.f12141b = aVar;
        }

        @Override // i.k2.l.c
        /* JADX INFO: renamed from: a */
        public void resume(@d y1 y1Var) {
            i0.f(y1Var, SurveyH5Bean.VALUE);
            i.k2.l.c cVar = this.a;
            try {
                Object objInvoke = this.f12141b.invoke();
                if (objInvoke != b.b()) {
                    if (cVar == null) {
                        throw new e1("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
                    }
                    cVar.resume(objInvoke);
                }
            } catch (Throwable th) {
                cVar.resumeWithException(th);
            }
        }

        @Override // i.k2.l.c
        @d
        public e getContext() {
            return this.a.getContext();
        }

        @Override // i.k2.l.c
        public void resumeWithException(@d Throwable th) {
            i0.f(th, "exception");
            this.a.resumeWithException(th);
        }
    }

    /* JADX INFO: renamed from: i.k2.l.n.b$b */
    /* JADX INFO: compiled from: IntrinsicsJvm.kt */
    public static final class C0245b implements i.k2.l.c<y1> {
        final /* synthetic */ i.k2.l.c a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ l f12142b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ i.k2.l.c f12143c;

        public C0245b(i.k2.l.c cVar, l lVar, i.k2.l.c cVar2) {
            this.a = cVar;
            this.f12142b = lVar;
            this.f12143c = cVar2;
        }

        @Override // i.k2.l.c
        /* JADX INFO: renamed from: a */
        public void resume(@d y1 y1Var) {
            i0.f(y1Var, SurveyH5Bean.VALUE);
            i.k2.l.c cVar = this.a;
            try {
                l lVar = this.f12142b;
                if (lVar == null) {
                    throw new e1("null cannot be cast to non-null type (kotlin.coroutines.experimental.Continuation<T>) -> kotlin.Any?");
                }
                Object objInvoke = ((l) n1.a(lVar, 1)).invoke(this.f12143c);
                if (objInvoke != b.b()) {
                    if (cVar == null) {
                        throw new e1("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
                    }
                    cVar.resume(objInvoke);
                }
            } catch (Throwable th) {
                cVar.resumeWithException(th);
            }
        }

        @Override // i.k2.l.c
        @d
        public e getContext() {
            return this.a.getContext();
        }

        @Override // i.k2.l.c
        public void resumeWithException(@d Throwable th) {
            i0.f(th, "exception");
            this.a.resumeWithException(th);
        }
    }

    /* JADX INFO: compiled from: IntrinsicsJvm.kt */
    public static final class c implements i.k2.l.c<y1> {
        final /* synthetic */ i.k2.l.c a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ p f12144b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ Object f12145c;

        /* JADX INFO: renamed from: d */
        final /* synthetic */ i.k2.l.c f12146d;

        public c(i.k2.l.c cVar, p pVar, Object obj, i.k2.l.c cVar2) {
            this.a = cVar;
            this.f12144b = pVar;
            this.f12145c = obj;
            this.f12146d = cVar2;
        }

        @Override // i.k2.l.c
        /* JADX INFO: renamed from: a */
        public void resume(@d y1 y1Var) {
            i0.f(y1Var, SurveyH5Bean.VALUE);
            i.k2.l.c cVar = this.a;
            try {
                p pVar = this.f12144b;
                if (pVar == null) {
                    throw new e1("null cannot be cast to non-null type (R, kotlin.coroutines.experimental.Continuation<T>) -> kotlin.Any?");
                }
                Object objInvoke = ((p) n1.a(pVar, 2)).invoke(this.f12145c, this.f12146d);
                if (objInvoke != b.b()) {
                    if (cVar == null) {
                        throw new e1("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
                    }
                    cVar.resume(objInvoke);
                }
            } catch (Throwable th) {
                cVar.resumeWithException(th);
            }
        }

        @Override // i.k2.l.c
        @d
        public e getContext() {
            return this.a.getContext();
        }

        @Override // i.k2.l.c
        public void resumeWithException(@d Throwable th) {
            i0.f(th, "exception");
            this.a.resumeWithException(th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @t0(version = "1.1")
    @d
    public static <T> i.k2.l.c<y1> a(@d l<? super i.k2.l.c<? super T>, ? extends Object> lVar, @d i.k2.l.c<? super T> cVar) {
        i0.f(lVar, "$this$createCoroutineUnchecked");
        i0.f(cVar, "completion");
        if (!(lVar instanceof i.k2.l.o.a.a)) {
            return i.k2.l.o.a.b.a(cVar.getContext(), new C0245b(cVar, lVar, cVar));
        }
        i.k2.l.c<y1> cVarCreate = ((i.k2.l.o.a.a) lVar).create(cVar);
        if (cVarCreate != null) {
            return ((i.k2.l.o.a.a) cVarCreate).getFacade();
        }
        throw new e1("null cannot be cast to non-null type kotlin.coroutines.experimental.jvm.internal.CoroutineImpl");
    }

    @t0(version = "1.1")
    public static /* synthetic */ void a() {
    }

    @t0(version = "1.1")
    @f
    private static final <T> Object b(@d l<? super i.k2.l.c<? super T>, ? extends Object> lVar, i.k2.l.c<? super T> cVar) {
        if (lVar != null) {
            return ((l) n1.a(lVar, 1)).invoke(cVar);
        }
        throw new e1("null cannot be cast to non-null type (kotlin.coroutines.experimental.Continuation<T>) -> kotlin.Any?");
    }

    @t0(version = "1.1")
    @f
    private static final <R, T> Object b(@d p<? super R, ? super i.k2.l.c<? super T>, ? extends Object> pVar, R r, i.k2.l.c<? super T> cVar) {
        if (pVar != null) {
            return ((p) n1.a(pVar, 2)).invoke(r, cVar);
        }
        throw new e1("null cannot be cast to non-null type (R, kotlin.coroutines.experimental.Continuation<T>) -> kotlin.Any?");
    }

    @d
    public static Object b() {
        return i.k2.m.d.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @t0(version = "1.1")
    @d
    public static <R, T> i.k2.l.c<y1> a(@d p<? super R, ? super i.k2.l.c<? super T>, ? extends Object> pVar, R r, @d i.k2.l.c<? super T> cVar) {
        i0.f(pVar, "$this$createCoroutineUnchecked");
        i0.f(cVar, "completion");
        if (!(pVar instanceof i.k2.l.o.a.a)) {
            return i.k2.l.o.a.b.a(cVar.getContext(), new c(cVar, pVar, r, cVar));
        }
        i.k2.l.c<y1> cVarCreate = ((i.k2.l.o.a.a) pVar).create(r, cVar);
        if (cVarCreate != null) {
            return ((i.k2.l.o.a.a) cVarCreate).getFacade();
        }
        throw new e1("null cannot be cast to non-null type kotlin.coroutines.experimental.jvm.internal.CoroutineImpl");
    }

    private static final <T> i.k2.l.c<y1> a(i.k2.l.c<? super T> cVar, i.q2.s.a<? extends Object> aVar) {
        return i.k2.l.o.a.b.a(cVar.getContext(), new a(cVar, aVar));
    }
}
