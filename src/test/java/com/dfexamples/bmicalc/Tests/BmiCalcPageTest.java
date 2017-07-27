package com.dfexamples.bmicalc.Tests;

import com.dfexamples.bmicalc.Pages.BmiCalculatorPage;

import org.junit.Ignore;
import org.junit.Test;

//import static com.dfexamples.bmicalc.Pages.BmiCalculatorPage.CalculateBmi;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;

public class BmiCalcPageTest extends BaseTest {

//    String height;
//    String weight;
//    String bmi;
//    String bmiCategory;
//
//    @Parameterized.Parameters
//    public static Collection<Object[]> data() {
//        Object[][] data = new  Object[][]{
//                {"160","45","17.6","Underweight"},
//                {"168","70","24.8","Normal"},
//                {"181","89","27.2","Overweight"},
//                {"178","100","31.6","Obesity"}
//        };
//        return Arrays.asList(data);
//    }
//
//    public BmiCalcPageTest (String height, String weight, String bmi, String bmiCategory) {
//        this.height = height;
//        this.weight =  weight;
//        this.bmi = bmi;
//        this.bmiCategory =  bmiCategory;
//    }

    @Test
    public void firstBasicTest() {
        BmiCalculatorPage.goTo();
    }

    @Ignore
    @Test
    public void TestBMICalculatorWithDataSet() throws Exception {
        BmiCalculatorPage.goTo();

//        assertThat("Calculation failed - wrong BMI", CalculateBmi(height, weight).getBmi().toString(), is(bmi.toString()));
//        assertThat("Calculation failed - wrong BMI Category", CalculateBmi(height, weight).getBmiCategory().toString(), is(bmiCategory.toString()));
    }
}
