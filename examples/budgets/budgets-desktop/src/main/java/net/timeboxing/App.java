package net.timeboxing;

import io.qt.widgets.QApplication;
import io.qt.widgets.QMainWindow;
import io.qt.widgets.QMenu;
import io.qt.widgets.QMenuBar;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        QApplication.initialize(args);

        QMainWindow mw = new QMainWindow();
        mw.setWindowTitle("Test");
        mw.setMinimumWidth(150);
        mw.setMinimumHeight(150);
        mw.setVisible(true);

        QMenuBar menu = new QMenuBar();
        QMenu file = new QMenu();
        file.setTitle("Testing");
        menu.addMenu(file);

        mw.setMenuBar(menu);
        QApplication.exec();
    }
}
