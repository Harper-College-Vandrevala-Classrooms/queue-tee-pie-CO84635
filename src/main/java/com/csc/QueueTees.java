package com.csc;

public class QueueTees {
  private Cutie[] items;
  int front, rear, size, capacity;

  QueueTees(int capacity) {
    this.capacity = capacity;
    this.items = new Cutie[capacity];
    this.front = 0;
    this.rear = -1;
    this.size = 0;
  }

  int size() {
    return size;
  }

  private boolean isEmpty() {
    return size == 0;
  }

  private boolean isFull() {
    return size == capacity;
  }

  void enqueue(Cutie cutie) {
    if (isFull()) {
      System.out.println("The Queue is full!");
      return;
    }
    rear++;
    items[rear] = cutie;
    size++;
    System.out.println("Enqueued the cutie with the description: \"" + cutie.description() + "\", with a rating of " + cutie.cutenessRating() + ".");
  }
  
  Cutie dequeue() {
    if (isEmpty()) {
      System.out.println("Queue is empty!");
      return null;
    } else {
      Cutie cutie = items[front];
      front++;
      size--;

      if (size == 0) {
        front = 0;
        rear = -1;
      }

      System.out.println("Dequeued the cutie with the description: \"" + cutie.description() + "\", with a rating of " + cutie.cutenessRating() + ".");
      return cutie;
    }
  }

  public static void main(String[] args) {
    Duckling duckling = new Duckling();
    Kitty kitty = new Kitty();
    Puppy puppy = new Puppy();
    Rabbit rabbit = new Rabbit();
    Raccoon raccoon = new Raccoon();
    Turtle turtle = new Turtle();

    QueueTees queue = new QueueTees(5);

    System.out.println("Size of the Queue before adding Cuties: " + queue.size());

    queue.enqueue(duckling);
    queue.enqueue(kitty);
    queue.enqueue(puppy);
    queue.enqueue(rabbit);
    queue.enqueue(raccoon);
    queue.enqueue(turtle); // Should print Queue is full!

    System.out.println("Size of the Queue after adding Cuties: " + queue.size());

    queue.dequeue(); // Duckling
    queue.dequeue(); // Kitty
    queue.dequeue(); // Puppy
    queue.dequeue(); // Rabbit
    queue.dequeue(); // Racoon
    queue.dequeue(); // Should print Queue is empty!

    queue.dequeue(); // Should say that the Queue is empty!
  }
}
