package ui.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class MineFragment_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private MineFragment f19637a;

    /* renamed from: b, reason: collision with root package name */
    private View f19638b;

    /* renamed from: c, reason: collision with root package name */
    private View f19639c;

    /* renamed from: d, reason: collision with root package name */
    private View f19640d;

    /* renamed from: e, reason: collision with root package name */
    private View f19641e;

    /* renamed from: f, reason: collision with root package name */
    private View f19642f;

    /* renamed from: g, reason: collision with root package name */
    private View f19643g;

    /* renamed from: h, reason: collision with root package name */
    private View f19644h;

    /* renamed from: i, reason: collision with root package name */
    private View f19645i;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MineFragment f19646a;

        a(MineFragment mineFragment) {
            this.f19646a = mineFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19646a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MineFragment f19648a;

        b(MineFragment mineFragment) {
            this.f19648a = mineFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19648a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MineFragment f19650a;

        c(MineFragment mineFragment) {
            this.f19650a = mineFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19650a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MineFragment f19652a;

        d(MineFragment mineFragment) {
            this.f19652a = mineFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19652a.onViewClicked(view);
        }
    }

    class e extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MineFragment f19654a;

        e(MineFragment mineFragment) {
            this.f19654a = mineFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19654a.onViewClicked(view);
        }
    }

    class f extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MineFragment f19656a;

        f(MineFragment mineFragment) {
            this.f19656a = mineFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19656a.onViewClicked(view);
        }
    }

    class g extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MineFragment f19658a;

        g(MineFragment mineFragment) {
            this.f19658a = mineFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19658a.onViewClicked(view);
        }
    }

    class h extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MineFragment f19660a;

        h(MineFragment mineFragment) {
            this.f19660a = mineFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19660a.onViewClicked(view);
        }
    }

    @UiThread
    public MineFragment_ViewBinding(MineFragment mineFragment, View view) {
        this.f19637a = mineFragment;
        View findRequiredView = Utils.findRequiredView(view, R.id.tv_phone, "field 'mTvPhone' and method 'onViewClicked'");
        mineFragment.mTvPhone = (TextView) Utils.castView(findRequiredView, R.id.tv_phone, "field 'mTvPhone'", TextView.class);
        this.f19638b = findRequiredView;
        findRequiredView.setOnClickListener(new a(mineFragment));
        mineFragment.mTvExplain = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_explain, "field 'mTvExplain'", TextView.class);
        mineFragment.mTvLevelLb = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_Level_lb, "field 'mTvLevelLb'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.ll_report_list, "field 'mLlReport' and method 'onViewClicked'");
        mineFragment.mLlReport = findRequiredView2;
        this.f19639c = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(mineFragment));
        mineFragment.mTvRepNum = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_repNum, "field 'mTvRepNum'", TextView.class);
        View findRequiredView3 = Utils.findRequiredView(view, R.id.ll_evidence_list, "field 'mLlEvide' and method 'onViewClicked'");
        mineFragment.mLlEvide = findRequiredView3;
        this.f19640d = findRequiredView3;
        findRequiredView3.setOnClickListener(new c(mineFragment));
        mineFragment.mTvEvidNum = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_evidNum, "field 'mTvEvidNum'", TextView.class);
        mineFragment.reportRedTip = (TextView) Utils.findRequiredViewAsType(view, R.id.report_red_tip, "field 'reportRedTip'", TextView.class);
        mineFragment.caseRedTip = (TextView) Utils.findRequiredViewAsType(view, R.id.case_red_tip, "field 'caseRedTip'", TextView.class);
        View findRequiredView4 = Utils.findRequiredView(view, R.id.cl_head, "field 'mClHead' and method 'onViewClicked'");
        mineFragment.mClHead = findRequiredView4;
        this.f19641e = findRequiredView4;
        findRequiredView4.setOnClickListener(new d(mineFragment));
        mineFragment.mLlDetalHis = Utils.findRequiredView(view, R.id.ll_datile, "field 'mLlDetalHis'");
        View findRequiredView5 = Utils.findRequiredView(view, R.id.ll_feedback, "field 'mLlFeedBack' and method 'onViewClicked'");
        mineFragment.mLlFeedBack = findRequiredView5;
        this.f19642f = findRequiredView5;
        findRequiredView5.setOnClickListener(new e(mineFragment));
        View findRequiredView6 = Utils.findRequiredView(view, R.id.ll_ablout_app, "field 'mLlAboutUs' and method 'onViewClicked'");
        mineFragment.mLlAboutUs = findRequiredView6;
        this.f19643g = findRequiredView6;
        findRequiredView6.setOnClickListener(new f(mineFragment));
        View findRequiredView7 = Utils.findRequiredView(view, R.id.ll_setting, "field 'mLlSetting' and method 'onViewClicked'");
        mineFragment.mLlSetting = findRequiredView7;
        this.f19644h = findRequiredView7;
        findRequiredView7.setOnClickListener(new g(mineFragment));
        View findRequiredView8 = Utils.findRequiredView(view, R.id.ll_user_note, "method 'onViewClicked'");
        this.f19645i = findRequiredView8;
        findRequiredView8.setOnClickListener(new h(mineFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MineFragment mineFragment = this.f19637a;
        if (mineFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f19637a = null;
        mineFragment.mTvPhone = null;
        mineFragment.mTvExplain = null;
        mineFragment.mTvLevelLb = null;
        mineFragment.mLlReport = null;
        mineFragment.mTvRepNum = null;
        mineFragment.mLlEvide = null;
        mineFragment.mTvEvidNum = null;
        mineFragment.reportRedTip = null;
        mineFragment.caseRedTip = null;
        mineFragment.mClHead = null;
        mineFragment.mLlDetalHis = null;
        mineFragment.mLlFeedBack = null;
        mineFragment.mLlAboutUs = null;
        mineFragment.mLlSetting = null;
        this.f19638b.setOnClickListener(null);
        this.f19638b = null;
        this.f19639c.setOnClickListener(null);
        this.f19639c = null;
        this.f19640d.setOnClickListener(null);
        this.f19640d = null;
        this.f19641e.setOnClickListener(null);
        this.f19641e = null;
        this.f19642f.setOnClickListener(null);
        this.f19642f = null;
        this.f19643g.setOnClickListener(null);
        this.f19643g = null;
        this.f19644h.setOnClickListener(null);
        this.f19644h = null;
        this.f19645i.setOnClickListener(null);
        this.f19645i = null;
    }
}
