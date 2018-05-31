package org.ms.module.ablecloud;

import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;

/**
 * @Author SuperAndy
 * @Date 2018-05-30 15:49
 */
@Alias("bewinchProperty")
public class BewinchProperty {
    private String physicalId;
    private LocalDateTime reportTime;
    private Integer rawWaterValue;
    private Integer cleanTotalWater;
    private Integer cleanWaterValue;
    private Integer deviceBreakdown;
    private Integer temperatureLock;
    private Integer handleWaterSpeed;
    private Integer currentPumpADValue;
    private Integer todayCleanHotWater;
    private Integer currentPumpPWNValue;
    private Integer currentVoltageValue;
    private Integer firstFilterLifeTIme;
    private Integer forthFilterLifeTime;
    private Integer measureWaterForever;
    private Integer thridFilterLifeTIme;
    private Integer todayCleanColdWater;
    private Integer secondFilterLifeTime;
    private Integer measureFetchWaterValue;
    private Integer afterLastFetchWaterTime;
    private Integer firstFilterSurplusScale;
    private Integer thridFilterSurplusScale;
    private Integer fourthFilterSurplusScale;
    private Integer secondFilterSurplusScale;
    private Integer currentTotalCleanWaterValue;
    private Integer currentFetchWaterRealityTemper;
    private Integer currentFetchWaterLockTemperature;
    private String snCode;
    private Integer reservePlace;
    private LocalDateTime createTime;

