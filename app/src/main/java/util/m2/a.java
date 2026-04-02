package util.m2;

import android.media.AudioRecord;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Process;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;
import util.m2.b;
import util.s1;

/* JADX INFO: compiled from: MediaAudioEncoder.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends util.m2.b {
    private static final boolean s = false;
    private static final String t = "MediaAudioEncoder";
    private static final String u = "audio/mp4a-latm";
    private static final int v = 44100;
    private static final int w = 8000;
    public static final int x = 1024;
    public static final int y = 25;
    private static final int[] z = {1, 0, 5, 7, 6};
    private b r;

    /* JADX INFO: compiled from: MediaAudioEncoder.java */
    private class b extends Thread {
        private b() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(-19);
            try {
                int minBufferSize = AudioRecord.getMinBufferSize(a.v, 16, 2);
                int i2 = 25600 < minBufferSize ? ((minBufferSize / 1024) + 1) * 1024 * 2 : 25600;
                AudioRecord audioRecord = null;
                for (int i3 : a.z) {
                    try {
                        AudioRecord audioRecord2 = new AudioRecord(i3, a.v, 16, 2, i2);
                        if (audioRecord2.getState() != 1) {
                            audioRecord2 = null;
                        }
                        audioRecord = audioRecord2;
                    } catch (Exception unused) {
                        audioRecord = null;
                    }
                    if (audioRecord != null) {
                        break;
                    }
                }
                if (audioRecord == null) {
                    s1.b(a.t, "failed to initialize AudioRecord");
                    return;
                }
                try {
                    if (a.this.f14962b) {
                        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(1024);
                        audioRecord.startRecording();
                        while (a.this.f14962b && !a.this.f14964d && !a.this.f14965e) {
                            try {
                                byteBufferAllocateDirect.clear();
                                int i4 = audioRecord.read(byteBufferAllocateDirect, 1024);
                                if (i4 > 0) {
                                    byteBufferAllocateDirect.position(i4);
                                    byteBufferAllocateDirect.flip();
                                    a.this.a(byteBufferAllocateDirect, i4, a.this.d());
                                    a.this.b();
                                }
                            } catch (Throwable th) {
                                audioRecord.stop();
                                throw th;
                            }
                        }
                        a.this.b();
                        audioRecord.stop();
                    }
                    audioRecord.release();
                } catch (Throwable th2) {
                    audioRecord.release();
                    throw th2;
                }
            } catch (Exception e2) {
                s1.a(a.t, "AudioThread#run", e2);
            }
        }

        /* synthetic */ b(a aVar, C0325a c0325a) {
            this();
        }
    }

    public a(c cVar, b.a aVar) {
        super(cVar, aVar);
        this.r = null;
    }

    private static final MediaCodecInfo a(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i2 = 0; i2 < codecCount; i2++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
            if (codecInfoAt.isEncoder()) {
                for (String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equalsIgnoreCase(str)) {
                        return codecInfoAt;
                    }
                }
            }
        }
        return null;
    }

    @Override // util.m2.b
    protected void e() throws IOException {
        this.f14967g = -1;
        this.f14965e = false;
        this.f14966f = false;
        if (a(u) == null) {
            s1.b(t, "Unable to find an appropriate codec for audio/mp4a-latm");
            return;
        }
        MediaFormat mediaFormatCreateAudioFormat = MediaFormat.createAudioFormat(u, v, 1);
        mediaFormatCreateAudioFormat.setInteger("aac-profile", 2);
        mediaFormatCreateAudioFormat.setInteger("channel-mask", 16);
        mediaFormatCreateAudioFormat.setInteger("bitrate", 8000);
        mediaFormatCreateAudioFormat.setInteger("channel-count", 1);
        this.f14968h = MediaCodec.createEncoderByType(u);
        this.f14968h.configure(mediaFormatCreateAudioFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f14968h.start();
        b.a aVar = this.f14971k;
        if (aVar != null) {
            try {
                aVar.a(this);
            } catch (Exception e2) {
                s1.a(t, "prepare:", e2);
            }
        }
    }

    @Override // util.m2.b
    protected void f() {
        this.r = null;
        super.f();
    }

    @Override // util.m2.b
    protected void h() {
        super.h();
        if (this.r == null) {
            this.r = new b();
            this.r.start();
        }
    }
}
