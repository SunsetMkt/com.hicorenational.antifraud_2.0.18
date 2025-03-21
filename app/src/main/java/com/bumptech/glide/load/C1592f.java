package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.p116o.C1613m;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1623b;
import com.bumptech.glide.load.p125r.p126d.C1719b0;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: ImageHeaderParserUtils.java */
/* renamed from: com.bumptech.glide.load.f */
/* loaded from: classes.dex */
public final class C1592f {

    /* renamed from: a */
    private static final int f4181a = 5242880;

    /* compiled from: ImageHeaderParserUtils.java */
    /* renamed from: com.bumptech.glide.load.f$a */
    class a implements g {

        /* renamed from: a */
        final /* synthetic */ InputStream f4182a;

        a(InputStream inputStream) {
            this.f4182a = inputStream;
        }

        @Override // com.bumptech.glide.load.C1592f.g
        /* renamed from: a */
        public ImageHeaderParser.ImageType mo3825a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.mo3815a(this.f4182a);
            } finally {
                this.f4182a.reset();
            }
        }
    }

    /* compiled from: ImageHeaderParserUtils.java */
    /* renamed from: com.bumptech.glide.load.f$b */
    class b implements g {

        /* renamed from: a */
        final /* synthetic */ ByteBuffer f4183a;

        b(ByteBuffer byteBuffer) {
            this.f4183a = byteBuffer;
        }

        @Override // com.bumptech.glide.load.C1592f.g
        /* renamed from: a */
        public ImageHeaderParser.ImageType mo3825a(ImageHeaderParser imageHeaderParser) throws IOException {
            return imageHeaderParser.mo3816a(this.f4183a);
        }
    }

    /* compiled from: ImageHeaderParserUtils.java */
    /* renamed from: com.bumptech.glide.load.f$c */
    class c implements g {

        /* renamed from: a */
        final /* synthetic */ C1613m f4184a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC1623b f4185b;

        c(C1613m c1613m, InterfaceC1623b interfaceC1623b) {
            this.f4184a = c1613m;
            this.f4185b = interfaceC1623b;
        }

        @Override // com.bumptech.glide.load.C1592f.g
        /* renamed from: a */
        public ImageHeaderParser.ImageType mo3825a(ImageHeaderParser imageHeaderParser) throws IOException {
            C1719b0 c1719b0;
            C1719b0 c1719b02 = null;
            try {
                c1719b0 = new C1719b0(new FileInputStream(this.f4184a.mo3858a().getFileDescriptor()), this.f4185b);
            } catch (Throwable th) {
                th = th;
            }
            try {
                ImageHeaderParser.ImageType mo3815a = imageHeaderParser.mo3815a(c1719b0);
                try {
                    c1719b0.close();
                } catch (IOException unused) {
                }
                this.f4184a.mo3858a();
                return mo3815a;
            } catch (Throwable th2) {
                th = th2;
                c1719b02 = c1719b0;
                if (c1719b02 != null) {
                    try {
                        c1719b02.close();
                    } catch (IOException unused2) {
                    }
                }
                this.f4184a.mo3858a();
                throw th;
            }
        }
    }

    /* compiled from: ImageHeaderParserUtils.java */
    /* renamed from: com.bumptech.glide.load.f$d */
    class d implements f {

        /* renamed from: a */
        final /* synthetic */ InputStream f4186a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC1623b f4187b;

        d(InputStream inputStream, InterfaceC1623b interfaceC1623b) {
            this.f4186a = inputStream;
            this.f4187b = interfaceC1623b;
        }

        @Override // com.bumptech.glide.load.C1592f.f
        /* renamed from: a */
        public int mo3826a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.mo3813a(this.f4186a, this.f4187b);
            } finally {
                this.f4186a.reset();
            }
        }
    }

    /* compiled from: ImageHeaderParserUtils.java */
    /* renamed from: com.bumptech.glide.load.f$e */
    class e implements f {

        /* renamed from: a */
        final /* synthetic */ C1613m f4188a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC1623b f4189b;

        e(C1613m c1613m, InterfaceC1623b interfaceC1623b) {
            this.f4188a = c1613m;
            this.f4189b = interfaceC1623b;
        }

        @Override // com.bumptech.glide.load.C1592f.f
        /* renamed from: a */
        public int mo3826a(ImageHeaderParser imageHeaderParser) throws IOException {
            C1719b0 c1719b0;
            C1719b0 c1719b02 = null;
            try {
                c1719b0 = new C1719b0(new FileInputStream(this.f4188a.mo3858a().getFileDescriptor()), this.f4189b);
            } catch (Throwable th) {
                th = th;
            }
            try {
                int mo3813a = imageHeaderParser.mo3813a(c1719b0, this.f4189b);
                try {
                    c1719b0.close();
                } catch (IOException unused) {
                }
                this.f4188a.mo3858a();
                return mo3813a;
            } catch (Throwable th2) {
                th = th2;
                c1719b02 = c1719b0;
                if (c1719b02 != null) {
                    try {
                        c1719b02.close();
                    } catch (IOException unused2) {
                    }
                }
                this.f4188a.mo3858a();
                throw th;
            }
        }
    }

    /* compiled from: ImageHeaderParserUtils.java */
    /* renamed from: com.bumptech.glide.load.f$f */
    private interface f {
        /* renamed from: a */
        int mo3826a(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    /* compiled from: ImageHeaderParserUtils.java */
    /* renamed from: com.bumptech.glide.load.f$g */
    private interface g {
        /* renamed from: a */
        ImageHeaderParser.ImageType mo3825a(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    private C1592f() {
    }

    @NonNull
    /* renamed from: a */
    public static ImageHeaderParser.ImageType m3822a(@NonNull List<ImageHeaderParser> list, @Nullable ByteBuffer byteBuffer) throws IOException {
        return byteBuffer == null ? ImageHeaderParser.ImageType.UNKNOWN : m3821a(list, new b(byteBuffer));
    }

    @NonNull
    /* renamed from: b */
    public static ImageHeaderParser.ImageType m3824b(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull InterfaceC1623b interfaceC1623b) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new C1719b0(inputStream, interfaceC1623b);
        }
        inputStream.mark(5242880);
        return m3821a(list, new a(inputStream));
    }

    @NonNull
    /* renamed from: a */
    private static ImageHeaderParser.ImageType m3821a(@NonNull List<ImageHeaderParser> list, g gVar) throws IOException {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ImageHeaderParser.ImageType mo3825a = gVar.mo3825a(list.get(i2));
            if (mo3825a != ImageHeaderParser.ImageType.UNKNOWN) {
                return mo3825a;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @NonNull
    @RequiresApi(21)
    /* renamed from: b */
    public static ImageHeaderParser.ImageType m3823b(@NonNull List<ImageHeaderParser> list, @NonNull C1613m c1613m, @NonNull InterfaceC1623b interfaceC1623b) throws IOException {
        return m3821a(list, new c(c1613m, interfaceC1623b));
    }

    /* renamed from: a */
    public static int m3820a(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull InterfaceC1623b interfaceC1623b) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new C1719b0(inputStream, interfaceC1623b);
        }
        inputStream.mark(5242880);
        return m3818a(list, new d(inputStream, interfaceC1623b));
    }

    @RequiresApi(21)
    /* renamed from: a */
    public static int m3819a(@NonNull List<ImageHeaderParser> list, @NonNull C1613m c1613m, @NonNull InterfaceC1623b interfaceC1623b) throws IOException {
        return m3818a(list, new e(c1613m, interfaceC1623b));
    }

    /* renamed from: a */
    private static int m3818a(@NonNull List<ImageHeaderParser> list, f fVar) throws IOException {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            int mo3826a = fVar.mo3826a(list.get(i2));
            if (mo3826a != -1) {
                return mo3826a;
            }
        }
        return -1;
    }
}
