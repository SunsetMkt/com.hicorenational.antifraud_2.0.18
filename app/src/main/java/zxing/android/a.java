package zxing.android;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.hicorenational.antifraud.R;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import d.b.c.r;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: CaptureActivityHandler.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends Handler {

    /* JADX INFO: renamed from: e */
    private static final String f15132e = a.class.getSimpleName();
    private final CaptureActivity a;

    /* JADX INFO: renamed from: b */
    private final n.b.c f15133b;

    /* JADX INFO: renamed from: c */
    private EnumC0328a f15134c;

    /* JADX INFO: renamed from: d */
    private final n.a.d f15135d;

    /* JADX INFO: renamed from: zxing.android.a$a */
    /* JADX INFO: compiled from: CaptureActivityHandler.java */
    private enum EnumC0328a {
        PREVIEW,
        SUCCESS,
        DONE
    }

    public a(CaptureActivity captureActivity, Collection<d.b.c.a> collection, Map<d.b.c.e, ?> map, String str, n.a.d dVar) {
        this.a = captureActivity;
        this.f15133b = new n.b.c(captureActivity, collection, map, str, new zxing.view.a(captureActivity.d()));
        this.f15133b.start();
        this.f15134c = EnumC0328a.SUCCESS;
        this.f15135d = dVar;
        dVar.e();
        b();
    }

    public void a() {
        this.f15134c = EnumC0328a.DONE;
        this.f15135d.f();
        Message.obtain(this.f15133b.a(), R.id.quit).sendToTarget();
        try {
            this.f15133b.join(500L);
        } catch (InterruptedException unused) {
        }
        removeMessages(R.id.decode_succeeded);
        removeMessages(R.id.decode_failed);
    }

    public void b() {
        if (this.f15134c == EnumC0328a.SUCCESS) {
            this.f15134c = EnumC0328a.PREVIEW;
            this.f15135d.a(this.f15133b.a(), R.id.decode);
            this.a.a();
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        ActivityInfo activityInfo;
        String str = null;
        switch (message.what) {
            case R.id.decode_failed /* 2131296528 */:
                this.f15134c = EnumC0328a.PREVIEW;
                this.f15135d.a(this.f15133b.a(), R.id.decode);
                break;
            case R.id.decode_succeeded /* 2131296529 */:
                this.f15134c = EnumC0328a.SUCCESS;
                this.a.a((r) message.obj, null, 0.0f);
                break;
            case R.id.launch_product_query /* 2131296927 */:
                String str2 = (String) message.obj;
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(524288);
                intent.setData(Uri.parse(str2));
                ResolveInfo resolveInfoResolveActivity = this.a.getPackageManager().resolveActivity(intent, 65536);
                if (resolveInfoResolveActivity != null && (activityInfo = resolveInfoResolveActivity.activityInfo) != null) {
                    str = activityInfo.packageName;
                    String str3 = "Using browser in package " + str;
                }
                if ("com.android.browser".equals(str) || "com.android.chrome".equals(str)) {
                    intent.setPackage(str);
                    intent.addFlags(CommonNetImpl.FLAG_AUTH);
                    intent.putExtra("com.android.browser.application_id", str);
                }
                try {
                    this.a.startActivity(intent);
                } catch (ActivityNotFoundException unused) {
                    String str4 = "Can't find anything to handle VIEW of URI " + str2;
                    return;
                }
                break;
            case R.id.restart_preview /* 2131297308 */:
                b();
                break;
            case R.id.return_scan_result /* 2131297311 */:
                this.a.setResult(-1, (Intent) message.obj);
                this.a.finish();
                break;
        }
    }
}
