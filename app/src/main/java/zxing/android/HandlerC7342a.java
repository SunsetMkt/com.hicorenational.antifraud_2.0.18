package zxing.android;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.hicorenational.antifraud.C2113R;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Collection;
import java.util.Map;
import p031c.p035b.p043c.C1107r;
import p031c.p035b.p043c.EnumC0953a;
import p031c.p035b.p043c.EnumC1044e;
import p381m.p382a.C5929d;
import p381m.p383b.C5934c;
import zxing.view.C7348a;

/* compiled from: CaptureActivityHandler.java */
/* renamed from: zxing.android.a */
/* loaded from: classes2.dex */
public final class HandlerC7342a extends Handler {

    /* renamed from: e */
    private static final String f25806e = HandlerC7342a.class.getSimpleName();

    /* renamed from: a */
    private final CaptureActivity f25807a;

    /* renamed from: b */
    private final C5934c f25808b;

    /* renamed from: c */
    private a f25809c;

    /* renamed from: d */
    private final C5929d f25810d;

    /* compiled from: CaptureActivityHandler.java */
    /* renamed from: zxing.android.a$a */
    private enum a {
        PREVIEW,
        SUCCESS,
        DONE
    }

    public HandlerC7342a(CaptureActivity captureActivity, Collection<EnumC0953a> collection, Map<EnumC1044e, ?> map, String str, C5929d c5929d) {
        this.f25807a = captureActivity;
        this.f25808b = new C5934c(captureActivity, collection, map, str, new C7348a(captureActivity.m26823d()));
        this.f25808b.start();
        this.f25809c = a.SUCCESS;
        this.f25810d = c5929d;
        c5929d.m24907e();
        m26825b();
    }

    /* renamed from: a */
    public void m26824a() {
        this.f25809c = a.DONE;
        this.f25810d.m24908f();
        Message.obtain(this.f25808b.m24917a(), C2113R.id.quit).sendToTarget();
        try {
            this.f25808b.join(500L);
        } catch (InterruptedException unused) {
        }
        removeMessages(C2113R.id.decode_succeeded);
        removeMessages(C2113R.id.decode_failed);
    }

    /* renamed from: b */
    public void m26825b() {
        if (this.f25809c == a.SUCCESS) {
            this.f25809c = a.PREVIEW;
            this.f25810d.m24902a(this.f25808b.m24917a(), C2113R.id.decode);
            this.f25807a.m26819a();
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        ActivityInfo activityInfo;
        String str = null;
        switch (message.what) {
            case C2113R.id.decode_failed /* 2131296498 */:
                this.f25809c = a.PREVIEW;
                this.f25810d.m24902a(this.f25808b.m24917a(), C2113R.id.decode);
                break;
            case C2113R.id.decode_succeeded /* 2131296499 */:
                this.f25809c = a.SUCCESS;
                this.f25807a.m26820a((C1107r) message.obj, null, 0.0f);
                break;
            case C2113R.id.launch_product_query /* 2131296878 */:
                String str2 = (String) message.obj;
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(524288);
                intent.setData(Uri.parse(str2));
                ResolveInfo resolveActivity = this.f25807a.getPackageManager().resolveActivity(intent, 65536);
                if (resolveActivity != null && (activityInfo = resolveActivity.activityInfo) != null) {
                    str = activityInfo.packageName;
                    String str3 = "Using browser in package " + str;
                }
                if ("com.android.browser".equals(str) || "com.android.chrome".equals(str)) {
                    intent.setPackage(str);
                    intent.addFlags(CommonNetImpl.FLAG_AUTH);
                    intent.putExtra("com.android.browser.application_id", str);
                }
                try {
                    this.f25807a.startActivity(intent);
                    break;
                } catch (ActivityNotFoundException unused) {
                    String str4 = "Can't find anything to handle VIEW of URI " + str2;
                    return;
                }
                break;
            case C2113R.id.restart_preview /* 2131297168 */:
                m26825b();
                break;
            case C2113R.id.return_scan_result /* 2131297171 */:
                this.f25807a.setResult(-1, (Intent) message.obj);
                this.f25807a.finish();
                break;
        }
    }
}
