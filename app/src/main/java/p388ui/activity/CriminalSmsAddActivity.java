package p388ui.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import bean.BrandBean;
import bean.CriminalSmsBean;
import bean.SmsPictureBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.C2113R;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import interfaces.PermissionsListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p023b.p024a.p025a.p027e.C0923i;
import p357j.C5846e;
import p388ui.callview.CriminalSmsAddCallView;
import p388ui.fragment.AddSmsFourFragment;
import p388ui.fragment.AddSmsOneFragment;
import p388ui.fragment.AddSmsThreeFragment;
import p388ui.fragment.AddSmsTwoFragment;
import p388ui.presenter.CriminalSmsAddPresenter;
import util.C7292k1;
import util.C7304o1;
import util.C7319s1;
import util.permissionutil.C7308a;
import util.permissionutil.C7310c;

/* loaded from: classes2.dex */
public class CriminalSmsAddActivity extends BaseActivity implements CriminalSmsAddCallView {
    public static final int FRAGMENT_SMS_FOUR = 3;
    public static final int FRAGMENT_SMS_ONE = 0;
    public static final int FRAGMENT_SMS_THREE = 2;
    public static final int FRAGMENT_SMS_TWO = 1;
    private String mCaseInfoId;
    private AddSmsFourFragment mFragmentFour;
    private AddSmsOneFragment mFragmentOne;
    private AddSmsThreeFragment mFragmentThree;
    private AddSmsTwoFragment mFragmentTwo;
    private CriminalSmsAddPresenter mPresenter;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;

    @BindView(C2113R.id.tv_type)
    TextView mTvType;
    public final int mMaxSelectNum = 6;
    private CriminalSmsBean mCriminalSmsBean = null;
    private CriminalSmsBean mChildBean = null;
    private List<CriminalSmsBean> mList = new ArrayList();
    private int mPosition = -1;
    private List<LocalMedia> mLocalMedia = new ArrayList();
    private int mCurrentFragmentPosition = 0;
    private List<BrandBean> mBrandList = new ArrayList();
    private List<String> mBrandStrList = new ArrayList();
    private boolean mOnlyShow = false;
    public String[] strs = {"短信", "彩信", "iMessage", "IP短信"};

    /* renamed from: ui.activity.CriminalSmsAddActivity$a */
    class C6259a implements C0923i.b<String> {

        /* renamed from: a */
        final /* synthetic */ TextView f22199a;

        C6259a(TextView textView) {
            this.f22199a = textView;
        }

        @Override // p023b.p024a.p025a.p027e.C0923i.b
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo970a(int i2, String str) {
            TextView textView = this.f22199a;
            if (textView != null) {
                textView.setText(str);
            }
            CriminalSmsAddActivity.this.changeFragment(i2);
        }
    }

    /* renamed from: ui.activity.CriminalSmsAddActivity$b */
    class C6260b implements PermissionsListener {
        C6260b() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            C7310c.m26513a(CriminalSmsAddActivity.this.mActivity, list, z, true, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            C5846e.m24617a(CriminalSmsAddActivity.this.mActivity, 200L, PictureMimeType.ofImage(), 6 - CriminalSmsAddActivity.this.mLocalMedia.size()).forResult(PictureConfig.CHOOSE_REQUEST);
        }
    }

    /* renamed from: ui.activity.CriminalSmsAddActivity$c */
    class C6261c implements C0923i.b<String> {

        /* renamed from: a */
        final /* synthetic */ C0923i.b f22202a;

        C6261c(C0923i.b bVar) {
            this.f22202a = bVar;
        }

        @Override // p023b.p024a.p025a.p027e.C0923i.b
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo970a(int i2, String str) {
            C0923i.b bVar = this.f22202a;
            if (bVar != null) {
                bVar.mo970a(i2, CriminalSmsAddActivity.this.mBrandList.get(i2));
            }
        }
    }

