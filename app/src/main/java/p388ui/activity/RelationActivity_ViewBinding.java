package p388ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public final class RelationActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private RelationActivity f22817a;

    /* renamed from: b */
    private View f22818b;

    /* renamed from: c */
    private View f22819c;

    /* renamed from: d */
    private View f22820d;

    /* renamed from: ui.activity.RelationActivity_ViewBinding$a */
    class C6478a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ RelationActivity f22821a;

        C6478a(RelationActivity relationActivity) {
            this.f22821a = relationActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22821a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.RelationActivity_ViewBinding$b */
    class C6479b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ RelationActivity f22823a;

        C6479b(RelationActivity relationActivity) {
            this.f22823a = relationActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22823a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.RelationActivity_ViewBinding$c */
    class C6480c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ RelationActivity f22825a;

        C6480c(RelationActivity relationActivity) {
            this.f22825a = relationActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22825a.onViewClicked(view);
        }
    }

    @UiThread
    public RelationActivity_ViewBinding(RelationActivity relationActivity) {
        this(relationActivity, relationActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        RelationActivity relationActivity = this.f22817a;
        if (relationActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22817a = null;
        relationActivity.mTvTitle = null;
        relationActivity.mRecyclerview = null;
        relationActivity.mTvSelectTip = null;
        relationActivity.mTvCommit = null;
        relationActivity.mBtnCommit = null;
        this.f22818b.setOnClickListener(null);
        this.f22818b = null;
        this.f22819c.setOnClickListener(null);
        this.f22819c = null;
        this.f22820d.setOnClickListener(null);
        this.f22820d = null;
    }

    @UiThread
    public RelationActivity_ViewBinding(RelationActivity relationActivity, View view) {
        this.f22817a = relationActivity;
        relationActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        relationActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        relationActivity.mTvSelectTip = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_add, "field 'mTvSelectTip'", TextView.class);
        relationActivity.mTvCommit = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_commit_tip, "field 'mTvCommit'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        relationActivity.mBtnCommit = (Button) Utils.castView(findRequiredView, C2113R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f22818b = findRequiredView;
        findRequiredView.setOnClickListener(new C6478a(relationActivity));
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f22819c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6479b(relationActivity));
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.ll_add, "method 'onViewClicked'");
        this.f22820d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6480c(relationActivity));
    }
}
