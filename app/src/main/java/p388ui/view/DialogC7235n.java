package p388ui.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.hicorenational.antifraud.C2113R;
import p388ui.Hicore;

/* compiled from: ConfirmCancelDialog.java */
/* renamed from: ui.view.n */
/* loaded from: classes2.dex */
public class DialogC7235n extends Dialog implements View.OnClickListener {

    /* renamed from: a */
    private Activity f24926a;

    /* renamed from: b */
    private Context f24927b;

    /* renamed from: c */
    private Button f24928c;

    /* renamed from: d */
    private Button f24929d;

    /* renamed from: e */
    private String f24930e;

    /* renamed from: f */
    private String f24931f;

    /* renamed from: g */
    private a f24932g;

    /* renamed from: h */
    private String f24933h;

    /* renamed from: i */
    private String f24934i;

    /* renamed from: j */
    private CharSequence f24935j;

    /* renamed from: k */
    private boolean f24936k;

    /* renamed from: l */
    private int f24937l;

    /* renamed from: m */
    private int f24938m;

    /* compiled from: ConfirmCancelDialog.java */
    /* renamed from: ui.view.n$a */
    public interface a {
        /* renamed from: a */
        void m26004a();

        /* renamed from: b */
        void m26005b();
    }

    public DialogC7235n(Activity activity, String str, String str2, String str3, String str4) {
        super(activity, C2113R.style.myStyle);
        this.f24936k = false;
        this.f24937l = -1;
        this.f24938m = -1;
        this.f24926a = activity;
        this.f24930e = str;
        this.f24931f = str2;
        this.f24933h = str3;
        this.f24934i = str4;
    }

    /* renamed from: a */
    public a m26002a() {
        return this.f24932g;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        dismiss();
        int id = view.getId();
        if (id != C2113R.id.cancel_btn) {
            if (id == C2113R.id.confirm_btn && (aVar = this.f24932g) != null) {
                aVar.m26005b();
                return;
            }
            return;
        }
        a aVar2 = this.f24932g;
        if (aVar2 != null) {
            aVar2.m26004a();
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2113R.layout.custom_dialog);
        setCanceledOnTouchOutside(false);
        ((TextView) findViewById(C2113R.id.customdialog_title)).setText(this.f24930e);
        TextView textView = (TextView) findViewById(C2113R.id.customdialog_subtitle);
        if (this.f24936k) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setText(this.f24935j);
        } else {
            textView.setText(this.f24931f);
        }
        this.f24928c = (Button) findViewById(C2113R.id.confirm_btn);
        this.f24929d = (Button) findViewById(C2113R.id.cancel_btn);
        if (!TextUtils.isEmpty(this.f24933h)) {
            this.f24928c.setText(this.f24933h);
        }
        if (!TextUtils.isEmpty(this.f24934i)) {
            this.f24929d.setText(this.f24934i);
        }
        if (this.f24937l == -1) {
            this.f24928c.setTextColor(-14072090);
        } else {
            this.f24928c.setTextColor(Hicore.getApp().getResources().getColor(this.f24937l));
        }
        if (this.f24938m == -1) {
            this.f24929d.setTextColor(-14072090);
        } else {
            this.f24929d.setTextColor(Hicore.getApp().getResources().getColor(this.f24938m));
        }
        this.f24928c.setOnClickListener(this);
        this.f24929d.setOnClickListener(this);
    }

    /* renamed from: a */
    public void m26003a(a aVar) {
        this.f24932g = aVar;
    }

    public DialogC7235n(Activity activity, String str, CharSequence charSequence, boolean z, int i2, int i3, String str2, String str3) {
        super(activity, C2113R.style.myStyle);
        this.f24936k = false;
        this.f24937l = -1;
        this.f24938m = -1;
        this.f24926a = activity;
        this.f24930e = str;
        this.f24935j = charSequence;
        this.f24933h = str2;
        this.f24934i = str3;
        this.f24936k = z;
        this.f24937l = i2;
        this.f24938m = i3;
    }

    public DialogC7235n(Context context, String str, String str2, String str3, String str4) {
        super(context, C2113R.style.myStyle);
        this.f24936k = false;
        this.f24937l = -1;
        this.f24938m = -1;
        this.f24927b = context;
        this.f24930e = str;
        this.f24931f = str2;
        this.f24933h = str3;
        this.f24934i = str4;
    }
}
