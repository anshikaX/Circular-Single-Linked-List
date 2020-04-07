
import java.util.Scanner;
public class CSLL
{
    static Node head=null;
    static Node tail=null;
    static Scanner sc = new Scanner(System.in);

    //Creating a linked list
    public void createCircularSingleLinkedList()
    {
        System.out.println("Enter the number of nodes");
        int n=sc.nextInt();

        Node temp;
        for(int i=0;i<n;i++)
        {
            temp = new Node();
            System.out.println("Enter the value in a node");
            int value = sc.nextInt();
            temp.data = value;

            if (head == null)  //Only one node exists
            {
                head = temp;
                tail = temp;
                tail.next = head;
            } else              //There is more than one node in the linked list
            {
                tail.next = temp;
                tail = temp;
                tail.next = head;
            }
        }

    }

    //Traversal of Circular Linked List
    public void display()
    {
        System.out.println("\n\n Printing the values of circular linked list");
        Node currentNode = head;
        while(currentNode!=null )
        {
            System.out.println(currentNode.data + " ");
            if(currentNode.next==head)
            {
                break;
            }
            currentNode=currentNode.next;
        }
    }

    //Insertion of a node at start, specific and end position
    public void insertNode()
    {
        Node temp = new Node();
        System.out.println("\n1.Insert in the beginning \n2.Insert at the specified position \n3.Insert at the end of the list");
        int choice = sc.nextInt();

        switch(choice)
        {
            case 1:
                System.out.println("Enter the value in a node");
                int value1 = sc.nextInt();
                temp.data = value1;
                if (head == null)  //There was no node and inserting the first node.
                {
                    head = temp;
                    tail = temp;
                    temp.next = temp;  // or tail.next=head
                }
                else              //It already has some node or atleast 1 node.
                {
                    temp.next=head;
                    head = temp;
                    tail.next = temp;  //or tail.next= head
                }
                break;

            case 2:
                System.out.println("Enter the value in a node");
                int value2 = sc.nextInt();
                temp.data = value2;
                System.out.println("Enter the position where you want to create a node");
                int position = sc.nextInt();

                if(position==1)
                {
                    temp.next = head;
                    head = temp;

                }
                else
                {
                    Node currentNode = head;
                    int counter = 1;
                    while (currentNode != null)
                    {
                        if (counter == position - 1)
                        {
                            break;
                        }
                        currentNode = currentNode.next;
                        counter = counter + 1;

                        if(currentNode==head)
                        {
                            break;
                        }

                    }
                    if (currentNode!=head)
                    {
                        temp.next = currentNode.next;         //Temp node gets the address of it's next node
                        currentNode.next = temp;             //Current Node gets the address of temp node to make a link
                        if(currentNode == tail)
                        {
                           tail=temp;
                        }
                    }
                    else if(position==2)
                    {
                        temp.next = currentNode.next;
                        currentNode.next = temp;
                    }
                    else
                    {
                        System.out.println("Invalid position!!");
                    }
                    break;
                }

            case 3:
                System.out.println("Enter the value in a node");
                int value3 = sc.nextInt();
                temp.data=value3;
                if(head==null)
                {
                    head=temp;
                    tail=temp;
                    tail.next=head;
                }
                else
                {
                    tail.next=temp;
                    tail=temp;
                    tail.next=head;
                }
                break;

            default:
                System.out.println("Invalid choice!!  \n\n Please select a suitable choice ");
                insertNode();

        }

    }

    //Searching for a given value in a node
    public void search()
    {
        System.out.println("Enter the value that you want to search");
        int value=sc.nextInt();
        Node currentNode = head;
        int counter=1;
        while(currentNode!=null)
        {
            if (currentNode.data == value)
            {
                System.out.println("Value found!!");
                System.out.println("Value is: " + currentNode.data + " and it's position is: " + counter);
                break;

            }
            counter++;
            currentNode = currentNode.next;
            if (currentNode == head)
            {
                break;
            }
        }
        if(currentNode==head)
        {
            System.out.println("Value doesn't exist in the linked list");
        }


    }

    //Deleting of node from SingleLinkedList which has a given value
    public void delete()
    {
        System.out.println("\n1. Delete the node from the beginning of the list. \n2.Delete the node at the specific position. \n3.Delete the node from the end of the list.");
        int choice = sc.nextInt();

        switch(choice)
        {
            case 1:
                if(head==null)
                {
                    System.out.println("There is no node.Linked list doesn't exist!");
                }
                else if(head==tail)   //There is just one node who's reference is with head and tail.To destroy the link,update head and tail with null
                {
                    head.next=null;
                    head=null;
                    tail=null;
                }
                else                //More than one node's case
                {
                    head = head.next;
                    tail.next=head;
                }
                break;

            case 2:
                System.out.println("Enter the position of the node that you want to delete");
                int pos=sc.nextInt();
                if(head==null)
                {
                    System.out.println("Linked list doesn't exist!!!");
                }
                else if(head!=tail && pos==1)
                {
                    head=head.next;
                    tail.next=head;
                }
                else if(head==tail && pos==1)
                {
                    tail.next=null;
                    head=null;
                    tail=null;
                }
                else
                {
                    Node currentNode=head;
                    int counter=1;
                    while(currentNode!=null)
                    {
                        if(counter==pos-1)
                        {
                            break;
                        }
                        currentNode=currentNode.next;
                        counter++;
                        if(currentNode==head)
                        {
                            break;
                        }
                    }
                    if(currentNode.next!=head)
                    {
                        currentNode.next=currentNode.next.next;
                        if(currentNode.next==tail)                //last position
                        {
                            tail=currentNode;
                            tail.next=head;
                        }
                    }
                    else
                    {
                        System.out.println(" Invalid position");
                    }
                }
                break;

            case 3:
                if(head==null)
                {
                    System.out.println("Linked list doesn't exist.");
                }
                else if(head==tail)   //If there is just one node that is the last node.
                {
                    tail.next=null;
                    head=null;
                    tail=null;

                }
                else                 //If there are more than one node
                {
                    Node currentNode = head;
                    while (currentNode.next != tail)           //It will take to the second last node
                    {
                        currentNode = currentNode.next;

                    }
                    currentNode.next = null;
                    currentNode.next= head;
                    tail = currentNode;
                }
                break;

            default:
                System.out.println("Invalid Choice!!  \n\n Please select suitable option");
                delete();

        }

    }

    //Deleting entire  Linked list
    public void deleteCSLL()
    {
        head=null;
        tail.next=null;
        tail=null;
        System.out.println("Linked list deleted successfully");
    }


}