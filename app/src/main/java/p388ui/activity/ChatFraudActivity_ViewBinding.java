package p388ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class ChatFraudActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private ChatFraudActivity f22084a;

    /* renamed from: b */
    private View f22085b;

    /* renamed from: c */
    private View f22086c;

    /* renamed from: d */
    private View f22087d;

    /* renamed from: e */
    private View f22088e;

    /* renamed from: ui.activity.ChatFraudActivity_ViewBinding$a */
    class C6215a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ChatFraudActivity f22089a;

        C6215a(ChatFraudActivity chatFraudActivity) {
            this.f22089a = chatFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22089a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.ChatFraudActivity_ViewBinding$b */
    class C6216b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ChatFraudActivity f22091a;

        C6216b(ChatFraudActivity chatFraudActivity) {
            this.f22091a = chatFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22091a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.ChatFraudActivity_ViewBinding$c */
    class C6217c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ChatFraudActivity f22093a;

        C6217c(ChatFraudActivity chatFraudActivity) {
            this.f22093a = chatFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22093a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.ChatFraudActivity_ViewBinding$d */
    class C6218d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ChatFraudActivity f22095a;

        C6218d(ChatFraudActivity chatFraudActivity) {
            this.f22095a = chatFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22095a.onViewClicked(view);
        }
    }

    @UiThread
    public ChatFraudActivity_ViewBinding(ChatFraudActivity chatFraudActivity) {
        this(chatFraudActivity, chatFraudActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ChatFraudActivity chatFraudActivity = this.f22084a;
        if (chatFraudActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22084a = null;
        chatFraudActivity.mTvTitle = null;
        chatFraudActivity.mRgChat = null;
        chatFraudActivity.mRbWx = null;
        chatFraudActivity.mRbQQ = null;
        chatFraudActivity.mTvAccNum = null;
        chatFraudActivity.mRegion = null;
        chatFraudActivity.mTvDuperyType = null;
        chatFraudActivity.mEtCaseDescribe = null;
        this.f22085b.setOnClickListener(null);
        this.f22085b = null;
        this.f22086c.setOnClickListener(null);
        this.f22086c = null;
        this.f22087d.setOnClickListener(null);
        this.f22087d = null;
        this.f22088e.setOnClickListener(null);
        this.f22088e = null;
    }

    @UiThread
    public ChatFraudActivity_ViewBinding(ChatFraudActivity chatFraudActivity, View view) {
        this.f22084a = chatFraudActivity;
        chatFraudActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        chatFraudActivity.mRgChat = (RadioGroup) Utils.findRequiredViewAsType(view, C2113R.id.rg_chat, "field 'mRgChat'", RadioGroup.class);
        chatFraudActivity.mRbWx = (RadioButton) Utils.findRequiredViewAsType(view, C2113R.id.rb_wx, "field 'mRbWx'", RadioButton.class);
        chatFraudActivity.mRbQQ = (RadioButton) Utils.findRequiredViewAsType(view, C2113R.id.rb_qq, "field 'mRbQQ'", RadioButton.class);
        chatFraudActivity.mTvAccNum = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.trad_fraud_num, "field 'mTvAccNum'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.region, "field 'mRegion' and method 'onViewClicked'");
        chatFraudActivity.mRegion = (TextView) Utils.castView(findRequiredView, C2113R.id.region, "field 'mRegion'", TextView.class);
        this.f22085b = findRequiredView;
        findRequiredView.setOnClickListener(new C6215a(chatFraudActivity));
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.tv_dupery_type, "field 'mTvDuperyType' and method 'onViewClicked'");
        chatFraudActivity.mTvDuperyType = (TextView) Utils.castView(findRequiredView2, C2113R.id.tv_dupery_type, "field 'mTvDuperyType'", TextView.class);
        this.f22086c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6216b(chatFraudActivity));
        chatFraudActivity.mEtCaseDescribe = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_case_describe, "field 'mEtCaseDescribe'", EditText.class);
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f22087d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6217c(chatFraudActivity));
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.btn_commit, "method 'onViewClicked'");
        this.f22088e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6218d(chatFraudActivity));
    }
}
