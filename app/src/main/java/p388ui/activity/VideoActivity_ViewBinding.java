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
public class VideoActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private VideoActivity f23384a;

    /* renamed from: b */
    private View f23385b;

    /* renamed from: c */
    private View f23386c;

    /* renamed from: ui.activity.VideoActivity_ViewBinding$a */
    class C6662a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ VideoActivity f23387a;

        C6662a(VideoActivity videoActivity) {
            this.f23387a = videoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23387a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.VideoActivity_ViewBinding$b */
    class C6663b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ VideoActivity f23389a;

        C6663b(VideoActivity videoActivity) {
            this.f23389a = videoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23389a.onViewClicked(view);
        }
    }

    @UiThread
    public VideoActivity_ViewBinding(VideoActivity videoActivity) {
        this(videoActivity, videoActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        VideoActivity videoActivity = this.f23384a;
        if (videoActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23384a = null;
        videoActivity.mTvTitle = null;
        videoActivity.mRecyclerview = null;
        videoActivity.mTvCommitTip = null;
        videoActivity.mBtnCommit = null;
        this.f23385b.setOnClickListener(null);
        this.f23385b = null;
        this.f23386c.setOnClickListener(null);
        this.f23386c = null;
    }

    @UiThread
    public VideoActivity_ViewBinding(VideoActivity videoActivity, View view) {
        this.f23384a = videoActivity;
        videoActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        videoActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        videoActivity.mTvCommitTip = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_commit_tip, "field 'mTvCommitTip'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        videoActivity.mBtnCommit = (Button) Utils.castView(findRequiredView, C2113R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f23385b = findRequiredView;
        findRequiredView.setOnClickListener(new C6662a(videoActivity));
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f23386c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6663b(videoActivity));
    }
}
