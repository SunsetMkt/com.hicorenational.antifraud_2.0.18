package p388ui.activity;

import adapter.SmsPictureAdapter;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.BrandBean;
import bean.CriminalSmsBean;
import bean.SmsBean;
import bean.SmsPictureBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.C2113R;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import interfaces.IClickListener;
import interfaces.PermissionsListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import manager.AccountManager;
import p023b.p024a.p025a.p027e.C0923i;
import p357j.C5846e;
import p388ui.callview.CriminalSmsAddCallView;
import p388ui.presenter.CriminalSmsAddPresenter;
import util.C7257b1;
import util.C7277f1;
import util.C7292k1;
import util.C7301n1;
import util.C7304o1;
import util.C7319s1;
import util.C7331w1;
import util.permissionutil.C7308a;
import util.permissionutil.C7310c;

/* loaded from: classes2.dex */
public class CriminalSmsSelectActivity extends BaseActivity implements CriminalSmsAddCallView, SmsPictureAdapter.InterfaceC0074b, BaseQuickAdapter.InterfaceC1895i {
    private SmsPictureAdapter mAdapter;

    @BindView(C2113R.id.confirm)
    TextView mBtnCommit;
    private String mCaseInfoId;

    @BindView(C2113R.id.et_phone)
    EditText mEtPhone;

    @BindView(C2113R.id.tv_victim_phone)
    EditText mEtVictimPhone;

    @BindView(C2113R.id.ll_picture)
    LinearLayout mLlPicture;
    private CriminalSmsAddPresenter mPresenter;

    @BindView(C2113R.id.rb_no)
    RadioButton mRbNo;

    @BindView(C2113R.id.rb_yes)
    RadioButton mRbYes;

