package com.bumptech.glide.load.p125r;

import android.annotation.SuppressLint;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.EnumC1588b;
import com.bumptech.glide.load.EnumC1597k;
import com.bumptech.glide.load.InterfaceC1598l;
import com.bumptech.glide.load.p118p.InterfaceC1677v;
import com.bumptech.glide.load.p125r.p126d.AbstractC1741p;
import com.bumptech.glide.load.p125r.p126d.C1742q;
import com.bumptech.glide.load.p125r.p126d.C1748w;
import java.io.IOException;

/* compiled from: ImageDecoderResourceDecoder.java */
@RequiresApi(api = 28)
/* renamed from: com.bumptech.glide.load.r.a */
/* loaded from: classes.dex */
public abstract class AbstractC1713a<T> implements InterfaceC1598l<ImageDecoder.Source, T> {

    /* renamed from: b */
    private static final String f4800b = "ImageDecoder";

    /* renamed from: a */
    final C1748w f4801a = C1748w.m4401a();

    /* compiled from: ImageDecoderResourceDecoder.java */
    /* renamed from: com.bumptech.glide.load.r.a$a */
    class a implements ImageDecoder.OnHeaderDecodedListener {

        /* renamed from: a */
        final /* synthetic */ int f4802a;

        /* renamed from: b */
        final /* synthetic */ int f4803b;

        /* renamed from: c */
        final /* synthetic */ boolean f4804c;

        /* renamed from: d */
        final /* synthetic */ EnumC1588b f4805d;

        /* renamed from: e */
        final /* synthetic */ AbstractC1741p f4806e;

        /* renamed from: f */
        final /* synthetic */ EnumC1597k f4807f;

        /* compiled from: ImageDecoderResourceDecoder.java */
        /* renamed from: com.bumptech.glide.load.r.a$a$a, reason: collision with other inner class name */
        class C7363a implements ImageDecoder.OnPartialImageListener {
            C7363a() {
            }

            @Override // android.graphics.ImageDecoder.OnPartialImageListener
            public boolean onPartialImage(@NonNull ImageDecoder.DecodeException decodeException) {
                return false;
            }
        }

        a(int i2, int i3, boolean z, EnumC1588b enumC1588b, AbstractC1741p abstractC1741p, EnumC1597k enumC1597k) {
            this.f4802a = i2;
            this.f4803b = i3;
            this.f4804c = z;
            this.f4805d = enumC1588b;
            this.f4806e = abstractC1741p;
            this.f4807f = enumC1597k;
        }

        @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
        @SuppressLint({"Override"})
        public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
            if (AbstractC1713a.this.f4801a.m4405a(this.f4802a, this.f4803b, this.f4804c, false)) {
                imageDecoder.setAllocator(3);
            } else {
                imageDecoder.setAllocator(1);
            }
            if (this.f4805d == EnumC1588b.PREFER_RGB_565) {
                imageDecoder.setMemorySizePolicy(0);
            }
            imageDecoder.setOnPartialImageListener(new C7363a());
            Size size = imageInfo.getSize();
            int i2 = this.f4802a;
            if (i2 == Integer.MIN_VALUE) {
                i2 = size.getWidth();
            }
            int i3 = this.f4803b;
            if (i3 == Integer.MIN_VALUE) {
                i3 = size.getHeight();
            }
            float mo4370b = this.f4806e.mo4370b(size.getWidth(), size.getHeight(), i2, i3);
            int round = Math.round(size.getWidth() * mo4370b);
            int round2 = Math.round(size.getHeight() * mo4370b);
            if (Log.isLoggable(AbstractC1713a.f4800b, 2)) {
                String str = "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + round + "x" + round2 + "] scaleFactor: " + mo4370b;
            }
            imageDecoder.setTargetSize(round, round2);
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 28) {
                imageDecoder.setTargetColorSpace(ColorSpace.get(this.f4807f == EnumC1597k.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut() ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
            } else if (i4 >= 26) {
                imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
            }
        }
    }

    /* renamed from: a */
    protected abstract InterfaceC1677v<T> mo4301a(ImageDecoder.Source source, int i2, int i3, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException;

    @Override // com.bumptech.glide.load.InterfaceC1598l
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final boolean mo3843a(@NonNull ImageDecoder.Source source, @NonNull C1596j c1596j) {
        return true;
    }

    @Override // com.bumptech.glide.load.InterfaceC1598l
    @Nullable
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final InterfaceC1677v<T> mo3842a(@NonNull ImageDecoder.Source source, int i2, int i3, @NonNull C1596j c1596j) throws IOException {
        return mo4301a(source, i2, i3, new a(i2, i3, c1596j.m3840a(C1742q.f4922k) != null && ((Boolean) c1596j.m3840a(C1742q.f4922k)).booleanValue(), (EnumC1588b) c1596j.m3840a(C1742q.f4918g), (AbstractC1741p) c1596j.m3840a(AbstractC1741p.f4914h), (EnumC1597k) c1596j.m3840a(C1742q.f4919h)));
    }
}
