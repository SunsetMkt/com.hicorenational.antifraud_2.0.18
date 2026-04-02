package m.q.a;

import javax.annotation.Nullable;
import m.m;

/* JADX INFO: compiled from: Result.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e<T> {

    @Nullable
    private final m<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final Throwable f12796b;

    private e(@Nullable m<T> mVar, @Nullable Throwable th) {
        this.a = mVar;
        this.f12796b = th;
    }

    public static <T> e<T> a(Throwable th) {
        if (th != null) {
            return new e<>(null, th);
        }
        throw new NullPointerException("error == null");
    }

    public boolean b() {
        return this.f12796b != null;
    }

    @Nullable
    public m<T> c() {
        return this.a;
    }

    public static <T> e<T> a(m<T> mVar) {
        if (mVar != null) {
            return new e<>(mVar, null);
        }
        throw new NullPointerException("response == null");
    }

    @Nullable
    public Throwable a() {
        return this.f12796b;
    }
}
