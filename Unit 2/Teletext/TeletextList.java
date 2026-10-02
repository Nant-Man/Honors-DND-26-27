import java.awt.Graphics;

/**
 * Implements the list of messages for teletext
 */
public class TeletextList
{
  private ListNode2 heading, topNode;

  /**
   * Creates a circular list of headlines.
   * First creates a circular list with one node, "Today's headlines:".
   * Saves a reference to that node in heading.
   * Adds a node holding an empty string before heading
   * and another node holding an empty string after heading.
   * Appends all the strings from headlines to the list, after
   * the blank line that follows heading,
   * preserving their order.  Sets topNode equal to heading.
   */
  public TeletextList(String[] headlines)
  {
    heading = new ListNode2("Today's headlines:");
    heading.setNext(heading);
    heading.setPrevious(heading);

    // what if I changed this to use addAfter stuff?

    addAfter(heading, "");
    addBefore(heading, "");
    for (String headline : headlines) {
      addBefore(heading.getPrevious(), headline);
    }

    // heading.setNext(new ListNode2(""));
    // heading.getNext().setPrevious(heading);
    // heading.setPrevious(new ListNode2(""));
    // heading.getPrevious().setNext(heading);

    // ListNode2 nodeToAddTo = heading.getNext();
    // for (String headline : headlines) {
    //   ListNode2 newNode = new ListNode2(headline);
    //   nodeToAddTo.setNext(newNode);
    //   newNode.setPrevious(nodeToAddTo);
    //   nodeToAddTo = newNode;
    // }
    // nodeToAddTo.setNext(heading.getPrevious());
    // heading.setPrevious(nodeToAddTo);

    topNode = heading;
  }

  /**
   * Inserts a node with msg into the headlines list after the blank
   * line that follows heading.
   */
  public void insert(String msg)
  {
    ListNode2 newNode = new ListNode2(msg, heading.getNext(), heading.getNext().getNext());
    newNode.getNext().setPrevious(newNode);
    newNode.getPrevious().setNext(newNode);
  }

  /**
   * Deletes the node that follows topNode from the headlines list,
   * unless that node happens to be heading or the node before or after
   * heading that holds a blank line.
   */
  public void delete()
  {
    ListNode2 followingNode = topNode.getNext();
    if (followingNode.equals(heading)) {
      return;
    }
    if (followingNode.equals(heading.getNext()) || followingNode.equals(heading.getPrevious())) {
      return;
    }
    followingNode.getPrevious().setNext(followingNode.getNext());
    followingNode.getNext().setPrevious(followingNode.getPrevious());
  }

  /**
   * Scrolls up the headlines list, advancing topNode to the next node.
   */
  public void scrollUp()
  {
    topNode = topNode.getNext();
  }

  /**
   * Adds a new node with msg to the headlines list before a given node.
   * Returns a reference to the added node.
   */
  private ListNode2 addBefore(ListNode2 node, String msg)
  {
    ListNode2 newNode = new ListNode2(msg, node.getPrevious(), node);
    newNode.getNext().setPrevious(newNode);
    newNode.getPrevious().setNext(newNode);
    return newNode;
  }

  /**
   * Adds a new node with msg to the headlines list after a given node.
   * Returns a reference to the added node.
   */
  private ListNode2 addAfter(ListNode2 node, String msg)
  {
    ListNode2 newNode = new ListNode2(msg, node, node.getNext());
    newNode.getNext().setPrevious(newNode);
    newNode.getPrevious().setNext(newNode);
    return newNode;
  }

  /**
   * Removes a given node from the list.
   */
  private void remove(ListNode2 node)
  {
    node.getNext().setPrevious(node.getPrevious());
    node.getPrevious().setNext(node.getNext());
  }

  /**
   * Draws nLines headlines in g, starting with topNode at x, y
   * and incrementing y by lineHeight after each headline.
   */
  public void draw(Graphics g, int x, int y, int lineHeight, int nLines)
  {
    ListNode2 node = topNode;
    for (int k = 1; k <= nLines; k++)
    {
      g.drawString((String)node.getValue(), x, y);
      y += lineHeight;
      node = node.getNext();
    }
  }
}
