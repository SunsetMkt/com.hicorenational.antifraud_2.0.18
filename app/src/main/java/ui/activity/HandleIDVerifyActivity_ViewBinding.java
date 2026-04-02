package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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
public class HandleIDVerifyActivity_ViewBinding implements Unbinder {
    private HandleIDVerifyActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13409c;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ HandleIDVerifyActivity a;

        a(HandleIDVerifyActivity handleIDVerifyActivity) {
            this.a = handleIDVerifyActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ HandleIDVerifyActivity a;

        b(HandleIDVerifyActivity handleIDVerifyActivity) {
            this.a = handleIDVerifyActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public HandleIDVerifyActivity_ViewBinding(HandleIDVerifyActivity handleIDVerifyActivity) {
        this(handleIDVerifyActivity, handleIDVerifyActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        HandleIDVerifyActivity handleIDVerifyActivity = this.a;
        if (handleIDVerifyActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        handleIDVerifyActivity.mIvBack = null;
        handleIDVerifyActivity.mTvTitle = null;
        handleIDVerifyActivity.mTvRight = null;
        handleIDVerifyActivity.mEtName = null;
        handleIDVerifyActivity.mEtUserId = null;
        handleIDVerifyActivity.mConfirm = null;
        handleIDVerifyActivity.mTCbSelect = null;
        handleIDVerifyActivity.mTvSelectTips = null;
        this.f13408b.setOnClickListener(null);
        this.f13408b = null;
        this.f13409c.setOnClickListener(null);
        this.f13409c = null;
    }

    @UiThread
    public HandleIDVerifyActivity_ViewBinding(HandleIDVerifyActivity handleIDVerifyActivity, View view) {
        this.a = handleIDVerifyActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        handleIDVerifyActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13408b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(handleIDVerifyActivity));
        handleIDVerifyActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        handleIDVerifyActivity.mTvRight = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_right, "field 'mTvRight'", TextView.class);
        handleIDVerifyActivity.mEtName = (EditText) Utils.findRequiredViewAsType(view, R.id.user_name, "field 'mEtName'", EditText.class);
        handleIDVerifyActivity.mEtUserId = (EditText) Utils.findRequiredViewAsType(view, R.id.user_ID, "field 'mEtUserId'", EditText.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_idvrfy_start, "field 'mConfirm' and method 'onViewClicked'");
        handleIDVerifyActivity.mConfirm = (Button) Utils.castView(viewFindRequiredView2, R.id.btn_idvrfy_start, "field 'mConfirm'", Button.class);
        this.f13409c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(handleIDVerifyActivity));
        handleIDVerifyActivity.mTCbSelect = (CheckBox) Utils.findRequiredViewAsType(view, R.id.cb_select, "field 'mTCbSelect'", CheckBox.class);
        handleIDVerifyActivity.mTvSelectTips = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_select_tip, "field 'mTvSelectTips'", TextView.class);
    }
}
