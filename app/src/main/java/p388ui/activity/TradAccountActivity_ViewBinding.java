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
public class TradAccountActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private TradAccountActivity f23283a;

    /* renamed from: b */
    private View f23284b;

    /* renamed from: c */
    private View f23285c;

    /* renamed from: d */
    private View f23286d;

    /* renamed from: ui.activity.TradAccountActivity_ViewBinding$a */
    class C6626a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ TradAccountActivity f23287a;

        C6626a(TradAccountActivity tradAccountActivity) {
            this.f23287a = tradAccountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23287a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.TradAccountActivity_ViewBinding$b */
    class C6627b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ TradAccountActivity f23289a;

        C6627b(TradAccountActivity tradAccountActivity) {
            this.f23289a = tradAccountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23289a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.TradAccountActivity_ViewBinding$c */
    class C6628c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ TradAccountActivity f23291a;

        C6628c(TradAccountActivity tradAccountActivity) {
            this.f23291a = tradAccountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23291a.onViewClicked(view);
        }
    }

    @UiThread
    public TradAccountActivity_ViewBinding(TradAccountActivity tradAccountActivity) {
        this(tradAccountActivity, tradAccountActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        TradAccountActivity tradAccountActivity = this.f23283a;
        if (tradAccountActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23283a = null;
        tradAccountActivity.mTvTitle = null;
        tradAccountActivity.mRecyclerview = null;
        tradAccountActivity.mTvSelectTip = null;
        tradAccountActivity.mTvCommit = null;
        tradAccountActivity.mBtnCommit = null;
        this.f23284b.setOnClickListener(null);
        this.f23284b = null;
        this.f23285c.setOnClickListener(null);
        this.f23285c = null;
        this.f23286d.setOnClickListener(null);
        this.f23286d = null;
    }

    @UiThread
    public TradAccountActivity_ViewBinding(TradAccountActivity tradAccountActivity, View view) {
        this.f23283a = tradAccountActivity;
        tradAccountActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        tradAccountActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        tradAccountActivity.mTvSelectTip = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_select_tip, "field 'mTvSelectTip'", TextView.class);
        tradAccountActivity.mTvCommit = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_commit_tip, "field 'mTvCommit'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        tradAccountActivity.mBtnCommit = (Button) Utils.castView(findRequiredView, C2113R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f23284b = findRequiredView;
        findRequiredView.setOnClickListener(new C6626a(tradAccountActivity));
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f23285c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6627b(tradAccountActivity));
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.ll_select, "method 'onViewClicked'");
        this.f23286d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6628c(tradAccountActivity));
    }
}
