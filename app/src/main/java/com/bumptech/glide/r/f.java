package com.bumptech.glide.r;

import android.graphics.drawable.Drawable;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.p.q;
import com.bumptech.glide.r.l.o;
import com.bumptech.glide.r.l.p;
import com.bumptech.glide.util.l;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: RequestFutureTarget.java */
/* JADX INFO: loaded from: classes.dex */
public class f<R> implements c<R>, g<R> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final a f3457k = new a();
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f3458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f3459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f3460d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    @GuardedBy("this")
    private R f3461e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    @GuardedBy("this")
    private d f3462f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @GuardedBy("this")
    private boolean f3463g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @GuardedBy("this")
    private boolean f3464h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @GuardedBy("this")
    private boolean f3465i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    @GuardedBy("this")
    private q f3466j;

    /* JADX INFO: compiled from: RequestFutureTarget.java */
    @VisibleForTesting
    static class a {
        a() {
        }

        void a(Object obj, long j2) throws InterruptedException {
            obj.wait(j2);
        }

        void a(Object obj) {
            obj.notifyAll();
        }
    }

    public f(int i2, int i3) {
        this(i2, i3, true, f3457k);
    }

    @Override // com.bumptech.glide.r.l.p
    public synchronized void a(@Nullable d dVar) {
        this.f3462f = dVar;
    }

    @Override // com.bumptech.glide.r.l.p
    public void a(@NonNull o oVar) {
    }

    @Override // com.bumptech.glide.r.l.p
    public void b(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.r.l.p
    public void b(@NonNull o oVar) {
        oVar.a(this.a, this.f3458b);
    }

    @Override // com.bumptech.glide.r.l.p
    public void c(@Nullable Drawable drawable) {
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        d dVar;
        synchronized (this) {
            if (isDone()) {
                return false;
            }
            this.f3463g = true;
            this.f3460d.a(this);
            if (z) {
                dVar = this.f3462f;
                this.f3462f = null;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                dVar.clear();
            }
            return true;
        }
    }

    @Override // java.util.concurrent.Future
    public R get() throws ExecutionException, InterruptedException {
        try {
            return a((Long) null);
        } catch (TimeoutException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        return this.f3463g;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0010  */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean isDone() {
        boolean z;
        if (this.f3463g || this.f3464h) {
            z = true;
        } else if (!this.f3465i) {
            z = false;
        }
        return z;
    }

    @Override // com.bumptech.glide.manager.i
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.i
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.i
    public void onStop() {
    }

    f(int i2, int i3, boolean z, a aVar) {
        this.a = i2;
        this.f3458b = i3;
        this.f3459c = z;
        this.f3460d = aVar;
    }

    @Override // com.bumptech.glide.r.l.p
    @Nullable
    public synchronized d a() {
        return this.f3462f;
    }

    @Override // java.util.concurrent.Future
    public R get(long j2, @NonNull TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return a(Long.valueOf(timeUnit.toMillis(j2)));
    }

    @Override // com.bumptech.glide.r.l.p
    public synchronized void a(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.r.l.p
    public synchronized void a(@NonNull R r, @Nullable com.bumptech.glide.r.m.f<? super R> fVar) {
    }

    private synchronized R a(Long l2) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.f3459c && !isDone()) {
            l.a();
        }
        if (!this.f3463g) {
            if (!this.f3465i) {
                if (this.f3464h) {
                    return this.f3461e;
                }
                if (l2 == null) {
                    this.f3460d.a(this, 0L);
                } else if (l2.longValue() > 0) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    long jLongValue = l2.longValue() + jCurrentTimeMillis;
                    while (!isDone() && jCurrentTimeMillis < jLongValue) {
                        this.f3460d.a(this, jLongValue - jCurrentTimeMillis);
                        jCurrentTimeMillis = System.currentTimeMillis();
                    }
                }
                if (!Thread.interrupted()) {
                    if (!this.f3465i) {
                        if (!this.f3463g) {
                            if (this.f3464h) {
                                return this.f3461e;
                            }
                            throw new TimeoutException();
                        }
                        throw new CancellationException();
                    }
                    throw new ExecutionException(this.f3466j);
                }
                throw new InterruptedException();
            }
            throw new ExecutionException(this.f3466j);
        }
        throw new CancellationException();
    }

    @Override // com.bumptech.glide.r.g
    public synchronized boolean a(@Nullable q qVar, Object obj, p<R> pVar, boolean z) {
        this.f3465i = true;
        this.f3466j = qVar;
        this.f3460d.a(this);
        return false;
    }

    @Override // com.bumptech.glide.r.g
    public synchronized boolean a(R r, Object obj, p<R> pVar, com.bumptech.glide.load.a aVar, boolean z) {
        this.f3464h = true;
        this.f3461e = r;
        this.f3460d.a(this);
        return false;
    }
}
