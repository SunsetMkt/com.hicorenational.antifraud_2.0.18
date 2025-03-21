package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.C1584j;
import com.bumptech.glide.ComponentCallbacks2C1576b;
import com.bumptech.glide.ComponentCallbacks2C1585k;
import com.bumptech.glide.load.InterfaceC1593g;
import com.bumptech.glide.load.InterfaceC1600n;
import com.bumptech.glide.load.p118p.AbstractC1665j;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e;
import com.bumptech.glide.p134o.InterfaceC1804a;
import com.bumptech.glide.p137r.AbstractC1822a;
import com.bumptech.glide.p137r.C1829h;
import com.bumptech.glide.p137r.p138l.AbstractC1837e;
import com.bumptech.glide.p137r.p138l.InterfaceC1848p;
import com.bumptech.glide.p137r.p139m.InterfaceC1856f;
import com.bumptech.glide.p140s.C1866e;
import com.bumptech.glide.util.C1876j;
import com.bumptech.glide.util.C1878l;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GifFrameLoader.java */
/* renamed from: com.bumptech.glide.load.resource.gif.f */
/* loaded from: classes.dex */
class C1775f {

    /* renamed from: a */
    private final InterfaceC1804a f5018a;

    /* renamed from: b */
    private final Handler f5019b;

    /* renamed from: c */
    private final List<b> f5020c;

    /* renamed from: d */
    final ComponentCallbacks2C1585k f5021d;

    /* renamed from: e */
    private final InterfaceC1626e f5022e;

    /* renamed from: f */
    private boolean f5023f;

    /* renamed from: g */
    private boolean f5024g;

    /* renamed from: h */
    private boolean f5025h;

    /* renamed from: i */
    private C1584j<Bitmap> f5026i;

    /* renamed from: j */
    private a f5027j;

    /* renamed from: k */
    private boolean f5028k;

    /* renamed from: l */
    private a f5029l;

    /* renamed from: m */
    private Bitmap f5030m;

    /* renamed from: n */
    private InterfaceC1600n<Bitmap> f5031n;

    /* renamed from: o */
    private a f5032o;

    /* renamed from: p */
    @Nullable
    private d f5033p;

    /* renamed from: q */
    private int f5034q;

    /* renamed from: r */
    private int f5035r;

    /* renamed from: s */
    private int f5036s;

    /* compiled from: GifFrameLoader.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.resource.gif.f$a */
    static class a extends AbstractC1837e<Bitmap> {

        /* renamed from: d */
        private final Handler f5037d;

        /* renamed from: e */
        final int f5038e;

        /* renamed from: f */
        private final long f5039f;

        /* renamed from: g */
        private Bitmap f5040g;

        a(Handler handler, int i2, long j2) {
            this.f5037d = handler;
            this.f5038e = i2;
            this.f5039f = j2;
        }

        @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
        /* renamed from: a */
        public /* bridge */ /* synthetic */ void mo3709a(@NonNull Object obj, @Nullable InterfaceC1856f interfaceC1856f) {
            m4493a((Bitmap) obj, (InterfaceC1856f<? super Bitmap>) interfaceC1856f);
        }

        /* renamed from: b */
        Bitmap m4494b() {
            return this.f5040g;
        }

        @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
        /* renamed from: c */
        public void mo3712c(@Nullable Drawable drawable) {
            this.f5040g = null;
        }

        /* renamed from: a */
        public void m4493a(@NonNull Bitmap bitmap, @Nullable InterfaceC1856f<? super Bitmap> interfaceC1856f) {
            this.f5040g = bitmap;
            this.f5037d.sendMessageAtTime(this.f5037d.obtainMessage(1, this), this.f5039f);
        }
    }

    /* compiled from: GifFrameLoader.java */
    /* renamed from: com.bumptech.glide.load.resource.gif.f$b */
    public interface b {
        /* renamed from: a */
        void mo4446a();
    }

    /* compiled from: GifFrameLoader.java */
    /* renamed from: com.bumptech.glide.load.resource.gif.f$c */
    private class c implements Handler.Callback {

