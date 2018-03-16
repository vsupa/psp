package com.vsupa.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * 通过外交绑定
 * @author Maxwell.Lee
 * @date 2018-03-06 13:14
 * @since   1.0.0
 */
public class ForeignKeyBindingHandler<M, F, T> {

    private Function<M, ?>  mainKeyFun;

    private Function<F, ?>  foreignKeyFun;

    private ComposeOperation<M, F, T>   composeOpt;

    public <K> ForeignKeyBindingHandler(Function<M, K> mainKeyFun, Function<F, K> foreignKeyFun,
                                    ComposeOperation<M, F, T> composeOpt) {
        this.mainKeyFun = mainKeyFun;
        this.foreignKeyFun = foreignKeyFun;
        this.composeOpt = composeOpt;
    }

    public List<T> apply(List<M> mainObjs, List<F> foreignObjs) {
        Map<Object, F> idx2ForeignObjMap = new HashMap<>();
        if (foreignObjs != null) {
            for (F fo : foreignObjs) {
                Object key = foreignKeyFun.apply(fo);
                if (key == null) continue;

                idx2ForeignObjMap.put(key, fo);
            }
        }

        List<T> rst = new ArrayList<>();
        for (M mo : mainObjs) {
            Object key = mainKeyFun.apply(mo);

            if (key == null) {
                T t = composeOpt.compose(mo, null);
                if (t != null) rst.add(t);
                continue;
            }

            F fo = idx2ForeignObjMap.get(key);
            T t = composeOpt.compose(mo, fo);
            if (t != null) rst.add(t);
        }

        return rst;
    }

}
