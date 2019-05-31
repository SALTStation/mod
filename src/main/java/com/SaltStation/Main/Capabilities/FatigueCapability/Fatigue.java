package com.SaltStation.Main.Capabilities.FatigueCapability;

public class Fatigue implements IFatigue {

    private double fatigue = 0;
    private double limit = 10;
    private double regen = 0;

    @Override
    public void setFatigue(double points) {
        if(points>this.fatigue){
            this.fatigue=this.limit;
        }
        else{
            this.fatigue=points;
        }


    }

    public void setLimit(double points) {
        this.limit=points;

    }

    public void setRegen(double points) {
        this.regen=points;

    }

    @Override
    public void add(double points) {
        if (this.fatigue + points < this.limit){
            this.fatigue+=points;
        }
        else{
            this.fatigue=this.limit;
        }


    }

    @Override
    public void remove(double points) {
        if (this.fatigue - points > 0){
            this.fatigue-=points;
        }
        else{
            this.fatigue=0;
        }


    }

    @Override
    public double getFatigue() {
        return this.fatigue ;
    }

    @Override
    public double getLimit() {
        return this.limit ;
    }

    @Override
    public double getRegen() {
        return this.regen ;
    }
}
