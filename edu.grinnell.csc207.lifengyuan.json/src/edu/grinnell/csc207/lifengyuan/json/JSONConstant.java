package edu.grinnell.csc207.lifengyuan.json;

public class JSONConstant
    implements
      JSONValue
{
  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+

  String contents;
 
  int length;
  // +--------------+-------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Constructor of JSONConstant
   * 
   * 
   */
  public JSONConstant (String str)
  {
    this.contents = str;
    this.length = str.length();
  } // JSONConstant

  // +---------+----------------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * Given a JSONConstant return a JSON string .
   */

  @Override
  public String
    toJSONString ()
  {
    return this.contents;

  }// toJSONString

  /**
   * Get the size of a JSONConstant
   */
  @Override
  public int size()
  {
    return length;
  } // size()
}// class JSONConstant
