package pages;

import org.json.simple.JSONArray;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.FakerValues;
import utils.WebUtils;

public class WebPage extends WebUtils{

    WebUtils webUtils;
    FakerValues faker;
    static String codTarefa;
    JSONArray json = new JSONArray();

    public WebPage(){

        this.webUtils = new WebUtils();
        this.faker = new FakerValues();
    }

    //xpath's

    String inputBox = "//input";
    String inserirTarefa = "//button[@type = 'submit']";
    String textoTarefa = "//span[text()= 'texto']";
    String checkboxTarefa = "//input[@type = 'checkbox']";
    String botaoDone = "//a[text() = 'DONE']";
    String lixeira = "//button[@type = 'button']";

    public void abrirSistema(String url){
        webUtils.getSite(url);
    }

    public void criarTarefa() {
        codTarefa = faker.getTarefa();
        webUtils.sendKeys(inputBox, codTarefa);
        webUtils.click(inserirTarefa);
    }

    public void criarMultiplasTarefas(){
        for (int i = 0; i<3; i++) {
            String codTarefa = faker.getTarefa();

            webUtils.sendKeys(inputBox, codTarefa);
            webUtils.click(inserirTarefa);
            json.add(i, codTarefa);
        }
    }

    public void excluirTarefa(){
        webUtils.waitTime(3000);
        webUtils.click(lixeira);
    }

    public void validarExclusaoTarefa(){
        webUtils.validateTextNotExist(lixeira);
    }

    public void validarCriacaoMultiplasTarefas(){
        webUtils.waitTime(3000);

        for (int i = 0; i<json.size(); i++){
            String tarefa = json.get(i).toString();
            webUtils.validateText(textoTarefa.replace("texto", " "+tarefa) ,tarefa);
        }
    }

    public void validarCriacaoTarefa(){
        webUtils.waitTime(5000);
        webUtils.validateText(textoTarefa.replace("texto", " "+codTarefa) ,codTarefa);
    }

    public void concluirTarefa(){
        webUtils.waitTime(3000);
        webUtils.click(checkboxTarefa);
    }

    public void validarTarefaDone(){
        webUtils.waitTime(3000);
        webUtils.click(botaoDone);
        webUtils.waitTime(2000);
        webUtils.validateText(textoTarefa.replace("texto", " "+codTarefa) ,codTarefa);
    }
}
