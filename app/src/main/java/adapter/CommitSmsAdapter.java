package adapter;

import android.text.TextUtils;
import bean.CriminalSmsBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.R;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CommitSmsAdapter extends BaseQuickAdapter<CriminalSmsBean, BaseViewHolder> {
    public CommitSmsAdapter(List<CriminalSmsBean> list) {
        super(R.layout.recyclerview_commit_sms, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(BaseViewHolder baseViewHolder, CriminalSmsBean criminalSmsBean) {
        String content = criminalSmsBean.getContent();
        if (criminalSmsBean.getSmsType() == 2 && TextUtils.isEmpty(content)) {
            content = "[\u56fe\u7247]";
        }
        if (criminalSmsBean.getSmsType() == 4) {
            baseViewHolder.c(R.id.tv_sms_phone, false).c(R.id.tv_tag, false);
        } else {
            baseViewHolder.c(R.id.tv_sms_phone, true).c(R.id.tv_tag, true).a(R.id.tv_sms_phone, (CharSequence) ("\u6d89\u8bc8\u77ed\u4fe1\u53f7\u7801\uff1a" + criminalSmsBean.getSuspectMobile())).a(R.id.tv_tag, (CharSequence) criminalSmsBean.getSuspectMobileTypeText());
        }
        baseViewHolder.a(R.id.tv_sms_content, (CharSequence) content);
        baseViewHolder.a(R.id.tv_type_sms, (CharSequence) criminalSmsBean.getSmsTypeText()).a(R.id.tv_victim_phone, (CharSequence) ("\u63a5\u6536\u77ed\u4fe1\u53f7\u7801\uff1a" + criminalSmsBean.getVictimMobile())).a(R.id.tv_time, (CharSequence) criminalSmsBean.getDeliveryTime());
    }
}
