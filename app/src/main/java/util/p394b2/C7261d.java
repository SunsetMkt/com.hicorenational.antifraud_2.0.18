package util.p394b2;

import android.hardware.display.VirtualDisplay;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.projection.MediaProjection;
import android.opengl.EGLContext;
import android.view.Surface;
import java.io.IOException;
import util.C7301n1;
import util.p394b2.AbstractRunnableC7259b;

/* compiled from: MediaVideoEncoder.java */
/* renamed from: util.b2.d */
/* loaded from: classes2.dex */
public class C7261d extends AbstractRunnableC7259b {

    /* renamed from: A */
    private static final int f25173A = 25;

    /* renamed from: B */
    private static final float f25174B = 0.25f;

    /* renamed from: C */
    protected static int[] f25175C = {2130708361};

    /* renamed from: x */
    private static final boolean f25176x = false;

    /* renamed from: y */
    private static final String f25177y = "MediaVideoEncoder";

    /* renamed from: z */
    private static final String f25178z = "video/avc";

    /* renamed from: r */
    private final int f25179r;

    /* renamed from: s */
    private final int f25180s;

    /* renamed from: t */
    private Surface f25181t;

    /* renamed from: u */
    private MediaProjection f25182u;

    /* renamed from: v */
    private VirtualDisplay f25183v;

    /* renamed from: w */
    private int f25184w;

    public C7261d(C7260c c7260c, AbstractRunnableC7259b.a aVar, int i2, int i3, MediaProjection mediaProjection) {
        super(c7260c, aVar);
        this.f25182u = null;
        this.f25183v = null;
        this.f25184w = 240;
        this.f25179r = i2;
        this.f25180s = i3;
        this.f25182u = mediaProjection;
    }

    /* renamed from: j */
    private int m26279j() {
        int i2 = (int) (this.f25179r * 6.25f * this.f25180s);
        C7301n1.m26459c(f25177y, String.format("bitrate=%5.2f[Mbps]", Float.valueOf((i2 / 1024.0f) / 1024.0f)));
        return i2;
    }

    /* renamed from: k */
    private VirtualDisplay m26280k() {
        MediaProjection mediaProjection = this.f25182u;
        if (mediaProjection == null || this.f25157h == null) {
            return null;
        }
        return mediaProjection.createVirtualDisplay("mediaProjection", this.f25179r, this.f25180s, this.f25184w, 16, this.f25181t, null, null);
    }

    /* renamed from: a */
    public void m26281a(EGLContext eGLContext, int i2) {
    }

    /* renamed from: a */
    public boolean m26282a(float[] fArr) {
        return super.mo26257b();
    }

    @Override // util.p394b2.AbstractRunnableC7259b
    /* renamed from: b */
    public boolean mo26257b() {
        return super.mo26257b();
    }

    @Override // util.p394b2.AbstractRunnableC7259b
    /* renamed from: e */
    protected void mo26251e() throws IOException {
        this.f25156g = -1;
        this.f25154e = false;
        this.f25155f = false;
        if (m26277a(f25178z) == null) {
            C7301n1.m26457b(f25177y, "Unable to find an appropriate codec for video/avc");
            return;
        }
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(f25178z, this.f25179r, this.f25180s);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("bitrate", m26279j());
        createVideoFormat.setInteger("frame-rate", 25);
        createVideoFormat.setInteger("i-frame-interval", 10);
        this.f25157h = MediaCodec.createEncoderByType(f25178z);
        this.f25157h.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f25181t = this.f25157h.createInputSurface();
        this.f25157h.start();
        this.f25183v = m26280k();
        AbstractRunnableC7259b.a aVar = this.f25160k;
        if (aVar != null) {
            try {
                aVar.m26262a(this);
            } catch (Exception e2) {
                C7301n1.m26455a(f25177y, "prepare:", e2);
            }
        }
    }

    @Override // util.p394b2.AbstractRunnableC7259b
    /* renamed from: f */
    protected void mo26252f() {
        Surface surface = this.f25181t;
        if (surface != null) {
            surface.release();
            this.f25181t = null;
        }
        super.mo26252f();
    }

    @Override // util.p394b2.AbstractRunnableC7259b
    /* renamed from: g */
    protected void mo26260g() {
        this.f25157h.signalEndOfInputStream();
        this.f25154e = true;
    }

    /* renamed from: a */
    public boolean m26283a(float[] fArr, float[] fArr2) {
        return super.mo26257b();
    }

    /* renamed from: a */
    protected static final MediaCodecInfo m26277a(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i2 = 0; i2 < codecCount; i2++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
            if (codecInfoAt.isEncoder()) {
                for (String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equalsIgnoreCase(str) && m26276a(codecInfoAt, str) > 0) {
                        return codecInfoAt;
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    protected static final int m26276a(MediaCodecInfo mediaCodecInfo, String str) {
        try {
            Thread.currentThread().setPriority(10);
            MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
            Thread.currentThread().setPriority(5);
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int[] iArr = capabilitiesForType.colorFormats;
                if (i3 >= iArr.length) {
                    break;
                }
                int i4 = iArr[i3];
                if (m26278a(i4)) {
                    i2 = i4;
                    break;
                }
                i3++;
            }
            if (i2 == 0) {
                C7301n1.m26457b(f25177y, "couldn't find a good color format for " + mediaCodecInfo.getName() + " / " + str);
            }
            return i2;
        } catch (Throwable th) {
            Thread.currentThread().setPriority(5);
            throw th;
        }
    }

    /* renamed from: a */
    private static final boolean m26278a(int i2) {
        int[] iArr = f25175C;
        int length = iArr != null ? iArr.length : 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (f25175C[i3] == i2) {
                return true;
            }
        }
        return false;
    }
}
