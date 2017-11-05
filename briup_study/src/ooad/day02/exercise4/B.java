package ooad.day02.exercise4;

import java.io.Serializable;

public class B implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;
	private C c;

	public B(C c) {
		this.c = c;
	}

	public C getC() {
		return c;
	}

	public void setC(C c) {
		this.c = c;
	}

	@Override
	public String toString() {
		return "B [c=" + c + "]";
	}

	
}
