package hk.mc4u.junit5seleniumtest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppTest {
	CacheHelper cacheHelper;
	SquaredCalculator squaredCalculator;

	
//    @Test
    @DisplayName(value = "simple test")
    public void shouldAnswerWithTrue() {
    	Integer i = (new Random()).nextInt(100);
    	assertThat(i)
    		.isNotNull()
    		.isNotNegative()
    		.isLessThan(100)
    		.isEven();
    	
    }

    @BeforeEach
    public void init() {
    	cacheHelper = new CacheHelper();
		squaredCalculator = new SquaredCalculator(cacheHelper);
	}
    
    @Test
    public void whenCalculatingSquareValueAgain_thenCacheHasAllValues() {
    	
        for (int i = 10; i < 15; i++) {
        	Assertions.assertFalse(cacheHelper.getSquareNumberCache().containsKey(i));
            log.info("Square value of " + i + " is: "
              + squaredCalculator.getSquareValueOfNumber(i) + "\n");
        }      
        
        for (int i = 10; i < 15; i++) {
        	Assertions.assertTrue(cacheHelper.getSquareNumberCache().containsKey(i));
        	log.info("Square value of " + i + " is: "
              + squaredCalculator.getSquareValueOfNumber(i) + "\n");
        }
    }
}
