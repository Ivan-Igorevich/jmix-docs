package com.company.onboarding.view.dialogsandnotifications.notifications;

import com.company.onboarding.view.main.MainView;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;
import io.jmix.flowui.Notifications;
import io.jmix.flowui.view.StandardView;
import io.jmix.flowui.view.Subscribe;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "NotificationSampleView", layout = MainView.class)
@ViewController("NotificationSampleView")
@ViewDescriptor("notification-sample-view.xml")
public class NotificationSampleView extends StandardView {
    // tag::notification-1[]
    @Autowired
    private Notifications notifications;

    @Subscribe("helloButton")
    public void onHelloButtonClick(ClickEvent<Button> event) {
        notifications.show("Hello");
    }
    // end::notification-1[]

    private void showNotification() {
        // tag::notification-2[]
        notifications.create("Hello")
                .withType(Notifications.Type.WARNING)
                .withPosition(Notification.Position.BOTTOM_END)
                .withDuration(3000)
                .show();
        // end::notification-2[]
    }

    private void showNotificationHtml() {
        // tag::notification-html[]
        notifications.show(new Html("<div>Hello<br>World</div>"));
        // end::notification-html[]
    }

    private void showNotificationPre() {
        // tag::notification-pre[]
        notifications.create("First line\nSecond line")
                .withClassName(LumoUtility.Whitespace.PRE_LINE)
                .withDuration(5000)
                .show();
        // end::notification-pre[]
    }

}