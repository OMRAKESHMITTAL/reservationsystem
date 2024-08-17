import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {

    public MainView() {
        Button loginButton = new Button("Login", e -> getUI().ifPresent(ui -> ui.navigate(LoginView.class)));
        Button reserveButton = new Button("Reserve Ticket", e -> getUI().ifPresent(ui -> ui.navigate(ReservationView.class)));
        Button cancelButton = new Button("Cancel Ticket", e -> getUI().ifPresent(ui -> ui.navigate(CancellationView.class)));
        Button exitButton = new Button("Exit", e -> getUI().ifPresent(ui -> ui.getSession().close()));

        add(loginButton, reserveButton, cancelButton, exitButton);
    }
}
