Problem 5: Design Patterns
==========================


a. Factory
----------
From Assignment4: 
Fractions with the same value may have different represatations, we need
to make all fractions reduced to their lowest terms.

different kind of way to sort use the same interface 

public class MergeSorter<T>
    extends
      SorterBridge<T>
      
public class Quicksorter<T>
    extends
      SorterBridge<T>

public class InsertionSorter<T>
    extends
      SorterBridge<T>

public class SelectionSorter<T>
    extends
      SorterBridge<T>

  - A class cannot anticipate which subclasses must be created
  - Separate a family of objects using shared interface
  - Hide concrete classes from the client

b. Singleton
------------
LinkedStack only contain the Node<T> top element. So top is a singleton.
  /**
   * Create a new stack.
   */
   // declare the unique instance of the class
  public LinkedStack()     
  {
    this.top = null;
  } // LinkedStack(int)


we use the Singleton pattern in the binary search trees lab. we  are used to implement common data structures such that create a root of tree. 
  - Ensure unique instance by defining class final
  - Access to the instance only via methods provided

c. Adapter
----------
1. Adapter from standard Java Priority Queue to Proirty queue: 
   * Original
     - capacity elements and compariator set does not support Priority Queue 
     - Using pattern
   * Adapter provides interface for using order to compare elements.
   * Add needed functionality in Adapter methods
   
     public interface PriorityQueue<T>
       extends LinearStructure<T>
    { 
      ...
    }
     public class BuiltinPriorityQueue<T>
      implements PriorityQueue<T>
    {
     ...
    }
     

d. Decorator
------------
 subclass of Anonymous Inner Classes
 
  - Provide flexible alternative to subclassing
  - Add new function to an object without affecting other objects
  - Make responsibilities easily added and removed dynamically & transparently to the 
    object
