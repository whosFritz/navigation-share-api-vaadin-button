package org.vaadin.addons.whosfritz;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.Route;

@Route("")
public class AddonView extends Div {

    public AddonView() {
        ShareButton shareButton = new ShareButton();
        shareButton.setShareTitle("Share this page");
        shareButton.setShareText("Look at this page!");
        shareButton.setShareUrl("window.location.href");
        shareButton.setShareIcon(VaadinIcon.SHARE);
        shareButton.addClickListener(event -> shareButton.sharePage());

        shareButton.setId("shareButton");
        add(shareButton);
    }
}
