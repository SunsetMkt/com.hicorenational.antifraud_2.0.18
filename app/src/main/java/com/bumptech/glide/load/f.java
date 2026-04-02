package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.r.d.b0;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: ImageHeaderParserUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class f {
    private static final int a = 5242880;

    /* JADX INFO: compiled from: ImageHeaderParserUtils.java */
    class a implements g {
        final /* synthetic */ InputStream a;

        a(InputStream inputStream) {
            this.a = inputStream;
        }

        @Override // com.bumptech.glide.load.f.g
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.a(this.a);
            } finally {
                this.a.reset();
            }
        }
    }

    /* JADX INFO: compiled from: ImageHeaderParserUtils.java */
    class b implements g {
        final /* synthetic */ ByteBuffer a;

        b(ByteBuffer byteBuffer) {
            this.a = byteBuffer;
        }

        @Override // com.bumptech.glide.load.f.g
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException {
            return imageHeaderParser.a(this.a);
        }
    }

    /* JADX INFO: compiled from: ImageHeaderParserUtils.java */
    class c implements g {
        final /* synthetic */ com.bumptech.glide.load.o.m a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.bumptech.glide.load.p.a0.b f2712b;

        c(com.bumptech.glide.load.o.m mVar, com.bumptech.glide.load.p.a0.b bVar) {
            this.a = mVar;
            this.f2712b = bVar;
        }

        @Override // com.bumptech.glide.load.f.g
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws Throwable {
            b0 b0Var;
            b0 b0Var2 = null;
            try {
                b0Var = new b0(new FileInputStream(this.a.a().getFileDescriptor()), this.f2712b);
            } catch (Throwable th) {
                th = th;
            }
            try {
                ImageHeaderParser.ImageType imageTypeA = imageHeaderParser.a(b0Var);
                try {
                    b0Var.close();
                } catch (IOException unused) {
                }
                this.a.a();
                return imageTypeA;
            } catch (Throwable th2) {
                th = th2;
                b0Var2 = b0Var;
                if (b0Var2 != null) {
                    try {
                        b0Var2.close();
                    } catch (IOException unused2) {
                    }
                }
                this.a.a();
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: ImageHeaderParserUtils.java */
    class d implements InterfaceC0043f {
        final /* synthetic */ InputStream a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.bumptech.glide.load.p.a0.b f2713b;

        d(InputStream inputStream, com.bumptech.glide.load.p.a0.b bVar) {
            this.a = inputStream;
            this.f2713b = bVar;
        }

        @Override // com.bumptech.glide.load.f.InterfaceC0043f
        public int a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.a(this.a, this.f2713b);
            } finally {
                this.a.reset();
            }
        }
    }

    /* JADX INFO: compiled from: ImageHeaderParserUtils.java */
    class e implements InterfaceC0043f {
        final /* synthetic */ com.bumptech.glide.load.o.m a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.bumptech.glide.load.p.a0.b f2714b;

        e(com.bumptech.glide.load.o.m mVar, com.bumptech.glide.load.p.a0.b bVar) {
            this.a = mVar;
            this.f2714b = bVar;
        }

        @Override // com.bumptech.glide.load.f.InterfaceC0043f
        public int a(ImageHeaderParser imageHeaderParser) throws Throwable {
            b0 b0Var;
            b0 b0Var2 = null;
            try {
                b0Var = new b0(new FileInputStream(this.a.a().getFileDescriptor()), this.f2714b);
            } catch (Throwable th) {
                th = th;
            }
            try {
                int iA = imageHeaderParser.a(b0Var, this.f2714b);
                try {
                    b0Var.close();
                } catch (IOException unused) {
                }
                this.a.a();
                return iA;
            } catch (Throwable th2) {
                th = th2;
                b0Var2 = b0Var;
                if (b0Var2 != null) {
                    try {
                        b0Var2.close();
                    } catch (IOException unused2) {
                    }
                }
                this.a.a();
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: com.bumptech.glide.load.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ImageHeaderParserUtils.java */
    private interface InterfaceC0043f {
        int a(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    /* JADX INFO: compiled from: ImageHeaderParserUtils.java */
    private interface g {
        ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    private f() {
    }

    @NonNull
    public static ImageHeaderParser.ImageType a(@NonNull List<ImageHeaderParser> list, @Nullable ByteBuffer byteBuffer) throws IOException {
        return byteBuffer == null ? ImageHeaderParser.ImageType.UNKNOWN : a(list, new b(byteBuffer));
    }

    @NonNull
    public static ImageHeaderParser.ImageType b(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull com.bumptech.glide.load.p.a0.b bVar) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new b0(inputStream, bVar);
        }
        inputStream.mark(5242880);
        return a(list, new a(inputStream));
    }

    @NonNull
    private static ImageHeaderParser.ImageType a(@NonNull List<ImageHeaderParser> list, g gVar) throws IOException {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ImageHeaderParser.ImageType imageTypeA = gVar.a(list.get(i2));
            if (imageTypeA != ImageHeaderParser.ImageType.UNKNOWN) {
                return imageTypeA;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @NonNull
    @RequiresApi(21)
    public static ImageHeaderParser.ImageType b(@NonNull List<ImageHeaderParser> list, @NonNull com.bumptech.glide.load.o.m mVar, @NonNull com.bumptech.glide.load.p.a0.b bVar) throws IOException {
        return a(list, new c(mVar, bVar));
    }

    public static int a(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull com.bumptech.glide.load.p.a0.b bVar) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new b0(inputStream, bVar);
        }
        inputStream.mark(5242880);
        return a(list, new d(inputStream, bVar));
    }

    @RequiresApi(21)
    public static int a(@NonNull List<ImageHeaderParser> list, @NonNull com.bumptech.glide.load.o.m mVar, @NonNull com.bumptech.glide.load.p.a0.b bVar) throws IOException {
        return a(list, new e(mVar, bVar));
    }

    private static int a(@NonNull List<ImageHeaderParser> list, InterfaceC0043f interfaceC0043f) throws IOException {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            int iA = interfaceC0043f.a(list.get(i2));
            if (iA != -1) {
                return iA;
            }
        }
        return -1;
    }
}
