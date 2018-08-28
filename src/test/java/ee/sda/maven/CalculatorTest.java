package ee.sda.maven;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert.*;


public class CalculatorTest {

  @Test
  public void sum_Returns0_IfCalledWithNoArgs() {
    // given
    Calculator calculator = new Calculator();

    // when
    int sum = calculator.sum();

    // then
    Assert.assertEquals(0, sum);
  }

  @Test
  public void sum_Returns0_IfCalledWithNull() {
    // given
    Calculator calculator = new Calculator();
    String input = null;

    // when
    int sum = calculator.sum(input);

    // then
    assert sum == 10;
    Assert.assertEquals(0, sum);
  }

  @Test
  public void sum_Returns0_IfInputHasNoNumbers() {
    Calculator calculator = new Calculator();

    int sum = calculator.sum("It's great to write tests at last!");

    Assert.assertEquals(0, sum);
  }

  @Test
  public void sum_ReturnsSameNumber_IfInputIsOneNumber() {
    Calculator calculator = new Calculator();

    int sum = calculator.sum("100");

    Assert.assertEquals(100, sum);
  }

  @Test
  public void sum_ReturnsCorrectSum_IfInputHasSumOfTwoNumbers() {
    Calculator calculator = new Calculator();

    int sum = calculator.sum("100+123");

    Assert.assertEquals(223, sum);
  }


  @Test
  public void sum_ReturnsCorrectSum_IfInputHasPartlyValidNumbers() {
    Calculator calculator = new Calculator();

    int sum = calculator.sum("100+12as3");

    Assert.assertEquals(100, sum);
  }

  @Test
  public void sum_ReturnsCorrectSum_IfInputHasManyNumbers() {
    Calculator calculator = new Calculator();

    int sum = calculator.sum("100+1+2+3+4+5+6+7+8+9+10");

    Assert.assertEquals(155, sum);
  }

  @Test
  public void sum_ReturnsCorrectSum_IfInputHasNegativeNumbers() {
    Calculator calculator = new Calculator();

    int sum = calculator.sum("-100+-1");

    Assert.assertEquals(-101, sum);
  }

}
