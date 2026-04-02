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
public class VideoActivity_ViewBinding implements Unbinder {
    private VideoActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13971c;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ VideoActivity a;

        a(VideoActivity videoActivity) {
            this.a = videoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ VideoActivity a;

        b(VideoActivity videoActivity) {
            this.a = videoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public VideoActivity_ViewBinding(VideoActivity videoActivity) {
        this(videoActivity, videoActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        VideoActivity videoActivity = this.a;
        if (videoActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        videoActivity.mTvTitle = null;
        videoActivity.mRecyclerview = null;
        videoActivity.mTvCommitTip = null;
        videoActivity.mBtnCommit = null;
        this.f13970b.setOnClickListener(null);
        this.f13970b = null;
        this.f13971c.setOnClickListener(null);
        this.f13971c = null;
    }

    @UiThread
    public VideoActivity_ViewBinding(VideoActivity videoActivity, View view) {
        this.a = videoActivity;
        videoActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        videoActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        videoActivity.mTvCommitTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_commit_tip, "field 'mTvCommitTip'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        videoActivity.mBtnCommit = (Button) Utils.castView(viewFindRequiredView, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f13970b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(videoActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13971c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(videoActivity));
    }
}
