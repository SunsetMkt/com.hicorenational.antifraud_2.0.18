package p388ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class AppActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private AppActivity f21809a;

    /* renamed from: b */
    private View f21810b;

    /* renamed from: c */
    private View f21811c;

    /* renamed from: d */
    private View f21812d;

    /* renamed from: ui.activity.AppActivity_ViewBinding$a */
    class C6121a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ AppActivity f21813a;

        C6121a(AppActivity appActivity) {
            this.f21813a = appActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21813a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.AppActivity_ViewBinding$b */
    class C6122b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ AppActivity f21815a;

        C6122b(AppActivity appActivity) {
            this.f21815a = appActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21815a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.AppActivity_ViewBinding$c */
    class C6123c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ AppActivity f21817a;

        C6123c(AppActivity appActivity) {
            this.f21817a = appActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21817a.onViewClicked(view);
        }
    }

    @UiThread
    public AppActivity_ViewBinding(AppActivity appActivity) {
        this(appActivity, appActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AppActivity appActivity = this.f21809a;
        if (appActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f21809a = null;
        appActivity.mTvTitle = null;
        appActivity.mRecyclerview = null;
        appActivity.mTvSelectTip = null;
        appActivity.mTvCommitTip = null;
        appActivity.mBtnCommit = null;
        this.f21810b.setOnClickListener(null);
        this.f21810b = null;
        this.f21811c.setOnClickListener(null);
        this.f21811c = null;
        this.f21812d.setOnClickListener(null);
        this.f21812d = null;
    }

    @UiThread
    public AppActivity_ViewBinding(AppActivity appActivity, View view) {
        this.f21809a = appActivity;
        appActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        appActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        appActivity.mTvSelectTip = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_select_tip, "field 'mTvSelectTip'", TextView.class);
        appActivity.mTvCommitTip = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_commit_tip, "field 'mTvCommitTip'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        appActivity.mBtnCommit = (Button) Utils.castView(findRequiredView, C2113R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f21810b = findRequiredView;
        findRequiredView.setOnClickListener(new C6121a(appActivity));
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f21811c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6122b(appActivity));
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.ll_select, "method 'onViewClicked'");
        this.f21812d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6123c(appActivity));
    }
}
