package edu.grinnell.csc207.lifengyuan.json;

import java.math.BigDecimal;

/**
 * JSONNumber give as a number
 * 
 * @author Fengyuan Li
 * 
 */
public class JSONNumber
    implements
      JSONValue
{
  // +--------+----------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * Store the value of the number
   */
  BigDecimal value;
  
  /**
   * Store the length of the string of a number
   */
  int length = 0;

  // +--------------+-----------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * JSONNumber constructor
   * 
   * @param num
   */
  public JSONNumber (String num)
  {
    this.value = new BigDecimal (num);
    this.length = num.length ();
  } // JSONNumber(String)

  // +---------+----------------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * Given a JSON string return a JSONNumber object.
   * 
   * @param str
   * @return JSONNumber
   */
  @Override
  public String
    toJSONString ()
  {
    return this.value.toString ();
  } // toJSONString()

  /**
   * Get the size of the JSONReal
   */
  @Override
  public int size()
  {
    return length;
  } // size()

}//class JSONNumber
