package util.m2;

import android.media.MediaCodec;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import util.s1;

/* JADX INFO: compiled from: MediaEncoder.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements Runnable {

    /* JADX INFO: renamed from: m */
    private static final boolean f14960m = false;

    /* JADX INFO: renamed from: n */
    private static final String f14961n = "MediaEncoder";
    protected static final int o = 10000;
    protected static final int p = 1;
    protected static final int q = 9;

    /* JADX INFO: renamed from: b */
    protected volatile boolean f14962b;

    /* JADX INFO: renamed from: c */
    private int f14963c;

    /* JADX INFO: renamed from: d */
    protected volatile boolean f14964d;

    /* JADX INFO: renamed from: e */
    protected boolean f14965e;

    /* JADX INFO: renamed from: f */
    protected boolean f14966f;

    /* JADX INFO: renamed from: g */
    protected int f14967g;

    /* JADX INFO: renamed from: h */
    protected MediaCodec f14968h;

    /* JADX INFO: renamed from: i */
    protected final WeakReference<c> f14969i;

    /* JADX INFO: renamed from: j */
    private MediaCodec.BufferInfo f14970j;

    /* JADX INFO: renamed from: k */
    protected final a f14971k;
    protected final Object a = new Object();

    /* JADX INFO: renamed from: l */
    private long f14972l = 0;

    /* JADX INFO: compiled from: MediaEncoder.java */
    public interface a {
        void a(b bVar);

        void b(b bVar);
    }

    public b(c cVar, a aVar) {
        if (aVar == null) {
            throw new NullPointerException("MediaEncoderListener is null");
        }
        if (cVar == null) {
            throw new NullPointerException("MediaMuxerWrapper is null");
        }
        this.f14969i = new WeakReference<>(cVar);
        cVar.a(this);
        this.f14971k = aVar;
        synchronized (this.a) {
            this.f14970j = new MediaCodec.BufferInfo();
            new Thread(this, getClass().getSimpleName()).start();
            try {
                this.a.wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    private void j() {
        boolean z;
        while (true) {
            synchronized (this.a) {
                z = this.f14964d;
                if (this.f14963c > 0) {
                    this.f14963c--;
                }
            }
            if (z) {
                a();
                g();
                a();
                f();
                return;
            }
            a();
        }
    }

    protected void a(ByteBuffer byteBuffer, int i2, long j2) {
        if (this.f14962b) {
            ByteBuffer[] inputBuffers = this.f14968h.getInputBuffers();
            while (this.f14962b) {
                int iDequeueInputBuffer = this.f14968h.dequeueInputBuffer(com.heytap.mcssdk.constant.a.q);
                if (iDequeueInputBuffer >= 0) {
                    ByteBuffer byteBuffer2 = inputBuffers[iDequeueInputBuffer];
                    byteBuffer2.clear();
                    if (byteBuffer != null) {
                        byteBuffer2.put(byteBuffer);
                    }
                    if (i2 > 0) {
                        this.f14968h.queueInputBuffer(iDequeueInputBuffer, 0, i2, j2, 0);
                        return;
                    } else {
                        this.f14965e = true;
                        this.f14968h.queueInputBuffer(iDequeueInputBuffer, 0, 0, j2, 4);
                        return;
                    }
                }
            }
        }
    }

    public boolean b() {
        synchronized (this.a) {
            if (this.f14962b && !this.f14964d) {
                this.f14963c++;
                this.a.notifyAll();
                return true;
            }
            return false;
        }
    }

    public String c() {
        c cVar = this.f14969i.get();
        if (cVar != null) {
            return cVar.a();
        }
        return null;
    }

    protected long d() {
        long jNanoTime = System.nanoTime() / 1000;
        long j2 = this.f14972l;
        return jNanoTime < j2 ? jNanoTime + (j2 - jNanoTime) : jNanoTime;
    }

    abstract void e() throws IOException;

    protected void f() {
        try {
            this.f14971k.b(this);
        } catch (Exception e2) {
            s1.a(f14961n, "failed onStopped", e2);
        }
        this.f14962b = false;
        MediaCodec mediaCodec = this.f14968h;
        if (mediaCodec != null) {
            try {
                mediaCodec.stop();
                this.f14968h.release();
                this.f14968h = null;
            } catch (Exception e3) {
                s1.a(f14961n, "failed releasing MediaCodec", e3);
            }
        }
        if (this.f14966f) {
            WeakReference<c> weakReference = this.f14969i;
            c cVar = weakReference != null ? weakReference.get() : null;
            if (cVar != null) {
                try {
                    cVar.f();
                } catch (Exception e4) {
                    s1.a(f14961n, "failed stopping muxer", e4);
                }
            }
        }
        this.f14970j = null;
    }

    protected void g() {
        a(null, 0, d());
    }

    void h() {
        synchronized (this.a) {
            this.f14962b = true;
            this.f14964d = false;
            this.a.notifyAll();
        }
    }

    void i() {
        synchronized (this.a) {
            if (this.f14962b && !this.f14964d) {
                this.f14964d = true;
                this.a.notifyAll();
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.a) {
            this.f14964d = false;
            this.f14963c = 0;
            this.a.notify();
        }
        j();
        synchronized (this.a) {
            this.f14964d = true;
            this.f14962b = false;
        }
    }

    protected void a() {
        MediaCodec mediaCodec = this.f14968h;
        if (mediaCodec == null) {
            return;
        }
        try {
            ByteBuffer[] outputBuffers = mediaCodec.getOutputBuffers();
            c cVar = this.f14969i.get();
            if (cVar == null) {
                s1.f(f14961n, "muxer is unexpectedly null");
                return;
            }
            ByteBuffer[] outputBuffers2 = outputBuffers;
            int i2 = 0;
            while (this.f14962b) {
                int iDequeueOutputBuffer = this.f14968h.dequeueOutputBuffer(this.f14970j, com.heytap.mcssdk.constant.a.q);
                if (iDequeueOutputBuffer == -1) {
                    if (!this.f14965e && (i2 = i2 + 1) > 5) {
                        return;
                    }
                } else if (iDequeueOutputBuffer == -3) {
                    outputBuffers2 = this.f14968h.getOutputBuffers();
                } else if (iDequeueOutputBuffer == -2) {
                    if (!this.f14966f) {
                        this.f14967g = cVar.a(this.f14968h.getOutputFormat());
                        this.f14966f = true;
                        if (cVar.d()) {
                            continue;
                        } else {
                            synchronized (cVar) {
                                while (!cVar.b()) {
                                    try {
                                        cVar.wait(100L);
                                    } catch (InterruptedException unused) {
                                        return;
                                    }
                                }
                            }
                        }
                    } else {
                        throw new RuntimeException("format changed twice");
                    }
                } else if (iDequeueOutputBuffer >= 0) {
                    ByteBuffer byteBuffer = outputBuffers2[iDequeueOutputBuffer];
                    if (byteBuffer != null) {
                        MediaCodec.BufferInfo bufferInfo = this.f14970j;
                        if ((bufferInfo.flags & 2) != 0) {
                            bufferInfo.size = 0;
                        }
                        MediaCodec.BufferInfo bufferInfo2 = this.f14970j;
                        if (bufferInfo2.size != 0) {
                            if (this.f14966f) {
                                bufferInfo2.presentationTimeUs = d();
                                cVar.a(this.f14967g, byteBuffer, this.f14970j);
                                this.f14972l = this.f14970j.presentationTimeUs;
                                i2 = 0;
                            } else {
                                throw new RuntimeException("drain:muxer hasn't started");
                            }
                        }
                        this.f14968h.releaseOutputBuffer(iDequeueOutputBuffer, false);
                        if ((this.f14970j.flags & 4) != 0) {
                            this.f14962b = false;
                            return;
                        }
                    } else {
                        throw new RuntimeException("encoderOutputBuffer " + iDequeueOutputBuffer + " was null");
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
