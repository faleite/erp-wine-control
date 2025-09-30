package graphic;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {

    private JDesktopPane desktopPane;

    public MainMenu() {
        setTitle("Wine control system");
        setSize(1000, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        this.desktopPane = new JDesktopPane();
        setContentPane(desktopPane);

        JMenuBar menuBar = new JMenuBar();

        JMenu menuSystem = new JMenu("System");
            JMenuItem itemUser = new JMenuItem("User");
        menuSystem.add(itemUser);

        JMenu menuRegister = new JMenu("Register");
            JMenuItem itemCountries = new JMenuItem("Countries");
            JMenuItem itemRegions = new JMenuItem("Regions");
            JMenuItem itemWineries = new JMenuItem("Wineries");
            JMenuItem itemGrapes = new JMenuItem("Grapes");
        menuRegister.add(itemCountries);
        menuRegister.add(itemRegions);
        menuRegister.add(itemWineries);
        menuRegister.add(itemGrapes);

        JMenu menuReport = new JMenu("Report");
            JMenuItem itemSalesReport = new JMenuItem("Sales Report");
        menuReport.add(itemSalesReport);

        menuBar.add(menuSystem);
        menuBar.add(menuRegister);
        menuBar.add(menuReport);

        setJMenuBar(menuBar);

    }
}
