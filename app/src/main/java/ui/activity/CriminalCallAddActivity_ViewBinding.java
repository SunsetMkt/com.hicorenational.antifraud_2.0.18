package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public final class CriminalCallAddActivity_ViewBinding implements Unbinder {
    private CriminalCallAddActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13285d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f13286e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f13287f;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ CriminalCallAddActivity a;

        a(CriminalCallAddActivity criminalCallAddActivity) {
            this.a = criminalCallAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ CriminalCallAddActivity a;

        b(CriminalCallAddActivity criminalCallAddActivity) {
            this.a = criminalCallAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ CriminalCallAddActivity a;

        c(CriminalCallAddActivity criminalCallAddActivity) {
            this.a = criminalCallAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {
        final /* synthetic */ CriminalCallAddActivity a;

        d(CriminalCallAddActivity criminalCallAddActivity) {
            this.a = criminalCallAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class e extends DebouncingOnClickListener {
        final /* synthetic */ CriminalCallAddActivity a;

        e(CriminalCallAddActivity criminalCallAddActivity) {
            this.a = criminalCallAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public CriminalCallAddActivity_ViewBinding(CriminalCallAddActivity criminalCallAddActivity) {
        this(criminalCallAddActivity, criminalCallAddActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        CriminalCallAddActivity criminalCallAddActivity = this.a;
        if (criminalCallAddActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        criminalCallAddActivity.mTvTitle = null;
        criminalCallAddActivity.mBtnConfirm = null;
        criminalCallAddActivity.mEtVictimPhone = null;
        criminalCallAddActivity.mEtPhone = null;
        criminalCallAddActivity.mTvOccurTime = null;
        criminalCallAddActivity.mTvDuration = null;
        criminalCallAddActivity.mLlClause = null;
        criminalCallAddActivity.mTCbSelect = null;
        criminalCallAddActivity.mAudioNum = null;
        this.f13283b.setOnClickListener(null);
        this.f13283b = null;
        this.f13284c.setOnClickListener(null);
        this.f13284c = null;
        this.f13285d.setOnClickListener(null);
        this.f13285d = null;
        this.f13286e.setOnClickListener(null);
        this.f13286e = null;
        this.f13287f.setOnClickListener(null);
        this.f13287f = null;
    }

    @UiThread
    public CriminalCallAddActivity_ViewBinding(CriminalCallAddActivity criminalCallAddActivity, View view) {
        this.a = criminalCallAddActivity;
        criminalCallAddActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_confirm, "field 'mBtnConfirm' and method 'onViewClicked'");
        criminalCallAddActivity.mBtnConfirm = (Button) Utils.castView(viewFindRequiredView, R.id.btn_confirm, "field 'mBtnConfirm'", Button.class);
        this.f13283b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(criminalCallAddActivity));
        criminalCallAddActivity.mEtVictimPhone = (EditText) Utils.findRequiredViewAsType(view, R.id.et_victim_phone, "field 'mEtVictimPhone'", EditText.class);
        criminalCallAddActivity.mEtPhone = (EditText) Utils.findRequiredViewAsType(view, R.id.et_phone, "field 'mEtPhone'", EditText.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_occur_time, "field 'mTvOccurTime' and method 'onViewClicked'");
        criminalCallAddActivity.mTvOccurTime = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_occur_time, "field 'mTvOccurTime'", TextView.class);
        this.f13284c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(criminalCallAddActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_duration, "field 'mTvDuration' and method 'onViewClicked'");
        criminalCallAddActivity.mTvDuration = (TextView) Utils.castView(viewFindRequiredView3, R.id.tv_duration, "field 'mTvDuration'", TextView.class);
        this.f13285d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(criminalCallAddActivity));
        criminalCallAddActivity.mLlClause = Utils.findRequiredView(view, R.id.ll_clause, "field 'mLlClause'");
        criminalCallAddActivity.mTCbSelect = (CheckBox) Utils.findRequiredViewAsType(view, R.id.cb_select, "field 'mTCbSelect'", CheckBox.class);
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.tv_audio_num, "field 'mAudioNum' and method 'onViewClicked'");
        criminalCallAddActivity.mAudioNum = (TextView) Utils.castView(viewFindRequiredView4, R.id.tv_audio_num, "field 'mAudioNum'", TextView.class);
        this.f13286e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(criminalCallAddActivity));
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13287f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(criminalCallAddActivity));
    }
}
