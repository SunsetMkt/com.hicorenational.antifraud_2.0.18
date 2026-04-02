package ui.view;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import java.io.File;

/* JADX INFO: compiled from: SingleMediaScanner.java */
/* JADX INFO: loaded from: classes2.dex */
public class v implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private File f14831b;

    public v(Context context, File file) {
        this.f14831b = file;
        this.a = new MediaScannerConnection(context, this);
        this.a.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        this.a.scanFile(this.f14831b.getAbsolutePath(), null);
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        this.a.disconnect();
    }
}
