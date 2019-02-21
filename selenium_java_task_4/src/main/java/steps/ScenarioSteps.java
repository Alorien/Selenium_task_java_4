package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.ru.Когда;



public class ScenarioSteps {

    MainPageSteps mainPageSteps = new MainPageSteps();
    InsurationPageSteps insurationPageSteps = new InsurationPageSteps();
    MinInsurationPageSteps minInsurationPageSteps = new MinInsurationPageSteps();
    SendAppPageSteps sendAppPageSteps = new SendAppPageSteps();

    @When("^выбран пункт меню \"(.+)\"$")
    public void selectMenuItem(String menuName){
        mainPageSteps.selectMenuItem(menuName);
    }

    @When("^выбран вид страхования \"(.+)\"$")
    public void selectMenuInsurance(String menuName){
        mainPageSteps.selectInsuranceItem(menuName);
    }
    @Then("^заголовок страницы равен \"(.+)\"$")
    public void checkTitleDMSPage(String title){
        insurationPageSteps.checkTextPage(title);
        //insurationPageStepsPageSteps.checkTextPage("Страхование путешественнико");
    }
    @When("^нажата кнопка  \"(.+)\"$")
    public void clickBtnRegOnline(String menuName){
        insurationPageSteps.clickBtnRegOnline(menuName);
        //insurationPageSteps.clickBtnRegOnline("Оформить онлайн");
    }
    @When("^нажата выбрана страховака:\"(.+)\"$")
    public void selectMinIsuration(String menuName){
        minInsurationPageSteps.selectMinIsuration(menuName);
        //minInsurationPageSteps.selectMinIsuration("Минимальная");
    }
    @When("^нажата кнопка2:\"(.+)\"$")
    public void selectRegItem(String menuName){
        minInsurationPageSteps.selectRegItem(menuName);
        //minInsurationPageSteps.selectRegItem("Оформить");
    }
    @When("^заполняются поля:$")
    public void fillForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> sendAppPageSteps.fillField(field, value));

    }


    @Then("^значения полей равны:$")
    public void checkFillForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> sendAppPageSteps.checkFillField(field, value));
    }

    //sendAppPageSteps.fillFields(testData);
    //sendAppPageSteps.checkFillFields(testData);
    @When("^нажата кнопка3:\"(.+)\"$")
    public void btnSendApp(String fields) {
        sendAppPageSteps.btnSendApp(fields);
        //sendAppPageSteps.btnSendApp("Продолжить");
    }

    @Then("^сообщение на странице равно:\"(.+)\"$")
    public void checkFillForm(String fields) {
        sendAppPageSteps.checkErrorMessageField(fields);
        //sendAppPageSteps.checkErrorMessageField("Заполнены не все обязательные поля");
    }
}