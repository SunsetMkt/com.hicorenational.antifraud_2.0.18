package p388ui.activity;

import adapter.ReportPictureSelAdapter;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import bean.AccountBean;
import bean.AccountListBean;
import bean.CaseDivisonBean;
import bean.UploadFileBean;
import bean.UploadStateInfo;
import bean.module.ModuelConfig;
import bean.module.RegionMudelBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.C2113R;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.xiaomi.mipush.sdk.Constants;
import interfaces.IClickListener;
import interfaces.PermissionsListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import p023b.p024a.p025a.p027e.C0918d;
import p023b.p024a.p025a.p027e.C0922h;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import p245d.C4440a;
import p247e.C4445b;
import p357j.C5846e;
import p388ui.callview.AccountCallView;
import p388ui.presenter.AccountPresenter;
import p388ui.view.swip.SwipBackLayout;
import util.C7257b1;
import util.C7268d1;
import util.C7292k1;
import util.C7331w1;
import util.C7337y1;
import util.permissionutil.C7308a;
import util.permissionutil.C7310c;

/* loaded from: classes2.dex */
public class AccountActivity extends BasePicUploadActivity implements AccountCallView, ReportPictureSelAdapter.InterfaceC0069a, BaseQuickAdapter.InterfaceC1895i {

    @BindView(C2113R.id.et_amount)
    EditText mEtAmount;

    @BindView(C2113R.id.et_suspect_account)
    EditText mEtSuspectAccount;

    @BindView(C2113R.id.et_suspect_account_name)
    EditText mEtSuspectAccountName;

    @BindView(C2113R.id.et_suspect_other)
    EditText mEtSuspectOther;

    @BindView(C2113R.id.et_victim_account)
    EditText mEtVictimAccount;

    @BindView(C2113R.id.et_victim_other)
    EditText mEtVictimOther;

    @BindView(C2113R.id.group_suspect)
    View mGroupSuspect;

    @BindView(C2113R.id.group_victim)
    View mGroupVictim;

    @BindView(C2113R.id.ll_amount)
    LinearLayout mLlAmount;

    @BindView(C2113R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(C2113R.id.tv_confirm)
    TextView mTvConfirm;

    @BindView(C2113R.id.tv_payment_type)
    TextView mTvPaymentType;

    @BindView(C2113R.id.tv_suspect_type)
    TextView mTvSuspectType;

    @BindView(C2113R.id.tv_time)
    TextView mTvTime;

    @BindView(C2113R.id.tv_tip)
    TextView mTvTip;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;

    @BindView(C2113R.id.tv_victim_type)
    TextView mTvVictimType;

    @BindView(C2113R.id.ns_layout)
    NestedScrollView scrollView;
    private final int REQUEST_CODE = 100;
    private final String ACCOUNT_TYPE_ID_OTHER = "156299792136409088";
    private final String ACCOUNT_TYPE_ID_BANK = "156299792098660353";
    private AccountPresenter mPresenter = null;
    private List<CaseDivisonBean> mAccountTypeList = new ArrayList();
    private String mCaseInfoId = "";
    private String mPaymentInfoId = "";
    private AccountListBean mItem = null;
    private int mMaxSelectNum = 6;
    private ArrayList<LocalMedia> mLocalMedia = new ArrayList<>();
    private ReportPictureSelAdapter mAdapter = null;
    private RegionMudelBean mRegionBean = null;
    private int decimalCount = 2;

    /* renamed from: ui.activity.AccountActivity$a */
    class ViewOnFocusChangeListenerC6095a implements View.OnFocusChangeListener {
        ViewOnFocusChangeListenerC6095a() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (z) {
                return;
            }
            String obj = AccountActivity.this.mEtAmount.length() > 0 ? AccountActivity.this.mEtAmount.getText().toString() : "";
            AccountActivity accountActivity = AccountActivity.this;
            accountActivity.mEtAmount.setText(C7268d1.m26306a(obj, accountActivity.decimalCount));
        }
    }

