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
public class PictureActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private PictureActivity f22670a;

    /* renamed from: b */
    private View f22671b;

    /* renamed from: c */
    private View f22672c;

    /* renamed from: ui.activity.PictureActivity_ViewBinding$a */
    class C6427a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ PictureActivity f22673a;

        C6427a(PictureActivity pictureActivity) {
            this.f22673a = pictureActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22673a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.PictureActivity_ViewBinding$b */
    class C6428b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ PictureActivity f22675a;

        C6428b(PictureActivity pictureActivity) {
            this.f22675a = pictureActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22675a.onViewClicked(view);
        }
    }

    @UiThread
    public PictureActivity_ViewBinding(PictureActivity pictureActivity) {
        this(pictureActivity, pictureActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PictureActivity pictureActivity = this.f22670a;
        if (pictureActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22670a = null;
        pictureActivity.mTvTitle = null;
        pictureActivity.mRecyclerview = null;
        pictureActivity.mTvCommitTip = null;
        pictureActivity.mBtnCommit = null;
        this.f22671b.setOnClickListener(null);
        this.f22671b = null;
        this.f22672c.setOnClickListener(null);
        this.f22672c = null;
    }

    @UiThread
    public PictureActivity_ViewBinding(PictureActivity pictureActivity, View view) {
        this.f22670a = pictureActivity;
        pictureActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        pictureActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        pictureActivity.mTvCommitTip = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_commit_tip, "field 'mTvCommitTip'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        pictureActivity.mBtnCommit = (Button) Utils.castView(findRequiredView, C2113R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f22671b = findRequiredView;
        findRequiredView.setOnClickListener(new C6427a(pictureActivity));
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f22672c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6428b(pictureActivity));
    }
}
