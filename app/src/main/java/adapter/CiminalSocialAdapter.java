package adapter;

import bean.CriminalSocialBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.C2113R;
import java.util.List;

/* loaded from: classes.dex */
public class CiminalSocialAdapter extends BaseQuickAdapter<CriminalSocialBean, BaseViewHolder> {

    /* renamed from: V */
    private boolean f191V;

    public CiminalSocialAdapter(int i2, List<CriminalSocialBean> list) {
        super(i2, list);
        this.f191V = false;
    }

    /* renamed from: k */
    public void m228k(boolean z) {
        this.f191V = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo204a(BaseViewHolder baseViewHolder, CriminalSocialBean criminalSocialBean) {
        String platformText = criminalSocialBean.getPlatformText();
        String suspectAccount = criminalSocialBean.getSuspectAccount();
        baseViewHolder.m5211a(C2113R.id.tv_name, (CharSequence) platformText);
        baseViewHolder.m5211a(C2113R.id.tv_acc_num, (CharSequence) suspectAccount);
        baseViewHolder.m5194a(C2113R.id.iv_edit);
        baseViewHolder.m5194a(C2113R.id.iv_delete);
        baseViewHolder.m5194a(C2113R.id.cl_item);
        if (this.f191V) {
            baseViewHolder.m5224c(C2113R.id.iv_edit).setVisibility(8);
            baseViewHolder.m5224c(C2113R.id.iv_delete).setVisibility(8);
            baseViewHolder.m5224c(C2113R.id.iv_arrow).setVisibility(0);
        }
    }
}
