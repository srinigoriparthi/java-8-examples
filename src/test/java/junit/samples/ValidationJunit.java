package junit.samples;
import static org.junit.Assert.*;
import junitsamples.ValidationBO;
import org.junit.Before;
import org.junit.Test;


public class ValidationJunit {

    ValidationBO validationBO = null;
    String validEmail = null;
    String inValidEmail = null;

    @Before
    public void init(){
        validationBO = new ValidationBO();
    }

    /**
     * Testing valid Email Address
     */
    @Test
    public void testValidEmail() {
        validEmail = "vamsikrishna.mca2006@cognizant.com";
        boolean isValidEmail = validationBO.validateEmail(validEmail);
        assertTrue(isValidEmail);
        System.out.println("Valid Email Test Case Result is:"+ (isValidEmail ? "Success" : "Failed"));
    }

    /**
     *  Testing Invalid Email Address
     */
    @Test
    public void testInValidEmail() {
        inValidEmail = "vamsikrishna.mca2006&cognizant.com";
        boolean isInValidEmail = validationBO.validateEmail(inValidEmail);
        assertFalse(isInValidEmail);
        System.out.println("In Valid Email Test Case Result is:"+ (isInValidEmail ? "Success" : "Failed"));
    }

    /**
     * Cleaning
     */
    @Test
    public void destroy() {
        validationBO = null;
        System.out.println("Email Validation Test Ends !!");
    }

}
