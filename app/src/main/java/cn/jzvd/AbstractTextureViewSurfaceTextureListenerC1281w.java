package cn.jzvd;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import android.view.TextureView;

/* compiled from: JZMediaInterface.java */
/* renamed from: cn.jzvd.w */
/* loaded from: classes.dex */
public abstract class AbstractTextureViewSurfaceTextureListenerC1281w implements TextureView.SurfaceTextureListener {

    /* renamed from: e */
    public static SurfaceTexture f2866e;

    /* renamed from: a */
    public HandlerThread f2867a;

    /* renamed from: b */
    public Handler f2868b;

    /* renamed from: c */
    public Handler f2869c;

    /* renamed from: d */
    public Jzvd f2870d;

    public AbstractTextureViewSurfaceTextureListenerC1281w(Jzvd jzvd) {
        this.f2870d = jzvd;
    }

    /* renamed from: a */
    public abstract long mo2523a();

    /* renamed from: a */
    public abstract void mo2524a(float f2);

    /* renamed from: a */
    public abstract void mo2525a(float f2, float f3);

    /* renamed from: a */
    public abstract void mo2526a(long j2);

    /* renamed from: a */
    public abstract void mo2527a(Surface surface);

    /* renamed from: b */
    public abstract long mo2528b();

    /* renamed from: c */
    public abstract boolean mo2529c();

    /* renamed from: d */
    public abstract void mo2530d();

    /* renamed from: e */
    public abstract void mo2531e();

    /* renamed from: f */
    public abstract void mo2532f();

    /* renamed from: g */
    public abstract void mo2533g();
}