        /* renamed from: b */
        static final int f5041b = 1;

        /* renamed from: c */
        static final int f5042c = 2;

        c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                C1775f.this.m4479a((a) message.obj);
                return true;
            }
            if (i2 != 2) {
                return false;
            }
            C1775f.this.f5021d.m3783a((InterfaceC1848p<?>) message.obj);
            return false;
        }
    }

    /* compiled from: GifFrameLoader.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.resource.gif.f$d */
    interface d {
        /* renamed from: a */
        void m4495a();
    }

    C1775f(ComponentCallbacks2C1576b componentCallbacks2C1576b, InterfaceC1804a interfaceC1804a, int i2, int i3, InterfaceC1600n<Bitmap> interfaceC1600n, Bitmap bitmap) {
        this(componentCallbacks2C1576b.m3660d(), ComponentCallbacks2C1576b.m3649e(componentCallbacks2C1576b.m3662f()), interfaceC1804a, null, m4471a(ComponentCallbacks2C1576b.m3649e(componentCallbacks2C1576b.m3662f()), i2, i3), interfaceC1600n, bitmap);
    }

    /* renamed from: m */
    private static InterfaceC1593g m4472m() {
        return new C1866e(Double.valueOf(Math.random()));
    }

    /* renamed from: n */
    private void m4473n() {
        if (!this.f5023f || this.f5024g) {
            return;
        }
        if (this.f5025h) {
            C1876j.m4989a(this.f5032o == null, "Pending target must be null when starting from the first frame");
            this.f5018a.mo4645f();
            this.f5025h = false;
        }
        a aVar = this.f5032o;
        if (aVar != null) {
            this.f5032o = null;
            m4479a(aVar);
            return;
        }
        this.f5024g = true;
        long uptimeMillis = SystemClock.uptimeMillis() + this.f5018a.mo4643d();
        this.f5018a.mo4641b();
        this.f5029l = new a(this.f5019b, this.f5018a.mo4646g(), uptimeMillis);
        this.f5026i.mo3763a((AbstractC1822a<?>) C1829h.m4832b(m4472m())).mo3718a((Object) this.f5018a).m3773b((C1584j<Bitmap>) this.f5029l);
    }

    /* renamed from: o */
    private void m4474o() {
        Bitmap bitmap = this.f5030m;
        if (bitmap != null) {
            this.f5022e.mo3924a(bitmap);
            this.f5030m = null;
        }
    }

    /* renamed from: p */
    private void m4475p() {
        if (this.f5023f) {
            return;
        }
        this.f5023f = true;
        this.f5028k = false;
        m4473n();
    }

    /* renamed from: q */
    private void m4476q() {
        this.f5023f = false;
    }

    /* renamed from: a */
    void m4478a(InterfaceC1600n<Bitmap> interfaceC1600n, Bitmap bitmap) {
        this.f5031n = (InterfaceC1600n) C1876j.m4985a(interfaceC1600n);
        this.f5030m = (Bitmap) C1876j.m4985a(bitmap);
        this.f5026i = this.f5026i.mo3763a((AbstractC1822a<?>) new C1829h().m4764b(interfaceC1600n));
        this.f5034q = C1878l.m4995a(bitmap);
        this.f5035r = bitmap.getWidth();
        this.f5036s = bitmap.getHeight();
    }

    /* renamed from: b */
    void m4482b(b bVar) {
        this.f5020c.remove(bVar);
        if (this.f5020c.isEmpty()) {
            m4476q();
        }
    }

    /* renamed from: c */
    Bitmap m4483c() {
        a aVar = this.f5027j;
        return aVar != null ? aVar.m4494b() : this.f5030m;
    }

    /* renamed from: d */
    int m4484d() {
        a aVar = this.f5027j;
        if (aVar != null) {
            return aVar.f5038e;
        }
        return -1;
    }

    /* renamed from: e */
    Bitmap m4485e() {
        return this.f5030m;
    }

    /* renamed from: f */
    int m4486f() {
        return this.f5018a.mo4642c();
    }

    /* renamed from: g */
    InterfaceC1600n<Bitmap> m4487g() {
        return this.f5031n;
    }

    /* renamed from: h */
    int m4488h() {
        return this.f5036s;
    }

    /* renamed from: i */
    int m4489i() {
        return this.f5018a.mo4650k();
    }

    /* renamed from: j */
    int m4490j() {
        return this.f5018a.mo4649j() + this.f5034q;
    }

    /* renamed from: k */
    int m4491k() {
        return this.f5035r;
    }

    /* renamed from: l */
    void m4492l() {
        C1876j.m4989a(!this.f5023f, "Can't restart a running animation");
        this.f5025h = true;
        a aVar = this.f5032o;
        if (aVar != null) {
            this.f5021d.m3783a((InterfaceC1848p<?>) aVar);
            this.f5032o = null;
        }
    }

    @VisibleForTesting
    void setOnEveryFrameReadyListener(@Nullable d dVar) {
        this.f5033p = dVar;
    }

    /* renamed from: b */
    ByteBuffer m4481b() {
        return this.f5018a.mo4644e().asReadOnlyBuffer();
    }

    C1775f(InterfaceC1626e interfaceC1626e, ComponentCallbacks2C1585k componentCallbacks2C1585k, InterfaceC1804a interfaceC1804a, Handler handler, C1584j<Bitmap> c1584j, InterfaceC1600n<Bitmap> interfaceC1600n, Bitmap bitmap) {
        this.f5020c = new ArrayList();
        this.f5021d = componentCallbacks2C1585k;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.f5022e = interfaceC1626e;
        this.f5019b = handler;
        this.f5026i = c1584j;
        this.f5018a = interfaceC1804a;
        m4478a(interfaceC1600n, bitmap);
    }

    /* renamed from: a */
    void m4480a(b bVar) {
        if (!this.f5028k) {
            if (!this.f5020c.contains(bVar)) {
                boolean isEmpty = this.f5020c.isEmpty();
                this.f5020c.add(bVar);
                if (isEmpty) {
                    m4475p();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
    }

    /* renamed from: a */
    void m4477a() {
        this.f5020c.clear();
        m4474o();
        m4476q();
        a aVar = this.f5027j;
        if (aVar != null) {
            this.f5021d.m3783a((InterfaceC1848p<?>) aVar);
            this.f5027j = null;
        }
        a aVar2 = this.f5029l;
        if (aVar2 != null) {
            this.f5021d.m3783a((InterfaceC1848p<?>) aVar2);
            this.f5029l = null;
        }
        a aVar3 = this.f5032o;
        if (aVar3 != null) {
            this.f5021d.m3783a((InterfaceC1848p<?>) aVar3);
            this.f5032o = null;
        }
        this.f5018a.clear();
        this.f5028k = true;
    }

    @VisibleForTesting
    /* renamed from: a */
    void m4479a(a aVar) {
        d dVar = this.f5033p;
        if (dVar != null) {
            dVar.m4495a();
        }
        this.f5024g = false;
        if (this.f5028k) {
            this.f5019b.obtainMessage(2, aVar).sendToTarget();
            return;
        }
        if (!this.f5023f) {
            this.f5032o = aVar;
            return;
        }
        if (aVar.m4494b() != null) {
            m4474o();
            a aVar2 = this.f5027j;
            this.f5027j = aVar;
            for (int size = this.f5020c.size() - 1; size >= 0; size--) {
                this.f5020c.get(size).mo4446a();
            }
            if (aVar2 != null) {
                this.f5019b.obtainMessage(2, aVar2).sendToTarget();
            }
        }
        m4473n();
    }

    /* renamed from: a */
    private static C1584j<Bitmap> m4471a(ComponentCallbacks2C1585k componentCallbacks2C1585k, int i2, int i3) {
        return componentCallbacks2C1585k.m3786b().mo3763a((AbstractC1822a<?>) C1829h.m4834b(AbstractC1665j.f4538b).m4772c(true).m4767b(true).m4742a(i2, i3));
    }
}
