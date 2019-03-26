/**
  Represent a list, implemented in a chain of nodes
 */

public class List_inChainOfNodes {
    private Node headReference;

    /**
      Construct an empty list
     */


    /**
      @return the number of elements in this list
     */
    public int size() {
      int length = 0;
      Node node = headReference;
      while (node != null) {
        length++;
        node = node.getReferenceToNextNode();
      }
      return length;
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

  	/**
      Set value at @index to @newValue
      @return old value at @index
      @precondition: @index is within the bounds of this linked list.
     */
    public Node set( int index, int newValue ) {
        Node saveForReturn = get( index);
      	int counter = index;
        Node node = headReference;
      	while (counter != 0) {
          	if (counter == index) {
          		node = new Node(newValue);
            }
        	node = node.getReferenceToNextNode();
          	counter--;
        }
        return saveForReturn;
    }

  	/**
      accessor
      @return element @index from this linked list
      precondition: @index is within the bounds of the linked list.
          (Having warned the user about this precondition,
           you should NOT complicate your code to check
           whether user violated the condition.)
     */
    public Node get( int index ) {
        // E-Z! pass through the request to the linked list object
        int counter = index;
      	Node node = headReference;
      	while (counter != 0) {
          	if (counter == index) {
          		return node;
            }
        	node = node.getReferenceToNextNode();
          	counter--;
        }
    }

  	public Node getReferenceToNextNode( int index ) {
        // E-Z! pass through the request to the linked list object
        int counter = index;
      	Node node = headReference;
      	while (counter != 0) {
          	if (counter == index) {
          		return node.getReferenceToNextNode();
            }
        	node = node.getReferenceToNextNode();
          	counter--;
        }
    }


  	/**
      Insert @value at position @index in this list.
      Shift the element currently at that position (if any)
      and any subsequent elements to the right
      (that is, increase the index associated with each).
     */
     public void add( int index, int value) {
       	if(index == 0) {
       		addAsHead(value);
        } else if (index > 0 && index < size()) {
        	Node node = new Node(value);
          	node.setReferenceToNextNode(getReferenceToNextNode(index - 1));
          	get(index - 1).setReferenceToNextNode(node);
        } else {
          	Node node = new Node(value);
        	get(size() - 1).setReferenceToNextNode(node);
        }
     }

  	/**
      Remove the element at position @index in this list.
      Shift any subsequent elements to the left (that is,
      decrease the index associated with each).
      @return the value that was removed from the list
     */
     public int remove( int index) {
        if(index == 0) {
       		headReference = get(1);
        } else if (index > 0 && index < size()) {
        	get(index - 1).setReferenceToNextNode(get(index + 1));
        } else {
          	get(size() - 1).setReferenceToNextNode(null);
        }
     }
}
