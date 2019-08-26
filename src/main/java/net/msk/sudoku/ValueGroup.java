package net.msk.sudoku;

import java.util.Arrays;

public class ValueGroup {
	
	private Integer[] values;
	
	public ValueGroup() {
		this.values = new Integer[9];
	}
	
	ValueGroup(final Integer[] values) {
		this.values = values.clone();
	}
	
	Integer[] getValues() {
		return this.values.clone();
	}
	
	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		final ValueGroup that = (ValueGroup) o;
		return Arrays.equals(this.values, that.values);
	}
	
	@Override
	public int hashCode() {
		return Arrays.hashCode(this.values);
	}
}
