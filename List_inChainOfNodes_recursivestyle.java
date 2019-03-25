/**
  Represent a list, implemented in a chain of nodes
 */

public class List_inChainOfNodes{
    private Node headReference;

    /**
      Construct an empty list
     */


    /**
      @return the number of elements in this list
     */
    public int size() {
      if (this.headReference == null) {
        return 0;
      } else {
        return 1 + this.getReferenceToNextNode().size();
      }
    }


     /**
       @return a string representation of this list,
       format:
           # elements [element0,element1,element2,]
      */
    public String toString() {
      String str = "[";
      Node node = headReference;
      while (node != null) {
        str += node.getCargoReference() + ",";
        node = node.getReferenceToNextNode();
      }
      return str + "]";
    }

    public String stringBuilder() {
      if (this.headReference == null) {
        return "";
      } else {
        return this.getReferenceToNextNode().stringBuilder();
      }
    }


    /**
      Append @value to the head of this list.
      @return true, in keeping with conventions yet to be discussed
     */
    public boolean addAsHead( Object val) {
       Node newHead = new Node(val);
       Node oldHead = this.headReference;
       newHead.setReferenceToNextNode(oldHead);
       this.headReference = newHead;
       return true;
    }
}
