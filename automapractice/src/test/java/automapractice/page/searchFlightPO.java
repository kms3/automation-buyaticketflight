package automapractice.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class searchFlightPO extends basePO {

    public searchFlightPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#input-button__departure")
    public WebElement buttonInputDeparture;

    @FindBy(css = "#input-button__destination")
    public WebElement buttonInputDestination;

   
    public void checkpopupcookies(){
        WebElement popup = driver.findElement(By.xpath("//*[@class=\"cookie-popup-with-overlay__button\"]"));

        if (popup.isEnabled()){
            popup.click();
        }else{
            System.out.println("The cookie's pop-up wasn't displayied");
        }
        
    }

    public void inputDepartureAndDestination(String departure, String destination){
        buttonInputDeparture.click();
        buttonInputDeparture.sendKeys(departure);

        buttonInputDestination.click();
        buttonInputDestination.sendKeys(destination);

        driver.findElement(By.xpath("//span[text()=' "+destination+" ']")).click();
    }

    public void inputDateDeparture(String day, String month, String year) {
        
        String monthYearTrip = month + " " + year;

        String expectedDateDeparture = year+"-"+convertMonth(month)+"-"+day;

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        for (int i = 1; i<=12; i++){
            String calendarMonthName = driver.findElement(By.xpath("(//*[@class=\"calendar__month-name\"])[1]")).getText();
            if (calendarMonthName.equals(monthYearTrip)) {
                break;
            }else {
                driver.findElement(By.xpath("(//*[@data-ref='calendar-btn-next-month'])")).click();
                
            }
        }
       
        driver.findElement(By.xpath("//*[@data-id='"+expectedDateDeparture+"']")).click();
    }

    public void inputDateReturn(String day, String month, String year) {
        
        String monthYearTrip = month + " " + year;

        String expectedDateDeparture = year+"-"+convertMonth(month)+"-"+day;

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        for (int i = 1; i<=12; i++){
            String calendarMonthName = driver.findElement(By.xpath("(//*[@class=\"calendar__month-name\"])[1]")).getText();
            if (calendarMonthName.equals(monthYearTrip)) {
                break;
            }else {
                driver.findElement(By.xpath("(//*[@data-ref='calendar-btn-next-month'])")).click();
                
            }
        }
       
        driver.findElement(By.xpath("//*[@data-id='"+expectedDateDeparture+"']")).click();
    }

    public String convertMonth(String month){

        switch(month){
            case "January":
                month = "01";
                break;
            case "February":
                month = "02";
                break;
            case "March":
                month = "03";
                break;
            case "April":
                month = "04";
                break;
            case "May":
                month = "05";
                break;
            case "June":
                month = "06";
                break;
            case "July":
                month = "07";
                break;
            case "August":
                month = "08";
                break;
            case "September":
                month = "09";
                break;
            case "October":
                month = "07";
                break;
            case "November":
                month = "08";
                break;
            case "December":
                month = "09";
                break;
        }
        
        return month;
    }

    public void chooseNumberOfPassengers(Integer adult, Integer child){
        // i = 2 because the website all starts with one
        for (int i = 1; i <= adult; i++){
            if (i == adult ){
                //do nothing
                break;
            }else{
                driver.findElement(By.xpath("(//*[@data-ref='counter.counter__increment'])[1]")).click();
            }    
        }

        for (int i = 1; i <= child; i++){
            driver.findElement(By.xpath("(//*[@data-ref='counter.counter__increment'])[3]")).click();
        }

    }

    public void clickOnSearchButton(){
        driver.findElement(By.xpath("//*[@data-ref=\"flight-search-widget__cta\"]")).click();
    }

   
}
