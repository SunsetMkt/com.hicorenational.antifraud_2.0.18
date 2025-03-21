package util.p394b2;

import android.media.MediaCodec;
import com.heytap.mcssdk.constant.C2084a;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import util.C7301n1;

/* compiled from: MediaEncoder.java */
/* renamed from: util.b2.b */
/* loaded from: classes2.dex */
public abstract class AbstractRunnableC7259b implements Runnable {

    /* renamed from: m */
    private static final boolean f25145m = false;

    /* renamed from: n */
    private static final String f25146n = "MediaEncoder";

    /* renamed from: o */
    protected static final int f25147o = 10000;

    /* renamed from: p */
    protected static final int f25148p = 1;

    /* renamed from: q */
    protected static final int f25149q = 9;

    /* renamed from: b */
    protected volatile boolean f25151b;

    /* renamed from: c */
    private int f25152c;

    /* renamed from: d */
    protected volatile boolean f25153d;

    /* renamed from: e */
    protected boolean f25154e;

    /* renamed from: f */
    protected boolean f25155f;

    /* renamed from: g */
    protected int f25156g;

    /* renamed from: h */
    protected MediaCodec f25157h;

    /* renamed from: i */
    protected final WeakReference<C7260c> f25158i;

    /* renamed from: j */
    private MediaCodec.BufferInfo f25159j;

    /* renamed from: k */
    protected final a f25160k;

    /* renamed from: a */
    protected final Object f25150a = new Object();

    /* renamed from: l */
    private long f25161l = 0;

    /* compiled from: MediaEncoder.java */
    /* renamed from: util.b2.b$a */
    public interface a {
        /* renamed from: a */
        void m26262a(AbstractRunnableC7259b abstractRunnableC7259b);

        /* renamed from: b */
        void m26263b(AbstractRunnableC7259b abstractRunnableC7259b);
    }

