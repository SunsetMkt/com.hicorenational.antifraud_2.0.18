package androidx.camera.camera2.internal;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c0 implements Runnable {
    private final /* synthetic */ Camera2CameraControl a;

    @Override // java.lang.Runnable
    public final void run() {
        this.a.updateSessionConfig();
    }
}
