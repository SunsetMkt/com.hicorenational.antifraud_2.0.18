package com.bumptech.glide.load.p125r.p126d;

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
import com.bumptech.glide.load.C1595i;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.InterfaceC1598l;
import com.bumptech.glide.load.p118p.InterfaceC1677v;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: VideoDecoder.java */
/* renamed from: com.bumptech.glide.load.r.d.j0 */
/* loaded from: classes.dex */
public class C1735j0<T> implements InterfaceC1598l<T, Bitmap> {

    /* renamed from: d */
    private static final String f4860d = "VideoDecoder";

    /* renamed from: e */
    public static final long f4861e = -1;

    /* renamed from: f */
    @VisibleForTesting
    static final int f4862f = 2;

    /* renamed from: g */
    public static final C1595i<Long> f4863g = C1595i.m3832a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new a());

    /* renamed from: h */
    public static final C1595i<Integer> f4864h = C1595i.m3832a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new b());

    /* renamed from: i */
    private static final e f4865i = new e();

    /* renamed from: a */
    private final f<T> f4866a;

    /* renamed from: b */
    private final InterfaceC1626e f4867b;

    /* renamed from: c */
    private final e f4868c;

    /* compiled from: VideoDecoder.java */
    /* renamed from: com.bumptech.glide.load.r.d.j0$a */
    class a implements C1595i.b<Long> {

        /* renamed from: a */
        private final ByteBuffer f4869a = ByteBuffer.allocate(8);

        a() {
        }

        @Override // com.bumptech.glide.load.C1595i.b
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo3837a(@NonNull byte[] bArr, @NonNull Long l2, @NonNull MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.f4869a) {
                this.f4869a.position(0);
                messageDigest.update(this.f4869a.putLong(l2.longValue()).array());
            }
        }
    }

    /* compiled from: VideoDecoder.java */
    /* renamed from: com.bumptech.glide.load.r.d.j0$b */
    class b implements C1595i.b<Integer> {

        /* renamed from: a */
        private final ByteBuffer f4870a = ByteBuffer.allocate(4);

        b() {
        }

        @Override // com.bumptech.glide.load.C1595i.b
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo3837a(@NonNull byte[] bArr, @NonNull Integer num, @NonNull MessageDigest messageDigest) {
            if (num == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.f4870a) {
                this.f4870a.position(0);
                messageDigest.update(this.f4870a.putInt(num.intValue()).array());
            }
        }
    }

    /* compiled from: VideoDecoder.java */
    /* renamed from: com.bumptech.glide.load.r.d.j0$c */
    private static final class c implements f<AssetFileDescriptor> {
        private c() {
        }

        /* synthetic */ c(a aVar) {
            this();
        }

        @Override // com.bumptech.glide.load.p125r.p126d.C1735j0.f
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo4354a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    /* compiled from: VideoDecoder.java */
    @RequiresApi(23)
    /* renamed from: com.bumptech.glide.load.r.d.j0$d */
    static final class d implements f<ByteBuffer> {

        /* compiled from: VideoDecoder.java */
        /* renamed from: com.bumptech.glide.load.r.d.j0$d$a */
        class a extends MediaDataSource {

            /* renamed from: a */
            final /* synthetic */ ByteBuffer f4871a;

            a(ByteBuffer byteBuffer) {
                this.f4871a = byteBuffer;
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // android.media.MediaDataSource
            public long getSize() {
                return this.f4871a.limit();
            }

            @Override // android.media.MediaDataSource
            public int readAt(long j2, byte[] bArr, int i2, int i3) {
                if (j2 >= this.f4871a.limit()) {
                    return -1;
                }
                this.f4871a.position((int) j2);
                int min = Math.min(i3, this.f4871a.remaining());
                this.f4871a.get(bArr, i2, min);
                return min;
            }
        }

        d() {
        }

        @Override // com.bumptech.glide.load.p125r.p126d.C1735j0.f
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo4354a(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer) {
            mediaMetadataRetriever.setDataSource(new a(byteBuffer));
        }
    }

    /* compiled from: VideoDecoder.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.r.d.j0$e */
    static class e {
        e() {
        }

        /* renamed from: a */
        public MediaMetadataRetriever m4355a() {
            return new MediaMetadataRetriever();
        }
    }

    /* compiled from: VideoDecoder.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.r.d.j0$f */
    interface f<T> {
        /* renamed from: a */
        void mo4354a(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    /* compiled from: VideoDecoder.java */
    /* renamed from: com.bumptech.glide.load.r.d.j0$g */
    static final class g implements f<ParcelFileDescriptor> {
        g() {
        }

        @Override // com.bumptech.glide.load.p125r.p126d.C1735j0.f
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo4354a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    C1735j0(InterfaceC1626e interfaceC1626e, f<T> fVar) {
        this(interfaceC1626e, fVar, f4865i);
    }

    /* renamed from: a */
    public static InterfaceC1598l<AssetFileDescriptor, Bitmap> m4350a(InterfaceC1626e interfaceC1626e) {
        return new C1735j0(interfaceC1626e, new c(null));
    }

    @RequiresApi(api = 23)
    /* renamed from: b */
    public static InterfaceC1598l<ByteBuffer, Bitmap> m4352b(InterfaceC1626e interfaceC1626e) {
        return new C1735j0(interfaceC1626e, new d());
    }

    /* renamed from: c */
    public static InterfaceC1598l<ParcelFileDescriptor, Bitmap> m4353c(InterfaceC1626e interfaceC1626e) {
        return new C1735j0(interfaceC1626e, new g());
    }

    @Override // com.bumptech.glide.load.InterfaceC1598l
    /* renamed from: a */
    public boolean mo3843a(@NonNull T t, @NonNull C1596j c1596j) {
        return true;
    }

    @VisibleForTesting
    C1735j0(InterfaceC1626e interfaceC1626e, f<T> fVar, e eVar) {
        this.f4867b = interfaceC1626e;
        this.f4866a = fVar;
        this.f4868c = eVar;
    }

    @TargetApi(27)
    /* renamed from: b */
    private static Bitmap m4351b(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2, int i3, int i4, AbstractC1741p abstractC1741p) {
        try {
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (parseInt3 == 90 || parseInt3 == 270) {
                parseInt2 = parseInt;
                parseInt = parseInt2;
            }
            float mo4370b = abstractC1741p.mo4370b(parseInt, parseInt2, i3, i4);
            return mediaMetadataRetriever.getScaledFrameAtTime(j2, i2, Math.round(parseInt * mo4370b), Math.round(mo4370b * parseInt2));
        } catch (Throwable unused) {
            Log.isLoggable(f4860d, 3);
            return null;
        }
    }

    @Override // com.bumptech.glide.load.InterfaceC1598l
    /* renamed from: a */
    public InterfaceC1677v<Bitmap> mo3842a(@NonNull T t, int i2, int i3, @NonNull C1596j c1596j) throws IOException {
        long longValue = ((Long) c1596j.m3840a(f4863g)).longValue();
        if (longValue < 0 && longValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + longValue);
        }
        Integer num = (Integer) c1596j.m3840a(f4864h);
        if (num == null) {
            num = 2;
        }
        AbstractC1741p abstractC1741p = (AbstractC1741p) c1596j.m3840a(AbstractC1741p.f4914h);
        if (abstractC1741p == null) {
            abstractC1741p = AbstractC1741p.f4913g;
        }
        AbstractC1741p abstractC1741p2 = abstractC1741p;
        MediaMetadataRetriever m4355a = this.f4868c.m4355a();
        try {
            try {
                this.f4866a.mo4354a(m4355a, t);
                Bitmap m4349a = m4349a(m4355a, longValue, num.intValue(), i2, i3, abstractC1741p2);
                m4355a.release();
                return C1728g.m4315a(m4349a, this.f4867b);
            } catch (RuntimeException e2) {
                throw new IOException(e2);
            }
        } catch (Throwable th) {
            m4355a.release();
            throw th;
        }
    }

    @Nullable
    /* renamed from: a */
    private static Bitmap m4349a(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2, int i3, int i4, AbstractC1741p abstractC1741p) {
        Bitmap m4351b = (Build.VERSION.SDK_INT < 27 || i3 == Integer.MIN_VALUE || i4 == Integer.MIN_VALUE || abstractC1741p == AbstractC1741p.f4912f) ? null : m4351b(mediaMetadataRetriever, j2, i2, i3, i4, abstractC1741p);
        return m4351b == null ? m4348a(mediaMetadataRetriever, j2, i2) : m4351b;
    }

    /* renamed from: a */
    private static Bitmap m4348a(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2) {
        return mediaMetadataRetriever.getFrameAtTime(j2, i2);
    }
}