    public String getPhysicalId() {
        return physicalId;
    }
    public void setPhysicalId(String physicalId) {
        this.physicalId = physicalId;
    }
    public LocalDateTime getReportTime() {
        return reportTime;
    }
    public void setReportTime(LocalDateTime reportTime) {
        this.reportTime = reportTime;
    }
    public Integer getRawWaterValue() {
        return rawWaterValue;
    }
    public void setRawWaterValue(Integer rawWaterValue) {
        this.rawWaterValue = rawWaterValue;
    }
    public Integer getCleanTotalWater() {
        return cleanTotalWater;
    }
    public void setCleanTotalWater(Integer cleanTotalWater) {
        this.cleanTotalWater = cleanTotalWater;
    }
    public Integer getCleanWaterValue() {
        return cleanWaterValue;
    }
    public void setCleanWaterValue(Integer cleanWaterValue) {
        this.cleanWaterValue = cleanWaterValue;
    }
    public Integer getDeviceBreakdown() {
        return deviceBreakdown;
    }
    public void setDeviceBreakdown(Integer deviceBreakdown) {
        this.deviceBreakdown = deviceBreakdown;
    }
    public Integer getTemperatureLock() {
        return temperatureLock;
    }
    public void setTemperatureLock(Integer temperatureLock) {
        this.temperatureLock = temperatureLock;
    }
    public Integer getHandleWaterSpeed() {
        return handleWaterSpeed;
    }
    public void setHandleWaterSpeed(Integer handleWaterSpeed) {
        this.handleWaterSpeed = handleWaterSpeed;
    }
    public Integer getCurrentPumpADValue() {
        return currentPumpADValue;
    }
    public void setCurrentPumpADValue(Integer currentPumpADValue) {
        this.currentPumpADValue = currentPumpADValue;
    }
    public Integer getTodayCleanHotWater() {
        return todayCleanHotWater;
    }
    public void setTodayCleanHotWater(Integer todayCleanHotWater) {
        this.todayCleanHotWater = todayCleanHotWater;
    }
    public Integer getCurrentPumpPWNValue() {
        return currentPumpPWNValue;
    }
    public void setCurrentPumpPWNValue(Integer currentPumpPWNValue) {
        this.currentPumpPWNValue = currentPumpPWNValue;
    }
    public Integer getCurrentVoltageValue() {
        return currentVoltageValue;
    }
    public void setCurrentVoltageValue(Integer currentVoltageValue) {
        this.currentVoltageValue = currentVoltageValue;
    }
    public Integer getFirstFilterLifeTIme() {
        return firstFilterLifeTIme;
    }
    public void setFirstFilterLifeTIme(Integer firstFilterLifeTIme) {
        this.firstFilterLifeTIme = firstFilterLifeTIme;
    }
    public Integer getForthFilterLifeTime() {
        return forthFilterLifeTime;
    }
    public void setForthFilterLifeTime(Integer forthFilterLifeTime) {
        this.forthFilterLifeTime = forthFilterLifeTime;
    }
    public Integer getMeasureWaterForever() {
        return measureWaterForever;
    }
    public void setMeasureWaterForever(Integer measureWaterForever) {
        this.measureWaterForever = measureWaterForever;
    }
    public Integer getThridFilterLifeTIme() {
        return thridFilterLifeTIme;
    }
    public void setThridFilterLifeTIme(Integer thridFilterLifeTIme) {
        this.thridFilterLifeTIme = thridFilterLifeTIme;
    }
    public Integer getTodayCleanColdWater() {
        return todayCleanColdWater;
    }
    public void setTodayCleanColdWater(Integer todayCleanColdWater) {
        this.todayCleanColdWater = todayCleanColdWater;
    }
    public Integer getSecondFilterLifeTime() {
        return secondFilterLifeTime;
    }
    public void setSecondFilterLifeTime(Integer secondFilterLifeTime) {
        this.secondFilterLifeTime = secondFilterLifeTime;
    }
    public Integer getMeasureFetchWaterValue() {
        return measureFetchWaterValue;
    }
    public void setMeasureFetchWaterValue(Integer measureFetchWaterValue) {
        this.measureFetchWaterValue = measureFetchWaterValue;
    }
    public Integer getAfterLastFetchWaterTime() {
        return afterLastFetchWaterTime;
    }
    public void setAfterLastFetchWaterTime(Integer afterLastFetchWaterTime) {
        this.afterLastFetchWaterTime = afterLastFetchWaterTime;
    }
    public Integer getFirstFilterSurplusScale() {
        return firstFilterSurplusScale;
    }
    public void setFirstFilterSurplusScale(Integer firstFilterSurplusScale) {
        this.firstFilterSurplusScale = firstFilterSurplusScale;
    }
    public Integer getThridFilterSurplusScale() {
        return thridFilterSurplusScale;
    }
    public void setThridFilterSurplusScale(Integer thridFilterSurplusScale) {
        this.thridFilterSurplusScale = thridFilterSurplusScale;
    }
    public Integer getFourthFilterSurplusScale() {
        return fourthFilterSurplusScale;
    }
    public void setFourthFilterSurplusScale(Integer fourthFilterSurplusScale) {
        this.fourthFilterSurplusScale = fourthFilterSurplusScale;
    }
    public Integer getSecondFilterSurplusScale() {
        return secondFilterSurplusScale;
    }
    public void setSecondFilterSurplusScale(Integer secondFilterSurplusScale) {
        this.secondFilterSurplusScale = secondFilterSurplusScale;
    }
    public Integer getCurrentTotalCleanWaterValue() {
        return currentTotalCleanWaterValue;
    }
    public void setCurrentTotalCleanWaterValue(Integer currentTotalCleanWaterValue) {
        this.currentTotalCleanWaterValue = currentTotalCleanWaterValue;
    }
    public Integer getCurrentFetchWaterRealityTemper() {
        return currentFetchWaterRealityTemper;
    }
    public void setCurrentFetchWaterRealityTemper(Integer currentFetchWaterRealityTemper) {
        this.currentFetchWaterRealityTemper = currentFetchWaterRealityTemper;
    }
    public Integer getCurrentFetchWaterLockTemperature() {
        return currentFetchWaterLockTemperature;
    }
    public void setCurrentFetchWaterLockTemperature(Integer currentFetchWaterLockTemperature) {
        this.currentFetchWaterLockTemperature = currentFetchWaterLockTemperature;
    }
    public String getSnCode() {
        return snCode;
    }
    public void setSnCode(String snCode) {
        this.snCode = snCode;
    }
    public Integer getReservePlace() {
        return reservePlace;
    }
    public void setReservePlace(Integer reservePlace) {
        this.reservePlace = reservePlace;
    }
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    @Override
    public String toString() {
        return "BewinchProperty [physicalId=" + physicalId + ", reportTime=" + reportTime + ", rawWaterValue="
                + rawWaterValue + ", cleanTotalWater=" + cleanTotalWater + ", cleanWaterValue=" + cleanWaterValue
                + ", deviceBreakdown=" + deviceBreakdown + ", temperatureLock=" + temperatureLock
                + ", handleWaterSpeed=" + handleWaterSpeed + ", currentPumpADValue=" + currentPumpADValue
                + ", todayCleanHotWater=" + todayCleanHotWater + ", currentPumpPWNValue=" + currentPumpPWNValue
                + ", currentVoltageValue=" + currentVoltageValue + ", firstFilterLifeTIme=" + firstFilterLifeTIme
                + ", forthFilterLifeTime=" + forthFilterLifeTime + ", measureWaterForever=" + measureWaterForever
                + ", thridFilterLifeTIme=" + thridFilterLifeTIme + ", todayCleanColdWater=" + todayCleanColdWater
                + ", secondFilterLifeTime=" + secondFilterLifeTime + ", measureFetchWaterValue="
                + measureFetchWaterValue + ", afterLastFetchWaterTime=" + afterLastFetchWaterTime
                + ", firstFilterSurplusScale=" + firstFilterSurplusScale + ", thridFilterSurplusScale="
                + thridFilterSurplusScale + ", fourthFilterSurplusScale=" + fourthFilterSurplusScale
                + ", secondFilterSurplusScale=" + secondFilterSurplusScale + ", currentTotalCleanWaterValue="
                + currentTotalCleanWaterValue + ", currentFetchWaterRealityTemper=" + currentFetchWaterRealityTemper
                + ", currentFetchWaterLockTemperature=" + currentFetchWaterLockTemperature + ", snCode=" + snCode
                + ", reservePlace=" + reservePlace + ", createTime=" + createTime + "]";
    }
}
