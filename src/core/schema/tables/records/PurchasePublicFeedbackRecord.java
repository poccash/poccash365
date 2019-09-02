/*
 * This file is generated by jOOQ.
 */
package core.schema.tables.records;


import core.schema.tables.PurchasePublicFeedback;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;

import javax.annotation.Generated;


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
public class PurchasePublicFeedbackRecord extends UpdatableRecordImpl<PurchasePublicFeedbackRecord> implements Record5<Long, Long, String, Integer, Boolean> {

    private static final long serialVersionUID = 316651930;

    /**
     * Setter for <code>DB.purchase_public_feedback.db_id</code>.
     */
    public void setDbId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>DB.purchase_public_feedback.db_id</code>.
     */
    public Long getDbId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>DB.purchase_public_feedback.id</code>.
     */
    public void setId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>DB.purchase_public_feedback.id</code>.
     */
    public Long getId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>DB.purchase_public_feedback.public_feedback</code>.
     */
    public void setPublicFeedback(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>DB.purchase_public_feedback.public_feedback</code>.
     */
    public String getPublicFeedback() {
        return (String) get(2);
    }

    /**
     * Setter for <code>DB.purchase_public_feedback.height</code>.
     */
    public void setHeight(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>DB.purchase_public_feedback.height</code>.
     */
    public Integer getHeight() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>DB.purchase_public_feedback.latest</code>.
     */
    public void setLatest(Boolean value) {
        set(4, value);
    }

    /**
     * Getter for <code>DB.purchase_public_feedback.latest</code>.
     */
    public Boolean getLatest() {
        return (Boolean) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Long, Long, String, Integer, Boolean> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Long, Long, String, Integer, Boolean> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return PurchasePublicFeedback.PURCHASE_PUBLIC_FEEDBACK.DB_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return PurchasePublicFeedback.PURCHASE_PUBLIC_FEEDBACK.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return PurchasePublicFeedback.PURCHASE_PUBLIC_FEEDBACK.PUBLIC_FEEDBACK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return PurchasePublicFeedback.PURCHASE_PUBLIC_FEEDBACK.HEIGHT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field5() {
        return PurchasePublicFeedback.PURCHASE_PUBLIC_FEEDBACK.LATEST;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getDbId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component2() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getPublicFeedback();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getHeight();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean component5() {
        return getLatest();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getDbId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value2() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getPublicFeedback();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getHeight();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value5() {
        return getLatest();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PurchasePublicFeedbackRecord value1(Long value) {
        setDbId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PurchasePublicFeedbackRecord value2(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PurchasePublicFeedbackRecord value3(String value) {
        setPublicFeedback(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PurchasePublicFeedbackRecord value4(Integer value) {
        setHeight(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PurchasePublicFeedbackRecord value5(Boolean value) {
        setLatest(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PurchasePublicFeedbackRecord values(Long value1, Long value2, String value3, Integer value4, Boolean value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PurchasePublicFeedbackRecord
     */
    public PurchasePublicFeedbackRecord() {
        super(PurchasePublicFeedback.PURCHASE_PUBLIC_FEEDBACK);
    }

    /**
     * Create a detached, initialised PurchasePublicFeedbackRecord
     */
    public PurchasePublicFeedbackRecord(Long dbId, Long id, String publicFeedback, Integer height, Boolean latest) {
        super(PurchasePublicFeedback.PURCHASE_PUBLIC_FEEDBACK);

        set(0, dbId);
        set(1, id);
        set(2, publicFeedback);
        set(3, height);
        set(4, latest);
    }
}
