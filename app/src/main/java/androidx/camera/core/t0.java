package androidx.camera.core;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class t0 implements Runnable {
    private final /* synthetic */ ImageCapture a;

    @Override // java.lang.Runnable
    public final void run() {
        this.a.issueImageCaptureRequests();
    }
}
