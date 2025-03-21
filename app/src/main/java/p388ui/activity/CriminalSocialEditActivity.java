package p388ui.activity;

import adapter.SmsPictureAdapter;
import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.CriminalSocialBean;
import bean.CriminalSocialFileBean;
import bean.CriminalSocialTypeBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.C2113R;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.zhy.view.flowlayout.AbstractC4439b;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagFlowLayout;
import interfaces.PermissionsListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import p357j.C5846e;
import p388ui.callview.CriminalSocialEditCallView;
import p388ui.presenter.CriminalSocialEditPresenter;
import util.C7292k1;
import util.C7304o1;
import util.C7331w1;
import util.C7337y1;
import util.permissionutil.C7308a;
import util.permissionutil.C7310c;

/* loaded from: classes2.dex */
public class CriminalSocialEditActivity extends BaseActivity implements CriminalSocialEditCallView, SmsPictureAdapter.InterfaceC0074b, BaseQuickAdapter.InterfaceC1895i {
    private SmsPictureAdapter mAdapter;
    private CriminalSocialBean mBean;

    @BindView(C2113R.id.btn_commit)
    Button mBtnCommit;

    @BindView(C2113R.id.et_account)
    EditText mEtAccount;

    @BindView(C2113R.id.et_account_other)
    EditText mEtAccountOther;

    @BindView(C2113R.id.et_tag_other)
    EditText mEtTagOther;

    @BindView(C2113R.id.flow_layout)
    TagFlowLayout mFlowLayout;

    @BindView(C2113R.id.v_flow_uncheck)
    View mFlowUncheck;

    @BindView(C2113R.id.ll_acc_nomar)
    View mLlAccNorm;

    @BindView(C2113R.id.ll_acc_other)
    View mLlAccOther;

    @BindView(C2113R.id.ll_picture)
    LinearLayout mLlPicture;
    private CriminalSocialEditPresenter mPresenter;

