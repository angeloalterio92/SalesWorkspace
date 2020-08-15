package TaxCalculator.DemoUnitTesting.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;

import TaxCalculator.DemoUnitTesting.model.Product;

public class Taxation {
	
	public static HashMap<String, Double> calculateTaxAndNet (List<Product> products) {
		
		HashMap<String, Double> map = new HashMap<String, Double>();
		double totalNet = 0;
		double taxAmount = 0;
		
		for (Product prod : products) {
			
			double prodTax = 0;
			
			totalNet += prod.getPrice();
			
			//calculate basic tax if product is not tax free
			if (!prod.isTaxFree(prod.getName())) {
				double calculated = calculateBasicTax(prod);
				taxAmount += calculated;
				prodTax += calculated;
			}
			
			//case of imported products with additional tax
			if (prod.isImported(prod.getName())) {
				double calculated = calculateImportedTax(prod);
				taxAmount += calculated;
				prodTax += calculated;
			}
			
			//Round up tax to 0.05
			prodTax = Math.ceil(prodTax * 20) / 20.0;
			prod.setGrossPrice(new BigDecimal(prodTax + prod.getPrice()).setScale(2, RoundingMode.HALF_UP));
		}
		
		//Round up tax to 0.05
		taxAmount = Math.ceil(taxAmount * 20) / 20.0;
		
		map.put("tax", taxAmount);
		map.put("net", totalNet);
		
		return map;
	}

	private static double calculateImportedTax(Product prod) {
		return (prod.getPrice()*0.05);
	}

	private static double calculateBasicTax(Product prod) {
		return (prod.getPrice()*0.1);
		
	}
	
}
