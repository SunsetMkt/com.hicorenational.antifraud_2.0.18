package p388ui.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class AddSmsTwoFragment_ViewBinding implements Unbinder {

    /* renamed from: a */
    private AddSmsTwoFragment f23796a;

    /* renamed from: b */
    private View f23797b;

    /* renamed from: c */
    private View f23798c;

    /* renamed from: ui.fragment.AddSmsTwoFragment_ViewBinding$a */
    class C6853a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ AddSmsTwoFragment f23799a;

        C6853a(AddSmsTwoFragment addSmsTwoFragment) {
            this.f23799a = addSmsTwoFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23799a.onViewClicked(view);
        }
    }

    /* renamed from: ui.fragment.AddSmsTwoFragment_ViewBinding$b */
    class C6854b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ AddSmsTwoFragment f23801a;

        C6854b(AddSmsTwoFragment addSmsTwoFragment) {
            this.f23801a = addSmsTwoFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23801a.onViewClicked(view);
        }
    }

    @UiThread
    public AddSmsTwoFragment_ViewBinding(AddSmsTwoFragment addSmsTwoFragment, View view) {
        this.f23796a = addSmsTwoFragment;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.confirm, "field 'mBtnCommit' and method 'onViewClicked'");
        addSmsTwoFragment.mBtnCommit = (TextView) Utils.castView(findRequiredView, C2113R.id.confirm, "field 'mBtnCommit'", TextView.class);
        this.f23797b = findRequiredView;
        findRequiredView.setOnClickListener(new C6853a(addSmsTwoFragment));
        addSmsTwoFragment.mEtPhone = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_phone, "field 'mEtPhone'", EditText.class);
        addSmsTwoFragment.mEtDescribe = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_describe, "field 'mEtDescribe'", EditText.class);
        addSmsTwoFragment.mEtVictimPhone = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.tv_victim_phone, "field 'mEtVictimPhone'", EditText.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.tv_time, "field 'mTvTime' and method 'onViewClicked'");
        addSmsTwoFragment.mTvTime = (TextView) Utils.castView(findRequiredView2, C2113R.id.tv_time, "field 'mTvTime'", TextView.class);
        this.f23798c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6854b(addSmsTwoFragment));
        addSmsTwoFragment.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        addSmsTwoFragment.mTvTip = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_tip, "field 'mTvTip'", TextView.class);
        addSmsTwoFragment.mTvDescribeLabel = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_describe_label, "field 'mTvDescribeLabel'", TextView.class);
        addSmsTwoFragment.mLlPicture = (LinearLayout) Utils.findRequiredViewAsType(view, C2113R.id.ll_picture, "field 'mLlPicture'", LinearLayout.class);
        addSmsTwoFragment.mTvTipPicture = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_tip_picture, "field 'mTvTipPicture'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AddSmsTwoFragment addSmsTwoFragment = this.f23796a;
        if (addSmsTwoFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23796a = null;
        addSmsTwoFragment.mBtnCommit = null;
        addSmsTwoFragment.mEtPhone = null;
        addSmsTwoFragment.mEtDescribe = null;
        addSmsTwoFragment.mEtVictimPhone = null;
        addSmsTwoFragment.mTvTime = null;
        addSmsTwoFragment.mRecyclerview = null;
        addSmsTwoFragment.mTvTip = null;
        addSmsTwoFragment.mTvDescribeLabel = null;
        addSmsTwoFragment.mLlPicture = null;
        addSmsTwoFragment.mTvTipPicture = null;
        this.f23797b.setOnClickListener(null);
        this.f23797b = null;
        this.f23798c.setOnClickListener(null);
        this.f23798c = null;
    }
}
