package ui.d;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.hicorenational.antifraud.R;
import util.s1;

/* JADX INFO: compiled from: CallIntercepterDialog.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends ui.d.d {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f14084n = 1;
    private static final int o = 2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f14085j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f14086k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public c f14087l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public d f14088m;

    /* JADX INFO: compiled from: CallIntercepterDialog.java */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = b.this;
            if (bVar.f14087l != null) {
                if (bVar.f14086k != 1) {
                    b.this.f14087l.a();
                    return;
                }
                b.this.f14087l.b();
                b.this.f14086k = 2;
                b.this.f14092e.setText("\u505c\u6b62\u5f55\u97f3");
            }
        }
    }

    /* JADX INFO: renamed from: ui.d.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CallIntercepterDialog.java */
    class ViewOnClickListenerC0289b implements View.OnClickListener {
        ViewOnClickListenerC0289b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar = b.this.f14088m;
            if (dVar != null) {
                dVar.a();
            }
        }
    }

    /* JADX INFO: compiled from: CallIntercepterDialog.java */
    public interface c {
        void a();

        void b();
    }

    /* JADX INFO: compiled from: CallIntercepterDialog.java */
    public interface d {
        void a();
    }

    public b(Context context) {
        super(context, R.style.SmsIntercepteDilog);
        this.f14085j = 1;
        this.f14086k = 1;
    }

    public void b() {
        this.f14091d.setVisibility(0);
        this.f14092e.setVisibility(0);
        this.f14090c.setVisibility(8);
        this.f14091d.setText("\u4e3e\u62a5\u7535\u8bdd");
        this.f14092e.setText("\u5f00\u59cb\u5f55\u97f3");
        this.f14092e.setOnClickListener(new a());
        this.f14091d.setOnClickListener(new ViewOnClickListenerC0289b());
    }

    @Override // ui.d.d, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        s1.c(b.a.u.a.f1912n, "onCreate               mDialogType  " + this.f14085j);
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= 26) {
            window.setType(2038);
        } else {
            window.setType(2003);
        }
        int i2 = this.f14085j;
        if (i2 == 1) {
            window.setFlags(40, 1024);
            a();
        } else {
            if (i2 != 2) {
                return;
            }
            b();
            setCanceledOnTouchOutside(false);
        }
    }

    public void setOnRecordClickListener(c cVar) {
        this.f14087l = cVar;
    }

    public void setOnReportPhoneListener(d dVar) {
        this.f14088m = dVar;
    }

    public void a(int i2) {
        this.f14085j = i2;
    }

    public void a() {
        this.f14092e.setVisibility(8);
        this.f14091d.setVisibility(8);
        this.f14090c.setVisibility(8);
    }
}
