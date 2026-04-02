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
public class SmsRecordSelectActivity_ViewBinding implements Unbinder {
    private SmsRecordSelectActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13873c;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ SmsRecordSelectActivity a;

        a(SmsRecordSelectActivity smsRecordSelectActivity) {
            this.a = smsRecordSelectActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ SmsRecordSelectActivity a;

        b(SmsRecordSelectActivity smsRecordSelectActivity) {
            this.a = smsRecordSelectActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public SmsRecordSelectActivity_ViewBinding(SmsRecordSelectActivity smsRecordSelectActivity) {
        this(smsRecordSelectActivity, smsRecordSelectActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SmsRecordSelectActivity smsRecordSelectActivity = this.a;
        if (smsRecordSelectActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        smsRecordSelectActivity.mIvBack = null;
        smsRecordSelectActivity.mTvTitle = null;
        smsRecordSelectActivity.mRlTitle = null;
        smsRecordSelectActivity.mRecyclerview = null;
        smsRecordSelectActivity.mBtnReport = null;
        this.f13872b.setOnClickListener(null);
        this.f13872b = null;
        this.f13873c.setOnClickListener(null);
        this.f13873c = null;
    }

    @UiThread
    public SmsRecordSelectActivity_ViewBinding(SmsRecordSelectActivity smsRecordSelectActivity, View view) {
        this.a = smsRecordSelectActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        smsRecordSelectActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13872b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(smsRecordSelectActivity));
        smsRecordSelectActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        smsRecordSelectActivity.mRlTitle = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_title, "field 'mRlTitle'", RelativeLayout.class);
        smsRecordSelectActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_report, "field 'mBtnReport' and method 'onViewClicked'");
        smsRecordSelectActivity.mBtnReport = (Button) Utils.castView(viewFindRequiredView2, R.id.btn_report, "field 'mBtnReport'", Button.class);
        this.f13873c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(smsRecordSelectActivity));
    }
}
