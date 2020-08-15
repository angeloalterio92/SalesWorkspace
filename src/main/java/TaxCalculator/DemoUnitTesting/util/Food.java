package TaxCalculator.DemoUnitTesting.util;

public enum Food {
	
	CASE_1("chocolate");
	
	
	private String value;

	Food (String value) {
		this.value = value;
	}
	
	public String getVal() {
        return value;
    }

}
