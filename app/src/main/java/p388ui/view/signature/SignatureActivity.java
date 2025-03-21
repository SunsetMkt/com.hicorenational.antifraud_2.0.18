package p388ui.view.signature;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.hicorenational.antifraud.C2113R;
import util.C7292k1;
import util.C7331w1;

/* loaded from: classes2.dex */
public class SignatureActivity extends Activity {

    /* renamed from: e */
    public static final int f24985e = 1;

    /* renamed from: f */
    public static final int f24986f = 2;

    /* renamed from: a */
    private GestureSignatureView f24987a;

    /* renamed from: b */
    private String f24988b;

    /* renamed from: c */
    private TextView f24989c;

    /* renamed from: d */
    private int f24990d;

    /* renamed from: a */
    public /* synthetic */ void m26038a(View view) {
        this.f24987a.m26035a();
    }

    /* renamed from: b */
    public /* synthetic */ void m26039b(View view) {
        try {
            if (!this.f24987a.getTouched()) {
                C7331w1.m26688a("您还未签名");
            } else {
                this.f24987a.m26036a(this.f24988b);
                finish();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTheme(C2113R.style.full_height_dlg);
        setContentView(C2113R.layout.dlg_signature);
        getWindow().setLayout(-1, -1);
        this.f24987a = (GestureSignatureView) findViewById(C2113R.id.gsv_signature);
        this.f24989c = (TextView) findViewById(C2113R.id.tv_sign);
        this.f24988b = getIntent().getStringExtra(C7292k1.f25394d);
        this.f24990d = getIntent().getIntExtra(C7292k1.f25397e, 0);
        if (this.f24990d == 2) {
            this.f24989c.setText("民警签名");
        }
        findViewById(C2113R.id.btn_clear).setOnClickListener(new View.OnClickListener() { // from class: ui.view.signature.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SignatureActivity.this.m26038a(view);
            }
        });
        findViewById(C2113R.id.btn_save).setOnClickListener(new View.OnClickListener() { // from class: ui.view.signature.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SignatureActivity.this.m26039b(view);
            }
        });
    }
}
