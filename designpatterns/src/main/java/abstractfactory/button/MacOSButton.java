package abstractfactory.button;

public class MacOSButton implements Button{
    @Override
    public void paint() {
        System.out.println("MacOSButton.paint");
    }
}
