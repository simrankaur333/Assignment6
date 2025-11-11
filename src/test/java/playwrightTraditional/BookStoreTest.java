package playwrightTraditional;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.nio.file.Paths;
import java.util.*;

public class BookStoreTest {

    @Test
    void testBookstoreFlow() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(true));
            BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                    .setRecordVideoDir(Paths.get("videos/"))
                    .setRecordVideoSize(1280, 720));
            Page page = context.newPage();
            page.navigate("https://depaul.bncollege.com/");
            page.getByPlaceholder("Enter your search details (").click();
            page.getByPlaceholder("Enter your search details (").fill("earbuds");
            page.getByPlaceholder("Enter your search details (").press("Enter");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("brand")).click();
            page.locator("#facet-brand").getByRole(AriaRole.LIST).locator("label").filter(new Locator.FilterOptions().setHasText("brand JBL (12)")).getByRole(AriaRole.IMG).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Color")).click();
            page.locator("label").filter(new Locator.FilterOptions().setHasText("Color Black (9)")).locator("svg").first().click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Price")).click();
            page.locator("#facet-price svg").nth(2).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("JBL Quantum True Wireless")).click();
            page.getByLabel("Add to cart").click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Cart 1 items")).click();
            page.getByLabel("Enter Promo Code").click();
            page.getByLabel("Enter Promo Code").fill("TEST");
            page.getByLabel("Apply Promo Code").click();
            page.getByLabel("Proceed To Checkout").first().click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Proceed As Guest")).click();
            page.getByPlaceholder("Please enter your first name").click();
            page.getByPlaceholder("Please enter your first name").fill("Hello");
            page.getByPlaceholder("Please enter your last name").click();
            page.getByPlaceholder("Please enter your last name").fill("DJ");
            page.getByPlaceholder("Please enter a valid email").click();
            page.getByPlaceholder("Please enter a valid email").fill("test@gmail.com");
            page.getByPlaceholder("Please enter a valid phone").click();
            page.getByPlaceholder("Please enter a valid phone").fill("0000000000");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Back to cart")).click();
            page.getByLabel("Remove product JBL Quantum").click();
        }
    }
}
