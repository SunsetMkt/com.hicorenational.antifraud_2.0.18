package com.bumptech.glide.load.p125r.p126d;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.C1592f;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.p116o.C1611k;
import com.bumptech.glide.load.p116o.C1613m;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1623b;
import com.bumptech.glide.util.C1876j;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: ImageReader.java */
/* renamed from: com.bumptech.glide.load.r.d.x */
/* loaded from: classes.dex */
interface InterfaceC1749x {

    /* compiled from: ImageReader.java */
    /* renamed from: com.bumptech.glide.load.r.d.x$a */
    public static final class a implements InterfaceC1749x {

        /* renamed from: a */
        private final C1611k f4958a;

        /* renamed from: b */
        private final InterfaceC1623b f4959b;

        /* renamed from: c */
        private final List<ImageHeaderParser> f4960c;

        a(InputStream inputStream, List<ImageHeaderParser> list, InterfaceC1623b interfaceC1623b) {
            this.f4959b = (InterfaceC1623b) C1876j.m4985a(interfaceC1623b);
            this.f4960c = (List) C1876j.m4985a(list);
            this.f4958a = new C1611k(inputStream, interfaceC1623b);
        }

        @Override // com.bumptech.glide.load.p125r.p126d.InterfaceC1749x
        @Nullable
        /* renamed from: a */
        public Bitmap mo4407a(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeStream(this.f4958a.mo3858a(), null, options);
        }

        @Override // com.bumptech.glide.load.p125r.p126d.InterfaceC1749x
        /* renamed from: b */
        public void mo4408b() {
            this.f4958a.m3869c();
        }

        @Override // com.bumptech.glide.load.p125r.p126d.InterfaceC1749x
        /* renamed from: c */
        public ImageHeaderParser.ImageType mo4409c() throws IOException {
            return C1592f.m3824b(this.f4960c, this.f4958a.mo3858a(), this.f4959b);
        }

        @Override // com.bumptech.glide.load.p125r.p126d.InterfaceC1749x
        /* renamed from: a */
        public int mo4406a() throws IOException {
            return C1592f.m3820a(this.f4960c, this.f4958a.mo3858a(), this.f4959b);
        }
    }

    /* renamed from: a */
    int mo4406a() throws IOException;

    @Nullable
    /* renamed from: a */
    Bitmap mo4407a(BitmapFactory.Options options) throws IOException;

    /* renamed from: b */
    void mo4408b();

    /* renamed from: c */
    ImageHeaderParser.ImageType mo4409c() throws IOException;

    /* compiled from: ImageReader.java */
    @RequiresApi(21)
    /* renamed from: com.bumptech.glide.load.r.d.x$b */
    public static final class b implements InterfaceC1749x {

        /* renamed from: a */
        private final InterfaceC1623b f4961a;

        /* renamed from: b */
        private final List<ImageHeaderParser> f4962b;

        /* renamed from: c */
        private final C1613m f4963c;

        b(ParcelFileDescriptor parcelFileDescriptor, List<ImageHeaderParser> list, InterfaceC1623b interfaceC1623b) {
            this.f4961a = (InterfaceC1623b) C1876j.m4985a(interfaceC1623b);
            this.f4962b = (List) C1876j.m4985a(list);
            this.f4963c = new C1613m(parcelFileDescriptor);
        }

        @Override // com.bumptech.glide.load.p125r.p126d.InterfaceC1749x
        @Nullable
        /* renamed from: a */
        public Bitmap mo4407a(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeFileDescriptor(this.f4963c.mo3858a().getFileDescriptor(), null, options);
        }

        @Override // com.bumptech.glide.load.p125r.p126d.InterfaceC1749x
        /* renamed from: b */
        public void mo4408b() {
        }

        @Override // com.bumptech.glide.load.p125r.p126d.InterfaceC1749x
        /* renamed from: c */
        public ImageHeaderParser.ImageType mo4409c() throws IOException {
            return C1592f.m3823b(this.f4962b, this.f4963c, this.f4961a);
        }

        @Override // com.bumptech.glide.load.p125r.p126d.InterfaceC1749x
        /* renamed from: a */
        public int mo4406a() throws IOException {
            return C1592f.m3819a(this.f4962b, this.f4963c, this.f4961a);
        }
    }
}
