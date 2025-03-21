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
public class AudioActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private AudioActivity f21854a;

    /* renamed from: b */
    private View f21855b;

    /* renamed from: c */
    private View f21856c;

    /* renamed from: d */
    private View f21857d;

    /* renamed from: ui.activity.AudioActivity_ViewBinding$a */
    class C6134a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ AudioActivity f21858a;

        C6134a(AudioActivity audioActivity) {
            this.f21858a = audioActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21858a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.AudioActivity_ViewBinding$b */
    class C6135b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ AudioActivity f21860a;

        C6135b(AudioActivity audioActivity) {
            this.f21860a = audioActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21860a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.AudioActivity_ViewBinding$c */
    class C6136c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ AudioActivity f21862a;

        C6136c(AudioActivity audioActivity) {
            this.f21862a = audioActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21862a.onViewClicked(view);
        }
    }

    @UiThread
    public AudioActivity_ViewBinding(AudioActivity audioActivity) {
        this(audioActivity, audioActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AudioActivity audioActivity = this.f21854a;
        if (audioActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f21854a = null;
        audioActivity.mTvTitle = null;
        audioActivity.mRecyclerview = null;
        audioActivity.mTvSelectTip = null;
        audioActivity.mTvCommitTip = null;
        audioActivity.mBtnCommit = null;
        this.f21855b.setOnClickListener(null);
        this.f21855b = null;
        this.f21856c.setOnClickListener(null);
        this.f21856c = null;
        this.f21857d.setOnClickListener(null);
        this.f21857d = null;
    }

    @UiThread
    public AudioActivity_ViewBinding(AudioActivity audioActivity, View view) {
        this.f21854a = audioActivity;
        audioActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        audioActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        audioActivity.mTvSelectTip = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_select_tip, "field 'mTvSelectTip'", TextView.class);
        audioActivity.mTvCommitTip = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_commit_tip, "field 'mTvCommitTip'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        audioActivity.mBtnCommit = (Button) Utils.castView(findRequiredView, C2113R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f21855b = findRequiredView;
        findRequiredView.setOnClickListener(new C6134a(audioActivity));
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f21856c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6135b(audioActivity));
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.ll_select, "method 'onViewClicked'");
        this.f21857d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6136c(audioActivity));
    }
}
