package adapter;

import bean.RelationBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.C2113R;
import java.util.List;

/* loaded from: classes.dex */
public class RelationAdapter extends BaseQuickAdapter<RelationBean, BaseViewHolder> {

    /* renamed from: V */
    private List<RelationBean> f253V;

    /* renamed from: W */
    private boolean f254W;

    public RelationAdapter(int i2, List<RelationBean> list) {
        super(i2, list);
        this.f253V = list;
        this.f254W = false;
    }

    /* renamed from: k */
    public void m265k(boolean z) {
        this.f254W = z;
    }

    /* renamed from: m */
    public void m266m(int i2) {
        this.f253V.remove(i2);
        notifyDataSetChanged();
    }

    /* renamed from: a */
    public void m264a(List<RelationBean> list) {
        this.f253V.clear();
        this.f253V.addAll(list);
        notifyDataSetChanged();
    }

    /* renamed from: a */
    public void m263a(int i2, RelationBean relationBean) {
        this.f253V.set(i2, relationBean);
        notifyItemChanged(i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo204a(BaseViewHolder baseViewHolder, RelationBean relationBean) {
        String platformText = relationBean.getPlatformText();
        String suspectMobile = relationBean.getSuspectMobile();
        baseViewHolder.m5211a(C2113R.id.tv_name, (CharSequence) platformText);
        baseViewHolder.m5211a(C2113R.id.tv_acc_num, (CharSequence) suspectMobile);
        baseViewHolder.m5194a(C2113R.id.iv_edit);
        baseViewHolder.m5194a(C2113R.id.iv_delete);
        baseViewHolder.m5194a(C2113R.id.cl_item);
        if (this.f254W) {
            baseViewHolder.m5224c(C2113R.id.iv_edit).setVisibility(8);
            baseViewHolder.m5224c(C2113R.id.iv_delete).setVisibility(8);
            baseViewHolder.m5224c(C2113R.id.iv_arrow).setVisibility(0);
        }
    }
}
