package p388ui.p389d;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.hicorenational.antifraud.C2113R;

/* compiled from: AppIntercepterDialog.java */
/* renamed from: ui.d.a */
/* loaded from: classes2.dex */
public class DialogC6818a extends Dialog implements View.OnClickListener {

    /* renamed from: a */
    public ImageView f23667a;

    /* renamed from: b */
    public TextView f23668b;

    /* renamed from: c */
    public TextView f23669c;

    /* renamed from: d */
    private Context f23670d;

    /* renamed from: e */
    private a f23671e;

    /* compiled from: AppIntercepterDialog.java */
    /* renamed from: ui.d.a$a */
    public interface a {
        /* renamed from: a */
        void mo25171a();

        /* renamed from: a */
        void mo25172a(TextView textView);
    }

    public DialogC6818a(Context context) {
        super(context, C2113R.style.SmsIntercepteDilog);
        this.f23670d = context;
    }

    /* renamed from: a */
    private void m25475a() {
        this.f23667a = (ImageView) findViewById(C2113R.id.iv_close);
        this.f23668b = (TextView) findViewById(C2113R.id.tv_content);
        this.f23669c = (TextView) findViewById(C2113R.id.tv_confirm);
        this.f23667a.setOnClickListener(this);
        this.f23669c.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        int id = view.getId();
        if (id != C2113R.id.iv_close) {
            if (id == C2113R.id.tv_confirm && (aVar = this.f23671e) != null) {
                aVar.mo25172a(this.f23669c);
                return;
            }
            return;
        }
        a aVar2 = this.f23671e;
        if (aVar2 != null) {
            aVar2.mo25171a();
        }
        dismiss();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2113R.layout.dialog_intercepte_app);
        m25475a();
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= 26) {
            window.setType(2038);
        } else {
            window.setType(2003);
        }
        setCanceledOnTouchOutside(false);
    }

    public void setOnBtnClickListener(a aVar) {
        this.f23671e = aVar;
    }

    /* renamed from: a */
    public void m25476a(String str) {
        this.f23668b.setText(str);
    }
}