    private void brandDialog(C0923i.b<BrandBean> bVar) {
        C7319s1.m26567a(this.mActivity, this.mBrandStrList, new C6261c(bVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeFragment(int i2) {
        if (i2 == 0) {
            showFragmentOne();
            return;
        }
        if (i2 == 1) {
            showFragmentTwo();
            return;
        }
        if (i2 == 2) {
            showFragmentThree();
        } else {
            if (i2 != 3) {
                return;
            }
            showFragmentFour();
            this.mPresenter.brandHttp(null);
        }
    }

    private void checkPermission() {
        C7310c.m26518a(this.mActivity, new String[]{C7308a.f25547z}, new C6260b());
    }

    private void initFragment() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        this.mFragmentOne = (AddSmsOneFragment) supportFragmentManager.findFragmentByTag("0");
        if (this.mFragmentOne == null) {
            this.mFragmentOne = new AddSmsOneFragment();
            supportFragmentManager.beginTransaction().add(C2113R.id.fl_fragment, this.mFragmentOne, "0").commit();
        }
        this.mLocalMedia = this.mFragmentOne.m25545f();
        this.mCurrentFragmentPosition = 0;
    }

    private void showFragmentFour() {
        if (this.mFragmentFour == null) {
            this.mFragmentFour = new AddSmsFourFragment();
        }
        switchFragment(this.mFragmentFour, "3");
        this.mLocalMedia = this.mFragmentFour.m25536e();
        this.mCurrentFragmentPosition = 3;
    }

    private void showFragmentOne() {
        if (this.mFragmentOne == null) {
            this.mFragmentOne = new AddSmsOneFragment();
        }
        switchFragment(this.mFragmentOne, "0");
        this.mLocalMedia = this.mFragmentOne.m25545f();
        this.mCurrentFragmentPosition = 0;
    }

    private void showFragmentThree() {
        if (this.mFragmentThree == null) {
            this.mFragmentThree = new AddSmsThreeFragment();
        }
        switchFragment(this.mFragmentThree, "2");
        this.mLocalMedia = this.mFragmentThree.m25552e();
        this.mCurrentFragmentPosition = 2;
    }

    private void showFragmentTwo() {
        if (this.mFragmentTwo == null) {
            this.mFragmentTwo = new AddSmsTwoFragment();
        }
        switchFragment(this.mFragmentTwo, "1");
        this.mLocalMedia = this.mFragmentTwo.m25561f();
        this.mCurrentFragmentPosition = 1;
    }

    private void switchFragment(Fragment fragment, String str) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(C2113R.id.fl_fragment, fragment, str);
        beginTransaction.commit();
    }

    public void brandPick(C0923i.b<BrandBean> bVar) {
        if (this.mBrandStrList.size() <= 0) {
            this.mPresenter.brandHttp(bVar);
        } else {
            brandDialog(bVar);
        }
    }

    public void confirm(CriminalSmsBean criminalSmsBean) {
        showProgressDialog("提交中...");
        this.mChildBean.setCaseInfoID(this.mCaseInfoId);
        this.mPresenter.confirm(this.mChildBean, this.mLocalMedia);
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

    public CriminalSmsBean getCriminalSmsBean() {
        return this.mCriminalSmsBean;
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        this.mTvTitle.setText("涉诈短信详情");
        this.mPresenter = new CriminalSmsAddPresenter(this.mActivity, this);
        try {
            this.mCaseInfoId = getIntent().getStringExtra(C7292k1.f25338C0);
            this.mList = (List) getIntent().getSerializableExtra(C7292k1.f25391c);
            this.mPosition = getIntent().getIntExtra(C7292k1.f25397e, -1);
            this.mOnlyShow = getIntent().getBooleanExtra(C7292k1.f25394d, false);
            if (this.mList != null && this.mPosition >= 0 && this.mPosition < this.mList.size()) {
                this.mCriminalSmsBean = this.mList.get(this.mPosition);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.mCriminalSmsBean == null) {
            this.mCriminalSmsBean = new CriminalSmsBean();
            this.mCriminalSmsBean.setSmsType(1);
            this.mCriminalSmsBean.setSmsTypeText(this.strs[0]);
            this.mTvType.setText(this.strs[0]);
        }
        initFragment();
        CriminalSmsBean criminalSmsBean = this.mCriminalSmsBean;
        if (criminalSmsBean != null) {
            this.mTvType.setText(this.strs[criminalSmsBean.getSmsType() - 1]);
            changeFragment(this.mCriminalSmsBean.getSmsType() - 1);
        }
        if (this.mOnlyShow) {
            this.mTvType.setCompoundDrawables(null, null, null, null);
            this.mTvType.setEnabled(false);
        }
    }

    public boolean isOnlyShow() {
        return this.mOnlyShow;
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
        int i4 = this.mCurrentFragmentPosition;
        if (i4 == 0) {
            this.mFragmentOne.m25546g();
            return;
        }
        if (i4 == 1) {
            this.mFragmentTwo.m25562g();
        } else if (i4 == 2) {
            this.mFragmentThree.m25553f();
        } else {
            if (i4 != 3) {
                return;
            }
            this.mFragmentFour.m25537f();
        }
    }

    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        List<SmsPictureBean> smsDetails;
        if (view.getId() != C2113R.id.iv_clear) {
            return;
        }
        CriminalSmsBean criminalSmsBean = this.mChildBean;
        if (criminalSmsBean != null && (smsDetails = criminalSmsBean.getSmsDetails()) != null && smsDetails.size() > 0 && smsDetails.size() > i2) {
            smsDetails.remove(i2);
        }
        this.mLocalMedia.remove(i2);
        baseQuickAdapter.notifyDataSetChanged();
    }

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
        this.mBrandList.clear();
        this.mBrandList.addAll(list);
        Iterator<BrandBean> it = this.mBrandList.iterator();
        while (it.hasNext()) {
            this.mBrandStrList.add(it.next().getOsBrandTypeText());
        }
        this.mFragmentFour.m25534a(this.mBrandList);
        if (bVar == null) {
            return;
        }
        brandDialog(bVar);
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.tv_type})
    public void onViewClicked(View view) {
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == C2113R.id.iv_back) {
            onBackPressed();
        } else {
            if (id != C2113R.id.tv_type) {
                return;
            }
            pickData(this.mTvType);
        }
    }

    @Override // p388ui.callview.CriminalSmsAddCallView
    public void onfail() {
        hideProgressDialog();
    }

    public void pickData(TextView textView) {
        C7319s1.m26568a(this.mActivity, this.strs, new C6259a(textView));
    }

    public void setChildBean(CriminalSmsBean criminalSmsBean) {
        this.mChildBean = criminalSmsBean;
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_criminal_sms_add;
    }
}