    public AbstractRunnableC7259b(C7260c c7260c, a aVar) {
        if (aVar == null) {
            throw new NullPointerException("MediaEncoderListener is null");
        }
        if (c7260c == null) {
            throw new NullPointerException("MediaMuxerWrapper is null");
        }
        this.f25158i = new WeakReference<>(c7260c);
        c7260c.m26269a(this);
        this.f25160k = aVar;
        synchronized (this.f25150a) {
            this.f25159j = new MediaCodec.BufferInfo();
            new Thread(this, getClass().getSimpleName()).start();
            try {
                this.f25150a.wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    /* renamed from: j */
    private void m26254j() {
        boolean z;
        while (true) {
            synchronized (this.f25150a) {
                z = this.f25153d;
                if (this.f25152c > 0) {
                    this.f25152c--;
                }
            }
            if (z) {
                m26255a();
                mo26260g();
                m26255a();
                mo26252f();
                return;
            }
            m26255a();
        }
    }

    /* renamed from: a */
    protected void m26256a(ByteBuffer byteBuffer, int i2, long j2) {
        if (this.f25151b) {
            ByteBuffer[] inputBuffers = this.f25157h.getInputBuffers();
            while (this.f25151b) {
                int dequeueInputBuffer = this.f25157h.dequeueInputBuffer(C2084a.f6135q);
                if (dequeueInputBuffer >= 0) {
                    ByteBuffer byteBuffer2 = inputBuffers[dequeueInputBuffer];
                    byteBuffer2.clear();
                    if (byteBuffer != null) {
                        byteBuffer2.put(byteBuffer);
                    }
                    if (i2 > 0) {
                        this.f25157h.queueInputBuffer(dequeueInputBuffer, 0, i2, j2, 0);
                        return;
                    } else {
                        this.f25154e = true;
                        this.f25157h.queueInputBuffer(dequeueInputBuffer, 0, 0, j2, 4);
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public boolean mo26257b() {
        synchronized (this.f25150a) {
            if (this.f25151b && !this.f25153d) {
                this.f25152c++;
                this.f25150a.notifyAll();
                return true;
            }
            return false;
        }
    }

    /* renamed from: c */
    public String m26258c() {
        C7260c c7260c = this.f25158i.get();
        if (c7260c != null) {
            return c7260c.m26267a();
        }
        return null;
    }

    /* renamed from: d */
    protected long m26259d() {
        long nanoTime = System.nanoTime() / 1000;
        long j2 = this.f25161l;
        return nanoTime < j2 ? nanoTime + (j2 - nanoTime) : nanoTime;
    }

    /* renamed from: e */
    abstract void mo26251e() throws IOException;

    /* renamed from: f */
    protected void mo26252f() {
        try {
            this.f25160k.m26263b(this);
        } catch (Exception e2) {
            C7301n1.m26455a(f25146n, "failed onStopped", e2);
        }
        this.f25151b = false;
        MediaCodec mediaCodec = this.f25157h;
        if (mediaCodec != null) {
            try {
                mediaCodec.stop();
                this.f25157h.release();
                this.f25157h = null;
            } catch (Exception e3) {
                C7301n1.m26455a(f25146n, "failed releasing MediaCodec", e3);
            }
        }
        if (this.f25155f) {
            WeakReference<C7260c> weakReference = this.f25158i;
            C7260c c7260c = weakReference != null ? weakReference.get() : null;
            if (c7260c != null) {
                try {
                    c7260c.m26274f();
                } catch (Exception e4) {
                    C7301n1.m26455a(f25146n, "failed stopping muxer", e4);
                }
            }
        }
        this.f25159j = null;
    }

    /* renamed from: g */
    protected void mo26260g() {
        m26256a(null, 0, m26259d());
    }

    /* renamed from: h */
    void mo26253h() {
        synchronized (this.f25150a) {
            this.f25151b = true;
            this.f25153d = false;
            this.f25150a.notifyAll();
        }
    }

    /* renamed from: i */
    void m26261i() {
        synchronized (this.f25150a) {
            if (this.f25151b && !this.f25153d) {
                this.f25153d = true;
                this.f25150a.notifyAll();
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.f25150a) {
            this.f25153d = false;
            this.f25152c = 0;
            this.f25150a.notify();
        }
        m26254j();
        synchronized (this.f25150a) {
            this.f25153d = true;
            this.f25151b = false;
        }
    }

    /* renamed from: a */
    protected void m26255a() {
        MediaCodec mediaCodec = this.f25157h;
        if (mediaCodec == null) {
            return;
        }
        try {
            ByteBuffer[] outputBuffers = mediaCodec.getOutputBuffers();
            C7260c c7260c = this.f25158i.get();
            if (c7260c == null) {
                C7301n1.m26465f(f25146n, "muxer is unexpectedly null");
                return;
            }
            ByteBuffer[] byteBufferArr = outputBuffers;
            int i2 = 0;
            while (this.f25151b) {
                int dequeueOutputBuffer = this.f25157h.dequeueOutputBuffer(this.f25159j, C2084a.f6135q);
                if (dequeueOutputBuffer == -1) {
                    if (!this.f25154e && (i2 = i2 + 1) > 5) {
                        return;
                    }
                } else if (dequeueOutputBuffer == -3) {
                    byteBufferArr = this.f25157h.getOutputBuffers();
                } else if (dequeueOutputBuffer == -2) {
                    if (!this.f25155f) {
                        this.f25156g = c7260c.m26266a(this.f25157h.getOutputFormat());
                        this.f25155f = true;
                        if (c7260c.m26272d()) {
                            continue;
                        } else {
                            synchronized (c7260c) {
                                while (!c7260c.m26270b()) {
                                    try {
                                        c7260c.wait(100L);
                                    } catch (InterruptedException unused) {
                                        return;
                                    }
                                }
                            }
                        }
                    } else {
                        throw new RuntimeException("format changed twice");
                    }
                } else if (dequeueOutputBuffer >= 0) {
                    ByteBuffer byteBuffer = byteBufferArr[dequeueOutputBuffer];
                    if (byteBuffer != null) {
                        MediaCodec.BufferInfo bufferInfo = this.f25159j;
                        if ((bufferInfo.flags & 2) != 0) {
                            bufferInfo.size = 0;
                        }
                        MediaCodec.BufferInfo bufferInfo2 = this.f25159j;
                        if (bufferInfo2.size != 0) {
                            if (this.f25155f) {
                                bufferInfo2.presentationTimeUs = m26259d();
                                c7260c.m26268a(this.f25156g, byteBuffer, this.f25159j);
                                this.f25161l = this.f25159j.presentationTimeUs;
                                i2 = 0;
                            } else {
                                throw new RuntimeException("drain:muxer hasn't started");
                            }
                        }
                        this.f25157h.releaseOutputBuffer(dequeueOutputBuffer, false);
                        if ((this.f25159j.flags & 4) != 0) {
                            this.f25151b = false;
                            return;
                        }
                    } else {
                        throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                    }
                } else {
                    continue;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
