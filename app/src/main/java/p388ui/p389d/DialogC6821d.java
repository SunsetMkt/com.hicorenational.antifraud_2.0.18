package p388ui.p389d;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.hicorenational.antifraud.C2113R;

/* compiled from: SmsIntercepteDialog.java */
/* renamed from: ui.d.d */
/* loaded from: classes2.dex */
public class DialogC6821d extends Dialog implements View.OnClickListener {

    /* renamed from: a */
    public TextView f23680a;

    /* renamed from: b */
    public TextView f23681b;

    /* renamed from: c */
    public TextView f23682c;

    /* renamed from: d */
    public Button f23683d;

    /* renamed from: e */
    public Button f23684e;

    /* renamed from: f */
    private String f23685f;

    /* renamed from: g */
    private String f23686g;

    /* renamed from: h */
    private Context f23687h;

    /* renamed from: i */
    private a f23688i;

    /* compiled from: SmsIntercepteDialog.java */
    /* renamed from: ui.d.d$a */
    public interface a {
        /* renamed from: a */
        void m25491a();

        /* renamed from: b */
        void m25492b();
    }

    public DialogC6821d(Context context, int i2) {
        super(context, C2113R.style.SmsIntercepteDilog);
        this.f23687h = context;
    }

    /* renamed from: a */
    private void m25485a() {
        this.f23680a = (TextView) findViewById(C2113R.id.txt_dialog_sms_address);
        this.f23681b = (TextView) findViewById(C2113R.id.txt_dialog_sms_content);
        this.f23683d = (Button) findViewById(C2113R.id.btn_dialog_sms_close);
        this.f23682c = (TextView) findViewById(C2113R.id.txt_dialog_sms_warn);
        this.f23683d.setOnClickListener(this);
        this.f23684e = (Button) findViewById(C2113R.id.btn_dialog_sms_report);
        this.f23684e.setOnClickListener(this);
    }

    /* renamed from: b */
    public void m25488b(String str) {
        this.f23680a.setText(str);
    }

    /* renamed from: c */
    public void m25489c(String str) {
        this.f23684e.setText(str);
    }

    /* renamed from: d */
    public void m25490d(String str) {
        this.f23682c.setText(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2113R.id.btn_dialog_sms_close /* 2131296397 */:
                a aVar = this.f23688i;
                if (aVar != null) {
                    aVar.m25491a();
                }
                dismiss();
                break;
            case C2113R.id.btn_dialog_sms_report /* 2131296398 */:
                a aVar2 = this.f23688i;
                if (aVar2 != null) {
                    aVar2.m25492b();
                }
                dismiss();
                break;
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2113R.layout.dialog_intercepte);
        m25485a();
    }

    public void setOnBtnClickListener(a aVar) {
        this.f23688i = aVar;
    }

    /* renamed from: a */
    public void m25486a(String str) {
        this.f23681b.setText(str);
    }

    /* renamed from: a */
    public void m25487a(String str, String str2) {
        this.f23683d.setText(str);
        this.f23684e.setText(str2);
    }
}
