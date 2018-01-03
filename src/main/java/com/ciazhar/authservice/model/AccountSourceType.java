package com.ciazhar.authservice.model;


public enum AccountSourceType implements IntentStateWithCodeAndDescription {

    DOSCOM(1,"doscom account"),
    JELAJAH(2,"jelajah account"),
    MAKETTO(3,"maketto account"),
    ANIMUS(4,"animus account"),
    EASYTRANS(5,"easytrans account"),
    UNKNOWN(0,"unknown account");

    private int code;
    private String description;

    AccountSourceType(int code, String description){
        this.code = code;
        this.description = description;
    }

	@Override
	public int code() {
		return this.code;
	}

	@Override
	public String description() {
		return this.description;
	}
    
    
}