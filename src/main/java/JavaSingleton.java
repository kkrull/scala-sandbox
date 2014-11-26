//new JavaSingleton() will fail from anywhere outside (unless you get sneaky)
public class JavaSingleton {
  private static final JavaSingleton INSTANCE = new JavaSingleton();

  private JavaSingleton() { }

  public static int abs(int x) {
    return Math.abs(x);
  }
}