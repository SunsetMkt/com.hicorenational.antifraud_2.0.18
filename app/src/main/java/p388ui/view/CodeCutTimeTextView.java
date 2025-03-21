package p388ui.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class CodeCutTimeTextView extends FrameLayout {

    /* renamed from: d */
    public static final int f24496d = 60;

    /* renamed from: e */
    public static final int f24497e = 180;

    /* renamed from: f */
    public static int f24498f = 60;

    /* renamed from: a */
    private TextView f24499a;

    /* renamed from: b */
    private boolean f24500b;

    /* renamed from: c */
    private AbstractC7237p f24501c;

    /* renamed from: ui.view.CodeCutTimeTextView$a */
    class C7168a extends AbstractC7237p {

        /* renamed from: g */
        final /* synthetic */ Activity f24502g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C7168a(long j2, long j3, Activity activity) {
            super(j2, j3);
            this.f24502g = activity;
        }

        @Override // p388ui.view.AbstractC7237p
        /* renamed from: a */
        public void mo25433a(long j2) {
            if (this.f24502g.isFinishing() || CodeCutTimeTextView.this.f24499a == null) {
                return;
            }
            int i2 = (int) (j2 / 1000);
            CodeCutTimeTextView.this.f24499a.setText("重新获取(" + i2 + ")");
            CodeCutTimeTextView.this.f24499a.setTextColor(Color.parseColor("#666666"));
        }

        @Override // p388ui.view.AbstractC7237p
        /* renamed from: d */
        public void mo25434d() {
            if (this.f24502g.isFinishing() || CodeCutTimeTextView.this.f24499a == null) {
                return;
            }
            CodeCutTimeTextView.this.f24499a.setText("重新获取");
            CodeCutTimeTextView.this.f24499a.setTextColor(Color.parseColor("#2B4CFF"));
            CodeCutTimeTextView.this.f24500b = false;
            CodeCutTimeTextView.this.setEnabled(true);
        }
    }

    public CodeCutTimeTextView(Context context) {
        this(context, null);
    }

    /* renamed from: b */
    public void m25759b() {
        AbstractC7237p abstractC7237p = this.f24501c;
        if (abstractC7237p != null) {
            abstractC7237p.m26011a();
            m25757a(false);
        }
    }

    /* renamed from: c */
    public void m25760c() {
        AbstractC7237p abstractC7237p = this.f24501c;
        if (abstractC7237p != null) {
            abstractC7237p.m26011a();
            m25757a(true);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
    }

    public CodeCutTimeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CodeCutTimeTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f24499a = (TextView) LayoutInflater.from(context).inflate(C2113R.layout.code_cut_time, (ViewGroup) this, true).findViewById(C2113R.id.tv_versf);
        m25757a(false);
    }

    /* renamed from: a */
    public void m25757a(boolean z) {
        this.f24499a.setText("获取验证码");
        this.f24500b = false;
        if (z) {
            this.f24499a.setTextColor(Color.parseColor("#2B4CFF"));
            setEnabled(true);
        } else {
            this.f24499a.setTextColor(Color.parseColor("#666666"));
            setEnabled(false);
        }
    }

    /* renamed from: a */
    public boolean m25758a() {
        return this.f24500b;
    }

    /* renamed from: a */
    public void m25756a(Activity activity, int i2) {
        if (i2 <= 0) {
            f24498f = 180;
        } else {
            f24498f = i2;
        }
        m25754a(activity);
    }

    /* renamed from: a */
    private void m25754a(Activity activity) {
        this.f24500b = true;
        setEnabled(false);
        AbstractC7237p abstractC7237p = this.f24501c;
        if (abstractC7237p == null) {
            this.f24501c = new C7168a(f24498f * 1000, 1000L, activity);
        } else {
            abstractC7237p.m26012a(f24498f * 1000, 1000L);
        }
    }
}
