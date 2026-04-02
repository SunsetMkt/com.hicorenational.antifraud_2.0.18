package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public final class VictimActivity_ViewBinding implements Unbinder {
    private VictimActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13963d;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ VictimActivity a;

        a(VictimActivity victimActivity) {
            this.a = victimActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ VictimActivity a;

        b(VictimActivity victimActivity) {
            this.a = victimActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ VictimActivity a;

        c(VictimActivity victimActivity) {
            this.a = victimActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public VictimActivity_ViewBinding(VictimActivity victimActivity) {
        this(victimActivity, victimActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        VictimActivity victimActivity = this.a;
        if (victimActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        victimActivity.mIvBack = null;
        victimActivity.mTvTitle = null;
        victimActivity.mTvPeopName = null;
        victimActivity.mTvPeopPhone = null;
        victimActivity.mTvPeopCredentType = null;
        victimActivity.mEtPeopCredentNumber = null;
        victimActivity.mBtnCommit = null;
        this.f13961b.setOnClickListener(null);
        this.f13961b = null;
        this.f13962c.setOnClickListener(null);
        this.f13962c = null;
        this.f13963d.setOnClickListener(null);
        this.f13963d = null;
    }

    @UiThread
    public VictimActivity_ViewBinding(VictimActivity victimActivity, View view) {
        this.a = victimActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        victimActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13961b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(victimActivity));
        victimActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        victimActivity.mTvPeopName = (EditText) Utils.findRequiredViewAsType(view, R.id.tv_peop_name, "field 'mTvPeopName'", EditText.class);
        victimActivity.mTvPeopPhone = (EditText) Utils.findRequiredViewAsType(view, R.id.tv_num_phone, "field 'mTvPeopPhone'", EditText.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_peop_credent_type, "field 'mTvPeopCredentType' and method 'onClick'");
        victimActivity.mTvPeopCredentType = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_peop_credent_type, "field 'mTvPeopCredentType'", TextView.class);
        this.f13962c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(victimActivity));
        victimActivity.mEtPeopCredentNumber = (EditText) Utils.findRequiredViewAsType(view, R.id.et_peop_credent_number, "field 'mEtPeopCredentNumber'", EditText.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btn_commit, "field 'mBtnCommit' and method 'onClick'");
        victimActivity.mBtnCommit = (Button) Utils.castView(viewFindRequiredView3, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f13963d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(victimActivity));
    }
}
