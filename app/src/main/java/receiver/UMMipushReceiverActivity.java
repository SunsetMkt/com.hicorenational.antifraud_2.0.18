package receiver;

import android.os.Bundle;
import android.widget.TextView;
import com.hicorenational.antifraud.C2113R;
import com.umeng.message.UmengNotifyClickActivity;
import com.umeng.message.entity.UMessage;

/* loaded from: classes2.dex */
public class UMMipushReceiverActivity extends UmengNotifyClickActivity {

    /* renamed from: b */
    private TextView f21706b;

    /* renamed from: receiver.UMMipushReceiverActivity$a */
    class RunnableC6083a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ UMessage f21707a;

        RunnableC6083a(UMessage uMessage) {
            this.f21707a = uMessage;
        }

        @Override // java.lang.Runnable
        public void run() {
            UMMipushReceiverActivity.this.f21706b.setText(this.f21707a.getRaw().toString());
        }
    }

    @Override // com.umeng.message.UmengNotifyClickActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2113R.layout.umeng_mipush);
        this.f21706b = (TextView) findViewById(C2113R.id.mipushTextView);
    }

    @Override // com.umeng.message.UmengNotifyClickActivity
    protected void onMessage(UMessage uMessage) {
        super.onMessage(uMessage);
        runOnUiThread(new RunnableC6083a(uMessage));
    }
}
