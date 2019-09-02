/*
 * This file is generated by jOOQ.
 */
package core.schema.tables;


import core.schema.Db;
import core.schema.Indexes;
import core.schema.Keys;
import core.schema.tables.records.BidOrderRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import javax.annotation.Generated;
import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BidOrder extends TableImpl<BidOrderRecord> {

    private static final long serialVersionUID = 1710131418;

    /**
     * The reference instance of <code>DB.bid_order</code>
     */
    public static final BidOrder BID_ORDER = new BidOrder();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BidOrderRecord> getRecordType() {
        return BidOrderRecord.class;
    }

    /**
     * The column <code>DB.bid_order.db_id</code>.
     */
    public final TableField<BidOrderRecord, Long> DB_ID = createField("db_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>DB.bid_order.id</code>.
     */
    public final TableField<BidOrderRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>DB.bid_order.account_id</code>.
     */
    public final TableField<BidOrderRecord, Long> ACCOUNT_ID = createField("account_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>DB.bid_order.asset_id</code>.
     */
    public final TableField<BidOrderRecord, Long> ASSET_ID = createField("asset_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>DB.bid_order.price</code>.
     */
    public final TableField<BidOrderRecord, Long> PRICE = createField("price", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>DB.bid_order.quantity</code>.
     */
    public final TableField<BidOrderRecord, Long> QUANTITY = createField("quantity", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>DB.bid_order.creation_height</code>.
     */
    public final TableField<BidOrderRecord, Integer> CREATION_HEIGHT = createField("creation_height", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>DB.bid_order.height</code>.
     */
    public final TableField<BidOrderRecord, Integer> HEIGHT = createField("height", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>DB.bid_order.latest</code>.
     */
    public final TableField<BidOrderRecord, Boolean> LATEST = createField("latest", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaultValue(org.jooq.impl.DSL.field("1", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * Create a <code>DB.bid_order</code> table reference
     */
    public BidOrder() {
        this(DSL.name("bid_order"), null);
    }

    /**
     * Create an aliased <code>DB.bid_order</code> table reference
     */
    public BidOrder(String alias) {
        this(DSL.name(alias), BID_ORDER);
    }

    /**
     * Create an aliased <code>DB.bid_order</code> table reference
     */
    public BidOrder(Name alias) {
        this(alias, BID_ORDER);
    }

    private BidOrder(Name alias, Table<BidOrderRecord> aliased) {
        this(alias, aliased, null);
    }

    private BidOrder(Name alias, Table<BidOrderRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> BidOrder(Table<O> child, ForeignKey<O, BidOrderRecord> key) {
        super(child, key, BID_ORDER);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Db.DB;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.BID_ORDER_BID_ORDER_ACCOUNT_ID_IDX, Indexes.BID_ORDER_BID_ORDER_ASSET_ID_PRICE_IDX, Indexes.BID_ORDER_BID_ORDER_CREATION_IDX, Indexes.BID_ORDER_BID_ORDER_ID_HEIGHT_IDX, Indexes.BID_ORDER_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<BidOrderRecord, Long> getIdentity() {
        return Keys.IDENTITY_BID_ORDER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<BidOrderRecord> getPrimaryKey() {
        return Keys.KEY_BID_ORDER_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<BidOrderRecord>> getKeys() {
        return Arrays.<UniqueKey<BidOrderRecord>>asList(Keys.KEY_BID_ORDER_PRIMARY, Keys.KEY_BID_ORDER_BID_ORDER_ID_HEIGHT_IDX);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BidOrder as(String alias) {
        return new BidOrder(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BidOrder as(Name alias) {
        return new BidOrder(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public BidOrder rename(String name) {
        return new BidOrder(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public BidOrder rename(Name name) {
        return new BidOrder(name, null);
    }
}
