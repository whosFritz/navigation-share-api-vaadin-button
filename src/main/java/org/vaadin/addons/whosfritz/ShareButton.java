package org.vaadin.addons.whosfritz;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.ButtonVariant;

/**
 * A share button that uses the Web Share API to share the current page.
 * <p>
 *     The share button can be customized with a title, text, URL, and icon.
 *     The default values are:
 *     <ul>
 *         <li>Title: "Share this Page"</li>
 *         <li>Text: "Look at this page!"</li>
 *         <li>URL: "window.location.href"</li>
 *         <li>Icon: VaadinIcon.SHARE</li>
 *    </ul>
 *    The share button can be customized with the following methods:
 *    <ul>
 *        <li>setShareIcon(VaadinIcon icon): Sets the button icon</li>
 *        <li>setShareText(String text): Sets the share text</li>
 *        <li>setShareUrl(String url): Sets the share URL</li>
 *        <li>setShareTitle(String title): Sets the share title</li>
 *        <li>sharePage(): Executes the sharing using the Web Share API</li>
 *     </ul>
 *     The share button can be used in any Vaadin application to share the current page.
 * </p>
 * <p>
 *
 */
public class ShareButton extends Button {

    private String title;
    private String text;
    private String url;
    private VaadinIcon icon;

    /**
     * Creates a share button with customizable parameters.
     *
     * @param title the title of the shared content (default: document title)
     * @param text the text for sharing (default: empty)
     * @param url the URL to share (default: current page URL)
     * @param icon the icon for the button (default: VaadinIcon.SHARE)
     */
    public ShareButton(String title, String text, String url, VaadinIcon icon) {
        this.title = (title != null && !title.isEmpty()) ? title : "Share this Page"; // Default title
        this.text = (text != null && !text.isEmpty()) ? text : "Look at this page!"; // Default text
        this.url = (url != null && !url.isEmpty()) ? url : "window.location.href"; // Default-URL
        this.icon = (icon != null) ? icon : VaadinIcon.SHARE; // Default icon

        // Set the button icon and styling
        this.setIcon(this.icon.create());
    }

    // Overloaded constructor with default values
    public ShareButton() {
        this(null, null, null, null); // Defaults everything
    }

    /**
     * Executes the sharing using the Web Share API.
     */
    public void sharePage() {
        UI.getCurrent().getPage().executeJs(
                "const shareData = { " +
                        "  title: '" + title + "', " +
                        "  text: '" + text + "', " +
                        "  url: " + url + " " +
                        "}; " +
                        "navigator.share(shareData)" +
                        "  .then(() => {})" +
                        "  .catch(err => { console.log('Error: ' + err); });"
        );
    }

    /**
     * Sets the button icon.
     *
     * @param icon the icon to set
     */
    public void setShareIcon(VaadinIcon icon) {
        this.icon = icon;
        this.setIcon(icon.create());
    }

    /**
     * Gets the button icon.
     *
     * @return the button icon
     */
    public VaadinIcon getShareIcon() {
        return this.icon;
    }

    /**
     * Sets the share text.
     *
     * @param text the share text to set
     */
    public void setShareText(String text) {
        this.text = text;
    }

    /**
     * Gets the share text.
     *
     * @return share text
     */
    public String getShareText() {
        return this.text;
    }

    /**
     * Sets the share URL.
     *
     * @param url the share URL to set
     */
    public void setShareUrl(String url) {
        this.url = url;
    }

    /**
     * Gets the share URL.
     *
     * @return the share URL
     */
    public String getShareUrl() {
        return this.url;
    }

    /**
     * Sets the share title.
     *
     * @param title the share title to set
     */
    public void setShareTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the share title.
     *
     * @return the share title
     */
    public String getShareTitle() {
        return this.title;
    }

    /**
     * Gets the share button.
     *
     * @return the share button
     */
    public ShareButton getShareButton() {
        return this;
    }

}
