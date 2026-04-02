package ui.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class MineFragment_ViewBinding implements Unbinder {
    private MineFragment a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f14180b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f14181c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f14182d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f14183e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f14184f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private View f14185g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private View f14186h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private View f14187i;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ MineFragment a;

        a(MineFragment mineFragment) {
            this.a = mineFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ MineFragment a;

        b(MineFragment mineFragment) {
            this.a = mineFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ MineFragment a;

        c(MineFragment mineFragment) {
            this.a = mineFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {
        final /* synthetic */ MineFragment a;

        d(MineFragment mineFragment) {
            this.a = mineFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class e extends DebouncingOnClickListener {
        final /* synthetic */ MineFragment a;

        e(MineFragment mineFragment) {
            this.a = mineFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class f extends DebouncingOnClickListener {
        final /* synthetic */ MineFragment a;

        f(MineFragment mineFragment) {
            this.a = mineFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class g extends DebouncingOnClickListener {
        final /* synthetic */ MineFragment a;

        g(MineFragment mineFragment) {
            this.a = mineFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class h extends DebouncingOnClickListener {
        final /* synthetic */ MineFragment a;

        h(MineFragment mineFragment) {
            this.a = mineFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public MineFragment_ViewBinding(MineFragment mineFragment, View view) {
        this.a = mineFragment;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_phone, "field 'mTvPhone' and method 'onViewClicked'");
        mineFragment.mTvPhone = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_phone, "field 'mTvPhone'", TextView.class);
        this.f14180b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(mineFragment));
        mineFragment.mTvExplain = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_explain, "field 'mTvExplain'", TextView.class);
        mineFragment.mTvLevelLb = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_Level_lb, "field 'mTvLevelLb'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.ll_report_list, "field 'mLlReport' and method 'onViewClicked'");
        mineFragment.mLlReport = viewFindRequiredView2;
        this.f14181c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(mineFragment));
        mineFragment.mTvRepNum = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_repNum, "field 'mTvRepNum'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_evidence_list, "field 'mLlEvide' and method 'onViewClicked'");
        mineFragment.mLlEvide = viewFindRequiredView3;
        this.f14182d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(mineFragment));
        mineFragment.mTvEvidNum = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_evidNum, "field 'mTvEvidNum'", TextView.class);
        mineFragment.reportRedTip = (TextView) Utils.findRequiredViewAsType(view, R.id.report_red_tip, "field 'reportRedTip'", TextView.class);
        mineFragment.caseRedTip = (TextView) Utils.findRequiredViewAsType(view, R.id.case_red_tip, "field 'caseRedTip'", TextView.class);
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.cl_head, "field 'mClHead' and method 'onViewClicked'");
        mineFragment.mClHead = viewFindRequiredView4;
        this.f14183e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(mineFragment));
        mineFragment.mLlDetalHis = Utils.findRequiredView(view, R.id.ll_datile, "field 'mLlDetalHis'");
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.ll_feedback, "field 'mLlFeedBack' and method 'onViewClicked'");
        mineFragment.mLlFeedBack = viewFindRequiredView5;
        this.f14184f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(mineFragment));
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.ll_ablout_app, "field 'mLlAboutUs' and method 'onViewClicked'");
        mineFragment.mLlAboutUs = viewFindRequiredView6;
        this.f14185g = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(mineFragment));
        View viewFindRequiredView7 = Utils.findRequiredView(view, R.id.ll_setting, "field 'mLlSetting' and method 'onViewClicked'");
        mineFragment.mLlSetting = viewFindRequiredView7;
        this.f14186h = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new g(mineFragment));
        View viewFindRequiredView8 = Utils.findRequiredView(view, R.id.ll_user_note, "method 'onViewClicked'");
        this.f14187i = viewFindRequiredView8;
        viewFindRequiredView8.setOnClickListener(new h(mineFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MineFragment mineFragment = this.a;
        if (mineFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
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
        this.f14180b.setOnClickListener(null);
        this.f14180b = null;
        this.f14181c.setOnClickListener(null);
        this.f14181c = null;
        this.f14182d.setOnClickListener(null);
        this.f14182d = null;
        this.f14183e.setOnClickListener(null);
        this.f14183e = null;
        this.f14184f.setOnClickListener(null);
        this.f14184f = null;
        this.f14185g.setOnClickListener(null);
        this.f14185g = null;
        this.f14186h.setOnClickListener(null);
        this.f14186h = null;
        this.f14187i.setOnClickListener(null);
        this.f14187i = null;
    }
}
