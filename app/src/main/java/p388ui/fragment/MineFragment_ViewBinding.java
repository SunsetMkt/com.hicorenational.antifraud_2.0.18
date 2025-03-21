package p388ui.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class MineFragment_ViewBinding implements Unbinder {

    /* renamed from: a */
    private MineFragment f23824a;

    /* renamed from: b */
    private View f23825b;

    /* renamed from: c */
    private View f23826c;

    /* renamed from: d */
    private View f23827d;

    /* renamed from: e */
    private View f23828e;

    /* renamed from: f */
    private View f23829f;

    /* renamed from: g */
    private View f23830g;

    /* renamed from: h */
    private View f23831h;

    /* renamed from: i */
    private View f23832i;

    /* renamed from: ui.fragment.MineFragment_ViewBinding$a */
    class C6866a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ MineFragment f23833a;

        C6866a(MineFragment mineFragment) {
            this.f23833a = mineFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23833a.onViewClicked(view);
        }
    }

    /* renamed from: ui.fragment.MineFragment_ViewBinding$b */
    class C6867b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ MineFragment f23835a;

        C6867b(MineFragment mineFragment) {
            this.f23835a = mineFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23835a.onViewClicked(view);
        }
    }

    /* renamed from: ui.fragment.MineFragment_ViewBinding$c */
    class C6868c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ MineFragment f23837a;

        C6868c(MineFragment mineFragment) {
            this.f23837a = mineFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23837a.onViewClicked(view);
        }
    }

    /* renamed from: ui.fragment.MineFragment_ViewBinding$d */
    class C6869d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ MineFragment f23839a;

        C6869d(MineFragment mineFragment) {
            this.f23839a = mineFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23839a.onViewClicked(view);
        }
    }

    /* renamed from: ui.fragment.MineFragment_ViewBinding$e */
    class C6870e extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ MineFragment f23841a;

        C6870e(MineFragment mineFragment) {
            this.f23841a = mineFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23841a.onViewClicked(view);
        }
    }

    /* renamed from: ui.fragment.MineFragment_ViewBinding$f */
    class C6871f extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ MineFragment f23843a;

        C6871f(MineFragment mineFragment) {
            this.f23843a = mineFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23843a.onViewClicked(view);
        }
    }

    /* renamed from: ui.fragment.MineFragment_ViewBinding$g */
    class C6872g extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ MineFragment f23845a;

        C6872g(MineFragment mineFragment) {
            this.f23845a = mineFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23845a.onViewClicked(view);
        }
    }

    /* renamed from: ui.fragment.MineFragment_ViewBinding$h */
    class C6873h extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ MineFragment f23847a;

        C6873h(MineFragment mineFragment) {
            this.f23847a = mineFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23847a.onViewClicked(view);
        }
    }

    @UiThread
    public MineFragment_ViewBinding(MineFragment mineFragment, View view) {
        this.f23824a = mineFragment;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.tv_phone, "field 'mTvPhone' and method 'onViewClicked'");
        mineFragment.mTvPhone = (TextView) Utils.castView(findRequiredView, C2113R.id.tv_phone, "field 'mTvPhone'", TextView.class);
        this.f23825b = findRequiredView;
        findRequiredView.setOnClickListener(new C6866a(mineFragment));
        mineFragment.mTvExplain = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_explain, "field 'mTvExplain'", TextView.class);
        mineFragment.mTvLevelLb = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_Level_lb, "field 'mTvLevelLb'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.ll_report_list, "field 'mLlReport' and method 'onViewClicked'");
        mineFragment.mLlReport = findRequiredView2;
        this.f23826c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6867b(mineFragment));
        mineFragment.mTvRepNum = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_repNum, "field 'mTvRepNum'", TextView.class);
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.ll_evidence_list, "field 'mLlEvide' and method 'onViewClicked'");
        mineFragment.mLlEvide = findRequiredView3;
        this.f23827d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6868c(mineFragment));
        mineFragment.mTvEvidNum = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_evidNum, "field 'mTvEvidNum'", TextView.class);
        mineFragment.reportRedTip = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.report_red_tip, "field 'reportRedTip'", TextView.class);
        mineFragment.caseRedTip = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.case_red_tip, "field 'caseRedTip'", TextView.class);
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.cl_head, "field 'mClHead' and method 'onViewClicked'");
        mineFragment.mClHead = findRequiredView4;
        this.f23828e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6869d(mineFragment));
        mineFragment.mLlDetalHis = Utils.findRequiredView(view, C2113R.id.ll_datile, "field 'mLlDetalHis'");
        View findRequiredView5 = Utils.findRequiredView(view, C2113R.id.ll_feedback, "field 'mLlFeedBack' and method 'onViewClicked'");
        mineFragment.mLlFeedBack = findRequiredView5;
        this.f23829f = findRequiredView5;
        findRequiredView5.setOnClickListener(new C6870e(mineFragment));
        View findRequiredView6 = Utils.findRequiredView(view, C2113R.id.ll_ablout_app, "field 'mLlAboutUs' and method 'onViewClicked'");
        mineFragment.mLlAboutUs = findRequiredView6;
        this.f23830g = findRequiredView6;
        findRequiredView6.setOnClickListener(new C6871f(mineFragment));
        View findRequiredView7 = Utils.findRequiredView(view, C2113R.id.ll_setting, "field 'mLlSetting' and method 'onViewClicked'");
        mineFragment.mLlSetting = findRequiredView7;
        this.f23831h = findRequiredView7;
        findRequiredView7.setOnClickListener(new C6872g(mineFragment));
        View findRequiredView8 = Utils.findRequiredView(view, C2113R.id.ll_user_note, "method 'onViewClicked'");
        this.f23832i = findRequiredView8;
        findRequiredView8.setOnClickListener(new C6873h(mineFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MineFragment mineFragment = this.f23824a;
        if (mineFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23824a = null;
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
        this.f23825b.setOnClickListener(null);
        this.f23825b = null;
        this.f23826c.setOnClickListener(null);
        this.f23826c = null;
        this.f23827d.setOnClickListener(null);
        this.f23827d = null;
        this.f23828e.setOnClickListener(null);
        this.f23828e = null;
        this.f23829f.setOnClickListener(null);
        this.f23829f = null;
        this.f23830g.setOnClickListener(null);
        this.f23830g = null;
        this.f23831h.setOnClickListener(null);
        this.f23831h = null;
        this.f23832i.setOnClickListener(null);
        this.f23832i = null;
    }
}
