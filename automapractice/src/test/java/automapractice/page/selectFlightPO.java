package automapractice.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class selectFlightPO extends basePO{

    public selectFlightPO(WebDriver driver) {
        super(driver);
    }

    //@FindBy(css = "#ry-modal-portal > div > fare-upgrade-container > fare-upgrade-component > ry-dialog > div > div > div.fare-upgrade-footer > button.fare-upgrade-footer-continue_button.ry-button--outline-light-blue.ry-button--full")
    //public WebElement buttonContinueWithValueFare;
    
    private String qtd;

    public void selectTheFlightsDestinationReturn(){

        driver.findElement(By.xpath("/html/body/app-root/flights-root/div/div/div/div/flights-lazy-content/flights-summary-container/flights-summary/div/div[1]/journey-container/journey/flight-list/div/flight-card/div/div/div[1]/div")).click();
        
        driver.findElement(By.xpath("/html/body/app-root/flights-root/div/div/div/div/flights-lazy-content/flights-summary-container/flights-summary/div/div[2]/journey-container/journey/flight-list/div/flight-card/div/div/div[1]/div")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement selectFare = driver.findElement(By.xpath("//span[text()=' Continue for ']"));
        js.executeScript("arguments[0].scrollIntoView();", selectFare);

        selectFare.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement buttonContinueWithValueFare = driver.findElement(By.xpath("//button[text()=\" Continue with Value fare \"]"));
        
        if (buttonContinueWithValueFare.isDisplayed()){
            buttonContinueWithValueFare.click();
        }

        driver.findElement(By.xpath("//span[text()='Log in later']")).click();
    }
    /**
     * Information about the passagers
     * @param order order of input (1,2,3...)
     * @param title title avaible (Mr, Mrs, Ms)
     * @param firstName
     * @param lastName
     */
    public void inputInformationOfAdultPassager(Integer order, String title, String firstName, String lastName){
        //order of button equals order
        //order to input the information name and lastname is neworder
        Integer newOrder = order - 1;

        WebElement FormAdult = driver.findElement(By.xpath("//*[@data-ref='pax-details__ADT-"+newOrder+"']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", FormAdult);     
        
        driver.findElement(By.xpath("(//*[@id=\"title-0-error-message\"]/div[2]/button)")).click(); //["+order+"]
        
        //seleciona titulo
        driver.findElement(By.xpath("//*[@id=\"title-0-error-message\"]/div[2]/div/div/ry-dropdown-item["+selectTitle(title)+"]/button/div/div[1]")).click();
        
        FormAdult.findElement(By.name("form.passengers.ADT-"+newOrder+".name")).sendKeys(firstName);
        FormAdult.findElement(By.name("form.passengers.ADT-"+newOrder+".surname")).sendKeys(lastName);

    }

    public void inputInformationOfChildPassager(Integer order, String firstName, String LastName){
        Integer newOrder = order - 1;

        WebElement FormChild = driver.findElement(By.xpath("//*[@data-ref='pax-details__CHD-"+newOrder+"']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", FormChild);

        FormChild.findElement(By.name("form.passengers.CHD-"+newOrder+".name")).sendKeys(firstName);
        FormChild.findElement(By.name("form.passengers.CHD-"+newOrder+".surname")).sendKeys(LastName);

    }
    
    public String selectTitle(String title){

            switch(title){
                case "Mr":
                    title = "1";
                    break;
                case "Mrs":
                    title = "2";
                    break;
                case "Ms":
                    title = "3";
                    break;
            }
            
        return title;
    }

    public void continueToSelectSeats(){
        
        driver.findElement(By.xpath("/html/body/app-root/flights-root/div/div/div/div/flights-lazy-content/ng-component/div/continue-flow-container/continue-flow/div/div/span/button")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement popupFamily = driver.findElement(By.xpath("//button[text()=\" Okay, got it. \"]"));

        if (popupFamily.isEnabled()){
            popupFamily.click();
        }
    }

    public void chooseSeatPassengers(Integer numberSeat, Integer QtdPassengers){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //TODO: input conditionals if qtdpassengers is 0;

        for(int i = 1; i<=QtdPassengers; i++){
            
            driver.findElement(By.id("seat-"+numberSeat+convertNumberInLetter(i))).click();
        }

        driver.findElement(By.xpath("//button[text()=\" Next flight \"]")).click();

        WebElement popUPReserveSeatTheSame = driver.findElement(By.xpath("//button[text()=\" No, thanks \"]"));

        if (popUPReserveSeatTheSame.isDisplayed()){
            popUPReserveSeatTheSame.click();
        }
    
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        for(int i = 1; i<=QtdPassengers; i++){
            
            driver.findElement(By.id("seat-"+numberSeat+convertNumberInLetter(i))).click();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//button[text()=\" Continue \"]")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//button[text()=\" No, thanks \"]")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String convertNumberInLetter(int i) {
       
        switch(i){
            case 1:
                qtd = "A";
                break;
            case 2:
                qtd = "B";
                break;
            case 3:
                qtd = "C";
                break;
            case 4:
                qtd = "D";
                break;
            case 5:
                qtd = "E";
                break;
        }
       
        return qtd;
    }

}
