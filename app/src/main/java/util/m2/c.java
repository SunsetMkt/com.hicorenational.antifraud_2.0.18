package util.m2;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import util.s1;

/* JADX INFO: compiled from: MediaMuxerWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final boolean f14973h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f14974i = "MediaMuxerWrapper";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f14975j = "AVRecSample";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final SimpleDateFormat f14976k = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.US);
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MediaMuxer f14977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f14978c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f14979d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f14980e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b f14981f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private b f14982g;

    public c(String str) throws IOException {
        try {
            this.a = a(Environment.DIRECTORY_MOVIES, TextUtils.isEmpty(str) ? ".mp4" : str).toString();
            this.f14977b = new MediaMuxer(this.a, 0);
            this.f14979d = 0;
            this.f14978c = 0;
            this.f14980e = false;
        } catch (NullPointerException unused) {
            throw new RuntimeException("This app has no permission of writing external storage");
        }
    }

    private static final String h() {
        return f14976k.format(new GregorianCalendar().getTime());
    }

    public String a() {
        return this.a;
    }

    public synchronized boolean b() {
        return this.f14980e;
    }

    public void c() throws IOException {
        b bVar = this.f14981f;
        if (bVar != null) {
            bVar.e();
        }
        b bVar2 = this.f14982g;
        if (bVar2 != null) {
            bVar2.e();
        }
    }

    synchronized boolean d() {
        this.f14979d++;
        if (this.f14978c > 0 && this.f14979d == this.f14978c) {
            this.f14977b.start();
            this.f14980e = true;
            notifyAll();
        }
        return this.f14980e;
    }

    public void e() {
        b bVar = this.f14981f;
        if (bVar != null) {
            bVar.h();
        }
        b bVar2 = this.f14982g;
        if (bVar2 != null) {
            bVar2.h();
        }
    }

    synchronized void f() {
        this.f14979d--;
        if (this.f14978c > 0 && this.f14979d <= 0) {
            this.f14977b.stop();
            this.f14977b.release();
            this.f14980e = false;
        }
    }

    public void g() {
        b bVar = this.f14981f;
        if (bVar != null) {
            bVar.i();
        }
        this.f14981f = null;
        b bVar2 = this.f14982g;
        if (bVar2 != null) {
            bVar2.i();
        }
        this.f14982g = null;
    }

    void a(b bVar) {
        if (bVar instanceof d) {
            if (this.f14981f != null) {
                throw new IllegalArgumentException("Video encoder already added.");
            }
            this.f14981f = bVar;
        } else {
            if (!(bVar instanceof a)) {
                throw new IllegalArgumentException("unsupported encoder");
            }
            if (this.f14982g != null) {
                throw new IllegalArgumentException("Video encoder already added.");
            }
            this.f14982g = bVar;
        }
        this.f14978c = (this.f14981f != null ? 1 : 0) + (this.f14982g == null ? 0 : 1);
    }

    synchronized int a(MediaFormat mediaFormat) {
        if (!this.f14980e) {
        } else {
            throw new IllegalStateException("muxer already started");
        }
        return this.f14977b.addTrack(mediaFormat);
    }

    synchronized void a(int i2, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.f14979d > 0) {
            this.f14977b.writeSampleData(i2, byteBuffer, bufferInfo);
        }
    }

    public static final File a(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        File file = new File(e.d.f10177m);
        s1.a(f14974i, "path=" + file.toString());
        file.mkdirs();
        if (!file.canWrite()) {
            return null;
        }
        return new File(file, simpleDateFormat.format(new Date()) + str2);
    }
}
