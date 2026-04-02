package ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;
import ui.view.MyEdittext;

/* JADX INFO: loaded from: classes2.dex */
public class SmsAddActivity_ViewBinding implements Unbinder {
    private SmsAddActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13855d;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ SmsAddActivity a;

        a(SmsAddActivity smsAddActivity) {
            this.a = smsAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ SmsAddActivity a;

        b(SmsAddActivity smsAddActivity) {
            this.a = smsAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ SmsAddActivity a;

        c(SmsAddActivity smsAddActivity) {
            this.a = smsAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public SmsAddActivity_ViewBinding(SmsAddActivity smsAddActivity) {
        this(smsAddActivity, smsAddActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SmsAddActivity smsAddActivity = this.a;
        if (smsAddActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        smsAddActivity.mTvTitle = null;
        smsAddActivity.mBtnCommit = null;
        smsAddActivity.mEtPhone = null;
        smsAddActivity.mEtDescribe = null;
        smsAddActivity.mEtVictimPhone = null;
        smsAddActivity.mTvTime = null;
        this.f13853b.setOnClickListener(null);
        this.f13853b = null;
        this.f13854c.setOnClickListener(null);
        this.f13854c = null;
        this.f13855d.setOnClickListener(null);
        this.f13855d = null;
    }

    @UiThread
    public SmsAddActivity_ViewBinding(SmsAddActivity smsAddActivity, View view) {
        this.a = smsAddActivity;
        smsAddActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.confirm, "field 'mBtnCommit' and method 'onViewClicked'");
        smsAddActivity.mBtnCommit = (TextView) Utils.castView(viewFindRequiredView, R.id.confirm, "field 'mBtnCommit'", TextView.class);
        this.f13853b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(smsAddActivity));
        smsAddActivity.mEtPhone = (EditText) Utils.findRequiredViewAsType(view, R.id.et_phone, "field 'mEtPhone'", EditText.class);
        smsAddActivity.mEtDescribe = (MyEdittext) Utils.findRequiredViewAsType(view, R.id.et_describe, "field 'mEtDescribe'", MyEdittext.class);
        smsAddActivity.mEtVictimPhone = (EditText) Utils.findRequiredViewAsType(view, R.id.tv_victim_phone, "field 'mEtVictimPhone'", EditText.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_time, "field 'mTvTime' and method 'onViewClicked'");
        smsAddActivity.mTvTime = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_time, "field 'mTvTime'", TextView.class);
        this.f13854c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(smsAddActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13855d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(smsAddActivity));
    }
}
