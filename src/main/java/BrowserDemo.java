import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.time.Duration;

public class BrowserDemo {

        public static void main (String[] args) {
            WebDriver driver = new ChromeDriver();
            try {
                // 1. Ожидание ДО открытия страницы
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                //открываем сайт
                driver.get("https://demoqa.com/text-box");

                //ищем все подписи полей формы
                List<WebElement> labels = driver.findElements(By.cssSelector("label"));
                System.out.println("Найдено подписей: " + labels.size());
                for (WebElement label : labels) {
                    System.out.println("- " + label.getText());
                }
                System.out.println("Title: " + driver.getTitle()); //вывод заголовка в консоль

                //находим фул нэйм и вводим текст
                WebElement fullName = driver.findElement(By.id("userName")); //ищем по id элемент фуллнэйм
                fullName.sendKeys("Anna"); // воодим имя

                //ищем поле ввода имэйла
                WebElement email = driver.findElement(By.id("userEmail"));
                email.sendKeys("anna@example.com");

                //находим кноппку ввода и кликаем
                WebElement submit = driver.findElement(By.id("submit"));

                // Скроллим к кнопке
                // 4. Кликаем через JS (обходим перекрытие footer)
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", submit);

                //jкно вывода
                WebElement output = driver.findElement(By.id("output"));
                System.out.println("Output: " + output.getText());

            }
            finally {
                driver.quit(); // закрытие браузкра в конце
            }


        }
    }


