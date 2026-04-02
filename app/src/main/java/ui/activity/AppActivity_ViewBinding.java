package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class AppActivity_ViewBinding implements Unbinder {
    private AppActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13088d;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ AppActivity a;

        a(AppActivity appActivity) {
            this.a = appActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ AppActivity a;

        b(AppActivity appActivity) {
            this.a = appActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ AppActivity a;

        c(AppActivity appActivity) {
            this.a = appActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public AppActivity_ViewBinding(AppActivity appActivity) {
        this(appActivity, appActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AppActivity appActivity = this.a;
        if (appActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        appActivity.mTvTitle = null;
        appActivity.mRecyclerview = null;
        appActivity.mTvSelectTip = null;
        appActivity.mTvCommitTip = null;
        appActivity.mBtnCommit = null;
        this.f13086b.setOnClickListener(null);
        this.f13086b = null;
        this.f13087c.setOnClickListener(null);
        this.f13087c = null;
        this.f13088d.setOnClickListener(null);
        this.f13088d = null;
    }

    @UiThread
    public AppActivity_ViewBinding(AppActivity appActivity, View view) {
        this.a = appActivity;
        appActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        appActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        appActivity.mTvSelectTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_select_tip, "field 'mTvSelectTip'", TextView.class);
        appActivity.mTvCommitTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_commit_tip, "field 'mTvCommitTip'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        appActivity.mBtnCommit = (Button) Utils.castView(viewFindRequiredView, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f13086b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(appActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13087c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(appActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_select, "method 'onViewClicked'");
        this.f13088d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(appActivity));
    }
}
