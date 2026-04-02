package ui.view.signature;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.hicorenational.antifraud.R;
import util.e2;
import util.p1;

/* JADX INFO: loaded from: classes2.dex */
public class SignatureActivity extends Activity {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f14805e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f14806f = 2;
    private GestureSignatureView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f14807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f14808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f14809d;

    public /* synthetic */ void a(View view) {
        this.a.a();
    }

    public /* synthetic */ void b(View view) {
        try {
            if (!this.a.getTouched()) {
                e2.a("\u60a8\u8fd8\u672a\u7b7e\u540d");
            } else {
                this.a.a(this.f14807b);
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
        setTheme(R.style.full_height_dlg);
        setContentView(R.layout.dlg_signature);
        getWindow().setLayout(-1, -1);
        this.a = (GestureSignatureView) findViewById(R.id.gsv_signature);
        this.f14808c = (TextView) findViewById(R.id.tv_sign);
        this.f14807b = getIntent().getStringExtra(p1.f15012d);
        this.f14809d = getIntent().getIntExtra(p1.f15013e, 0);
        if (this.f14809d == 2) {
            this.f14808c.setText("\u6c11\u8b66\u7b7e\u540d");
        }
        findViewById(R.id.btn_clear).setOnClickListener(new View.OnClickListener() { // from class: ui.view.signature.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.a(view);
            }
        });
        findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() { // from class: ui.view.signature.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.b(view);
            }
        });
    }
}
