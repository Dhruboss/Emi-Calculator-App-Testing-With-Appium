package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static setup.Setup.PACKAGE_NAME;

public class EmiCalcPage {
    @FindBy(id = PACKAGE_NAME + ":id/btnStart")
    public AndroidElement btnStart;
    @FindBy(id = PACKAGE_NAME + ":id/etLoanAmount")
    AndroidElement txtLoanAmount;
    @FindBy(id = PACKAGE_NAME + ":id/etInterest")
    AndroidElement txtInterest;
    @FindBy(id = PACKAGE_NAME + ":id/etYears")
    AndroidElement txtPeriodYear;
    @FindBy(id = PACKAGE_NAME + ":id/etMonths")
    AndroidElement txtPeriodMonth;
    @FindBy(id = PACKAGE_NAME + ":id/etEMI")
    AndroidElement txtEmiAmount;
    @FindBy(id = PACKAGE_NAME + ":id/etFee")
    AndroidElement txtProsFee;
    @FindBy(id = PACKAGE_NAME + ":id/btnCalculate")
    AndroidElement btnCalculate;


    @FindBy(id = PACKAGE_NAME + ":id/monthly_emi_result")
    public AndroidElement txtMonthlyEmi;
    @FindBy(id = PACKAGE_NAME + ":id/total_interest_result")
    public AndroidElement txtInterestResult;
    @FindBy(id = PACKAGE_NAME + ":id/processing_fee_result")
    public AndroidElement txtProsFeeResult;
    @FindBy(id = PACKAGE_NAME + ":id/total_payment_result")
    public AndroidElement txtTotalPayment;
    @FindBy(id = PACKAGE_NAME + ":id/btnReset")
    public AndroidElement btnReset;


    public EmiCalcPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void calculateEMI(int loanAmount,double interest,int periodYear,double prosFee) {
        txtLoanAmount.sendKeys(""+loanAmount+"");
        txtInterest.sendKeys(""+interest+"");
        txtPeriodYear.sendKeys(""+periodYear+"");
        txtProsFee.sendKeys(""+prosFee+"");
        btnCalculate.click();
        txtEmiAmount.getText();
    }
}
