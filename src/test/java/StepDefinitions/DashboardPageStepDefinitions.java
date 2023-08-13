package StepDefinitions;

import Hooks.DriverHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static StepDefinitions.CommonStepDefinitions.getElement;

public class DashboardPageStepDefinitions {

    private  WebDriver driver;
    Actions action;
    public DashboardPageStepDefinitions(DriverHooks hooks){
        this.driver= hooks.getDriver();
    }


    By createButton= By.xpath("//li[@data-testid='create-board-tile']");
    By createBoardBox=By.xpath("//button[contains(@data-testid, 'create-board')]");
    By boardTitleInputField = By.xpath("//input[@data-testid='create-board-title-input']");
    By createBoardSubmitButton=By.xpath("//button[@data-testid='create-board-submit-button']");
    By ListInputField=By.xpath("//input[@class='list-name-input']");
    By addListButton=By.xpath("//input[@value='Add list']");
    By addCardButton=By.xpath("(//span[text()='Add a card'])[1]");
    By enterCardName=By.xpath("//textarea[contains(@placeholder, 'Enter a title for this card')]");
    By addCardToListButton=By.xpath("//input[@value='Add card']");
    By closeAddCardButton=By.xpath("(//a[contains(@class,'icon-close')])[1]");
    By cardFromFirstList=By.xpath("//a[@data-testid='trello-card']");
    By secondListDropField=By.xpath("(//div[@class='list-cards u-fancy-scrollbar js-list-cards js-sortable ui-sortable'])[2]");
    By secondListCard=By.xpath("//div[contains(@class,'list-card-details js-card-details')]");
    @Then("I create board with the name {string}")
    public void createBoardWithName(String boardName) {
        getElement(createButton).click();
        getElement(createBoardBox).click();
        getElement(boardTitleInputField).sendKeys(boardName);
        getElement(createBoardSubmitButton).click();
    }

    @And("I create two list with the name {string} and {string}")
    public void iCreateTwoListWithTheNameAnd(String list1, String lis2) {
        getElement(ListInputField).sendKeys(list1);
        getElement(addListButton).click();
        getElement(ListInputField).sendKeys(lis2);
        getElement(addListButton).click();
    }

    @Then("I add card to the ListA with the name {string}")
    public void addCardToTheListA(String cardName) {
        getElement(addCardButton).click();
        getElement(enterCardName).sendKeys(cardName);
        getElement(addCardToListButton).click();
        getElement(closeAddCardButton).click();
    }

    @And("I move the card from listA to listB by drag and drop")
    public void iMoveTheCardFromListAToListBByDragAndDrop() {
        action=new Actions(driver);
        action.dragAndDrop(getElement(cardFromFirstList),getElement(secondListDropField)).build().perform();

    }

    @And("I get the coordinates of the card in listB")
    public void iGetTheCoordinatesOfTheCardInListB() {
        Rectangle rect = getElement(secondListCard).getRect();
        double xcoordinate=rect.getX();
        double yCoordinate=rect.getY();
        System.out.println("XCOORDINATE is "+xcoordinate);
        System.out.println("YCOORDINATE is "+yCoordinate);
    }
}
