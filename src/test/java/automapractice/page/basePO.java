package automapractice.page;
/*
* Classe base para as novas pages objects;
* Todas as pages devem ser herdadas dessa classe */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class basePO {
    /* Driver base que sera utilizado pelas pages */
    protected WebDriver driver;

    /**
     * Construtor base para criação da fabrica de elementos(Page Factory)
     * @param driver - Driver da pagina atual
     */
    public basePO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    
}
