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
public class PictureActivity_ViewBinding implements Unbinder {
    private PictureActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13561c;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ PictureActivity a;

        a(PictureActivity pictureActivity) {
            this.a = pictureActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ PictureActivity a;

        b(PictureActivity pictureActivity) {
            this.a = pictureActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public PictureActivity_ViewBinding(PictureActivity pictureActivity) {
        this(pictureActivity, pictureActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PictureActivity pictureActivity = this.a;
        if (pictureActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        pictureActivity.mTvTitle = null;
        pictureActivity.mRecyclerview = null;
        pictureActivity.mTvCommitTip = null;
        pictureActivity.mBtnCommit = null;
        this.f13560b.setOnClickListener(null);
        this.f13560b = null;
        this.f13561c.setOnClickListener(null);
        this.f13561c = null;
    }

    @UiThread
    public PictureActivity_ViewBinding(PictureActivity pictureActivity, View view) {
        this.a = pictureActivity;
        pictureActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        pictureActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        pictureActivity.mTvCommitTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_commit_tip, "field 'mTvCommitTip'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        pictureActivity.mBtnCommit = (Button) Utils.castView(viewFindRequiredView, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f13560b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(pictureActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13561c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(pictureActivity));
    }
}
