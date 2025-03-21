package p388ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public final class ReChargeActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private ReChargeActivity f22760a;

    /* renamed from: b */
    private View f22761b;

    /* renamed from: c */
    private View f22762c;

    /* renamed from: d */
    private View f22763d;

    /* renamed from: ui.activity.ReChargeActivity_ViewBinding$a */
    class C6456a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ReChargeActivity f22764a;

        C6456a(ReChargeActivity reChargeActivity) {
            this.f22764a = reChargeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22764a.onClick(view);
        }
    }

    /* renamed from: ui.activity.ReChargeActivity_ViewBinding$b */
    class C6457b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ReChargeActivity f22766a;

        C6457b(ReChargeActivity reChargeActivity) {
            this.f22766a = reChargeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22766a.onClick(view);
        }
    }

    /* renamed from: ui.activity.ReChargeActivity_ViewBinding$c */
    class C6458c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ReChargeActivity f22768a;

        C6458c(ReChargeActivity reChargeActivity) {
            this.f22768a = reChargeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22768a.onClick(view);
        }
    }

    @UiThread
    public ReChargeActivity_ViewBinding(ReChargeActivity reChargeActivity) {
        this(reChargeActivity, reChargeActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ReChargeActivity reChargeActivity = this.f22760a;
        if (reChargeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22760a = null;
        reChargeActivity.mIvBack = null;
        reChargeActivity.mTvTitle = null;
        reChargeActivity.mLlAddLayout = null;
        reChargeActivity.mTvAdd = null;
        reChargeActivity.mRecycleView = null;
        reChargeActivity.mTvCommitTip = null;
        reChargeActivity.mBtnCommit = null;
        this.f22761b.setOnClickListener(null);
        this.f22761b = null;
        this.f22762c.setOnClickListener(null);
        this.f22762c = null;
        this.f22763d.setOnClickListener(null);
        this.f22763d = null;
    }

    @UiThread
    public ReChargeActivity_ViewBinding(ReChargeActivity reChargeActivity, View view) {
        this.f22760a = reChargeActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        reChargeActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f22761b = findRequiredView;
        findRequiredView.setOnClickListener(new C6456a(reChargeActivity));
        reChargeActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.ll_add, "field 'mLlAddLayout' and method 'onClick'");
        reChargeActivity.mLlAddLayout = findRequiredView2;
        this.f22762c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6457b(reChargeActivity));
        reChargeActivity.mTvAdd = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_add, "field 'mTvAdd'", TextView.class);
        reChargeActivity.mRecycleView = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecycleView'", RecyclerView.class);
        reChargeActivity.mTvCommitTip = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_commit_tip, "field 'mTvCommitTip'", TextView.class);
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.btn_commit, "field 'mBtnCommit' and method 'onClick'");
        reChargeActivity.mBtnCommit = (Button) Utils.castView(findRequiredView3, C2113R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f22763d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6458c(reChargeActivity));
    }
}
