package com.vayvonnhanh;

public enum Status {
	  ACTIVE(0),
	    DELETED(1);

	    private final int value;

	    Status(int value) {
	        this.value = value;
	    }

	    public int getValue() {
	        return value;
	    }
}
