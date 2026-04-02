package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class CallRecordActivity_ViewBinding implements Unbinder {
    private CallRecordActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13167c;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ CallRecordActivity a;

        a(CallRecordActivity callRecordActivity) {
            this.a = callRecordActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ CallRecordActivity a;

        b(CallRecordActivity callRecordActivity) {
            this.a = callRecordActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public CallRecordActivity_ViewBinding(CallRecordActivity callRecordActivity) {
        this(callRecordActivity, callRecordActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CallRecordActivity callRecordActivity = this.a;
        if (callRecordActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        callRecordActivity.mIvBack = null;
        callRecordActivity.mTvTitle = null;
        callRecordActivity.mRlTitle = null;
        callRecordActivity.mRecyclerview = null;
        callRecordActivity.mBtnReport = null;
        this.f13166b.setOnClickListener(null);
        this.f13166b = null;
        this.f13167c.setOnClickListener(null);
        this.f13167c = null;
    }

    @UiThread
    public CallRecordActivity_ViewBinding(CallRecordActivity callRecordActivity, View view) {
        this.a = callRecordActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        callRecordActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13166b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(callRecordActivity));
        callRecordActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        callRecordActivity.mRlTitle = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_title, "field 'mRlTitle'", RelativeLayout.class);
        callRecordActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_report, "field 'mBtnReport' and method 'onViewClicked'");
        callRecordActivity.mBtnReport = (Button) Utils.castView(viewFindRequiredView2, R.id.btn_report, "field 'mBtnReport'", Button.class);
        this.f13167c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(callRecordActivity));
    }
}
