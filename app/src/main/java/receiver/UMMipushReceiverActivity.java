package receiver;

import android.os.Bundle;
import android.widget.TextView;
import com.hicorenational.antifraud.R;
import com.umeng.message.UmengNotifyClickActivity;
import com.umeng.message.entity.UMessage;

/* JADX INFO: loaded from: classes2.dex */
public class UMMipushReceiverActivity extends UmengNotifyClickActivity {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f13022b;

    class a implements Runnable {
        final /* synthetic */ UMessage a;

        a(UMessage uMessage) {
            this.a = uMessage;
        }

        @Override // java.lang.Runnable
        public void run() {
            UMMipushReceiverActivity.this.f13022b.setText(this.a.getRaw().toString());
        }
    }

    @Override // com.umeng.message.UmengNotifyClickActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.umeng_mipush);
        this.f13022b = (TextView) findViewById(R.id.mipushTextView);
    }

    @Override // com.umeng.message.UmengNotifyClickActivity
    protected void onMessage(UMessage uMessage) {
        super.onMessage(uMessage);
        runOnUiThread(new a(uMessage));
    }
}
