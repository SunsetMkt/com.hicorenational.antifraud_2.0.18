package util;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.just.agentweb.DefaultWebClient;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: VideoFrameExtractor.java */
/* JADX INFO: loaded from: classes2.dex */
public class i2 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile i2 f14928d;
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ExecutorService f14929b = Executors.newFixedThreadPool(2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f14930c = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: VideoFrameExtractor.java */
    public interface a {
        void a(Bitmap bitmap);

        void onError(String str);
    }

    private i2(Context context) {
        this.a = context.getApplicationContext();
    }

    public static i2 a(Context context) {
        if (f14928d == null) {
            synchronized (i2.class) {
                if (f14928d == null) {
                    f14928d = new i2(context);
                }
            }
        }
        return f14928d;
    }

    public /* synthetic */ void b(String str, final a aVar) {
        try {
            final Bitmap bitmapA = a(str);
            this.f14930c.post(new Runnable() { // from class: util.u0
                @Override // java.lang.Runnable
                public final void run() {
                    aVar.a(bitmapA);
                }
            });
        } catch (Exception e2) {
            this.f14930c.post(new Runnable() { // from class: util.v0
                @Override // java.lang.Runnable
                public final void run() {
                    aVar.onError(e2.getMessage());
                }
            });
        }
    }

    private boolean b(String str) {
        return str.startsWith(DefaultWebClient.HTTP_SCHEME) || str.startsWith(DefaultWebClient.HTTPS_SCHEME) || str.startsWith("ftp://") || str.startsWith("rtsp://");
    }

    public void a(final String str, final a aVar) {
        this.f14929b.execute(new Runnable() { // from class: util.w0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.b(str, aVar);
            }
        });
    }

    private Bitmap a(String str) throws Exception {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            if (b(str)) {
                mediaMetadataRetriever.setDataSource(str, new HashMap());
            } else if (str.startsWith("content://")) {
                mediaMetadataRetriever.setDataSource(this.a, Uri.parse(str));
            } else if (str.startsWith("file://") || new File(str).exists()) {
                mediaMetadataRetriever.setDataSource(str);
            } else {
                throw new Exception("\u6587\u4ef6\u4e0d\u5b58\u5728: " + str);
            }
            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L, 2);
            if (frameAtTime != null) {
                return frameAtTime;
            }
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u89c6\u9891\u5e27");
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    public void a() {
        this.f14929b.shutdown();
        f14928d = null;
    }
}
