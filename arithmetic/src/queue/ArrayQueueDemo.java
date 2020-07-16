package queue;

/**
 * 使用数组 模拟 队列 编写一个 ArrayQueue类
 */
public class ArrayQueueDemo {

}

class ArrayQueue{
    private int maxSize; //表示数组的最大容量
    private int front; //队列头
    private int rear; //队列尾

    private int [] arr; //该数据用于存放数据 模拟队列

    //创建队列的构造器
    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; //指向队列头部 指向队列头的前一个位置
        rear = -1; //指向队列尾部 就是队列最后一个数据
    }

    //判断队列是否慢
    public boolean isPull(){
        return rear == maxSize -1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return front == rear;
    }

    //添加数据队列
    public void addQueue(int n){
        if(isPull()){
            System.out.println("队列空，不能加入数据");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    //获取队列的数据 出队列
    public int getQueue(){
        if(isEmpty()){
           throw new RuntimeException("队列空，不能取值");
        }
        front ++;
        return arr[front];
    }

    //显示队列所有数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列空，不能加入数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    //显示队列的头数据，注意不是取出数据
    public int headQueue(){
        if(isEmpty()){
            System.out.println("队列空的，没有数据~~");
            throw new RuntimeException("队列空，没有数据");
        }
        return arr[front + 1];
    }
}
