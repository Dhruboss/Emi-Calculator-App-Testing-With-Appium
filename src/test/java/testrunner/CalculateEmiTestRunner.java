package testrunner;

import dataset.Dataset;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import screens.EmiCalcPage;
import setup.Setup;

public class CalculateEmiTestRunner extends Setup {
    EmiCalcPage cal;

    @BeforeTest
    public void calculateStart(){
        cal = new EmiCalcPage(driver);
        cal.btnStart.click();
    }
    @Test(dataProvider = "data-provider", dataProviderClass = Dataset.class)
    public void calculateEMI(int loanAmount,double interest,int periodYear,double prosFee,int monthlyEmi, int interestResult, int prosFeeResult, int totalPayment) throws InterruptedException {

        cal = new EmiCalcPage(driver);
        cal.calculateEMI(loanAmount,interest,periodYear,prosFee);

        String mEmi = cal.txtMonthlyEmi.getText();
        String iResult = cal.txtInterestResult.getText();
        String pFeeResult = cal.txtProsFeeResult.getText();
        String tPayment = cal.txtTotalPayment.getText();

        mEmi= String.valueOf((int)Math.floor(Double.parseDouble(mEmi.replace(",",""))));
        iResult= String.valueOf((int)Math.floor(Double.parseDouble(iResult.replace(",",""))));
        pFeeResult= String.valueOf((int)Math.floor(Double.parseDouble(pFeeResult.replace(",",""))));
        tPayment= String.valueOf((int)Math.floor(Double.parseDouble(tPayment.replace(",",""))));

        Assert.assertEquals(mEmi,String.valueOf(monthlyEmi));
        Assert.assertEquals(iResult,String.valueOf(interestResult));
        Assert.assertEquals(pFeeResult,String.valueOf(prosFeeResult));
        Assert.assertEquals(tPayment,String.valueOf(totalPayment));

        Thread.sleep(1000);
        cal.btnReset.click();
        Thread.sleep(1000);

    }

}
