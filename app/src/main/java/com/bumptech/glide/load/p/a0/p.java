package com.bumptech.glide.load.p.a0;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import java.util.NavigableMap;

/* JADX INFO: compiled from: SizeStrategy.java */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(19)
final class p implements l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f2817d = 8;
    private final b a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h<a, Bitmap> f2818b = new h<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final NavigableMap<Integer, Integer> f2819c = new n();

    /* JADX INFO: compiled from: SizeStrategy.java */
    @VisibleForTesting
    static final class a implements m {
        private final b a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2820b;

        a(b bVar) {
            this.a = bVar;
        }

        public void a(int i2) {
            this.f2820b = i2;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && this.f2820b == ((a) obj).f2820b;
        }

        public int hashCode() {
            return this.f2820b;
        }

        @Override // com.bumptech.glide.load.p.a0.m
        public void offer() {
            this.a.a(this);
        }

        public String toString() {
            return p.a(this.f2820b);
        }
    }

    /* JADX INFO: compiled from: SizeStrategy.java */
    @VisibleForTesting
    static class b extends d<a> {
        b() {
        }

        public a a(int i2) {
            a aVar = (a) super.b();
            aVar.a(i2);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.p.a0.d
        public a a() {
            return new a(this);
        }
    }

    p() {
    }

    private static String d(Bitmap bitmap) {
        return a(com.bumptech.glide.util.l.a(bitmap));
    }

    @Override // com.bumptech.glide.load.p.a0.l
    public void a(Bitmap bitmap) {
        a aVarA = this.a.a(com.bumptech.glide.util.l.a(bitmap));
        this.f2818b.a(aVarA, bitmap);
        Integer num = (Integer) this.f2819c.get(Integer.valueOf(aVarA.f2820b));
        this.f2819c.put(Integer.valueOf(aVarA.f2820b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // com.bumptech.glide.load.p.a0.l
    public String b(int i2, int i3, Bitmap.Config config) {
        return a(com.bumptech.glide.util.l.a(i2, i3, config));
    }

    @Override // com.bumptech.glide.load.p.a0.l
    public String c(Bitmap bitmap) {
        return d(bitmap);
    }

    @Override // com.bumptech.glide.load.p.a0.l
    @Nullable
    public Bitmap removeLast() {
        Bitmap bitmapA = this.f2818b.a();
        if (bitmapA != null) {
            a(Integer.valueOf(com.bumptech.glide.util.l.a(bitmapA)));
        }
        return bitmapA;
    }

    public String toString() {
        return "SizeStrategy:\n  " + this.f2818b + "\n  SortedSizes" + this.f2819c;
    }

    @Override // com.bumptech.glide.load.p.a0.l
    public int b(Bitmap bitmap) {
        return com.bumptech.glide.util.l.a(bitmap);
    }

    @Override // com.bumptech.glide.load.p.a0.l
    @Nullable
    public Bitmap a(int i2, int i3, Bitmap.Config config) {
        int iA = com.bumptech.glide.util.l.a(i2, i3, config);
        a aVarA = this.a.a(iA);
        Integer numCeilingKey = this.f2819c.ceilingKey(Integer.valueOf(iA));
        if (numCeilingKey != null && numCeilingKey.intValue() != iA && numCeilingKey.intValue() <= iA * 8) {
            this.a.a(aVarA);
            aVarA = this.a.a(numCeilingKey.intValue());
        }
        Bitmap bitmapA = this.f2818b.a(aVarA);
        if (bitmapA != null) {
            bitmapA.reconfigure(i2, i3, config);
            a(numCeilingKey);
        }
        return bitmapA;
    }

    private void a(Integer num) {
        Integer num2 = (Integer) this.f2819c.get(num);
        if (num2.intValue() == 1) {
            this.f2819c.remove(num);
        } else {
            this.f2819c.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    static String a(int i2) {
        return "[" + i2 + "]";
    }
}
