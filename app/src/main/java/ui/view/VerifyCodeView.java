package ui.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class VerifyCodeView extends RelativeLayout {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f14651e = 4;
    private EditText a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView[] f14652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f14653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f14654d;

    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            VerifyCodeView verifyCodeView = VerifyCodeView.this;
            verifyCodeView.f14653c = verifyCodeView.a.getText().toString();
            if (VerifyCodeView.this.f14654d != null) {
                if (VerifyCodeView.this.f14653c.length() >= VerifyCodeView.f14651e) {
                    VerifyCodeView.this.f14654d.a();
                } else {
                    VerifyCodeView.this.f14654d.a(VerifyCodeView.this.f14653c.length());
                }
            }
            for (int i2 = 0; i2 < VerifyCodeView.f14651e; i2++) {
                if (i2 < VerifyCodeView.this.f14653c.length()) {
                    VerifyCodeView.this.f14652b[i2].setText(String.valueOf(VerifyCodeView.this.f14653c.charAt(i2)));
                } else {
                    VerifyCodeView.this.f14652b[i2].setText("");
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

    public interface b {
        void a();

        void a(int i2);
    }

    public VerifyCodeView(Context context) {
        this(context, null);
    }

    public String getEditContent() {
        return this.f14653c;
    }

    public EditText getEditText() {
        return this.a;
    }

    public void setInputCompleteListener(b bVar) {
        this.f14654d = bVar;
    }

    public VerifyCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void b() {
        this.a.addTextChangedListener(new a());
    }

    public VerifyCodeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f14653c = "";
        View.inflate(context, R.layout.view_verify_code, this);
        this.f14652b = new TextView[f14651e];
        this.f14652b[0] = (TextView) findViewById(R.id.tv_0);
        this.f14652b[1] = (TextView) findViewById(R.id.tv_1);
        this.f14652b[2] = (TextView) findViewById(R.id.tv_2);
        this.f14652b[3] = (TextView) findViewById(R.id.tv_3);
        this.a = (EditText) findViewById(R.id.edit_text_view);
        this.a.setCursorVisible(false);
        b();
    }
}
