import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class WeddingComplex {

    public static Map<String, String> createBestCouple(
            Map<String, List<String>> first,
            Map<String, List<String>> second) {

        Map<String, String> result = new HashMap<>();
        Map<String, String> engagedTo = new HashMap<>();
        Map<String, Integer> nextProposalIndex = new HashMap<>();

        Queue<String> freeMembers = new LinkedList<>(first.keySet());

        for (String member : first.keySet()) {
            nextProposalIndex.put(member, 0);
        }

        while (!freeMembers.isEmpty()) {
            String member = freeMembers.poll();

            List<String> preferences = first.get(member);
            int index = nextProposalIndex.get(member);
            String candidate = preferences.get(index);

            nextProposalIndex.put(member, index + 1);

            if (!engagedTo.containsKey(candidate)) {
                engagedTo.put(candidate, member);
                result.put(member, candidate);
            } else {
                String currentPartner = engagedTo.get(candidate);

                List<String> candidatePreferences = second.get(candidate);

                if (candidatePreferences.indexOf(member) < candidatePreferences.indexOf(currentPartner)) {
                    engagedTo.put(candidate, member);

                    result.remove(currentPartner);
                    result.put(member, candidate);

                    freeMembers.add(currentPartner);
                } else {
                    freeMembers.add(member);
                }
            }
        }

        return result;
    }
}