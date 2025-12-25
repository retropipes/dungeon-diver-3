package com.puttysoftware.dungeondiver3.support;

public class CloneableObject implements Cloneable {
    // Constructor
    public CloneableObject() {
	super();
    }

    // Method
    @Override
    public Object clone() {
	return new CloneableObject();
    }
}
