package util.p394b2;

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
import util.C7301n1;
import util.p394b2.AbstractRunnableC7259b;

/* compiled from: MediaAudioEncoder.java */
/* renamed from: util.b2.a */
/* loaded from: classes2.dex */
public class C7258a extends AbstractRunnableC7259b {

    /* renamed from: s */
    private static final boolean f25135s = false;

    /* renamed from: t */
    private static final String f25136t = "MediaAudioEncoder";

    /* renamed from: u */
    private static final String f25137u = "audio/mp4a-latm";

    /* renamed from: v */
    private static final int f25138v = 44100;

    /* renamed from: w */
    private static final int f25139w = 8000;

    /* renamed from: x */
    public static final int f25140x = 1024;

    /* renamed from: y */
    public static final int f25141y = 25;

    /* renamed from: z */
    private static final int[] f25142z = {1, 0, 5, 7, 6};

    /* renamed from: r */
    private b f25143r;

    /* compiled from: MediaAudioEncoder.java */
    /* renamed from: util.b2.a$b */
    private class b extends Thread {
        private b() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(-19);
            try {
                int minBufferSize = AudioRecord.getMinBufferSize(C7258a.f25138v, 16, 2);
                int i2 = 25600 < minBufferSize ? ((minBufferSize / 1024) + 1) * 1024 * 2 : 25600;
                AudioRecord audioRecord = null;
                for (int i3 : C7258a.f25142z) {
                    try {
                        AudioRecord audioRecord2 = new AudioRecord(i3, C7258a.f25138v, 16, 2, i2);
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
                    C7301n1.m26457b(C7258a.f25136t, "failed to initialize AudioRecord");
                    return;
                }
                try {
                    if (C7258a.this.f25151b) {
                        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(1024);
                        audioRecord.startRecording();
                        while (C7258a.this.f25151b && !C7258a.this.f25153d && !C7258a.this.f25154e) {
                            try {
                                allocateDirect.clear();
                                int read = audioRecord.read(allocateDirect, 1024);
                                if (read > 0) {
                                    allocateDirect.position(read);
                                    allocateDirect.flip();
                                    C7258a.this.m26256a(allocateDirect, read, C7258a.this.m26259d());
                                    C7258a.this.mo26257b();
                                }
                            } catch (Throwable th) {
                                audioRecord.stop();
                                throw th;
                            }
                        }
                        C7258a.this.mo26257b();
                        audioRecord.stop();
                    }
                    audioRecord.release();
                } catch (Throwable th2) {
                    audioRecord.release();
                    throw th2;
                }
            } catch (Exception e2) {
                C7301n1.m26455a(C7258a.f25136t, "AudioThread#run", e2);
            }
        }
    }

    public C7258a(C7260c c7260c, AbstractRunnableC7259b.a aVar) {
        super(c7260c, aVar);
        this.f25143r = null;
    }

    /* renamed from: a */
    private static final MediaCodecInfo m26249a(String str) {
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

    @Override // util.p394b2.AbstractRunnableC7259b
    /* renamed from: e */
    protected void mo26251e() throws IOException {
        this.f25156g = -1;
        this.f25154e = false;
        this.f25155f = false;
        if (m26249a(f25137u) == null) {
            C7301n1.m26457b(f25136t, "Unable to find an appropriate codec for audio/mp4a-latm");
            return;
        }
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat(f25137u, f25138v, 1);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger("channel-mask", 16);
        createAudioFormat.setInteger("bitrate", 8000);
        createAudioFormat.setInteger("channel-count", 1);
        this.f25157h = MediaCodec.createEncoderByType(f25137u);
        this.f25157h.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f25157h.start();
        AbstractRunnableC7259b.a aVar = this.f25160k;
        if (aVar != null) {
            try {
                aVar.m26262a(this);
            } catch (Exception e2) {
                C7301n1.m26455a(f25136t, "prepare:", e2);
            }
        }
    }

    @Override // util.p394b2.AbstractRunnableC7259b
    /* renamed from: f */
    protected void mo26252f() {
        this.f25143r = null;
        super.mo26252f();
    }

    @Override // util.p394b2.AbstractRunnableC7259b
    /* renamed from: h */
    protected void mo26253h() {
        super.mo26253h();
        if (this.f25143r == null) {
            this.f25143r = new b();
            this.f25143r.start();
        }
    }
}
