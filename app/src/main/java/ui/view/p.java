package ui.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.hicorenational.antifraud.R;
import ui.Hicore;

/* JADX INFO: compiled from: ConfirmCancelDialog.java */
/* JADX INFO: loaded from: classes2.dex */
public class p extends Dialog implements View.OnClickListener {
    private Activity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f14757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Button f14758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Button f14759d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f14760e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f14761f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private a f14762g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f14763h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f14764i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private CharSequence f14765j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f14766k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f14767l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f14768m;

    /* JADX INFO: compiled from: ConfirmCancelDialog.java */
    public interface a {
        void a();

        void b();
    }

    public p(Activity activity, String str, String str2, String str3, String str4) {
        super(activity, R.style.myStyle);
        this.f14766k = false;
        this.f14767l = -1;
        this.f14768m = -1;
        this.a = activity;
        this.f14760e = str;
        this.f14761f = str2;
        this.f14763h = str3;
        this.f14764i = str4;
    }

    public a a() {
        return this.f14762g;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        dismiss();
        int id = view.getId();
        if (id != R.id.cancel_btn) {
            if (id == R.id.confirm_btn && (aVar = this.f14762g) != null) {
                aVar.b();
                return;
            }
            return;
        }
        a aVar2 = this.f14762g;
        if (aVar2 != null) {
            aVar2.a();
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.custom_dialog);
        setCanceledOnTouchOutside(false);
        ((TextView) findViewById(R.id.customdialog_title)).setText(this.f14760e);
        TextView textView = (TextView) findViewById(R.id.customdialog_subtitle);
        if (this.f14766k) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setText(this.f14765j);
        } else {
            textView.setText(this.f14761f);
        }
        this.f14758c = (Button) findViewById(R.id.confirm_btn);
        this.f14759d = (Button) findViewById(R.id.cancel_btn);
        if (!TextUtils.isEmpty(this.f14763h)) {
            this.f14758c.setText(this.f14763h);
        }
        if (!TextUtils.isEmpty(this.f14764i)) {
            this.f14759d.setText(this.f14764i);
        }
        if (this.f14767l == -1) {
            this.f14758c.setTextColor(-14072090);
        } else {
            this.f14758c.setTextColor(Hicore.getApp().getResources().getColor(this.f14767l));
        }
        if (this.f14768m == -1) {
            this.f14759d.setTextColor(-14072090);
        } else {
            this.f14759d.setTextColor(Hicore.getApp().getResources().getColor(this.f14768m));
        }
        this.f14758c.setOnClickListener(this);
        this.f14759d.setOnClickListener(this);
    }

    public void a(a aVar) {
        this.f14762g = aVar;
    }

    public p(Activity activity, String str, CharSequence charSequence, boolean z, int i2, int i3, String str2, String str3) {
        super(activity, R.style.myStyle);
        this.f14766k = false;
        this.f14767l = -1;
        this.f14768m = -1;
        this.a = activity;
        this.f14760e = str;
        this.f14765j = charSequence;
        this.f14763h = str2;
        this.f14764i = str3;
        this.f14766k = z;
        this.f14767l = i2;
        this.f14768m = i3;
    }

    public p(Context context, String str, String str2, String str3, String str4) {
        super(context, R.style.myStyle);
        this.f14766k = false;
        this.f14767l = -1;
        this.f14768m = -1;
        this.f14757b = context;
        this.f14760e = str;
        this.f14761f = str2;
        this.f14763h = str3;
        this.f14764i = str4;
    }
}
