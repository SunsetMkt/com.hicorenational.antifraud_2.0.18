package androidx.recyclerview.widget;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* loaded from: classes.dex */
public class DiffUtil {
    private static final Comparator<Snake> SNAKE_COMPARATOR = new Comparator<Snake>() { // from class: androidx.recyclerview.widget.DiffUtil.1
        @Override // java.util.Comparator
        public int compare(Snake snake, Snake snake2) {
            int i2 = snake.f621x - snake2.f621x;
            return i2 == 0 ? snake.f622y - snake2.f622y : i2;
        }
    };

    public static abstract class Callback {
        public abstract boolean areContentsTheSame(int i2, int i3);

        public abstract boolean areItemsTheSame(int i2, int i3);

        @Nullable
        public Object getChangePayload(int i2, int i3) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    public static class DiffResult {
        private static final int FLAG_CHANGED = 2;
        private static final int FLAG_IGNORE = 16;
        private static final int FLAG_MASK = 31;
        private static final int FLAG_MOVED_CHANGED = 4;
        private static final int FLAG_MOVED_NOT_CHANGED = 8;
        private static final int FLAG_NOT_CHANGED = 1;
        private static final int FLAG_OFFSET = 5;
        public static final int NO_POSITION = -1;
        private final Callback mCallback;
        private final boolean mDetectMoves;
        private final int[] mNewItemStatuses;
        private final int mNewListSize;
        private final int[] mOldItemStatuses;
        private final int mOldListSize;
        private final List<Snake> mSnakes;

        DiffResult(Callback callback, List<Snake> list, int[] iArr, int[] iArr2, boolean z) {
            this.mSnakes = list;
            this.mOldItemStatuses = iArr;
            this.mNewItemStatuses = iArr2;
            Arrays.fill(this.mOldItemStatuses, 0);
            Arrays.fill(this.mNewItemStatuses, 0);
            this.mCallback = callback;
            this.mOldListSize = callback.getOldListSize();
            this.mNewListSize = callback.getNewListSize();
            this.mDetectMoves = z;
            addRootSnake();
            findMatchingItems();
        }

        private void addRootSnake() {
            Snake snake = this.mSnakes.isEmpty() ? null : this.mSnakes.get(0);
            if (snake != null && snake.f621x == 0 && snake.f622y == 0) {
                return;
            }
            Snake snake2 = new Snake();
            snake2.f621x = 0;
            snake2.f622y = 0;
            snake2.removal = false;
            snake2.size = 0;
            snake2.reverse = false;
            this.mSnakes.add(0, snake2);
        }

        private void dispatchAdditions(List<PostponedUpdate> list, ListUpdateCallback listUpdateCallback, int i2, int i3, int i4) {
            if (!this.mDetectMoves) {
                listUpdateCallback.onInserted(i2, i3);
                return;
            }
            for (int i5 = i3 - 1; i5 >= 0; i5--) {
                int i6 = i4 + i5;
                int i7 = this.mNewItemStatuses[i6] & 31;
                if (i7 == 0) {
                    listUpdateCallback.onInserted(i2, 1);
                    Iterator<PostponedUpdate> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().currentPos++;
                    }
                } else if (i7 == 4 || i7 == 8) {
                    int i8 = this.mNewItemStatuses[i6] >> 5;
                    listUpdateCallback.onMoved(removePostponedUpdate(list, i8, true).currentPos, i2);
                    if (i7 == 4) {
                        listUpdateCallback.onChanged(i2, 1, this.mCallback.getChangePayload(i8, i6));
                    }
                } else {
                    if (i7 != 16) {
                        throw new IllegalStateException("unknown flag for pos " + i6 + AbstractC1191a.f2568g + Long.toBinaryString(i7));
                    }
                    list.add(new PostponedUpdate(i6, i2, false));
                }
            }
        }

