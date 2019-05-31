package com.SaltStation.Main.Spells;

public class SpellManager {

    public SpellManager(){

    }
    public Spell manageSpells(String cs){
        if(cs=="bett"){
            return new bettfinder();
        }
        else{
            return new testSpell();
        }
    }
}
