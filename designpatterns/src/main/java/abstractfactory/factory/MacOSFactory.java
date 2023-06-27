package abstractfactory.factory;

import abstractfactory.button.Button;
import abstractfactory.button.MacOSButton;
import abstractfactory.checkbox.CheckBox;
import abstractfactory.checkbox.MacOSCheckBox;

public class MacOSFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacOSCheckBox();
    }
}