    /* renamed from: ui.activity.AccountActivity$b */
    class C6096b implements PermissionsListener {
        C6096b() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            C7310c.m26513a(AccountActivity.this.mActivity, list, z, true, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            C5846e.m24617a(AccountActivity.this.mActivity, 200L, PictureMimeType.ofImage(), AccountActivity.this.mMaxSelectNum - AccountActivity.this.mLocalMedia.size()).forResult(PictureConfig.CHOOSE_REQUEST);
        }
    }

    /* renamed from: ui.activity.AccountActivity$c */
    class C6097c implements C0918d.m {
        C6097c() {
        }

        @Override // p023b.p024a.p025a.p027e.C0918d.m
        /* renamed from: a */
        public void mo880a(String str, String str2, String str3, String str4, String str5) {
            AccountActivity.this.mTvTime.setText(str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str3 + AbstractC1191a.f2568g + str4 + Constants.COLON_SEPARATOR + str5);
        }
    }

    /* renamed from: ui.activity.AccountActivity$d */
    class C6098d extends C0922h.a {

        /* renamed from: a */
        final /* synthetic */ TextView f21738a;

        /* renamed from: b */
        final /* synthetic */ List f21739b;

        /* renamed from: c */
        final /* synthetic */ View f21740c;

        C6098d(TextView textView, List list, View view) {
            this.f21738a = textView;
            this.f21739b = list;
            this.f21740c = view;
        }

        @Override // p023b.p024a.p025a.p027e.C0922h.a
        /* renamed from: b */
        public void mo971b(int i2, String str) {
            this.f21738a.setText(str);
            String id = ((CaseDivisonBean) this.f21739b.get(i2)).getId();
            this.f21738a.setTag(id);
            if (this.f21740c != null) {
                if (TextUtils.equals(id, "156299792136409088")) {
                    this.f21740c.setVisibility(0);
                } else {
                    this.f21740c.setVisibility(8);
                }
            }
        }
    }

    /* renamed from: ui.activity.AccountActivity$e */
    class C6099e implements IClickListener {
        C6099e() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            AccountActivity.this.cancleUpLoad();
            AccountActivity.this.finish();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    private void checkPermission() {
        C7310c.m26518a(this.mActivity, new String[]{C7308a.f25547z}, new C6096b());
    }

    private boolean compareAccount(String str, String str2) {
        if (TextUtils.isEmpty(str) || !TextUtils.equals(str, str2)) {
            return false;
        }
        this.mEtVictimAccount.setTextColor(ContextCompat.getColor(this.mActivity, C2113R.color.red));
        this.mEtSuspectAccount.setTextColor(ContextCompat.getColor(this.mActivity, C2113R.color.red));
        C7257b1.m26210b(this.mActivity, "嫌疑人银行账户与受害人银行账户相同，疑似误录，请再次核实", "确定", null);
        return true;
    }

