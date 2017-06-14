package cn.infit.ll.dbentity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by kaxia on 2017/6/14.
 */
@Entity
@Table(name = "user_data", schema = "IN_Fit", catalog = "")
public class UserDataEntity {
    private int id;
    private int userId;
    private Timestamp createDate;
    private BigDecimal weight;
    private BigDecimal height;
    private BigDecimal highWaist;
    private BigDecimal ankleHigh;
    private BigDecimal kneeHigh;
    private BigDecimal doesHigh;
    private BigDecimal hipHigh;
    private BigDecimal feetLong;
    private BigDecimal backLength;
    private BigDecimal frontWaistLength;
    private BigDecimal chestLong;
    private BigDecimal chestWidth;
    private BigDecimal backWidth;
    private BigDecimal shoulderLength;
    private BigDecimal hipWaistLong;
    private BigDecimal theThighInsideLong;
    private BigDecimal armLength;
    private BigDecimal upperArmLength;
    private BigDecimal lengthOfTheTrunk;
    private BigDecimal forkLength;
    private BigDecimal headCircumference;
    private BigDecimal neckCircumference;
    private BigDecimal onTheChest;
    private BigDecimal theChest;
    private BigDecimal underTheChest;
    private int onTheWaistWaistInTheNet;
    private BigDecimal inTheWaist;
    private BigDecimal waistbandIsSurrounded;
    private BigDecimal hipCircumference;
    private BigDecimal thighCircumference;
    private BigDecimal inTheThighCircumference;
    private BigDecimal kneeCircumference;
    private BigDecimal ankleCircumference;
    private BigDecimal heelsCircumference;
    private BigDecimal armRhizosphere;
    private BigDecimal upperArmCircumference;
    private BigDecimal elbowCircumference;
    private BigDecimal wristCircumference;
    private BigDecimal hemCircumference;
    private BigDecimal footMouth;
    private BigDecimal beforeTheLength;
    private BigDecimal afterTheLength;
    private BigDecimal sleeveLength;
    private BigDecimal length;
    private BigDecimal straightCrotch;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "create_date")
    @CreationTimestamp
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "weight")
    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "height")
    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    @Basic
    @Column(name = "high_waist")
    public BigDecimal getHighWaist() {
        return highWaist;
    }

    public void setHighWaist(BigDecimal highWaist) {
        this.highWaist = highWaist;
    }

    @Basic
    @Column(name = "ankle_high")
    public BigDecimal getAnkleHigh() {
        return ankleHigh;
    }

    public void setAnkleHigh(BigDecimal ankleHigh) {
        this.ankleHigh = ankleHigh;
    }

    @Basic
    @Column(name = "knee_high")
    public BigDecimal getKneeHigh() {
        return kneeHigh;
    }

    public void setKneeHigh(BigDecimal kneeHigh) {
        this.kneeHigh = kneeHigh;
    }

    @Basic
    @Column(name = "does_high")
    public BigDecimal getDoesHigh() {
        return doesHigh;
    }

    public void setDoesHigh(BigDecimal doesHigh) {
        this.doesHigh = doesHigh;
    }

    @Basic
    @Column(name = "hip_high")
    public BigDecimal getHipHigh() {
        return hipHigh;
    }

    public void setHipHigh(BigDecimal hipHigh) {
        this.hipHigh = hipHigh;
    }

    @Basic
    @Column(name = "feet_long")
    public BigDecimal getFeetLong() {
        return feetLong;
    }

    public void setFeetLong(BigDecimal feetLong) {
        this.feetLong = feetLong;
    }

    @Basic
    @Column(name = "back_length")
    public BigDecimal getBackLength() {
        return backLength;
    }

    public void setBackLength(BigDecimal backLength) {
        this.backLength = backLength;
    }

    @Basic
    @Column(name = "front_waist_length")
    public BigDecimal getFrontWaistLength() {
        return frontWaistLength;
    }

    public void setFrontWaistLength(BigDecimal frontWaistLength) {
        this.frontWaistLength = frontWaistLength;
    }

    @Basic
    @Column(name = "chest_long")
    public BigDecimal getChestLong() {
        return chestLong;
    }

    public void setChestLong(BigDecimal chestLong) {
        this.chestLong = chestLong;
    }

    @Basic
    @Column(name = "chest_width")
    public BigDecimal getChestWidth() {
        return chestWidth;
    }

    public void setChestWidth(BigDecimal chestWidth) {
        this.chestWidth = chestWidth;
    }

    @Basic
    @Column(name = "back_width")
    public BigDecimal getBackWidth() {
        return backWidth;
    }

    public void setBackWidth(BigDecimal backWidth) {
        this.backWidth = backWidth;
    }

    @Basic
    @Column(name = "shoulder_length")
    public BigDecimal getShoulderLength() {
        return shoulderLength;
    }

    public void setShoulderLength(BigDecimal shoulderLength) {
        this.shoulderLength = shoulderLength;
    }

    @Basic
    @Column(name = "hip_waist_long")
    public BigDecimal getHipWaistLong() {
        return hipWaistLong;
    }

    public void setHipWaistLong(BigDecimal hipWaistLong) {
        this.hipWaistLong = hipWaistLong;
    }

    @Basic
    @Column(name = "the_thigh_inside_long")
    public BigDecimal getTheThighInsideLong() {
        return theThighInsideLong;
    }

    public void setTheThighInsideLong(BigDecimal theThighInsideLong) {
        this.theThighInsideLong = theThighInsideLong;
    }

    @Basic
    @Column(name = "arm_length")
    public BigDecimal getArmLength() {
        return armLength;
    }

    public void setArmLength(BigDecimal armLength) {
        this.armLength = armLength;
    }

    @Basic
    @Column(name = "upper_arm_length")
    public BigDecimal getUpperArmLength() {
        return upperArmLength;
    }

    public void setUpperArmLength(BigDecimal upperArmLength) {
        this.upperArmLength = upperArmLength;
    }

    @Basic
    @Column(name = "length_of_the_trunk")
    public BigDecimal getLengthOfTheTrunk() {
        return lengthOfTheTrunk;
    }

    public void setLengthOfTheTrunk(BigDecimal lengthOfTheTrunk) {
        this.lengthOfTheTrunk = lengthOfTheTrunk;
    }

    @Basic
    @Column(name = "fork_length")
    public BigDecimal getForkLength() {
        return forkLength;
    }

    public void setForkLength(BigDecimal forkLength) {
        this.forkLength = forkLength;
    }

    @Basic
    @Column(name = "head_circumference")
    public BigDecimal getHeadCircumference() {
        return headCircumference;
    }

    public void setHeadCircumference(BigDecimal headCircumference) {
        this.headCircumference = headCircumference;
    }

    @Basic
    @Column(name = "neck_circumference")
    public BigDecimal getNeckCircumference() {
        return neckCircumference;
    }

    public void setNeckCircumference(BigDecimal neckCircumference) {
        this.neckCircumference = neckCircumference;
    }

    @Basic
    @Column(name = "on_the_chest")
    public BigDecimal getOnTheChest() {
        return onTheChest;
    }

    public void setOnTheChest(BigDecimal onTheChest) {
        this.onTheChest = onTheChest;
    }

    @Basic
    @Column(name = "the_chest")
    public BigDecimal getTheChest() {
        return theChest;
    }

    public void setTheChest(BigDecimal theChest) {
        this.theChest = theChest;
    }

    @Basic
    @Column(name = "under_the_chest")
    public BigDecimal getUnderTheChest() {
        return underTheChest;
    }

    public void setUnderTheChest(BigDecimal underTheChest) {
        this.underTheChest = underTheChest;
    }

    @Basic
    @Column(name = "on_the_waist_waist_in_the_net")
    public int getOnTheWaistWaistInTheNet() {
        return onTheWaistWaistInTheNet;
    }

    public void setOnTheWaistWaistInTheNet(int onTheWaistWaistInTheNet) {
        this.onTheWaistWaistInTheNet = onTheWaistWaistInTheNet;
    }

    @Basic
    @Column(name = "in_the_waist")
    public BigDecimal getInTheWaist() {
        return inTheWaist;
    }

    public void setInTheWaist(BigDecimal inTheWaist) {
        this.inTheWaist = inTheWaist;
    }

    @Basic
    @Column(name = "waistband_is_surrounded")
    public BigDecimal getWaistbandIsSurrounded() {
        return waistbandIsSurrounded;
    }

    public void setWaistbandIsSurrounded(BigDecimal waistbandIsSurrounded) {
        this.waistbandIsSurrounded = waistbandIsSurrounded;
    }

    @Basic
    @Column(name = "hip_circumference")
    public BigDecimal getHipCircumference() {
        return hipCircumference;
    }

    public void setHipCircumference(BigDecimal hipCircumference) {
        this.hipCircumference = hipCircumference;
    }

    @Basic
    @Column(name = "thigh_circumference")
    public BigDecimal getThighCircumference() {
        return thighCircumference;
    }

    public void setThighCircumference(BigDecimal thighCircumference) {
        this.thighCircumference = thighCircumference;
    }

    @Basic
    @Column(name = "in_the_thigh_circumference")
    public BigDecimal getInTheThighCircumference() {
        return inTheThighCircumference;
    }

    public void setInTheThighCircumference(BigDecimal inTheThighCircumference) {
        this.inTheThighCircumference = inTheThighCircumference;
    }

    @Basic
    @Column(name = "knee_circumference")
    public BigDecimal getKneeCircumference() {
        return kneeCircumference;
    }

    public void setKneeCircumference(BigDecimal kneeCircumference) {
        this.kneeCircumference = kneeCircumference;
    }

    @Basic
    @Column(name = "ankle_circumference")
    public BigDecimal getAnkleCircumference() {
        return ankleCircumference;
    }

    public void setAnkleCircumference(BigDecimal ankleCircumference) {
        this.ankleCircumference = ankleCircumference;
    }

    @Basic
    @Column(name = "heels_circumference")
    public BigDecimal getHeelsCircumference() {
        return heelsCircumference;
    }

    public void setHeelsCircumference(BigDecimal heelsCircumference) {
        this.heelsCircumference = heelsCircumference;
    }

    @Basic
    @Column(name = "arm_rhizosphere")
    public BigDecimal getArmRhizosphere() {
        return armRhizosphere;
    }

    public void setArmRhizosphere(BigDecimal armRhizosphere) {
        this.armRhizosphere = armRhizosphere;
    }

    @Basic
    @Column(name = "upper_arm_circumference")
    public BigDecimal getUpperArmCircumference() {
        return upperArmCircumference;
    }

    public void setUpperArmCircumference(BigDecimal upperArmCircumference) {
        this.upperArmCircumference = upperArmCircumference;
    }

    @Basic
    @Column(name = "elbow_circumference")
    public BigDecimal getElbowCircumference() {
        return elbowCircumference;
    }

    public void setElbowCircumference(BigDecimal elbowCircumference) {
        this.elbowCircumference = elbowCircumference;
    }

    @Basic
    @Column(name = "wrist_circumference")
    public BigDecimal getWristCircumference() {
        return wristCircumference;
    }

    public void setWristCircumference(BigDecimal wristCircumference) {
        this.wristCircumference = wristCircumference;
    }

    @Basic
    @Column(name = "hem_circumference")
    public BigDecimal getHemCircumference() {
        return hemCircumference;
    }

    public void setHemCircumference(BigDecimal hemCircumference) {
        this.hemCircumference = hemCircumference;
    }

    @Basic
    @Column(name = "foot_mouth")
    public BigDecimal getFootMouth() {
        return footMouth;
    }

    public void setFootMouth(BigDecimal footMouth) {
        this.footMouth = footMouth;
    }

    @Basic
    @Column(name = "before_the_length")
    public BigDecimal getBeforeTheLength() {
        return beforeTheLength;
    }

    public void setBeforeTheLength(BigDecimal beforeTheLength) {
        this.beforeTheLength = beforeTheLength;
    }

    @Basic
    @Column(name = "after_the_length")
    public BigDecimal getAfterTheLength() {
        return afterTheLength;
    }

    public void setAfterTheLength(BigDecimal afterTheLength) {
        this.afterTheLength = afterTheLength;
    }

    @Basic
    @Column(name = "sleeve_length")
    public BigDecimal getSleeveLength() {
        return sleeveLength;
    }

    public void setSleeveLength(BigDecimal sleeveLength) {
        this.sleeveLength = sleeveLength;
    }

    @Basic
    @Column(name = "length")
    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    @Basic
    @Column(name = "straight_crotch")
    public BigDecimal getStraightCrotch() {
        return straightCrotch;
    }

    public void setStraightCrotch(BigDecimal straightCrotch) {
        this.straightCrotch = straightCrotch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDataEntity that = (UserDataEntity) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (onTheWaistWaistInTheNet != that.onTheWaistWaistInTheNet) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;
        if (height != null ? !height.equals(that.height) : that.height != null) return false;
        if (highWaist != null ? !highWaist.equals(that.highWaist) : that.highWaist != null) return false;
        if (ankleHigh != null ? !ankleHigh.equals(that.ankleHigh) : that.ankleHigh != null) return false;
        if (kneeHigh != null ? !kneeHigh.equals(that.kneeHigh) : that.kneeHigh != null) return false;
        if (doesHigh != null ? !doesHigh.equals(that.doesHigh) : that.doesHigh != null) return false;
        if (hipHigh != null ? !hipHigh.equals(that.hipHigh) : that.hipHigh != null) return false;
        if (feetLong != null ? !feetLong.equals(that.feetLong) : that.feetLong != null) return false;
        if (backLength != null ? !backLength.equals(that.backLength) : that.backLength != null) return false;
        if (frontWaistLength != null ? !frontWaistLength.equals(that.frontWaistLength) : that.frontWaistLength != null)
            return false;
        if (chestLong != null ? !chestLong.equals(that.chestLong) : that.chestLong != null) return false;
        if (chestWidth != null ? !chestWidth.equals(that.chestWidth) : that.chestWidth != null) return false;
        if (backWidth != null ? !backWidth.equals(that.backWidth) : that.backWidth != null) return false;
        if (shoulderLength != null ? !shoulderLength.equals(that.shoulderLength) : that.shoulderLength != null)
            return false;
        if (hipWaistLong != null ? !hipWaistLong.equals(that.hipWaistLong) : that.hipWaistLong != null) return false;
        if (theThighInsideLong != null ? !theThighInsideLong.equals(that.theThighInsideLong) : that.theThighInsideLong != null)
            return false;
        if (armLength != null ? !armLength.equals(that.armLength) : that.armLength != null) return false;
        if (upperArmLength != null ? !upperArmLength.equals(that.upperArmLength) : that.upperArmLength != null)
            return false;
        if (lengthOfTheTrunk != null ? !lengthOfTheTrunk.equals(that.lengthOfTheTrunk) : that.lengthOfTheTrunk != null)
            return false;
        if (forkLength != null ? !forkLength.equals(that.forkLength) : that.forkLength != null) return false;
        if (headCircumference != null ? !headCircumference.equals(that.headCircumference) : that.headCircumference != null)
            return false;
        if (neckCircumference != null ? !neckCircumference.equals(that.neckCircumference) : that.neckCircumference != null)
            return false;
        if (onTheChest != null ? !onTheChest.equals(that.onTheChest) : that.onTheChest != null) return false;
        if (theChest != null ? !theChest.equals(that.theChest) : that.theChest != null) return false;
        if (underTheChest != null ? !underTheChest.equals(that.underTheChest) : that.underTheChest != null)
            return false;
        if (inTheWaist != null ? !inTheWaist.equals(that.inTheWaist) : that.inTheWaist != null) return false;
        if (waistbandIsSurrounded != null ? !waistbandIsSurrounded.equals(that.waistbandIsSurrounded) : that.waistbandIsSurrounded != null)
            return false;
        if (hipCircumference != null ? !hipCircumference.equals(that.hipCircumference) : that.hipCircumference != null)
            return false;
        if (thighCircumference != null ? !thighCircumference.equals(that.thighCircumference) : that.thighCircumference != null)
            return false;
        if (inTheThighCircumference != null ? !inTheThighCircumference.equals(that.inTheThighCircumference) : that.inTheThighCircumference != null)
            return false;
        if (kneeCircumference != null ? !kneeCircumference.equals(that.kneeCircumference) : that.kneeCircumference != null)
            return false;
        if (ankleCircumference != null ? !ankleCircumference.equals(that.ankleCircumference) : that.ankleCircumference != null)
            return false;
        if (heelsCircumference != null ? !heelsCircumference.equals(that.heelsCircumference) : that.heelsCircumference != null)
            return false;
        if (armRhizosphere != null ? !armRhizosphere.equals(that.armRhizosphere) : that.armRhizosphere != null)
            return false;
        if (upperArmCircumference != null ? !upperArmCircumference.equals(that.upperArmCircumference) : that.upperArmCircumference != null)
            return false;
        if (elbowCircumference != null ? !elbowCircumference.equals(that.elbowCircumference) : that.elbowCircumference != null)
            return false;
        if (wristCircumference != null ? !wristCircumference.equals(that.wristCircumference) : that.wristCircumference != null)
            return false;
        if (hemCircumference != null ? !hemCircumference.equals(that.hemCircumference) : that.hemCircumference != null)
            return false;
        if (footMouth != null ? !footMouth.equals(that.footMouth) : that.footMouth != null) return false;
        if (beforeTheLength != null ? !beforeTheLength.equals(that.beforeTheLength) : that.beforeTheLength != null)
            return false;
        if (afterTheLength != null ? !afterTheLength.equals(that.afterTheLength) : that.afterTheLength != null)
            return false;
        if (sleeveLength != null ? !sleeveLength.equals(that.sleeveLength) : that.sleeveLength != null) return false;
        if (length != null ? !length.equals(that.length) : that.length != null) return false;
        if (straightCrotch != null ? !straightCrotch.equals(that.straightCrotch) : that.straightCrotch != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (highWaist != null ? highWaist.hashCode() : 0);
        result = 31 * result + (ankleHigh != null ? ankleHigh.hashCode() : 0);
        result = 31 * result + (kneeHigh != null ? kneeHigh.hashCode() : 0);
        result = 31 * result + (doesHigh != null ? doesHigh.hashCode() : 0);
        result = 31 * result + (hipHigh != null ? hipHigh.hashCode() : 0);
        result = 31 * result + (feetLong != null ? feetLong.hashCode() : 0);
        result = 31 * result + (backLength != null ? backLength.hashCode() : 0);
        result = 31 * result + (frontWaistLength != null ? frontWaistLength.hashCode() : 0);
        result = 31 * result + (chestLong != null ? chestLong.hashCode() : 0);
        result = 31 * result + (chestWidth != null ? chestWidth.hashCode() : 0);
        result = 31 * result + (backWidth != null ? backWidth.hashCode() : 0);
        result = 31 * result + (shoulderLength != null ? shoulderLength.hashCode() : 0);
        result = 31 * result + (hipWaistLong != null ? hipWaistLong.hashCode() : 0);
        result = 31 * result + (theThighInsideLong != null ? theThighInsideLong.hashCode() : 0);
        result = 31 * result + (armLength != null ? armLength.hashCode() : 0);
        result = 31 * result + (upperArmLength != null ? upperArmLength.hashCode() : 0);
        result = 31 * result + (lengthOfTheTrunk != null ? lengthOfTheTrunk.hashCode() : 0);
        result = 31 * result + (forkLength != null ? forkLength.hashCode() : 0);
        result = 31 * result + (headCircumference != null ? headCircumference.hashCode() : 0);
        result = 31 * result + (neckCircumference != null ? neckCircumference.hashCode() : 0);
        result = 31 * result + (onTheChest != null ? onTheChest.hashCode() : 0);
        result = 31 * result + (theChest != null ? theChest.hashCode() : 0);
        result = 31 * result + (underTheChest != null ? underTheChest.hashCode() : 0);
        result = 31 * result + onTheWaistWaistInTheNet;
        result = 31 * result + (inTheWaist != null ? inTheWaist.hashCode() : 0);
        result = 31 * result + (waistbandIsSurrounded != null ? waistbandIsSurrounded.hashCode() : 0);
        result = 31 * result + (hipCircumference != null ? hipCircumference.hashCode() : 0);
        result = 31 * result + (thighCircumference != null ? thighCircumference.hashCode() : 0);
        result = 31 * result + (inTheThighCircumference != null ? inTheThighCircumference.hashCode() : 0);
        result = 31 * result + (kneeCircumference != null ? kneeCircumference.hashCode() : 0);
        result = 31 * result + (ankleCircumference != null ? ankleCircumference.hashCode() : 0);
        result = 31 * result + (heelsCircumference != null ? heelsCircumference.hashCode() : 0);
        result = 31 * result + (armRhizosphere != null ? armRhizosphere.hashCode() : 0);
        result = 31 * result + (upperArmCircumference != null ? upperArmCircumference.hashCode() : 0);
        result = 31 * result + (elbowCircumference != null ? elbowCircumference.hashCode() : 0);
        result = 31 * result + (wristCircumference != null ? wristCircumference.hashCode() : 0);
        result = 31 * result + (hemCircumference != null ? hemCircumference.hashCode() : 0);
        result = 31 * result + (footMouth != null ? footMouth.hashCode() : 0);
        result = 31 * result + (beforeTheLength != null ? beforeTheLength.hashCode() : 0);
        result = 31 * result + (afterTheLength != null ? afterTheLength.hashCode() : 0);
        result = 31 * result + (sleeveLength != null ? sleeveLength.hashCode() : 0);
        result = 31 * result + (length != null ? length.hashCode() : 0);
        result = 31 * result + (straightCrotch != null ? straightCrotch.hashCode() : 0);
        return result;
    }
}
