package p388ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public final class CriminalCallAddActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private CriminalCallAddActivity f22159a;

    /* renamed from: b */
    private View f22160b;

    /* renamed from: c */
    private View f22161c;

    /* renamed from: d */
    private View f22162d;

    /* renamed from: e */
    private View f22163e;

    /* renamed from: f */
    private View f22164f;

    /* renamed from: ui.activity.CriminalCallAddActivity_ViewBinding$a */
    class C6245a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CriminalCallAddActivity f22165a;

        C6245a(CriminalCallAddActivity criminalCallAddActivity) {
            this.f22165a = criminalCallAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22165a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.CriminalCallAddActivity_ViewBinding$b */
    class C6246b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CriminalCallAddActivity f22167a;

        C6246b(CriminalCallAddActivity criminalCallAddActivity) {
            this.f22167a = criminalCallAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22167a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.CriminalCallAddActivity_ViewBinding$c */
    class C6247c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CriminalCallAddActivity f22169a;

        C6247c(CriminalCallAddActivity criminalCallAddActivity) {
            this.f22169a = criminalCallAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22169a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.CriminalCallAddActivity_ViewBinding$d */
    class C6248d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CriminalCallAddActivity f22171a;

        C6248d(CriminalCallAddActivity criminalCallAddActivity) {
            this.f22171a = criminalCallAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22171a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.CriminalCallAddActivity_ViewBinding$e */
    class C6249e extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CriminalCallAddActivity f22173a;

        C6249e(CriminalCallAddActivity criminalCallAddActivity) {
            this.f22173a = criminalCallAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22173a.onViewClicked(view);
        }
    }

    @UiThread
    public CriminalCallAddActivity_ViewBinding(CriminalCallAddActivity criminalCallAddActivity) {
        this(criminalCallAddActivity, criminalCallAddActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        CriminalCallAddActivity criminalCallAddActivity = this.f22159a;
        if (criminalCallAddActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22159a = null;
        criminalCallAddActivity.mTvTitle = null;
        criminalCallAddActivity.mBtnConfirm = null;
        criminalCallAddActivity.mEtVictimPhone = null;
        criminalCallAddActivity.mEtPhone = null;
        criminalCallAddActivity.mTvOccurTime = null;
        criminalCallAddActivity.mTvDuration = null;
        criminalCallAddActivity.mLlClause = null;
        criminalCallAddActivity.mTCbSelect = null;
        criminalCallAddActivity.mAudioNum = null;
        this.f22160b.setOnClickListener(null);
        this.f22160b = null;
        this.f22161c.setOnClickListener(null);
        this.f22161c = null;
        this.f22162d.setOnClickListener(null);
        this.f22162d = null;
        this.f22163e.setOnClickListener(null);
        this.f22163e = null;
        this.f22164f.setOnClickListener(null);
        this.f22164f = null;
    }

    @UiThread
    public CriminalCallAddActivity_ViewBinding(CriminalCallAddActivity criminalCallAddActivity, View view) {
        this.f22159a = criminalCallAddActivity;
        criminalCallAddActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.btn_confirm, "field 'mBtnConfirm' and method 'onViewClicked'");
        criminalCallAddActivity.mBtnConfirm = (Button) Utils.castView(findRequiredView, C2113R.id.btn_confirm, "field 'mBtnConfirm'", Button.class);
        this.f22160b = findRequiredView;
        findRequiredView.setOnClickListener(new C6245a(criminalCallAddActivity));
        criminalCallAddActivity.mEtVictimPhone = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_victim_phone, "field 'mEtVictimPhone'", EditText.class);
        criminalCallAddActivity.mEtPhone = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_phone, "field 'mEtPhone'", EditText.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.tv_occur_time, "field 'mTvOccurTime' and method 'onViewClicked'");
        criminalCallAddActivity.mTvOccurTime = (TextView) Utils.castView(findRequiredView2, C2113R.id.tv_occur_time, "field 'mTvOccurTime'", TextView.class);
        this.f22161c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6246b(criminalCallAddActivity));
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.tv_duration, "field 'mTvDuration' and method 'onViewClicked'");
        criminalCallAddActivity.mTvDuration = (TextView) Utils.castView(findRequiredView3, C2113R.id.tv_duration, "field 'mTvDuration'", TextView.class);
        this.f22162d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6247c(criminalCallAddActivity));
        criminalCallAddActivity.mLlClause = Utils.findRequiredView(view, C2113R.id.ll_clause, "field 'mLlClause'");
        criminalCallAddActivity.mTCbSelect = (CheckBox) Utils.findRequiredViewAsType(view, C2113R.id.cb_select, "field 'mTCbSelect'", CheckBox.class);
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.tv_audio_num, "field 'mAudioNum' and method 'onViewClicked'");
        criminalCallAddActivity.mAudioNum = (TextView) Utils.castView(findRequiredView4, C2113R.id.tv_audio_num, "field 'mAudioNum'", TextView.class);
        this.f22163e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6248d(criminalCallAddActivity));
        View findRequiredView5 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f22164f = findRequiredView5;
        findRequiredView5.setOnClickListener(new C6249e(criminalCallAddActivity));
    }
}
