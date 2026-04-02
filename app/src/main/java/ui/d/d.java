package ui.d;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.hicorenational.antifraud.R;

/* JADX INFO: compiled from: SmsIntercepteDialog.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends Dialog implements View.OnClickListener {
    public TextView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f14089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f14090c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Button f14091d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Button f14092e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f14093f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f14094g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Context f14095h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private a f14096i;

    /* JADX INFO: compiled from: SmsIntercepteDialog.java */
    public interface a {
        void a();

        void b();
    }

    public d(Context context, int i2) {
        super(context, R.style.SmsIntercepteDilog);
        this.f14095h = context;
    }

    private void a() {
        this.a = (TextView) findViewById(R.id.txt_dialog_sms_address);
        this.f14089b = (TextView) findViewById(R.id.txt_dialog_sms_content);
        this.f14091d = (Button) findViewById(R.id.btn_dialog_sms_close);
        this.f14090c = (TextView) findViewById(R.id.txt_dialog_sms_warn);
        this.f14091d.setOnClickListener(this);
        this.f14092e = (Button) findViewById(R.id.btn_dialog_sms_report);
        this.f14092e.setOnClickListener(this);
    }

    public void b(String str) {
        this.a.setText(str);
    }

    public void c(String str) {
        this.f14092e.setText(str);
    }

    public void d(String str) {
        this.f14090c.setText(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_dialog_sms_close /* 2131296409 */:
                a aVar = this.f14096i;
                if (aVar != null) {
                    aVar.a();
                }
                dismiss();
                break;
            case R.id.btn_dialog_sms_report /* 2131296410 */:
                a aVar2 = this.f14096i;
                if (aVar2 != null) {
                    aVar2.b();
                }
                dismiss();
                break;
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_intercepte);
        a();
    }

    public void setOnBtnClickListener(a aVar) {
        this.f14096i = aVar;
    }

    public void a(String str) {
        this.f14089b.setText(str);
    }

    public void a(String str, String str2) {
        this.f14091d.setText(str);
        this.f14092e.setText(str2);
    }
}
