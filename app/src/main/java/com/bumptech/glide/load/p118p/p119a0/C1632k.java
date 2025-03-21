package com.bumptech.glide.load.p118p.p119a0;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: LruBitmapPool.java */
/* renamed from: com.bumptech.glide.load.p.a0.k */
/* loaded from: classes.dex */
public class C1632k implements InterfaceC1626e {

    /* renamed from: k */
    private static final String f4303k = "LruBitmapPool";

    /* renamed from: l */
    private static final Bitmap.Config f4304l = Bitmap.Config.ARGB_8888;

    /* renamed from: a */
    private final InterfaceC1633l f4305a;

    /* renamed from: b */
    private final Set<Bitmap.Config> f4306b;

    /* renamed from: c */
    private final long f4307c;

    /* renamed from: d */
    private final a f4308d;

    /* renamed from: e */
    private long f4309e;

    /* renamed from: f */
    private long f4310f;

    /* renamed from: g */
    private int f4311g;

    /* renamed from: h */
    private int f4312h;

    /* renamed from: i */
    private int f4313i;

    /* renamed from: j */
    private int f4314j;

    /* compiled from: LruBitmapPool.java */
    /* renamed from: com.bumptech.glide.load.p.a0.k$a */
    private interface a {
        /* renamed from: a */
        void mo3966a(Bitmap bitmap);

        /* renamed from: b */
        void mo3967b(Bitmap bitmap);
    }

    /* compiled from: LruBitmapPool.java */
    /* renamed from: com.bumptech.glide.load.p.a0.k$b */
    private static final class b implements a {
        b() {
        }

        @Override // com.bumptech.glide.load.p118p.p119a0.C1632k.a
        /* renamed from: a */
        public void mo3966a(Bitmap bitmap) {
        }

        @Override // com.bumptech.glide.load.p118p.p119a0.C1632k.a
        /* renamed from: b */
        public void mo3967b(Bitmap bitmap) {
        }
    }

    /* compiled from: LruBitmapPool.java */
    /* renamed from: com.bumptech.glide.load.p.a0.k$c */
    private static class c implements a {

        /* renamed from: a */
        private final Set<Bitmap> f4315a = Collections.synchronizedSet(new HashSet());

        private c() {
        }

        @Override // com.bumptech.glide.load.p118p.p119a0.C1632k.a
        /* renamed from: a */
        public void mo3966a(Bitmap bitmap) {
            if (!this.f4315a.contains(bitmap)) {
                throw new IllegalStateException("Cannot remove bitmap not in tracker");
            }
            this.f4315a.remove(bitmap);
        }

        @Override // com.bumptech.glide.load.p118p.p119a0.C1632k.a
        /* renamed from: b */
        public void mo3967b(Bitmap bitmap) {
            if (!this.f4315a.contains(bitmap)) {
                this.f4315a.add(bitmap);
                return;
            }
            throw new IllegalStateException("Can't add already added bitmap: " + bitmap + " [" + bitmap.getWidth() + "x" + bitmap.getHeight() + "]");
        }
    }

    C1632k(long j2, InterfaceC1633l interfaceC1633l, Set<Bitmap.Config> set) {
        this.f4307c = j2;
        this.f4309e = j2;
        this.f4305a = interfaceC1633l;
        this.f4306b = set;
        this.f4308d = new b();
    }

    /* renamed from: g */
    private void m3957g() {
        if (Log.isLoggable(f4303k, 2)) {
            m3958h();
        }
    }

    /* renamed from: h */
    private void m3958h() {
        String str = "Hits=" + this.f4311g + ", misses=" + this.f4312h + ", puts=" + this.f4313i + ", evictions=" + this.f4314j + ", currentSize=" + this.f4310f + ", maxSize=" + this.f4309e + "\nStrategy=" + this.f4305a;
    }

    /* renamed from: i */
    private void m3959i() {
        m3951a(this.f4309e);
    }