    private void confirm() {
        String str;
        String str2;
        String charSequence = this.mTvPaymentType.getText().toString();
        Object tag = this.mTvPaymentType.getTag();
        if (TextUtils.isEmpty(charSequence) || tag == null) {
            C7331w1.m26688a("请选择转账方式");
            return;
        }
        String obj = tag.toString();
        String charSequence2 = this.mTvTime.getText().toString();
        if (TextUtils.isEmpty(charSequence2)) {
            C7331w1.m26688a("请选择转账时间");
            return;
        }
        if (this.mLlAmount.getVisibility() != 0) {
            str = "0";
        } else if (this.mEtAmount.length() <= 0) {
            C7331w1.m26688a("请输入转账金额");
            return;
        } else {
            str = C7268d1.m26306a(this.mEtAmount.getText().toString(), this.decimalCount);
            this.mEtAmount.setText(str);
        }
        String charSequence3 = this.mTvVictimType.getText().toString();
        if (!transFilt() && TextUtils.isEmpty(charSequence3)) {
            C7331w1.m26688a("请选择受害人账户类型");
            return;
        }
        Object tag2 = this.mTvVictimType.getTag();
        String str3 = "";
        String obj2 = tag2 != null ? tag2.toString() : "";
        String obj3 = this.mEtVictimOther.getText().toString();
        if (this.mGroupVictim.getVisibility() != 0) {
            obj3 = "";
        } else if (TextUtils.isEmpty(obj3)) {
            C7331w1.m26688a("请输入受害人账户类型");
            return;
        }
        String obj4 = this.mEtVictimAccount.getText().toString();
        if (!transFilt() && TextUtils.isEmpty(obj4)) {
            C7331w1.m26688a("请输入受害人账号");
            return;
        }
        String charSequence4 = this.mTvSuspectType.getText().toString();
        Object tag3 = this.mTvSuspectType.getTag();
        if (TextUtils.isEmpty(charSequence4) && this.mLocalMedia.size() == 0) {
            C7331w1.m26688a("请完善嫌疑人账户信息或上传转账汇款凭证");
            return;
        }
        String obj5 = tag3 != null ? tag3.toString() : "";
        String obj6 = this.mEtSuspectOther.getText().toString();
        String obj7 = this.mEtSuspectAccountName.getText().toString();
        String obj8 = this.mEtSuspectAccount.getText().toString();
        if (this.mLocalMedia.size() == 0) {
            if (TextUtils.isEmpty(charSequence4) || tag3 == null) {
                C7331w1.m26688a("请选择嫌疑人账户类型");
                return;
            }
            if (this.mGroupSuspect.getVisibility() == 0) {
                if (TextUtils.isEmpty(obj6)) {
                    C7331w1.m26688a("请输入嫌疑人账户类型");
                    return;
                }
                str3 = obj6;
            }
            if (TextUtils.isEmpty(obj7)) {
                C7331w1.m26688a("请输入嫌疑人账户名");
                return;
            } else if (TextUtils.isEmpty(obj8)) {
                C7331w1.m26688a("请输入嫌疑人账号");
                return;
            } else if (compareAccount(obj4, obj8)) {
                return;
            }
        } else {
            if (TextUtils.isEmpty(charSequence4) && TextUtils.isEmpty(obj7) && TextUtils.isEmpty(obj8)) {
                str2 = obj6;
                AccountBean accountBean = new AccountBean();
                accountBean.setId(this.mCaseInfoId);
                accountBean.setPaymentInfoID(this.mPaymentInfoId);
                accountBean.setPaymentType(obj);
                accountBean.setPaymentTypeText(charSequence);
                accountBean.setPaymentTime(charSequence2);
                accountBean.setTransferAmount(str);
                accountBean.setVictim(obj2, charSequence3, obj3, obj4);
                accountBean.setSuspect(obj5, charSequence4, str2, obj8, obj7);
                this.mPresenter.savePayment(accountBean);
            }
            if (TextUtils.isEmpty(charSequence4) || tag3 == null) {
                C7331w1.m26688a("请选择嫌疑人账户类型");
                return;
            }
            if (this.mGroupSuspect.getVisibility() == 0) {
                if (TextUtils.isEmpty(obj6)) {
                    C7331w1.m26688a("请输入嫌疑人账户类型");
                    return;
                }
                str3 = obj6;
            }
            if (TextUtils.isEmpty(obj7)) {
                C7331w1.m26688a("请输入嫌疑人账户名");
                return;
            } else if (TextUtils.isEmpty(obj8)) {
                C7331w1.m26688a("请输入嫌疑人账号");
                return;
            } else if (compareAccount(obj4, obj8)) {
                return;
            }
        }
        str2 = str3;
        AccountBean accountBean2 = new AccountBean();
        accountBean2.setId(this.mCaseInfoId);
        accountBean2.setPaymentInfoID(this.mPaymentInfoId);
        accountBean2.setPaymentType(obj);
        accountBean2.setPaymentTypeText(charSequence);
        accountBean2.setPaymentTime(charSequence2);
        accountBean2.setTransferAmount(str);
        accountBean2.setVictim(obj2, charSequence3, obj3, obj4);
        accountBean2.setSuspect(obj5, charSequence4, str2, obj8, obj7);
        this.mPresenter.savePayment(accountBean2);
    }

