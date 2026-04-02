package ui.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class CodeCutTimeTextView extends FrameLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f14518d = 60;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f14519e = 180;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f14520f = 60;
    private TextView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f14521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private r f14522c;

    class a extends r {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Activity f14523g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j2, long j3, Activity activity) {
            super(j2, j3);
            this.f14523g = activity;
        }

        @Override // ui.view.r
        public void a(long j2) {
            if (this.f14523g.isFinishing() || CodeCutTimeTextView.this.a == null) {
                return;
            }
            int i2 = (int) (j2 / 1000);
            CodeCutTimeTextView.this.a.setText("\u91cd\u65b0\u83b7\u53d6(" + i2 + ")");
            CodeCutTimeTextView.this.a.setTextColor(Color.parseColor("#666666"));
        }

        @Override // ui.view.r
        public void d() {
            if (this.f14523g.isFinishing() || CodeCutTimeTextView.this.a == null) {
                return;
            }
            CodeCutTimeTextView.this.a.setText("\u91cd\u65b0\u83b7\u53d6");
            CodeCutTimeTextView.this.a.setTextColor(Color.parseColor("#2B4CFF"));
            CodeCutTimeTextView.this.f14521b = false;
            CodeCutTimeTextView.this.setEnabled(true);
        }
    }

    public CodeCutTimeTextView(Context context) {
        this(context, null);
    }

    public void b() {
        r rVar = this.f14522c;
        if (rVar != null) {
            rVar.a();
            a(false);
        }
    }

    public void c() {
        r rVar = this.f14522c;
        if (rVar != null) {
            rVar.a();
            a(true);
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
        this.a = (TextView) LayoutInflater.from(context).inflate(R.layout.code_cut_time, (ViewGroup) this, true).findViewById(R.id.tv_versf);
        a(false);
    }

    public void a(boolean z) {
        this.a.setText("\u83b7\u53d6\u9a8c\u8bc1\u7801");
        this.f14521b = false;
        if (z) {
            this.a.setTextColor(Color.parseColor("#2B4CFF"));
            setEnabled(true);
        } else {
            this.a.setTextColor(Color.parseColor("#666666"));
            setEnabled(false);
        }
    }

    public boolean a() {
        return this.f14521b;
    }

    public void a(Activity activity, int i2) {
        if (i2 <= 0) {
            f14520f = 180;
        } else {
            f14520f = i2;
        }
        a(activity);
    }

    private void a(Activity activity) {
        this.f14521b = true;
        setEnabled(false);
        r rVar = this.f14522c;
        if (rVar == null) {
            this.f14522c = new a(f14520f * 1000, 1000L, activity);
        } else {
            rVar.a(f14520f * 1000, 1000L);
        }
    }
}
