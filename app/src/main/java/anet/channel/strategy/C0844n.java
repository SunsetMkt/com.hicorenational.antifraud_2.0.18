package anet.channel.strategy;

import java.io.File;
import java.util.Comparator;

/* compiled from: Taobao */
/* renamed from: anet.channel.strategy.n */
/* loaded from: classes.dex */
final class C0844n implements Comparator<File> {
    C0844n() {
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(File file, File file2) {
        return (int) (file2.lastModified() - file.lastModified());
    }
}