    private ReportPictureSelAdapter initRecycle(NestedScrollView nestedScrollView, RecyclerView recyclerView, ArrayList<LocalMedia> arrayList, List<UploadStateInfo> list) {
        recycleViewListener(nestedScrollView, recyclerView);
        return ReportPictureSelAdapter.m271a(this.mActivity, recyclerView, this.mMaxSelectNum, this, this, arrayList, list);
    }

    private void onkeyback() {
        C7257b1.m26184a(this.mActivity, "放弃本次信息编辑？", "", "确定", "取消", -1, -1, true, (IClickListener) new C6099e());
    }

    private void redisplay() {
        AccountListBean accountListBean = this.mItem;
        if (accountListBean != null) {
            this.mTvPaymentType.setText(accountListBean.getPaymentTypeText());
            this.mTvPaymentType.setTag(this.mItem.getPaymentType());
            this.mTvTime.setText(this.mItem.getPaymentTime());
            if (this.mLlAmount.getVisibility() == 0) {
                this.mEtAmount.setText(C7268d1.m26306a(this.mItem.getTransferAmount(), this.decimalCount));
            }
            String victimAccountType = this.mItem.getVictimAccountType();
            this.mTvVictimType.setText(this.mItem.getVictimAccountTypeText());
            this.mTvVictimType.setTag(victimAccountType);
            if (TextUtils.equals(victimAccountType, "156299792136409088")) {
                this.mEtVictimOther.setText(this.mItem.getVictimAccountTypeText1());
                this.mGroupVictim.setVisibility(0);
            } else {
                this.mGroupVictim.setVisibility(8);
            }
            this.mEtVictimAccount.setText(this.mItem.getVictimAccount());
            String suspectAccountType = this.mItem.getSuspectAccountType();
            this.mTvSuspectType.setText(this.mItem.getSuspectAccountTypeText());
            this.mTvSuspectType.setTag(suspectAccountType);
            if (TextUtils.equals(suspectAccountType, "156299792136409088")) {
                this.mEtSuspectOther.setText(this.mItem.getSuspectAccountTypeText1());
                this.mGroupSuspect.setVisibility(0);
            } else {
                this.mGroupSuspect.setVisibility(8);
            }
            this.mEtSuspectAccountName.setText(this.mItem.getSuspectName());
            this.mEtSuspectAccount.setText(this.mItem.getSuspectAccount());
            transFilt();
            redisplayPicture();
        }
    }

    private void redisplayPicture() {
        List<UploadFileBean> paymentDetails = this.mItem.getPaymentDetails();
        if (paymentDetails != null && paymentDetails.size() > 0) {
            this.mUploadPicList.addAll(paymentDetails);
            for (UploadFileBean uploadFileBean : paymentDetails) {
                UploadStateInfo uploadStateInfo = new UploadStateInfo();
                uploadStateInfo.setUploadState(2);
                this.mUploadStateList.add(uploadStateInfo);
                LocalMedia localMedia = new LocalMedia();
                localMedia.setPath(uploadFileBean.getFileUrl());
                localMedia.setFileName(uploadFileBean.getFileName());
                this.mLocalMedia.add(localMedia);
            }
        }
        this.mAdapter.notifyDataSetChanged();
    }

    private void showTimePiker() {
        Calendar calendar = Calendar.getInstance();
        int i2 = calendar.get(1);
        int i3 = calendar.get(2) + 1;
        int i4 = calendar.get(5);
        int i5 = calendar.get(11);
        int i6 = calendar.get(12);
        C0918d c0918d = new C0918d(this, 0, 3);
        c0918d.mo869g(2018, 2055);
        c0918d.mo860a(i2, i3, i4, i5, i6);
        c0918d.setOnDateTimePickListener(new C6097c());
        c0918d.m1045m();
    }

