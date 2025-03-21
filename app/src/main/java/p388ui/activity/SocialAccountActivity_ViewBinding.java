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
public class SocialAccountActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private SocialAccountActivity f23228a;

    /* renamed from: b */
    private View f23229b;

    /* renamed from: c */
    private View f23230c;

    /* renamed from: d */
    private View f23231d;

    /* renamed from: ui.activity.SocialAccountActivity_ViewBinding$a */
    class C6609a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SocialAccountActivity f23232a;

        C6609a(SocialAccountActivity socialAccountActivity) {
            this.f23232a = socialAccountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23232a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.SocialAccountActivity_ViewBinding$b */
    class C6610b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SocialAccountActivity f23234a;

        C6610b(SocialAccountActivity socialAccountActivity) {
            this.f23234a = socialAccountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23234a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.SocialAccountActivity_ViewBinding$c */
    class C6611c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SocialAccountActivity f23236a;

        C6611c(SocialAccountActivity socialAccountActivity) {
            this.f23236a = socialAccountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23236a.onViewClicked(view);
        }
    }

    @UiThread
    public SocialAccountActivity_ViewBinding(SocialAccountActivity socialAccountActivity) {
        this(socialAccountActivity, socialAccountActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SocialAccountActivity socialAccountActivity = this.f23228a;
        if (socialAccountActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23228a = null;
        socialAccountActivity.mTvTitle = null;
        socialAccountActivity.mRecyclerview = null;
        socialAccountActivity.mTvSelectTip = null;
        socialAccountActivity.mTvCommit = null;
        socialAccountActivity.mBtnCommit = null;
        this.f23229b.setOnClickListener(null);
        this.f23229b = null;
        this.f23230c.setOnClickListener(null);
        this.f23230c = null;
        this.f23231d.setOnClickListener(null);
        this.f23231d = null;
    }

    @UiThread
    public SocialAccountActivity_ViewBinding(SocialAccountActivity socialAccountActivity, View view) {
        this.f23228a = socialAccountActivity;
        socialAccountActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        socialAccountActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        socialAccountActivity.mTvSelectTip = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_select_tip, "field 'mTvSelectTip'", TextView.class);
        socialAccountActivity.mTvCommit = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_commit_tip, "field 'mTvCommit'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        socialAccountActivity.mBtnCommit = (Button) Utils.castView(findRequiredView, C2113R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f23229b = findRequiredView;
        findRequiredView.setOnClickListener(new C6609a(socialAccountActivity));
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f23230c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6610b(socialAccountActivity));
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.ll_select, "method 'onViewClicked'");
        this.f23231d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6611c(socialAccountActivity));
    }
}
