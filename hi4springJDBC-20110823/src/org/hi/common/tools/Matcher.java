package org.hi.common.tools;

public abstract interface Matcher
{
  public abstract boolean isPattern(String paramString);

  public abstract boolean match(String paramString, Object paramObject);
}

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.common.tools.Matcher
 * JD-Core Version:    0.6.0
 */