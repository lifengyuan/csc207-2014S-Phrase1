package edu.grinnell.csc207.lifengyuan.json;

import java.util.ArrayList;
import java.util.Iterator;

public class JSONArray
    implements
      JSONValue
{
  // +--------+----------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * Store the values
   */
  ArrayList<JSONValue> elements;
  /**
   * store the size of this JSONArray
   */
  int length = 0;

  // +---------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * JSONArray Constructor
   * 
   * @param elements
   *          , an ArrayList of JSONValues
   */
  public JSONArray ()
  {
    this.elements = new ArrayList<JSONValue> ();
    length++;
  } // JSONArray()

  // +-----------+----------------------------------------
  // | Methods |
  // +-----------+
  
  /**
   * Add a value into JSONArray
  *
   */
  void add(JSONValue val)
  {
    this.elements.add(val);
    length += val.size();
  } // add(JSONValue)

  /**
   * Convert a JSONArray back into a string
   * 
   * @post A string is given
   */
  @Override
  public String
    toJSONString ()
  {
    StringBuilder strBuilder = new StringBuilder ();
    strBuilder.append ('[');
    Iterator<JSONValue> iterator = elements.iterator ();
    if (iterator.hasNext ())
      strBuilder.append (iterator.next ().toJSONString ());
    while (iterator.hasNext ())
      {
        strBuilder.append (",");
        strBuilder.append (iterator.next ().toJSONString ());
      }
    strBuilder.append (']');
    return strBuilder.toString ();
  } // toJSONString()

  @Override
  public int size()
  {
    return length;
  } // size()
  
}// class JSONArray
