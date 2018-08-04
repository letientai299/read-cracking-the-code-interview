package stack_queue;

import utils.Node;
import utils.Stack;

/**
 * Classic tower of Hanoi
 */
public class TowerOfHanoi {
  /*
   * Some notes;
   * - It takes 1 move for 1 places to go from 1 rod to any other rod.
   * - Assume that we have a maximum efficient way to move n plates from rod 1 to either rod 2 or 3,
   * and now we have to deal with n+1 plate. We will first have to move n plates to rod 2, and then
   * move last plate (the n+1) to rod 3, then move n plates from rod 2 to rod 3. Let's say our max
   * efficient way need f(n) steps. The next maximum efficient way need:
   *
   *    f(n+1) = 2 * f(n) + 1
   *
   * Let's check it:
   *
   * f(1) = 1
   * f(2) = 3
   * f(3) = 7
   *
   * In general, we will need
   *
   * f(n) = 2 * f(n-1) + 1
   *      = 2 * (2 * f(n-2) + 1) + 1
   *      = 2^2 * f(n-2) + 2^1 + 2^0
   *      = ...
   *      = 2^(n-1) * f(1) + 2^(n-2) + 2^(n-3) + ... + 1
   *      = 2^n - 1
   */

  private Stack rod1 = new Stack();
  private Stack rod2 = new Stack();
  private Stack rod3 = new Stack();

  public TowerOfHanoi(int n) {
    this.init(n);
  }

  /**
   * Init the game with n plates
   */
  void init(int n) {
    reset();
    for (int i = n; i > 0; i--) {
      rod1.push(i);
    }
  }

  private void reset() {
    rod1 = new Stack();
    rod2 = new Stack();
    rod3 = new Stack();
  }

  /**
   * Text based visualize the status of 3 rods.
   */
  void status() {
    System.out.println("----------------");
    System.out.println("Rod 1: " + rod1.toString());
    System.out.println("Rod 2: " + rod2.toString());
    System.out.println("Rod 3: " + rod3.toString());
  }

  /**
   * Move plates from rod 1 to rod 3, following the rules.
   */
  void solve() {
    move(rod1.size(), rod1, rod3, rod2);
  }

  private void move(int nPlates, Stack from, Stack to, Stack middle) {
    // If the number of plate to be moved is just 1, just move it.
    if (nPlates == 1) {
      final Node plate = from.pop();
      to.push(plate.data);
      status();
      return;
    }

    // otherwise, we need some middle step.
    move(nPlates - 1, from, middle, to);
    move(1, from, to, middle);
    move(nPlates - 1, middle, to, from);
  }

  public static void main(String[] args) {
    final TowerOfHanoi towerOfHanoi = new TowerOfHanoi(5);
    towerOfHanoi.status();
    towerOfHanoi.solve();
  }
}

