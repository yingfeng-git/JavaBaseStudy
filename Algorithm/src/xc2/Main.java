package xc2;
import java.util.*;
import java.util.stream.Collectors;

class WorkflowNode {
    String nodeId;
    int timeoutMillis;
    List<WorkflowNode> nextNodes;
    boolean initialised;

    public static WorkflowNode load(String value) {
        // Create head node;
        Map<String, WorkflowNode> map = new HashMap<>();
        WorkflowNode head = new WorkflowNode("HEAD", 0, null);
        map.put(head.nodeId, head);

        for (String nodeValue : value.split("\\|")) {
            String[] properties = nodeValue.split("\\`");
            WorkflowNode node = map.get(properties[0]);

            node.timeoutMillis = Integer.parseInt(properties[1]);
            node.initialised = true;

            // Check next nodes
            if (properties[2].equals("END")) {
                continue;
            }
            node.nextNodes = Arrays.stream(properties[2].split(","))
                    .map(p -> new WorkflowNode(p, 0, null))
                    .collect(Collectors.toList());
            node.nextNodes.forEach(p -> map.put(p.nodeId, p));

            map.put(node.nodeId, node);
        }

        return head;
    }

    public WorkflowNode(String nodeId, int timeoutMillis, List<WorkflowNode> nextNodes) {
        this.nodeId = nodeId;
        this.timeoutMillis = timeoutMillis;
        this.nextNodes = nextNodes;
    }


}


//HEAD`0`A,B,C|A`10`END|B`20`END|C`30`END
//HEAD`0`A,B,C|A`10`END|B`20`END|C`30`D,E|D`20`END|E`31`END
//HEAD`0`A,B,C|A`10`END|B`20`G,F|G`22`END|F`23`END|C`30`D,E|D`20`END|E`31`END

public class Main {
    static int maxTime = 0;
    static int time = 0;

    public static int findMaxTime(WorkflowNode node){
        time += node.timeoutMillis;
        if (node.nextNodes != null) {
            for (WorkflowNode workflowNode : node.nextNodes) {
                findMaxTime(workflowNode);
            }
        }else{
            if (time > maxTime) maxTime = time;
        }
        time -= node.timeoutMillis;
        return maxTime;
    }

    public static void main(String args[]) {
//        Scanner cin = new Scanner(System.in);
        List<String> in = new LinkedList<>();
        in.add("HEAD`0`A,B,C|A`10`END|B`20`END|C`30`END");
        in.add("HEAD`0`A,B,C|A`10`END|B`20`END|C`30`D,E|D`20`END|E`31`END");
        in.add("HEAD`0`A,B,C|A`10`END|B`20`G,F|G`45`END|F`23`END|C`30`D,E|D`20`END|E`31`END");
        Iterator<String> cin = in.iterator();
        while (cin.hasNext()) {
            WorkflowNode node = WorkflowNode.load(cin.next());
            System.out.println(findMaxTime(node));
            maxTime = 0;
            time = 0;
        }
    }
}