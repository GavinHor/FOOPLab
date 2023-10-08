package lab1;

public class ListSpeedTest
{
    static long time_test(List list, int n)
    {
        System.out.println("List class: " + list.getClass());
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < n; i++)
        {
            list.append(n);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken to append " + n + " elements: " + (endTime - startTime) + "ms \n" );
        return endTime - startTime;
    }

    public static void main(String[] args)
    {
        List[] lists =
                {
                        new ArrayList(),
                        new LinkedList(),
                        new EfficientArrayList(),
                        new EfficientLinkedList(),
                };

        int increment = 10000;
        int multiplyTo = 10;
        for(int i = 1; i < multiplyTo + 1; i++)
        {
            int n = increment * i;
            for (List list : lists)
            {
                time_test(list, n);
            }
        }
    }
}
