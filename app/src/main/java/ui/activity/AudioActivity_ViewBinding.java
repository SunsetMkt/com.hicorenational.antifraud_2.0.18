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
public class AudioActivity_ViewBinding implements Unbinder {
    private AudioActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13115d;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ AudioActivity a;

        a(AudioActivity audioActivity) {
            this.a = audioActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ AudioActivity a;

        b(AudioActivity audioActivity) {
            this.a = audioActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ AudioActivity a;

        c(AudioActivity audioActivity) {
            this.a = audioActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public AudioActivity_ViewBinding(AudioActivity audioActivity) {
        this(audioActivity, audioActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AudioActivity audioActivity = this.a;
        if (audioActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        audioActivity.mTvTitle = null;
        audioActivity.mRecyclerview = null;
        audioActivity.mTvSelectTip = null;
        audioActivity.mTvCommitTip = null;
        audioActivity.mBtnCommit = null;
        this.f13113b.setOnClickListener(null);
        this.f13113b = null;
        this.f13114c.setOnClickListener(null);
        this.f13114c = null;
        this.f13115d.setOnClickListener(null);
        this.f13115d = null;
    }

    @UiThread
    public AudioActivity_ViewBinding(AudioActivity audioActivity, View view) {
        this.a = audioActivity;
        audioActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        audioActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        audioActivity.mTvSelectTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_select_tip, "field 'mTvSelectTip'", TextView.class);
        audioActivity.mTvCommitTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_commit_tip, "field 'mTvCommitTip'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        audioActivity.mBtnCommit = (Button) Utils.castView(viewFindRequiredView, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f13113b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(audioActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13114c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(audioActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_select, "method 'onViewClicked'");
        this.f13115d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(audioActivity));
    }
}