    private void showTypePiker(List<CaseDivisonBean> list, TextView textView, View view) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            arrayList.add(list.get(i2).getName());
        }
        if (arrayList.size() == 0) {
            return;
        }
        C0922h c0922h = new C0922h(this.mActivity, arrayList);
        c0922h.m1017x(3);
        c0922h.m979E(0);
        c0922h.m998C(15);
        c0922h.setOnOptionPickListener(new C6098d(textView, list, view));
        c0922h.m1045m();
    }

    private boolean transFilt() {
        String charSequence = this.mTvPaymentType.getText().toString();
        return TextUtils.equals("柜面现金转账", charSequence) || TextUtils.equals("ATM机无卡存款", charSequence);
    }

    @Override // p388ui.activity.BasePicUploadActivity
    public void changeBtnCommit(String str, boolean z) {
        if (this.mTvConfirm != null) {
            if (!TextUtils.isEmpty(str)) {
                this.mTvConfirm.setText(str);
            }
            this.mTvConfirm.setEnabled(z);
        }
    }

    @Override // p388ui.activity.BasePicUploadActivity
    public void createUpLoadInfo(UploadFileBean uploadFileBean) {
        uploadFileBean.setId(this.mCaseInfoId);
        uploadFileBean.setPaymentInfoID(this.mPaymentInfoId);
    }

    @Override // p388ui.activity.BasePicUploadActivity
    public String deLoadFileUrl() {
        return C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17107m1);
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        this.mTvTitle.setText("涉案账户信息");
        this.mTvTip.setText("最多可选择" + this.mMaxSelectNum + "张图片");
        this.mRegionBean = C4440a.m16408j();
        RegionMudelBean regionMudelBean = this.mRegionBean;
        if (regionMudelBean == null || !TextUtils.equals(regionMudelBean.getStopPayment(), "1")) {
            this.mLlAmount.setVisibility(8);
        } else {
            this.mLlAmount.setVisibility(0);
            C7268d1.m26309a(this.mEtAmount, this.decimalCount, null);
            this.mEtAmount.setOnFocusChangeListener(new ViewOnFocusChangeListenerC6095a());
        }
        this.mPresenter = new AccountPresenter(this, this);
        this.mPresenter.accountType();
        this.mCaseInfoId = getIntent().getStringExtra(C7292k1.f25338C0);
        try {
            this.mItem = (AccountListBean) getIntent().getSerializableExtra(C7292k1.f25391c);
            this.mPaymentInfoId = this.mItem.getId();
        } catch (Exception e2) {
            e2.printStackTrace();
            this.mItem = null;
            this.mPaymentInfoId = "";
        }
        this.mAdapter = initRecycle(this.scrollView, this.mRecyclerview, this.mLocalMedia, this.mUploadStateList);
        C7268d1.m26317c(this.mEtSuspectAccountName);
        redisplay();
    }

    @Override // p388ui.activity.BasePicUploadActivity
    public void notifyAdapter() {
        super.notifyAdapter();
        if (this.mLocalMedia == null || this.isScroll) {
            this.isScrollOver = true;
            return;
        }
        int i2 = this.mCurrentUploadIndex;
        if (i2 < 0) {
            this.mAdapter.notifyDataSetChanged();
        } else if (!this.isScrollOver) {
            this.mAdapter.notifyItemChanged(i2);
        } else {
            this.mAdapter.notifyItemRangeChanged(0, i2);
            this.isScrollOver = false;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        CaseDivisonBean caseDivisonBean;
        List obtainMultipleResult;
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1) {
            if (i2 == 100) {
                if (intent == null || (caseDivisonBean = (CaseDivisonBean) intent.getSerializableExtra(C7292k1.f25414j1)) == null) {
                    return;
                }
                this.mTvPaymentType.setText(caseDivisonBean.getName());
                this.mTvPaymentType.setTag(caseDivisonBean.getId());
                transFilt();
                return;
            }
            if (i2 == 188 && (obtainMultipleResult = PictureSelector.obtainMultipleResult(intent)) != null && obtainMultipleResult.size() > 0) {
                if (Build.VERSION.SDK_INT > 28) {
                    C7337y1.m26751a(this.mActivity, (List<LocalMedia>) obtainMultipleResult);
                }
                List<LocalMedia> m26741a = C7337y1.m26741a((List<LocalMedia>) obtainMultipleResult);
                for (int i4 = 0; i4 < m26741a.size(); i4++) {
                    LocalMedia localMedia = m26741a.get(i4);
                    localMedia.setChecked(false);
                    this.mLocalMedia.add(localMedia);
                    this.mUploadStateList.add(new UploadStateInfo());
                    UploadFileBean uploadFileBean = new UploadFileBean();
                    uploadFileBean.setLocalPath(localMedia.getPath());
                    uploadFileBean.setFileName(localMedia.getFileName());
                    this.mUploadPicList.add(uploadFileBean);
                }
                this.mAdapter.notifyDataSetChanged();
                changeBtnCommit("确定", true);
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.mItem != null) {
            setResult(-1);
        }
        super.onBackPressed();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.InterfaceC1895i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (isDouble() || view.getId() != C2113R.id.iv_clear || rejuctOperation(false)) {
            return;
        }
        deleteDialog(i2);
    }

    @Override // adapter.ReportPictureSelAdapter.InterfaceC0069a
    public void onItemClickListener(int i2, ArrayList<LocalMedia> arrayList) {
        if (isDouble()) {
            return;
        }
        if (i2 == arrayList.size()) {
            if (rejuctOperation(false)) {
                return;
            }
            checkPermission();
            return;
        }
        String path = arrayList.get(i2).getPath();
        Intent intent = new Intent(this, (Class<?>) PreviewPictureActivity.class);
        intent.putParcelableArrayListExtra(PreviewPictureActivity.f22711f, arrayList);
        intent.putExtra(PreviewPictureActivity.f22712g, i2);
        intent.putExtra(PreviewPictureActivity.f22713h, arrayList.size());
        intent.putExtra(PreviewPictureActivity.f22714i, path);
        startActivityForResult(intent, 1000);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        onkeyback();
        return true;
    }

    @Override // p388ui.callview.AccountCallView
    public void onSuccessAccountType(List<CaseDivisonBean> list) {
        this.mAccountTypeList = list;
    }

    @Override // p388ui.callview.AccountCallView
    public void onSuccessSave(String str) {
        this.mPaymentInfoId = str;
        if (this.mLocalMedia.size() > 0) {
            commitDeal();
        } else {
            pageFileFinish();
        }
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.tv_payment_type, C2113R.id.tv_time, C2113R.id.tv_victim_type, C2113R.id.tv_suspect_type, C2113R.id.tv_confirm})
    public void onViewClicked(View view) {
        if (isDouble()) {
        }
        switch (view.getId()) {
            case C2113R.id.iv_back /* 2131296762 */:
                onkeyback();
                break;
            case C2113R.id.tv_confirm /* 2131297484 */:
                confirm();
                break;
            case C2113R.id.tv_payment_type /* 2131297634 */:
                startActivityForResult(new Intent(this, (Class<?>) PaymentTypeActivity.class), 100);
                break;
            case C2113R.id.tv_suspect_type /* 2131297741 */:
                showTypePiker(this.mAccountTypeList, this.mTvSuspectType, this.mGroupSuspect);
                break;
            case C2113R.id.tv_time /* 2131297752 */:
                showTimePiker();
                break;
            case C2113R.id.tv_victim_type /* 2131297806 */:
                showTypePiker(this.mAccountTypeList, this.mTvVictimType, this.mGroupVictim);
                break;
        }
    }

    @Override // p388ui.activity.BasePicUploadActivity
    protected void pageFileFinish() {
        super.pageFileFinish();
        if (this.mItem != null) {
            C7331w1.m26688a("修改成功");
        } else {
            C7331w1.m26688a("添加成功");
        }
        setResult(-1);
        finish();
    }

    @Override // p388ui.activity.BasePicUploadActivity
    public void removeLocalData(int i2) {
        this.mLocalMedia.remove(i2);
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_account;
    }

    @Override // p388ui.activity.BasePicUploadActivity
    public String upLoadFileUrl() {
        return C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17104l1);
    }
}
