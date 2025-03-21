package p388ui.p389d;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.hicorenational.antifraud.C2113R;
import p000a.p001a.p014u.C0052a;
import util.C7301n1;

/* compiled from: CallIntercepterDialog.java */
/* renamed from: ui.d.b */
/* loaded from: classes2.dex */
public class DialogC6819b extends DialogC6821d {

    /* renamed from: n */
    private static final int f23672n = 1;

    /* renamed from: o */
    private static final int f23673o = 2;

    /* renamed from: j */
    private int f23674j;

    /* renamed from: k */
    private int f23675k;

    /* renamed from: l */
    public c f23676l;

    /* renamed from: m */
    public d f23677m;

    /* compiled from: CallIntercepterDialog.java */
    /* renamed from: ui.d.b$a */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DialogC6819b dialogC6819b = DialogC6819b.this;
            if (dialogC6819b.f23676l != null) {
                if (dialogC6819b.f23675k != 1) {
                    DialogC6819b.this.f23676l.m25482a();
                    return;
                }
                DialogC6819b.this.f23676l.m25483b();
                DialogC6819b.this.f23675k = 2;
                DialogC6819b.this.f23684e.setText("停止录音");
            }
        }
    }

    /* compiled from: CallIntercepterDialog.java */
    /* renamed from: ui.d.b$b */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar = DialogC6819b.this.f23677m;
            if (dVar != null) {
                dVar.m25484a();
            }
        }
    }

    /* compiled from: CallIntercepterDialog.java */
    /* renamed from: ui.d.b$c */
    public interface c {
        /* renamed from: a */
        void m25482a();

        /* renamed from: b */
        void m25483b();
    }

    /* compiled from: CallIntercepterDialog.java */
    /* renamed from: ui.d.b$d */
    public interface d {
        /* renamed from: a */
        void m25484a();
    }

    public DialogC6819b(Context context) {
        super(context, C2113R.style.SmsIntercepteDilog);
        this.f23674j = 1;
        this.f23675k = 1;
    }

    /* renamed from: b */
    public void m25481b() {
        this.f23683d.setVisibility(0);
        this.f23684e.setVisibility(0);
        this.f23682c.setVisibility(8);
        this.f23683d.setText("举报电话");
        this.f23684e.setText("开始录音");
        this.f23684e.setOnClickListener(new a());
        this.f23683d.setOnClickListener(new b());
    }

    @Override // p388ui.p389d.DialogC6821d, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C7301n1.m26459c(C0052a.f162n, "onCreate               mDialogType  " + this.f23674j);
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= 26) {
            window.setType(2038);
        } else {
            window.setType(2003);
        }
        int i2 = this.f23674j;
        if (i2 == 1) {
            window.setFlags(40, 1024);
            m25479a();
        } else {
            if (i2 != 2) {
                return;
            }
            m25481b();
            setCanceledOnTouchOutside(false);
        }
    }

    public void setOnRecordClickListener(c cVar) {
        this.f23676l = cVar;
    }

    public void setOnReportPhoneListener(d dVar) {
        this.f23677m = dVar;
    }

    /* renamed from: a */
    public void m25480a(int i2) {
        this.f23674j = i2;
    }

    /* renamed from: a */
    public void m25479a() {
        this.f23684e.setVisibility(8);
        this.f23683d.setVisibility(8);
        this.f23682c.setVisibility(8);
    }
}
