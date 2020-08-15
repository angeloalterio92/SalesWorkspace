package TaxCalculator.DemoUnitTesting.util;

public enum Medical {
	CASE_1("headache pills");
	
	
	private String value;

	Medical(String value) {
		this.value = value;
	}
	
	public String getVal() {
        return value;
    }
	
}