    @BindView(C2113R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(C2113R.id.tv_describe)
    TextView mTvDescribe;

    @BindView(C2113R.id.tv_time)
    TextView mTvTime;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;
    private CriminalSmsBean mCriminalSmsBean = null;
    private List<CriminalSmsBean> mList = new ArrayList();
    private int mPosition = -1;
    private int mMaxSelectNum = 6;
    private List<LocalMedia> mLocalMedia = new ArrayList();
    private boolean mOnlyShow = false;

    /* renamed from: ui.activity.CriminalSmsSelectActivity$a */
    class C6264a implements CompoundButton.OnCheckedChangeListener {
        C6264a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                int id = compoundButton.getId();
                if (id == C2113R.id.rb_no) {
                    CriminalSmsSelectActivity.this.mRbYes.setChecked(false);
                } else {
                    if (id != C2113R.id.rb_yes) {
                        return;
                    }
                    CriminalSmsSelectActivity.this.mRbNo.setChecked(false);
                }
            }
        }
    }

    /* renamed from: ui.activity.CriminalSmsSelectActivity$b */
    class C6265b implements PermissionsListener {
        C6265b() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            C7310c.m26513a(CriminalSmsSelectActivity.this.mActivity, list, z, true, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            C5846e.m24617a(CriminalSmsSelectActivity.this.mActivity, 200L, PictureMimeType.ofImage(), CriminalSmsSelectActivity.this.mMaxSelectNum - CriminalSmsSelectActivity.this.mLocalMedia.size()).forResult(PictureConfig.CHOOSE_REQUEST);
        }
    }

    /* renamed from: ui.activity.CriminalSmsSelectActivity$c */
    class C6266c implements IClickListener {
        C6266c() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            CriminalSmsSelectActivity.this.showProgressDialog("提交中...");
            CriminalSmsSelectActivity.this.mPresenter.confirm(CriminalSmsSelectActivity.this.mCriminalSmsBean, CriminalSmsSelectActivity.this.mLocalMedia);
        }
    }

    private void checkPermission() {
        C7310c.m26518a(this.mActivity, new String[]{C7308a.f25521A, C7308a.f25547z}, new C6265b());
    }

    private void initRecycle() {
        this.mRecyclerview.setLayoutManager(new GridLayoutManager(this.mActivity, 3));
        this.mAdapter = new SmsPictureAdapter(C2113R.layout.recyclerview_feedback, this.mLocalMedia, this.mMaxSelectNum, this.mOnlyShow);
        this.mAdapter.m5103a(this.mRecyclerview);
        this.mAdapter.setOnItemClickListener(new SmsPictureAdapter.InterfaceC0074b() { // from class: ui.activity.c0
            @Override // adapter.SmsPictureAdapter.InterfaceC0074b
            public final void onItemClickListener(int i2, List list) {
                CriminalSmsSelectActivity.this.onItemClickListener(i2, list);
            }
        });
        this.mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.InterfaceC1895i() { // from class: ui.activity.v1
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.InterfaceC1895i
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                CriminalSmsSelectActivity.this.onItemChildClick(baseQuickAdapter, view, i2);
            }
        });
        this.mRecyclerview.setAdapter(this.mAdapter);
    }

    private void onlyShow() {
        this.mEtVictimPhone.setEnabled(false);
        this.mEtPhone.setEnabled(false);
        this.mTvDescribe.setEnabled(false);
        this.mTvTime.setCompoundDrawables(null, null, null, null);
        this.mTvTime.setEnabled(false);
        this.mRbYes.setEnabled(false);
        this.mRbNo.setEnabled(false);
        if (this.mLocalMedia.size() <= 0) {
            this.mLlPicture.setVisibility(8);
        }
        this.mBtnCommit.setVisibility(8);
    }

    public void confirm() {
        String obj = this.mEtPhone.getText().toString();
        String charSequence = this.mTvDescribe.getText().toString();
        if (this.mEtVictimPhone.length() == 0) {
            C7331w1.m26688a("请输入接收短信号码");
            return;
        }
        if (TextUtils.isEmpty(obj)) {
            C7331w1.m26688a("请输入涉诈短信号码");
            return;
        }
        if (this.mTvTime.length() == 0) {
            C7331w1.m26688a("请选择涉诈短信接收时间");
            return;
        }
        if (TextUtils.isEmpty(charSequence)) {
            C7331w1.m26688a("请输入涉诈短信内容");
            return;
        }
        if (this.mCriminalSmsBean == null) {
            this.mCriminalSmsBean = new CriminalSmsBean();
        }
        this.mCriminalSmsBean.setCaseInfoID(this.mCaseInfoId);
        this.mCriminalSmsBean.setVictimMobile(this.mEtVictimPhone.getText().toString());
        this.mCriminalSmsBean.setSuspectMobile(obj);
        this.mCriminalSmsBean.setDeliveryTime(this.mTvTime.getText().toString());
        this.mCriminalSmsBean.setContent(charSequence);
        this.mCriminalSmsBean.setVictimMobile(this.mEtVictimPhone.getText().toString());
        this.mCriminalSmsBean.setDeliveryTime(this.mTvTime.getText().toString());
        this.mCriminalSmsBean.setIsInput(2);
        List<CriminalSmsBean> list = this.mList;
        if (list == null) {
            this.mList = new ArrayList();
            this.mList.add(this.mCriminalSmsBean);
        } else if (this.mPosition < 0) {
            list.add(this.mCriminalSmsBean);
        }
        if (this.mRbYes.isChecked()) {
            this.mCriminalSmsBean.setSmsType(2);
            this.mCriminalSmsBean.setSmsTypeText("彩信");
        } else {
            this.mCriminalSmsBean.setSmsType(1);
            this.mCriminalSmsBean.setSmsTypeText("短信");
        }
        if (this.mList.size() == 0) {
            C7331w1.m26688a("还没有填写信息");
        } else if (TextUtils.equals(obj, AccountManager.getVisiblePhone())) {
            C7257b1.m26184a(this.mActivity, "添加的涉诈短信中包含您的登录号码，确定添加个人发送短信为涉诈短信？", "", "取消", "确定", C2113R.color._A8B4F7, C2113R.color.blue, true, (IClickListener) new C6266c());
        } else {
            showProgressDialog("提交中...");
            this.mPresenter.confirm(this.mCriminalSmsBean, this.mLocalMedia);
        }
    }

    public void deleteDoubleElement(List<LocalMedia> list, List<LocalMedia> list2, LocalMedia localMedia) {
        if (list == null) {
            list = new ArrayList<>();
        }
        if (list2 == null || (list2.size() <= 0 && localMedia != null)) {
            list2 = new ArrayList<>();
            list2.add(localMedia);
        }
        Iterator<LocalMedia> it = list2.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            LocalMedia next = it.next();
            if (list.size() > 0) {
                for (LocalMedia localMedia2 : list) {
                    if (!next.getPath().equals(localMedia2.getPath())) {
                        if (Build.VERSION.SDK_INT > 28) {
                            try {
                                String path = localMedia2.getPath();
                                String path2 = next.getPath();
                                if (C7304o1.m26466a(new File(path)).equals(C7304o1.m26466a(new File(path2)))) {
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    z = true;
                }
                if (!z) {
                    next.setChecked(true);
                    list.add(next);
                }
            } else {
                next.setChecked(true);
                list.add(next);
            }
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            LocalMedia localMedia3 = list.get(i2);
            if (localMedia3.isChecked()) {
                localMedia3.setChecked(false);
            }
        }
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        this.mTvTitle.setText("涉诈短信详情");
        this.mPresenter = new CriminalSmsAddPresenter(this.mActivity, this);
        try {
            this.mCaseInfoId = getIntent().getStringExtra(C7292k1.f25338C0);
            this.mOnlyShow = getIntent().getBooleanExtra(C7292k1.f25394d, false);
            this.mList = (List) getIntent().getSerializableExtra(C7292k1.f25391c);
            this.mPosition = getIntent().getIntExtra(C7292k1.f25397e, -1);
            SmsBean smsBean = (SmsBean) getIntent().getSerializableExtra(C7292k1.f25388b);
            if (this.mList != null && this.mPosition >= 0 && this.mPosition < this.mList.size()) {
                this.mCriminalSmsBean = this.mList.get(this.mPosition);
            } else if (smsBean != null) {
                this.mCriminalSmsBean = new CriminalSmsBean();
                this.mCriminalSmsBean.setVictimMobile(smsBean.getVictimTel());
                this.mCriminalSmsBean.setSuspectMobile(smsBean.getSmsNum());
                this.mCriminalSmsBean.setContent(smsBean.getSmsContent());
                this.mCriminalSmsBean.setDeliveryTime(smsBean.getStringDate().substring(0, r3.length() - 3));
                this.mCriminalSmsBean.setIsInput(2);
                this.mCriminalSmsBean.setIndex(smsBean.getIndex());
                if (!TextUtils.isEmpty(smsBean.getFileUri())) {
                    this.mCriminalSmsBean.setSmsType(2);
                    this.mCriminalSmsBean.setSmsTypeText("彩信");
                    C7301n1.m26457b("tempPath", "彩信==>" + C7277f1.m26346a(this.mActivity, smsBean.getFileUri()));
                    String m25367a = SmsRecordSelectActivity.m25367a(this.mActivity, smsBean.getFileUri(), smsBean.getType());
                    smsBean.setSmsFilePath(m25367a);
                    LocalMedia localMedia = new LocalMedia();
                    localMedia.setPath(m25367a);
                    this.mLocalMedia.add(localMedia);
                    this.mRbYes.setChecked(true);
                    this.mRbNo.setChecked(false);
                    this.mRbNo.setEnabled(false);
                }
            }
            if (this.mCriminalSmsBean != null) {
                if (this.mCriminalSmsBean.getIsInput() == 2) {
                    this.mEtPhone.setEnabled(false);
                    this.mTvTime.setEnabled(false);
                    this.mTvTime.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.mTvDescribe.setEnabled(false);
                    this.mEtPhone.setTextColor(getResources().getColor(C2113R.color.colorGray));
                    this.mTvTime.setTextColor(getResources().getColor(C2113R.color.colorGray));
                    this.mTvDescribe.setTextColor(getResources().getColor(C2113R.color.colorGray));
                }
                String victimMobile = this.mCriminalSmsBean.getVictimMobile();
                String suspectMobile = this.mCriminalSmsBean.getSuspectMobile();
                String deliveryTime = this.mCriminalSmsBean.getDeliveryTime();
                String content = this.mCriminalSmsBean.getContent();
                if (!TextUtils.isEmpty(victimMobile)) {
                    this.mEtVictimPhone.setText(victimMobile);
                }
                if (!TextUtils.isEmpty(suspectMobile)) {
                    this.mEtPhone.setText(suspectMobile);
                }
                if (!TextUtils.isEmpty(deliveryTime)) {
                    this.mTvTime.setText(deliveryTime);
                }
                if (!TextUtils.isEmpty(content)) {
                    this.mTvDescribe.setText(content);
                }
                List<SmsPictureBean> smsDetails = this.mCriminalSmsBean.getSmsDetails();
                if (smsDetails != null && smsDetails.size() > 0) {
                    for (int i2 = 0; i2 < smsDetails.size(); i2++) {
                        SmsPictureBean smsPictureBean = smsDetails.get(i2);
                        LocalMedia localMedia2 = new LocalMedia();
                        localMedia2.setPath(smsPictureBean.getLocalPath());
                        localMedia2.setCompressPath(smsPictureBean.getFilePath());
                        localMedia2.setOriginalPath(smsPictureBean.getSmsDetailID());
                        this.mLocalMedia.add(localMedia2);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.mCriminalSmsBean == null) {
            this.mCriminalSmsBean = new CriminalSmsBean();
        }
        initRecycle();
        C6264a c6264a = new C6264a();
        this.mRbYes.setOnCheckedChangeListener(c6264a);
        this.mRbNo.setOnCheckedChangeListener(c6264a);
        if (this.mCriminalSmsBean.getSmsType() == 2) {
            this.mRbYes.setChecked(true);
        } else {
            this.mRbNo.setChecked(true);
        }
        if (this.mOnlyShow) {
            onlyShow();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        List<LocalMedia> obtainMultipleResult;
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1 || i2 != 188 || (obtainMultipleResult = PictureSelector.obtainMultipleResult(intent)) == null || obtainMultipleResult.size() <= 0) {
            return;
        }
        if (Build.VERSION.SDK_INT > 28) {
            changePath(obtainMultipleResult);
        }
        deleteDoubleElement(this.mLocalMedia, obtainMultipleResult, null);
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.InterfaceC1895i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        List<SmsPictureBean> smsDetails;
        if (view.getId() != C2113R.id.iv_clear) {
            return;
        }
        CriminalSmsBean criminalSmsBean = this.mCriminalSmsBean;
        if (criminalSmsBean != null && (smsDetails = criminalSmsBean.getSmsDetails()) != null && smsDetails.size() > 0 && smsDetails.size() > i2) {
            smsDetails.remove(i2);
        }
        this.mLocalMedia.remove(i2);
        baseQuickAdapter.notifyDataSetChanged();
    }

    @Override // adapter.SmsPictureAdapter.InterfaceC0074b
    public void onItemClickListener(int i2, List<LocalMedia> list) {
        if (isDouble()) {
            return;
        }
        ArrayList<? extends Parcelable> arrayList = (ArrayList) list;
        if (i2 == arrayList.size()) {
            checkPermission();
            return;
        }
        String path = ((LocalMedia) arrayList.get(i2)).getPath();
        Intent intent = new Intent(this, (Class<?>) PreviewPictureActivity.class);
        intent.putParcelableArrayListExtra(PreviewPictureActivity.f22711f, arrayList);
        intent.putExtra(PreviewPictureActivity.f22712g, i2);
        intent.putExtra(PreviewPictureActivity.f22713h, arrayList.size());
        intent.putExtra(PreviewPictureActivity.f22714i, path);
        startActivityForResult(intent, 1000);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        hideProgressDialog();
    }

    @Override // p388ui.callview.CriminalSmsAddCallView
    public void onSuccessBrand(List<BrandBean> list, C0923i.b<BrandBean> bVar) {
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.tv_time, C2113R.id.confirm})
    public void onViewClicked(View view) {
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == C2113R.id.confirm) {
            confirm();
        } else if (id == C2113R.id.iv_back) {
            onBackPressed();
        } else {
            if (id != C2113R.id.tv_time) {
                return;
            }
            C7319s1.m26565a(this.mActivity, this.mTvTime);
        }
    }

    @Override // p388ui.callview.CriminalSmsAddCallView
    public void onfail() {
        hideProgressDialog();
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_criminal_sms_select;
    }
}
