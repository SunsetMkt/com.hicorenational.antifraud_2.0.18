package p388ui.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class VerifyCodeView extends RelativeLayout {

    /* renamed from: e */
    private static int f24740e = 4;

    /* renamed from: a */
    private EditText f24741a;

    /* renamed from: b */
    private TextView[] f24742b;

    /* renamed from: c */
    private String f24743c;

    /* renamed from: d */
    private InterfaceC7201b f24744d;

    /* renamed from: ui.view.VerifyCodeView$a */
    class C7200a implements TextWatcher {
        C7200a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            VerifyCodeView verifyCodeView = VerifyCodeView.this;
            verifyCodeView.f24743c = verifyCodeView.f24741a.getText().toString();
            if (VerifyCodeView.this.f24744d != null) {
                if (VerifyCodeView.this.f24743c.length() >= VerifyCodeView.f24740e) {
                    VerifyCodeView.this.f24744d.mo25390a();
                } else {
                    VerifyCodeView.this.f24744d.mo25391a(VerifyCodeView.this.f24743c.length());
                }
            }
            for (int i2 = 0; i2 < VerifyCodeView.f24740e; i2++) {
                if (i2 < VerifyCodeView.this.f24743c.length()) {
                    VerifyCodeView.this.f24742b[i2].setText(String.valueOf(VerifyCodeView.this.f24743c.charAt(i2)));
                } else {
                    VerifyCodeView.this.f24742b[i2].setText("");
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* renamed from: ui.view.VerifyCodeView$b */
    public interface InterfaceC7201b {
        /* renamed from: a */
        void mo25390a();

        /* renamed from: a */
        void mo25391a(int i2);
    }

    public VerifyCodeView(Context context) {
        this(context, null);
    }

    public String getEditContent() {
        return this.f24743c;
    }

    public EditText getEditText() {
        return this.f24741a;
    }

    public void setInputCompleteListener(InterfaceC7201b interfaceC7201b) {
        this.f24744d = interfaceC7201b;
    }

    public VerifyCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: b */
    private void m25866b() {
        this.f24741a.addTextChangedListener(new C7200a());
    }

    public VerifyCodeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f24743c = "";
        View.inflate(context, C2113R.layout.view_verify_code, this);
        this.f24742b = new TextView[f24740e];
        this.f24742b[0] = (TextView) findViewById(C2113R.id.tv_0);
        this.f24742b[1] = (TextView) findViewById(C2113R.id.tv_1);
        this.f24742b[2] = (TextView) findViewById(C2113R.id.tv_2);
        this.f24742b[3] = (TextView) findViewById(C2113R.id.tv_3);
        this.f24741a = (EditText) findViewById(C2113R.id.edit_text_view);
        this.f24741a.setCursorVisible(false);
        m25866b();
    }
}
