package abstractfactory.factory;

import abstractfactory.button.Button;
import abstractfactory.button.WindowsButton;
import abstractfactory.checkbox.CheckBox;
import abstractfactory.checkbox.WindowsCheckBox;

public class WindowsFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckBox();
    }
}
