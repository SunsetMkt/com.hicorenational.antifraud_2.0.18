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
public class SocialAccountActivity_ViewBinding implements Unbinder {
    private SocialAccountActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13879d;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ SocialAccountActivity a;

        a(SocialAccountActivity socialAccountActivity) {
            this.a = socialAccountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ SocialAccountActivity a;

        b(SocialAccountActivity socialAccountActivity) {
            this.a = socialAccountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ SocialAccountActivity a;

        c(SocialAccountActivity socialAccountActivity) {
            this.a = socialAccountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public SocialAccountActivity_ViewBinding(SocialAccountActivity socialAccountActivity) {
        this(socialAccountActivity, socialAccountActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SocialAccountActivity socialAccountActivity = this.a;
        if (socialAccountActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        socialAccountActivity.mTvTitle = null;
        socialAccountActivity.mRecyclerview = null;
        socialAccountActivity.mTvSelectTip = null;
        socialAccountActivity.mTvCommit = null;
        socialAccountActivity.mBtnCommit = null;
        this.f13877b.setOnClickListener(null);
        this.f13877b = null;
        this.f13878c.setOnClickListener(null);
        this.f13878c = null;
        this.f13879d.setOnClickListener(null);
        this.f13879d = null;
    }

    @UiThread
    public SocialAccountActivity_ViewBinding(SocialAccountActivity socialAccountActivity, View view) {
        this.a = socialAccountActivity;
        socialAccountActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        socialAccountActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        socialAccountActivity.mTvSelectTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_select_tip, "field 'mTvSelectTip'", TextView.class);
        socialAccountActivity.mTvCommit = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_commit_tip, "field 'mTvCommit'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        socialAccountActivity.mBtnCommit = (Button) Utils.castView(viewFindRequiredView, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f13877b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(socialAccountActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13878c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(socialAccountActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_select, "method 'onViewClicked'");
        this.f13879d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(socialAccountActivity));
    }
}
