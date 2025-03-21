package com.vivo.push.p237f;

import com.vivo.push.AbstractC4016v;
import com.vivo.push.C3924m;
import com.vivo.push.C3975t;
import com.vivo.push.p232b.C3848t;
import com.vivo.push.util.C4010u;
import java.util.ArrayList;
import java.util.List;

/* compiled from: OnSetTagsReceiveTask.java */
/* renamed from: com.vivo.push.f.ab */
/* loaded from: classes2.dex */
final class C3883ab extends AbstractC3882aa {
    C3883ab(AbstractC4016v abstractC4016v) {
        super(abstractC4016v);
    }

    @Override // com.vivo.push.AbstractRunnableC3971s
    /* renamed from: a */
    protected final void mo12952a(AbstractC4016v abstractC4016v) {
        C3848t c3848t = (C3848t) abstractC4016v;
        ArrayList<String> m12878d = c3848t.m12878d();
        List<String> m12879e = c3848t.m12879e();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int m12877i = c3848t.m12877i();
        C4010u.m13306c("OnSetTagsTask", "doTask,删除成功的标签 = " + m12878d + " 删除失败的= " + m12879e + " 错误码= " + m12877i);
        String m12876h = c3848t.m12876h();
        if (m12878d != null) {
            for (String str : m12878d) {
                if (str.startsWith("ali/")) {
                    arrayList2.add(str.replace("ali/", ""));
                } else if (str.startsWith("tag/")) {
                    arrayList.add(str.replace("tag/", ""));
                }
            }
        }
        if (m12879e != null) {
            for (String str2 : m12879e) {
                if (str2.startsWith("ali/")) {
                    arrayList4.add(str2.replace("ali/", ""));
                } else if (str2.startsWith("tag/")) {
                    arrayList3.add(str2.replace("tag/", ""));
                }
            }
        }
        if (arrayList.size() > 0 || arrayList3.size() > 0) {
            C4010u.m13306c("OnSetTagsTask", "doTask1,订阅成功的标签 = " + arrayList + " 订阅失败的标签= " + arrayList3 + " 错误码= " + m12877i);
            if (arrayList.size() > 0) {
                C3924m.m13016a();
                C3924m.m13020a(arrayList);
            }
            C3924m.m13016a().m13034a(c3848t.m12876h(), m12877i);
            C3975t.m13170b(new RunnableC3884ac(this, m12877i, arrayList, arrayList3, m12876h));
        }
        if (arrayList2.size() > 0 || arrayList4.size() > 0) {
            C4010u.m13306c("OnSetTagsTask", "doTask1,订阅成功的别名 = " + arrayList + " 订阅失败的别名= " + arrayList3 + " 错误码= " + m12877i);
            if (arrayList2.size() > 0) {
                C3924m.m13016a().m13033a((String) arrayList2.get(0));
            }
            C3924m.m13016a().m13034a(c3848t.m12876h(), m12877i);
            C3975t.m13170b(new RunnableC3885ad(this, m12877i, arrayList2, arrayList4, m12876h));
        }
    }
}
