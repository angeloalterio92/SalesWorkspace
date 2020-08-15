package TaxCalculator.DemoUnitTesting;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;

import TaxCalculator.DemoUnitTesting.model.Product;
import TaxCalculator.DemoUnitTesting.util.Taxation;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	//TODO generate input to process
    	
        System.out.println( "Hello World!" );
        
    }
    
    public HashMap<String, BigDecimal> extractPrice(List<Product> input) {
		
		HashMap<String, BigDecimal> output = new HashMap<String, BigDecimal>();
		
		HashMap<String, Double> map = Taxation.calculateTaxAndNet(input);
		
		BigDecimal taxTotal = new BigDecimal(map.get("tax")).setScale(2, RoundingMode.HALF_UP);
		BigDecimal totalPrice = (new BigDecimal(map.get("net") + map.get("tax")).setScale(2, RoundingMode.HALF_UP));
		
		for (Product prod : input) {
			output.put(prod.getName(), prod.getGrossPrice());
		}
		
		output.put("tax", taxTotal);
		output.put("total", totalPrice);
		
		return output;
	}
    
    public String buildOutput (List<Product> input) {
    	
    	StringBuilder output = new StringBuilder();
    	String spacer = " ";
    	String separator = ": ";
    	String newline = "\n";
    	HashMap<String, BigDecimal> calculated = extractPrice(input);
    	
    	for (Product prod : input) {
    		output.append(prod.getQuantity()).append(spacer);
    		output.append(prod.getName()).append(separator);
    		output.append(prod.getGrossPrice()).append(newline);
    	}
    	
    	output.append("Sales Taxes").append(separator).append(calculated.get("tax")).append(newline);
    	output.append("Total").append(separator).append(calculated.get("total"));
    	
    	return output.toString();
    	
    }
}
