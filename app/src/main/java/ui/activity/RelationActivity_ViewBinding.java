package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public final class RelationActivity_ViewBinding implements Unbinder {
    private RelationActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13644d;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ RelationActivity a;

        a(RelationActivity relationActivity) {
            this.a = relationActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ RelationActivity a;

        b(RelationActivity relationActivity) {
            this.a = relationActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ RelationActivity a;

        c(RelationActivity relationActivity) {
            this.a = relationActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public RelationActivity_ViewBinding(RelationActivity relationActivity) {
        this(relationActivity, relationActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        RelationActivity relationActivity = this.a;
        if (relationActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        relationActivity.mTvTitle = null;
        relationActivity.mRecyclerview = null;
        relationActivity.mTvSelectTip = null;
        relationActivity.mTvCommit = null;
        relationActivity.mBtnCommit = null;
        this.f13642b.setOnClickListener(null);
        this.f13642b = null;
        this.f13643c.setOnClickListener(null);
        this.f13643c = null;
        this.f13644d.setOnClickListener(null);
        this.f13644d = null;
    }

    @UiThread
    public RelationActivity_ViewBinding(RelationActivity relationActivity, View view) {
        this.a = relationActivity;
        relationActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        relationActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        relationActivity.mTvSelectTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_add, "field 'mTvSelectTip'", TextView.class);
        relationActivity.mTvCommit = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_commit_tip, "field 'mTvCommit'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        relationActivity.mBtnCommit = (Button) Utils.castView(viewFindRequiredView, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f13642b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(relationActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13643c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(relationActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_add, "method 'onViewClicked'");
        this.f13644d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(relationActivity));
    }
}
