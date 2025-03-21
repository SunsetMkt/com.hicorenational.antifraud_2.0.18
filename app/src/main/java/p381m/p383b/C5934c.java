package p381m.p383b;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import p031c.p035b.p043c.EnumC0953a;
import p031c.p035b.p043c.EnumC1044e;
import p031c.p035b.p043c.InterfaceC1110u;
import zxing.android.C7347f;
import zxing.android.CaptureActivity;

/* compiled from: DecodeThread.java */
/* renamed from: m.b.c */
/* loaded from: classes2.dex */
public final class C5934c extends Thread {

    /* renamed from: e */
    public static final String f21422e = "barcode_bitmap";

    /* renamed from: f */
    public static final String f21423f = "barcode_scaled_factor";

    /* renamed from: a */
    private final CaptureActivity f21424a;

    /* renamed from: c */
    private Handler f21426c;

    /* renamed from: d */
    private final CountDownLatch f21427d = new CountDownLatch(1);

    /* renamed from: b */
    private final Map<EnumC1044e, Object> f21425b = new EnumMap(EnumC1044e.class);

    public C5934c(CaptureActivity captureActivity, Collection<EnumC0953a> collection, Map<EnumC1044e, ?> map, String str, InterfaceC1110u interfaceC1110u) {
        this.f21424a = captureActivity;
        if (map != null) {
            this.f21425b.putAll(map);
        }
        if (collection == null || collection.isEmpty()) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(captureActivity);
            collection = EnumSet.noneOf(EnumC0953a.class);
            if (defaultSharedPreferences.getBoolean(C7347f.f25859a, true)) {
                collection.addAll(C5932a.f21410b);
            }
            if (defaultSharedPreferences.getBoolean(C7347f.f25860b, true)) {
                collection.addAll(C5932a.f21411c);
            }
            if (defaultSharedPreferences.getBoolean(C7347f.f25861c, true)) {
                collection.addAll(C5932a.f21413e);
            }
            if (defaultSharedPreferences.getBoolean(C7347f.f25862d, true)) {
                collection.addAll(C5932a.f21414f);
            }
            if (defaultSharedPreferences.getBoolean(C7347f.f25863e, false)) {
                collection.addAll(C5932a.f21415g);
            }
            if (defaultSharedPreferences.getBoolean(C7347f.f25864f, false)) {
                collection.addAll(C5932a.f21416h);
            }
        }
        this.f21425b.put(EnumC1044e.POSSIBLE_FORMATS, collection);
        if (str != null) {
            this.f21425b.put(EnumC1044e.CHARACTER_SET, str);
        }
        this.f21425b.put(EnumC1044e.NEED_RESULT_POINT_CALLBACK, interfaceC1110u);
        String str2 = "Hints: " + this.f21425b;
    }

    /* renamed from: a */
    public Handler m24917a() {
        try {
            this.f21427d.await();
        } catch (InterruptedException unused) {
        }
        return this.f21426c;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.f21426c = new HandlerC5933b(this.f21424a, this.f21425b);
        this.f21427d.countDown();
        Looper.loop();
    }
}
