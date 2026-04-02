package g.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import h.a.l;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: Compressor.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    private int a = 612;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10220b = 816;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Bitmap.CompressFormat f10221c = Bitmap.CompressFormat.JPEG;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f10222d = 80;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f10223e;

    /* JADX INFO: compiled from: Compressor.java */
    class a implements Callable<l<File>> {
        final /* synthetic */ File a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f10224b;

        a(File file, String str) {
            this.a = file;
            this.f10224b = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public l<File> call() {
            try {
                return l.l(b.this.a(this.a, this.f10224b));
            } catch (IOException e2) {
                return l.a((Throwable) e2);
            }
        }
    }

    /* JADX INFO: renamed from: g.a.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Compressor.java */
    class CallableC0167b implements Callable<l<Bitmap>> {
        final /* synthetic */ File a;

        CallableC0167b(File file) {
            this.a = file;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public l<Bitmap> call() {
            try {
                return l.l(b.this.a(this.a));
            } catch (IOException e2) {
                return l.a((Throwable) e2);
            }
        }
    }

    public b(Context context) {
        this.f10223e = context.getCacheDir().getPath() + File.separator + "images";
    }

    public b a(int i2) {
        this.f10220b = i2;
        return this;
    }

    public b b(int i2) {
        this.a = i2;
        return this;
    }

    public b c(int i2) {
        this.f10222d = i2;
        return this;
    }

    public l<File> d(File file) {
        return b(file, file.getName());
    }

    public b a(Bitmap.CompressFormat compressFormat) {
        this.f10221c = compressFormat;
        return this;
    }

    public l<File> b(File file, String str) {
        return l.d((Callable) new a(file, str));
    }

    public File c(File file) throws IOException {
        return a(file, file.getName());
    }

    public b a(String str) {
        this.f10223e = str;
        return this;
    }

    public l<Bitmap> b(File file) {
        return l.d((Callable) new CallableC0167b(file));
    }

    public File a(File file, String str) throws IOException {
        return c.a(file, this.a, this.f10220b, this.f10221c, this.f10222d, this.f10223e + File.separator + str);
    }

    public Bitmap a(File file) throws IOException {
        return c.a(file, this.a, this.f10220b);
    }
}
