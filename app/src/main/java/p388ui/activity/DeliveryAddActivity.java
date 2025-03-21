package p388ui.activity;

import adapter.ReportPictureSelAdapter;
import android.content.Intent;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import bean.DeliveryBean;
import bean.DeliveryPlatBean;
import bean.UploadFileBean;
import bean.UploadStateInfo;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.C2113R;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.taobao.agoo.p201a.p202a.AbstractC3059b;
import com.umeng.analytics.pro.C3351bh;
import interfaces.IClickListener;
import interfaces.PermissionsListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import manager.AccountManager;
import p023b.p024a.p025a.p027e.C0918d;
import p023b.p024a.p025a.p027e.C0922h;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p357j.C5846e;
import p388ui.Hicore;
import p388ui.callview.DeliveryView;
import p388ui.presenter.DeliveryPresenter;
import util.C7257b1;
import util.C7292k1;
import util.C7331w1;
import util.C7337y1;
import util.permissionutil.C7308a;
import util.permissionutil.C7310c;

/* compiled from: DeliveryAddActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u001e\u0010x\u001a\u00020y2\u0006\u0010z\u001a\u00020\u00072\f\u0010{\u001a\b\u0012\u0004\u0012\u00020G0oH\u0002J\b\u0010|\u001a\u00020yH\u0002J\b\u0010}\u001a\u00020yH\u0016J>\u0010~\u001a\u00020\u00132\u0006\u0010r\u001a\u00020s2\u0006\u0010\u007f\u001a\u00020V2\u0016\u0010{\u001a\u0012\u0012\u0004\u0012\u00020G0Fj\b\u0012\u0004\u0012\u00020G`H2\u000e\u0010\u0080\u0001\u001a\t\u0012\u0005\u0012\u00030\u0081\u00010oJ\u0007\u0010\u0082\u0001\u001a\u00020yJ\t\u0010\u0083\u0001\u001a\u00020yH\u0016J&\u0010\u0084\u0001\u001a\u00020y2\u0006\u0010z\u001a\u00020\u00072\u0007\u0010\u0085\u0001\u001a\u00020\u00072\n\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u0001H\u0016J1\u0010\u0088\u0001\u001a\u00020y2\u0012\u0010\u0089\u0001\u001a\r\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u008a\u00012\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010@2\u0007\u0010\u008c\u0001\u001a\u00020\u0007H\u0016J/\u0010\u008d\u0001\u001a\u00020y2\u0007\u0010\u008c\u0001\u001a\u00020\u00072\u001b\u0010\u008e\u0001\u001a\u0016\u0012\u0004\u0012\u00020G\u0018\u00010Fj\n\u0012\u0004\u0012\u00020G\u0018\u0001`HH\u0016J\u001d\u0010\u008f\u0001\u001a\u00030\u0090\u00012\u0007\u0010\u0091\u0001\u001a\u00020\u00072\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u0016J\u0018\u0010\u0094\u0001\u001a\u00020y2\r\u0010\u0095\u0001\u001a\b\u0012\u0004\u0012\u00020p0oH\u0016J\u0012\u0010\u0096\u0001\u001a\u00020y2\u0007\u0010\u0097\u0001\u001a\u00020\u001fH\u0016J\u0012\u0010\u0098\u0001\u001a\u00020y2\u0007\u0010\u0099\u0001\u001a\u00020\rH\u0016J\u0012\u0010\u009a\u0001\u001a\u00020y2\u0007\u0010\u008b\u0001\u001a\u00020@H\u0007J\u0007\u0010\u009b\u0001\u001a\u00020yJ\t\u0010\u009c\u0001\u001a\u00020yH\u0014J\u0012\u0010\u009d\u0001\u001a\u00020y2\u0007\u0010\u009e\u0001\u001a\u00020\u0007H\u0002J\u0007\u0010\u009f\u0001\u001a\u00020yJ\u0012\u0010 \u0001\u001a\u00020y2\u0007\u0010¡\u0001\u001a\u00020\rH\u0002J\u0012\u0010¢\u0001\u001a\u00020y2\u0007\u0010\u008c\u0001\u001a\u00020\u0007H\u0016J\t\u0010£\u0001\u001a\u00020yH\u0002J\t\u0010¤\u0001\u001a\u00020\u0007H\u0016J\u0007\u0010¥\u0001\u001a\u00020yJ\u0014\u0010¦\u0001\u001a\u00020y2\t\u0010§\u0001\u001a\u0004\u0018\u00010\\H\u0002J&\u0010¨\u0001\u001a\u00020y2\u001d\u0010©\u0001\u001a\u0018\u0012\u0005\u0012\u00030ª\u0001\u0018\u00010Fj\u000b\u0012\u0005\u0012\u00030ª\u0001\u0018\u0001`HJ\u0007\u0010«\u0001\u001a\u00020yR\u0014\u0010\u0006\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010$\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010*\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\u001e\u0010-\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010'\"\u0004\b/\u0010)R\u001e\u00100\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010'\"\u0004\b2\u0010)R\u001e\u00103\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010'\"\u0004\b5\u0010)R\u001e\u00106\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010'\"\u0004\b8\u0010)R\u001e\u00109\u001a\u00020:8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001e\u0010?\u001a\u00020@8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR*\u0010E\u001a\u0012\u0012\u0004\u0012\u00020G0Fj\b\u0012\u0004\u0012\u00020G`HX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0014\u0010M\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bN\u0010\tR\u001c\u0010O\u001a\u0004\u0018\u00010PX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001e\u0010U\u001a\u00020V8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u001e\u0010[\u001a\u00020\\8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u001e\u0010a\u001a\u00020\\8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010^\"\u0004\bc\u0010`R\u001e\u0010d\u001a\u00020\\8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010^\"\u0004\bf\u0010`R\u001e\u0010g\u001a\u0012\u0012\u0004\u0012\u00020\r0Fj\b\u0012\u0004\u0012\u00020\r`HX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010h\u001a\u0004\u0018\u00010iX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u0016\u0010n\u001a\n\u0012\u0004\u0012\u00020p\u0018\u00010oX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010q\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010r\u001a\u00020s8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010u\"\u0004\bv\u0010w¨\u0006¬\u0001"}, m23546d2 = {"Lui/activity/DeliveryAddActivity;", "Lui/activity/BasePicUploadActivity;", "Lui/callview/DeliveryView;", "Ladapter/ReportPictureSelAdapter$OnItemClickListener;", "Lcom/chad/library/adapter/base/BaseQuickAdapter$OnItemChildClickListener;", "()V", "CODE_PREVIEW", "", "getCODE_PREVIEW", "()I", "REQUEST_CODE_RECORD", "getREQUEST_CODE_RECORD", "caseInfoId", "", "getCaseInfoId", "()Ljava/lang/String;", "setCaseInfoId", "(Ljava/lang/String;)V", "mAdapter", "Ladapter/ReportPictureSelAdapter;", "getMAdapter", "()Ladapter/ReportPictureSelAdapter;", "setMAdapter", "(Ladapter/ReportPictureSelAdapter;)V", "mBtnConfirm", "Landroid/widget/Button;", "getMBtnConfirm", "()Landroid/widget/Button;", "setMBtnConfirm", "(Landroid/widget/Button;)V", "mDeliveryBean", "Lbean/DeliveryBean;", "getMDeliveryBean", "()Lbean/DeliveryBean;", "setMDeliveryBean", "(Lbean/DeliveryBean;)V", "mEtDeliveryAddress", "Landroid/widget/EditText;", "getMEtDeliveryAddress", "()Landroid/widget/EditText;", "setMEtDeliveryAddress", "(Landroid/widget/EditText;)V", "mEtDeliveryName", "getMEtDeliveryName", "setMEtDeliveryName", "mEtDeliveryNum", "getMEtDeliveryNum", "setMEtDeliveryNum", "mEtDeliveryPhone", "getMEtDeliveryPhone", "setMEtDeliveryPhone", "mEtDeliveryWp", "getMEtDeliveryWp", "setMEtDeliveryWp", "mEtPlatName", "getMEtPlatName", "setMEtPlatName", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mLlDeliveryPlat", "Landroid/view/View;", "getMLlDeliveryPlat", "()Landroid/view/View;", "setMLlDeliveryPlat", "(Landroid/view/View;)V", "mLocalMedia", "Ljava/util/ArrayList;", "Lcom/luck/picture/lib/entity/LocalMedia;", "Lkotlin/collections/ArrayList;", "getMLocalMedia", "()Ljava/util/ArrayList;", "setMLocalMedia", "(Ljava/util/ArrayList;)V", "mMaxSelectNum", "getMMaxSelectNum", "mPresenter", "Lui/presenter/DeliveryPresenter;", "getMPresenter", "()Lui/presenter/DeliveryPresenter;", "setMPresenter", "(Lui/presenter/DeliveryPresenter;)V", "mRecyView", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecyView", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecyView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mTvDeliveryPlat", "Landroid/widget/TextView;", "getMTvDeliveryPlat", "()Landroid/widget/TextView;", "setMTvDeliveryPlat", "(Landroid/widget/TextView;)V", "mTvDeliveryTime", "getMTvDeliveryTime", "setMTvDeliveryTime", "mTvTitle", "getMTvTitle", "setMTvTitle", "pickTypes", "picker", "Lcn/qqtheme/framework/picker/OptionPicker;", "getPicker", "()Lcn/qqtheme/framework/picker/OptionPicker;", "setPicker", "(Lcn/qqtheme/framework/picker/OptionPicker;)V", "platList", "", "Lbean/DeliveryPlatBean;", "platformCode", "scrollView", "Landroidx/core/widget/NestedScrollView;", "getScrollView", "()Landroidx/core/widget/NestedScrollView;", "setScrollView", "(Landroidx/core/widget/NestedScrollView;)V", "checkPermission", "", "requestCode", "localMediaList", "editChangeListner", "initPage", "initRecycle", "recyclerView", "uploadStateInfoList", "Lbean/UploadStateInfo;", "initView", "notifyAdapter", "onActivityResult", AbstractC3059b.JSON_ERRORCODE, "data", "Landroid/content/Intent;", "onItemChildClick", "adapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "view", "position", "onItemClickListener", "myLiveList", "onKeyDown", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onSuccessPlatList", "list", "onSuccessSave", "bean", "onSuccessSaveFail", "msg", "onViewClicked", "onkeyback", "pageFileFinish", "platSelect", "index", "redisplayData", "regexPlat", "editStr", "removeLocalData", "saveHttpApi", "setLayoutView", "showPlatPiker", "showTimePiker", "timePk", "transLocalMedia", "picBeans", "Lbean/UploadFileBean;", "upLoadMedia", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class DeliveryAddActivity extends BasePicUploadActivity implements DeliveryView, ReportPictureSelAdapter.InterfaceC0069a, BaseQuickAdapter.InterfaceC1895i {

    @InterfaceC5817e
    private ReportPictureSelAdapter mAdapter;

    @BindView(C2113R.id.btn_confirm)
    @InterfaceC5816d
    public Button mBtnConfirm;

    @InterfaceC5817e
    private DeliveryBean mDeliveryBean;

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

    @BindView(C2113R.id.et_delivery_name)
    @InterfaceC5816d
    public EditText mEtPlatName;

    @BindView(C2113R.id.iv_back)
    @InterfaceC5816d
    public ImageView mIvBack;

    @BindView(C2113R.id.ll_delivery_plat)
    @InterfaceC5816d
    public View mLlDeliveryPlat;

    @InterfaceC5817e
    private DeliveryPresenter mPresenter;

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

    @InterfaceC5817e
    private C0922h picker;
    private List<? extends DeliveryPlatBean> platList;
    private String platformCode;

    @BindView(C2113R.id.ns_layout)
    @InterfaceC5816d
    public NestedScrollView scrollView;
    private final int CODE_PREVIEW = 1000;
    private final int REQUEST_CODE_RECORD = 1001;

    @InterfaceC5816d
    private String caseInfoId = "";
    private final int mMaxSelectNum = 6;

    @InterfaceC5816d
    private ArrayList<LocalMedia> mLocalMedia = new ArrayList<>();
    private ArrayList<String> pickTypes = new ArrayList<>();

    /* compiled from: DeliveryAddActivity.kt */
    /* renamed from: ui.activity.DeliveryAddActivity$a */
    public static final class C6286a implements PermissionsListener {

        /* renamed from: b */
        final /* synthetic */ List f22270b;

        /* renamed from: c */
        final /* synthetic */ int f22271c;

        C6286a(List list, int i2) {
            this.f22270b = list;
            this.f22271c = i2;
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(@InterfaceC5816d List<String> list, boolean z) {
            C5544i0.m22546f(list, "deniedPermissions");
            C7310c.m26513a(DeliveryAddActivity.this.mActivity, list, z, true, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            C5846e.m24617a(DeliveryAddActivity.this.mActivity, 200L, PictureMimeType.ofImage(), DeliveryAddActivity.this.getMMaxSelectNum() - this.f22270b.size()).forResult(this.f22271c);
        }
    }

    /* compiled from: DeliveryAddActivity.kt */
    /* renamed from: ui.activity.DeliveryAddActivity$b */
    public static final class C6287b implements TextWatcher {
        C6287b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@InterfaceC5816d Editable editable) {
            C5544i0.m22546f(editable, C3351bh.f11580aE);
            DeliveryAddActivity.this.regexPlat(editable.toString());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@InterfaceC5816d CharSequence charSequence, int i2, int i3, int i4) {
            C5544i0.m22546f(charSequence, C3351bh.f11580aE);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@InterfaceC5816d CharSequence charSequence, int i2, int i3, int i4) {
            C5544i0.m22546f(charSequence, C3351bh.f11580aE);
        }
    }

    /* compiled from: DeliveryAddActivity.kt */
    /* renamed from: ui.activity.DeliveryAddActivity$c */
    public static final class C6288c implements IClickListener {
        C6288c() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            DeliveryAddActivity.this.upLoadMedia();
        }
    }

    /* compiled from: DeliveryAddActivity.kt */
    /* renamed from: ui.activity.DeliveryAddActivity$d */
    public static final class C6289d implements IClickListener {
        C6289d() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            DeliveryAddActivity.this.cancleUpLoad();
            DeliveryAddActivity.this.finish();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    /* compiled from: DeliveryAddActivity.kt */
    /* renamed from: ui.activity.DeliveryAddActivity$e */
    public static final class C6290e extends C0922h.a {
        C6290e() {
        }

        @Override // p023b.p024a.p025a.p027e.C0922h.a
        /* renamed from: b */
        public void mo971b(int i2, @InterfaceC5816d String str) {
            C5544i0.m22546f(str, "item");
            DeliveryAddActivity.this.platSelect(i2);
        }
    }

    /* compiled from: DeliveryAddActivity.kt */
    /* renamed from: ui.activity.DeliveryAddActivity$f */
    static final class C6291f implements C0918d.m {

        /* renamed from: a */
        final /* synthetic */ TextView f22276a;

        C6291f(TextView textView) {
            this.f22276a = textView;
        }

        @Override // p023b.p024a.p025a.p027e.C0918d.m
        /* renamed from: a */
        public final void mo880a(String str, String str2, String str3, String str4, String str5) {
            String str6 = str + '-' + str2 + '-' + str3 + ' ' + str4 + ':' + str5;
            TextView textView = this.f22276a;
            if (textView == null) {
                C5544i0.m22545f();
            }
            textView.setText(str6);
        }
    }

    private final void checkPermission(int i2, List<? extends LocalMedia> list) {
        C7310c.m26518a(this.mActivity, new String[]{C7308a.f25547z}, new C6286a(list, i2));
    }

    private final void editChangeListner() {
        EditText editText = this.mEtDeliveryNum;
        if (editText == null) {
            C5544i0.m22554k("mEtDeliveryNum");
        }
        if (editText == null) {
            C5544i0.m22545f();
        }
        editText.addTextChangedListener(new C6287b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void platSelect(int i2) {
        List<? extends DeliveryPlatBean> list = this.platList;
        if (list == null) {
            C5544i0.m22545f();
        }
        DeliveryPlatBean deliveryPlatBean = list.get(i2);
        this.platformCode = deliveryPlatBean.getPlatform();
        if (deliveryPlatBean.getEx() == 1) {
            View view = this.mLlDeliveryPlat;
            if (view == null) {
                C5544i0.m22554k("mLlDeliveryPlat");
            }
            view.setVisibility(0);
        } else {
            View view2 = this.mLlDeliveryPlat;
            if (view2 == null) {
                C5544i0.m22554k("mLlDeliveryPlat");
            }
            view2.setVisibility(8);
        }
        TextView textView = this.mTvDeliveryPlat;
        if (textView == null) {
            C5544i0.m22554k("mTvDeliveryPlat");
        }
        textView.setText(deliveryPlatBean.getPlatformText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void regexPlat(String str) {
        if (TextUtils.isEmpty(str)) {
            TextView textView = this.mTvDeliveryPlat;
            if (textView == null) {
                C5544i0.m22554k("mTvDeliveryPlat");
            }
            textView.setText("");
            View view = this.mLlDeliveryPlat;
            if (view == null) {
                C5544i0.m22554k("mLlDeliveryPlat");
            }
            view.setVisibility(8);
            return;
        }
        List<? extends DeliveryPlatBean> list = this.platList;
        if (list != null) {
            Integer valueOf = list != null ? Integer.valueOf(list.size()) : null;
            if (valueOf == null) {
                C5544i0.m22545f();
            }
            if (valueOf.intValue() > 0) {
                List<? extends DeliveryPlatBean> list2 = this.platList;
                if (list2 == null) {
                    C5544i0.m22545f();
                }
                int size = list2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    List<? extends DeliveryPlatBean> list3 = this.platList;
                    if (list3 == null) {
                        C5544i0.m22545f();
                    }
                    if (C7337y1.m26758a(str, list3.get(i2).getOddNumRegex())) {
                        C0922h c0922h = this.picker;
                        if (c0922h != null) {
                            c0922h.m979E(i2);
                        }
                        platSelect(i2);
                        return;
                    }
                }
            }
        }
    }

    private final void saveHttpApi() {
        ArrayList<UploadFileBean> mailingTelDetails;
        ArrayList<LocalMedia> arrayList = this.mLocalMedia;
        if (arrayList == null || arrayList.size() == 0) {
            DeliveryBean deliveryBean = this.mDeliveryBean;
            if (deliveryBean != null) {
                deliveryBean.setMailingTelDetails(null);
            }
        } else {
            ArrayList<UploadFileBean> arrayList2 = this.mUploadPicList;
            if (arrayList2 != null && arrayList2.size() > 0) {
                DeliveryBean deliveryBean2 = this.mDeliveryBean;
                if ((deliveryBean2 != null ? deliveryBean2.getMailingTelDetails() : null) != null) {
                    DeliveryBean deliveryBean3 = this.mDeliveryBean;
                    if (deliveryBean3 != null && (mailingTelDetails = deliveryBean3.getMailingTelDetails()) != null) {
                        mailingTelDetails.addAll(this.mUploadPicList);
                    }
                } else {
                    DeliveryBean deliveryBean4 = this.mDeliveryBean;
                    if (deliveryBean4 != null) {
                        deliveryBean4.setMailingTelDetails(this.mUploadPicList);
                    }
                }
            }
        }
        DeliveryPresenter deliveryPresenter = this.mPresenter;
        if (deliveryPresenter == null) {
            C5544i0.m22545f();
        }
        deliveryPresenter.saveDeliveryTelHttp(this.mDeliveryBean);
    }

    private final void showTimePiker(TextView textView) {
        Calendar calendar = Calendar.getInstance();
        int i2 = calendar.get(1);
        int i3 = calendar.get(2) + 1;
        int i4 = calendar.get(5);
        int i5 = calendar.get(11);
        int i6 = calendar.get(12);
        C0918d c0918d = new C0918d(this, 0, 3);
        c0918d.mo869g(2018, 2055);
        c0918d.mo860a(i2, i3, i4, i5, i6);
        c0918d.setOnDateTimePickListener(new C6291f(textView));
        c0918d.m1045m();
    }

    public final int getCODE_PREVIEW() {
        return this.CODE_PREVIEW;
    }

    @InterfaceC5816d
    public final String getCaseInfoId() {
        return this.caseInfoId;
    }

    @InterfaceC5817e
    public final ReportPictureSelAdapter getMAdapter() {
        return this.mAdapter;
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
        return this.mDeliveryBean;
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
    public final EditText getMEtPlatName() {
        EditText editText = this.mEtPlatName;
        if (editText == null) {
            C5544i0.m22554k("mEtPlatName");
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

    @InterfaceC5816d
    public final View getMLlDeliveryPlat() {
        View view = this.mLlDeliveryPlat;
        if (view == null) {
            C5544i0.m22554k("mLlDeliveryPlat");
        }
        return view;
    }

    @InterfaceC5816d
    public final ArrayList<LocalMedia> getMLocalMedia() {
        return this.mLocalMedia;
    }

    public final int getMMaxSelectNum() {
        return this.mMaxSelectNum;
    }

    @InterfaceC5817e
    public final DeliveryPresenter getMPresenter() {
        return this.mPresenter;
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

    @InterfaceC5817e
    public final C0922h getPicker() {
        return this.picker;
    }

    public final int getREQUEST_CODE_RECORD() {
        return this.REQUEST_CODE_RECORD;
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
        textView.setText("寄递类嫌疑人电话详情");
        initView();
        editChangeListner();
        DeliveryPresenter deliveryPresenter = this.mPresenter;
        if (deliveryPresenter == null) {
            C5544i0.m22545f();
        }
        deliveryPresenter.getPlatList();
    }

    @InterfaceC5816d
    public final ReportPictureSelAdapter initRecycle(@InterfaceC5816d NestedScrollView nestedScrollView, @InterfaceC5816d RecyclerView recyclerView, @InterfaceC5816d ArrayList<LocalMedia> arrayList, @InterfaceC5816d List<? extends UploadStateInfo> list) {
        C5544i0.m22546f(nestedScrollView, "scrollView");
        C5544i0.m22546f(recyclerView, "recyclerView");
        C5544i0.m22546f(arrayList, "localMediaList");
        C5544i0.m22546f(list, "uploadStateInfoList");
        recycleViewListener(nestedScrollView, recyclerView);
        ReportPictureSelAdapter m271a = ReportPictureSelAdapter.m271a(this.mActivity, recyclerView, this.mMaxSelectNum, this, this, arrayList, list);
        C5544i0.m22521a((Object) m271a, "ReportPictureSelAdapter.…List,uploadStateInfoList)");
        return m271a;
    }

    public final void initView() {
        String stringExtra = getIntent().getStringExtra(C7292k1.f25338C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.caseInfoId = stringExtra;
        this.mDeliveryBean = (DeliveryBean) getIntent().getSerializableExtra(C7292k1.f25391c);
        this.mPresenter = new DeliveryPresenter(this.mActivity, this);
        NestedScrollView nestedScrollView = this.scrollView;
        if (nestedScrollView == null) {
            C5544i0.m22554k("scrollView");
        }
        RecyclerView recyclerView = this.mRecyView;
        if (recyclerView == null) {
            C5544i0.m22554k("mRecyView");
        }
        ArrayList<LocalMedia> arrayList = this.mLocalMedia;
        ArrayList<UploadStateInfo> arrayList2 = this.mUploadStateList;
        C5544i0.m22521a((Object) arrayList2, "mUploadStateList");
        this.mAdapter = initRecycle(nestedScrollView, recyclerView, arrayList, arrayList2);
    }

    @Override // p388ui.activity.BasePicUploadActivity
    public void notifyAdapter() {
        super.notifyAdapter();
        if (this.mLocalMedia == null || this.isScroll) {
            this.isScrollOver = true;
            return;
        }
        if (this.mCurrentUploadIndex < 0) {
            ReportPictureSelAdapter reportPictureSelAdapter = this.mAdapter;
            if (reportPictureSelAdapter == null) {
                C5544i0.m22545f();
            }
            reportPictureSelAdapter.notifyDataSetChanged();
            return;
        }
        if (!this.isScrollOver) {
            ReportPictureSelAdapter reportPictureSelAdapter2 = this.mAdapter;
            if (reportPictureSelAdapter2 == null) {
                C5544i0.m22545f();
            }
            reportPictureSelAdapter2.notifyDataSetChanged();
            return;
        }
        ReportPictureSelAdapter reportPictureSelAdapter3 = this.mAdapter;
        if (reportPictureSelAdapter3 == null) {
            C5544i0.m22545f();
        }
        reportPictureSelAdapter3.notifyItemRangeChanged(0, this.mCurrentUploadIndex);
        this.isScrollOver = false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, @InterfaceC5817e Intent intent) {
        List<LocalMedia> obtainMultipleResult;
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1 || i2 != this.REQUEST_CODE_RECORD || (obtainMultipleResult = PictureSelector.obtainMultipleResult(intent)) == null || obtainMultipleResult.size() <= 0) {
            return;
        }
        Button button = this.mBtnConfirm;
        if (button == null) {
            C5544i0.m22554k("mBtnConfirm");
        }
        if (button.isEnabled()) {
            if (Build.VERSION.SDK_INT > 28) {
                changePath(obtainMultipleResult);
            }
            List<LocalMedia> m26741a = C7337y1.m26741a(obtainMultipleResult);
            C5544i0.m22521a((Object) m26741a, "newList");
            int size = m26741a.size();
            for (int i4 = 0; i4 < size; i4++) {
                UploadFileBean uploadFileBean = new UploadFileBean();
                uploadFileBean.setLocalPath(m26741a.get(i4).getPath());
                uploadFileBean.setFileName(m26741a.get(i4).getFileName());
                this.mLocalMedia.add(m26741a.get(i4));
                this.mUploadStateList.add(new UploadStateInfo());
                this.mUploadPicList.add(uploadFileBean);
            }
            ReportPictureSelAdapter reportPictureSelAdapter = this.mAdapter;
            if (reportPictureSelAdapter != null) {
                reportPictureSelAdapter.notifyDataSetChanged();
            }
            changeBtnCommit("确定", true);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.InterfaceC1895i
    public void onItemChildClick(@InterfaceC5817e BaseQuickAdapter<?, ?> baseQuickAdapter, @InterfaceC5817e View view, int i2) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == C2113R.id.iv_clear) {
            Button button = this.mBtnConfirm;
            if (button == null) {
                C5544i0.m22554k("mBtnConfirm");
            }
            if (button.isEnabled()) {
                deleteDialog(i2);
            }
        }
    }

    @Override // adapter.ReportPictureSelAdapter.InterfaceC0069a
    public void onItemClickListener(int i2, @InterfaceC5817e ArrayList<LocalMedia> arrayList) {
        LocalMedia localMedia;
        if (isDouble()) {
            return;
        }
        if (arrayList != null && i2 == arrayList.size()) {
            if (rejuctOperation(false)) {
                return;
            }
            checkPermission(this.REQUEST_CODE_RECORD, this.mLocalMedia);
            return;
        }
        String path = (arrayList == null || (localMedia = arrayList.get(i2)) == null) ? null : localMedia.getPath();
        Intent intent = new Intent(this, (Class<?>) PreviewPictureActivity.class);
        intent.putParcelableArrayListExtra(PreviewPictureActivity.f22711f, arrayList);
        intent.putExtra(PreviewPictureActivity.f22712g, i2);
        intent.putExtra(PreviewPictureActivity.f22713h, arrayList != null ? Integer.valueOf(arrayList.size()) : null);
        intent.putExtra(PreviewPictureActivity.f22714i, path);
        startActivityForResult(intent, this.CODE_PREVIEW);
    }

    @Override // p388ui.callview.DeliveryView
    public void onItemDelet(int i2) {
        DeliveryView.C6815a.m25459a(this, i2);
    }

    @Override // p388ui.callview.DeliveryView
    public void onItemEdit(int i2) {
        DeliveryView.C6815a.m25463b(this, i2);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, @InterfaceC5816d KeyEvent keyEvent) {
        C5544i0.m22546f(keyEvent, "event");
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        onkeyback();
        return true;
    }

    @Override // p388ui.callview.DeliveryView
    public void onSuccessList(@InterfaceC5816d List<? extends DeliveryBean> list) {
        C5544i0.m22546f(list, "list");
        DeliveryView.C6815a.m25462a(this, list);
    }

    @Override // p388ui.callview.DeliveryView
    public void onSuccessPlatList(@InterfaceC5816d List<? extends DeliveryPlatBean> list) {
        C5544i0.m22546f(list, "list");
        DeliveryView.C6815a.m25464b(this, list);
        if (list.size() > 0) {
            this.platList = list;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.pickTypes.add(list.get(i2).getPlatformText());
                String platform = list.get(i2).getPlatform();
                DeliveryBean deliveryBean = this.mDeliveryBean;
                if (C5544i0.m22531a((Object) platform, (Object) (deliveryBean != null ? deliveryBean.getPlatform() : null))) {
                    if (list.get(i2).getEx() == 1) {
                        DeliveryBean deliveryBean2 = this.mDeliveryBean;
                        if (deliveryBean2 != null) {
                            deliveryBean2.setEx(1);
                        }
                    } else {
                        DeliveryBean deliveryBean3 = this.mDeliveryBean;
                        if (deliveryBean3 != null) {
                            deliveryBean3.setEx(0);
                        }
                    }
                }
            }
            redisplayData();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    @Override // p388ui.callview.DeliveryView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onSuccessSave(@p324i.p336c.p337a.InterfaceC5816d bean.DeliveryBean r2) {
        /*
            r1 = this;
            java.lang.String r0 = "bean"
            p286h.p309q2.p311t.C5544i0.m22546f(r2, r0)
            bean.DeliveryBean r2 = r1.mDeliveryBean
            if (r2 == 0) goto L1e
            if (r2 != 0) goto Le
            p286h.p309q2.p311t.C5544i0.m22545f()
        Le:
            java.lang.String r2 = r2.getMailingTelInfoid()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L1e
            java.lang.String r2 = "修改成功"
            util.C7331w1.m26688a(r2)
            goto L23
        L1e:
            java.lang.String r2 = "添加成功"
            util.C7331w1.m26688a(r2)
        L23:
            android.widget.Button r2 = r1.mBtnConfirm
            if (r2 != 0) goto L2c
            java.lang.String r0 = "mBtnConfirm"
            p286h.p309q2.p311t.C5544i0.m22554k(r0)
        L2c:
            r0 = 1
            r2.setEnabled(r0)
            r1.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p388ui.activity.DeliveryAddActivity.onSuccessSave(bean.DeliveryBean):void");
    }

    @Override // p388ui.callview.DeliveryView
    public void onSuccessSaveFail(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "msg");
        DeliveryView.C6815a.m25461a(this, str);
        Button button = this.mBtnConfirm;
        if (button == null) {
            C5544i0.m22554k("mBtnConfirm");
        }
        button.setEnabled(true);
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.tv_delivery_plat, C2113R.id.tv_delivery_time, C2113R.id.btn_confirm})
    public final void onViewClicked(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        Hicore app = Hicore.getApp();
        C5544i0.m22521a((Object) app, "Hicore.getApp()");
        if (app.isDouble()) {
        }
        switch (view.getId()) {
            case C2113R.id.btn_confirm /* 2131296396 */:
                EditText editText = this.mEtDeliveryNum;
                if (editText == null) {
                    C5544i0.m22554k("mEtDeliveryNum");
                }
                String obj = editText.getText().toString();
                TextView textView = this.mTvDeliveryPlat;
                if (textView == null) {
                    C5544i0.m22554k("mTvDeliveryPlat");
                }
                String obj2 = textView.getText().toString();
                EditText editText2 = this.mEtPlatName;
                if (editText2 == null) {
                    C5544i0.m22554k("mEtPlatName");
                }
                String obj3 = editText2.getText().toString();
                EditText editText3 = this.mEtDeliveryName;
                if (editText3 == null) {
                    C5544i0.m22554k("mEtDeliveryName");
                }
                String obj4 = editText3.getText().toString();
                EditText editText4 = this.mEtDeliveryPhone;
                if (editText4 == null) {
                    C5544i0.m22554k("mEtDeliveryPhone");
                }
                String obj5 = editText4.getText().toString();
                EditText editText5 = this.mEtDeliveryAddress;
                if (editText5 == null) {
                    C5544i0.m22554k("mEtDeliveryAddress");
                }
                String obj6 = editText5.getText().toString();
                TextView textView2 = this.mTvDeliveryTime;
                if (textView2 == null) {
                    C5544i0.m22554k("mTvDeliveryTime");
                }
                String obj7 = textView2.getText().toString();
                EditText editText6 = this.mEtDeliveryWp;
                if (editText6 == null) {
                    C5544i0.m22554k("mEtDeliveryWp");
                }
                String obj8 = editText6.getText().toString();
                if (!(obj.length() == 0)) {
                    EditText editText7 = this.mEtPlatName;
                    if (editText7 == null) {
                        C5544i0.m22554k("mEtPlatName");
                    }
                    if (editText7.isShown()) {
                        if (obj3.length() == 0) {
                            C7331w1.m26688a("请填写物流公司名称");
                            break;
                        }
                    }
                    if (!(obj2.length() == 0)) {
                        if (!(obj4.length() == 0)) {
                            if (!(obj5.length() == 0)) {
                                if (!(obj6.length() == 0)) {
                                    if (!(obj7.length() == 0)) {
                                        if (!(obj8.length() == 0)) {
                                            DeliveryBean deliveryBean = this.mDeliveryBean;
                                            if (deliveryBean == null) {
                                                this.mDeliveryBean = new DeliveryBean();
                                                DeliveryBean deliveryBean2 = this.mDeliveryBean;
                                                if (deliveryBean2 == null) {
                                                    C5544i0.m22545f();
                                                }
                                                deliveryBean2.setCaseInfoID(this.caseInfoId);
                                                DeliveryBean deliveryBean3 = this.mDeliveryBean;
                                                if (deliveryBean3 == null) {
                                                    C5544i0.m22545f();
                                                }
                                                deliveryBean3.setPlatform(this.platformCode);
                                                EditText editText8 = this.mEtPlatName;
                                                if (editText8 == null) {
                                                    C5544i0.m22554k("mEtPlatName");
                                                }
                                                if (editText8.isShown()) {
                                                    DeliveryBean deliveryBean4 = this.mDeliveryBean;
                                                    if (deliveryBean4 == null) {
                                                        C5544i0.m22545f();
                                                    }
                                                    deliveryBean4.setDeliveryPlat(obj3);
                                                } else {
                                                    DeliveryBean deliveryBean5 = this.mDeliveryBean;
                                                    if (deliveryBean5 == null) {
                                                        C5544i0.m22545f();
                                                    }
                                                    deliveryBean5.setDeliveryPlat(obj2);
                                                }
                                                DeliveryBean deliveryBean6 = this.mDeliveryBean;
                                                if (deliveryBean6 == null) {
                                                    C5544i0.m22545f();
                                                }
                                                deliveryBean6.setDeliveryNum(obj);
                                                DeliveryBean deliveryBean7 = this.mDeliveryBean;
                                                if (deliveryBean7 == null) {
                                                    C5544i0.m22545f();
                                                }
                                                deliveryBean7.setDeliveryAddress(obj6);
                                                DeliveryBean deliveryBean8 = this.mDeliveryBean;
                                                if (deliveryBean8 == null) {
                                                    C5544i0.m22545f();
                                                }
                                                deliveryBean8.setDeliveryName(obj4);
                                                DeliveryBean deliveryBean9 = this.mDeliveryBean;
                                                if (deliveryBean9 == null) {
                                                    C5544i0.m22545f();
                                                }
                                                deliveryBean9.setDeliveryPhone(obj5);
                                                DeliveryBean deliveryBean10 = this.mDeliveryBean;
                                                if (deliveryBean10 == null) {
                                                    C5544i0.m22545f();
                                                }
                                                deliveryBean10.setDeliveryTime(obj7);
                                                DeliveryBean deliveryBean11 = this.mDeliveryBean;
                                                if (deliveryBean11 == null) {
                                                    C5544i0.m22545f();
                                                }
                                                deliveryBean11.setDeliveryWp(obj8);
                                            } else {
                                                if (deliveryBean == null) {
                                                    C5544i0.m22545f();
                                                }
                                                deliveryBean.setCaseInfoID(this.caseInfoId);
                                                DeliveryBean deliveryBean12 = this.mDeliveryBean;
                                                if (deliveryBean12 == null) {
                                                    C5544i0.m22545f();
                                                }
                                                deliveryBean12.setPlatform(this.platformCode);
                                                EditText editText9 = this.mEtPlatName;
                                                if (editText9 == null) {
                                                    C5544i0.m22554k("mEtPlatName");
                                                }
                                                if (editText9.isShown()) {
                                                    DeliveryBean deliveryBean13 = this.mDeliveryBean;
                                                    if (deliveryBean13 == null) {
                                                        C5544i0.m22545f();
                                                    }
                                                    deliveryBean13.setDeliveryPlat(obj3);
                                                } else {
                                                    DeliveryBean deliveryBean14 = this.mDeliveryBean;
                                                    if (deliveryBean14 == null) {
                                                        C5544i0.m22545f();
                                                    }
                                                    deliveryBean14.setDeliveryPlat(obj2);
                                                }
                                                DeliveryBean deliveryBean15 = this.mDeliveryBean;
                                                if (deliveryBean15 == null) {
                                                    C5544i0.m22545f();
                                                }
                                                deliveryBean15.setDeliveryNum(obj);
                                                DeliveryBean deliveryBean16 = this.mDeliveryBean;
                                                if (deliveryBean16 == null) {
                                                    C5544i0.m22545f();
                                                }
                                                deliveryBean16.setDeliveryAddress(obj6);
                                                DeliveryBean deliveryBean17 = this.mDeliveryBean;
                                                if (deliveryBean17 == null) {
                                                    C5544i0.m22545f();
                                                }
                                                deliveryBean17.setDeliveryName(obj4);
                                                DeliveryBean deliveryBean18 = this.mDeliveryBean;
                                                if (deliveryBean18 == null) {
                                                    C5544i0.m22545f();
                                                }
                                                deliveryBean18.setDeliveryPhone(obj5);
                                                DeliveryBean deliveryBean19 = this.mDeliveryBean;
                                                if (deliveryBean19 == null) {
                                                    C5544i0.m22545f();
                                                }
                                                deliveryBean19.setDeliveryTime(obj7);
                                                DeliveryBean deliveryBean20 = this.mDeliveryBean;
                                                if (deliveryBean20 == null) {
                                                    C5544i0.m22545f();
                                                }
                                                deliveryBean20.setDeliveryWp(obj8);
                                            }
                                            if (!C5544i0.m22531a((Object) obj5, (Object) AccountManager.getVisiblePhone())) {
                                                upLoadMedia();
                                                break;
                                            } else {
                                                C7257b1.m26211b(this.mActivity, "添加的寄件人手机号码是您的登录号码，确定添加个人号码为诈骗号码?", "", "取消", "确定", new C6288c());
                                                break;
                                            }
                                        } else {
                                            C7331w1.m26688a("请填写快递物品");
                                            break;
                                        }
                                    } else {
                                        C7331w1.m26688a("请选择寄件时间");
                                        break;
                                    }
                                } else {
                                    C7331w1.m26688a("请填写寄件地址");
                                    break;
                                }
                            } else {
                                C7331w1.m26688a("请填写寄件人电话");
                                break;
                            }
                        } else {
                            C7331w1.m26688a("请填写寄件人姓名");
                            break;
                        }
                    } else {
                        C7331w1.m26688a("请选择物流公司");
                        break;
                    }
                } else {
                    C7331w1.m26688a("请输入或粘贴快递单号");
                    break;
                }
            case C2113R.id.iv_back /* 2131296762 */:
                onkeyback();
                break;
            case C2113R.id.tv_delivery_plat /* 2131297520 */:
                showPlatPiker();
                break;
            case C2113R.id.tv_delivery_time /* 2131297524 */:
                TextView textView3 = this.mTvDeliveryTime;
                if (textView3 == null) {
                    C5544i0.m22554k("mTvDeliveryTime");
                }
                showTimePiker(textView3);
                break;
        }
    }

    public final void onkeyback() {
        C7257b1.m26211b(this.mActivity, "放弃本次信息编辑？", "", "确定", "取消", new C6289d());
    }

    @Override // p388ui.activity.BasePicUploadActivity
    protected void pageFileFinish() {
        super.pageFileFinish();
        saveHttpApi();
    }

    public final void redisplayData() {
        if (this.mDeliveryBean != null) {
            EditText editText = this.mEtDeliveryNum;
            if (editText == null) {
                C5544i0.m22554k("mEtDeliveryNum");
            }
            DeliveryBean deliveryBean = this.mDeliveryBean;
            editText.setText(deliveryBean != null ? deliveryBean.getDeliveryNum() : null);
            EditText editText2 = this.mEtDeliveryPhone;
            if (editText2 == null) {
                C5544i0.m22554k("mEtDeliveryPhone");
            }
            DeliveryBean deliveryBean2 = this.mDeliveryBean;
            editText2.setText(deliveryBean2 != null ? deliveryBean2.getDeliveryPhone() : null);
            EditText editText3 = this.mEtDeliveryAddress;
            if (editText3 == null) {
                C5544i0.m22554k("mEtDeliveryAddress");
            }
            DeliveryBean deliveryBean3 = this.mDeliveryBean;
            editText3.setText(deliveryBean3 != null ? deliveryBean3.getDeliveryAddress() : null);
            EditText editText4 = this.mEtDeliveryName;
            if (editText4 == null) {
                C5544i0.m22554k("mEtDeliveryName");
            }
            if (editText4 == null) {
                C5544i0.m22545f();
            }
            DeliveryBean deliveryBean4 = this.mDeliveryBean;
            editText4.setText(deliveryBean4 != null ? deliveryBean4.getDeliveryName() : null);
            TextView textView = this.mTvDeliveryTime;
            if (textView == null) {
                C5544i0.m22554k("mTvDeliveryTime");
            }
            DeliveryBean deliveryBean5 = this.mDeliveryBean;
            textView.setText(deliveryBean5 != null ? deliveryBean5.getDeliveryTime() : null);
            EditText editText5 = this.mEtDeliveryWp;
            if (editText5 == null) {
                C5544i0.m22554k("mEtDeliveryWp");
            }
            DeliveryBean deliveryBean6 = this.mDeliveryBean;
            editText5.setText(deliveryBean6 != null ? deliveryBean6.getDeliveryWp() : null);
            DeliveryBean deliveryBean7 = this.mDeliveryBean;
            if (deliveryBean7 == null || deliveryBean7.getEx() != 1) {
                View view = this.mLlDeliveryPlat;
                if (view == null) {
                    C5544i0.m22554k("mLlDeliveryPlat");
                }
                view.setVisibility(8);
                TextView textView2 = this.mTvDeliveryPlat;
                if (textView2 == null) {
                    C5544i0.m22554k("mTvDeliveryPlat");
                }
                if (textView2 == null) {
                    C5544i0.m22545f();
                }
                DeliveryBean deliveryBean8 = this.mDeliveryBean;
                textView2.setText(deliveryBean8 != null ? deliveryBean8.getDeliveryPlat() : null);
            } else {
                View view2 = this.mLlDeliveryPlat;
                if (view2 == null) {
                    C5544i0.m22554k("mLlDeliveryPlat");
                }
                view2.setVisibility(0);
                TextView textView3 = this.mTvDeliveryPlat;
                if (textView3 == null) {
                    C5544i0.m22554k("mTvDeliveryPlat");
                }
                if (textView3 == null) {
                    C5544i0.m22545f();
                }
                ArrayList<String> arrayList = this.pickTypes;
                textView3.setText(arrayList.get(arrayList.size() - 1));
                EditText editText6 = this.mEtPlatName;
                if (editText6 == null) {
                    C5544i0.m22554k("mEtPlatName");
                }
                if (editText6 == null) {
                    C5544i0.m22545f();
                }
                DeliveryBean deliveryBean9 = this.mDeliveryBean;
                editText6.setText(deliveryBean9 != null ? deliveryBean9.getDeliveryPlat() : null);
            }
            DeliveryBean deliveryBean10 = this.mDeliveryBean;
            this.platformCode = deliveryBean10 != null ? deliveryBean10.getPlatform() : null;
            DeliveryBean deliveryBean11 = this.mDeliveryBean;
            transLocalMedia(deliveryBean11 != null ? deliveryBean11.getMailingTelDetails() : null);
        }
    }

    @Override // p388ui.activity.BasePicUploadActivity
    public void removeLocalData(int i2) {
        ArrayList<UploadFileBean> mailingTelDetails;
        this.mLocalMedia.remove(i2);
        ReportPictureSelAdapter reportPictureSelAdapter = this.mAdapter;
        if (reportPictureSelAdapter != null) {
            reportPictureSelAdapter.notifyDataSetChanged();
        }
        DeliveryBean deliveryBean = this.mDeliveryBean;
        if (deliveryBean == null || (mailingTelDetails = deliveryBean.getMailingTelDetails()) == null) {
            return;
        }
        mailingTelDetails.remove(i2);
    }

    public final void setCaseInfoId(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "<set-?>");
        this.caseInfoId = str;
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_delivery_add;
    }

    public final void setMAdapter(@InterfaceC5817e ReportPictureSelAdapter reportPictureSelAdapter) {
        this.mAdapter = reportPictureSelAdapter;
    }

    public final void setMBtnConfirm(@InterfaceC5816d Button button) {
        C5544i0.m22546f(button, "<set-?>");
        this.mBtnConfirm = button;
    }

    public final void setMDeliveryBean(@InterfaceC5817e DeliveryBean deliveryBean) {
        this.mDeliveryBean = deliveryBean;
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

    public final void setMEtPlatName(@InterfaceC5816d EditText editText) {
        C5544i0.m22546f(editText, "<set-?>");
        this.mEtPlatName = editText;
    }

    public final void setMIvBack(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMLlDeliveryPlat(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mLlDeliveryPlat = view;
    }

    public final void setMLocalMedia(@InterfaceC5816d ArrayList<LocalMedia> arrayList) {
        C5544i0.m22546f(arrayList, "<set-?>");
        this.mLocalMedia = arrayList;
    }

    public final void setMPresenter(@InterfaceC5817e DeliveryPresenter deliveryPresenter) {
        this.mPresenter = deliveryPresenter;
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

    public final void setPicker(@InterfaceC5817e C0922h c0922h) {
        this.picker = c0922h;
    }

    public final void setScrollView(@InterfaceC5816d NestedScrollView nestedScrollView) {
        C5544i0.m22546f(nestedScrollView, "<set-?>");
        this.scrollView = nestedScrollView;
    }

    public final void showPlatPiker() {
        if (this.pickTypes.size() == 0) {
            return;
        }
        this.picker = new C0922h(this.mActivity, this.pickTypes);
        C0922h c0922h = this.picker;
        if (c0922h != null) {
            c0922h.m1017x(3);
        }
        C0922h c0922h2 = this.picker;
        if (c0922h2 != null) {
            c0922h2.m979E(0);
        }
        C0922h c0922h3 = this.picker;
        if (c0922h3 != null) {
            c0922h3.m998C(15);
        }
        C0922h c0922h4 = this.picker;
        if (c0922h4 != null) {
            c0922h4.setOnOptionPickListener(new C6290e());
        }
        C0922h c0922h5 = this.picker;
        if (c0922h5 != null) {
            c0922h5.m1045m();
        }
    }

    public final void transLocalMedia(@InterfaceC5817e ArrayList<UploadFileBean> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mUploadPicList.addAll(arrayList);
            Iterator<UploadFileBean> it = arrayList.iterator();
            while (it.hasNext()) {
                UploadFileBean next = it.next();
                new UploadFileBean();
                UploadStateInfo uploadStateInfo = new UploadStateInfo();
                uploadStateInfo.setUploadState(2);
                this.mUploadStateList.add(uploadStateInfo);
                LocalMedia localMedia = new LocalMedia();
                C5544i0.m22521a((Object) next, "bean");
                localMedia.setPath(next.getLocalPath());
                localMedia.setFileName(next.getFileName());
                this.mLocalMedia.add(localMedia);
            }
        }
        ReportPictureSelAdapter reportPictureSelAdapter = this.mAdapter;
        if (reportPictureSelAdapter != null) {
            reportPictureSelAdapter.notifyDataSetChanged();
        }
    }

    public final void upLoadMedia() {
        if (this.mLocalMedia.size() <= 0) {
            pageFileFinish();
            return;
        }
        commitDeal();
        Button button = this.mBtnConfirm;
        if (button == null) {
            C5544i0.m22554k("mBtnConfirm");
        }
        button.setEnabled(false);
    }
}
