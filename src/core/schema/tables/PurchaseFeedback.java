/*
 * This file is generated by jOOQ.
 */
package core.schema.tables;


import core.schema.Db;
import core.schema.Indexes;
import core.schema.Keys;
import core.schema.tables.records.PurchaseFeedbackRecord;
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
public class PurchaseFeedback extends TableImpl<PurchaseFeedbackRecord> {

    private static final long serialVersionUID = -835257634;

    /**
     * The reference instance of <code>DB.purchase_feedback</code>
     */
    public static final PurchaseFeedback PURCHASE_FEEDBACK = new PurchaseFeedback();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PurchaseFeedbackRecord> getRecordType() {
        return PurchaseFeedbackRecord.class;
    }

    /**
     * The column <code>DB.purchase_feedback.db_id</code>.
     */
    public final TableField<PurchaseFeedbackRecord, Long> DB_ID = createField("db_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>DB.purchase_feedback.id</code>.
     */
    public final TableField<PurchaseFeedbackRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>DB.purchase_feedback.feedback_data</code>.
     */
    public final TableField<PurchaseFeedbackRecord, byte[]> FEEDBACK_DATA = createField("feedback_data", org.jooq.impl.SQLDataType.BLOB.nullable(false), this, "");

    /**
     * The column <code>DB.purchase_feedback.feedback_nonce</code>.
     */
    public final TableField<PurchaseFeedbackRecord, byte[]> FEEDBACK_NONCE = createField("feedback_nonce", org.jooq.impl.SQLDataType.VARBINARY(32).nullable(false), this, "");

    /**
     * The column <code>DB.purchase_feedback.height</code>.
     */
    public final TableField<PurchaseFeedbackRecord, Integer> HEIGHT = createField("height", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>DB.purchase_feedback.latest</code>.
     */
    public final TableField<PurchaseFeedbackRecord, Boolean> LATEST = createField("latest", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaultValue(org.jooq.impl.DSL.field("1", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * Create a <code>DB.purchase_feedback</code> table reference
     */
    public PurchaseFeedback() {
        this(DSL.name("purchase_feedback"), null);
    }

    /**
     * Create an aliased <code>DB.purchase_feedback</code> table reference
     */
    public PurchaseFeedback(String alias) {
        this(DSL.name(alias), PURCHASE_FEEDBACK);
    }

    /**
     * Create an aliased <code>DB.purchase_feedback</code> table reference
     */
    public PurchaseFeedback(Name alias) {
        this(alias, PURCHASE_FEEDBACK);
    }

    private PurchaseFeedback(Name alias, Table<PurchaseFeedbackRecord> aliased) {
        this(alias, aliased, null);
    }

    private PurchaseFeedback(Name alias, Table<PurchaseFeedbackRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> PurchaseFeedback(Table<O> child, ForeignKey<O, PurchaseFeedbackRecord> key) {
        super(child, key, PURCHASE_FEEDBACK);
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
        return Arrays.<Index>asList(Indexes.PURCHASE_FEEDBACK_PRIMARY, Indexes.PURCHASE_FEEDBACK_PURCHASE_FEEDBACK_ID_HEIGHT_IDX);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<PurchaseFeedbackRecord, Long> getIdentity() {
        return Keys.IDENTITY_PURCHASE_FEEDBACK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<PurchaseFeedbackRecord> getPrimaryKey() {
        return Keys.KEY_PURCHASE_FEEDBACK_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<PurchaseFeedbackRecord>> getKeys() {
        return Arrays.<UniqueKey<PurchaseFeedbackRecord>>asList(Keys.KEY_PURCHASE_FEEDBACK_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PurchaseFeedback as(String alias) {
        return new PurchaseFeedback(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PurchaseFeedback as(Name alias) {
        return new PurchaseFeedback(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public PurchaseFeedback rename(String name) {
        return new PurchaseFeedback(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public PurchaseFeedback rename(Name name) {
        return new PurchaseFeedback(name, null);
    }
}
