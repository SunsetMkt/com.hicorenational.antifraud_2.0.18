package p388ui.activity;

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
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class CallRecordActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private CallRecordActivity f21958a;

    /* renamed from: b */
    private View f21959b;

    /* renamed from: c */
    private View f21960c;

    /* renamed from: ui.activity.CallRecordActivity_ViewBinding$a */
    class C6174a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CallRecordActivity f21961a;

        C6174a(CallRecordActivity callRecordActivity) {
            this.f21961a = callRecordActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21961a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.CallRecordActivity_ViewBinding$b */
    class C6175b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CallRecordActivity f21963a;

        C6175b(CallRecordActivity callRecordActivity) {
            this.f21963a = callRecordActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21963a.onViewClicked(view);
        }
    }

    @UiThread
    public CallRecordActivity_ViewBinding(CallRecordActivity callRecordActivity) {
        this(callRecordActivity, callRecordActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CallRecordActivity callRecordActivity = this.f21958a;
        if (callRecordActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f21958a = null;
        callRecordActivity.mIvBack = null;
        callRecordActivity.mTvTitle = null;
        callRecordActivity.mRlTitle = null;
        callRecordActivity.mRecyclerview = null;
        callRecordActivity.mBtnReport = null;
        this.f21959b.setOnClickListener(null);
        this.f21959b = null;
        this.f21960c.setOnClickListener(null);
        this.f21960c = null;
    }

    @UiThread
    public CallRecordActivity_ViewBinding(CallRecordActivity callRecordActivity, View view) {
        this.f21958a = callRecordActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        callRecordActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f21959b = findRequiredView;
        findRequiredView.setOnClickListener(new C6174a(callRecordActivity));
        callRecordActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        callRecordActivity.mRlTitle = (RelativeLayout) Utils.findRequiredViewAsType(view, C2113R.id.rl_title, "field 'mRlTitle'", RelativeLayout.class);
        callRecordActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.btn_report, "field 'mBtnReport' and method 'onViewClicked'");
        callRecordActivity.mBtnReport = (Button) Utils.castView(findRequiredView2, C2113R.id.btn_report, "field 'mBtnReport'", Button.class);
        this.f21960c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6175b(callRecordActivity));
    }
}
