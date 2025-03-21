package p388ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class VerifyFaceActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private VerifyFaceActivity f23345a;

    /* renamed from: b */
    private View f23346b;

    /* renamed from: c */
    private View f23347c;

    /* renamed from: d */
    private View f23348d;

    /* renamed from: e */
    private View f23349e;

    /* renamed from: ui.activity.VerifyFaceActivity_ViewBinding$a */
    class C6649a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ VerifyFaceActivity f23350a;

        C6649a(VerifyFaceActivity verifyFaceActivity) {
            this.f23350a = verifyFaceActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23350a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.VerifyFaceActivity_ViewBinding$b */
    class C6650b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ VerifyFaceActivity f23352a;

        C6650b(VerifyFaceActivity verifyFaceActivity) {
            this.f23352a = verifyFaceActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23352a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.VerifyFaceActivity_ViewBinding$c */
    class C6651c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ VerifyFaceActivity f23354a;

        C6651c(VerifyFaceActivity verifyFaceActivity) {
            this.f23354a = verifyFaceActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23354a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.VerifyFaceActivity_ViewBinding$d */
    class C6652d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ VerifyFaceActivity f23356a;

        C6652d(VerifyFaceActivity verifyFaceActivity) {
            this.f23356a = verifyFaceActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23356a.onViewClicked(view);
        }
    }

    @UiThread
    public VerifyFaceActivity_ViewBinding(VerifyFaceActivity verifyFaceActivity) {
        this(verifyFaceActivity, verifyFaceActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        VerifyFaceActivity verifyFaceActivity = this.f23345a;
        if (verifyFaceActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23345a = null;
        verifyFaceActivity.mIvBack = null;
        verifyFaceActivity.mTvTitle = null;
        verifyFaceActivity.mTvRight = null;
        verifyFaceActivity.mTvCardType = null;
        verifyFaceActivity.mUserName = null;
        verifyFaceActivity.mUserID = null;
        verifyFaceActivity.mConfirm = null;
        this.f23346b.setOnClickListener(null);
        this.f23346b = null;
        this.f23347c.setOnClickListener(null);
        this.f23347c = null;
        this.f23348d.setOnClickListener(null);
        this.f23348d = null;
        this.f23349e.setOnClickListener(null);
        this.f23349e = null;
    }

    @UiThread
    public VerifyFaceActivity_ViewBinding(VerifyFaceActivity verifyFaceActivity, View view) {
        this.f23345a = verifyFaceActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        verifyFaceActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f23346b = findRequiredView;
        findRequiredView.setOnClickListener(new C6649a(verifyFaceActivity));
        verifyFaceActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.tv_right, "field 'mTvRight' and method 'onViewClicked'");
        verifyFaceActivity.mTvRight = (TextView) Utils.castView(findRequiredView2, C2113R.id.tv_right, "field 'mTvRight'", TextView.class);
        this.f23347c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6650b(verifyFaceActivity));
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.tv_card_type, "field 'mTvCardType' and method 'onViewClicked'");
        verifyFaceActivity.mTvCardType = (TextView) Utils.castView(findRequiredView3, C2113R.id.tv_card_type, "field 'mTvCardType'", TextView.class);
        this.f23348d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6651c(verifyFaceActivity));
        verifyFaceActivity.mUserName = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.user_name, "field 'mUserName'", EditText.class);
        verifyFaceActivity.mUserID = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.user_ID, "field 'mUserID'", EditText.class);
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.confirm, "field 'mConfirm' and method 'onViewClicked'");
        verifyFaceActivity.mConfirm = (TextView) Utils.castView(findRequiredView4, C2113R.id.confirm, "field 'mConfirm'", TextView.class);
        this.f23349e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6652d(verifyFaceActivity));
    }
}
