package linked_list;

import java.util.HashSet;
import java.util.Set;
import utils.Node;

/**
 * 2.5 Given a circular linked list, implement an algorithm which returns node at the beginning of
 * the loop.
 */
public class FindCircularNode {

  // Solution using additional buffer
  // O(n) time and O(n) space at worse case
  // This is simple, but depend on the assumption that query from the set is O(1).
  static Node findCircularNode(Node head) {
    if (head == null) return null;

    Set<Node> visited = new HashSet<>();
    Node node = head;
    while (node != null && !visited.contains(node)) {
      visited.add(node);
      node = node.next;
    }

    // If the list is not loop, then this will also return null, as there's no node that satisfy
    // the expectation.
    return node;
  }

  // Solution inspired by the book
  // I can't discover it by myself, without first read about 'slow' and 'fast' runners.
  // But I also don't like to read all the guide. Below is how I think after first hint
  static Node findCircularNodeWithoutBuffer(Node head) {
    // Define f: fast runner, advance 2 steps as a time
    // Define s: slow runner, advance 1 step as a time
    //
    // - If f ('fast') and s ('slow') start as the beginning of the loop, they will meet at that point
    // after f has done 2 circles.
    //
    // - If when s enter the loop, f has already done k steps, they will meet at... (there's something
    // we need to analize here)
    //
    // Case 1:
    // 1 2 3 4 5 1 ... (k = 2, loop size = 5)
    // f: 3 5 2 4 1 3 5 2 _4_ ...
    // s: 1 2 3 4 5 1 2 3 _4_ ...
    //
    // Case 2:
    // 1 2 3 4 5 6 7 8 1 ...
    // f: 3 5 7 1 3 5 _7_
    // s: 1 2 3 4 5 6 _7_ 8 1 2 3 4 5 6 7 8 1 2 ...

    // Case 3:
    // 1 2 3 4 5 6 7 1 ...
    // f: 3 5 7 1 3 5 2 4 6 1 3 _5_ 7...
    // s: 1 2 3 4 5 6 7 1 2 3 4 _5_ 6 7 1 2 ...
    //
    // Let's say that at the time f meet s, s has done x = a*n + b steps.
    // Thus, f has done 2x= 2an + 2b steps from the position k
    // And at that time, x locates at position b.
    // Position of f is: 2anb + 2b + k = 2b + k
    // Because s meet f at that position, we have: b = 2b + k => b = b = - k = n - k (it's loop)
    //
    // Now, Let's say there's k nodes from the head to the first node in the loop, by the time s
    // enter the loop, s has done k steps, and f has done 2k steps (k steps since the head, and
    // another k steps since the loop start). They will meet at position n-k since the loop start.
    // And that's where the creative should kick in (I could never discover it by myself alone).
    // f should done another k steps to go back to the loop start, and s should be at the loop start
    // also, so that when they meet again, they meet at that point. Thus, we must buy k steps for f,
    // and we do it by take s back to the head, let both f and s run again. By the time s enter the
    // loop the second time, f be there also. They will meet, and no more looping, we can return
    // at that position.

    if (head == null) return null;

    Node fast = head;
    Node slow = head;

    do {
      fast = fast.next;
      if (fast == null) {
        return null;
      }
      fast = fast.next;
      slow = slow.next;
    } while (fast != null && fast != slow);

    // If there's no loop, then the while block will break when fast is null, which is also desired
    // result for such cases.
    if (fast == null) return null;

    // So, we are now guaranteed that there's a loop within the list.
    slow = head;
    while (fast != slow) {
      // My above analyze lead this below (commented) line of code, which can't guarantee exact result
      // fast = fast.next.next;
      // The correct code, after continue read the book.
      fast = fast.next; // We have this result as both f and s now k step aways to the loop start.
      slow = slow.next;

      // I've fallen into the trap of thinking too much.
    }
    System.out.println(slow.data);
    // 1 2 3 4 5 6 7 8 4
    // f: 1 3 5 7 _5_                  7 5 7 5
    // s: 1 2 3 4 _5_ (move back) 1   2 3 4 5

    return fast;
  }
}
