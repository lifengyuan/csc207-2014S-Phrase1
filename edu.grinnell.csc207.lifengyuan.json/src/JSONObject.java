import java.util.Hashtable;
import java.util.List;
import java.util.Set;

public class JSONObject
{
  // +--------+----------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * A Hashtable to store objects
   */
  private Hashtable<String, Object> table;

  // +-------------+----------------------------------------------------------
  // | Constructor |
  // +-------------+
  /**
   * Construct a JSONObject
   */

  public JSONObject ()
  {
    this.table = new Hashtable<String, Object> ();
  }// JSONObject ()

  public JSONObject (Hashtable<String, Object> table)
  {
    this.table = table;
  }// JSONObject ()

  // +---------+----------------------------------------------------------
  // | Methods |
  // +---------+

  public Object
    get (String key)
  {
    return table.get (key);
  }// get (String)

  public Number
    getNumber (String key)
  {
    Object obj = get (key);
    if (obj instanceof Number)
      {
        return (Number) obj;
      }// if
    else
      {
        return null;
      }
  }// getNumber(String)

  public Object
    remove (String key)
  {
    return table.remove (key);
  }// remove (String)

  public String
    getString (String key)
  {
    Object obj = get (key);
    if (obj instanceof String)
      {
        return (String) obj;
      }// if
    else
      {
        return null;
      }
  }// getString (String)

  @SuppressWarnings("unchecked")
  public List<Object>
    getArray (String key)
  {
    Object obj = get (key);
    if (obj instanceof List)
      {
        return (List<Object>) obj;
      }
    else
      {
        return null;
      }
  }// getArray (String)

  @SuppressWarnings("unchecked")
  public JSONObject
    getJSONObject (String key)
  {
    Object obj = get (key);
    if (obj instanceof Hashtable)
      {
        return new JSONObject ((Hashtable<String, Object>) obj);
      }
    else
      {
        return null;
      }
  }// getJSONObject (String)

  public Set<String>
    getKeySet ()
  {
    return table.keySet ();
  }// getKeySet()

  /**
   * Convert a JSONObject into a string
   * 
   * @pre none
   * @post a String is given
   */
  @Override
  public String
    toString ()
  {
    JSONWriter writer = new JSONWriter ();
    return writer.write (this);
  }// toString()
}// class JSONObject
