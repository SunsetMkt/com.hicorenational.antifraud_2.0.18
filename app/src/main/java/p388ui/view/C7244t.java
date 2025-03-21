package p388ui.view;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import java.io.File;

/* compiled from: SingleMediaScanner.java */
/* renamed from: ui.view.t */
/* loaded from: classes2.dex */
public class C7244t implements MediaScannerConnection.MediaScannerConnectionClient {

    /* renamed from: a */
    private MediaScannerConnection f25015a;

    /* renamed from: b */
    private File f25016b;

    public C7244t(Context context, File file) {
        this.f25016b = file;
        this.f25015a = new MediaScannerConnection(context, this);
        this.f25015a.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        this.f25015a.scanFile(this.f25016b.getAbsolutePath(), null);
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        this.f25015a.disconnect();
    }
}
