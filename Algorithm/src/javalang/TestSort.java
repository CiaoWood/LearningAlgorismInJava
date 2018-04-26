package javalang;

public class TestSort implements Testable {

    @Override
    public void test() {
        BubbleSort bs = new BubbleSort();
        bs.GetRunTime();
        InsertionSort is = new InsertionSort();
        is.GetRunTime();
        ShellSort ss = new ShellSort();
        ss.GetRunTime();
        MergeSort ms = new MergeSort();
        ms.GetRunTime();
        QuickSort qs = new QuickSort();
        qs.GetRunTime();
        //System.out.println("The " + this.getClass() + " takes " + time + "ms");
    }

}