        private void dispatchRemovals(List<PostponedUpdate> list, ListUpdateCallback listUpdateCallback, int i2, int i3, int i4) {
            if (!this.mDetectMoves) {
                listUpdateCallback.onRemoved(i2, i3);
                return;
            }
            for (int i5 = i3 - 1; i5 >= 0; i5--) {
                int i6 = i4 + i5;
                int i7 = this.mOldItemStatuses[i6] & 31;
                if (i7 == 0) {
                    listUpdateCallback.onRemoved(i2 + i5, 1);
                    Iterator<PostponedUpdate> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().currentPos--;
                    }
                } else if (i7 == 4 || i7 == 8) {
                    int i8 = this.mOldItemStatuses[i6] >> 5;
                    PostponedUpdate removePostponedUpdate = removePostponedUpdate(list, i8, false);
                    listUpdateCallback.onMoved(i2 + i5, removePostponedUpdate.currentPos - 1);
                    if (i7 == 4) {
                        listUpdateCallback.onChanged(removePostponedUpdate.currentPos - 1, 1, this.mCallback.getChangePayload(i6, i8));
                    }
                } else {
                    if (i7 != 16) {
                        throw new IllegalStateException("unknown flag for pos " + i6 + AbstractC1191a.f2568g + Long.toBinaryString(i7));
                    }
                    list.add(new PostponedUpdate(i6, i2 + i5, true));
                }
            }
        }

        private void findAddition(int i2, int i3, int i4) {
            if (this.mOldItemStatuses[i2 - 1] != 0) {
                return;
            }
            findMatchingItem(i2, i3, i4, false);
        }

        private boolean findMatchingItem(int i2, int i3, int i4, boolean z) {
            int i5;
            int i6;
            int i7;
            if (z) {
                i3--;
                i5 = i2;
                i6 = i3;
            } else {
                i5 = i2 - 1;
                i6 = i5;
            }
            while (i4 >= 0) {
                Snake snake = this.mSnakes.get(i4);
                int i8 = snake.f621x;
                int i9 = snake.size;
                int i10 = i8 + i9;
                int i11 = snake.f622y + i9;
                if (z) {
                    for (int i12 = i5 - 1; i12 >= i10; i12--) {
                        if (this.mCallback.areItemsTheSame(i12, i6)) {
                            i7 = this.mCallback.areContentsTheSame(i12, i6) ? 8 : 4;
                            this.mNewItemStatuses[i6] = (i12 << 5) | 16;
                            this.mOldItemStatuses[i12] = (i6 << 5) | i7;
                            return true;
                        }
                    }
                } else {
                    for (int i13 = i3 - 1; i13 >= i11; i13--) {
                        if (this.mCallback.areItemsTheSame(i6, i13)) {
                            i7 = this.mCallback.areContentsTheSame(i6, i13) ? 8 : 4;
                            int i14 = i2 - 1;
                            this.mOldItemStatuses[i14] = (i13 << 5) | 16;
                            this.mNewItemStatuses[i13] = (i14 << 5) | i7;
                            return true;
                        }
                    }
                }
                i5 = snake.f621x;
                i3 = snake.f622y;
                i4--;
            }
            return false;
        }

        private void findMatchingItems() {
            int i2 = this.mOldListSize;
            int i3 = this.mNewListSize;
            for (int size = this.mSnakes.size() - 1; size >= 0; size--) {
                Snake snake = this.mSnakes.get(size);
                int i4 = snake.f621x;
                int i5 = snake.size;
                int i6 = i4 + i5;
                int i7 = snake.f622y + i5;
                if (this.mDetectMoves) {
                    while (i2 > i6) {
                        findAddition(i2, i3, size);
                        i2--;
                    }
                    while (i3 > i7) {
                        findRemoval(i2, i3, size);
                        i3--;
                    }
                }
                for (int i8 = 0; i8 < snake.size; i8++) {
                    int i9 = snake.f621x + i8;
                    int i10 = snake.f622y + i8;
                    int i11 = this.mCallback.areContentsTheSame(i9, i10) ? 1 : 2;
                    this.mOldItemStatuses[i9] = (i10 << 5) | i11;
                    this.mNewItemStatuses[i10] = (i9 << 5) | i11;
                }
                i2 = snake.f621x;
                i3 = snake.f622y;
            }
        }

