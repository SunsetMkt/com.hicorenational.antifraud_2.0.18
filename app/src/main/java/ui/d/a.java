package ui.d;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.hicorenational.antifraud.R;

/* JADX INFO: compiled from: AppIntercepterDialog.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends Dialog implements View.OnClickListener {
    public ImageView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f14080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f14081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f14082d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private InterfaceC0288a f14083e;

    /* JADX INFO: renamed from: ui.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AppIntercepterDialog.java */
    public interface InterfaceC0288a {
        void a();

        void a(TextView textView);
    }

    public a(Context context) {
        super(context, R.style.SmsIntercepteDilog);
        this.f14082d = context;
    }

    private void a() {
        this.a = (ImageView) findViewById(R.id.iv_close);
        this.f14080b = (TextView) findViewById(R.id.tv_content);
        this.f14081c = (TextView) findViewById(R.id.tv_confirm);
        this.a.setOnClickListener(this);
        this.f14081c.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InterfaceC0288a interfaceC0288a;
        int id = view.getId();
        if (id != R.id.iv_close) {
            if (id == R.id.tv_confirm && (interfaceC0288a = this.f14083e) != null) {
                interfaceC0288a.a(this.f14081c);
                return;
            }
            return;
        }
        InterfaceC0288a interfaceC0288a2 = this.f14083e;
        if (interfaceC0288a2 != null) {
            interfaceC0288a2.a();
        }
        dismiss();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_intercepte_app);
        a();
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= 26) {
            window.setType(2038);
        } else {
            window.setType(2003);
        }
        setCanceledOnTouchOutside(false);
    }

    public void setOnBtnClickListener(InterfaceC0288a interfaceC0288a) {
        this.f14083e = interfaceC0288a;
    }

    public void a(String str) {
        this.f14080b.setText(str);
    }
}
