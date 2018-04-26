package javalang;/*
 * 输入：例如( 1 + 2 ) * 3 / 4 - ( 5 * 6 ) = 用空格隔开， = 号不可省略
 * 输出：计算结果
 * 原理：建两个栈，一个放操作符一个放操作数。将输入的数值和操作符分别存入这两个栈中，当有 ） 的时候 计算一下结果
 */


import java.util.Scanner;
import java.util.Stack;

public class Calculator implements Testable {
    //建两个栈，一个放操作符一个放操作数。
    private Stack<String> ops = new Stack<String>();
    private Stack<Double> val = new Stack<Double>();

    public Double inputStart() {
        //确保ops和val是空的。研究一下如何反复输入，2014-12-16 11:48:31遇到问题是第二次输入时，input.hasNext()直接返回true了
        ops.clear();
        val.clear();
        System.out.println("Please input:");
        Scanner input = new Scanner(System.in);
        String item = "";
        while (input.hasNext()) {
            item = input.next();
            //若是'=',退出读入
            if ("=".equals(item)) break;
            //若是'('，不做任何操作
            if ("(".equals(item)) ;
                //若是+-*/，则推入操作符栈
            else if ("+".equals(item) || "-".equals(item) || "*".equals(item) || "/".equals(item)) ops.push(item);
                //若是')'，我们知道需要做一次计算了
            else if (")".equals(item)) {
                PopCalPush();
            } else if (item.matches("-?[0-9]+.*[0-9]*")) {
                Double doubleVal = 0.0;
                //其他情况，我们认为这是一个数字，将它推入操作数栈
                try {
                    doubleVal = Double.parseDouble(item);
                } catch (Exception ex) {
                    System.out.println("input must be double value");
                    //关闭input防止内存泄露
                    input.close();
                    return null;
                }
                val.push(doubleVal);
            } else {
                //识别出来的符号
                System.out.println("We can't recognize your input!");
                input.close();
                return null;
            }
        }

        input.close();

        if (val.isEmpty()) {
            System.out.println("no val can be read");
            return null;
        } else if (ops.isEmpty()) {
            System.out.println("no ops can be read");
            return null;
        }

        //确保计算可以进行的条件是操作符栈的size比操作数栈的size小1
        if (val.size() - ops.size() != 1) {
            System.out.println(String.format("The number of ops shall be 1 less than the number of val. But the number of ops is %i, and the number of val is %i", ops.size(), val.size()));
            return null;
        }
        //只要操作数栈里的数量大于1，我们认为存在可以计算的条件
        while (val.size() > 1) {
            PopCalPush();
        }

        return val.pop();
    }

    public void PopCalPush() {
        if (ops == null || ops.isEmpty()) return;
        if (val == null || val.size() < 2) return; //操作数至少要2个

        String ops1 = ops.pop();
        Double val1 = val.pop();
        if (ops1.equals("+")) {
            //若上一个操作符是一级操作符（*或者/） 或者-，则先计算上一个
            if (!ops.isEmpty() && (GetOpsLevel(ops.peek()) == OpsLevel.FIRST || "-".equals(ops.peek()))) {
                PopCalPush();
                val.push(val1);
                ops.push("+");
            } else {
                //若上一个操作符不是一级的，则直接计算
                val.push(val.pop() + val1);
            }
        } else if (ops1.equals("-")) {
            //若上一个操作符是一级操作符（*或者/）  或者-，则先计算上一个
            if (!ops.isEmpty() && (GetOpsLevel(ops.peek()) == OpsLevel.FIRST || "-".equals(ops.peek()))) {
                PopCalPush();
                val.push(val1);
                ops.push("-");
            } else {
                //若上一个操作符不是一级的，则直接计算
                val.push(val.pop() - val1);
            }
        } else if (ops1.equals("*")) val.push(val.pop() * val1);
        else if (ops1.equals("/")) val.push(val.pop() / val1);
    }

    /**
     * 操作符等级函数，/*一级，+-二级
     *
     * @param ops
     * @return
     */
    private OpsLevel GetOpsLevel(String ops) {
        if ("+".equals(ops) || "-".equals(ops)) return OpsLevel.SECOND;
        else if ("*".equals(ops) || "/".equals(ops)) return OpsLevel.FIRST;
        else return OpsLevel.NON;
    }

    @Override
    public void test() {
        Double output = inputStart();
        if (output != null)
            System.out.println("Outout is: " + output);
    }

    //定义操作符等级的枚举
    public enum OpsLevel {
        NON,
        FIRST,
        SECOND
    }
}