    @TargetApi(26)
    /* renamed from: j */
    private static Set<Bitmap.Config> m3960j() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        if (Build.VERSION.SDK_INT >= 19) {
            hashSet.add(null);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* renamed from: k */
    private static InterfaceC1633l m3961k() {
        return Build.VERSION.SDK_INT >= 19 ? new C1636o() : new C1624c();
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e
    /* renamed from: a */
    public synchronized void mo3922a(float f2) {
        this.f4309e = Math.round(this.f4307c * f2);
        m3959i();
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e
    /* renamed from: b */
    public long mo3925b() {
        return this.f4309e;
    }

    /* renamed from: c */
    public long m3962c() {
        return this.f4314j;
    }

    /* renamed from: d */
    public long m3963d() {
        return this.f4310f;
    }

    /* renamed from: e */
    public long m3964e() {
        return this.f4311g;
    }

    /* renamed from: f */
    public long m3965f() {
        return this.f4312h;
    }

    @NonNull
    /* renamed from: c */
    private static Bitmap m3954c(int i2, int i3, @Nullable Bitmap.Config config) {
        if (config == null) {
            config = f4304l;
        }
        return Bitmap.createBitmap(i2, i3, config);
    }

    @Nullable
    /* renamed from: d */
    private synchronized Bitmap m3956d(int i2, int i3, @Nullable Bitmap.Config config) {
        Bitmap mo3910a;
        m3952a(config);
        mo3910a = this.f4305a.mo3910a(i2, i3, config != null ? config : f4304l);
        if (mo3910a == null) {
            if (Log.isLoggable(f4303k, 3)) {
                String str = "Missing bitmap=" + this.f4305a.mo3913b(i2, i3, config);
            }
            this.f4312h++;
        } else {
            this.f4311g++;
            this.f4310f -= this.f4305a.mo3912b(mo3910a);
            this.f4308d.mo3966a(mo3910a);
            m3955c(mo3910a);
        }
        if (Log.isLoggable(f4303k, 2)) {
            String str2 = "Get bitmap=" + this.f4305a.mo3913b(i2, i3, config);
        }
        m3957g();
        return mo3910a;
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e
    @NonNull
    /* renamed from: b */
    public Bitmap mo3926b(int i2, int i3, Bitmap.Config config) {
        Bitmap m3956d = m3956d(i2, i3, config);
        return m3956d == null ? m3954c(i2, i3, config) : m3956d;
    }

    /* renamed from: c */
    private static void m3955c(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        m3953b(bitmap);
    }

    @TargetApi(19)
    /* renamed from: b */
    private static void m3953b(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            bitmap.setPremultiplied(true);
        }
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e
    /* renamed from: a */
    public synchronized void mo3924a(Bitmap bitmap) {
        try {
            if (bitmap != null) {
                if (!bitmap.isRecycled()) {
                    if (bitmap.isMutable() && this.f4305a.mo3912b(bitmap) <= this.f4309e && this.f4306b.contains(bitmap.getConfig())) {
                        int mo3912b = this.f4305a.mo3912b(bitmap);
                        this.f4305a.mo3911a(bitmap);
                        this.f4308d.mo3967b(bitmap);
                        this.f4313i++;
                        this.f4310f += mo3912b;
                        if (Log.isLoggable(f4303k, 2)) {
                            String str = "Put bitmap in pool=" + this.f4305a.mo3914c(bitmap);
                        }
                        m3957g();
                        m3959i();
                        return;
                    }
                    if (Log.isLoggable(f4303k, 2)) {
                        String str2 = "Reject bitmap from pool, bitmap: " + this.f4305a.mo3914c(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f4306b.contains(bitmap.getConfig());
                    }
                    bitmap.recycle();
                    return;
                }
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            throw new NullPointerException("Bitmap must not be null");
        } catch (Throwable th) {
            throw th;
        }
    }

    public C1632k(long j2) {
        this(j2, m3961k(), m3960j());
    }

    public C1632k(long j2, Set<Bitmap.Config> set) {
        this(j2, m3961k(), set);
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e
    @NonNull
    /* renamed from: a */
    public Bitmap mo3920a(int i2, int i3, Bitmap.Config config) {
        Bitmap m3956d = m3956d(i2, i3, config);
        if (m3956d != null) {
            m3956d.eraseColor(0);
            return m3956d;
        }
        return m3954c(i2, i3, config);
    }

    @TargetApi(26)
    /* renamed from: a */
    private static void m3952a(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e
    /* renamed from: a */
    public void mo3921a() {
        Log.isLoggable(f4303k, 3);
        m3951a(0L);
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e
    @SuppressLint({"InlinedApi"})
    /* renamed from: a */
    public void mo3923a(int i2) {
        if (Log.isLoggable(f4303k, 3)) {
            String str = "trimMemory, level=" + i2;
        }
        if (i2 >= 40 || (Build.VERSION.SDK_INT >= 23 && i2 >= 20)) {
            mo3921a();
        } else if (i2 >= 20 || i2 == 15) {
            m3951a(mo3925b() / 2);
        }
    }

    /* renamed from: a */
    private synchronized void m3951a(long j2) {
        while (this.f4310f > j2) {
            Bitmap removeLast = this.f4305a.removeLast();
            if (removeLast == null) {
                if (Log.isLoggable(f4303k, 5)) {
                    m3958h();
                }
                this.f4310f = 0L;
                return;
            }
            this.f4308d.mo3966a(removeLast);
            this.f4310f -= this.f4305a.mo3912b(removeLast);
            this.f4314j++;
            if (Log.isLoggable(f4303k, 3)) {
                String str = "Evicting bitmap=" + this.f4305a.mo3914c(removeLast);
            }
            m3957g();
            removeLast.recycle();
        }
    }
}
