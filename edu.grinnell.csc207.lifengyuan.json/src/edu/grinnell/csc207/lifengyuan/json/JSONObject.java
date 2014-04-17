package edu.grinnell.csc207.lifengyuan.json;

import java.util.HashMap;
import java.util.Set;


/**
 * 
 * @author Fengyuan
 *
 */
public class JSONObject
implements JSONValue
{
  // +--------+----------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * A Hashtable to store objects
   */
HashMap <JSONString, JSONValue> object;

/**
 * The size of this JSONObject
 */
int length = 0;


// +-------------+----------------------------------------------------------
// | Constructor |
// +-------------+
/**
 * Construct a JSONObject
 */

public JSONObject()
{
  this.object = object;
  this.length = length;
} // JSONObject()

//+-----------+----------------------------------------------------------
//|  Methods  |
//+-----------+


public void add(JSONValue key, JSONValue value)
{
  this.object.put ((JSONString) key, value);
  length += (key.size() + value.size() + 1); // ':'
} // add(String, JSONValue)


/**
 * Given a JSON string return a JSONObject object.
 * 
 */

@Override
public String toJSONString()
{
  StringBuilder strBuilder = new StringBuilder();
  strBuilder.append("{ ");      // initialize the string
  HashMap<JSONString, JSONValue> hash = this.object;
  Set<JSONString> keys = hash.keySet();  // get all keys from the HashTable
  for ( JSONString key : keys )
    {
      strBuilder.append(key.toJSONString());
      strBuilder.append(':');
      strBuilder.append(hash.get(key).toJSONString());
      strBuilder.append(' ');
    }
  strBuilder.append('}');
  return strBuilder.toString();
}//toJSONString()

/**
 * Get the size of the JSONObject
 *
 */
@Override
public int size()
{
  return length;
}//size

}//class JSONObject
