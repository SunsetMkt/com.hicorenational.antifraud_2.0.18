package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.l;
import com.bumptech.glide.o.a;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

/* JADX INFO: compiled from: ByteBufferGifDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements l<ByteBuffer, GifDrawable> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f3273f = "BufferGifDecoder";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final C0061a f3274g = new C0061a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final b f3275h = new b();
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<ImageHeaderParser> f3276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f3277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final C0061a f3278d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.load.resource.gif.b f3279e;

    /* JADX INFO: renamed from: com.bumptech.glide.load.resource.gif.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ByteBufferGifDecoder.java */
    @VisibleForTesting
    static class C0061a {
        C0061a() {
        }

        com.bumptech.glide.o.a a(a.InterfaceC0063a interfaceC0063a, com.bumptech.glide.o.c cVar, ByteBuffer byteBuffer, int i2) {
            return new com.bumptech.glide.o.f(interfaceC0063a, cVar, byteBuffer, i2);
        }
    }

    public a(Context context) {
        this(context, com.bumptech.glide.b.a(context).h().a(), com.bumptech.glide.b.a(context).d(), com.bumptech.glide.b.a(context).c());
    }

    /* JADX INFO: compiled from: ByteBufferGifDecoder.java */
    @VisibleForTesting
    static class b {
        private final Queue<com.bumptech.glide.o.d> a = com.bumptech.glide.util.l.a(0);

        b() {
        }

        synchronized com.bumptech.glide.o.d a(ByteBuffer byteBuffer) {
            com.bumptech.glide.o.d dVarPoll;
            dVarPoll = this.a.poll();
            if (dVarPoll == null) {
                dVarPoll = new com.bumptech.glide.o.d();
            }
            return dVarPoll.a(byteBuffer);
        }

        synchronized void a(com.bumptech.glide.o.d dVar) {
            dVar.a();
            this.a.offer(dVar);
        }
    }

    @Override // com.bumptech.glide.load.l
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull j jVar) throws IOException {
        return !((Boolean) jVar.a(h.f3301b)).booleanValue() && com.bumptech.glide.load.f.a(this.f3276b, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    public a(Context context, List<ImageHeaderParser> list, com.bumptech.glide.load.p.a0.e eVar, com.bumptech.glide.load.p.a0.b bVar) {
        this(context, list, eVar, bVar, f3275h, f3274g);
    }

    @Override // com.bumptech.glide.load.l
    public d a(@NonNull ByteBuffer byteBuffer, int i2, int i3, @NonNull j jVar) {
        com.bumptech.glide.o.d dVarA = this.f3277c.a(byteBuffer);
        try {
            return a(byteBuffer, i2, i3, dVarA, jVar);
        } finally {
            this.f3277c.a(dVarA);
        }
    }

    @VisibleForTesting
    a(Context context, List<ImageHeaderParser> list, com.bumptech.glide.load.p.a0.e eVar, com.bumptech.glide.load.p.a0.b bVar, b bVar2, C0061a c0061a) {
        this.a = context.getApplicationContext();
        this.f3276b = list;
        this.f3278d = c0061a;
        this.f3279e = new com.bumptech.glide.load.resource.gif.b(eVar, bVar);
        this.f3277c = bVar2;
    }

    @Nullable
    private d a(ByteBuffer byteBuffer, int i2, int i3, com.bumptech.glide.o.d dVar, j jVar) {
        Bitmap.Config config;
        long jA = com.bumptech.glide.util.f.a();
        try {
            com.bumptech.glide.o.c cVarC = dVar.c();
            if (cVarC.b() > 0 && cVarC.c() == 0) {
                if (jVar.a(h.a) == com.bumptech.glide.load.b.PREFER_RGB_565) {
                    config = Bitmap.Config.RGB_565;
                } else {
                    config = Bitmap.Config.ARGB_8888;
                }
                com.bumptech.glide.o.a aVarA = this.f3278d.a(this.f3279e, cVarC, byteBuffer, a(cVarC, i2, i3));
                aVarA.a(config);
                aVarA.b();
                Bitmap bitmapA = aVarA.a();
                if (bitmapA == null) {
                    return null;
                }
                d dVar2 = new d(new GifDrawable(this.a, aVarA, com.bumptech.glide.load.r.c.a(), i2, i3, bitmapA));
                if (Log.isLoggable(f3273f, 2)) {
                    String str = "Decoded GIF from stream in " + com.bumptech.glide.util.f.a(jA);
                }
                return dVar2;
            }
            if (Log.isLoggable(f3273f, 2)) {
                String str2 = "Decoded GIF from stream in " + com.bumptech.glide.util.f.a(jA);
            }
            return null;
        } finally {
            if (Log.isLoggable(f3273f, 2)) {
                String str3 = "Decoded GIF from stream in " + com.bumptech.glide.util.f.a(jA);
            }
        }
    }

    private static int a(com.bumptech.glide.o.c cVar, int i2, int i3) {
        int iMin = Math.min(cVar.a() / i3, cVar.d() / i2);
        int iMax = Math.max(1, iMin == 0 ? 0 : Integer.highestOneBit(iMin));
        if (Log.isLoggable(f3273f, 2) && iMax > 1) {
            String str = "Downsampling GIF, sampleSize: " + iMax + ", target dimens: [" + i2 + "x" + i3 + "], actual dimens: [" + cVar.d() + "x" + cVar.a() + "]";
        }
        return iMax;
    }
}
