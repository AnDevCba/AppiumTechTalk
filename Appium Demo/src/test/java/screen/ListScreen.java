package screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobilePlatform;

/**
 * @author Francisco Visintini.
 */
public class ListScreen extends Screen {

    public static final String LIST_ITEMS = "new UiScrollable(" +
            ".resourceIdMatches(\".*:id/recycler\").scrollable(true))" +
            ".scrollIntoView(.description(\"List Item %1$d\")" +
            ".childSelector(.resourceIdMatches(\".*:id/%2$s\")))";

    public ListScreen(AppiumDriver driver) {
        super(driver);
    }


    public MobileElement getTitleElement(int index) {
        if (platform.equals(MobilePlatform.ANDROID)) {
            return (MobileElement) driver.findElement(
                    MobileBy.AndroidUIAutomator(String.format(LIST_ITEMS, index, "title")));
        } else {
            return (MobileElement) driver.findElementsById("titleCell").get(index);
        }
    }

    public MobileElement getDescriptionElement(int index) {
        if (platform.equals(MobilePlatform.ANDROID)) {
            return (MobileElement) driver.findElement(
                    MobileBy.AndroidUIAutomator(String.format(LIST_ITEMS, index, "description")));
        } else {
            return (MobileElement) driver.findElementsById("descriptionCell").get(index);
        }
    }
}
