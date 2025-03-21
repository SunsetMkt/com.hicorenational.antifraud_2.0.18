package util.p394b2;

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
import p245d.C4443d;
import util.C7301n1;

/* compiled from: MediaMuxerWrapper.java */
/* renamed from: util.b2.c */
/* loaded from: classes2.dex */
public class C7260c {

    /* renamed from: h */
    private static final boolean f25162h = false;

    /* renamed from: i */
    private static final String f25163i = "MediaMuxerWrapper";

    /* renamed from: j */
    private static final String f25164j = "AVRecSample";

    /* renamed from: k */
    private static final SimpleDateFormat f25165k = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.US);

    /* renamed from: a */
    private String f25166a;

    /* renamed from: b */
    private final MediaMuxer f25167b;

    /* renamed from: c */
    private int f25168c;

    /* renamed from: d */
    private int f25169d;

    /* renamed from: e */
    private boolean f25170e;

    /* renamed from: f */
    private AbstractRunnableC7259b f25171f;

    /* renamed from: g */
    private AbstractRunnableC7259b f25172g;

    public C7260c(String str) throws IOException {
        try {
            this.f25166a = m26264a(Environment.DIRECTORY_MOVIES, TextUtils.isEmpty(str) ? ".mp4" : str).toString();
            this.f25167b = new MediaMuxer(this.f25166a, 0);
            this.f25169d = 0;
            this.f25168c = 0;
            this.f25170e = false;
        } catch (NullPointerException unused) {
            throw new RuntimeException("This app has no permission of writing external storage");
        }
    }

    /* renamed from: h */
    private static final String m26265h() {
        return f25165k.format(new GregorianCalendar().getTime());
    }

    /* renamed from: a */
    public String m26267a() {
        return this.f25166a;
    }

    /* renamed from: b */
    public synchronized boolean m26270b() {
        return this.f25170e;
    }

    /* renamed from: c */
    public void m26271c() throws IOException {
        AbstractRunnableC7259b abstractRunnableC7259b = this.f25171f;
        if (abstractRunnableC7259b != null) {
            abstractRunnableC7259b.mo26251e();
        }
        AbstractRunnableC7259b abstractRunnableC7259b2 = this.f25172g;
        if (abstractRunnableC7259b2 != null) {
            abstractRunnableC7259b2.mo26251e();
        }
    }

    /* renamed from: d */
    synchronized boolean m26272d() {
        this.f25169d++;
        if (this.f25168c > 0 && this.f25169d == this.f25168c) {
            this.f25167b.start();
            this.f25170e = true;
            notifyAll();
        }
        return this.f25170e;
    }

    /* renamed from: e */
    public void m26273e() {
        AbstractRunnableC7259b abstractRunnableC7259b = this.f25171f;
        if (abstractRunnableC7259b != null) {
            abstractRunnableC7259b.mo26253h();
        }
        AbstractRunnableC7259b abstractRunnableC7259b2 = this.f25172g;
        if (abstractRunnableC7259b2 != null) {
            abstractRunnableC7259b2.mo26253h();
        }
    }

    /* renamed from: f */
    synchronized void m26274f() {
        this.f25169d--;
        if (this.f25168c > 0 && this.f25169d <= 0) {
            this.f25167b.stop();
            this.f25167b.release();
            this.f25170e = false;
        }
    }

    /* renamed from: g */
    public void m26275g() {
        AbstractRunnableC7259b abstractRunnableC7259b = this.f25171f;
        if (abstractRunnableC7259b != null) {
            abstractRunnableC7259b.m26261i();
        }
        this.f25171f = null;
        AbstractRunnableC7259b abstractRunnableC7259b2 = this.f25172g;
        if (abstractRunnableC7259b2 != null) {
            abstractRunnableC7259b2.m26261i();
        }
        this.f25172g = null;
    }

    /* renamed from: a */
    void m26269a(AbstractRunnableC7259b abstractRunnableC7259b) {
        if (abstractRunnableC7259b instanceof C7261d) {
            if (this.f25171f != null) {
                throw new IllegalArgumentException("Video encoder already added.");
            }
            this.f25171f = abstractRunnableC7259b;
        } else {
            if (!(abstractRunnableC7259b instanceof C7258a)) {
                throw new IllegalArgumentException("unsupported encoder");
            }
            if (this.f25172g != null) {
                throw new IllegalArgumentException("Video encoder already added.");
            }
            this.f25172g = abstractRunnableC7259b;
        }
        this.f25168c = (this.f25171f != null ? 1 : 0) + (this.f25172g == null ? 0 : 1);
    }

    /* renamed from: a */
    synchronized int m26266a(MediaFormat mediaFormat) {
        if (!this.f25170e) {
        } else {
            throw new IllegalStateException("muxer already started");
        }
        return this.f25167b.addTrack(mediaFormat);
    }

    /* renamed from: a */
    synchronized void m26268a(int i2, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.f25169d > 0) {
            this.f25167b.writeSampleData(i2, byteBuffer, bufferInfo);
        }
    }

    /* renamed from: a */
    public static final File m26264a(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        File file = new File(C4443d.f16966m);
        C7301n1.m26454a(f25163i, "path=" + file.toString());
        file.mkdirs();
        if (!file.canWrite()) {
            return null;
        }
        return new File(file, simpleDateFormat.format(new Date()) + str2);
    }
}
