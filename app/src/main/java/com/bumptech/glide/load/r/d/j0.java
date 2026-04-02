package com.bumptech.glide.load.r.d;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.i;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: compiled from: VideoDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class j0<T> implements com.bumptech.glide.load.l<T, Bitmap> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f3171d = "VideoDecoder";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f3172e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @VisibleForTesting
    static final int f3173f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final com.bumptech.glide.load.i<Long> f3174g = com.bumptech.glide.load.i.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new a());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final com.bumptech.glide.load.i<Integer> f3175h = com.bumptech.glide.load.i.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new b());

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final e f3176i = new e();
    private final f<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.p.a0.e f3177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f3178c;

    /* JADX INFO: compiled from: VideoDecoder.java */
    class a implements i.b<Long> {
        private final ByteBuffer a = ByteBuffer.allocate(8);

        a() {
        }

        @Override // com.bumptech.glide.load.i.b
        public void a(@NonNull byte[] bArr, @NonNull Long l2, @NonNull MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.a) {
                this.a.position(0);
                messageDigest.update(this.a.putLong(l2.longValue()).array());
            }
        }
    }

    /* JADX INFO: compiled from: VideoDecoder.java */
    class b implements i.b<Integer> {
        private final ByteBuffer a = ByteBuffer.allocate(4);

        b() {
        }

        @Override // com.bumptech.glide.load.i.b
        public void a(@NonNull byte[] bArr, @NonNull Integer num, @NonNull MessageDigest messageDigest) {
            if (num == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.a) {
                this.a.position(0);
                messageDigest.update(this.a.putInt(num.intValue()).array());
            }
        }
    }

    /* JADX INFO: compiled from: VideoDecoder.java */
    private static final class c implements f<AssetFileDescriptor> {
        private c() {
        }

        /* synthetic */ c(a aVar) {
            this();
        }

        @Override // com.bumptech.glide.load.r.d.j0.f
        public void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    /* JADX INFO: compiled from: VideoDecoder.java */
    @RequiresApi(23)
    static final class d implements f<ByteBuffer> {

        /* JADX INFO: compiled from: VideoDecoder.java */
        class a extends MediaDataSource {
            final /* synthetic */ ByteBuffer a;

            a(ByteBuffer byteBuffer) {
                this.a = byteBuffer;
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // android.media.MediaDataSource
            public long getSize() {
                return this.a.limit();
            }

            @Override // android.media.MediaDataSource
            public int readAt(long j2, byte[] bArr, int i2, int i3) {
                if (j2 >= this.a.limit()) {
                    return -1;
                }
                this.a.position((int) j2);
                int iMin = Math.min(i3, this.a.remaining());
                this.a.get(bArr, i2, iMin);
                return iMin;
            }
        }

        d() {
        }

        @Override // com.bumptech.glide.load.r.d.j0.f
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer) {
            mediaMetadataRetriever.setDataSource(new a(byteBuffer));
        }
    }

    /* JADX INFO: compiled from: VideoDecoder.java */
    @VisibleForTesting
    static class e {
        e() {
        }

        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    /* JADX INFO: compiled from: VideoDecoder.java */
    @VisibleForTesting
    interface f<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    /* JADX INFO: compiled from: VideoDecoder.java */
    static final class g implements f<ParcelFileDescriptor> {
        g() {
        }

        @Override // com.bumptech.glide.load.r.d.j0.f
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    j0(com.bumptech.glide.load.p.a0.e eVar, f<T> fVar) {
        this(eVar, fVar, f3176i);
    }

    public static com.bumptech.glide.load.l<AssetFileDescriptor, Bitmap> a(com.bumptech.glide.load.p.a0.e eVar) {
        return new j0(eVar, new c(null));
    }

    @RequiresApi(api = 23)
    public static com.bumptech.glide.load.l<ByteBuffer, Bitmap> b(com.bumptech.glide.load.p.a0.e eVar) {
        return new j0(eVar, new d());
    }

    public static com.bumptech.glide.load.l<ParcelFileDescriptor, Bitmap> c(com.bumptech.glide.load.p.a0.e eVar) {
        return new j0(eVar, new g());
    }

    @Override // com.bumptech.glide.load.l
    public boolean a(@NonNull T t, @NonNull com.bumptech.glide.load.j jVar) {
        return true;
    }

    @VisibleForTesting
    j0(com.bumptech.glide.load.p.a0.e eVar, f<T> fVar, e eVar2) {
        this.f3177b = eVar;
        this.a = fVar;
        this.f3178c = eVar2;
    }

    @TargetApi(27)
    private static Bitmap b(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2, int i3, int i4, p pVar) {
        try {
            int i5 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int i6 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int i7 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (i7 == 90 || i7 == 270) {
                i6 = i5;
                i5 = i6;
            }
            float fB = pVar.b(i5, i6, i3, i4);
            return mediaMetadataRetriever.getScaledFrameAtTime(j2, i2, Math.round(i5 * fB), Math.round(fB * i6));
        } catch (Throwable unused) {
            Log.isLoggable(f3171d, 3);
            return null;
        }
    }

    @Override // com.bumptech.glide.load.l
    public com.bumptech.glide.load.p.v<Bitmap> a(@NonNull T t, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar) throws IOException {
        long jLongValue = ((Long) jVar.a(f3174g)).longValue();
        if (jLongValue < 0 && jLongValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + jLongValue);
        }
        Integer num = (Integer) jVar.a(f3175h);
        if (num == null) {
            num = 2;
        }
        p pVar = (p) jVar.a(p.f3206h);
        if (pVar == null) {
            pVar = p.f3205g;
        }
        p pVar2 = pVar;
        MediaMetadataRetriever mediaMetadataRetrieverA = this.f3178c.a();
        try {
            try {
                this.a.a(mediaMetadataRetrieverA, t);
                Bitmap bitmapA = a(mediaMetadataRetrieverA, jLongValue, num.intValue(), i2, i3, pVar2);
                mediaMetadataRetrieverA.release();
                return com.bumptech.glide.load.r.d.g.a(bitmapA, this.f3177b);
            } catch (RuntimeException e2) {
                throw new IOException(e2);
            }
        } catch (Throwable th) {
            mediaMetadataRetrieverA.release();
            throw th;
        }
    }

    @Nullable
    private static Bitmap a(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2, int i3, int i4, p pVar) {
        Bitmap bitmapB = (Build.VERSION.SDK_INT < 27 || i3 == Integer.MIN_VALUE || i4 == Integer.MIN_VALUE || pVar == p.f3204f) ? null : b(mediaMetadataRetriever, j2, i2, i3, i4, pVar);
        return bitmapB == null ? a(mediaMetadataRetriever, j2, i2) : bitmapB;
    }

    private static Bitmap a(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2) {
        return mediaMetadataRetriever.getFrameAtTime(j2, i2);
    }
}