    @BindView(C2113R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(C2113R.id.tv_account_label)
    TextView mTvAccountLabel;

    @BindView(C2113R.id.tv_account_other_label)
    TextView mTvAccountOtherLabel;

    @BindView(C2113R.id.tv_tag_other_label)
    TextView mTvTagOtherLabel;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;
    private int pos;
    private AbstractC4439b mTagAdapter = null;
    private CriminalSocialTypeBean mTypeBean = new CriminalSocialTypeBean();
    private List<CriminalSocialTypeBean> mTypeList = new ArrayList();
    private String mCaseInfoId = "";
    private int mMaxSelectNum = 6;
    private List<LocalMedia> mLocalMedia = new ArrayList();
    private boolean mOnlyShow = false;

    /* renamed from: ui.activity.CriminalSocialEditActivity$a */
    class C6274a extends AbstractC4439b<CriminalSocialTypeBean> {
        C6274a(List list) {
            super(list);
        }

        @Override // com.zhy.view.flowlayout.AbstractC4439b
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public View mo16383a(FlowLayout flowLayout, int i2, CriminalSocialTypeBean criminalSocialTypeBean) {
            TextView textView = (TextView) LayoutInflater.from(CriminalSocialEditActivity.this.mActivity).inflate(C2113R.layout.tag_flow, (ViewGroup) CriminalSocialEditActivity.this.mFlowLayout, false);
            textView.setText(((CriminalSocialTypeBean) CriminalSocialEditActivity.this.mTypeList.get(i2)).getPlatformText());
            textView.setTextColor(CriminalSocialEditActivity.this.getResources().getColorStateList(C2113R.color.text_choose_one));
            return textView;
        }
    }

    /* renamed from: ui.activity.CriminalSocialEditActivity$b */
    class C6275b implements PermissionsListener {
        C6275b() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            C7310c.m26513a(CriminalSocialEditActivity.this.mActivity, list, z, true, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            C5846e.m24617a(CriminalSocialEditActivity.this.mActivity, 200L, PictureMimeType.ofImage(), CriminalSocialEditActivity.this.mMaxSelectNum - CriminalSocialEditActivity.this.mLocalMedia.size()).forResult(PictureConfig.CHOOSE_REQUEST);
        }
    }

    private void change(CriminalSocialTypeBean criminalSocialTypeBean, CriminalSocialBean criminalSocialBean) {
        int ex = criminalSocialTypeBean.getEx();
        if (ex == 1) {
            this.mLlAccOther.setVisibility(0);
            this.mLlAccNorm.setVisibility(8);
            this.mTvTagOtherLabel.setText("平台名称");
            this.mEtTagOther.setHint("请输入平台名称");
            this.mTvAccountOtherLabel.setText("平台账号");
            this.mEtAccountOther.setHint("请输入平台账号");
            if (criminalSocialBean != null) {
                this.mEtTagOther.setText(criminalSocialBean.getPlatformText());
                this.mEtAccountOther.setText(criminalSocialBean.getSuspectAccount());
                return;
            }
            return;
        }
        if (ex == 2) {
            this.mLlAccOther.setVisibility(0);
            this.mLlAccNorm.setVisibility(8);
            this.mTvTagOtherLabel.setText("公众号/服务号名称");
            this.mEtTagOther.setHint("请输入公众号/服务号名称");
            this.mTvAccountOtherLabel.setText("公众号/服务号账号");
            this.mEtAccountOther.setHint("请输入公众号/服务号账号");
            if (criminalSocialBean != null) {
                this.mEtTagOther.setText(criminalSocialBean.getPlatformText());
                this.mEtAccountOther.setText(criminalSocialBean.getSuspectAccount());
                return;
            }
            return;
        }
        this.mLlAccOther.setVisibility(8);
        this.mLlAccNorm.setVisibility(0);
        this.mTvAccountLabel.setText(criminalSocialTypeBean.getPlatformText() + "账号");
        this.mEtAccount.setHint("请输入账号");
        if (criminalSocialBean != null) {
            this.mEtAccount.setText(criminalSocialBean.getSuspectAccount());
        }
    }

    private void checkPermission() {
        C7310c.m26518a(this.mActivity, new String[]{C7308a.f25521A, C7308a.f25547z}, new C6275b());
    }

    private int contains(List<CriminalSocialTypeBean> list, String str) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (TextUtils.equals(list.get(i2).getPlatform(), str)) {
                return i2;
            }
        }
        return -10;
    }

    private String dealName(String str) {
        for (int i2 = 0; i2 < this.mTypeList.size(); i2++) {
            CriminalSocialTypeBean criminalSocialTypeBean = this.mTypeList.get(i2);
            if (str.equalsIgnoreCase(criminalSocialTypeBean.getPlatformText())) {
                String platformText = criminalSocialTypeBean.getPlatformText();
                this.mTypeBean = criminalSocialTypeBean;
                return platformText;
            }
        }
        return str;
    }

    private void getIntentData() {
        List<CriminalSocialFileBean> netAccountDetails;
        this.mCaseInfoId = getIntent().getStringExtra(C7292k1.f25338C0);
        this.pos = getIntent().getIntExtra(C7292k1.f25438v, 0);
        this.mOnlyShow = getIntent().getBooleanExtra(C7292k1.f25394d, false);
        this.mBean = (CriminalSocialBean) getIntent().getSerializableExtra(C7292k1.f25440w);
        CriminalSocialBean criminalSocialBean = this.mBean;
        if (criminalSocialBean == null || (netAccountDetails = criminalSocialBean.getNetAccountDetails()) == null || netAccountDetails.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < netAccountDetails.size(); i2++) {
            CriminalSocialFileBean criminalSocialFileBean = netAccountDetails.get(i2);
            LocalMedia localMedia = new LocalMedia();
            localMedia.setPath(criminalSocialFileBean.getLocalPath());
            localMedia.setCompressPath(criminalSocialFileBean.getFilePath());
            localMedia.setOriginalPath(criminalSocialFileBean.getNetAccountDetailInfoID());
            this.mLocalMedia.add(localMedia);
        }
    }

    private void initRecycle() {
        this.mRecyclerview.setLayoutManager(new GridLayoutManager(this.mActivity, 3));
        this.mAdapter = new SmsPictureAdapter(C2113R.layout.recyclerview_feedback, this.mLocalMedia, this.mMaxSelectNum, this.mOnlyShow);
        this.mAdapter.m5103a(this.mRecyclerview);
        this.mAdapter.setOnItemClickListener(new SmsPictureAdapter.InterfaceC0074b() { // from class: ui.activity.t0
            @Override // adapter.SmsPictureAdapter.InterfaceC0074b
            public final void onItemClickListener(int i2, List list) {
                CriminalSocialEditActivity.this.onItemClickListener(i2, list);
            }
        });
        this.mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.InterfaceC1895i() { // from class: ui.activity.y
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.InterfaceC1895i
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                CriminalSocialEditActivity.this.onItemChildClick(baseQuickAdapter, view, i2);
            }
        });
        this.mRecyclerview.setAdapter(this.mAdapter);
    }

    /* renamed from: a */
    public /* synthetic */ boolean m25239a(View view, int i2, FlowLayout flowLayout) {
        CriminalSocialTypeBean criminalSocialTypeBean = this.mTypeList.get(i2);
        change(criminalSocialTypeBean, null);
        this.mTypeBean = criminalSocialTypeBean;
        return true;
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
        this.mTvTitle.setText("添加互联网账号");
        this.mPresenter = new CriminalSocialEditPresenter(this.mActivity, this);
        getIntentData();
        if (this.mOnlyShow) {
            this.mTvTitle.setText("互联网账号详情");
            this.mBtnCommit.setVisibility(8);
            this.mEtAccount.setEnabled(false);
            this.mEtAccountOther.setEnabled(false);
            this.mEtTagOther.setEnabled(false);
            this.mFlowUncheck.setVisibility(0);
            if (this.mLocalMedia.size() <= 0) {
                this.mLlPicture.setVisibility(8);
            }
        }
        initTagAdapter();
        initRecycle();
        this.mPresenter.typeHttp();
    }

    protected void initTagAdapter() {
        this.mTagAdapter = new C6274a(this.mTypeList);
        this.mFlowLayout.setAdapter(this.mTagAdapter);
        this.mFlowLayout.setOnTagClickListener(new TagFlowLayout.InterfaceC4437c() { // from class: ui.activity.o
            @Override // com.zhy.view.flowlayout.TagFlowLayout.InterfaceC4437c
            /* renamed from: a */
            public final boolean mo16381a(View view, int i2, FlowLayout flowLayout) {
                return CriminalSocialEditActivity.this.m25239a(view, i2, flowLayout);
            }
        });
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
        List<CriminalSocialFileBean> netAccountDetails;
        if (view.getId() != C2113R.id.iv_clear) {
            return;
        }
        CriminalSocialBean criminalSocialBean = this.mBean;
        if (criminalSocialBean != null && (netAccountDetails = criminalSocialBean.getNetAccountDetails()) != null && netAccountDetails.size() > 0 && netAccountDetails.size() > i2) {
            netAccountDetails.remove(i2);
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

    @Override // p388ui.callview.CriminalSocialEditCallView
    public void onSuccessType(List<CriminalSocialTypeBean> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.mTypeList.clear();
        this.mTypeList.addAll(list);
        this.mTagAdapter.m16391c();
        CriminalSocialBean criminalSocialBean = this.mBean;
        if (criminalSocialBean == null) {
            CriminalSocialTypeBean criminalSocialTypeBean = list.get(0);
            this.mTypeBean = criminalSocialTypeBean;
            this.mTagAdapter.m16387a(0);
            change(criminalSocialTypeBean, null);
            return;
        }
        int contains = contains(list, criminalSocialBean.getPlatform());
        if (contains >= 0) {
            CriminalSocialTypeBean criminalSocialTypeBean2 = list.get(contains);
            this.mTypeBean = criminalSocialTypeBean2;
            change(criminalSocialTypeBean2, this.mBean);
            this.mTagAdapter.m16387a(contains);
            return;
        }
        int size = list.size() - 1;
        CriminalSocialTypeBean criminalSocialTypeBean3 = list.get(size);
        this.mTypeBean = criminalSocialTypeBean3;
        change(criminalSocialTypeBean3, this.mBean);
        this.mTagAdapter.m16387a(size);
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.btn_commit})
    public void onViewClicked(View view) {
        String obj;
        String obj2;
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != C2113R.id.btn_commit) {
            if (id != C2113R.id.iv_back) {
                return;
            }
            finish();
            return;
        }
        if (this.mTypeList.size() > 0) {
            int ex = this.mTypeBean.getEx();
            if (ex == 1) {
                obj = this.mEtTagOther.getText().toString();
                if (TextUtils.isEmpty(obj)) {
                    C7331w1.m26688a("请输入平台名称");
                    return;
                }
                obj2 = this.mEtAccountOther.getText().toString();
                if (TextUtils.isEmpty(obj2)) {
                    C7331w1.m26688a("请输入平台账号");
                    return;
                }
            } else if (ex != 2) {
                obj = this.mTypeBean.getPlatformText();
                obj2 = this.mEtAccount.getText().toString();
                if (TextUtils.isEmpty(obj2)) {
                    C7331w1.m26688a("请输入账号");
                    return;
                }
            } else {
                obj = this.mEtTagOther.getText().toString();
                if (TextUtils.isEmpty(obj)) {
                    C7331w1.m26688a("请输入公众号/服务号名称");
                    return;
                }
                obj2 = this.mEtAccountOther.getText().toString();
                if (TextUtils.isEmpty(obj2)) {
                    C7331w1.m26688a("请输入公众号/服务号账号");
                    return;
                }
            }
            if (C7337y1.m26796u(obj2) || obj2.contains(AbstractC1191a.f2568g)) {
                C7331w1.m26688a("账号不得纯文字、不得含空格");
                return;
            }
            if (this.mTypeBean.getEx() == 1 || this.mTypeBean.getEx() == 2) {
                dealName(obj);
            }
            CriminalSocialBean criminalSocialBean = new CriminalSocialBean();
            criminalSocialBean.setCaseInfoId(this.mCaseInfoId);
            criminalSocialBean.setPlatformText(obj);
            criminalSocialBean.setPlatform(this.mTypeBean.getPlatform());
            criminalSocialBean.setSuspectAccount(obj2);
            if (this.mBean == null) {
                showProgressDialog("提交中...");
                this.mPresenter.confirm(criminalSocialBean, this.mLocalMedia);
                return;
            }
            showProgressDialog("提交中...");
            this.mBean.setCaseInfoId(this.mCaseInfoId);
            this.mBean.setPlatformText(obj);
            this.mBean.setPlatform(this.mTypeBean.getPlatform());
            this.mBean.setSuspectAccount(obj2);
            this.mPresenter.confirm(this.mBean, this.mLocalMedia);
        }
    }

    @Override // p388ui.callview.CriminalSocialEditCallView
    public void onfail() {
        hideProgressDialog();
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_criminal_social_edit;
    }
}
