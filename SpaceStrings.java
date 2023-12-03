public class SpaceStrings{


  public int getStringLength(String str)
  {
    return str.length();
  }

  public int getLetterPosition(String str, char letter)
  {
    return str.indexOf(letter);
  }

  public String makeAllCaps(String str)
  {
    return str.toUpperCase();
  }

  public String makeAllLowers(String str)
  {
    return str.toLowerCase();
  }

  public String makeHugeString(String str1, String str2)
  {
    return str1.concat(str2);
  }
  public static void main(String[] args)
  {
    
  }
}
