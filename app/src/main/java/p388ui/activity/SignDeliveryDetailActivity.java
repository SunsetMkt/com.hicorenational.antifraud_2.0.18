package p388ui.activity;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import bean.DeliveryBean;
import bean.UploadFileBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import java.util.ArrayList;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p388ui.Hicore;
import p388ui.presenter.DeliveryPresenter;
import p388ui.presenter.GridViewPicPresenter;
import util.C7292k1;

/* compiled from: SignDeliveryDetailActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010U\u001a\u00020VH\u0016J\u0006\u0010W\u001a\u00020VJ\u0010\u0010X\u001a\u00020V2\u0006\u0010Y\u001a\u00020(H\u0007J\b\u0010Z\u001a\u00020.H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001e\u0010\u0018\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001e\u0010\u001b\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001e\u0010\u001e\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001e\u0010!\u001a\u00020\"8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010'\u001a\u00020(8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020.X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u00107\u001a\u0002088\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001e\u0010=\u001a\u00020>8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001e\u0010C\u001a\u00020>8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010@\"\u0004\bE\u0010BR\u001e\u0010F\u001a\u00020>8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010@\"\u0004\bH\u0010BR\u001c\u0010I\u001a\u0004\u0018\u00010JX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001e\u0010O\u001a\u00020P8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010T¨\u0006["}, m23546d2 = {"Lui/activity/SignDeliveryDetailActivity;", "Lui/activity/BaseActivity;", "()V", "mBtnConfirm", "Landroid/widget/Button;", "getMBtnConfirm", "()Landroid/widget/Button;", "setMBtnConfirm", "(Landroid/widget/Button;)V", "mDeliveryBean", "Lbean/DeliveryBean;", "getMDeliveryBean", "()Lbean/DeliveryBean;", "setMDeliveryBean", "(Lbean/DeliveryBean;)V", "mEtDeliveryAddress", "Landroid/widget/EditText;", "getMEtDeliveryAddress", "()Landroid/widget/EditText;", "setMEtDeliveryAddress", "(Landroid/widget/EditText;)V", "mEtDeliveryName", "getMEtDeliveryName", "setMEtDeliveryName", "mEtDeliveryNum", "getMEtDeliveryNum", "setMEtDeliveryNum", "mEtDeliveryPhone", "getMEtDeliveryPhone", "setMEtDeliveryPhone", "mEtDeliveryWp", "getMEtDeliveryWp", "setMEtDeliveryWp", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mLlWlPic", "Landroid/view/View;", "getMLlWlPic", "()Landroid/view/View;", "setMLlWlPic", "(Landroid/view/View;)V", "mMaxSelectNum", "", "getMMaxSelectNum", "()I", "mPresenter", "Lui/presenter/DeliveryPresenter;", "getMPresenter", "()Lui/presenter/DeliveryPresenter;", "setMPresenter", "(Lui/presenter/DeliveryPresenter;)V", "mRecyView", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecyView", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecyView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mTvDeliveryPlat", "Landroid/widget/TextView;", "getMTvDeliveryPlat", "()Landroid/widget/TextView;", "setMTvDeliveryPlat", "(Landroid/widget/TextView;)V", "mTvDeliveryTime", "getMTvDeliveryTime", "setMTvDeliveryTime", "mTvTitle", "getMTvTitle", "setMTvTitle", "picPresenter", "Lui/presenter/GridViewPicPresenter;", "getPicPresenter", "()Lui/presenter/GridViewPicPresenter;", "setPicPresenter", "(Lui/presenter/GridViewPicPresenter;)V", "scrollView", "Landroidx/core/widget/NestedScrollView;", "getScrollView", "()Landroidx/core/widget/NestedScrollView;", "setScrollView", "(Landroidx/core/widget/NestedScrollView;)V", "initPage", "", "initView", "onViewClicked", "view", "setLayoutView", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class SignDeliveryDetailActivity extends BaseActivity {

    /* renamed from: a */
    @InterfaceC5817e
    private DeliveryPresenter f23131a;

    /* renamed from: b */
    @InterfaceC5817e
    private GridViewPicPresenter f23132b;

    /* renamed from: c */
    private final int f23133c = 6;

    /* renamed from: d */
    @InterfaceC5817e
    private DeliveryBean f23134d;

    @BindView(C2113R.id.btn_confirm)
    @InterfaceC5816d
    public Button mBtnConfirm;

    @BindView(C2113R.id.et_delivery_address)
    @InterfaceC5816d
    public EditText mEtDeliveryAddress;

    @BindView(C2113R.id.et_delivery_sender)
    @InterfaceC5816d
    public EditText mEtDeliveryName;

    @BindView(C2113R.id.et_delivery_num)
    @InterfaceC5816d
    public EditText mEtDeliveryNum;

    @BindView(C2113R.id.et_delivery_phone)
    @InterfaceC5816d
    public EditText mEtDeliveryPhone;

    @BindView(C2113R.id.et_delivery_wp)
    @InterfaceC5816d
    public EditText mEtDeliveryWp;

    @BindView(C2113R.id.iv_back)
    @InterfaceC5816d
    public ImageView mIvBack;

    @BindView(C2113R.id.ll_wu_pic)
    @InterfaceC5816d
    public View mLlWlPic;

    @BindView(C2113R.id.recyclerview)
    @InterfaceC5816d
    public RecyclerView mRecyView;

    @BindView(C2113R.id.tv_delivery_plat)
    @InterfaceC5816d
    public TextView mTvDeliveryPlat;

    @BindView(C2113R.id.tv_delivery_time)
    @InterfaceC5816d
    public TextView mTvDeliveryTime;

    @BindView(C2113R.id.tv_title)
    @InterfaceC5816d
    public TextView mTvTitle;

    @BindView(C2113R.id.ns_layout)
    @InterfaceC5816d
    public NestedScrollView scrollView;

    @InterfaceC5816d
    /* renamed from: a */
    public final View m25354a() {
        View view = this.mLlWlPic;
        if (view == null) {
            C5544i0.m22554k("mLlWlPic");
        }
        return view;
    }

    @InterfaceC5817e
    /* renamed from: b */
    public final GridViewPicPresenter m25356b() {
        return this.f23132b;
    }

    @InterfaceC5816d
    public final Button getMBtnConfirm() {
        Button button = this.mBtnConfirm;
        if (button == null) {
            C5544i0.m22554k("mBtnConfirm");
        }
        return button;
    }

    @InterfaceC5817e
    public final DeliveryBean getMDeliveryBean() {
        return this.f23134d;
    }

    @InterfaceC5816d
    public final EditText getMEtDeliveryAddress() {
        EditText editText = this.mEtDeliveryAddress;
        if (editText == null) {
            C5544i0.m22554k("mEtDeliveryAddress");
        }
        return editText;
    }

    @InterfaceC5816d
    public final EditText getMEtDeliveryName() {
        EditText editText = this.mEtDeliveryName;
        if (editText == null) {
            C5544i0.m22554k("mEtDeliveryName");
        }
        return editText;
    }

    @InterfaceC5816d
    public final EditText getMEtDeliveryNum() {
        EditText editText = this.mEtDeliveryNum;
        if (editText == null) {
            C5544i0.m22554k("mEtDeliveryNum");
        }
        return editText;
    }

    @InterfaceC5816d
    public final EditText getMEtDeliveryPhone() {
        EditText editText = this.mEtDeliveryPhone;
        if (editText == null) {
            C5544i0.m22554k("mEtDeliveryPhone");
        }
        return editText;
    }

    @InterfaceC5816d
    public final EditText getMEtDeliveryWp() {
        EditText editText = this.mEtDeliveryWp;
        if (editText == null) {
            C5544i0.m22554k("mEtDeliveryWp");
        }
        return editText;
    }

    @InterfaceC5816d
    public final ImageView getMIvBack() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            C5544i0.m22554k("mIvBack");
        }
        return imageView;
    }

    public final int getMMaxSelectNum() {
        return this.f23133c;
    }

    @InterfaceC5817e
    public final DeliveryPresenter getMPresenter() {
        return this.f23131a;
    }

    @InterfaceC5816d
    public final RecyclerView getMRecyView() {
        RecyclerView recyclerView = this.mRecyView;
        if (recyclerView == null) {
            C5544i0.m22554k("mRecyView");
        }
        return recyclerView;
    }

    @InterfaceC5816d
    public final TextView getMTvDeliveryPlat() {
        TextView textView = this.mTvDeliveryPlat;
        if (textView == null) {
            C5544i0.m22554k("mTvDeliveryPlat");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvDeliveryTime() {
        TextView textView = this.mTvDeliveryTime;
        if (textView == null) {
            C5544i0.m22554k("mTvDeliveryTime");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        return textView;
    }

    @InterfaceC5816d
    public final NestedScrollView getScrollView() {
        NestedScrollView nestedScrollView = this.scrollView;
        if (nestedScrollView == null) {
            C5544i0.m22554k("scrollView");
        }
        return nestedScrollView;
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        if (textView == null) {
            C5544i0.m22545f();
        }
        textView.setText("寄件类嫌疑人电话详情");
        initView();
    }

    public final void initView() {
        this.f23134d = (DeliveryBean) getIntent().getSerializableExtra(C7292k1.f25391c);
        this.f23131a = new DeliveryPresenter(this.mActivity, null);
        this.f23132b = new GridViewPicPresenter(this.mActivity);
        GridViewPicPresenter gridViewPicPresenter = this.f23132b;
        if (gridViewPicPresenter != null) {
            RecyclerView recyclerView = this.mRecyView;
            if (recyclerView == null) {
                C5544i0.m22554k("mRecyView");
            }
            gridViewPicPresenter.initRecycleWeb(recyclerView);
        }
        if (this.f23134d != null) {
            EditText editText = this.mEtDeliveryNum;
            if (editText == null) {
                C5544i0.m22554k("mEtDeliveryNum");
            }
            DeliveryBean deliveryBean = this.f23134d;
            editText.setText(deliveryBean != null ? deliveryBean.getDeliveryNum() : null);
            TextView textView = this.mTvDeliveryPlat;
            if (textView == null) {
                C5544i0.m22554k("mTvDeliveryPlat");
            }
            DeliveryBean deliveryBean2 = this.f23134d;
            textView.setText(deliveryBean2 != null ? deliveryBean2.getDeliveryPlat() : null);
            EditText editText2 = this.mEtDeliveryName;
            if (editText2 == null) {
                C5544i0.m22554k("mEtDeliveryName");
            }
            DeliveryBean deliveryBean3 = this.f23134d;
            editText2.setText(deliveryBean3 != null ? deliveryBean3.getDeliveryName() : null);
            EditText editText3 = this.mEtDeliveryPhone;
            if (editText3 == null) {
                C5544i0.m22554k("mEtDeliveryPhone");
            }
            DeliveryBean deliveryBean4 = this.f23134d;
            editText3.setText(deliveryBean4 != null ? deliveryBean4.getDeliveryPhone() : null);
            EditText editText4 = this.mEtDeliveryAddress;
            if (editText4 == null) {
                C5544i0.m22554k("mEtDeliveryAddress");
            }
            DeliveryBean deliveryBean5 = this.f23134d;
            editText4.setText(deliveryBean5 != null ? deliveryBean5.getDeliveryAddress() : null);
            TextView textView2 = this.mTvDeliveryTime;
            if (textView2 == null) {
                C5544i0.m22554k("mTvDeliveryTime");
            }
            DeliveryBean deliveryBean6 = this.f23134d;
            textView2.setText(deliveryBean6 != null ? deliveryBean6.getDeliveryTime() : null);
            EditText editText5 = this.mEtDeliveryWp;
            if (editText5 == null) {
                C5544i0.m22554k("mEtDeliveryWp");
            }
            DeliveryBean deliveryBean7 = this.f23134d;
            editText5.setText(deliveryBean7 != null ? deliveryBean7.getDeliveryWp() : null);
            Button button = this.mBtnConfirm;
            if (button == null) {
                C5544i0.m22554k("mBtnConfirm");
            }
            button.setVisibility(8);
            EditText editText6 = this.mEtDeliveryNum;
            if (editText6 == null) {
                C5544i0.m22554k("mEtDeliveryNum");
            }
            editText6.setEnabled(false);
            TextView textView3 = this.mTvDeliveryPlat;
            if (textView3 == null) {
                C5544i0.m22554k("mTvDeliveryPlat");
            }
            textView3.setEnabled(false);
            EditText editText7 = this.mEtDeliveryName;
            if (editText7 == null) {
                C5544i0.m22554k("mEtDeliveryName");
            }
            editText7.setEnabled(false);
            EditText editText8 = this.mEtDeliveryPhone;
            if (editText8 == null) {
                C5544i0.m22554k("mEtDeliveryPhone");
            }
            editText8.setEnabled(false);
            EditText editText9 = this.mEtDeliveryAddress;
            if (editText9 == null) {
                C5544i0.m22554k("mEtDeliveryAddress");
            }
            editText9.setEnabled(false);
            TextView textView4 = this.mTvDeliveryTime;
            if (textView4 == null) {
                C5544i0.m22554k("mTvDeliveryTime");
            }
            textView4.setEnabled(false);
            EditText editText10 = this.mEtDeliveryWp;
            if (editText10 == null) {
                C5544i0.m22554k("mEtDeliveryWp");
            }
            editText10.setEnabled(false);
            TextView textView5 = this.mTvDeliveryPlat;
            if (textView5 == null) {
                C5544i0.m22554k("mTvDeliveryPlat");
            }
            if (textView5 == null) {
                C5544i0.m22545f();
            }
            textView5.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            TextView textView6 = this.mTvDeliveryTime;
            if (textView6 == null) {
                C5544i0.m22554k("mTvDeliveryTime");
            }
            if (textView6 == null) {
                C5544i0.m22545f();
            }
            textView6.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            DeliveryBean deliveryBean8 = this.f23134d;
            ArrayList<UploadFileBean> mailingTelDetails = deliveryBean8 != null ? deliveryBean8.getMailingTelDetails() : null;
            if (mailingTelDetails == null || mailingTelDetails.size() <= 0) {
                View view = this.mLlWlPic;
                if (view == null) {
                    C5544i0.m22554k("mLlWlPic");
                }
                view.setVisibility(8);
                return;
            }
            GridViewPicPresenter gridViewPicPresenter2 = this.f23132b;
            if (gridViewPicPresenter2 != null) {
                gridViewPicPresenter2.setListData(mailingTelDetails);
            }
        }
    }

    @OnClick({C2113R.id.iv_back})
    public final void onViewClicked(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        Hicore app = Hicore.getApp();
        C5544i0.m22521a((Object) app, "Hicore.getApp()");
        if (!app.isDouble() && view.getId() == C2113R.id.iv_back) {
            finish();
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_delivery_add;
    }

    public final void setMBtnConfirm(@InterfaceC5816d Button button) {
        C5544i0.m22546f(button, "<set-?>");
        this.mBtnConfirm = button;
    }

    public final void setMDeliveryBean(@InterfaceC5817e DeliveryBean deliveryBean) {
        this.f23134d = deliveryBean;
    }

    public final void setMEtDeliveryAddress(@InterfaceC5816d EditText editText) {
        C5544i0.m22546f(editText, "<set-?>");
        this.mEtDeliveryAddress = editText;
    }

    public final void setMEtDeliveryName(@InterfaceC5816d EditText editText) {
        C5544i0.m22546f(editText, "<set-?>");
        this.mEtDeliveryName = editText;
    }

    public final void setMEtDeliveryNum(@InterfaceC5816d EditText editText) {
        C5544i0.m22546f(editText, "<set-?>");
        this.mEtDeliveryNum = editText;
    }

    public final void setMEtDeliveryPhone(@InterfaceC5816d EditText editText) {
        C5544i0.m22546f(editText, "<set-?>");
        this.mEtDeliveryPhone = editText;
    }

    public final void setMEtDeliveryWp(@InterfaceC5816d EditText editText) {
        C5544i0.m22546f(editText, "<set-?>");
        this.mEtDeliveryWp = editText;
    }

    public final void setMIvBack(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMLlWlPic(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mLlWlPic = view;
    }

    public final void setMPresenter(@InterfaceC5817e DeliveryPresenter deliveryPresenter) {
        this.f23131a = deliveryPresenter;
    }

    public final void setMRecyView(@InterfaceC5816d RecyclerView recyclerView) {
        C5544i0.m22546f(recyclerView, "<set-?>");
        this.mRecyView = recyclerView;
    }

    public final void setMTvDeliveryPlat(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvDeliveryPlat = textView;
    }

    public final void setMTvDeliveryTime(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvDeliveryTime = textView;
    }

    public final void setMTvTitle(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    public final void setScrollView(@InterfaceC5816d NestedScrollView nestedScrollView) {
        C5544i0.m22546f(nestedScrollView, "<set-?>");
        this.scrollView = nestedScrollView;
    }

    /* renamed from: a */
    public final void m25355a(@InterfaceC5817e GridViewPicPresenter gridViewPicPresenter) {
        this.f23132b = gridViewPicPresenter;
    }
}
