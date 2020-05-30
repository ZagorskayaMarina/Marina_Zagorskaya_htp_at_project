package tests;

import org.junit.Assert;
import web_pages.HotelsPage;
import web_pages.MainBookingPage;

public class Steps {
    MainBookingPage mainBookingPage = new MainBookingPage();

    public void checkMainBookingPage() throws InterruptedException {
        mainBookingPage.navigateToPage();
        mainBookingPage.enterCity("Париж");
        mainBookingPage.enterDate(3,10);
        mainBookingPage.enterGuestData(4, 0, 2);
        mainBookingPage.search();
    }

   HotelsPage hotelsPage = new HotelsPage();
    public void comparePrice(int idPriceCategory, int hotelId, int numberOfNight) throws InterruptedException {
        hotelsPage.selectPriceCategory(idPriceCategory);
        int priceOfCategory = hotelsPage.retrievePriceFromCategory(idPriceCategory);
        System.out.println("Prise of category " + priceOfCategory);
        Thread.sleep(6000);
        hotelsPage.sortByPrice();
        Thread.sleep(1000);
        //Здесь есть ошибка- это цена самого дорогого отеля
        int ipt = hotelsPage.getPriceOfHotelPerNight(1, 10);
        System.out.println("Price of 1 night in the first hotel: " + ipt);
        Assert.assertTrue(ipt >= priceOfCategory);
    }

}
