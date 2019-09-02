/*
 * This file is generated by jOOQ.
 */
package core.schema.tables;


import core.schema.Db;
import core.schema.Indexes;
import core.schema.Keys;
import core.schema.tables.records.PurchaseRecord;
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
public class Purchase extends TableImpl<PurchaseRecord> {

    private static final long serialVersionUID = -1799759090;

    /**
     * The reference instance of <code>DB.purchase</code>
     */
    public static final Purchase PURCHASE = new Purchase();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PurchaseRecord> getRecordType() {
        return PurchaseRecord.class;
    }

    /**
     * The column <code>DB.purchase.db_id</code>.
     */
    public final TableField<PurchaseRecord, Long> DB_ID = createField("db_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>DB.purchase.id</code>.
     */
    public final TableField<PurchaseRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>DB.purchase.buyer_id</code>.
     */
    public final TableField<PurchaseRecord, Long> BUYER_ID = createField("buyer_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>DB.purchase.goods_id</code>.
     */
    public final TableField<PurchaseRecord, Long> GOODS_ID = createField("goods_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>DB.purchase.seller_id</code>.
     */
    public final TableField<PurchaseRecord, Long> SELLER_ID = createField("seller_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>DB.purchase.quantity</code>.
     */
    public final TableField<PurchaseRecord, Integer> QUANTITY = createField("quantity", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>DB.purchase.price</code>.
     */
    public final TableField<PurchaseRecord, Long> PRICE = createField("price", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>DB.purchase.deadline</code>.
     */
    public final TableField<PurchaseRecord, Integer> DEADLINE = createField("deadline", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>DB.purchase.note</code>.
     */
    public final TableField<PurchaseRecord, byte[]> NOTE = createField("note", org.jooq.impl.SQLDataType.BLOB.defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.BLOB)), this, "");

    /**
     * The column <code>DB.purchase.nonce</code>.
     */
    public final TableField<PurchaseRecord, byte[]> NONCE = createField("nonce", org.jooq.impl.SQLDataType.VARBINARY(32).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARBINARY)), this, "");

    /**
     * The column <code>DB.purchase.timestamp</code>.
     */
    public final TableField<PurchaseRecord, Integer> TIMESTAMP = createField("timestamp", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>DB.purchase.pending</code>.
     */
    public final TableField<PurchaseRecord, Boolean> PENDING = createField("pending", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false), this, "");

    /**
     * The column <code>DB.purchase.goods</code>.
     */
    public final TableField<PurchaseRecord, byte[]> GOODS = createField("goods", org.jooq.impl.SQLDataType.BLOB.defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.BLOB)), this, "");

    /**
     * The column <code>DB.purchase.goods_nonce</code>.
     */
    public final TableField<PurchaseRecord, byte[]> GOODS_NONCE = createField("goods_nonce", org.jooq.impl.SQLDataType.VARBINARY(32).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARBINARY)), this, "");

    /**
     * The column <code>DB.purchase.refund_note</code>.
     */
    public final TableField<PurchaseRecord, byte[]> REFUND_NOTE = createField("refund_note", org.jooq.impl.SQLDataType.BLOB.defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.BLOB)), this, "");

    /**
     * The column <code>DB.purchase.refund_nonce</code>.
     */
    public final TableField<PurchaseRecord, byte[]> REFUND_NONCE = createField("refund_nonce", org.jooq.impl.SQLDataType.VARBINARY(32).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARBINARY)), this, "");

    /**
     * The column <code>DB.purchase.has_feedback_notes</code>.
     */
    public final TableField<PurchaseRecord, Boolean> HAS_FEEDBACK_NOTES = createField("has_feedback_notes", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>DB.purchase.has_public_feedbacks</code>.
     */
    public final TableField<PurchaseRecord, Boolean> HAS_PUBLIC_FEEDBACKS = createField("has_public_feedbacks", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>DB.purchase.discount</code>.
     */
    public final TableField<PurchaseRecord, Long> DISCOUNT = createField("discount", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>DB.purchase.refund</code>.
     */
    public final TableField<PurchaseRecord, Long> REFUND = createField("refund", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>DB.purchase.height</code>.
     */
    public final TableField<PurchaseRecord, Integer> HEIGHT = createField("height", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>DB.purchase.latest</code>.
     */
    public final TableField<PurchaseRecord, Boolean> LATEST = createField("latest", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaultValue(org.jooq.impl.DSL.field("1", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * Create a <code>DB.purchase</code> table reference
     */
    public Purchase() {
        this(DSL.name("purchase"), null);
    }

    /**
     * Create an aliased <code>DB.purchase</code> table reference
     */
    public Purchase(String alias) {
        this(DSL.name(alias), PURCHASE);
    }

    /**
     * Create an aliased <code>DB.purchase</code> table reference
     */
    public Purchase(Name alias) {
        this(alias, PURCHASE);
    }

    private Purchase(Name alias, Table<PurchaseRecord> aliased) {
        this(alias, aliased, null);
    }

    private Purchase(Name alias, Table<PurchaseRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Purchase(Table<O> child, ForeignKey<O, PurchaseRecord> key) {
        super(child, key, PURCHASE);
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
        return Arrays.<Index>asList(Indexes.PURCHASE_PRIMARY, Indexes.PURCHASE_PURCHASE_BUYER_ID_HEIGHT_IDX, Indexes.PURCHASE_PURCHASE_DEADLINE_IDX, Indexes.PURCHASE_PURCHASE_ID_HEIGHT_IDX, Indexes.PURCHASE_PURCHASE_SELLER_ID_HEIGHT_IDX, Indexes.PURCHASE_PURCHASE_TIMESTAMP_IDX);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<PurchaseRecord, Long> getIdentity() {
        return Keys.IDENTITY_PURCHASE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<PurchaseRecord> getPrimaryKey() {
        return Keys.KEY_PURCHASE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<PurchaseRecord>> getKeys() {
        return Arrays.<UniqueKey<PurchaseRecord>>asList(Keys.KEY_PURCHASE_PRIMARY, Keys.KEY_PURCHASE_PURCHASE_ID_HEIGHT_IDX);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Purchase as(String alias) {
        return new Purchase(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Purchase as(Name alias) {
        return new Purchase(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Purchase rename(String name) {
        return new Purchase(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Purchase rename(Name name) {
        return new Purchase(name, null);
    }
}
