package p248f.p249a.p250a;

import android.content.Context;
import android.graphics.Bitmap;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import p251g.p252a.AbstractC4519l;

/* compiled from: Compressor.java */
/* renamed from: f.a.a.b */
/* loaded from: classes2.dex */
public class C4449b {

    /* renamed from: a */
    private int f17179a = 612;

    /* renamed from: b */
    private int f17180b = 816;

    /* renamed from: c */
    private Bitmap.CompressFormat f17181c = Bitmap.CompressFormat.JPEG;

    /* renamed from: d */
    private int f17182d = 80;

    /* renamed from: e */
    private String f17183e;

    /* compiled from: Compressor.java */
    /* renamed from: f.a.a.b$a */
    class a implements Callable<AbstractC4519l<File>> {

        /* renamed from: a */
        final /* synthetic */ File f17184a;

        /* renamed from: b */
        final /* synthetic */ String f17185b;

        a(File file, String str) {
            this.f17184a = file;
            this.f17185b = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public AbstractC4519l<File> call() {
            try {
                return AbstractC4519l.m17651l(C4449b.this.m16425a(this.f17184a, this.f17185b));
            } catch (IOException e2) {
                return AbstractC4519l.m17582a((Throwable) e2);
            }
        }
    }

    /* compiled from: Compressor.java */
    /* renamed from: f.a.a.b$b */
    class b implements Callable<AbstractC4519l<Bitmap>> {

        /* renamed from: a */
        final /* synthetic */ File f17187a;

        b(File file) {
            this.f17187a = file;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public AbstractC4519l<Bitmap> call() {
            try {
                return AbstractC4519l.m17651l(C4449b.this.m16421a(this.f17187a));
            } catch (IOException e2) {
                return AbstractC4519l.m17582a((Throwable) e2);
            }
        }
    }

    public C4449b(Context context) {
        this.f17183e = context.getCacheDir().getPath() + File.separator + "images";
    }

    /* renamed from: a */
    public C4449b m16422a(int i2) {
        this.f17180b = i2;
        return this;
    }

    /* renamed from: b */
    public C4449b m16426b(int i2) {
        this.f17179a = i2;
        return this;
    }

    /* renamed from: c */
    public C4449b m16429c(int i2) {
        this.f17182d = i2;
        return this;
    }

    /* renamed from: d */
    public AbstractC4519l<File> m16431d(File file) {
        return m16428b(file, file.getName());
    }

    /* renamed from: a */
    public C4449b m16423a(Bitmap.CompressFormat compressFormat) {
        this.f17181c = compressFormat;
        return this;
    }

    /* renamed from: b */
    public AbstractC4519l<File> m16428b(File file, String str) {
        return AbstractC4519l.m17637d((Callable) new a(file, str));
    }

    /* renamed from: c */
    public File m16430c(File file) throws IOException {
        return m16425a(file, file.getName());
    }

    /* renamed from: a */
    public C4449b m16424a(String str) {
        this.f17183e = str;
        return this;
    }

    /* renamed from: b */
    public AbstractC4519l<Bitmap> m16427b(File file) {
        return AbstractC4519l.m17637d((Callable) new b(file));
    }

    /* renamed from: a */
    public File m16425a(File file, String str) throws IOException {
        return C4450c.m16434a(file, this.f17179a, this.f17180b, this.f17181c, this.f17182d, this.f17183e + File.separator + str);
    }

    /* renamed from: a */
    public Bitmap m16421a(File file) throws IOException {
        return C4450c.m16433a(file, this.f17179a, this.f17180b);
    }
}
