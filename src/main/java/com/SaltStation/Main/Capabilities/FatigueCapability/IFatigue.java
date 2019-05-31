package com.SaltStation.Main.Capabilities.FatigueCapability;

public interface IFatigue {

    public void setFatigue(double points);
    public void setLimit(double points);
    public void setRegen(double points);
    public void add(double points);
    public void remove(double points);

    public double getFatigue();
    public double getLimit();
    public double getRegen();
}
