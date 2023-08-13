@TrelloAutomation
Feature: This feature files contains scenarios about card movement between lists

  @TrelloAutomation
  Scenario:User moves the card between two lists successfully and then logsout
    Given I navigate to the URL "https://trello.com/"
    Then I click on login button
    Given I enter username "testingtrello779@gmail.com" and password "trellopassword1" and click on login button
    Then I create board with the name "TrelloBoard"
    And I create two list with the name "ListA" and "ListB"
    And I add card to the ListA with the name "CardA"
    And I move the card from listA to listB by drag and drop
    And I get the coordinates of the card in listB
    Then I logout from the application
