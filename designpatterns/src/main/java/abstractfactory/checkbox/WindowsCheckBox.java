package abstractfactory.checkbox;

public class WindowsCheckBox implements CheckBox{
    @Override
    public void paint() {
        System.out.println("WindowsCheckBox.paint");
    }
}