        private void findRemoval(int i2, int i3, int i4) {
            if (this.mNewItemStatuses[i3 - 1] != 0) {
                return;
            }
            findMatchingItem(i2, i3, i4, true);
        }

        private static PostponedUpdate removePostponedUpdate(List<PostponedUpdate> list, int i2, boolean z) {
            int size = list.size() - 1;
            while (size >= 0) {
                PostponedUpdate postponedUpdate = list.get(size);
                if (postponedUpdate.posInOwnerList == i2 && postponedUpdate.removal == z) {
                    list.remove(size);
                    while (size < list.size()) {
                        list.get(size).currentPos += z ? 1 : -1;
                        size++;
                    }
                    return postponedUpdate;
                }
                size--;
            }
            return null;
        }

        public int convertNewPositionToOld(@IntRange(from = 0) int i2) {
            if (i2 >= 0) {
                int[] iArr = this.mNewItemStatuses;
                if (i2 < iArr.length) {
                    int i3 = iArr[i2];
                    if ((i3 & 31) == 0) {
                        return -1;
                    }
                    return i3 >> 5;
                }
            }
            throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i2 + ", new list size = " + this.mNewItemStatuses.length);
        }

        public int convertOldPositionToNew(@IntRange(from = 0) int i2) {
            if (i2 >= 0) {
                int[] iArr = this.mOldItemStatuses;
                if (i2 < iArr.length) {
                    int i3 = iArr[i2];
                    if ((i3 & 31) == 0) {
                        return -1;
                    }
                    return i3 >> 5;
                }
            }
            throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i2 + ", old list size = " + this.mOldItemStatuses.length);
        }

        public void dispatchUpdatesTo(@NonNull RecyclerView.Adapter adapter2) {
            dispatchUpdatesTo(new AdapterListUpdateCallback(adapter2));
        }

        @VisibleForTesting
        List<Snake> getSnakes() {
            return this.mSnakes;
        }

        public void dispatchUpdatesTo(@NonNull ListUpdateCallback listUpdateCallback) {
            BatchingListUpdateCallback batchingListUpdateCallback = listUpdateCallback instanceof BatchingListUpdateCallback ? (BatchingListUpdateCallback) listUpdateCallback : new BatchingListUpdateCallback(listUpdateCallback);
            ArrayList arrayList = new ArrayList();
            int i2 = this.mOldListSize;
            int i3 = this.mNewListSize;
            for (int size = this.mSnakes.size() - 1; size >= 0; size--) {
                Snake snake = this.mSnakes.get(size);
                int i4 = snake.size;
                int i5 = snake.f621x + i4;
                int i6 = snake.f622y + i4;
                if (i5 < i2) {
                    dispatchRemovals(arrayList, batchingListUpdateCallback, i5, i2 - i5, i5);
                }
                if (i6 < i3) {
                    dispatchAdditions(arrayList, batchingListUpdateCallback, i5, i3 - i6, i6);
                }
                for (int i7 = i4 - 1; i7 >= 0; i7--) {
                    int[] iArr = this.mOldItemStatuses;
                    int i8 = snake.f621x;
                    if ((iArr[i8 + i7] & 31) == 2) {
                        batchingListUpdateCallback.onChanged(i8 + i7, 1, this.mCallback.getChangePayload(i8 + i7, snake.f622y + i7));
                    }
                }
                i2 = snake.f621x;
                i3 = snake.f622y;
            }
            batchingListUpdateCallback.dispatchLastEvent();
        }
    }

    public static abstract class ItemCallback<T> {
        public abstract boolean areContentsTheSame(@NonNull T t, @NonNull T t2);

        public abstract boolean areItemsTheSame(@NonNull T t, @NonNull T t2);

        @Nullable
        public Object getChangePayload(@NonNull T t, @NonNull T t2) {
            return null;
        }
    }

    private static class PostponedUpdate {
        int currentPos;
        int posInOwnerList;
        boolean removal;

        public PostponedUpdate(int i2, int i3, boolean z) {
            this.posInOwnerList = i2;
            this.currentPos = i3;
            this.removal = z;
        }
    }

    static class Range {
        int newListEnd;
        int newListStart;
        int oldListEnd;
        int oldListStart;

        public Range() {
        }

        public Range(int i2, int i3, int i4, int i5) {
            this.oldListStart = i2;
            this.oldListEnd = i3;
            this.newListStart = i4;
            this.newListEnd = i5;
        }
    }

    static class Snake {
        boolean removal;
        boolean reverse;
        int size;

        /* renamed from: x */
        int f621x;

        /* renamed from: y */
        int f622y;

        Snake() {
        }
    }

    private DiffUtil() {
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback) {
        return calculateDiff(callback, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:
    
        if (r24[r13 - 1] < r24[r13 + r5]) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ba, code lost:
    
        if (r25[r13 - 1] < r25[r13 + 1]) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e3 A[LOOP:4: B:54:0x00cf->B:58:0x00e3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ee A[EDGE_INSN: B:59:0x00ee->B:60:0x00ee BREAK  A[LOOP:4: B:54:0x00cf->B:58:0x00e3], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static androidx.recyclerview.widget.DiffUtil.Snake diffPartial(androidx.recyclerview.widget.DiffUtil.Callback r19, int r20, int r21, int r22, int r23, int[] r24, int[] r25, int r26) {
        /*
            Method dump skipped, instructions count: 309
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.DiffUtil.diffPartial(androidx.recyclerview.widget.DiffUtil$Callback, int, int, int, int, int[], int[], int):androidx.recyclerview.widget.DiffUtil$Snake");
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback, boolean z) {
        int oldListSize = callback.getOldListSize();
        int newListSize = callback.getNewListSize();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Range(0, oldListSize, 0, newListSize));
        int abs = Math.abs(oldListSize - newListSize) + oldListSize + newListSize;
        int i2 = abs * 2;
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            Range range = (Range) arrayList2.remove(arrayList2.size() - 1);
            Snake diffPartial = diffPartial(callback, range.oldListStart, range.oldListEnd, range.newListStart, range.newListEnd, iArr, iArr2, abs);
            if (diffPartial != null) {
                if (diffPartial.size > 0) {
                    arrayList.add(diffPartial);
                }
                diffPartial.f621x += range.oldListStart;
                diffPartial.f622y += range.newListStart;
                Range range2 = arrayList3.isEmpty() ? new Range() : (Range) arrayList3.remove(arrayList3.size() - 1);
                range2.oldListStart = range.oldListStart;
                range2.newListStart = range.newListStart;
                if (diffPartial.reverse) {
                    range2.oldListEnd = diffPartial.f621x;
                    range2.newListEnd = diffPartial.f622y;
                } else if (diffPartial.removal) {
                    range2.oldListEnd = diffPartial.f621x - 1;
                    range2.newListEnd = diffPartial.f622y;
                } else {
                    range2.oldListEnd = diffPartial.f621x;
                    range2.newListEnd = diffPartial.f622y - 1;
                }
                arrayList2.add(range2);
                if (!diffPartial.reverse) {
                    int i3 = diffPartial.f621x;
                    int i4 = diffPartial.size;
                    range.oldListStart = i3 + i4;
                    range.newListStart = diffPartial.f622y + i4;
                } else if (diffPartial.removal) {
                    int i5 = diffPartial.f621x;
                    int i6 = diffPartial.size;
                    range.oldListStart = i5 + i6 + 1;
                    range.newListStart = diffPartial.f622y + i6;
                } else {
                    int i7 = diffPartial.f621x;
                    int i8 = diffPartial.size;
                    range.oldListStart = i7 + i8;
                    range.newListStart = diffPartial.f622y + i8 + 1;
                }
                arrayList2.add(range);
            } else {
                arrayList3.add(range);
            }
        }
        Collections.sort(arrayList, SNAKE_COMPARATOR);
        return new DiffResult(callback, arrayList, iArr, iArr2, z);
    }
}
