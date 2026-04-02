package n.b;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import d.b.c.e;
import d.b.c.u;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import zxing.android.CaptureActivity;
import zxing.android.f;

/* JADX INFO: compiled from: DecodeThread.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends Thread {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f12856e = "barcode_bitmap";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f12857f = "barcode_scaled_factor";
    private final CaptureActivity a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Handler f12859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CountDownLatch f12860d = new CountDownLatch(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<e, Object> f12858b = new EnumMap(e.class);

    public c(CaptureActivity captureActivity, Collection<d.b.c.a> collection, Map<e, ?> map, String str, u uVar) {
        this.a = captureActivity;
        if (map != null) {
            this.f12858b.putAll(map);
        }
        if (collection == null || collection.isEmpty()) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(captureActivity);
            collection = EnumSet.noneOf(d.b.c.a.class);
            if (defaultSharedPreferences.getBoolean(f.a, true)) {
                collection.addAll(a.f12845b);
            }
            if (defaultSharedPreferences.getBoolean(f.f15163b, true)) {
                collection.addAll(a.f12846c);
            }
            if (defaultSharedPreferences.getBoolean(f.f15164c, true)) {
                collection.addAll(a.f12848e);
            }
            if (defaultSharedPreferences.getBoolean(f.f15165d, true)) {
                collection.addAll(a.f12849f);
            }
            if (defaultSharedPreferences.getBoolean(f.f15166e, false)) {
                collection.addAll(a.f12850g);
            }
            if (defaultSharedPreferences.getBoolean(f.f15167f, false)) {
                collection.addAll(a.f12851h);
            }
        }
        this.f12858b.put(e.POSSIBLE_FORMATS, collection);
        if (str != null) {
            this.f12858b.put(e.CHARACTER_SET, str);
        }
        this.f12858b.put(e.NEED_RESULT_POINT_CALLBACK, uVar);
        String str2 = "Hints: " + this.f12858b;
    }

    public Handler a() {
        try {
            this.f12860d.await();
        } catch (InterruptedException unused) {
        }
        return this.f12859c;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.f12859c = new b(this.a, this.f12858b);
        this.f12860d.countDown();
        Looper.loop();
    }
}
