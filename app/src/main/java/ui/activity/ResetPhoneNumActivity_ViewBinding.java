package ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class ResetPhoneNumActivity_ViewBinding implements Unbinder {
    private ResetPhoneNumActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13756c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13757d;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ ResetPhoneNumActivity a;

        a(ResetPhoneNumActivity resetPhoneNumActivity) {
            this.a = resetPhoneNumActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ ResetPhoneNumActivity a;

        b(ResetPhoneNumActivity resetPhoneNumActivity) {
            this.a = resetPhoneNumActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ ResetPhoneNumActivity a;

        c(ResetPhoneNumActivity resetPhoneNumActivity) {
            this.a = resetPhoneNumActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public ResetPhoneNumActivity_ViewBinding(ResetPhoneNumActivity resetPhoneNumActivity) {
        this(resetPhoneNumActivity, resetPhoneNumActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ResetPhoneNumActivity resetPhoneNumActivity = this.a;
        if (resetPhoneNumActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        resetPhoneNumActivity.mTvTitle = null;
        resetPhoneNumActivity.mPhoneCode = null;
        resetPhoneNumActivity.mConfim = null;
        resetPhoneNumActivity.mPhoneLable = null;
        resetPhoneNumActivity.mTvBomTips = null;
        resetPhoneNumActivity.mIvClean = null;
        this.f13755b.setOnClickListener(null);
        this.f13755b = null;
        this.f13756c.setOnClickListener(null);
        this.f13756c = null;
        this.f13757d.setOnClickListener(null);
        this.f13757d = null;
    }

    @UiThread
    public ResetPhoneNumActivity_ViewBinding(ResetPhoneNumActivity resetPhoneNumActivity, View view) {
        this.a = resetPhoneNumActivity;
        resetPhoneNumActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        resetPhoneNumActivity.mPhoneCode = (EditText) Utils.findRequiredViewAsType(view, R.id.phone_code, "field 'mPhoneCode'", EditText.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.confirm, "field 'mConfim' and method 'onViewClicked'");
        resetPhoneNumActivity.mConfim = (TextView) Utils.castView(viewFindRequiredView, R.id.confirm, "field 'mConfim'", TextView.class);
        this.f13755b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(resetPhoneNumActivity));
        resetPhoneNumActivity.mPhoneLable = (TextView) Utils.findRequiredViewAsType(view, R.id.phone_label, "field 'mPhoneLable'", TextView.class);
        resetPhoneNumActivity.mTvBomTips = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_bom_tips, "field 'mTvBomTips'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_clear, "field 'mIvClean' and method 'onViewClicked'");
        resetPhoneNumActivity.mIvClean = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_clear, "field 'mIvClean'", ImageView.class);
        this.f13756c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(resetPhoneNumActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13757d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(resetPhoneNumActivity));
    }
}
