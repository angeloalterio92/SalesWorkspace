package TaxCalculator.DemoUnitTesting;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import TaxCalculator.DemoUnitTesting.model.Product;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	TaxCalculator.DemoUnitTesting.App t = new TaxCalculator.DemoUnitTesting.App();

	@Test
	public void testCaseOne() {
		
		List<Product> products= new ArrayList<Product>();
		HashMap<String, BigDecimal> output = new HashMap<String, BigDecimal>();
		
		Product p1 = new Product("book", 12.49, 1);
		Product p2 = new Product("music CD", 14.99, 1);
		Product p3 = new Product("chocolate bar", 0.85, 1);
		products.add(p1);
		products.add(p2);
		products.add(p3);
		
		output.put("book", new BigDecimal(12.49).setScale(2, RoundingMode.HALF_UP));
		output.put("music CD", new BigDecimal(16.49).setScale(2, RoundingMode.HALF_UP));
		output.put("chocolate bar", new BigDecimal(0.85).setScale(2, RoundingMode.HALF_UP));
		output.put("tax", new BigDecimal(1.50).setScale(2, RoundingMode.HALF_UP));
		output.put("total", new BigDecimal(29.83).setScale(2, RoundingMode.HALF_UP));
		
		assertEquals(t.extractPrice(products), output);
	}
	
	@Test
	public void testCaseTwo() {
		
		List<Product> products= new ArrayList<Product>();
		HashMap<String, BigDecimal> output = new HashMap<String, BigDecimal>();
		
		Product p4 = new Product("imported box of chocolates", 10.00, 1);
		Product p5 = new Product("imported bottle of perfume", 47.50, 1);
		products.add(p4);
		products.add(p5);
		
		output.put("imported box of chocolates", new BigDecimal(10.50).setScale(2, RoundingMode.HALF_UP));
		output.put("imported bottle of perfume", new BigDecimal(54.65).setScale(2, RoundingMode.HALF_UP));
		output.put("tax", new BigDecimal(7.65).setScale(2, RoundingMode.HALF_UP));
		output.put("total", new BigDecimal(65.15).setScale(2, RoundingMode.HALF_UP));
		
		assertEquals(t.extractPrice(products), output);
	}
	
	@Test
	public void testCaseThree() {
		
		List<Product> products= new ArrayList<Product>();
		HashMap<String, BigDecimal> output = new HashMap<String, BigDecimal>();
		
		Product p6 = new Product("imported bottle of perfume", 27.99, 1);
		Product p7 = new Product("bottle of perfume", 18.99, 1);
		Product p8 = new Product("packet of headache pills", 9.75, 1);
		Product p9 = new Product("box of imported chocolates", 11.25, 1);
		products.add(p6);
		products.add(p7);
		products.add(p8);
		products.add(p9);
		
		output.put("imported bottle of perfume", new BigDecimal(32.19).setScale(2, RoundingMode.HALF_UP));
		output.put("bottle of perfume", new BigDecimal(20.89).setScale(2, RoundingMode.HALF_UP));
		output.put("packet of headache pills", new BigDecimal(9.75).setScale(2, RoundingMode.HALF_UP));
		output.put("box of imported chocolates", new BigDecimal(11.85).setScale(2, RoundingMode.HALF_UP));
		output.put("tax", new BigDecimal(6.70).setScale(2, RoundingMode.HALF_UP));
		output.put("total", new BigDecimal(74.68).setScale(2, RoundingMode.HALF_UP));
		
		assertEquals(t.extractPrice(products), output);
	}
	
	@Test
	//Test case to check the receipt details for input 3
	public void testCaseFour() {
		
		List<Product> products= new ArrayList<Product>();
		StringBuilder output = new StringBuilder();

    	String newline = "\n";
		
		Product p6 = new Product("imported bottle of perfume", 27.99, 1);
		Product p7 = new Product("bottle of perfume", 18.99, 1);
		Product p8 = new Product("packet of headache pills", 9.75, 1);
		Product p9 = new Product("box of imported chocolates", 11.25, 1);
		products.add(p6);
		products.add(p7);
		products.add(p8);
		products.add(p9);
		
		output.append("1 imported bottle of perfume: 32.19").append(newline);
		output.append("1 bottle of perfume: 20.89").append(newline);
		output.append("1 packet of headache pills: 9.75").append(newline);
		output.append("1 box of imported chocolates: 11.85").append(newline);
		output.append("Sales Taxes: 6.70").append(newline);
    	output.append("Total: 74.68");
		
		assertEquals(t.buildOutput(products), output.toString());
	}
	
}
