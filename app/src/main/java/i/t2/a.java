package i.t2;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import i.q2.s.q;
import i.q2.t.i0;
import i.w2.m;
import i.y;
import i.y1;

/* JADX INFO: compiled from: Delegates.kt */
/* JADX INFO: loaded from: classes2.dex */
@y(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0000\u0010\u0005*\u00020\u0001J}\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052Q\b\u0004\u0010\b\u001aK\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u0011H\u0005\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u0011H\u0005\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\tH\u0086\b\u00a2\u0006\u0002\u0010\u0011J}\u0010\u0012\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052Q\b\u0004\u0010\b\u001aK\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u0011H\u0005\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u0011H\u0005\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00130\tH\u0086\b\u00a2\u0006\u0002\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lkotlin/properties/Delegates;", "", "()V", "notNull", "Lkotlin/properties/ReadWriteProperty;", ExifInterface.GPS_DIRECTION_TRUE, "observable", "initialValue", "onChange", "Lkotlin/Function3;", "Lkotlin/reflect/KProperty;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "property", "oldValue", "newValue", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Lkotlin/properties/ReadWriteProperty;", "vetoable", "", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
public final class a {
    public static final a a = new a();

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: i.t2.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Delegates.kt */
    public static final class C0249a<T> extends c<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ q f12279b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f12280c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0249a(q qVar, Object obj, Object obj2) {
            super(obj2);
            this.f12279b = qVar;
            this.f12280c = obj;
        }

        @Override // i.t2.c
        protected void a(@j.c.a.d m<?> mVar, T t, T t2) {
            i0.f(mVar, "property");
            this.f12279b.invoke(mVar, t, t2);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Delegates.kt */
    public static final class b<T> extends c<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ q f12281b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f12282c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(q qVar, Object obj, Object obj2) {
            super(obj2);
            this.f12281b = qVar;
            this.f12282c = obj;
        }

        @Override // i.t2.c
        protected boolean b(@j.c.a.d m<?> mVar, T t, T t2) {
            i0.f(mVar, "property");
            return ((Boolean) this.f12281b.invoke(mVar, t, t2)).booleanValue();
        }
    }

    private a() {
    }

    @j.c.a.d
    public final <T> e<Object, T> a() {
        return new i.t2.b();
    }

    @j.c.a.d
    public final <T> e<Object, T> b(T t, @j.c.a.d q<? super m<?>, ? super T, ? super T, Boolean> qVar) {
        i0.f(qVar, "onChange");
        return new b(qVar, t, t);
    }

    @j.c.a.d
    public final <T> e<Object, T> a(T t, @j.c.a.d q<? super m<?>, ? super T, ? super T, y1> qVar) {
        i0.f(qVar, "onChange");
        return new C0249a(qVar, t, t);
    }
}
