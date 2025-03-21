package p388ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: classes2.dex */
public class CaseActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private CaseActivity f21999a;

    /* renamed from: b */
    private View f22000b;

    /* renamed from: c */
    private View f22001c;

    /* renamed from: d */
    private View f22002d;

    /* renamed from: e */
    private View f22003e;

    /* renamed from: f */
    private View f22004f;

    /* renamed from: g */
    private View f22005g;

    /* renamed from: h */
    private View f22006h;

    /* renamed from: i */
    private View f22007i;

    /* renamed from: ui.activity.CaseActivity_ViewBinding$a */
    class C6183a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CaseActivity f22008a;

        C6183a(CaseActivity caseActivity) {
            this.f22008a = caseActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22008a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.CaseActivity_ViewBinding$b */
    class C6184b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CaseActivity f22010a;

        C6184b(CaseActivity caseActivity) {
            this.f22010a = caseActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22010a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.CaseActivity_ViewBinding$c */
    class C6185c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CaseActivity f22012a;

        C6185c(CaseActivity caseActivity) {
            this.f22012a = caseActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22012a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.CaseActivity_ViewBinding$d */
    class C6186d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CaseActivity f22014a;

        C6186d(CaseActivity caseActivity) {
            this.f22014a = caseActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22014a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.CaseActivity_ViewBinding$e */
    class C6187e extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CaseActivity f22016a;

        C6187e(CaseActivity caseActivity) {
            this.f22016a = caseActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22016a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.CaseActivity_ViewBinding$f */
    class C6188f extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CaseActivity f22018a;

        C6188f(CaseActivity caseActivity) {
            this.f22018a = caseActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22018a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.CaseActivity_ViewBinding$g */
    class C6189g extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CaseActivity f22020a;

        C6189g(CaseActivity caseActivity) {
            this.f22020a = caseActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22020a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.CaseActivity_ViewBinding$h */
    class C6190h extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CaseActivity f22022a;

        C6190h(CaseActivity caseActivity) {
            this.f22022a = caseActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22022a.onViewClicked(view);
        }
    }

    @UiThread
    public CaseActivity_ViewBinding(CaseActivity caseActivity) {
        this(caseActivity, caseActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CaseActivity caseActivity = this.f21999a;
        if (caseActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f21999a = null;
        caseActivity.mTvTabCreate = null;
        caseActivity.mTvTabHistory = null;
        caseActivity.mTvHistoryDot = null;
        caseActivity.mIvTabCreate = null;
        caseActivity.mIvTabHistory = null;
        caseActivity.mLlCaseQRcode = null;
        caseActivity.mTvCaseName = null;
        caseActivity.mTvNumber = null;
        caseActivity.mIvQrcode = null;
        caseActivity.mTvDate = null;
        caseActivity.mTvCaseCode = null;
        caseActivity.mLlCaseCreate = null;
        caseActivity.mEtName = null;
        caseActivity.mTvType = null;
        caseActivity.mEtCaseCode = null;
        caseActivity.mLlCaseHistory = null;
        caseActivity.mLlCase = null;
        caseActivity.mTvChildTabWait = null;
        caseActivity.mTvChildTabOver = null;
        caseActivity.mSmRefreshWait = null;
        caseActivity.mSmRefreshOver = null;
        caseActivity.mRecyclerviewWait = null;
        caseActivity.mRecyclerviewOver = null;
        caseActivity.mNoDataWait = null;
        caseActivity.mNoDataOver = null;
        this.f22000b.setOnClickListener(null);
        this.f22000b = null;
        this.f22001c.setOnClickListener(null);
        this.f22001c = null;
        this.f22002d.setOnClickListener(null);
        this.f22002d = null;
        this.f22003e.setOnClickListener(null);
        this.f22003e = null;
        this.f22004f.setOnClickListener(null);
        this.f22004f = null;
        this.f22005g.setOnClickListener(null);
        this.f22005g = null;
        this.f22006h.setOnClickListener(null);
        this.f22006h = null;
        this.f22007i.setOnClickListener(null);
        this.f22007i = null;
    }

    @UiThread
    public CaseActivity_ViewBinding(CaseActivity caseActivity, View view) {
        this.f21999a = caseActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.tv_tab_create, "field 'mTvTabCreate' and method 'onViewClicked'");
        caseActivity.mTvTabCreate = (TextView) Utils.castView(findRequiredView, C2113R.id.tv_tab_create, "field 'mTvTabCreate'", TextView.class);
        this.f22000b = findRequiredView;
        findRequiredView.setOnClickListener(new C6183a(caseActivity));
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.tv_tab_history, "field 'mTvTabHistory' and method 'onViewClicked'");
        caseActivity.mTvTabHistory = (TextView) Utils.castView(findRequiredView2, C2113R.id.tv_tab_history, "field 'mTvTabHistory'", TextView.class);
        this.f22001c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6184b(caseActivity));
        caseActivity.mTvHistoryDot = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_history_dot, "field 'mTvHistoryDot'", TextView.class);
        caseActivity.mIvTabCreate = (ImageView) Utils.findRequiredViewAsType(view, C2113R.id.iv_tab_create, "field 'mIvTabCreate'", ImageView.class);
        caseActivity.mIvTabHistory = (ImageView) Utils.findRequiredViewAsType(view, C2113R.id.iv_tab_history, "field 'mIvTabHistory'", ImageView.class);
        caseActivity.mLlCaseQRcode = (LinearLayout) Utils.findRequiredViewAsType(view, C2113R.id.ll_case_qrcode, "field 'mLlCaseQRcode'", LinearLayout.class);
        caseActivity.mTvCaseName = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_case_name, "field 'mTvCaseName'", TextView.class);
        caseActivity.mTvNumber = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_number, "field 'mTvNumber'", TextView.class);
        caseActivity.mIvQrcode = (ImageView) Utils.findRequiredViewAsType(view, C2113R.id.iv_qrcode, "field 'mIvQrcode'", ImageView.class);
        caseActivity.mTvDate = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_date, "field 'mTvDate'", TextView.class);
        caseActivity.mTvCaseCode = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_case_code, "field 'mTvCaseCode'", TextView.class);
        caseActivity.mLlCaseCreate = (LinearLayout) Utils.findRequiredViewAsType(view, C2113R.id.ll_case_create, "field 'mLlCaseCreate'", LinearLayout.class);
        caseActivity.mEtName = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_name, "field 'mEtName'", EditText.class);
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.tv_type, "field 'mTvType' and method 'onViewClicked'");
        caseActivity.mTvType = (TextView) Utils.castView(findRequiredView3, C2113R.id.tv_type, "field 'mTvType'", TextView.class);
        this.f22002d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6185c(caseActivity));
        caseActivity.mEtCaseCode = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_case_code, "field 'mEtCaseCode'", EditText.class);
        caseActivity.mLlCaseHistory = (LinearLayout) Utils.findRequiredViewAsType(view, C2113R.id.ll_case_history, "field 'mLlCaseHistory'", LinearLayout.class);
        caseActivity.mLlCase = (LinearLayout) Utils.findRequiredViewAsType(view, C2113R.id.ll_case, "field 'mLlCase'", LinearLayout.class);
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.tv_child_tab_wait, "field 'mTvChildTabWait' and method 'onViewClicked'");
        caseActivity.mTvChildTabWait = (TextView) Utils.castView(findRequiredView4, C2113R.id.tv_child_tab_wait, "field 'mTvChildTabWait'", TextView.class);
        this.f22003e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6186d(caseActivity));
        View findRequiredView5 = Utils.findRequiredView(view, C2113R.id.tv_child_tab_over, "field 'mTvChildTabOver' and method 'onViewClicked'");
        caseActivity.mTvChildTabOver = (TextView) Utils.castView(findRequiredView5, C2113R.id.tv_child_tab_over, "field 'mTvChildTabOver'", TextView.class);
        this.f22004f = findRequiredView5;
        findRequiredView5.setOnClickListener(new C6187e(caseActivity));
        caseActivity.mSmRefreshWait = (SmartRefreshLayout) Utils.findRequiredViewAsType(view, C2113R.id.sm_refresh_wait, "field 'mSmRefreshWait'", SmartRefreshLayout.class);
        caseActivity.mSmRefreshOver = (SmartRefreshLayout) Utils.findRequiredViewAsType(view, C2113R.id.sm_refresh_over, "field 'mSmRefreshOver'", SmartRefreshLayout.class);
        caseActivity.mRecyclerviewWait = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview_wait, "field 'mRecyclerviewWait'", RecyclerView.class);
        caseActivity.mRecyclerviewOver = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview_over, "field 'mRecyclerviewOver'", RecyclerView.class);
        caseActivity.mNoDataWait = Utils.findRequiredView(view, C2113R.id.include_wait, "field 'mNoDataWait'");
        caseActivity.mNoDataOver = Utils.findRequiredView(view, C2113R.id.include_over, "field 'mNoDataOver'");
        View findRequiredView6 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f22005g = findRequiredView6;
        findRequiredView6.setOnClickListener(new C6188f(caseActivity));
        View findRequiredView7 = Utils.findRequiredView(view, C2113R.id.confirm, "method 'onViewClicked'");
        this.f22006h = findRequiredView7;
        findRequiredView7.setOnClickListener(new C6189g(caseActivity));
        View findRequiredView8 = Utils.findRequiredView(view, C2113R.id.tv_close, "method 'onViewClicked'");
        this.f22007i = findRequiredView8;
        findRequiredView8.setOnClickListener(new C6190h(caseActivity));
    }
}
