package com.bumptech.glide.load.r;

import android.annotation.SuppressLint;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.k;
import com.bumptech.glide.load.l;
import com.bumptech.glide.load.p.v;
import com.bumptech.glide.load.r.d.p;
import com.bumptech.glide.load.r.d.q;
import com.bumptech.glide.load.r.d.w;
import java.io.IOException;

/* JADX INFO: compiled from: ImageDecoderResourceDecoder.java */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 28)
public abstract class a<T> implements l<ImageDecoder.Source, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f3129b = "ImageDecoder";
    final w a = w.a();

    /* JADX INFO: renamed from: com.bumptech.glide.load.r.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ImageDecoderResourceDecoder.java */
    class C0058a implements ImageDecoder.OnHeaderDecodedListener {
        final /* synthetic */ int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f3130b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f3131c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.bumptech.glide.load.b f3132d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ p f3133e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ k f3134f;

        /* JADX INFO: renamed from: com.bumptech.glide.load.r.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ImageDecoderResourceDecoder.java */
        class C0059a implements ImageDecoder.OnPartialImageListener {
            C0059a() {
            }

            @Override // android.graphics.ImageDecoder.OnPartialImageListener
            public boolean onPartialImage(@NonNull ImageDecoder.DecodeException decodeException) {
                return false;
            }
        }

        C0058a(int i2, int i3, boolean z, com.bumptech.glide.load.b bVar, p pVar, k kVar) {
            this.a = i2;
            this.f3130b = i3;
            this.f3131c = z;
            this.f3132d = bVar;
            this.f3133e = pVar;
            this.f3134f = kVar;
        }

        @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
        @SuppressLint({"Override"})
        public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
            if (a.this.a.a(this.a, this.f3130b, this.f3131c, false)) {
                imageDecoder.setAllocator(3);
            } else {
                imageDecoder.setAllocator(1);
            }
            if (this.f3132d == com.bumptech.glide.load.b.PREFER_RGB_565) {
                imageDecoder.setMemorySizePolicy(0);
            }
            imageDecoder.setOnPartialImageListener(new C0059a());
            Size size = imageInfo.getSize();
            int width = this.a;
            if (width == Integer.MIN_VALUE) {
                width = size.getWidth();
            }
            int height = this.f3130b;
            if (height == Integer.MIN_VALUE) {
                height = size.getHeight();
            }
            float fB = this.f3133e.b(size.getWidth(), size.getHeight(), width, height);
            int iRound = Math.round(size.getWidth() * fB);
            int iRound2 = Math.round(size.getHeight() * fB);
            if (Log.isLoggable(a.f3129b, 2)) {
                String str = "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + iRound + "x" + iRound2 + "] scaleFactor: " + fB;
            }
            imageDecoder.setTargetSize(iRound, iRound2);
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 28) {
                imageDecoder.setTargetColorSpace(ColorSpace.get(this.f3134f == k.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut() ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
            } else if (i2 >= 26) {
                imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
            }
        }
    }

    protected abstract v<T> a(ImageDecoder.Source source, int i2, int i3, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException;

    @Override // com.bumptech.glide.load.l
    public final boolean a(@NonNull ImageDecoder.Source source, @NonNull j jVar) {
        return true;
    }

    @Override // com.bumptech.glide.load.l
    @Nullable
    public final v<T> a(@NonNull ImageDecoder.Source source, int i2, int i3, @NonNull j jVar) throws IOException {
        return a(source, i2, i3, new C0058a(i2, i3, jVar.a(q.f3213k) != null && ((Boolean) jVar.a(q.f3213k)).booleanValue(), (com.bumptech.glide.load.b) jVar.a(q.f3209g), (p) jVar.a(p.f3206h), (k) jVar.a(q.f3210h)));
    }
}
