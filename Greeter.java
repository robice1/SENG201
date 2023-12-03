public class Greeter
{
  private String universalGreeting = "Hello world";
  private String greetingText = universalGreeting;

  public void greet()
  {
    System.out.println(greetingText);
  }

  public void setGreeting(String theGreeting)
  {
    greetingText = theGreeting;
  }

  public static void main(String[] argv)
  {
    Greeter g1 = new Greeter();
    g1.greet();
    g1.setGreeting("Hello Cunts");
    g1.greet();
  }
}
