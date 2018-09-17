package com.nexdev.enyason.ohmslawexperiment;

/**
 * Created by enyason on 9/17/18.
 */

public class OhmsLawResult {

    String voltage,current;

    public OhmsLawResult(String voltage, String current) {
        this.voltage = voltage;
        this.current = current;
    }

    public String getVoltage() {
        return voltage;
    }

    public String getCurrent() {
        return current;
    }
}
