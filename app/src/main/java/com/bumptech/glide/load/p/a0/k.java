package com.bumptech.glide.load.p.a0;

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

/* JADX INFO: compiled from: LruBitmapPool.java */
/* JADX INFO: loaded from: classes.dex */
public class k implements e {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f2796k = "LruBitmapPool";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Bitmap.Config f2797l = Bitmap.Config.ARGB_8888;
    private final l a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<Bitmap.Config> f2798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f2799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f2800d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f2801e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f2802f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f2803g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f2804h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f2805i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f2806j;

    /* JADX INFO: compiled from: LruBitmapPool.java */
    private interface a {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    /* JADX INFO: compiled from: LruBitmapPool.java */
    private static final class b implements a {
        b() {
        }

        @Override // com.bumptech.glide.load.p.a0.k.a
        public void a(Bitmap bitmap) {
        }

        @Override // com.bumptech.glide.load.p.a0.k.a
        public void b(Bitmap bitmap) {
        }
    }

    /* JADX INFO: compiled from: LruBitmapPool.java */
    private static class c implements a {
        private final Set<Bitmap> a = Collections.synchronizedSet(new HashSet());

        private c() {
        }

        @Override // com.bumptech.glide.load.p.a0.k.a
        public void a(Bitmap bitmap) {
            if (!this.a.contains(bitmap)) {
                throw new IllegalStateException("Cannot remove bitmap not in tracker");
            }
            this.a.remove(bitmap);
        }

        @Override // com.bumptech.glide.load.p.a0.k.a
        public void b(Bitmap bitmap) {
            if (!this.a.contains(bitmap)) {
                this.a.add(bitmap);
                return;
            }
            throw new IllegalStateException("Can't add already added bitmap: " + bitmap + " [" + bitmap.getWidth() + "x" + bitmap.getHeight() + "]");
        }
    }

    k(long j2, l lVar, Set<Bitmap.Config> set) {
        this.f2799c = j2;
        this.f2801e = j2;
        this.a = lVar;
        this.f2798b = set;
        this.f2800d = new b();
    }

    private void g() {
        if (Log.isLoggable(f2796k, 2)) {
            h();
        }
    }

    private void h() {
        String str = "Hits=" + this.f2803g + ", misses=" + this.f2804h + ", puts=" + this.f2805i + ", evictions=" + this.f2806j + ", currentSize=" + this.f2802f + ", maxSize=" + this.f2801e + "\nStrategy=" + this.a;
    }

    private void i() {
        a(this.f2801e);
    }

    @TargetApi(26)
    private static Set<Bitmap.Config> j() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        if (Build.VERSION.SDK_INT >= 19) {
            hashSet.add(null);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static l k() {
        return Build.VERSION.SDK_INT >= 19 ? new o() : new com.bumptech.glide.load.p.a0.c();
    }

    @Override // com.bumptech.glide.load.p.a0.e
    public synchronized void a(float f2) {
        this.f2801e = Math.round(this.f2799c * f2);
        i();
    }

    @Override // com.bumptech.glide.load.p.a0.e
    public long b() {
        return this.f2801e;
    }

    public long c() {
        return this.f2806j;
    }

    public long d() {
        return this.f2802f;
    }

    public long e() {
        return this.f2803g;
    }

    public long f() {
        return this.f2804h;
    }

    @NonNull
    private static Bitmap c(int i2, int i3, @Nullable Bitmap.Config config) {
        if (config == null) {
            config = f2797l;
        }
        return Bitmap.createBitmap(i2, i3, config);
    }

    @Nullable
    private synchronized Bitmap d(int i2, int i3, @Nullable Bitmap.Config config) {
        Bitmap bitmapA;
        a(config);
        bitmapA = this.a.a(i2, i3, config != null ? config : f2797l);
        if (bitmapA == null) {
            if (Log.isLoggable(f2796k, 3)) {
                String str = "Missing bitmap=" + this.a.b(i2, i3, config);
            }
            this.f2804h++;
        } else {
            this.f2803g++;
            this.f2802f -= (long) this.a.b(bitmapA);
            this.f2800d.a(bitmapA);
            c(bitmapA);
        }
        if (Log.isLoggable(f2796k, 2)) {
            String str2 = "Get bitmap=" + this.a.b(i2, i3, config);
        }
        g();
        return bitmapA;
    }

    @Override // com.bumptech.glide.load.p.a0.e
    @NonNull
    public Bitmap b(int i2, int i3, Bitmap.Config config) {
        Bitmap bitmapD = d(i2, i3, config);
        return bitmapD == null ? c(i2, i3, config) : bitmapD;
    }

    private static void c(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        b(bitmap);
    }

    @TargetApi(19)
    private static void b(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            bitmap.setPremultiplied(true);
        }
    }

    @Override // com.bumptech.glide.load.p.a0.e
    public synchronized void a(Bitmap bitmap) {
        try {
            if (bitmap != null) {
                if (!bitmap.isRecycled()) {
                    if (bitmap.isMutable() && this.a.b(bitmap) <= this.f2801e && this.f2798b.contains(bitmap.getConfig())) {
                        int iB = this.a.b(bitmap);
                        this.a.a(bitmap);
                        this.f2800d.b(bitmap);
                        this.f2805i++;
                        this.f2802f += (long) iB;
                        if (Log.isLoggable(f2796k, 2)) {
                            String str = "Put bitmap in pool=" + this.a.c(bitmap);
                        }
                        g();
                        i();
                        return;
                    }
                    if (Log.isLoggable(f2796k, 2)) {
                        String str2 = "Reject bitmap from pool, bitmap: " + this.a.c(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f2798b.contains(bitmap.getConfig());
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

    public k(long j2) {
        this(j2, k(), j());
    }

    public k(long j2, Set<Bitmap.Config> set) {
        this(j2, k(), set);
    }

    @Override // com.bumptech.glide.load.p.a0.e
    @NonNull
    public Bitmap a(int i2, int i3, Bitmap.Config config) {
        Bitmap bitmapD = d(i2, i3, config);
        if (bitmapD != null) {
            bitmapD.eraseColor(0);
            return bitmapD;
        }
        return c(i2, i3, config);
    }

    @TargetApi(26)
    private static void a(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    @Override // com.bumptech.glide.load.p.a0.e
    public void a() {
        Log.isLoggable(f2796k, 3);
        a(0L);
    }

    @Override // com.bumptech.glide.load.p.a0.e
    @SuppressLint({"InlinedApi"})
    public void a(int i2) {
        if (Log.isLoggable(f2796k, 3)) {
            String str = "trimMemory, level=" + i2;
        }
        if (i2 >= 40 || (Build.VERSION.SDK_INT >= 23 && i2 >= 20)) {
            a();
        } else if (i2 >= 20 || i2 == 15) {
            a(b() / 2);
        }
    }

    private synchronized void a(long j2) {
        while (this.f2802f > j2) {
            Bitmap bitmapRemoveLast = this.a.removeLast();
            if (bitmapRemoveLast == null) {
                if (Log.isLoggable(f2796k, 5)) {
                    h();
                }
                this.f2802f = 0L;
                return;
            }
            this.f2800d.a(bitmapRemoveLast);
            this.f2802f -= (long) this.a.b(bitmapRemoveLast);
            this.f2806j++;
            if (Log.isLoggable(f2796k, 3)) {
                String str = "Evicting bitmap=" + this.a.c(bitmapRemoveLast);
            }
            g();
            bitmapRemoveLast.recycle();
        }
    }
}
