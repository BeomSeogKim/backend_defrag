package abstractfactory.checkbox;

public class MacOSCheckBox implements CheckBox{
    @Override
    public void paint() {
        System.out.println("MacOSCheckBox.paint");
    }
}
