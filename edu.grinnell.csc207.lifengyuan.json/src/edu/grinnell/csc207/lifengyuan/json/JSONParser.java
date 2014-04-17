package edu.grinnell.csc207.lifengyuan.json;

import java.util.HashMap;

public class JSONParser
{
  
  // +--------+----------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * A boolean flag to check if the first character in the given string begins
   * with '{' or '['
   */
  static boolean checkFirst = false;

  
public Object parse(String str)
throws Exception
{
  boolean checkFirst = false;
  int ch - str.charAt (0);
  while(!checkFirst)
    {
      switch (ch)
      {
        case ' ':
        case '\n':
        case '\t':
        case '\r':
        case '\b':
        case '\f':
          // ignore whitespace chars
          break;
        case '{':
          // object
          return parseObject(str);
        case '[':
          // array
          return parseArray(str);
        case '"':
          // string
          return parseString(str);
        case 'f':
        case 'n':
        case 't':    
          return parseConstant(str);
     //JSONNumber
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
        case '-':
        case '+':
        case '.':
          // number
          return parseNumber(str);
        default:
          throw new Exception("Invalid input");
      } // switch(ch)
  } // if
}// parse(String str)

public static Object parseObject(String str)
    throws Exception
  {
    if (str.charAt(0) != '{')
      throw new Exception(
                              "Invalid input: JSONObject should begin with '{', given"
                                  + str.charAt(0));
    else if (str.charAt(1) == '}')
      return new JSONObject();
    else if (str.charAt(1) != '"')
      throw new Exception(
                              "Invalid input: The first item in JSONObject should be a string, given "
                                  + str.charAt(1));
    else
      {
       
        JSONObject obj = new JSONObject(); // create a new JSONObject
        int i = 1;
        
        while (i < str.length())
          {
            if (str.charAt(i) == '}') // hit the end of an JSONObject
              {
                obj.length = i;
                i++;
                return obj;
              } // if
            JSONValue key = parse(str.substring(i)); // get a JSONString as a
                                                     // key
            i += key.size();
            if (str.charAt(i) != ':')
              throw new Exception ("Invalid input: Expect ':', given"
                                      + str.charAt(i));
            else
              {
                i++; // ':'
                JSONValue val = parse(str.substring(i));
                // get a JSONValue as a val
                obj.add(key, val); // add a pair
                i += val.size(); // increment i by the size of val
                if (str.charAt(i) == ',') // JSONObject has more pairs
                  i++;
                else if (str.charAt(i) == '}') // hit the end of the JSONObject
                  {
                    obj.length = i + 1;
                    i++;
                    return obj;
                  }
                else
                  throw new Exception(
                                          "Invalid input: Expect ',' or '}', but given "
                                              + str.charAt(i));
              } // if
          } // while
        throw new Exception("Invalid input");
        // return object;
      } // if
  }//parseObject
    public static String parseString(String str)
        throws Exception
      {
        if (str.charAt(0) != '"')
          throw new Exception(
                                  "Invalid input: JSONString should begin with a double quote, given "
                                      + str.charAt(0));
        else
          {
            for (int i = 1; i < str.length(); i++)
              {
                if (str.charAt(i) == '"')
                  {
                    if (str.charAt(i + 1) != ',' && str.charAt(i + 1) != '}'
                        && str.charAt(i + 1) != ']' && str.charAt(i + 1) != ':')
                      throw new Exception("Invalid input");
                    return new String(str.substring(0, i + 1));
                  } // if
              } // for(i)
            throw new Exception(
                                    "Invalid input: JSONString should end with a double quotation mark");
          } // else
      } // parseString
    
