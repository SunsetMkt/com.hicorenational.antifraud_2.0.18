package p388ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public final class VictimActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private VictimActivity f23367a;

    /* renamed from: b */
    private View f23368b;

    /* renamed from: c */
    private View f23369c;

    /* renamed from: d */
    private View f23370d;

    /* renamed from: ui.activity.VictimActivity_ViewBinding$a */
    class C6657a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ VictimActivity f23371a;

        C6657a(VictimActivity victimActivity) {
            this.f23371a = victimActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23371a.onClick(view);
        }
    }

    /* renamed from: ui.activity.VictimActivity_ViewBinding$b */
    class C6658b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ VictimActivity f23373a;

        C6658b(VictimActivity victimActivity) {
            this.f23373a = victimActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23373a.onClick(view);
        }
    }

    /* renamed from: ui.activity.VictimActivity_ViewBinding$c */
    class C6659c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ VictimActivity f23375a;

        C6659c(VictimActivity victimActivity) {
            this.f23375a = victimActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23375a.onClick(view);
        }
    }

    @UiThread
    public VictimActivity_ViewBinding(VictimActivity victimActivity) {
        this(victimActivity, victimActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        VictimActivity victimActivity = this.f23367a;
        if (victimActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23367a = null;
        victimActivity.mIvBack = null;
        victimActivity.mTvTitle = null;
        victimActivity.mTvPeopName = null;
        victimActivity.mTvPeopPhone = null;
        victimActivity.mTvPeopCredentType = null;
        victimActivity.mEtPeopCredentNumber = null;
        victimActivity.mBtnCommit = null;
        this.f23368b.setOnClickListener(null);
        this.f23368b = null;
        this.f23369c.setOnClickListener(null);
        this.f23369c = null;
        this.f23370d.setOnClickListener(null);
        this.f23370d = null;
    }

    @UiThread
    public VictimActivity_ViewBinding(VictimActivity victimActivity, View view) {
        this.f23367a = victimActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        victimActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f23368b = findRequiredView;
        findRequiredView.setOnClickListener(new C6657a(victimActivity));
        victimActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        victimActivity.mTvPeopName = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.tv_peop_name, "field 'mTvPeopName'", EditText.class);
        victimActivity.mTvPeopPhone = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.tv_num_phone, "field 'mTvPeopPhone'", EditText.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.tv_peop_credent_type, "field 'mTvPeopCredentType' and method 'onClick'");
        victimActivity.mTvPeopCredentType = (TextView) Utils.castView(findRequiredView2, C2113R.id.tv_peop_credent_type, "field 'mTvPeopCredentType'", TextView.class);
        this.f23369c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6658b(victimActivity));
        victimActivity.mEtPeopCredentNumber = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_peop_credent_number, "field 'mEtPeopCredentNumber'", EditText.class);
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.btn_commit, "field 'mBtnCommit' and method 'onClick'");
        victimActivity.mBtnCommit = (Button) Utils.castView(findRequiredView3, C2113R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f23370d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6659c(victimActivity));
    }
}
