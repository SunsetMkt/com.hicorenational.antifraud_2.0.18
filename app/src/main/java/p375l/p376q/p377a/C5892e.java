package p375l.p376q.p377a;

import javax.annotation.Nullable;
import p375l.C5884m;

/* compiled from: Result.java */
/* renamed from: l.q.a.e */
/* loaded from: classes2.dex */
public final class C5892e<T> {

    /* renamed from: a */
    @Nullable
    private final C5884m<T> f21343a;

    /* renamed from: b */
    @Nullable
    private final Throwable f21344b;

    private C5892e(@Nullable C5884m<T> c5884m, @Nullable Throwable th) {
        this.f21343a = c5884m;
        this.f21344b = th;
    }

    /* renamed from: a */
    public static <T> C5892e<T> m24862a(Throwable th) {
        if (th != null) {
            return new C5892e<>(null, th);
        }
        throw new NullPointerException("error == null");
    }

    /* renamed from: b */
    public boolean m24865b() {
        return this.f21344b != null;
    }

    @Nullable
    /* renamed from: c */
    public C5884m<T> m24866c() {
        return this.f21343a;
    }

    /* renamed from: a */
    public static <T> C5892e<T> m24863a(C5884m<T> c5884m) {
        if (c5884m != null) {
            return new C5892e<>(c5884m, null);
        }
        throw new NullPointerException("response == null");
    }

    @Nullable
    /* renamed from: a */
    public Throwable m24864a() {
        return this.f21344b;
    }
}
