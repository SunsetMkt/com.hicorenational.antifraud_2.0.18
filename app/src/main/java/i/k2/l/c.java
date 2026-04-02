package i.k2.l;

import i.t0;

/* JADX INFO: compiled from: Coroutines.kt */
/* JADX INFO: loaded from: classes2.dex */
@t0(version = "1.1")
public interface c<T> {
    @j.c.a.d
    e getContext();

    void resume(T t);

    void resumeWithException(@j.c.a.d Throwable th);
}
