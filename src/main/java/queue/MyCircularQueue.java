package queue;

public class MyCircularQueue {
        private int[] data;
        private int head;
        private int size;
        private int capacity;
        /** Initialize your data structure here. Set the size of the queue to be k. */
        public MyCircularQueue(int k) {
            data = new int[k];
            capacity = k;
            head = 0;
        }
        
        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue(int value) {
            if(isFull()) {
                return false;
            }

            data[(head + size) % capacity] = value;
            size++;
            return true;
        }
        
        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue() {
            if(isEmpty()) {
                return false;
            }
            head = (head + 1) % capacity;
            size--;
            return true;
        }
        
        /** Get the front item from the queue. */
        public int Front() {
            if(isEmpty()) return -1;
            return data[head]; 
        }
        
        /** Get the last item from the queue. */
        public int Rear() {
            if(isEmpty()) return -1;
            return data[(head + size - 1) % capacity];
        }
        
        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            return size == 0;
        }
        
        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            return size == capacity;
        }
}
