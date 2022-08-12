package automapractice.test;

import org.junit.BeforeClass;
import org.junit.Test;
import automapractice.page.searchFlightPO;
import automapractice.page.selectFlightPO;

public class BuyTicketFlight extends baseTest {
   
    public static searchFlightPO searchFlyPO;
    public static selectFlightPO selectFlyPO;
        
    @BeforeClass
    public static void testPrepare(){
        searchFlyPO = new searchFlightPO(driver);
        selectFlyPO = new selectFlightPO(driver);
    }


    @Test
    public void TC001_BuyTicketFlightOnRaynairWebSite(){

        searchFlyPO.checkpopupcookies();
        searchFlyPO.inputDepartureAndDestination("Lisbon", "Paris Beauvais");
        searchFlyPO.inputDateDeparture("18", "August", "2022");
        searchFlyPO.inputDateReturn("25", "August", "2022");
        searchFlyPO.chooseNumberOfPassengers(2,2);
        searchFlyPO.clickOnSearchButton();

        selectFlyPO.selectTheFlightsDestinationReturn();
        
        selectFlyPO.inputInformationOfAdultPassager(1, "Ms", "Karina", "Silva");
        selectFlyPO.inputInformationOfAdultPassager(2, "Ms", "Tayrine", "Filgueira");
        selectFlyPO.inputInformationOfChildPassager(1, "Isabela", "Mota");
        selectFlyPO.inputInformationOfChildPassager(2, "Gustavo", "Henrique");

        selectFlyPO.continueToSelectSeats();
        selectFlyPO.chooseSeatPassengers(22,4);

        //select type of bags
    }
}
