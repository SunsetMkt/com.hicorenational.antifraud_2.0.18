package com.bumptech.glide.p137r;

import android.graphics.drawable.Drawable;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.EnumC1587a;
import com.bumptech.glide.load.p118p.C1672q;
import com.bumptech.glide.p137r.p138l.InterfaceC1847o;
import com.bumptech.glide.p137r.p138l.InterfaceC1848p;
import com.bumptech.glide.p137r.p139m.InterfaceC1856f;
import com.bumptech.glide.util.C1878l;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: RequestFutureTarget.java */
/* renamed from: com.bumptech.glide.r.f */
/* loaded from: classes.dex */
public class C1827f<R> implements InterfaceFutureC1824c<R>, InterfaceC1828g<R> {

    /* renamed from: k */
    private static final a f5314k = new a();

    /* renamed from: a */
    private final int f5315a;

    /* renamed from: b */
    private final int f5316b;

    /* renamed from: c */
    private final boolean f5317c;

    /* renamed from: d */
    private final a f5318d;

    /* renamed from: e */
    @Nullable
    @GuardedBy("this")
    private R f5319e;

    /* renamed from: f */
    @Nullable
    @GuardedBy("this")
    private InterfaceC1825d f5320f;

    /* renamed from: g */
    @GuardedBy("this")
    private boolean f5321g;

    /* renamed from: h */
    @GuardedBy("this")
    private boolean f5322h;

    /* renamed from: i */
    @GuardedBy("this")
    private boolean f5323i;

    /* renamed from: j */
    @Nullable
    @GuardedBy("this")
    private C1672q f5324j;

    /* compiled from: RequestFutureTarget.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.r.f$a */
    static class a {
        a() {
        }

        /* renamed from: a */
        void m4819a(Object obj, long j2) throws InterruptedException {
            obj.wait(j2);
        }

        /* renamed from: a */
        void m4818a(Object obj) {
            obj.notifyAll();
        }
    }

    public C1827f(int i2, int i3) {
        this(i2, i3, true, f5314k);
    }

    @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
    /* renamed from: a */
    public synchronized void mo3707a(@Nullable InterfaceC1825d interfaceC1825d) {
        this.f5320f = interfaceC1825d;
    }

    @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
    /* renamed from: a */
    public void mo3708a(@NonNull InterfaceC1847o interfaceC1847o) {
    }

    @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
    /* renamed from: b */
    public void mo3710b(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
    /* renamed from: b */
    public void mo3711b(@NonNull InterfaceC1847o interfaceC1847o) {
        interfaceC1847o.mo4867a(this.f5315a, this.f5316b);
    }

    @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
    /* renamed from: c */
    public void mo3712c(@Nullable Drawable drawable) {
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        InterfaceC1825d interfaceC1825d;
        synchronized (this) {
            if (isDone()) {
                return false;
            }
            this.f5321g = true;
            this.f5318d.m4818a(this);
            if (z) {
                interfaceC1825d = this.f5320f;
                this.f5320f = null;
            } else {
                interfaceC1825d = null;
            }
            if (interfaceC1825d != null) {
                interfaceC1825d.clear();
            }
            return true;
        }
    }

    @Override // java.util.concurrent.Future
    public R get() throws InterruptedException, ExecutionException {
        try {
            return m4815a((Long) null);
        } catch (TimeoutException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        return this.f5321g;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        boolean z;
        if (!this.f5321g && !this.f5322h) {
            z = this.f5323i;
        }
        return z;
    }

    @Override // com.bumptech.glide.manager.InterfaceC1795i
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.InterfaceC1795i
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.InterfaceC1795i
    public void onStop() {
    }

    C1827f(int i2, int i3, boolean z, a aVar) {
        this.f5315a = i2;
        this.f5316b = i3;
        this.f5317c = z;
        this.f5318d = aVar;
    }

    @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
    @Nullable
    /* renamed from: a */
    public synchronized InterfaceC1825d mo3705a() {
        return this.f5320f;
    }

    @Override // java.util.concurrent.Future
    public R get(long j2, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return m4815a(Long.valueOf(timeUnit.toMillis(j2)));
    }

    @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
    /* renamed from: a */
    public synchronized void mo3706a(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
    /* renamed from: a */
    public synchronized void mo3709a(@NonNull R r, @Nullable InterfaceC1856f<? super R> interfaceC1856f) {
    }

    /* renamed from: a */
    private synchronized R m4815a(Long l2) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.f5317c && !isDone()) {
            C1878l.m5003a();
        }
        if (!this.f5321g) {
            if (!this.f5323i) {
                if (this.f5322h) {
                    return this.f5319e;
                }
                if (l2 == null) {
                    this.f5318d.m4819a(this, 0L);
                } else if (l2.longValue() > 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long longValue = l2.longValue() + currentTimeMillis;
                    while (!isDone() && currentTimeMillis < longValue) {
                        this.f5318d.m4819a(this, longValue - currentTimeMillis);
                        currentTimeMillis = System.currentTimeMillis();
                    }
                }
                if (!Thread.interrupted()) {
                    if (!this.f5323i) {
                        if (!this.f5321g) {
                            if (this.f5322h) {
                                return this.f5319e;
                            }
                            throw new TimeoutException();
                        }
                        throw new CancellationException();
                    }
                    throw new ExecutionException(this.f5324j);
                }
                throw new InterruptedException();
            }
            throw new ExecutionException(this.f5324j);
        }
        throw new CancellationException();
    }

    @Override // com.bumptech.glide.p137r.InterfaceC1828g
    /* renamed from: a */
    public synchronized boolean mo4816a(@Nullable C1672q c1672q, Object obj, InterfaceC1848p<R> interfaceC1848p, boolean z) {
        this.f5323i = true;
        this.f5324j = c1672q;
        this.f5318d.m4818a(this);
        return false;
    }

    @Override // com.bumptech.glide.p137r.InterfaceC1828g
    /* renamed from: a */
    public synchronized boolean mo4817a(R r, Object obj, InterfaceC1848p<R> interfaceC1848p, EnumC1587a enumC1587a, boolean z) {
        this.f5322h = true;
        this.f5319e = r;
        this.f5318d.m4818a(this);
        return false;
    }
}
