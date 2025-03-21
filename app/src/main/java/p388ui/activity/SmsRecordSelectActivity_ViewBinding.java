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
public class SmsRecordSelectActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private SmsRecordSelectActivity f23219a;

    /* renamed from: b */
    private View f23220b;

    /* renamed from: c */
    private View f23221c;

    /* renamed from: ui.activity.SmsRecordSelectActivity_ViewBinding$a */
    class C6607a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SmsRecordSelectActivity f23222a;

        C6607a(SmsRecordSelectActivity smsRecordSelectActivity) {
            this.f23222a = smsRecordSelectActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23222a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.SmsRecordSelectActivity_ViewBinding$b */
    class C6608b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SmsRecordSelectActivity f23224a;

        C6608b(SmsRecordSelectActivity smsRecordSelectActivity) {
            this.f23224a = smsRecordSelectActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23224a.onViewClicked(view);
        }
    }

    @UiThread
    public SmsRecordSelectActivity_ViewBinding(SmsRecordSelectActivity smsRecordSelectActivity) {
        this(smsRecordSelectActivity, smsRecordSelectActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SmsRecordSelectActivity smsRecordSelectActivity = this.f23219a;
        if (smsRecordSelectActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23219a = null;
        smsRecordSelectActivity.mIvBack = null;
        smsRecordSelectActivity.mTvTitle = null;
        smsRecordSelectActivity.mRlTitle = null;
        smsRecordSelectActivity.mRecyclerview = null;
        smsRecordSelectActivity.mBtnReport = null;
        this.f23220b.setOnClickListener(null);
        this.f23220b = null;
        this.f23221c.setOnClickListener(null);
        this.f23221c = null;
    }

    @UiThread
    public SmsRecordSelectActivity_ViewBinding(SmsRecordSelectActivity smsRecordSelectActivity, View view) {
        this.f23219a = smsRecordSelectActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        smsRecordSelectActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f23220b = findRequiredView;
        findRequiredView.setOnClickListener(new C6607a(smsRecordSelectActivity));
        smsRecordSelectActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        smsRecordSelectActivity.mRlTitle = (RelativeLayout) Utils.findRequiredViewAsType(view, C2113R.id.rl_title, "field 'mRlTitle'", RelativeLayout.class);
        smsRecordSelectActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.btn_report, "field 'mBtnReport' and method 'onViewClicked'");
        smsRecordSelectActivity.mBtnReport = (Button) Utils.castView(findRequiredView2, C2113R.id.btn_report, "field 'mBtnReport'", Button.class);
        this.f23221c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6608b(smsRecordSelectActivity));
    }
}
