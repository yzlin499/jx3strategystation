package top.yzlin.jx3strategystation.database;

import org.hibernate.query.Query;

public interface OperateQuery<T> {
    void apply(Query<T> query);
}
