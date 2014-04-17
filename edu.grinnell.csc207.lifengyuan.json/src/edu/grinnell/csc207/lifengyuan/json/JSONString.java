package edu.grinnell.csc207.lifengyuan.json;


/**
 * 
 * @author Fengyuan
 *
 */
public class JSONString
implements JSONValue
{
//+--------+----------------------------------------------------------
 // | Fields |
 // +--------+
 /**
  * content of the string
  */
String str;

/**
 * Store the length of the string
 */
int length = 0;

//+--------------+----------------------------------------------------
// | Constructors |
// +--------------+

/**
* JSONString constructor
* 
* @param str
*/
public JSONString(String str)
{
  this.str = str;
  this.length = str.length();
} // JSONSring(String)

// +---------+----------------------------------------------------------
// | Methods |
// +---------+

/**
 * Returns a Java string of JSONString
 */

public String toJSONString()
{
  return this.str;
} // toJSONString()

/**
 * Get the size of JSONString
 */
@Override
public int size()
{
  return this.length;
} // size()

}//class JSONString
