package com.taobao.accs.data;

import java.util.Comparator;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class b implements Comparator<Integer> {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a */
    public int compare(Integer num, Integer num2) {
        return num.intValue() - num2.intValue();
    }
}
