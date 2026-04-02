package ui.activity;

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
import com.hicorenational.antifraud.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* JADX INFO: loaded from: classes2.dex */
public class CaseActivity_ViewBinding implements Unbinder {
    private CaseActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13194c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13195d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f13196e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f13197f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private View f13198g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private View f13199h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private View f13200i;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ CaseActivity a;

        a(CaseActivity caseActivity) {
            this.a = caseActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ CaseActivity a;

        b(CaseActivity caseActivity) {
            this.a = caseActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ CaseActivity a;

        c(CaseActivity caseActivity) {
            this.a = caseActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {
        final /* synthetic */ CaseActivity a;

        d(CaseActivity caseActivity) {
            this.a = caseActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class e extends DebouncingOnClickListener {
        final /* synthetic */ CaseActivity a;

        e(CaseActivity caseActivity) {
            this.a = caseActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class f extends DebouncingOnClickListener {
        final /* synthetic */ CaseActivity a;

        f(CaseActivity caseActivity) {
            this.a = caseActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class g extends DebouncingOnClickListener {
        final /* synthetic */ CaseActivity a;

        g(CaseActivity caseActivity) {
            this.a = caseActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class h extends DebouncingOnClickListener {
        final /* synthetic */ CaseActivity a;

        h(CaseActivity caseActivity) {
            this.a = caseActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public CaseActivity_ViewBinding(CaseActivity caseActivity) {
        this(caseActivity, caseActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CaseActivity caseActivity = this.a;
        if (caseActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
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
        this.f13193b.setOnClickListener(null);
        this.f13193b = null;
        this.f13194c.setOnClickListener(null);
        this.f13194c = null;
        this.f13195d.setOnClickListener(null);
        this.f13195d = null;
        this.f13196e.setOnClickListener(null);
        this.f13196e = null;
        this.f13197f.setOnClickListener(null);
        this.f13197f = null;
        this.f13198g.setOnClickListener(null);
        this.f13198g = null;
        this.f13199h.setOnClickListener(null);
        this.f13199h = null;
        this.f13200i.setOnClickListener(null);
        this.f13200i = null;
    }

    @UiThread
    public CaseActivity_ViewBinding(CaseActivity caseActivity, View view) {
        this.a = caseActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_tab_create, "field 'mTvTabCreate' and method 'onViewClicked'");
        caseActivity.mTvTabCreate = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_tab_create, "field 'mTvTabCreate'", TextView.class);
        this.f13193b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(caseActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_tab_history, "field 'mTvTabHistory' and method 'onViewClicked'");
        caseActivity.mTvTabHistory = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_tab_history, "field 'mTvTabHistory'", TextView.class);
        this.f13194c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(caseActivity));
        caseActivity.mTvHistoryDot = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_history_dot, "field 'mTvHistoryDot'", TextView.class);
        caseActivity.mIvTabCreate = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_tab_create, "field 'mIvTabCreate'", ImageView.class);
        caseActivity.mIvTabHistory = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_tab_history, "field 'mIvTabHistory'", ImageView.class);
        caseActivity.mLlCaseQRcode = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_case_qrcode, "field 'mLlCaseQRcode'", LinearLayout.class);
        caseActivity.mTvCaseName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_case_name, "field 'mTvCaseName'", TextView.class);
        caseActivity.mTvNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_number, "field 'mTvNumber'", TextView.class);
        caseActivity.mIvQrcode = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_qrcode, "field 'mIvQrcode'", ImageView.class);
        caseActivity.mTvDate = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_date, "field 'mTvDate'", TextView.class);
        caseActivity.mTvCaseCode = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_case_code, "field 'mTvCaseCode'", TextView.class);
        caseActivity.mLlCaseCreate = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_case_create, "field 'mLlCaseCreate'", LinearLayout.class);
        caseActivity.mEtName = (EditText) Utils.findRequiredViewAsType(view, R.id.et_name, "field 'mEtName'", EditText.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_type, "field 'mTvType' and method 'onViewClicked'");
        caseActivity.mTvType = (TextView) Utils.castView(viewFindRequiredView3, R.id.tv_type, "field 'mTvType'", TextView.class);
        this.f13195d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(caseActivity));
        caseActivity.mEtCaseCode = (EditText) Utils.findRequiredViewAsType(view, R.id.et_case_code, "field 'mEtCaseCode'", EditText.class);
        caseActivity.mLlCaseHistory = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_case_history, "field 'mLlCaseHistory'", LinearLayout.class);
        caseActivity.mLlCase = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_case, "field 'mLlCase'", LinearLayout.class);
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.tv_child_tab_wait, "field 'mTvChildTabWait' and method 'onViewClicked'");
        caseActivity.mTvChildTabWait = (TextView) Utils.castView(viewFindRequiredView4, R.id.tv_child_tab_wait, "field 'mTvChildTabWait'", TextView.class);
        this.f13196e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(caseActivity));
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.tv_child_tab_over, "field 'mTvChildTabOver' and method 'onViewClicked'");
        caseActivity.mTvChildTabOver = (TextView) Utils.castView(viewFindRequiredView5, R.id.tv_child_tab_over, "field 'mTvChildTabOver'", TextView.class);
        this.f13197f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(caseActivity));
        caseActivity.mSmRefreshWait = (SmartRefreshLayout) Utils.findRequiredViewAsType(view, R.id.sm_refresh_wait, "field 'mSmRefreshWait'", SmartRefreshLayout.class);
        caseActivity.mSmRefreshOver = (SmartRefreshLayout) Utils.findRequiredViewAsType(view, R.id.sm_refresh_over, "field 'mSmRefreshOver'", SmartRefreshLayout.class);
        caseActivity.mRecyclerviewWait = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview_wait, "field 'mRecyclerviewWait'", RecyclerView.class);
        caseActivity.mRecyclerviewOver = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview_over, "field 'mRecyclerviewOver'", RecyclerView.class);
        caseActivity.mNoDataWait = Utils.findRequiredView(view, R.id.include_wait, "field 'mNoDataWait'");
        caseActivity.mNoDataOver = Utils.findRequiredView(view, R.id.include_over, "field 'mNoDataOver'");
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13198g = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(caseActivity));
        View viewFindRequiredView7 = Utils.findRequiredView(view, R.id.confirm, "method 'onViewClicked'");
        this.f13199h = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new g(caseActivity));
        View viewFindRequiredView8 = Utils.findRequiredView(view, R.id.tv_close, "method 'onViewClicked'");
        this.f13200i = viewFindRequiredView8;
        viewFindRequiredView8.setOnClickListener(new h(caseActivity));
    }
}
