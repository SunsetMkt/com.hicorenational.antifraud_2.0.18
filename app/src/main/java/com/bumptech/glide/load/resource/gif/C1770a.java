package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.ComponentCallbacks2C1576b;
import com.bumptech.glide.load.C1592f;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.EnumC1588b;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.InterfaceC1598l;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1623b;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e;
import com.bumptech.glide.load.p125r.C1715c;
import com.bumptech.glide.p134o.C1806c;
import com.bumptech.glide.p134o.C1807d;
import com.bumptech.glide.p134o.C1809f;
import com.bumptech.glide.p134o.InterfaceC1804a;
import com.bumptech.glide.util.C1872f;
import com.bumptech.glide.util.C1878l;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

/* compiled from: ByteBufferGifDecoder.java */
/* renamed from: com.bumptech.glide.load.resource.gif.a */
/* loaded from: classes.dex */
public class C1770a implements InterfaceC1598l<ByteBuffer, GifDrawable> {

    /* renamed from: f */
    private static final String f5005f = "BufferGifDecoder";

    /* renamed from: g */
    private static final a f5006g = new a();

    /* renamed from: h */
    private static final b f5007h = new b();

    /* renamed from: a */
    private final Context f5008a;

    /* renamed from: b */
    private final List<ImageHeaderParser> f5009b;

    /* renamed from: c */
    private final b f5010c;

    /* renamed from: d */
    private final a f5011d;

    /* renamed from: e */
    private final C1771b f5012e;

    /* compiled from: ByteBufferGifDecoder.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.resource.gif.a$a */
    static class a {
        a() {
        }

        /* renamed from: a */
        InterfaceC1804a m4461a(InterfaceC1804a.a aVar, C1806c c1806c, ByteBuffer byteBuffer, int i2) {
            return new C1809f(aVar, c1806c, byteBuffer, i2);
        }
    }

    public C1770a(Context context) {
        this(context, ComponentCallbacks2C1576b.m3633a(context).m3664h().m3735a(), ComponentCallbacks2C1576b.m3633a(context).m3660d(), ComponentCallbacks2C1576b.m3633a(context).m3659c());
    }

    /* compiled from: ByteBufferGifDecoder.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.resource.gif.a$b */
    static class b {

        /* renamed from: a */
        private final Queue<C1807d> f5013a = C1878l.m5002a(0);

        b() {
        }

        /* renamed from: a */
        synchronized C1807d m4462a(ByteBuffer byteBuffer) {
            C1807d poll;
            poll = this.f5013a.poll();
            if (poll == null) {
                poll = new C1807d();
            }
            return poll.m4671a(byteBuffer);
        }

        /* renamed from: a */
        synchronized void m4463a(C1807d c1807d) {
            c1807d.m4673a();
            this.f5013a.offer(c1807d);
        }
    }

    @Override // com.bumptech.glide.load.InterfaceC1598l
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public boolean mo3843a(@NonNull ByteBuffer byteBuffer, @NonNull C1596j c1596j) throws IOException {
        return !((Boolean) c1596j.m3840a(C1777h.f5046b)).booleanValue() && C1592f.m3822a(this.f5009b, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    public C1770a(Context context, List<ImageHeaderParser> list, InterfaceC1626e interfaceC1626e, InterfaceC1623b interfaceC1623b) {
        this(context, list, interfaceC1626e, interfaceC1623b, f5007h, f5006g);
    }

    @Override // com.bumptech.glide.load.InterfaceC1598l
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public C1773d mo3842a(@NonNull ByteBuffer byteBuffer, int i2, int i3, @NonNull C1596j c1596j) {
        C1807d m4462a = this.f5010c.m4462a(byteBuffer);
        try {
            return m4460a(byteBuffer, i2, i3, m4462a, c1596j);
        } finally {
            this.f5010c.m4463a(m4462a);
        }
    }

    @VisibleForTesting
    C1770a(Context context, List<ImageHeaderParser> list, InterfaceC1626e interfaceC1626e, InterfaceC1623b interfaceC1623b, b bVar, a aVar) {
        this.f5008a = context.getApplicationContext();
        this.f5009b = list;
        this.f5011d = aVar;
        this.f5012e = new C1771b(interfaceC1626e, interfaceC1623b);
        this.f5010c = bVar;
    }

    @Nullable
    /* renamed from: a */
    private C1773d m4460a(ByteBuffer byteBuffer, int i2, int i3, C1807d c1807d, C1596j c1596j) {
        Bitmap.Config config;
        long m4970a = C1872f.m4970a();
        try {
            C1806c m4675c = c1807d.m4675c();
            if (m4675c.m4653b() > 0 && m4675c.m4654c() == 0) {
                if (c1596j.m3840a(C1777h.f5045a) == EnumC1588b.PREFER_RGB_565) {
                    config = Bitmap.Config.RGB_565;
                } else {
                    config = Bitmap.Config.ARGB_8888;
                }
                InterfaceC1804a m4461a = this.f5011d.m4461a(this.f5012e, m4675c, byteBuffer, m4459a(m4675c, i2, i3));
                m4461a.mo4637a(config);
                m4461a.mo4641b();
                Bitmap mo4636a = m4461a.mo4636a();
                if (mo4636a == null) {
                    return null;
                }
                C1773d c1773d = new C1773d(new GifDrawable(this.f5008a, m4461a, C1715c.m4302a(), i2, i3, mo4636a));
                if (Log.isLoggable(f5005f, 2)) {
                    String str = "Decoded GIF from stream in " + C1872f.m4969a(m4970a);
                }
                return c1773d;
            }
            if (Log.isLoggable(f5005f, 2)) {
                String str2 = "Decoded GIF from stream in " + C1872f.m4969a(m4970a);
            }
            return null;
        } finally {
            if (Log.isLoggable(f5005f, 2)) {
                String str3 = "Decoded GIF from stream in " + C1872f.m4969a(m4970a);
            }
        }
    }

    /* renamed from: a */
    private static int m4459a(C1806c c1806c, int i2, int i3) {
        int min = Math.min(c1806c.m4652a() / i3, c1806c.m4655d() / i2);
        int max = Math.max(1, min == 0 ? 0 : Integer.highestOneBit(min));
        if (Log.isLoggable(f5005f, 2) && max > 1) {
            String str = "Downsampling GIF, sampleSize: " + max + ", target dimens: [" + i2 + "x" + i3 + "], actual dimens: [" + c1806c.m4655d() + "x" + c1806c.m4652a() + "]";
        }
        return max;
    }
}