    public static JSONArray parseArr(String str)
        throws JSONException
      {
        if (str.charAt(0) != '[')
          throw new Exception("Invalid input: JSONArray should begin with '['");
        else
          {
            JSONArray arr = new JSONArray(); // create a JSONAray

            for (int i = 1; i < str.length(); i++)
              {
                if (str.charAt(i) == ']')
                  {
                    arr.length = i + 1;
                    i++;
                    return arr;
                  } // hit the end of the array
                JSONValue val = parse(str.substring(i));

                arr.add(val); // add value to the array
                i = i + val.size() - 1; // increment i
                while (i + 1 < str.length())
                  {
                    if (str.charAt(i + 1) == ',')
                      {
                        i++;
                        JSONValue temp = parse(str.substring(i + 1));
                        arr.add(temp);
                        i += temp.size();
                      } // if str.charAt(i+1) is ','
                    if (str.charAt(i + 1) == ']')
                      {
                        arr.length = i + 2;
                        return arr;
                      } // if str.charAt(i+1) is ']'
                    // else
                  } // if i+1 < str.length()
              } // for(i)
          } // if
        throw new Exception("Invalid input");
      } // parseArr(String)
    
    public static JSONNumber parseNumber(String str)
        throws Exception
      {
        /**
         * A boolean flag to check if the period exists in the string
         */
        boolean period = false;
        /**
         * A boolean flag to check if the negative sign exists in the string
         */
        boolean negate = false;
        /**
         * A boolean flag to check if e exists in the string
         */
        boolean e = false;

        if (!Character.isDigit(str.charAt(0)) && str.charAt(0) != '-')
          {
            throw new Exception(
                                    "Invalid input: JSONReal should begin with a digit");
          } // if
        else
          {
            String temp = ""; // create a string
            int i = 0;
            while (i < str.length())
              {
                char num = str.charAt(i);
                switch (num)
                  {
                    case ',':
                    case '}':
                    case ']':
                      return new JSONNumber(temp);
                    case '-':
                      {
                        if (negate)
                          throw new Exception(
                                                  "Invalid input: expect a number, given"
                                                      + num);
                        else
                          {
                            temp += "-";
                            negate = true;
                            i++;
                          } // if
                        break;
                      } // case -
                    case 'e':
                      {
                        if (e)
                          throw new Exception(
                                                  "Invalid input: expect a number, given "
                                                      + num);
                        else
                          {
                            temp += "e";
                            e = true;
                            i++;
                          } // if
                        break;
                      } // case e
                    case '.':
                      {
                        if (period)
                          throw new Exception(
                                                  "Invalid input: expect a number, given "
                                                      + num);
                        else
                          {
                            temp += ".";
                            period = true;
                            i++;
                          } // if
                        break;
                      } // case .
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                      {
                        i++;
                        temp += Character.toString(num);
                        break;
                      } // case 0 1 2 3 4 5 6 7 8 9
                    default:
                      throw new Exception("Invalid input: not a valid number");
                  } // switch
              } // for
          } // else
        throw new Exception("Invalid input");
      } // parseNum(Str)

      /**
       * parse a string into JSONConstant
       * 
       * @param str
       *          A valid String
       * @return JSONConstant
       * @throws JSONException
       * 
       * @pre str is a valid string
       * @post A JSONConstant is given, or a JSONException is thrown
       */
      public static JSONConstant parseConstant(String str)
        throws Exception
      {
        char ch = str.charAt(0);
        if (ch != 'n' && ch != 'f' && ch != 't')
          throw new Exception(
                                  "Invalid input: JSONConstant expects null, true, or false.");
        else
          {
            switch (ch)
              {
                case 'n':
                  if (str.substring(0, 4).compareTo("null") != 0)
                    throw new Exception(
                                            "Invalid input: JSONConstant expects null, true, or false.");
                  else
                    return new JSONConstant("null");
                case 'f':
                  if (str.substring(0, 5).compareTo("false") != 0)
                    throw new Exception(
                                            "Invalid input: JSONConstant expects null, true, or false.");
                  else
                    return new JSONConstant("false");
                case 't':
                  if (str.substring(0, 4).compareTo("true") != 0)
                    throw new Exception(
                                            "Invalid input: JSONConstant expects null, true, or false.");
                  else
                    return new JSONConstant("true");
                default:
                  throw new Exception(
                                          "Invalid input: JSONConstant expects null, true, or false.");
              } // switch
          } // if
      } // parseConstant(String)

  } 


